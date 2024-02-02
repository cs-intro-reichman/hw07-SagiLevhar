
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) {
		// Your code goes here
		if (str.length() <= 1) {
			return "";
		}
		return str.substring(1);
	}

	public static int levenshtein(String word1, String word2) {
		// Your code goes here
		if (word1.isEmpty()) {
			return word2.length();
		}
		if (word2.isEmpty()) {
			return word1.length();
		}
		if (word1.toLowerCase().charAt(0) == word2.toLowerCase().charAt(0)) {
			return levenshtein(tail(word1), tail(word2));
		} else {
			return (1 + Math.min(Math.min(levenshtein(tail(word1), tail(word2)), levenshtein(word1, tail(word2))), levenshtein(tail(word1), word2)));

		}
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		In in = new In(fileName);
		for(int i = 0; i < dictionary.length; i ++){
			dictionary[i] = in.readLine();
		}
		return dictionary;

	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		String chosenWord = "";
		int currentDistance = 0;

		for (int i = 0; i < dictionary.length; i++){
			currentDistance = levenshtein(word, dictionary[i]);
			if (currentDistance <= threshold) {
				chosenWord = dictionary[i];
				if (currentDistance < threshold) {
					chosenWord = dictionary[i];
				}
			}
		}
		if (chosenWord.equals("")) {
			chosenWord = word;
		}
		return chosenWord;
	}
}
