package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (controlPrendreEtal.verifierIdentite (nomVendeur)) {
		
			System.out.println("Bonjour " + nomVendeur+ ",je vais regarder si je peux vous trouver un etal");
			
			controlPrendreEtal.resteEtals();
			
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("desol�e"+ nomVendeur + " je n'ai plus d'etal qui ne soit pas deja occup�");
			}		
			else{
				installerVendeur(nomVendeur);		
			}
		}	
		else{
			System.out.println("je suis desol�e "+ nomVendeur + " mais il faut �tre un habitant de notre village pour commencer ici");
			}	
		}
	
		

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait ,il me reste un etal pour vous!");
		System.out.println("Il me faudrait quelques renseignements:\n");
		System.out.println("Quel produit souhaitez-vous vendre?\n");
		String produit=scan.next();
		System.out.println("Combien de produit souhaitez-vous en vendre\n?");
		int nbProduit =Integer.parseInt(scan.next());
		System.out.println();
		int numeroEtal=controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		
		if (numeroEtal!=-1){ 
			System.out.println("le vendeur " + nomVendeur + " s'est installeé à l'etal n° "+ numeroEtal);
			
		}
	}
}
