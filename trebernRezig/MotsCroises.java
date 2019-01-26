package trebernRezig;

public class MotsCroises extends Grille{
	private char[][] solution;
	private char[][] proposition;
	private String[][] vertical;
	private String[][] horizontal;
	private boolean[][] noire;
	
	
	public MotsCroises(int hauteur, int largeur) {
		super(hauteur,largeur);
		this.horizontal = new String[hauteur][largeur];
		this.vertical = new String[hauteur][largeur];
		this.solution = new char[hauteur][largeur];
		this.proposition = new char[hauteur][largeur];
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
		assert(coordCorrectes(lig-1, col-1));
		return noire[lig-1][col-1];
	}
	public void setCaseNoire(int lig, int col, boolean noir) {
		assert(coordCorrectes(lig-1, col-1));
		noire[lig-1][col-1]=noir;
	}
	// Accesseurs � la grille de solution
	// Pr�conditions (assert) :
		//coordCorrectes(lig, col)
		//!estCaseNoire(lig, col)
	public char getSolution(int lig, int col) {
		assert(coordCorrectes(lig-1, col-1));
		assert(!estCaseNoire(lig, col));
		return solution[lig-1][col-1];
	}
	public void setSolution(int lig, int col, char sol) {
		assert(coordCorrectes(lig-1, col-1));
		assert(!estCaseNoire(lig, col));
		solution[lig-1][col-1] = sol;
	
	}
	// Accesseurs � la grille du joueur
	// Pr�conditions : idem
	public char getProposition(int lig, int col) {
		assert(coordCorrectes(lig-1, col-1));
		assert(!estCaseNoire(lig, col));
		return proposition[lig-1][col-1];
	}
	public void setProposition(int lig, int col, char prop) {
		assert(coordCorrectes(lig-1, col-1));
		assert(!estCaseNoire(lig, col));
		proposition[lig-1][col-1]=prop;
		
	}
	// Accesseurs aux d�finitions.
	// Le param�tre "horiz" est "true" pour les d�finitions
	// horizontales, "false" pour les d�finitions verticales.
	// Pr�conditions : idem
	public String getDefinition(int lig, int col, boolean horiz) {
		assert(coordCorrectes(lig-1, col-1));
		assert(!estCaseNoire(lig, col));
		if(horiz) {
			return horizontal[lig-1][col-1];
		}else
		return vertical[lig-1][col-1];
		
	}
	public void setDefinition(int lig, int col, boolean horiz, String def) {
		assert(coordCorrectes(lig-1, col-1));
		assert(!estCaseNoire(lig, col));
		if(horiz) {
			horizontal[lig-1][col-1]=def;
		}else
		vertical[lig-1][col-1]=def;
		
	}

	
}
