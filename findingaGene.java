import java.util.*;

class geneFinder {
	public static String findGene(String dna) {
		dna = dna.toLowerCase();
		int start = dna.indexOf("atg");
		int stoptag = dna.indexOf("tag", start + 3);
		int stoptga = dna.indexOf("tga", start + 3);
		int stoptaa = dna.indexOf("taa", start + 3);
		
		if (start == -1) {
			return "";
		} else if (stoptag != -1 && (stoptag-start)%3 == 0) {
			return dna.substring(start, stoptag + 3);
		} else if (stoptga != -1 && (stoptga - start)%3 == 0) {
			return dna.substring(start, stoptga + 3);
		} else if (stoptaa != -1 && (stoptaa - start) % 3 == 0) {
			return dna.substring(start, stoptaa +3);
		} else {
			return "";
		}
	}
	public static String stopcodon(String dna){
		String foundString = findGene(dna);
		if (foundString.equals("")) {
			return "";
		} else {
			return foundString.substring(foundString.length() - 3);
		}
	}
}


public class findingaGene {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);  
		System.out.println("Enter DNA code: ");
		String n = reader.next(); 
		String foundString = geneFinder.findGene(n);
		System.out.println("Found string of length " + foundString.length() + ": " + foundString
				+ " stopcodon: " + geneFinder.stopcodon(n));

	}

}
