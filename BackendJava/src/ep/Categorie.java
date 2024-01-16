package ep;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Categorie
{
    int idCategorie;
 	String nom;
    int prix;
    int coef;

    public int getCoef() {
        return coef;
    }
    public void setCoef(int coef) {
        this.coef = coef;
    }
    public int getPrix() {
        return prix;
    }
    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Categorie () {}
    public Categorie(int idCategorie, String nom) {
		this.idCategorie = idCategorie;
		this.nom = nom;
	}
    
    public Categorie(int idCategorie, String nom, int prix) {
		this.idCategorie = idCategorie;
		this.nom = nom;
        this.prix = prix;
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

    public List<Categorie> makaCategorie(Connexion c) throws Exception {
        List<Categorie> Categories = new ArrayList<>();

        try (Connection con = (Connection) c.miconnect();
             Statement statement = con.createStatement()) {

            String requete = "SELECT * FROM Categorie";
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Categorie p = new Categorie();
                p.setIdCategorie (resultat.getInt("idCategorie"));
                p.setNom(resultat.getString("nom"));
                Categories.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Tsy azo le Categorie");
        }

        return Categories;
    }

    public List<Categorie> getPrixCate(Connexion c) throws Exception
    {
        List<Categorie> l_val = new ArrayList<>();
        List<Categorie> catss = this.makaCategorie(c);
        int initialPrice = 1000;

        for (int i = 0; i < catss.size(); i++) {
            
            Categorie ca = new Categorie();
            ca.setIdCategorie(catss.get(i).getIdCategorie());
            ca.setNom(catss.get(i).getNom());

            int price = initialPrice;
            for (int j = catss.size() - 1; j > i; j--) {
                price *= 3;
            }
            ca.setPrix(price);

            l_val.add(ca);
        }

        return l_val;
    }

    public int getPrixParIdCate(Connexion c, int idCategorie) throws Exception
    {
        int price = 0;

        List<Categorie> l_val = this.getPrixCate(c);

        for (int i = 0; i < l_val.size(); i++) {
            if (l_val.get(i).getIdCategorie() == idCategorie) {
                price = l_val.get(i).getPrix();
            }
        }
        return price;
    }

    public int getCoefIdCate(Connexion c, int idCategorie) throws Exception 
    {
        int val = 0;

        try (Connection con = (Connection) c.miconnect();
             Statement statement = con.createStatement()) {

            String requete = "SELECT * FROM Categorie where idCategorie="+idCategorie;
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                val = resultat.getInt("coef");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Tsy azo le coef");
        }

        return val;
    }
}