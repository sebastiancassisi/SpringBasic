/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.springbasic.dao;

import ar.com.springbasic.beans.Admin;
import java.util.List;

/**
 *
 * @author cassisi
 */
public interface AdminDao {
    
    public boolean save (Admin admin);
    public List<Admin> findAll();
    public Admin findById(int id);
    public List<Admin> findByNombre (String nombre);
    public boolean update (Admin admin);
    public boolean delete (int idAd);
    public int[] saveAll(List<Admin> admins);
    
}
