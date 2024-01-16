import java.util.List;

import ep.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Connexion c = new Connexion();

        // Produit p = new Produit();
        // List<Produit> l_p = p.makaProduit(c);

        // for (int j = 0; j < l_p.size(); j++) {
            
        //     System.out.println(l_p.get(j).getNom()+ ", idcategorie : "+l_p.get(j).getCategorie()+", prix : "+l_p.get(j).getPrix());
        // }

        // Categorie ca = new Categorie();
        // List<Categorie> l_ca = ca.getPrixCate(c);
        // for (int i = 0; i < l_ca.size(); i++) {
        //     System.out.println(l_ca.get(i).getIdCategorie() +"   "+l_ca.get(i).getPrix());
        // }

        // System.out.println(ca.getCoefIdCate(c, 3));

        // int idCategorie = 2;
        // int initialPrice = 1000;
        // int finalPrice = ca.getPrixParIdCate(idCategorie);
        // System.out.println("Final price for idCategorie " + idCategorie + " is: " + finalPrice);

        // System.out.println("val filter.... "+p.filter(c, null, 3).size());
    
    }
}
