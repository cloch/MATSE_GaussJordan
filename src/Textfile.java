import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Textfile.
 */
public class Textfile {
	private String filepath;
	/**
	 * The Matrices.
	 */
	public Matrix[] matrices;
	private File input;

	/**
	 * Instantiates a new Textfile.
	 *
	 * @param path the path
	 */
	public Textfile(String path) {
		try{
			this.filepath = path;
			input = new File(path);
			if(!input.exists()){
				throw new IOException("File not found.");
			}
		}
		catch(IOException IOe){
			IOe.printStackTrace();
		}

	}

	private ArrayList<String> ReadFile() throws IOException{
		ArrayList<String> list = new ArrayList<>();
		String current;
		BufferedReader reader = new BufferedReader(new FileReader(filepath));
		while ((current = reader.readLine()) != null) {
			if(IsValid(current)){
				list.add(current);
			}
		}
		reader.close();
		return list;
	}

	private ArrayList<Double> GetVariables(String s){
		ArrayList<Double> res = new ArrayList<>(); 
		Matcher m = Pattern.compile("[0-9]+(\\.[0-9]+)*").matcher(s);
		while (m.find()){
			res.add(Double.valueOf(m.group()));
		}
		return res;
	}

	private ArrayList<ArrayList<Double>> BuildMatLines(ArrayList<String> list){
		ArrayList<ArrayList<Double>> res = new ArrayList<>();
		for (String s : list) {
			res.add(GetVariables(s));
		}
		return res;
	}

	/**
	 * Generate matrix matrix.
	 *
	 * @param list the list
	 * @return the matrix
	 * @throws Exception the exception
	 */
	public Matrix GenerateMatrix(ArrayList<Double> list)  throws Exception{
		ArrayList<String> FContent = ReadFile();
		ArrayList<ArrayList<Double>> lines = BuildMatLines(FContent);
		Matrix m = new Matrix(lines.get(0).size(), lines.size());
		for (int i = 0; i < m.getDimY(); i++){
			for (int j = 0; j < m.getDimX(); j++){
				m.setValue(j, i, lines.get(i).get(j));
			}
		}
		return m;
	}

	private boolean CheckForEqualRows(ArrayList<ArrayList<Double>> list){
		if(list.isEmpty()){
			return true;
		}
		int i = list.get(0).size();
		for (int j = 1; j < list.size(); j++){
			if (list.get(j).size()!=i){
				return false;
			}
		}
		return true;
	}

	private boolean IsValid(String s){
		return Pattern.matches("([0-9]+(\\.[0-9]+)*( |\t)*){2,}", s);    	
	}
}
