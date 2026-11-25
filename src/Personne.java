import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Personne {
    private int id;
    private String nom;
    private String prenom;

    public Personne(String n, String p){
        this.nom=n;
        this.prenom=p;
        this.id=-1;
    }

    public ArrayList<Personne> findAll() throws SQLException {
        ArrayList<Personne> liste = new ArrayList<Personne>();
        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("select * from Personne");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String nom = resultSet.getString("nom");
            String prenom = resultSet.getString("prenom");

            Personne p = new Personne(nom, prenom);
            p.id = id;
            liste.add(p);
        }
        return liste;
    }

    public Personne findById(int num) throws SQLException {
        Personne p = null;
        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement ps = connection.prepareStatement("select * from Personne where id=?");
        ps.setInt(1, num);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            p = new Personne(rs.getString("nom"), rs.getString("prenom"));
            p.setId(rs.getInt("id"));
        }
        return p;
    }


    public ArrayList<Personne> findByName(String n) throws SQLException {
        ArrayList<Personne> liste = new ArrayList<Personne>();
        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement ps = connection.prepareStatement("select * from Personne where name = ?");
        ps.setInt(1, n);
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String nom = resultSet.getString("nom");
            String prenom = resultSet.getString("prenom");

            Personne p = new Personne(nom, prenom);
            p.id = id;
            liste.add(p);
        }
        return liste;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setId(int id) {
        this.id = id;
    }
}
