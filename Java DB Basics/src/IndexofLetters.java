import java.util.Scanner;

public class IndexofLetters {
    public static void main(String[] args) {
        char [] letters = new char[26];

        char letter = 'a';

        for (int i = 0; i < letters.length ; i++) {
            letters[i] = letter;
            letter++;
        }

        Scanner scan = new Scanner(System.in);

        char[] word = scan.nextLine().toCharArray();

        for (int i = 0; i < word.length; i++) {
            for (int j = 0; j < letters.length; j++) {
               if (word[i] == letters[j]){
                   System.out.println(word[i] + " -> " +  j);
               }

            }
        }




    }
}
