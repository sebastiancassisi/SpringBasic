/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.springbasic.app;

import ar.com.springbasic.beans.Admin;
import ar.com.springbasic.dao.AdminDao;
import java.sql.Timestamp;
import java.util.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author cassisi
 */
public class MainApp {
 
    public static void main(String[] args) {
        
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("newSpringXMLConfig.xml");
        
        AdminDao adminDao = (AdminDao) applicationContext.getBean("adminDao");

        Timestamp ts = new Timestamp(new Date().getTime());
        
        Admin admin= new Admin();
        admin.setCargo("Gerente");
        admin.setNombre("Sebastian");
        admin.setFechaCreacion(ts);
        
        if (adminDao.save(admin)) {
            System.out.println("Admin salvado correctamente");
        }else{
            System.out.println("Error al insertar el administrador");
        }
        
    }
    
}
