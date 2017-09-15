package mouton;

public enum Case {
	DROIT,GAUCHE,VIDE;
	
	public String toString(){
		String res="";
		if(this.equals(DROIT)){
			res+='>';
		}else if(this.equals(GAUCHE)){
			res+='<';
		}else{
			res+=' ';
		}
		return res;
	}
}
