package mouton;

import java.util.ArrayList;
import java.util.List;

public class JeuMouton implements Jeu {
	protected int idxVide;
	protected Case[] jeu;
	public final int SIZE; 


	JeuMouton(int size){
		if(size%2!=1 ||size<0){
			SIZE=9;
		}else{
			SIZE=size;
		}
		jeu=new Case[SIZE];
		idxVide=(SIZE-1)/2;
		jeu[idxVide]=Case.VIDE;
		for(int i=0;i<idxVide;i++){
			jeu[i]=Case.DROIT;
		}
		for(int i=SIZE-1;i>idxVide;i--){
			jeu[i]=Case.GAUCHE;
		}
	}

	@Override
	public List<Integer> coupsPossibles() {
		ArrayList<Integer> res=new ArrayList<Integer>();
		for(int i=0;i<SIZE;i++){
			if(ok(i)){
				res.add((Integer)i);
			}
		}
		return res;
	}

	@Override
	public void executer(int coup) {
		idxVide=coup;
		if(jeu[coup].equals(Case.DROIT)){
			if(jeu[coup+1].equals(Case.VIDE)){
				jeu[coup+1]=Case.DROIT;
				jeu[coup]=Case.VIDE;
				
			}else if(jeu[coup+2].equals(Case.VIDE)){
				jeu[coup+2]=Case.DROIT;
				jeu[coup]=Case.VIDE;
			}
		}else if(jeu[coup].equals(Case.GAUCHE)){
			if(jeu[coup-1].equals(Case.VIDE)){
				jeu[coup-1]=Case.GAUCHE;
				jeu[coup]=Case.VIDE;
			}else if(jeu[coup-2].equals(Case.VIDE)){
				jeu[coup-2]=Case.GAUCHE;
				jeu[coup]=Case.VIDE;
			}
		}

	}

	@Override
	public boolean gagnant() {
		boolean res=true;
		//Si on a un mouton DROIT a gauche
		for(int i=0;i<(SIZE-1)/2;i++){
			if(jeu[i].equals(Case.DROIT)){
				res=false;
			}
		}

		//SI on a un mouton GAUCHE a droite
		for(int i=SIZE-1;i>(SIZE-1)/2;i--){
			if(jeu[i].equals(Case.GAUCHE)){
				res=false;
			}
		}
		return res;
	}

	@Override
	public boolean perdant() {
		if(coupsPossibles().isEmpty()){
			return true;
		}
		return false;
	}

	@Override
	public Case getCase(int i) {
		return jeu[i];
	}

	protected boolean ok(int c){
		if(jeu[c].equals(Case.DROIT)){
			if(c+1<SIZE){
				if(jeu[c+1].equals(Case.VIDE)){
					return true;
				}
			}
			if(c+2<SIZE){
				if(jeu[c+2].equals(Case.VIDE)){
					return true;
				}
			}
		}else if(jeu[c].equals(Case.GAUCHE)){
			if(c>0){
				if(jeu[c-1].equals(Case.VIDE)){
					return true;
				}
			}if(c>1){
				if(jeu[c-2].equals(Case.VIDE)){
					return true;
				}
			}
		}else{
				return false;
		}
		return false;
	}
}
