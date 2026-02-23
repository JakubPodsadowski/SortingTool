import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        String[] words = sentence.split(" ");
        int maxLength = 0;
        String longest = null;
        for (String word : words) {
            if (word.length() > maxLength) {
                longest = word;
                maxLength = word.length();
            }
        }
        System.out.println(longest);
    }
}