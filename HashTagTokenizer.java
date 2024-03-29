

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		In in = new In(fileName);

		for(int i = 0; i < dictionary.length; i ++){
			dictionary[i] = in.readLine();
		}
		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {
		boolean flag = false;
		String searchWord = word.toLowerCase();
		for(int i = 0; i < dictionary.length; i ++){
			if(dictionary[i].equals(searchWord)){
				flag =true;
			}
		}
		return flag;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
		String cutWord = "";
        int N = hashtag.length();
        for (int i = 1; i <= N; i++) {
			cutWord = hashtag.substring(0, i);
			if (existInDictionary(cutWord, dictionary)){
				System.out.println(cutWord);
				breakHashTag(hashtag.substring(i, N), dictionary);
			}
			
        }
    }
}
