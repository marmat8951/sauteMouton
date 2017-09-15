package mouton;

import java.util.List;

public interface Jeu {
	
	public List<Integer> coupsPossibles(); 
	public void executer(int coup);
	public boolean gagnant();
	public boolean perdant();
	public Case getCase(int i);
}
