/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.springbasic.app;

import ar.com.springbasic.beans.Administrador;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author cassisi
 */
public class MainApp {
 
    public static void main(String[] args) {
        
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("newSpringXMLConfig.xml");
        Administrador administrador = (Administrador) applicationContext.getBean("admin");
        administrador.imprimirDireccion();

        
    }
    
}
