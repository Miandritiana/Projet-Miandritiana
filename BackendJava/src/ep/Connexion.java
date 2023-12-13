package ep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

    private Connection connexion;

    public Connection miconnect() throws Exception {
        String dbUrl = "jdbc:postgresql://localhost:5432/epicerie";
        String user = "root";
        String password = "root";

        try {
            connexion = DriverManager.getConnection(dbUrl, user, password);
            System.out.println("Connexion à PostgreSQL établie avec succès!");
            return connexion;
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à PostgreSQL:");
            e.printStackTrace();
            throw e;
        }
    }

    public Connection getConnexion() {
        return connexion;
    }

    public void close() {
        try {
            if (connexion != null && !connexion.isClosed()) {
                connexion.close();
                System.out.println("Connexion à PostgreSQL fermée.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la fermeture de la connexion à PostgreSQL:");
            e.printStackTrace();
        }
    }
}
