package ba.unsa.etf.rpr;

public class Supermarket {

    Artikl[] artikli = new Artikl[1000];

    public void dodajArtikl(Artikl a){
        for(int i=0; i<1000; i++){
            if(artikli[i] == null) {
                artikli[i] = a;
                break;
            }
        }
    }


    public Artikl[] getArtikli() {
        return artikli;
    }

    Artikl a;
    public Artikl izbaciArtiklSaKodom(String kod){

        Artikl[] pom = new Artikl[1000];
        for(int i=0; i<1000; i++){
            if(artikli[i].getKod().equals(kod) && i != 0) {
                a = artikli[i];
                System.arraycopy(artikli, 0, pom, 0, i-1);
                System.arraycopy(artikli, i+1, pom, i, 1000-i-1);
                artikli = pom;
                break;
            }else if(artikli[i].getKod().equals(kod) && i == 0){
                a = artikli[i];
                System.arraycopy(artikli, 1, pom, 0, 999);
                artikli = pom;
                break;
            }
        }
        return a;
    }


}
