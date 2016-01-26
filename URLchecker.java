import edu.duke.*;

public class URLchecker {
	/**
	 * finds all links in a website and adds the urls to a StorageResource
	 * @param website
	 * @return StorageResource containing all the links
	 */
	static StorageResource findURLs(String website){
		URLResource url = new URLResource(website);
		StorageResource urlArray = new StorageResource();
		for (String line: url.lines()) {
			String line_lowercase = line.toLowerCase();
			int index = 0;
			int endURL = 0;
			while (index !=-1){
				index = line_lowercase.indexOf("href=", endURL);
				if (index != -1) {
					//int beginURL = word.lastIndexOf("\"", index);
					endURL = line_lowercase.indexOf("\"", index+6);
					String urlline = line.substring(index+6, endURL);
					urlArray.add(urlline);
				}
			}
		}
		return urlArray;

	}
	
	static void printURLs(String website){
		StorageResource sr = findURLs(website);
		int securecount = 0;
		int havecom = 0;
		int endcom = 0;
		int dotcount = 0;
		for (String url: sr.data()){
			if (url.indexOf("https") == 0){
				securecount++;
			}
			if (url.indexOf(".com") != -1){
				havecom++;
			}
			if (url.substring(url.length()-4).equals(".com") || url.substring(url.length()-5).equals(".com/")) {
				endcom++;
			}
			for (int i = 0; i<url.length(); i++){
				if (url.charAt(i) == '.'){
					dotcount++;
				}
			}
		}
		for (String link: sr.data()){
			System.out.println(link);
		}
		System.out.println("Number of links: " + sr.size());
		System.out.println("Number of securelinks: " + securecount);
		System.out.println("Number of links that have .com in them: " + havecom);
		System.out.println("Number of links that end with .com or .com/: " + endcom);
		System.out.println("Number of dots in links: " + dotcount);
	}

	public static void main(String[] args) {
		printURLs("http://www.dukelearntoprogram.com/course2/data/newyorktimes.html");
	}

}
