package eco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class TinbaCountMapperToContinent {
	public static void main(String[] args) throws Exception {
		HashMap<String, String> toContinent = continentReader.getCountryHashMap();
		String file = "C:\\Users\\Abstract Build\\Desktop\\TUD\\Economics of Cybersecurity/top10botnetdistr.txt";
		Bot[] bots = new Bot[13];
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line, continent;
		String[] data;
		while ((line = br.readLine()) != null) {
			data = line.split("\t");
			continent = toContinent.get(data[0]);
			for (int i = 1; i < bots.length; i++) {
				if (bots[i] == null) {
					bots[i] = new Bot(data[i]);
				}else if (continent != null) {
					bots[i].update(continent, data[i]);
				} else {
					
				}
			}
		}
		br.close();

		System.out.println("Bot\tEU\tAF\tAS\tNA\tSA\tOC");
		for (Bot b : bots) {
			if (b != null) {
				System.out.println(b);
			}
		}

	}
}
