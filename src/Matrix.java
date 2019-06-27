public class Matrix {
    private double[][] values;
    private int dimX;
    private int dimY;
    
    public Matrix (int x, int y){
    	values = new double[y][x];
    	dimX = x;
    	dimY = y;
    }
    
    public double getValue(int x, int y){
        return values[y][x];
    }
    
    public void setValue(int x, int y, double value){
        values[y][x] = value;
    }

    public int getDimX() {
        return dimX;
    }

    public int getDimY() {
        return dimY;
    }

    public void gauss(){

    }
    public void jordan(){

    }

    /**
     * Normalizes every row in the matrix.
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

        for (int ySort = 0; ySort < dimY; ySort++) {
            int maxVal = 0;
            int maxIndex = 0;
            for (int y = ySort; y < dimY; y++) {
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
