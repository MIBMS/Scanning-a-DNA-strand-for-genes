import java.util.Scanner;

class manyGeneFinder{
	/**This method finds the first occurrence of each stop codon to the right of index .
	 * @param dna DNA to be inputed
	 * @param index start index to be inputed
	 * @return From those stop codons that are a multiple of three from index , it returns 
	 * the smallest index position. It should return -1 if no stop codon was found 
	 * and there is no such position.
	 */
	static int findStopIndex(String dna, int index){
				
		int tagindex = dna.indexOf("tag", index + 3);
		int tgaindex = dna.indexOf("tga", index + 3);
		int taaindex = dna.indexOf("taa", index + 3);
		
		if (tgaindex == -1 || (tgaindex - index) % 3 != 0){
			tgaindex = dna.length()+1;
		}
		if (tagindex == -1 || (tagindex - index) % 3 != 0){
			tagindex = dna.length()+1;
		}
		if (taaindex == -1 || (taaindex - index) % 3 != 0){
			taaindex = dna.length()+1;
		}
		if (tgaindex == dna.length()+1 && tagindex == dna.length()+1 && taaindex == dna.length()+1){
			return -1;
		}
		else{
			return Math.min(tgaindex, Math.min(taaindex, tagindex));
		}
		
	}
	
	/**
	 * This method should print all the genes it finds in DNA. 
	 * This method should repeatedly look for a gene, and if it finds one, 
	 * print it and then look for another gene.
	 * 
	 * @param dna DNA to be used
	 */
	static void printall(String dna){
		int start = 0;
		int loc = 0;
		int stop = 0;
		while (loc != -1){
			loc = dna.indexOf("atg", start);
			if (loc != -1){
				stop = findStopIndex(dna, loc);
				if (stop != -1){
					String gene = dna.substring(loc, stop+3);
					System.out.println(gene);
					start = stop + 3;
				}
				else{
					start = loc + 3;
				}
				
			}
		}
	}
	
}


public class findingManyGenes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);  
		System.out.println("Enter DNA code: ");
		String n = reader.next(); 
		n = n.toLowerCase();
		manyGeneFinder.printall(n);

	}

}

