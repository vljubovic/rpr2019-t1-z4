package ba.unsa.etf.rpr;

public class Artikl {
    int cijena;
    String kod;
    String naziv;
    public Artikl (String naziv, int cijena, String kod){
          this.naziv = naziv;
          this.cijena = cijena;
          this.kod = kod;
    }
    public Artikl (Artikl a){
        this.naziv = a.naziv;
        this.cijena = a.cijena;
        this.kod = a.kod;
    }

    public String getNaziv (){
       return this.naziv;
    }
    public int getCijena (){
        return this.cijena;
    }
    public String getKod (){
        return this.kod;
    }
}
