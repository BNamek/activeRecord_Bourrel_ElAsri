import java.sql.Connection;

public class DBConnection {
    private static DBConnection db=null;

    private DBConnection(){

    }

    public static DBConnection getInstance(){
        if(db == null){
            return db = new DBConnection();
        }else{
            return db;
        }
    }
}
