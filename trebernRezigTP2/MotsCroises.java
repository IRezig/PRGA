package trebernRezigTP2;

public class MotsCroises<T> extends Grille<T>{
	private Grille<?> solution;
	private Grille<?> proposition;
	private Grille<?> vertical;
	private Grille<?> horizontal;
	private boolean[][] noire;
	
	
	public MotsCroises(int hauteur, int largeur) {
		super(hauteur,largeur);
		this.horizontal = new Grille<Object>(hauteur,largeur);
		this.vertical = new Grille<Object>(hauteur,largeur);
		this.solution = new Grille<Object>(hauteur,largeur);
		this.proposition = new Grille<Object>(hauteur,largeur);
		this.noire = new boolean[hauteur][largeur];	
	}
	public int getHauteur() {
		return hauteur;
	}
	public int getLargeur() {
		return largeur;
	}
	public boolean coordCorrectes(int lig, int col) {
		return super.coordCorrectes(lig, col);
		//((lig >= 0 && this.getHauteur() > lig) && 
//				(col >= 0 && this.getLargeur() > col));
	}
	public boolean estCaseNoire(int lig, int col) {
		assert(coordCorrectes(lig, col));
		return noire[lig-1][col-1];
	}
	public void setCaseNoire(int lig, int col, boolean noir) {
		assert(coordCorrectes(lig, col));
		noire[lig-1][col-1]=noir;
	}
	// Accesseurs à la grille de solution
	// Préconditions (assert) :
		//coordCorrectes(lig, col)
		//!estCaseNoire(lig, col)
	public Object getSolution(int lig, int col) {
		assert(coordCorrectes(lig, col));
		assert(!estCaseNoire(lig, col));
		return solution.getCellule(lig, col);
	}
	public void setSolution(int lig, int col, Object sol) {
		assert(coordCorrectes(lig, col));
		assert(!estCaseNoire(lig, col));
		solution.setCellule(lig, col, sol);
	
	}
	// Accesseurs à la grille du joueur
	// Préconditions : idem
	public Object getProposition(int lig, int col) {
		assert(coordCorrectes(lig, col));
		assert(!estCaseNoire(lig, col));
		return proposition.getCellule(lig, col);
	}
	public void setProposition(int lig, int col, Object prop) {
		assert(coordCorrectes(lig, col));
		assert(!estCaseNoire(lig, col));
		proposition.setCellule(lig, col, prop);
		
	}
	// Accesseurs aux définitions.
	// Le paramètre "horiz" est "true" pour les définitions
	// horizontales, "false" pour les définitions verticales.
	// Préconditions : idem
	public Object getDefinition(int lig, int col, boolean horiz) {
		assert(coordCorrectes(lig, col));
		assert(!estCaseNoire(lig, col));
		if(horiz) {
			return horizontal.getCellule(lig, col);
		}else
		return vertical.getCellule(lig, col);
		
	}
	public void setDefinition(int lig, int col, boolean horiz, Object def) {
		assert(coordCorrectes(lig, col));
		assert(!estCaseNoire(lig, col));
		if(horiz) {
			horizontal.setCellule(lig, col, def);
		}else
		vertical.setCellule(lig, col, def);
		
	}
	
	
	public String solution() {
		return this.solution().toString();
	}
	
	@SuppressWarnings("unused")
	private String toString(char type, boolean horiz) {
		
		switch(type) {
		case 'S' : return this.solution.toString();
		case 'P' : return this.proposition.toString();
		case 'D' : 
			if(horiz) return this.horizontal.toString();
			else return this.vertical.toString();
		}
		
		return "erreur";
		
	}

	
}
