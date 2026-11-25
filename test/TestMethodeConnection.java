import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class TestMethodeConnection {
    @Test
    public void testgetInstance(){
        DBConnection dbc = DBConnection.getInstance();
        DBConnection dbc2 = DBConnection.getInstance();

        assertTrue(dbc==dbc2);

    }

    @Test
    public void testgetConnection() throws SQLException {
        Connection con1;
        Connection con2;

        DBConnection dbc = DBConnection.getInstance();
        con1 = dbc.getConnection();

        DBConnection dbc2 = DBConnection.getInstance();
        con2 = dbc2.getConnection();

        assertNotNull(con1,"La connexion avec la base de donnés ne dois pas etre null");

        assertTrue(con1 == con2,"Les 2 connexion doivent être identique");
    }

    @Test
    public void testSetNomDB() throws SQLException {

        DBConnection dbc = DBConnection.getInstance();
        Connection con1 = dbc.getConnection();

        dbc.setNomDB("test");
        Connection con2 = dbc.getConnection();

        assertTrue(con1 != con2,"Les connexions doivent etre differentes");
        assertTrue( con1.isClosed(),"La connexions 1 doit etre close");

        assertFalse(con2.isClosed(),"La connexion 2 doit etre ouverte");
    }

}
