/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncit.InventoryManagement.dao;

import com.ncit.InventoryManagement.beans.Inventory;
import java.sql.SQLException;
import java.util.List;
import com.ncit.InventoryManagement.util.Input;

/**
 *
 * @author pravin
 */
public interface InventoryDAO {
      public int insert(Inventory i) throws ClassNotFoundException,SQLException;
  public Boolean delete(int id)throws ClassNotFoundException,SQLException;
  public Inventory getById(int id) throws ClassNotFoundException,SQLException;
  public List<Inventory> getAll() throws ClassNotFoundException,SQLException;
  public List<Inventory> search(String param) throws ClassNotFoundException,SQLException;
}
