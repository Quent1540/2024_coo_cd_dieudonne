import donnees.Magasin;
import XML.ChargeurMagasin;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;


public class testChargeurMagasin {

    /**
     * On teste le chargement d'un magasin à partir du repertoire de fichiers xml fourni
     * On vérifie que le nombre de CD chargés est correct
     */
    @Test
    public void testChargeurMagasinOK() throws FileNotFoundException {
        ChargeurMagasin ch = new ChargeurMagasin("musicbrainzSimple");
        assertDoesNotThrow(() -> {
            ch.chargerMagasin();
        }, "Aucune exception ne devrait etre lancee");
        assertEquals(12, ch.chargerMagasin().getNombreCds());
    }

    /**
     * On teste le chargement d'un magasin à partir d'un répertoire inexistant
     * On vérifie que l'exception FileNotFoundException est bien levée
     */
    @Test
    public void testChargeurMagasinFail() {
        ChargeurMagasin ch = new ChargeurMagasin("../repertoireInexistant");
        assertThrows(FileNotFoundException.class, () -> {
            ch.chargerMagasin();
        }, "Une exception FileNotFoundException doit etre levee");
    }
}
