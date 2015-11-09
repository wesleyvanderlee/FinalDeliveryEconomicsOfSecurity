package eco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class continentReader {
	
	public static HashMap<String,String> getCountryHashMap() {
		try {
			return read();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static HashMap<String,String> read() throws Exception {
		HashMap<String,String> hm = new HashMap<String,String>();
		String file = "C:\\Users\\Abstract Build\\Desktop\\TUD\\Economics of Cybersecurity/country.txt";
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = "";
		String[] data;
		while ((line = br.readLine()) != null){
			data = line.split(",");
			hm.put(data[0], data[1]);
		}
		br.close();
		return hm;
	}
}
