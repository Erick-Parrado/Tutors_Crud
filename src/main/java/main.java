import com.xupi.tutorcrud.logic.TutorLogic;
import com.xupi.tutorcrud.persistance.DBConnection;
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
        
    }
    
    public void printTutorsList(){
        
    }
    
    public void updateTutorForm(){
        
    }
    
    public void deleteTutorForm(){
        
    }
}
