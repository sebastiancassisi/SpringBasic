/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.springbasic.app;

import ar.com.springbasic.beans.Admin;
import ar.com.springbasic.dao.AdminDao;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

/**
 *
 * @author cassisi
 */
public class MainApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("newSpringXMLConfig.xml");

        AdminDao adminDao = (AdminDao) applicationContext.getBean("adminDao");

        Timestamp ts = new Timestamp(new Date().getTime());

//        ***Creo un nuevo admin***
//          Admin admin = new Admin();
//        admin.setCargo("Gerente");
//        admin.setNombre("carlo");
//        admin.setFechaCreacion(ts);

        try {
//            ***Guardo el admin***
//            adminDao.save(admin);
            
//               ***traigo todos los campos ***
//            List<Admin> admins = adminDao.findAll();
//            for (Object admin1 : admins) {
//                System.out.println(admin1);    
//            }

//            ***Busco por un id***
//            System.out.println(adminDao.findById(2));

//            Busco por un nombre
//            System.out.println(adminDao.findByNombre("pepe").toString());

//            Modificar y borrar
//            Admin admin = adminDao.findById(1);
//            System.out.println("Admin con id 1= " + admin);
//            
//            admin.setCargo("Subgerente");
//            admin.setNombre("Adrian");
//            
//            if (adminDao.update(admin)) {
//                System.out.println("Actializacion correcta " +admin);
//            }
//            if (adminDao.delete(admin.getIdAd())) {
//                System.out.println("Admin: "+admin.getNombre() +" eliminado correctamente");
//                
//            }
            
            List<Admin> admins = new ArrayList<>();
            admins.add(new Admin("Papulo","Jefe de ingenieria",ts));
            admins.add(new Admin("Cucuro","Chorro",ts));
            admins.add(new Admin("Zafalo","Mujeriego",ts));
            admins.add(new Admin("Mengano","Chupa culo",ts));
            
            int[] vals = adminDao.saveAll(admins);


            for (int val : vals) {
              System.out.println("Filas afectadas para esta operacion= " + val);  
            }


        } catch (CannotGetJdbcConnectionException e) {
            //Error de conneccion
            System.out.println(e);
        } catch (DataAccessException b) {
            //Error de acceso a datos
            System.out.println(b);

        }

    }

}
