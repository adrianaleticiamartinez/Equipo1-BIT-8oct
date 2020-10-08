/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.readcsv;

/**
 *
 * @author edgar
 */
public class Usuario {
    String idCliente;
    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;
    String fechaNacimiento;
    String sexo;
    String segmento;
    String nacionalidad;
    String rfc;
    String tipoID;
    String numeroID;
    String cuenta;
    String email;

    public Usuario(String idCliente, String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, String sexo, String segmento, String nacionalidad, String rfc, String tipoID, String numeroID, String cuenta, String email) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.segmento = segmento;
        this.nacionalidad = nacionalidad;
        this.rfc = rfc;
        this.tipoID = tipoID;
        this.numeroID = numeroID;
        this.cuenta = cuenta;
        this.email = email;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTipoID() {
        return tipoID;
    }

    public void setTipoID(String tipoID) {
        this.tipoID = tipoID;
    }

    public String getNumeroID() {
        return numeroID;
    }

    public void setNumeroID(String numeroID) {
        this.numeroID = numeroID;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   
  
    
}
