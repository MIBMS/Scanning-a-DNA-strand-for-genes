import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import edu.duke.*;


public class storingAllGenes {

	/**
	 * stores genes found in dna strings
	 * @param dna dna string to be scanned
	 * @return storageresource object containing genes
	 */
	static StorageResource storeAll(String dna){
		StorageResource store = new StorageResource();
		int start = 0;
		int loc = 0;
		int stop = 0;
		while (loc != -1){
			loc = dna.indexOf("atg", start);
			if (loc != -1){
				stop = manyGeneFinder.findStopIndex(dna, loc);
				if (stop != -1){
					String gene = dna.substring(loc, stop+3);
					store.add(gene);
					start = stop + 3;
				}
				else{
					start = loc + 3;
				}
				
			}
		}
		return store;
		
	}
	
	/**
	 * tests the storage finder class and is to be called by the main method
	 * @param dna dna to be scanned
	 */
	static void testStorageFinder(String dna){
		StorageResource store =  storeAll(dna);
		System.out.println(store.size());

	}
	
	/**
	 * Finds the percentage of the gene that is cytosine and guanine
	 * @param dna gene to be scanned
	 * @return the ratio of c and g as a percentage of string length
	 */
	static float cgRatio(String dna){
		float count = 0;
		for(int i=0; i< dna.length(); i++){
			if (dna.charAt(i) == 'c' || dna.charAt(i) == 'g'){
				count++;
			}
		}
		return count/dna.length();
	}
	
	/**
	 * prints all the Strings that are longer than 60 characters
	 * prints the number of Strings that are longer than 60 characters
	 * prints the Strings whose C-G-ratio is higher than 0.35
	 * prints the number of strings whose C-G-ratio is higher than 0.35
	 * @param sr StorageResource which stores all the genes
	 */
	static void printGenes(StorageResource sr){
		//System.out.println("Printing strings longer than 60 char: ");
		int count = 0;
		for (String string : sr.data()){
			if (string.length()>60){
				//System.out.println(string);
				count++;
			}
		}
		System.out.println("Number of strings longer than 60 char: " + count);
		count = 0;
		//System.out.println("Printing strings with CG ratio higher than 0.35: ");
		for (String string : sr.data()){
			if (cgRatio(string)>0.35){
				//System.out.println(string);
				count++;
			}
		}
		System.out.println("Number of strings with CG ratio higher than 0.35: " + count);
	}
	
	/**
	 * counts the number of occurrences of CTG codon in a string of DNA
	 * @param dna dna to be analysed
	 * @return number of CTG occurrences
	 */
	static int countCTG(String dna){
		int count = 0;
		int start = 0;
		int position = 0;
		while (position != -1){
			position = dna.indexOf("ctg", start);
			if(position !=-1){
				count++;
			}
			start = position + 3;
		}
		return count;
	}
	
	static int maxLength(StorageResource sr){
		ArrayList<Integer> stringLengths = new ArrayList<Integer>();
		for (String gene: sr.data()){
			stringLengths.add(gene.length());
		Collections.sort(stringLengths);
		}
		if (stringLengths.size() == 0){
			return 0;
		}else{
			return stringLengths.get(stringLengths.size()-1);
		}
		
		
	}
	
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);  
		System.out.println("Enter DNA code: ");
		String n = reader.next(); 
		n = n.toLowerCase();
		testStorageFinder(n);
		StorageResource store = storeAll(n);
		printGenes(store);
		System.out.println("Number of times CTG appears: " + countCTG(n));
		System.out.println("Maximum gene found: " + maxLength(store));
		

	}

}
