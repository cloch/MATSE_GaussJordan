public class Main {
    public static void main(String[] args) {
        Matrix m = new Matrix(4,3);
        m.setValue(1,0, 5.0);
        m.setValue(2,0, 3.0);
        m.setValue(3,0, 7.0);
        m.setValue(2,1, 8.3);
        m.setValue(3,1, 13.0);
        m.setValue(0,2, 6.0);
        m.print();

        m.norm();
        m.print();
        m.sortRows();

        m.print();
    }
}
