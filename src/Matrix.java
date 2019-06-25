public class Matrix {
    private double[][] values;
    private int dimX;
    private int dimY;

    public void gauss(){

    }
    public void jordan(){

    }
    private void norm(){

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
