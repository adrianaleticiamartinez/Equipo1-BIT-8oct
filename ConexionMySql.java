/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.readcsv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author edgar
 */
public class ConexionMySql {
 
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String database = "sga";
    private static String hostname = "localhost:3306";
    private static String url =  "jdbc:mysql://database-1.cf70jork1fvq.us-east-2.rds.amazonaws.com:3306/datos?useSSL=false&serverTimezone=UTC";
    private static String user = "host";
    private static String password = "host1234";
    
    
    public static synchronized Connection getConnection(){
        Connection con = null;
        
        try{
            
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, password);
                 
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Aqui valio)");
            ex.printStackTrace();
        }
        
        return con;
    }
    
    
    
   
    
}
