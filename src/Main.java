import java.util.ArrayList;

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
            m.gauss(true);
            m.jordan(true);
        }
    }
}
