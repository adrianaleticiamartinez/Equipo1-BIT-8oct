/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.readcsv;

import com.csvreader.CsvReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author edgar
 */
public class Csv {
   
    public static void main(String[] args) {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        
        usuarios = importarCSV();
        System.out.println(usuarios.size());
        insertarMySQL(usuarios);
        
    }

    private static List<Usuario> importarCSV() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try{
            CsvReader leerUsuarios = new CsvReader("C:\\Users\\edgar\\Desktop\\InsumosHackaton8oct\\baseClientesHackaton8Oct.csv");
            leerUsuarios.readHeaders();
            while(leerUsuarios.readRecord()){
                String idCliente = leerUsuarios.get(0);
                String nombre = leerUsuarios.get(1);
                String apellidoPaterno = leerUsuarios.get(2);
                String apellidoMaterno = leerUsuarios.get(3);
                String fechaNacimiento = leerUsuarios.get(4);
                String sexo = leerUsuarios.get(5);
                String segmento = leerUsuarios.get(6);
                String nacionalidad = leerUsuarios.get(7);
                String rfc = leerUsuarios.get(8);
                String tipoID = leerUsuarios.get(9);
                String numeroID = leerUsuarios.get(10);
                String cuenta = leerUsuarios.get(11);
                String email = leerUsuarios.get(12);
                
                
                usuarios.add(new Usuario(idCliente,nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,sexo,segmento,nacionalidad,rfc,tipoID,numeroID,cuenta,email));
                
            }
            leerUsuarios.close();
            
            
        }catch(FileNotFoundException e){
        } catch (IOException ex) {
            
        }
        
        return usuarios;
    }

    private static void insertarMySQL(List<Usuario> usuarios) {
        //ConexionMySql sql = new ConexionMySql();
        Connection con = ConexionMySql.getConnection();
        
        String query ="INSERT INTO clientes(idCLIENTE,nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,sexo,segmento,nacionalidad,rfc,tipoID,numeroID,cuenta,email) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con.setAutoCommit(false);
            stmt = con.prepareStatement(query);
            for(int i = 0 ;i < usuarios.size();i++){
                stmt.setString(1,usuarios.get(i).getIdCliente());
                stmt.setString(2,usuarios.get(i).getNombre());
                stmt.setString(3,usuarios.get(i).getApellidoPaterno());
                stmt.setString(4,usuarios.get(i).getApellidoMaterno());
                stmt.setString(5,usuarios.get(i).getFechaNacimiento());
                stmt.setString(6,usuarios.get(i).getSexo());
                stmt.setString(7,usuarios.get(i).getSegmento());
                stmt.setString(8,usuarios.get(i).getNacionalidad());
                stmt.setString(9,usuarios.get(i).getRfc());
                stmt.setString(10,usuarios.get(i).getTipoID());
                stmt.setString(11,usuarios.get(i).getNumeroID());
                stmt.setString(12,usuarios.get(i).getCuenta());
                stmt.setString(13,usuarios.get(i).getEmail());
                stmt.addBatch();
                
                if(i%5000==0){
                    stmt.executeBatch();
                    con.commit();
                }
             
            }
            
       
           con.close();
           stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
}
