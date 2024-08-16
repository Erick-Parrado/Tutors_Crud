 
package com.xupi.tutorcrud.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class DBConnection {
    private String user;
    private String password;
    private String dataBase;
    private String server;
    private String port;
    private String strConnection;
    private Connection con;
    private static DBConnection instance;
    
    private DBConnection(){
        this.user = "root";
        this.password = "";
        this.dataBase = "comarcas_xupi";
        this.server = "localhost";
        this.port = "3306";
        this.strConnection = "jdbc:mysql//:"+this.server+":"+this.port+"/"+this.dataBase;
        this.con = null;
    }
    
    private Connection connectionToDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(this.strConnection,this.user,this.password);
            JOptionPane.showMessageDialog(null, "Conexion exitosa");
        }catch(Exception e){
            System.out.print(e);
            JOptionPane.showMessageDialog(null, "Conexion inexitosa");   
        }
        
        return this.con;
    }
    
    public Connection getConnectionToBD(){
        return this.connectionToDB();
    }
    
    //Sigleton
    public static DBConnection get(){
        if(instance == null){
            instance = new DBConnection();
        }
        return instance;
    }
}
