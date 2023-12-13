package ep;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Produit
{
 	String nom;
    String type;
    String categorie;
    int prix;

    public Produit(){}
     public Produit(String nomproduit,String tp,String ca,int pr)
 	{
 		this.nom=nomproduit;
 		this.type=tp;
        this.categorie=ca;
        this.prix=pr;
    }

 	public String getnom()
 	{
 		return this.nom;
 	}
 	public void setnom(String nomproduit)
 	{
 		this.nom=nomproduit;
 	}
    public String gettype()
 	{
 		return this.type;
 	}
 	public void settype(String tp)
 	{
 		this.type=tp;
 	}
    public String getcategorie()
 	{
 		return this.categorie;
 	}
 	public void setcategorie(String ca)
 	{
 		this.categorie=ca;
 	}public int getprix()
 	{
 		return this.prix;
 	}
 	public void setprix(int pr)
 	{
 		this.prix=pr;
 	}

    public void insertProduit(Connexion c, Produit p) throws Exception 
    {
        try (Connection con = (Connection) c.miconnect();
        Statement statement = con.createStatement()) {
                String insertionP = "INSERT INTO produit (nom, idtype, idcategorie, prix) VALUES ('" +
                                    p.getnom() + "','" + p.gettype() + "','" +
                                    p.getcategorie() + "','" + p.getprix() + "')";
                statement.executeUpdate(insertionP);
                System.out.println("Produit inséré avec succès.");
            } catch (Exception e) {
                throw e;
            }
    }
    
    public List<Produit> makaProduit(Connexion c) throws Exception {
        List<Produit> produits = new ArrayList<>();

        try (Connection con = (Connection) c.miconnect();
             Statement statement = con.createStatement()) {

            String requete = "SELECT * FROM v_produit";
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Produit p = new Produit();
                p.setnom(resultat.getString("nom"));
                p.settype(resultat.getString("type"));
                p.setcategorie(resultat.getString("categorie"));
                p.setprix(resultat.getInt("prix"));
                produits.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Tsy azo le view");
        }

        return produits;
    }
 }