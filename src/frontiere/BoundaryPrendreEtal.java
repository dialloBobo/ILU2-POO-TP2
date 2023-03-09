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
			System.out.println("je suis desolée "+ nomVendeur + " mais il faut être un habitant de notre village pour commencer ici");
			}
		else{
			System.out.println("Bonjour " + nomVendeur+ ",je vais regarder si je peux vous trouver un etal");
			
			controlPrendreEtal.resteEtals();
			
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("desolée"+ nomVendeur + " je n'ai plus d'etal qui ne soit pas deja occupé");
			}
					
			installerVendeur(nomVendeur);
					
				
			}
		}
	
		

	private void installerVendeur(String nomVendeur) {
		System.out.println("c'est parfait ,il me reste un etal pour vous!");
		System.out.println("il me faudrait quelques renseignements:");
		System.out.println("quel produit souhaitez-vous vendre?");
		String produit=scan.next();
		System.out.println("combien de produit souhaitez-vous en vendre?");
		int nbProduit =scan.nextInt();
		System.out.println();
		int numeroEtal=controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		
		if (numeroEtal!=-1){ 
			System.out.println("le vendeur" + nomVendeur + "s'est installé à l'etal n"+ numeroEtal);
			
		}
	}
}
