// package ep;

// import java.sql.*;

// public class Categorie
// {
//     int idcategorie;
//  	String nom;

//     public Categorie(int idcategorie, String nom) {
// 		this.idcategorie = idcategorie;
// 		this.nom = nom;
// 	}

// 	public int getIdcategorie() {
// 		return idcategorie;
// 	}

// 	public void setIdcategorie(int idcategorie) {
// 		this.idcategorie = idcategorie;
// 	}

// 	public String getNom() {
// 		return nom;
// 	}

// 	public void setNom(String nom) {
// 		this.nom = nom;
// 	}

//     public int makaIdCa(String nom) throws Exception {
//         Connexion connect=new Connexion();
//         Connection con=connect.connecter();
//         Statement statement = con.createStatement();
//         String requete = "SELECT idcategorie FROM Categorie WHERE nom = ?";
//         ResultSet resultat = statement.executeQuery(requete);
        
//         int idCa = 0;
        
//         if (result.next()) {
//             idCa = result.getInt("idcategorie");
//         }
        
//         return idCa;
//         con.close();
//         statement.close();
//         resultat.close();
//     }
// }