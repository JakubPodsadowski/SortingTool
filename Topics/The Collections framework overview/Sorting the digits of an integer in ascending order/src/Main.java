import java.lang.Integer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        convertToList(number);
    }

    public static List<Integer> convertToList(int number){
        List<Integer> list = new ArrayList<>();
        while (number % 10 != 0) {
            list.add(number % 10);
            number /= 10;
        }
        Collections.sort(list);
        System.out.println(list);
        return null;
    }
}