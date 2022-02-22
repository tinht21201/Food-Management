/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se150037.foodmanagement;

import java.io.IOException;

/**
 *
 * @author Huynh Trung Tin - SE150037
 */
public class FoodMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        InterfaceMenu menu = new Menu();
        menu.addItem("Welcome to Food Management - @ 2021 by <SE150037 - Huynh Trung Tin>");
        menu.addItem("Select the options below:");
        menu.addItem("1. Add a new food");
        menu.addItem("2. Search a food by name");
        menu.addItem("3. Remove the food by ID");
        menu.addItem("4. Print the food list in the descending order of expired date");
        menu.addItem("5. Save to file.");
        menu.addItem("6. Quit");
        int choice = 0;
        String file = "filefood.dat";
        InterfaceList list = new FoodList();
        
        try {
            FileStore.readFileBinary(file, ((FoodList) list));
        } catch (Exception e) {
        }
        
        do {
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    list.add();
                    list.addAnother();
                    System.out.println("");
                    break;
                case 2:
                    String name = Utils.getString("Enter name of food that you want to find: ");
                    list.searchByName(name);
                    list.searchAnother();
                    System.out.println("");
                    break;
                case 3:
                    list.removeById();
                    System.out.println("");
                    break;
                case 4:
                    list.print();
                    System.out.println("");
                    break;
                case 5:
                    if (FileStore.writeFileBinary(file, ((FoodList) list))) {
                        System.out.println("Success.");
                    } else {
                        System.out.println("Fail.");
                    }
                    break;
                case 6:
                    break;
            }
        } while (choice != 6);
    }

}
