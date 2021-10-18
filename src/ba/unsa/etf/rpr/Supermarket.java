package ba.unsa.etf.rpr;

public class Supermarket {
    private static Artikl[] artikli = new Artikl[1000];
    private static int brojArtikala = 0;


    public Artikl[] getArtikli() {
        return Supermarket.artikli;
    }

    public void setArtikli(Artikl[] artikli) {
        Supermarket.artikli = artikli;
    }

    public void dodajArtikl(Artikl artikl) {
        Supermarket.artikli[brojArtikala] = artikl;
        Supermarket.brojArtikala++;
    }

    public static Artikl izbaciArtiklSaKodom(String kod) {
        Artikl a = null;
        for(int i=0; i<artikli.length; i++) {
            if(artikli[i].getKod().equals(kod)) {
                a = new Artikl(artikli[i]);
                for(int j=i; j<=artikli.length; j++)Supermarket.artikli[j]=Supermarket.artikli[j+1];
            }
        }
        return a;
    }
}
