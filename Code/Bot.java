package eco;

import java.util.HashMap;

public class Bot {
	HashMap<String, Integer> hm;
	String name;

	public Bot(String name) {
		this.name = name;
		hm = new HashMap<String, Integer>();
		hm.put("EU", 0);
		hm.put("AF", 0);
		hm.put("AS", 0);
		hm.put("NA", 0);
		hm.put("SA", 0);
		hm.put("OC", 0);
	}

	public void update(String continent, String in) {
		hm.put(continent, (hm.get(continent) + Integer.parseInt(in)));
	}

	public String toString() {
		String s = name+"\t";
		s += hm.get("EU")+"\t";
		s += hm.get("AF")+"\t";
		s += hm.get("AS")+"\t";
		s += hm.get("NA")+"\t";
		s += hm.get("SA")+"\t";
		s += hm.get("OC");

		return s;
	}

}
