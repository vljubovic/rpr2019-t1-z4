package ba.unsa.etf.rpr;

public class Artikl {
    private String naziv;
    private int cijena;
    private String kod;

    public Artikl(java.lang.String ime, int cij, java.lang.String oznaka){
        naziv=ime;
        cijena=cij;
        kod=oznaka;
    }


    public String getNaziv() {
        return naziv;
    }

    public int getCijena() {
        return cijena;
    }

    public String getKod() {
        return kod;
    }
}

