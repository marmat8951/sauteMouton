package mouton;

public class Testjeu {
	Joueur joueur;
    Jeu jeu;
	public Testjeu(){
		jeu=new JeuMouton(9);
	}
	
	public static void main(String args[]){
		Testjeu j=new Testjeu();
		j.run();
		
	}
	
	private void affichageJeu(){
		JeuMouton jm=(JeuMouton)jeu;
		int tailleAAfficher=jm.SIZE;
		String txt="";
		for(int i=0;i<tailleAAfficher;i++){
			txt+=jeu.getCase(i).toString();
		}
		System.out.println(txt);
	}
	
	private void run(){
		jeu=new JeuMouton(9);
		joueur=new JoueurHumain();
		do{
			affichageJeu();
			jeu.executer(joueur.coupAJouer(jeu.coupsPossibles()));
		}while(!jeu.gagnant()&&!jeu.perdant());
		if(jeu.gagnant()){
			System.out.println("LE JOUEUR A GAGNE!");
			affichageJeu();
		}else{
			System.out.println("LE JOUEUR A PERDU!");
			affichageJeu();
		}
	}
		
	
}
