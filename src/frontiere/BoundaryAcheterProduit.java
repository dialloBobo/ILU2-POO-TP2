package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		String marchant,produit ;
		int numMarchant, nbProduit;
		
		System.out.println("Quel produit voulez vous acheter?");
		produit=scan.next();
		boolean produitIndispo = controlAcheterProduit.produitIndispo(produit);
	
		if (produitIndispo) {
			System.out.println("desolé mais personne ne vend ce produit au marché\n");
		}
		else {
			marchant= controlAcheterProduit.afficherProduit(produit);
		
		String nomVendeur;
		numMarchant =Clavier.entrerEntier("chez quel marchant voulez vous acheter des" + produit + "?\n" + marchant);
		nbProduit =Clavier.entrerEntier("Bonjour" + nomAcheteur + "combien de "+produit+ "voulez vous?\n");
		System.out.println(controlAcheterProduit.acheterProduit( produit , numMarchant ,nbProduit ,nomAcheteur));
	}
	}
}
