/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se150037.foodmanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Huynh Trung Tin - SE150037
 */
public class Utils {

    public static int getIntLimit(String message, int min, int max) {
        int result = 0;
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        do {
            try {
                System.out.print(message);
                result = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println("Error! Integer number: ");
            }
            if (result < min || result > max) {
                System.out.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Try again: ");
                check = true;
            } else {
                check = false;
            }
        } while (check);

        return result;
    }

    public static String getString(String message) {
        String result = "";
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        do {
            System.out.print(message);
            String tmp = sc.nextLine();
            if (!tmp.isEmpty()) {
                result = tmp;
                check = false;
            }
        } while (check);
        return result;
    }

    public static int getInt(String message) {
        int result = 0;
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        do {
            try {
                System.out.print(message);
                result = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println("Error! Integer number: ");
            }
        } while (check);
        return result;
    }

    public static int getPositiveInt(String message) {
        int result = -1;
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        do {
            try {
                System.out.print(message);
                result = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println("Error! Integer number: ");
            }
            if (result < 0) {
                System.out.println("Number must be great than 0! Try again:");
                check = true;
            } else {
                check = false;
            }
        } while (check);
        return result;
    }

    public static float getPositiveFloat(String message) {
        float result = -1;
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        do {
            try {
                System.out.print(message);
                result = Float.parseFloat(sc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println("Error! Float number: ");
            }
            if (result < 0) {
                System.out.println("Number must be great than 0! Try again:");
                check = true;
            } else {
                check = false;
            }
        } while (check);
        return result;
    }

    public static String updateString(String oldValue, String message) {
        String result = oldValue;
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        String tmp = sc.nextLine();
        if (!tmp.isEmpty()) {
            result = tmp;
        }
        return result;
    }

    public static String getValidDate(String message) {
        String result = "";
        Scanner sc = new Scanner(System.in);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date currentDate = cal.getTime();

        boolean check = true;
        do {
            System.out.print(message);
            result = sc.nextLine();
            SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
            date.setLenient(false);
            try {
                Date newDate = date.parse(result);
                if (newDate.before(currentDate)) {
                    System.err.println("Expiration date must be equal or greater than today!");
                    check = true;
                } else {
                    check = false;
                }
            } catch (ParseException e) {
                System.out.println("Invalid date");
            }
        } while (check);
        return result;
    }
}
