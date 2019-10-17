package ba.unsa.etf.rpr;

public class Korpa {

    Artikl[] korpa = new Artikl[50];


    public boolean dodajArtikl(Artikl a){

        for(int i=0; i<50; i++){
            if(korpa[i] == null){
                korpa[i] = a;
                break;
            }
        }

        if(korpa.length <= 50){
            return true;
        }
        return false;
    }




    public Artikl[] getArtikli() {

        return korpa;
    }

    Artikl a;
    public Artikl izbaciArtiklSaKodom(String kod){
        Artikl[] pom = new Artikl[50];
        for(int i=0; i<50; i++){
            if(korpa[i].getKod().equals(kod) && i != 0) {
                a = korpa[i];
                System.arraycopy(korpa, 0, pom, 0, i-1);
                System.arraycopy(korpa, i+1, pom, i, 50-i-1);
                korpa = pom;
                break;
            }else if(korpa[i].getKod().equals(kod) && i == 0){
                a = korpa[i];
                System.arraycopy(korpa, 1, pom, 0, 49);
                korpa = pom;
                break;
            }
        }
        return  a;
    }



    public int dajUkupnuCijenuArtikala() {
        int ukupnaCijenaArtikala = 0;
        for(Artikl artikl : korpa){
            if(artikl != null) {
                ukupnaCijenaArtikala = ukupnaCijenaArtikala + artikl.getCijena();
            }
            else{
                break;
            }
        }
        return  ukupnaCijenaArtikala;
    }
}

