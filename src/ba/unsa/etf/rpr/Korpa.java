package ba.unsa.etf.rpr;

public class Korpa {
    private Artikl[] artikli;

    public Artikl[] getArtikli() {
        return artikli;
    }

    public void setArtikli(Artikl[] artikli) {
        this.artikli = artikli;
    }

    public boolean dodajArtikl(Artikl a) { return true;
    }

    public Artikl izbaciArtiklSaKodom(String kod) { return null;
    }

    public int dajUkupnuCijenuArtikala() { return  0;
    }
}
