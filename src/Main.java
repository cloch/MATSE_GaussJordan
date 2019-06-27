import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Textfile file = new Textfile("test.txt");
        ArrayList<Double> list = new ArrayList<>();
        Matrix m = null;
        try {
            m = file.GenerateMatrix(list);
        } catch (Exception ex) {
            System.out.println("Exception occured, a meaningful error message would be nice!");
        }
        if (m != null) {
            m.sortRows();
            m.print();
            m.norm();
            m.print();
            m.combine(0);
            m.print();
            m.norm();
            m.print();
            m.combine(1);
            m.print();
            m.norm();
            m.print();
        }
    }
}
