/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xupi.tutorcrud.logic;

import com.xupi.tutorcrud.persistance.TutorDAO;
import com.xupi.tutorcrud.persistance.TutorDTO;

/**
 *
 * @author erick
 */
public class TutorLogic extends TutorDTO{
    private static TutorDAO DAO;
    public TutorLogic(int id, String name, String phone, boolean isDirector, int houseId) {
        super(id, name, phone, isDirector, houseId);
    }
    
    public TutorLogic(){
        super();
    }
    
    public TutorLogic(int id){
        TutorDTO gottenTutor = DAO.read(id);
        this.id = gottenTutor.getId();
        this.name = gottenTutor.getName();
        this.phone = gottenTutor.getPhone();
        this.isDirector = gottenTutor.isDirector();
        this.houseId = gottenTutor.getHouseId();
    }
    
    public TutorLogic(TutorDTO DTO){
        super(DTO.getId(),DTO.getName(),DTO.getPhone(),DTO.isDirector(),DTO.getHouseId());
    }
    
    public String getIsDirector(){
        if(this.isDirector){
            return "Director";
        }
        else{
            return "Tutor";
        }
    }
    
    public void catchDirectorAsign(String option){
        if(option == "S"){
            this.setIsDirector(true);
        }
        else if(option == "N"){
            this.setIsDirector(false);
        }
    }
    
    public void sendToCreate(){
        if(this.houseId>5 || this.houseId<1){
            System.out.print("Solo se puede asignar de la casa 1 a la 5");
            return;
        }
        DAO.insert(this);
    }
    
    
    public void sendToUpdate(){
        if(this.houseId>5 || this.houseId<1){
            System.out.print("Solo se puede asignar de la casa 1 a la 5");
            return;
        }
        if(this.isDirector)
        DAO.update(this);
    }
    
    public void sendToDelete(String option){
        if(option == "S"){
            DAO.delete(this);
        }
        else if(option == "N"){
            System.out.print("Eliminacion cancelada");
        }
    }
    
    public void modName(String name){
        if(!(name == null || name == "")){
            this.name = name;
        }
    }
    
    public void modPhone(String phone){
        if(!(phone == null || phone == "")){
            this.phone = phone;
        }
    }
    
    public void modIdDirector(String option){
        if(!(option == "")){
            this.catchDirectorAsign(option);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(this.getId());
        sb.append(",");
        sb.append(this.getName());
        sb.append(",");
        sb.append(this.getPhone());
        sb.append(",");
        if(this.isDirector()){
            sb.append("Director");
        }
        else{
            sb.append("Tutor");
        }
        sb.append(",");
        sb.append(this.getHouseId());
        sb.append("}\n");
        return sb.toString();
    }
}
