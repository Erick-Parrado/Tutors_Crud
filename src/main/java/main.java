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
