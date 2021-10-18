package ba.unsa.etf.rpr;

public class Korpa {
    private Artikl[] artikli = new Artikl[1000];
    private int brojArtikala = 0;

    public Artikl[] getArtikli() {
        return artikli;
    }

    public void setArtikli(Artikl[] artikli) {
        this.artikli = artikli;
    }

    public boolean dodajArtikl(Artikl artikl) { artikli[brojArtikala] = artikl;
        brojArtikala++;
        Supermarket.izbaciArtiklSaKodom(artikl.getKod());
        return false;
    }

    public Artikl izbaciArtiklSaKodom(String kod) {
        Artikl a = null;
        for(int i=0; i<artikli.length; i++) {
            if(artikli[i].getKod().equals(kod)) {
                a = new Artikl();
                for(int j=i; j<=artikli.length; j++)artikli[j]=artikli[j+1];
            }
        }

        return a;
    }

    public int dajUkupnuCijenuArtikala() { return  0;
    }
}
