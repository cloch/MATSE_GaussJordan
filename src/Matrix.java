/**
 * The type Matrix.
 */
public class Matrix {
    private double[][] values;
    private int dimX;
    private int dimY;

    /**
     * Instantiates a new Matrix.
     *
     * @param x the x
     * @param y the y
     */
    public Matrix (int x, int y){
    	values = new double[y][x];
    	dimX = x;
    	dimY = y;
    }

    /**
     * Get matrix element at given indices.
     *
     * @param x the x
     * @param y the y
     * @return the double
     */
    public double getValue(int x, int y){
        return values[y][x];
    }

    /**
     * Set matrix element at given indices.
     *
     * @param x     the x
     * @param y     the y
     * @param value the value
     */
    public void setValue(int x, int y, double value){
        values[y][x] = value;
    }

    /**
     * Gets dimX.
     *
     * @return the dim x
     */
    public int getDimX() {
        return dimX;
    }

    /**
     * Gets dimY.
     *
     * @return the dim y
     */
    public int getDimY() {
        return dimY;
    }

    /**
     * Gauss.
     */
    public void gauss(boolean debugmode){
        for (int i = 0; i < dimY-1; i++) {
            if (debugmode)
                System.out.println("Sort:");
            sortRows();
            if (debugmode)
                print();

            if (debugmode)
                System.out.println("Norm:");
            norm();
            if (debugmode)
                print();

            if (debugmode)
                System.out.println("Combine "+i+":");
            combine(i);
            if (debugmode)
                print();
        }
        if (debugmode)
            System.out.println("Norm:");
        norm();
        if (debugmode)
            print();
    }

    private void subtractRow(int firstRow, int secondRow, int targetRow) {
        for (int x = 0; x < dimX; x++) {
            values[targetRow][x] = values[firstRow][x] - values[secondRow][x];
        }
    }

    private void multiplyRow(int row, double value) {
        for (int x = 0; x < dimX; x++) {
            values[row][x] = value * values[row][x];
        }
    }

    /**
     * Jordan.
     */
    public void jordan(boolean debugmode){
        sortRows();
        for (int subtrahendRow = dimY-1; subtrahendRow > 0; subtrahendRow--) {
            for (int minuendRow = subtrahendRow-1; minuendRow >= 0; minuendRow--) {
                if (debugmode)
                    System.out.println("Jordan-Norm "+minuendRow+":");
                multiplyRow(minuendRow, 1.0/values[minuendRow][subtrahendRow]);
                if (debugmode)
                    print();

                if (debugmode)
                    System.out.println("Jordan-combine "+minuendRow+"-"+subtrahendRow+"=>"+minuendRow+":");
                subtractRow(minuendRow, subtrahendRow, minuendRow);
                if (debugmode)
                    print();
            }
            if (debugmode)
                System.out.println("Jordan-Norm as"+subtrahendRow+":");
            multiplyRow(subtrahendRow-1, 1.0/values[subtrahendRow-1][subtrahendRow-1]);
            if (debugmode)
                print();
        }
    }

    /**
     * Normalizes every row in the matrix by dividing each row
     * by the first non-zero value.
     */
    public void norm(){
        for (int y = 0; y < dimY; y++){
            int firstX = 0;
            while (Math.abs(values[y][firstX]) < 2 * Double.MIN_VALUE){ //value close to 0
                values[y][firstX] = 0;
                firstX++;
            }
            double divisor = values[y][firstX];
            values[y][firstX] = 1;
            for (int x = firstX + 1; x < dimX; x++){
                values[y][x] = values[y][x] / divisor;
            }
        }
    }

    /**
     * Combines all following rows with the given row.
     *
     * @param rowIndex The index of the row used to eliminate
     */
    public void combine(int rowIndex){
        for (int i = rowIndex + 1; i < dimY; i++) {
            for (int k = 0; k < dimX; k++) {
                values[i][k] = values[rowIndex][k] - values[i][k];
            }
        }
    }

    /**
     * Sorts matrix rows by number of preceding zeros.
     */
    public void sortRows(){
        int[] firstNonZero = new int[dimY];
        for (int y = 0; y < dimY; y++) {
            for (int x = 0; x < dimX; x++) {
                if (values[y][x] != 0) {
                    firstNonZero[y] = x;
                    break;
                }
            }
        }

        for (int ySort = dimY-1; ySort > 0; ySort--) {
            int maxVal = 0;
            int maxIndex = 0;
            for (int y = ySort; y >= 0; y--) {
                if (firstNonZero[y] > maxVal) {
                    maxVal = firstNonZero[y];
                    maxIndex = y;
                }
            }

            if (maxVal != 0) {
                double[] tempRow = values[ySort];
                values[ySort] = values[maxIndex];
                values[maxIndex] = tempRow;
                int temp = firstNonZero[ySort];
                firstNonZero[ySort] = firstNonZero[maxIndex];
                firstNonZero[maxIndex] = temp;
            }
        }
    }

    /**
     * Prints matrix to console.
     */
    public void print(){
        for (int y = 0; y < dimY; y++) {
            for (int x = 0; x < dimX; x++) {
                System.out.print(values[y][x]+" ");
            }
            System.out.println();	
        }
        System.out.println();
    }
}
