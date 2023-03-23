package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentite(String acheteur){
		return controlVerifierIdentite.verifierIdentite(acheteur);
	}
	public Gaulois [] vendeurPro(String produit){
		return village.rechercherVendeursProduit(produit);
	}
	public String nomVendeur(String produit ,int numero) {
		return vendeurPro(produit)[numero-1].getNom();
	}
	public boolean produitIndispo(String produit) {
		return vendeurPro(produit)==null;	
	}
	public String afficherProduit(String produit) {
		StringBuilder chaine = new StringBuilder();
		Gaulois[] gauloisProduit;
		gauloisProduit = vendeurPro(produit);
		for (int i = 0; i < gauloisProduit.length; i++) {
			chaine.append(i + 1 + " - " + gauloisProduit[i].getNom() + "\n");
		}
		return chaine.toString();
	}

	
	public String acheterProduit(String produit, int numero, int quantite, String nomAcheteur) {
		StringBuilder chaine = new StringBuilder();
		Gaulois[] gauloisProduit;
		Gaulois gaulois;
		Etal etal;
		int resultat;
		String nomVendeur;
		nomVendeur = nomVendeur(produit, numero);
		gauloisProduit = vendeurPro(produit);
		gaulois = gauloisProduit[numero - 1];
		etal = village.rechercherEtal(gaulois);
		resultat = etal.acheterProduit(quantite);
		if (resultat == 0) {
			chaine.append(
					nomAcheteur + " veut acheter " + quantite + " " + produit + " malheureusement il n y en a plus\n");
		} else if (resultat < quantite) {
			chaine.append(nomAcheteur + " veut acheter " + quantite + " " + produit
					+ " malheureusement il n y en a pas suffisament\n" + nomAcheteur + " a acheter les " + resultat
					+ " derniers.\n");
		} else {
			chaine.append(nomAcheteur + " a acheter " + resultat + " " + produit + " a " + nomVendeur + ".\n");
		}
		return chaine.toString();
	}
	
	
}