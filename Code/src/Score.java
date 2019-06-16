
public class Score implements Comparable<Score>{

	private int temps;
	private String nom;
	
	Score(int temps, String nom){
		this.temps=temps;
		this.nom=nom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getTemps() {
		return temps;
	}
	
	@Override
	public String toString() {

		return nom+" "+temps;
	}

	@Override
	public int compareTo(Score o) {
		return o.getTemps() - this.getTemps();
	}
	
}
