// package ep;
// public class Type
 
//  {
//  	int idtype;
//     String nom;
//     public Type(int id,String nomtype)
//  	{
//  		this.idtype=id;
//  		this.nom=nomtype;
//     }
   
//  	public int getid()
//  	{
//  		return this.idtype;
//  	}
//  	public void setid(String id)
//  	{
//  		this.idtype=id;
//  	}
//  	public String getnom()
//  	{
//  		return this.nom;
//  	}
//  	public void setnom(String nomtype)
//  	{
//  		this.nom=nomproduit;
//  	}

//     public int makaIdType(String nom) throws Exception {
//         Connexion connect=new Connexion();
//         Connection con=connect.connecter();
//         Statement statement = con.createStatement();
//         String requete = "SELECT idtype FROM Categorie WHERE nom = ?";
//         ResultSet resultat = statement.executeQuery(requete);
        
//         int idTp = 0;
        
//         if (result.next()) {
//             idTp = result.getInt("idtype");
//         }
    
//         return idTp;
//         con.close();
//         statement.close();
//         resultat.close();
//     }
//  }
