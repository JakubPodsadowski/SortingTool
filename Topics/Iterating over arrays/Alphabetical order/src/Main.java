import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String words = sc.nextLine();
        String[] wordsArray = words.split(" ");
        boolean out = false;
        for(int i = 0; i < wordsArray.length - 1; i++){
            if(wordsArray[i].compareTo(wordsArray[i+1]) > 0){
                out = false;
                break;
            }
            out = true;
        }
        System.out.println(out);
    }
}