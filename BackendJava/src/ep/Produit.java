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
    int idType;
    int idCategorie;

    public Produit(){}
    public Produit(String nomproduit,String tp,String ca,int pr)
 	{
 		this.nom=nomproduit;
 		this.type=tp;
        this.categorie=ca;
        this.prix=pr;
    }

    public Produit(String nomproduit, int tp, int ca,int pr)
 	{
 		this.nom=nomproduit;
 		this.idType=tp;
        this.idCategorie=ca;
        this.prix=pr;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getCategorie() {
        return categorie;
    }
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    public int getPrix() {
        return prix;
    }
    public void setPrix(int prix) {
        this.prix = prix;
    }
    public int getIdType() {
        return idType;
    }
    public void setIdType(int type) {
        this.idType = type;
    }
    public int getIdCategorie() {
        return idCategorie;
    }
    public void setCategorie(int categorie) {
        this.idCategorie = categorie;
    }
 	

    public void insertProduit(Connexion c, Produit p) throws Exception 
    {
        Categorie ca = new Categorie();
        int coef = ca.getCoefIdCate(c, p.getIdCategorie());

        try (Connection con = (Connection) c.miconnect();
        Statement statement = con.createStatement()) {
                String insertionP = "INSERT INTO produit (nom, idtype, idcategorie, prix) VALUES ('" +
                                    p.getNom() + "'," + p.getIdType() + "," +
                                    p.getIdCategorie() + "," + p.getPrix()*coef + ")";
                System.out.println(insertionP);
                statement.executeUpdate(insertionP);
                System.out.println("Produit inséré avec succès.");
            } catch (Exception e) {
                throw e;
            }
    }
    
    public List<Produit> makaProduit(Connexion c) throws Exception {
        List<Produit> produits = new ArrayList<>();
        Categorie ca = new Categorie();

        try (Connection con = (Connection) c.miconnect();
             Statement statement = con.createStatement()) {

            String requete = "SELECT * FROM v_produit";
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Produit p = new Produit();
                p.setNom(resultat.getString("nom"));
                p.setType(resultat.getString("type"));
                p.setCategorie(resultat.getString("categorie"));
                p.setPrix(resultat.getInt("prix"));
                // p.setPrix((ca.getPrixParIdCate(c, resultat.getInt("idcategorie")))+(resultat.getInt("prix")));
                produits.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Tsy azo le view");
        }

        return produits;
    }

    public List<Produit> filter(Connexion c, Integer idType, Integer idCategorie) throws Exception {
        List<Produit> produits = new ArrayList<>();
        Categorie ca = new Categorie();

        try (Connection con = (Connection) c.miconnect();
             Statement statement = con.createStatement()) {
    
            String requete = "SELECT * FROM v_produit WHERE 1=1";
    
            if (idType != null) {
                requete += " AND idType = " + idType;
            }
    
            if (idCategorie != null) {
                requete += " AND idCategorie = " + idCategorie;
            }
    
            ResultSet resultat = statement.executeQuery(requete);
    
            while (resultat.next()) {
                Produit p = new Produit();
                p.setNom(resultat.getString("nom"));
                p.setType(resultat.getString("type"));
                p.setCategorie(resultat.getString("categorie"));
                p.setPrix(resultat.getInt("prix"));
                // p.setPrix((ca.getPrixParIdCate(c, resultat.getInt("idcategorie")))+(resultat.getInt("prix")));
                produits.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Tsy azo le view");
        }
    
        return produits;
    }

    public List<Produit> search(Connexion c, Integer idType, Integer min, Integer max) throws Exception {
        List<Produit> produits = new ArrayList<>();
        Categorie ca = new Categorie();
    
        try (Connection con = (Connection) c.miconnect();
             Statement statement = con.createStatement()) {
    
            String requete = "SELECT * FROM v_produit ";
            boolean hasCondition = false;
    
            if (idType != 0 || min != 0 || max != 0) {
                requete += " WHERE";
            }

            if (idType != 0) {
                requete += " idType = " + idType;
                hasCondition = true;
            }
    
            if (min != 0) {
                if (hasCondition) {
                    requete += " AND ";
                }
                requete += " prix >= " + min;
                hasCondition = true;
            }
    
            if (max != 0) {
                if (hasCondition) {
                    requete += " AND ";
                }
                requete += " prix <= " + max;
            }
    
            System.out.println(requete);
            ResultSet resultat = statement.executeQuery(requete);
    
            while (resultat.next()) {
                Produit p = new Produit();
                p.setNom(resultat.getString("nom"));
                p.setType(resultat.getString("type"));
                p.setCategorie(resultat.getString("categorie"));
                p.setPrix(resultat.getInt("prix"));
                produits.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("TSISY ARGUMENT HITEDAVANA AZY....!!!");
        }
    
        return produits;
    }
    
    
    
 }