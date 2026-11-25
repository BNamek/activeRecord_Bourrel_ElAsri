import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection db=null;
    private Connection connection = null;
    private String url = "jdbc:mysql://127.0.0.1:3306/";
    private String nomDB = "testpersonne";
    private String user = "root";
    private String password = "";

    private DBConnection(){

    }

    public static DBConnection getInstance(){
        if(db == null){
            return db = new DBConnection();
        }else{
            return db;
        }
    }

    public Connection getConnection() throws SQLException {
        if (this.connection == null){
            this.connection = DriverManager.getConnection(this.url + this.nomDB,this.user,this.password);
            return this.connection;
        }else{
            return this.connection;
        }
    }

    public void setNomDB(String nom) throws SQLException {
        this.nomDB = nom;

        if (this.connection != null){
            this.connection.close();
            this.connection = null;
        }

    }


}
