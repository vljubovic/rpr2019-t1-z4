package ba.unsa.etf.rpr;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class SupermarketTest {

    @Test
    void daLiJeUnesenArtikl(){
        Supermarket supermarket = new Supermarket();
        supermarket.dodajArtikl(new Artikl("naziv", 99, "kod"));
        Artikl[] artikli = supermarket.getArtikli();
        assertNotNull(artikli[0]);
    }

        @Test
        void daLiPrekoracuje(){
        assertDoesNotThrow(
                ()-> {
                    Supermarket supermarket = new Supermarket();
                    for(int i=0; i<5000; i++){
                        supermarket.dodajArtikl(new Artikl("naziv", 99, "kod"));
                    }
                }
        );
        }






}





