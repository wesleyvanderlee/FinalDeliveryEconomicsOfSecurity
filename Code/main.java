package eco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class main {
	public static void main(String[] args) {
		ArrayList<String> bottypes = new ArrayList<String>();
		String file = "C:\\Users\\Abstract Build\\Desktop\\TUD\\Economics of Cybersecurity/econsec.data";
		String[] currline;
		String line, country, bottype;
		BufferedReader br = null;
		int i = 0;
		int e = 0;
		int y = 0;
		HashMap<String, HashMap<String, Integer>> hm = new HashMap<String, HashMap<String, Integer>>();
		currline = ",a,d,s".split(",");
		try {
			br = new BufferedReader(new FileReader(file), (1024 * 1024));
			br.readLine();
			br.readLine();
			while ((line = br.readLine()) != null) {// && i < 500000) {
				i++;
				try {
					currline = line.split(",");
					country = currline[3];
					bottype = currline[7].split(" ")[3];
					if (!hm.containsKey(country)) {
						HashMap<String, Integer> l = new HashMap<String, Integer>();
						l.put(bottype, 1);
						hm.put(country, l);
					} else {
						HashMap<String, Integer> l = hm.get(country);
						if(!l.containsKey(bottype)){
							HashMap<String, Integer> n = new HashMap<String, Integer>();
							n.put(bottype, 1);
							n.putAll(l);
							hm.put(country, n);
						}else{
							l.put(bottype, l.get(bottype) + 1);
							hm.put(country, l);
						}
					}
					if (!bottypes.contains(bottype)) {
						bottypes.add(bottype);
					}
				} catch (Exception ex) {
					e++;
				}
			}
			print(hm, bottypes);
		} catch (Exception ex) {
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException ex) {
				}
			}
		}

	}

	public static void print(HashMap<String, HashMap<String, Integer>> hm, ArrayList<String> bottypes) {
		System.out.print("CC\t");
		for (String bottype : bottypes) {
			System.out.print(bottype + "\t");
		}
		System.out.println();
		System.out.println("-->");
		for (String country : hm.keySet()) {
			String line = "";
			line += country + "\t";
			for (String bottype : bottypes) {
				Integer val = hm.get(country).get(bottype);
				if (val != null) {
					line += val;
				} else {
					line += 0;
				}
				line += "\t";
			}
			System.out.println(line);
		}
	}
}
