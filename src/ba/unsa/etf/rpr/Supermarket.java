package ba.unsa.etf.rpr;

public class Supermarket {
    Artikl[] artikli = new Artikl[1000];


    public void dodajArtikl (Artikl a){
        int i = 0;
        while (artikli[i] != null) i++;
        artikli [i] = new Artikl(a);
    }
    public Artikl[] getArtikli() {
        Artikl[] niz = new Artikl[1000];
        for (int i=0; i<1000; i++){
            niz[i] = artikli[i];
        }
        return niz;
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
