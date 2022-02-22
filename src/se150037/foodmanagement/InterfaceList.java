/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se150037.foodmanagement;

/**
 *
 * @author Huynh Trung Tin - SE150037
 */
public interface InterfaceList {

    void add();

    void addAnother();

    void searchByName(String name);

    void searchAnother();

    int findById(int id);

    void removeById();

    void print();
}
