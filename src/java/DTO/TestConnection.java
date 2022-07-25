/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DAO.AccountDAO;
import DAO.PlantDAO;
import Utils.randomString;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class TestConnection {

    public static void main(String[] args) {
//        Account acc = AccountDAO.getAccount("test@gmail.com", "test");
//        if (acc != null) {
//            if (acc.getRole() == 1) {
//                System.out.println("i am an admin");
//            } else {
//                System.out.println("i am a user");
//            }
//
//        } else {
//            System.out.println("login failed");
//        }
//        if (AccountDAO.insertAccount("testaccount2", "test2","test", "test2", 0, 1)) {
//            System.out.println("account inserted");
//        }
//        else{
//            System.out.println("account was not inserted");
//        }
//        ArrayList<Plant> list = PlantDAO.getPlants("lo", "byname");
//        for (Plant plant : list) {
//            System.out.println(plant.getId());
//            System.out.println(plant.getName());
//        }
//        AccountDAO.updateAccount("mas", "mashe", "mashe", "123");
        System.out.println(randomString.randomString());
        System.out.println(randomString.randomString());
        System.out.println(randomString.randomString());
        System.out.println(randomString.randomString());
        System.out.println(randomString.randomString());
    }

}
