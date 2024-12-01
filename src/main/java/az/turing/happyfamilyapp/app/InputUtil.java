package az.turing.happyfamilyapp.app;

import java.util.Scanner;

public class InputUtil {
    public static String getString(String title) {
        Scanner sc = new Scanner(System.in);
        System.out.println(title + ":");
        return sc.nextLine();
    }

    public static Integer getInteger(String title) {
        Scanner sc = new Scanner(System.in);
        System.out.println(title + ":");
        return sc.nextInt();
    }
}
