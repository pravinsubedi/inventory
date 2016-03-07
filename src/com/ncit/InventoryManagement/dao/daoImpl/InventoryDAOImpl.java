/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncit.InventoryManagement.dao.daoImpl;

import com.ncit.InventoryManagement.beans.Inventory;
import com.ncit.InventoryManagement.dao.InventoryDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pravin
 */
public class InventoryDAOImpl implements InventoryDAO{
    private final List<Inventory> inventoryList;
    private final List<Inventory> searchList=new ArrayList<>();
    public InventoryDAOImpl(List<Inventory> inventoryList) {
        this.inventoryList=inventoryList;
        
    }

    @Override
    public int insert(Inventory i) throws ClassNotFoundException, SQLException {
        inventoryList.add(i);
        return(0);//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean delete(int id) throws ClassNotFoundException, SQLException {
        Boolean found=false;
        for(Inventory i:inventoryList){
            if(i.getId()==id)
               inventoryList.remove(i);
               found=true;
               break;
    }
        return found;
    }
    @Override
    public Inventory getById(int id) throws ClassNotFoundException, SQLException {
       Inventory ie=null;
       for(Inventory i:inventoryList){
             if(i.getId()==id)
             {
                ie=i;//To change body of generated methods, choose Tools | Templates.
             }
       }
       return ie;
    }
    @Override
    public List<Inventory> getAll() throws ClassNotFoundException, SQLException {
        return inventoryList;        
    }

    @Override
    public List<Inventory> search(String param) throws ClassNotFoundException, SQLException {
         for(Inventory i:inventoryList){
             if(i.getItem().equals(param)){
                 searchList.add(i);
             }
         } 
         return searchList;
    }
    
}
