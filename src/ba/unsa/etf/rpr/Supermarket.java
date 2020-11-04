package ba.unsa.etf.rpr;

public class Supermarket {
    private Artikl[] proizvodi=new Artikl[1000];
    private int ref=0;
    public boolean dodajArtikl(Artikl proizvod){
            if(ref<50){
                proizvodi[ref]=new Artikl(proizvod.getNaziv(),proizvod.getCijena(),proizvod.getKod());
                ref++;
                return true;
            }
        return false;
    }
    public Artikl izbaciArtiklSaKodom (String kod){
        for(int i=0;i<ref;i++){
            if(proizvodi[i].getKod().equals(kod)){
                Artikl novi=new Artikl(proizvodi[i].getNaziv(),proizvodi[i].getCijena(),proizvodi[i].getKod());
                proizvodi[i]=null;
                PomjeriSve(i);
                return novi;
            }
        }
        return null;
    }
    private void PomjeriSve (int brojpozicija){
        for (int i=brojpozicija;i<ref;i++){
            proizvodi[i]=proizvodi[i+1];
        }
        proizvodi[ref]=null;
        ref--;
    }

    public Artikl[] getArtikli() {
        return proizvodi;
    }
}
