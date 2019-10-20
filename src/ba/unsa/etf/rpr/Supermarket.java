package ba.unsa.etf.rpr;

public class Supermarket {
    Artikl[] artikli = new Artikl[1000];
    private int brojArtikala = 0;

    public void dodajArtikl (Artikl a){
        artikli [brojArtikala] = new Artikl(a);
        brojArtikala = brojArtikala + 1;
    }
    public Artikl[] getArtikli() {
        Artikl[] niz = new Artikl[brojArtikala];
        for (int i=0; i< brojArtikala; i++){
            niz[i] = artikli[i];
        }
        return niz;
    }
}
