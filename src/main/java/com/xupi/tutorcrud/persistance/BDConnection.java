/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xupi.tutorcrud.persistance;

/**
 *
 * @author erick
 */
public class BDConnection {
    private String user;
    private String password;
    private String dataBase;
    private String server;
    private String port;
    private String strConnection;
    
    private BDConnection(){
        this.user = "root";
        this.password = "12345";
        this.dataBase = "comarcas_xupi";
        this.server = "localhost";
        this.port = "3306";
        
        this.strConnection = "jdbc:mysql//:"+this.server+":"+this.port+"/"+this.dataBase;
    }
}
