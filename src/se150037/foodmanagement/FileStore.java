/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se150037.foodmanagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Huynh Trung Tin - SE150037
 */
public class FileStore {

    public static void readFileBinary(String url, ArrayList list) throws IOException {
        FileInputStream fis = new FileInputStream(url);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            Food food = null;
            //System.out.println("Data from file:");
            while (fis.available() > 0) {
                food = (Food) ois.readObject();
                //Print when read file
                //System.out.println(food.toString());
                list.add(food);
            }
        } catch (Exception e) {
        } finally {
            if (fis != null) {
                fis.close();
            }
            if (ois != null) {
                ois.close();
            }
        }
    }

    public static boolean writeFileBinary(String url, ArrayList list) throws IOException {
        boolean check = false;
        FileOutputStream fos = new FileOutputStream(url);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        try {
            for (int i = 0; i < list.size(); i++) {
                oos.writeObject(list.get(i));
            }
            check = true;
        } catch (Exception e) {
        } finally {
            if (oos != null) {
                oos.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
        return check;
    }
}
