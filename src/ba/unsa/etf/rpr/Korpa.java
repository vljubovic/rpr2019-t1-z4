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


    public boolean dodajArtikl(Artikl artikl) {
        if(brojArtikala<50) {
            artikli[brojArtikala] = artikl;
            brojArtikala++;
            return true;
        }

        return false;
    }

    public Artikl izbaciArtiklSaKodom(String kod) {
    //    Artikl a = null;
        for(int i=0; i<brojArtikala; i++) {
            if(artikli[i]!=null && artikli[i].getKod().equals(kod)) {
                Artikl a = artikli[i];
            //    a = new Artikl(artikli[i]);
                for(int j=i; j<=brojArtikala; j++)artikli[j]=artikli[j+1];
                artikli[brojArtikala-1] = null;
                brojArtikala = brojArtikala -1;
                return a;
            }
        }

       return null;
    }

    public int dajUkupnuCijenuArtikala() {
        int suma = 0;
        for(Artikl a : artikli) {
            if (a!=null) {
                suma+=a.getCijena();
            }
        }
        return suma;
    }
}
