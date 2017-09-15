package mouton;

import java.util.List;
import java.util.Random;

public class JoueurAlea implements Joueur {
	public JoueurAlea(){
		
	}
	@Override
	public int coupAJouer(List<Integer> possibles) {
		Random r=new Random();
		return possibles.get(r.nextInt(possibles.size()));
	}

}
