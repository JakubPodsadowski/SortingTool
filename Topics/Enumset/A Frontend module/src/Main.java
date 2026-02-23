import java.util.EnumSet;
import java.util.Scanner;

// Include import statements
public class Main {

    enum Fonts {
        BOLD, LARGE, MEDIUM, SMALL, ITALIC, NORMAL
    }   

    EnumSet<Fonts> enumSet;

    public static void main(String[] args) {

        Main object = new Main();

        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine().trim();

        // Change Code below this line
        switch (string) {
            case "Main-Heading":
                object.enumSet = EnumSet.of(Fonts.BOLD, Fonts.LARGE, Fonts.NORMAL);
                break;
            case "Quote":
                object.enumSet = EnumSet.of(Fonts.SMALL, Fonts.ITALIC);
                    break;
            case "Paragraph":
                object.enumSet = EnumSet.of(Fonts.SMALL, Fonts.NORMAL);
                    break;
            case "Sub-Heading":
                object.enumSet = EnumSet.of(Fonts.NORMAL, Fonts.MEDIUM);
                    break;
            case "Quote|BOLD":
                object.enumSet = EnumSet.of(Fonts.BOLD, Fonts.SMALL, Fonts.ITALIC);
                    break;
            default : System.out.println("ERROR");
                    break;
        }
        // Change the code above this line
        System.out.println(object.enumSet);
    }
}