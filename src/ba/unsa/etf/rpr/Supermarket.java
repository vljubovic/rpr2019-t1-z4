package ba.unsa.etf.rpr;

public class Supermarket {
    //private final int maksimalnoUSupermarketu=1000;
    private Artikl[] artikli=new Artikl[1000];
    private int total=0;


    public Artikl[] getArtikli() {
        return artikli;
    }

    public void setArtikli(Artikl[] artikli) {
        this.artikli = artikli;
    }

    public void dodajArtikl(Artikl artikl) {
        if(total<1000) {
            artikli[total] = new Artikl(artikl);
            total++;
        }

    }

    public  Artikl izbaciArtiklSaKodom(String kod) {
      //  Artikl a = null;
        for(int i=0; i<total; i++) {
            if(artikli[i]!=null && artikli[i].getKod().equals(kod)) {
                Artikl a = artikli[i];
                //    a = new Artikl(artikli[i]);
                for(int j=i; j<=total; j++)artikli[j]=artikli[j+1];
                artikli[total-1] = null;
                total = total -1;
                return a;
            }
        }
        return null;
    }
}
