package ba.unsa.etf.rpr;

public class Korpa {
    private Artikl[] proizvodi=new Artikl[50];
    int ref=0;
    public boolean dodajArtikl(Artikl proizvod){
        if(ref<50){
            proizvodi[ref]=new Artikl(proizvod.getNaziv(),proizvod.getCijena(),proizvod.getKod());
            ref++;
            return true;
        }
        return false;
    }

    public Artikl[] getArtikli() {
        return proizvodi;
    }
    private void PomjeriSve (int brojpozicija){
        for (int i=brojpozicija;i<ref;i++){
            proizvodi[i]=proizvodi[i+1];
        }
        proizvodi[ref]=null;
        ref--;
    }
    public Artikl izbaciArtiklSaKodom (String kod) {
        for (int i = 0; i < ref; i++) {
            if (proizvodi[i].getKod().equals(kod)) {
                Artikl nov = new Artikl(proizvodi[i].getNaziv(), proizvodi[i].getCijena(), proizvodi[i].getKod());
                proizvodi[i] = null;
                PomjeriSve(i);
                return nov;
            }
        }
        return null;
    }

    public int dajUkupnuCijenuArtikala() {
        int Ukupno=0;
        for(int i=0;i<ref;i++){
            Ukupno+=proizvodi[i].getCijena();
        }
        return Ukupno;
    }
}
