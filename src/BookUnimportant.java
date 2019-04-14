import java.util.Scanner;

public class BookUnimportant {


    public static void Book() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Citim titlul cartii: ");
        String title = scanner.nextLine();

        System.out.println("Citim nr de pagini: ");
        int nrOfPages = scanner.nextInt();

        System.out.println("Citim lungimea copertii: ");
        int length = scanner.nextInt();

        System.out.println("Citim latimea cartii: ");
        int wide = scanner.nextInt();

        System.out.println("Citim culoarea cartii: ");
        String color = scanner.nextLine();
    }

    public static void main(String[] args) {

        System.out.println("Cate carti analizam?: ");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println("Citim caracteristicile cartii: ");

        while (i > 0) {
            Book();
            i--;
        }
    }
}