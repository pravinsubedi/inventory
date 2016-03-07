/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncit.InventoryManagement;

import com.ncit.InventoryManagement.beans.Inventory;
import com.ncit.InventoryManagement.dao.InventoryDAO;
import com.ncit.InventoryManagement.dao.daoImpl.InventoryDAOImpl;
import com.ncit.InventoryManagement.dao.daoImpl.InventoryDBIImpl;
import com.ncit.InventoryManagement.util.Input;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pravin
 */
public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       int choice=0;
        //InventoryDAO dao=new InventoryDAOImpl(new ArrayList<Inventory>());
        InventoryDAO dao=new InventoryDBIImpl();
        while(choice<=7){
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("welcome to Inventory Management System");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("1.add Item");
        System.out.println("2.delete Item");
        System.out.println("3.search by id of Item");
        System.out.println("4.search by name of Item");
        System.out.println("5.get all Item");
       /** System.out.println("6.load from file");
        System.out.println("7.store into file");*/
        System.out.println("6.exit");
  try{
            choice=Input.getInt();
            
            switch(choice){
                case 1:
                      addItem(dao);
                       break;
                case 2:
                      deleteItem(dao);
                     break;
                case 3:
                      getById(dao);
                     break;
                case 4:
                      search(dao);
                     break;
                case 5:
                    showAll(dao);
                      break;
                /**case 6:
                    loadFromFile(dao);
                    break;
                case 7:
                    storeIntoFile(dao);
                    break;*/
                case 6:
                    System.exit(0);
                    break;
            }
            
            
            }catch(IOException ioe){
                System.out.println(ioe.getMessage());
            }
    }
     
    }
       public static void addItem(InventoryDAO dao) throws IOException, SQLException, ClassNotFoundException{
            String result="Y";
            while(result.equalsIgnoreCase("Y")){
                Inventory i=new Inventory();
                System.out.println("enter the id of the item");
                i.setId(Input.getInt());
                System.out.println("enter the name of the item");
                i.setItem(Input.getString());
                System.out.println("enter the type of the item");
                i.setType(Input.getString());
                System.out.println("enter the brand of the item");
                i.setBrand(Input.getString());
                System.out.println("enter the price of the item");
                i.setPrice(Input.getInt());
                dao.insert(i);
                System.out.println("\r\n\r\nDo you want to continue??");
                result=Input.getString();
                
            }
            
        }
       public static void deleteItem(InventoryDAO dao) throws IOException, ClassNotFoundException, SQLException{
           System.out.println("enter the id of the item you want to delete");
           int id=Input.getInt();
           dao.delete(id);
           System.out.println("the item deleted");
       }
       public static void getById(InventoryDAO dao) throws IOException, ClassNotFoundException, SQLException{
           System.out.println("enter the id of the item");
           int id=Input.getInt();
           Inventory i=dao.getById(id);
           System.out.println(i.toCSV());
       }
       public static void search(InventoryDAO dao) throws IOException, SQLException, ClassNotFoundException{
           System.out.println("enter the name of the item you want to search");
           String param=Input.getString();
           List<Inventory> list=dao.search(param);
           for(Inventory i:list){
               System.out.println(i.toCSV());
           }
           
           
       }
           public static void showAll(InventoryDAO dao) throws ClassNotFoundException, SQLException{
        for(Inventory i : dao.getAll()){
            System.out.println(i.toCSV());
        }
    }
}
