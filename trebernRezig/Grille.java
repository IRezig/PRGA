package trebernRezig;
public class Grille implements Grilles{
	// Variables d’instance
	//nombre de lignes
	protected int hauteur;
	// largeur = nombre de colonnes
	protected int largeur;
	// tab = tableau de chaînes de caractères à 2 dimensions,
	private String[][] tab;
	private int taille;
	
	public Grille (int hauteur, int largeur) {
		assert(hauteur >= 0 && largeur >= 0);
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.taille = hauteur*largeur;
		this.tab = new String[hauteur][largeur];
	}
	// Accesseurs (getters)
	public int getHauteur() {
		return hauteur;
	}
	public int getLargeur() {
		return largeur;
	}
	// Validité des coordonnées
	// Resultat : vrai si et seulement si (lig, col)
	// désignent une cellule existante de la grille
	public boolean coordCorrectes(int lig, int col) {
		return ((lig >= 0 && this.getHauteur() > lig) && 
				(col >= 0 && this.getLargeur() > col));
	}
	// Valeur de la cellule ayant pour coordonnées (lig, col),
	// où lig (resp. col) est compris entre 1 et
	// getHauteur() (resp. getlargeur())
	// Précondition (assert) : coordCorrectes(lig, col)
	public String getCellule(int lig, int col) {
		assert(coordCorrectes(lig-1, col-1));
		return this.tab[lig-1][col-1];
	}
	// Modification de la cellule de coordonnées (lig,col)
	// Précondition (assert) : coordCorrectes(lig, col)
	public void setCellule(int lig, int col, String ch) {
		assert(coordCorrectes(lig-1, col-1));
		this.tab[lig-1][col-1]= ch ;
	}
	
	// Texte sur “hauteur�? lignes, colonnes séparées par des |
	// (voir exemple plus loin)
	@Override
	public String toString() {
		String ligne ="";
		System.out.println("|");
		for(int i = 0; i< this.getHauteur(); i++) {
			for(int j = 0; j< this.getLargeur()-1; j++) {
				ligne += " "+i+","+j +"|" ;
				System.out.println(""+i+","+j +"|");
			}
			
			ligne +="\n";
		}
		return ligne;
	}
}

