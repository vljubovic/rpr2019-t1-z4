package ba.unsa.etf.rpr;

public class Korpa {
    Artikl[] artikli = new Artikl[50];

    public boolean dodajArtikl(Artikl a) {
        boolean artiklDodan = false;
        for (int i = 0; i < 3; i++) {

            if (artikli[i] == null) {
                artikli[i] = new Artikl(a);
                artiklDodan = true;
                break;
            }
        }
        return artiklDodan;
    }


    public Artikl[] getArtikli(){
        Artikl[] niz = new Artikl[50];
        for (int i=0; i<50; i++){
            niz[i] = artikli[i];
        }
        return niz;
    }


    public int dajUkupnuCijenuArtikala(){
        int ukupnaCijena = 0;
        for (int i = 0; i<50; i++) {
            if (artikli[i] != null)
                ukupnaCijena = ukupnaCijena + artikli[i].cijena;
        }
     return ukupnaCijena;
    }
    public Artikl izbaciArtiklSaKodom(String kod){
        Artikl a = new Artikl();
        for (int i = 0; i<50; i++){
            if (artikli[i] != null)
                if (artikli[i].kod.equals(kod)){
                    a = artikli[i];
                    artikli[i] = null;
                    break;
                }
        }
        return a;
    }

}
