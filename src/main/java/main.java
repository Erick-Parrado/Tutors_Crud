import com.xupi.tutorcrud.logic.TutorLogic;
import com.xupi.tutorcrud.persistance.DBConnection;
import com.xupi.tutorcrud.persistance.TutorDAO;
import com.xupi.tutorcrud.persistance.TutorDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
/**
 *
 * @author erick
 */
public class main {
    public static Scanner reader = new Scanner(System.in);
    
    public static void main(String args[]){
        DBConnection cdb = DBConnection.get();
        cdb.getConnectionToBD();
        
        int option;
        
        System.out.println("Tutors CRUD Main Menu");
        do{
        System.out.println("1. Crear\n"
                + "2. Listado\n"
                + "3. Actualizar\n"
                + "4. Eliminar"
                + "0. Salir");
                option = reader.nextInt();
                switch(option){
                    case 1:
                        break;
                    case 2:
                        
                        break;
                }
        }while(option != 0);
        System.out.println("Fin del programa");
    }
    
    public void createTutorForm(){
        TutorLogic newTutor = new TutorLogic();
        System.out.println("Nombre:");
        newTutor.setName(reader.nextLine());
        System.out.println("Telefono:");
        newTutor.setPhone(reader.nextLine());
        System.out.println("Director(S/N):");
        newTutor.setName(reader.nextLine());
        System.out.println("Id Casa (1-5):");
        newTutor.setHouseId(reader.nextInt());
        newTutor.sendToCreate();
    }
    
    public void printTutorsList(){
        Iterator<TutorDTO> AllTutors = TutorDAO.get().readAll().iterator();
        System.out.println("Tutores");
        System.out.println("{ id, nombre , telefono , puesto, id casa }");
        while(AllTutors.hasNext()){
           TutorLogic current = new TutorLogic(AllTutors.next());
           System.out.print(current.toString());
        }
    }
    
    public void updateTutorForm(){
        System.out.println("Id:");
        TutorLogic tutor = new TutorLogic(reader.nextInt());
        System.out.println("Nombre:"+tutor.getName());
        tutor.setName(reader.nextLine());
        System.out.println("Telefono:"+tutor.getPhone());
        tutor.setPhone(reader.nextLine());
        System.out.println("Director(S/N):"+tutor.getIsDirector());
        tutor.catchDirectorAsign(reader.nextLine());
        System.out.println("Id Casa (1-5):"+tutor.getHouseId());
        tutor.setHouseId(reader.nextInt());
        tutor.sendToUpdate();
    }
    
    public void deleteTutorForm(){
        System.out.println("Id:");
        TutorLogic tutor = new TutorLogic(reader.nextInt());
        System.out.print(tutor.toString());
        System.out.println("Confirmar eliminacion (S/N):");
        tutor.sendToDelete(reader.nextLine());
    }
}
