package trebernRezigTP2;


public class Grille<T>  {
	// Variables d’instance
	//nombre de lignes
	protected int hauteur;
	protected int largeur;
	
	private Object[][] tab;
	private int taille;

	// largeur = nombre de colonnes
	// tab = tableau de chaînes de caractères à 2 dimensions,
	// avec taille = hauteur x largeur
	// Constructeur permettant d’obtenir une grille
	// dotée d’un tableau de dimensions conformes aux valeurs
	// respectives de hauteur et de largeur, dont tous les
	// éléments contiennent la valeur null.
	// Précondition (assert) : hauteur ≥ 0 et largeur ≥ 0
	public Grille (int hauteur, int largeur) {
		
		assert(hauteur >= 0 && largeur >= 0);
		
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.taille = hauteur*largeur;
		this.tab = new Object[hauteur][largeur];
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
		
		return ((lig >= 0 && this.getHauteur() >= lig) && (col >= 0 && this.getLargeur() >= col));
		
		//return lig>=0 && lig < largeur  && col >= 0 && col < this.hauteur;
	}
	// Valeur de la cellule ayant pour coordonnées (lig, col),
	// où lig (resp. col) est compris entre 1 et
	// getHauteur() (resp. getlargeur())
	// Précondition (assert) : coordCorrectes(lig, col)
	public Object getCellule(int lig, int col) {
		assert(coordCorrectes(lig-1, col-1));
		return this.tab[lig-1][col-1];
		
	}
	// Modification de la cellule de coordonnées (lig,col)
	// Précondition (assert) : coordCorrectes(lig, col)
	public void setCellule(int lig, int col, Object sol) {
		System.out.println("lig: "+lig);
		System.out.println("col: "+col+"\n");
		
		assert(coordCorrectes(lig, col));
		
		this.tab[lig-1][col-1]= sol ;
		
		
	}
	
	public IterateurMots iterateurMots(boolean horizontal, int num) {
		String[] res= {};
		if(horizontal) {
			for(int i=0; i <= this.largeur; i++) {
				res[i] = (String) this.tab[num][i];
			}
		}else {
			for(int i=0; i <= this.hauteur; i++) {
				res[i] = (String) this.tab[i][num];
			}
		}
	
		IterateurMots it = new IterateurMots(res);
		return it;
	}
	
	
	
	
	// Texte sur “hauteur�? lignes, colonnes séparées par des |
	// (voir exemple plus loin)
	@Override
	public String toString() {
		String ligne ="";
		for(int i = 0; i< this.largeur; i++) {
			
			for(int j = 0; j< this.largeur; j++) {
				ligne += ""+i+","+j +"|" ;
			}
			ligne +="\n";
		}
		return ligne;
	}
}

