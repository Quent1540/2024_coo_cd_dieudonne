package donnees;

import java.util.ArrayList;

/**
 * La classe Magasin represente un magasin qui vend des CDs.</p>
 * 
 * cette classe est caracterisee par un ensemble de CDs correspondant aux CDS
 * vendus dans ce magasin.
 * 
 */
public class Magasin {

	/**
	 * la liste des CDs disponibles en magasin
	 */
	private ArrayList<CD> listeCds;

	/**
	 * construit un magasin par defaut qui ne contient pas de CD
	 */
	public Magasin() {
		listeCds = new ArrayList<CD>();
	}

	/**
	 * ajoute un cd au magasin
	 * 
	 * @param cdAAjouter
	 *            le cd a ajouter
	 */
	public void ajouteCd(CD cdAAjouter) {
		listeCds.add(cdAAjouter);
	}

	@Override
	/**
	 * affiche le contenu du magasin
	 */
	public String toString() {
		String chaineResultat = "";
		//parcours des Cds
		for (int i = 0; i < listeCds.size(); i++) {
			chaineResultat += listeCds.get(i);
		}
		chaineResultat += "nb Cds: " + listeCds.size();
		return (chaineResultat);

	}

	/**
	 * @return le nombre de Cds du magasin
	 */
	public int getNombreCds() {
		return listeCds.size();
	}
	
	/**
	 * permet d'acceder � un CD
	 * 
	 * @return le cd a l'indice i ou null si indice est non valide
	 */
	public CD getCd(int i)
	{
		CD res=null;
		if ((i>=0)&&(i<this.listeCds.size()))
			res=this.listeCds.get(i);
		return(res);
	}

	public void trierArtiste(){
		int l = listeCds.size();
        for (int i=1;i<l;++i){
            CD c=listeCds.get(i);
            int j = i-1;

            while (j>=0 && listeCds.get(j).nomArtiste.compareTo(c.nomArtiste)>0){
                listeCds.set(j + 1,listeCds.get(j));
                j = j-1;
            }
            listeCds.set(j + 1, c);
        }
	}

	public void trierAlbum(){
        int l = listeCds.size();
        for (int i=0;i<l-1;i++){
            int indexMin = i;
            for (int j=i+1;j<l;j++){
                if (listeCds.get(j).nomCD.compareTo(listeCds.get(indexMin).nomCD)<0){
                    indexMin = j;
                }
            }
            CD c = listeCds.get(i);
            listeCds.set(i, listeCds.get(indexMin));
            listeCds.set(indexMin, c);
        }
    }

}
