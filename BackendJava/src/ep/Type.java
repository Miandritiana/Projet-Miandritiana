package ep;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Type
{
 	int idType;
    String nom;

    public Type () {}
    public Type(int idType, String nom) {
        this.idType = idType;
        this.nom = nom;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Type> makaType(Connexion c) throws Exception {
        List<Type> types = new ArrayList<>();

        try (Connection con = (Connection) c.miconnect();
             Statement statement = con.createStatement()) {

            String requete = "SELECT * FROM type";
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Type p = new Type();
                p.setIdType (resultat.getInt("idType"));
                p.setNom(resultat.getString("nom"));
                types.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Tsy azo le type");
        }

        return types;
    }
 }
