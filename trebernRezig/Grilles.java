package trebernRezig;

public interface Grilles {
	// Variables d’instance
	// hauteur = nombre de lignes 
	// largeur = nombre de colonnes
	// tab = tableau de chaînes de caractères à deux dimensions,
	// avec taille = hauteur x largeur
	// Constructeur permettant d’obtenir une grille
	// dotée d’un tableau de dimensions conformes aux valeurs
	// respectives de hauteur et de largeur, dont tous les
	// éléments contiennent la valeur null.
	// Précondition (assert) : hauteur   0 et largeur   0 ≥ ≥
	//public Grille (int hauteur, int largeur);
	// Accesseurs (getters)
	public int getHauteur();
	public int getLargeur();
	// Validité des coordonnées
	// Resultat : vrai si et seulement si lig (resp. col)
	// est compris entre 1 et getHauteur() (resp. getlargeur())
	public boolean coordCorrectes(int lig, int col);
	// Valeur de la cellule ayant pour coordonnées (lig, col)
	// Précondition (assert) : coordCorrectes(lig, col)
	public String getCellule(int lig, int col);
	// Modification de la cellule de coordonnées (lig, col)
	// Précondition (assert) : coordCorrectes(lig, col)
	public void setCellule(int lig, int col, String ch);
	// Texte sur “hauteur” lignes, colonnes séparées par des |
	// (voir exemple plus loin)
	@Override
	public String toString();

}
