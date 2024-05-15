import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import donnees.Magasin;
import donnees.CD;
import donnees.InfoPiste;

public class testTri{
    @Test
    public void testTrierAlbum(){
        //on cree un magasin avec des cd non tries
        Magasin magasin = new Magasin();
        CD cd1 = new CD("Johnny Halliday", "Album A");
        CD cd2 = new CD("Adele", "Album B");
        CD cd3 = new CD("Stromae", "Album C");
        //On ajoute l'album C puis le A puis le B
        magasin.ajouteCd(cd3);
        magasin.ajouteCd(cd1);
        magasin.ajouteCd(cd2);

        magasin.trierAlbum();

        assertEquals(cd1, magasin.getCd(0).getnomCD(),"Le premier Cd doit etre l'album A");
        assertEquals(cd3, magasin.getCd(magasin.getNombreCds()-1).getnomCD(), "Le dernier CD doit etre l'album C");
    }

     @Test
    public void testTrierArtiste() {
        Magasin magasin = new Magasin();
        CD cd1 = new CD("Artiste A", "Album A");
        CD cd2 = new CD("Artiste B", "Album B");
        CD cd3 = new CD("Artiste C", "Album C");
        //on ajoute au magasin le cd avec l'artiste C puis l'artiste A puis le B
        magasin.ajouteCd(cd3);
        magasin.ajouteCd(cd1);
        magasin.ajouteCd(cd2);

        //on trie les cd par artiste
        magasin.trierArtiste();

        assertEquals("Artiste C", magasin.getCd(0).getArtiste(), "Le premier Cd doit etre celui de l'artiste C");
        assertEquals("Artiste A", magasin.getCd(1).getArtiste(), "Le deuxième CD doit etre celui de l'artiste A");
        assertEquals("Artiste B", magasin.getCd(2).getArtiste(), "Le troisième cd doit etre celui de l'artiste B");
    }
}