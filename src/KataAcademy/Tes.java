package KataAcademy;

import java.util.Scanner;

public class Tes {
    public static int test(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println(test(x, y));
    }
}
