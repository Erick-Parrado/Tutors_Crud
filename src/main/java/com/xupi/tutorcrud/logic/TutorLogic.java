/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xupi.tutorcrud.logic;

import com.xupi.tutorcrud.persistance.TutorDTO;

/**
 *
 * @author erick
 */
public class TutorLogic extends TutorDTO{
    public TutorLogic(int id, String name, String phone, boolean isDirector, int houseId) {
        super(id, name, phone, isDirector, houseId);
    }
    
    public TutorLogic(){
        super();
    }
    
    public void catchDirectorAsign(char option){
        if(option == 'S'){
            
        }
        else if(option == 'N'){
            
        }
    }
}
