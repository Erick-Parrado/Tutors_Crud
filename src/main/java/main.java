/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.xupi.tutorcrud.persistance.DBConnection;
/**
 *
 * @author erick
 */
public class main {
    public static void main(String args[]){
        DBConnection cdb = DBConnection.get();
        cdb.getConnectionToBD();
    }
}
