public class Main {
    public static void main(String[] args) {
        Matrix m = new Matrix(4,3);
        m.setValue(1,0, 1.0);
        m.setValue(2,0, 1.0);
        m.setValue(3,0, 1.0);
        m.setValue(2,1, 1.0);
        m.setValue(3,1, 1.0);
        m.setValue(0,2, 1.0);
        m.print();
        m.sortRows();
        m.print();
    }
}
