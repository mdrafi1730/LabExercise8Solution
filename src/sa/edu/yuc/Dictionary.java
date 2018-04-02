package sa.edu.yuc;
import java.util.ArrayList;
import java.util.Scanner;
public class Dictionary {
	public static final String filename = "dictionary.db";
	public static void main(String[] args) {
		/*Hashtable<Word> dict = null;
		try {
			dict = (Hashtable<Word>)Util.load(filename);
		} catch (Exception e) {
			dict = new Hashtable<Word>(Word.class);
		}*/
		HashInterface<Word> dict = new Hashtable<>(Word.class);
		Scanner input = new Scanner(System.in);
		int option = -1;
		String word = null;
		while (option != 0) {
			menu();
			System.out.print("Option > ");
			option = input.nextInt();
			switch (option) {
				case 1:
					Word w = Word.getWordMeaning();
					dict.put(w.getWord(), w);
					try {
						Util.save(filename, dict);
					} catch (Exception e) { }
					break;
				case 2:
					System.out.println("Please enter the word: ");
					word = input.next();
					System.out.println(dict.get(word));
					break;
				case 3:
					System.out.println("Please enter the word: ");
					word = input.next();
					//dict.delete(word);
					try {
						Util.save(filename, dict);
					} catch (Exception e) { }
					break;
				case 4:
					dict.getAllValues();
					break;
				case 0:
					break;
				default:
					System.out.println("Error!");
			}			
		}
		System.out.println("Thank you!");
	}
	private static void menu() {
		System.out.println("Welcome to MyDictionary");
		System.out.println("Press 1 to add a new word");
		System.out.println("Press 2 to find a word");
		System.out.println("Press 3 to delete a word");
		System.out.println("Press 4 to list all words");
		System.out.println("Press 0 to exit");
	}
}