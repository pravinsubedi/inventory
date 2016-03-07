/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncit.InventoryManagement.dao.daoImpl;

import com.ncit.InventoryManagement.beans.Inventory;
import com.ncit.InventoryManagement.dao.InventoryDAO;
import com.ncit.InventoryManagement.util.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pravin
 */
public class InventoryDBIImpl implements InventoryDAO{

    
    
    @Override
    public int insert(Inventory i) throws ClassNotFoundException, SQLException {
           DBConnection conn=new DBConnection();
           String sql="INSERT INTO tbl_inventory(name,type,brand,price)VALUES";
            sql+="('"+i.getItem()+"','"+i.getType()+"','"+i.getBrand()+"',"+i.getPrice()+")";
           return(conn.executeUpdate(sql));
    }

    @Override
    public Boolean delete(int id) throws ClassNotFoundException, SQLException {
        DBConnection conn=new DBConnection();
        String sql="DELETE FROM tbl_inventory WHERE tbl_inventory.id="+id+"";
        conn.executeUpdate(sql);
        return true;
    }

    @Override
    public Inventory getById(int id) throws ClassNotFoundException, SQLException {
        DBConnection conn=new DBConnection();
        String sql="SELECT * FROM tbl_inventory WHERE tbl_inventory.id="+id+"";
        ResultSet rs=conn.executeQuery(sql);
        Inventory i=new Inventory();
        while(rs.next()){
         i.setItem(rs.getString("name"));
         i.setType(rs.getString("type"));
         i.setBrand(rs.getString("brand"));
         i.setPrice((int) rs.getDouble("price"));
         i.setId(rs.getInt("id"));
            
        }
        return i;
    }

    @Override
    public List<Inventory> getAll() throws ClassNotFoundException, SQLException {
        DBConnection conn=new DBConnection();
        String sql="SELECT * FROM tbl_inventory";
        ResultSet rs=conn.executeQuery(sql);
        List<Inventory> l=new ArrayList<>();
        while(rs.next()){
         Inventory i=new Inventory();  
         i.setItem(rs.getString("name"));
         i.setType(rs.getString("type"));
         i.setBrand(rs.getString("brand"));
         i.setPrice((int) rs.getDouble("price"));
         i.setId(rs.getInt("id"));
         l.add(i);
        }
        return l;
    }

    @Override
    public List<Inventory> search(String param) throws ClassNotFoundException, SQLException {
       DBConnection conn=new DBConnection();
        String sql="SELECT * FROM tbl_inventory WHERE tbl_inventory.item='"+param+"'";   
       ResultSet rs=conn.executeQuery(sql);
        List<Inventory> l=new ArrayList<>();
        while(rs.next()){
         Inventory i=new Inventory();
         i.setItem(rs.getString("name"));
         i.setType(rs.getString("type"));
         i.setBrand(rs.getString("brand"));
         i.setPrice((int) rs.getDouble("price"));
         i.setId(rs.getInt("id"));
         l.add(i);   
        }
    return l;
}
}