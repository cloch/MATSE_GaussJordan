public class Matrix {
    private double[][] values;
    private int dimX;
    private int dimY;

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

    }
    private void print(){

    }
}
