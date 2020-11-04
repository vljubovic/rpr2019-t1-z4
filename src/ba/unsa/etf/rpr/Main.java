package ba.unsa.etf.rpr;

import java.util.Scanner;

public class Main {

    private static Korpa Korpa = new Korpa();
    private static Supermarket Supermarket = new Supermarket();

    private static void unosArtikalaUMarket(){
        Supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "1"));
        Supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "2"));
        Supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "3"));
        Supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "4"));
        Supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "5"));
        Supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "6"));
        Supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "7"));
        Supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "8"));
        Supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "9"));
        Supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "10"));
        Supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "11"));
        Supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "12"));
        Supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "13"));
        Supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "14"));
        Supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "15"));
        Supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "16"));
        Supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "17"));
        Supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "18"));
        Supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "19"));
        Supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "20"));
    }

    public static void ispisArtikala(Artikl[] artikli){
        for (Artikl a : artikli) {
            if(a != null) System.out.println("Naziv: " + a.getNaziv() + ", Kod: " + a.getKod() + ", Cijena: " + a.getCijena() + " KM");
        }
    }

    public static void main(String[] args) {
//      Kreirati program koji modelira supermarket. Kupac ima korpu koja moze sadrzavati maksimalno 50 artikala.
//      Supermarket maksimalno sadrzi 1000 artikala. Artikl je odredjen svojim nazivom, cijenom i kodom.
//      Radi jednostavnosti cemo pretpostaviti da su svi kodovi artikala razliciti. Program treba da radi sljedece:
//      Kupac na pocetku dobija praznu korpu, te u nju moze ubacivati i iz nje izbacivati artikle. Ukoliko kupac zeli
//      ubacivati u korpu potrebno je ispisati sve artikle sa kodovima, te se unosi adekvatan kod za ubacivanje u korpu. Analogno
//      za izbacivanje iz korpe je potrebno ispisati sve produkte koji se trenutno nalaze u korpi sa kodovima. Pri ubacivanju
//      u korpu, stanje u supermarketu se mijenja i artikl vise nije dostupan. Analogno pri izbacivanju iz korpe,
//      artikl se vraca u supermarket. Cilj je implementirati program tako da se transakcije izmedju korpe i supermarketa
//      rjesavaju preko koda. Kupcu je potrebno omoguciti opciju da se prekine program, odnosno da odustane od kupovine,
//      ili da ide na checkout gdje se obracunava potpuni iznos. Placanje se vrsi unosom pri cemu se validira da li je
//      unesena negativna, odnosno dovoljna suma novca.

        unosArtikalaUMarket();
        for(;;){
            System.out.print("0 - odustani\n1 - dodaj u korpu\n2 - izbaci iz korpe\n3 - checkout\nUnesite opciju: ");
            Scanner scanner = new Scanner(System.in);
            int opcija = scanner.nextInt();

            if(opcija == 0){
                System.out.println("Odustali ste od kupovine.");
                return;
            }
            else if(opcija == 1){
                System.out.println("Dodavanje artikla u korpu\nArtikli u marketu su: ");
                ispisArtikala(Supermarket.getArtikli());
                System.out.println("Unesite kod artikla (unesite malo slovo \"c\" za odustajanje): ");
                java.lang.String kod = scanner.nextLine();
                kod = scanner.nextLine();
                if(!kod.equals("c")){
                    Artikl a = Supermarket.izbaciArtiklSaKodom(kod);
                    if(a != null){
                        if(Korpa.dodajArtikl(a)) System.out.println("Artikl dodan u korpu.");
                        else {
                            Supermarket.dodajArtikl(a);
                            System.out.println("Korpa je puna, artikl nije dodan!");
                        }
                    }
                }
            }
            else if(opcija == 2){
                System.out.println("Izbacivanje artikla iz korpe\nArtikli u korpi su: ");
                ispisArtikala(Korpa.getArtikli());
                System.out.println("Unesite kod artikla (unesite malo slovo \"c\" za odustajanje): ");
                String kod = scanner.nextLine();
                kod = scanner.nextLine();
                if(!kod.equals("c")){
                    Artikl a = Korpa.izbaciArtiklSaKodom(kod);
                    if(a != null){
                        Supermarket.dodajArtikl(a);
                    }
                }
            }
            else if(opcija == 3){
                int cijena = Korpa.dajUkupnuCijenuArtikala(), iznos;
                System.out.println("Ukupna cijena je " + Korpa.dajUkupnuCijenuArtikala() + " KM.");
                do{
                    System.out.print("Unesite ispravan iznos: ");
                    iznos = scanner.nextInt();
                }while(iznos < cijena);
                if(iznos > cijena) System.out.println("Povratni iznos: " + (iznos - cijena));
                System.out.println("Placeno, kupovina finalizirana.");
                return;
            }
        }

    }
}
