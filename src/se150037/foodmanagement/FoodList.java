/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se150037.foodmanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

/**
 *
 * @author Huynh Trung Tin - SE150037
 */
public class FoodList extends ArrayList<Food> implements InterfaceList {

    @Override
    public void add() {
        int id = 0;
        String name = "";
        float weight = 0;
        String type = "";
        String place = "";
        String expiredDate = "";
        boolean check = true;

        do {
            id = Utils.getPositiveInt("Input ID: ");
            if (findById(id) != -1) {
                System.out.println("Duplicate ID.");
                continue;
            }
            name = Utils.getString("Input Name: ");
            weight = Utils.getPositiveFloat("Input Weight (Kg): ");
            type = Utils.getString("Input Type: ");
            place = Utils.getString("Input Place: ");
            expiredDate = Utils.getValidDate("Input Expired Date (yyyy/mm/dd): ");
            check = false;
        } while (check);
        this.add(new Food(id, name, weight, type, place, expiredDate) {
        });
        System.out.println("Added!");
    }

    @Override
    public void searchByName(String name) {
        ArrayList<Food> temp = new ArrayList<Food>();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                temp.add(this.get(i));
            }
        }
        if (temp.isEmpty()) {
            System.out.println("This food does not exist");
        } else {
            for (int i = 0; i < temp.size(); i++) {
                System.out.println("Food {" + "ID: " + temp.get(i).getId() + ", "
                        + "Name: " + temp.get(i).getName() + ", "
                        + "Weight: " + temp.get(i).getWeight() + ", "
                        + "Type: " + temp.get(i).getType() + ", "
                        + "Place: " + temp.get(i).getPlace() + ", "
                        + "Expired Date: " + temp.get(i).getExpiredDate() + "}");
            }
        }
    }

    @Override
    public void removeById() {
        int id = 0;
        id = Utils.getPositiveInt("Input ID that you want delete: ");
        String confirmMess = "";
        boolean check = true;
        do {
            confirmMess = Utils.getString("Are you sure remove this item (Y/N)?");
            if (confirmMess.equalsIgnoreCase("Y")) {
                if (findById(id) != -1) {
                    this.remove(get(findById(id)));
                    System.out.println("Success.");
                } else {
                    System.out.println("Not Found!");
                }
                check = false;
            } else if (confirmMess.equalsIgnoreCase("N")) {
                System.out.println("Fail.");
                check = false;
            } else {
                check = true;
            }
        } while (check);
    }

    @Override
    public int findById(int id) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void print() {
        Collections.sort(this, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return o2.getExpiredDate().compareTo(o1.getExpiredDate());
            }

        });
        for (int i = 0; i < this.size(); i++) {
            System.out.println("Food {" + "ID: " + this.get(i).getId() + ", "
                    + "Name: " + this.get(i).getName() + ", "
                    + "Weight: " + this.get(i).getWeight() + ", "
                    + "Type: " + this.get(i).getType() + ", "
                    + "Place: " + this.get(i).getPlace() + ", "
                    + "Expired Date: " + this.get(i).getExpiredDate() + "}");
        }
    }

    @Override
    public void addAnother() {
        boolean check = true;
        String confirmMess = "";
        do {
            confirmMess = Utils.getString("Do you want to add another food? (Y/N): ");
            if (confirmMess.equalsIgnoreCase("Y")) {
                this.add();
                check = true;
            } else if (confirmMess.equalsIgnoreCase("N")) {
                check = false;
            } else {
                check = true;
            }
        } while (check);
    }

    @Override
    public void searchAnother() {
        boolean check = true;
        String confirmMess = "";
        do {
            confirmMess = Utils.getString("Do you want to search another food? (Y/N): ");
            if (confirmMess.equalsIgnoreCase("Y")) {
                String name = Utils.getString("Enter name of food that you want to find: ");
                this.searchByName(name);
                check = true;
            } else if (confirmMess.equalsIgnoreCase("N")) {
                check = false;
            } else {
                check = true;
            }
        } while (check);
    }

}
