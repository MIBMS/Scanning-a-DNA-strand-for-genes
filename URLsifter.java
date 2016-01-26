import java.util.ArrayList;

import edu.duke.*;

class findURLs {
	public static ArrayList<String> urlFind(){
		URLResource url = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
		ArrayList<String> urlArray = new ArrayList<String>();
		for (String word: url.words()) {
			String word2 = word;
			word = word.toLowerCase();
			int index = word.indexOf("youtube.com");
			if (index != -1) {
				int beginURL = word.lastIndexOf("\"", index);
				int endURL = word.indexOf("\"", index);
				String urlword = word2.substring(beginURL, endURL+1);
				urlArray.add(urlword);
			}
		}
		return urlArray;

	}

}

public class URLsifter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> urlArray = findURLs.urlFind();
		for (String urlword : urlArray){
			System.out.println(urlword);
		}
	}

}
