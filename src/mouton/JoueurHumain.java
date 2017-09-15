package mouton;

import java.util.List;
import java.util.Scanner;

public class JoueurHumain implements Joueur{
	public JoueurHumain(){
		
	}
	@Override
	public int coupAJouer(List<Integer> possibles) {
		System.out.println("Coup(s) possible(s):");
		for(int i=0;i<possibles.size();i++){
			System.out.println(possibles.get(i));
		}
		System.out.println("Quel coup voulez vous jouer?");
		String s;
		Scanner sc=new Scanner(System.in);
		Integer choix=-1;
		do{
			s=sc.nextLine();
			if(estUnNombre(s)){
			choix=Integer.parseInt(s);
			}else{
				System.err.println("Si vous voulez jouer, il faut respecter ce qui est demandé!");
				System.err.println(s+" n'est pas un nombre!");
			}
		}while(!possibles.contains(choix));
		
		return choix;
	}
	
	public boolean estUnNombre(String s){
		boolean res=true;
		if(s.length()==0){
			return false;
		}
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if(c>'9'){
				res=false;
			}if(c<'0'){
				res=false;
			}
		}
		return res;
		
	}

}
