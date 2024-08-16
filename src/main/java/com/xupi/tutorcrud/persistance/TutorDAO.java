/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xupi.tutorcrud.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author erick
 */
public class TutorDAO {
    private DBConnection DBC;
    private Connection con;
    private static TutorDAO instance;
    
    private TutorDAO(){
        this.DBC = DBConnection.get();
    }
    
    public static TutorDAO get(){
        if(instance == null){
            instance = new TutorDAO();
        }
        return instance;
    } 
    
    public void insert(TutorDTO tutor){
        this.con = DBC.getConnectionToBD();
        PreparedStatement statement = null;
        String query = "INSERT INTO tutors VALUES (NULL,?,?,?,?)";
        
        try{
            if(statement == null){
                statement = this.con.prepareStatement(query);
                statement.setString(1,tutor.getName());
                statement.setString(2,tutor.getPhone());
                statement.setBoolean(3,tutor.isDirector());
                statement.setInt(3,tutor.getHouseId());
                
                int response = statement.executeUpdate();
                if(response > 0) JOptionPane.showMessageDialog(null, "Tutor resgistrado");
            }
        }
        catch(Exception e){
            System.out.println(""+e.toString());
        }
    }
    public TutorDTO read(int id){
        this.con = DBC.getConnectionToBD();
        PreparedStatement statement = null;
        TutorDTO record = new TutorDTO();
        
        try{
            if(statement == null){
                String query = "SELECT * FROM tutors";
                ResultSet result = statement.executeQuery(query);
                
                while(result.next()){
                    record.setId(result.getInt("tuto_id"));
                    record.setName(result.getString("tuto_name"));
                    record.setPhone(result.getString("tuto_phone"));
                    record.setIsDirector(result.getBoolean("tuto_idDirector"));
                    record.setHouseId(result.getInt("hous_id"));
                    break;
                }
            }
            
        }
        catch(Exception e){
            System.out.println(""+e.toString());
        }
        return record;
    }
    
    public ArrayList<TutorDTO> readAll(){
        this.con = DBC.getConnectionToBD();
        PreparedStatement statement = null;
        ArrayList records = new ArrayList<TutorDTO>();
        
        try{
            if(statement == null){
                String query = "SELECT * FROM tutors";
                ResultSet result = statement.executeQuery(query);
                
                while(result.next()){
                    TutorDTO gotTutor = new TutorDTO();
                    
                    gotTutor.setId(result.getInt("tuto_id"));
                    gotTutor.setName(result.getString("tuto_name"));
                    gotTutor.setPhone(result.getString("tuto_phone"));
                    gotTutor.setIsDirector(result.getBoolean("tuto_idDirector"));
                    gotTutor.setHouseId(result.getInt("hous_id"));
                    
                    records.add(gotTutor);
                }
            }
        }
        catch(Exception e){
            System.out.println(""+e.toString());
        }
        return records;
    }
    
    public void update(TutorDTO tutor){
        this.con = DBC.getConnectionToBD();
        PreparedStatement statement = null;
        String query = "UPDATE tutors SET tuto_name=?,tuto_phone=?,tuto_isDirector=?, hous_id=?";
        
        try{
            if(statement == null){
                statement = this.con.prepareStatement(query);
                statement.setString(1,tutor.getName());
                statement.setString(2,tutor.getPhone());
                statement.setBoolean(3,tutor.isDirector());
                statement.setInt(4,tutor.getHouseId());
                
                int response = statement.executeUpdate();
                if(response > 0) JOptionPane.showMessageDialog(null, "Tutor "+tutor.getId()+" actualizado");
            }
        }
        catch(Exception e){
            System.out.println(""+e.toString());
        }
    }
    
        
    public void delete(TutorDTO tutor){
        this.con = DBC.getConnectionToBD();
        PreparedStatement statement = null;
        String query = "DELETE FROM tutors WHERE tuto_id=?";
        
        try{
            if(statement == null){
                statement = this.con.prepareStatement(query);
                statement.setInt(1,tutor.getId());
                
                int response = statement.executeUpdate();
                if(response > 0) JOptionPane.showMessageDialog(null, "Tutor "+tutor.getId()+" actualizado");
            }
        }
        catch(Exception e){
            System.out.println(""+e.toString());
        }
    }
}
