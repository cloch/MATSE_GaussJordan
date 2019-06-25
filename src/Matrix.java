public class Matrix {
    private double[][] values;
    private int dimX;
    private int dimY;
    
    public Matrix (int x, int y){
    	values = new double[x][y];
    }
    
    public double getValue(int x, int y){
    	return values[x][y];
    }
    
    public void setValue(int x, int y, double value){
    	values[x][y] = value;
    }

    public void gauss(){

    }
    public void jordan(){

    }
    private void norm(){
        /*
        for every row x find first value different from 0
        divide all values in the same row by this value
         */
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
    private void combine(){

    }
    private void sortRows(){
        int[] firstNonZero = new int[dimY];
        for (int y = 0; y < dimY; y++) {
            for (int x = 0; x < dimX; x++) {
                if (values[y][x] != 0) {
                    firstNonZero[y] = x;
                }
            }
        }

        for (int ySort = 0; ySort < dimY; ySort++) {
            double maxVal = 0.0;
            int maxIndex = 0;
            for (int y = ySort; y < dimY; y++) {
                if (firstNonZero[y] > maxVal) {
                    maxVal = firstNonZero[y][x];
                    maxIndex = y;
                }
            }

            int[] tempRow = values[ySort];
            values[ySort] = values[maxIndex];
            values[maxIndex] = tempRow;
        }
    }

    public void print(){
        for (int y = 0; y < dimY; y++) {
            for (int x = 0; x < dimX; x++) {
                System.out.print(values[y][x]+" ");
            }
            System.out.println();	
        }
    }
}
