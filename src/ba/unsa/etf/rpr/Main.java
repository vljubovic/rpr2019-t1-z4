package ba.unsa.etf.rpr;

import java.util.Scanner;

public class Main {

    private static Korpa korpa = new Korpa();
    private static Supermarket supermarket = new Supermarket();

    private static void unosArtikalaUMarket(){
        supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "1"));
        supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "2"));
        supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "3"));
        supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "4"));
        supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "5"));
        supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "6"));
        supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "7"));
        supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "8"));
        supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "9"));
        supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "10"));
        supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "11"));
        supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "12"));
        supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "13"));
        supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "14"));
        supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "15"));
        supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "16"));
        supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "17"));
        supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "18"));
        supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "19"));
        supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "20"));
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
                ispisArtikala(supermarket.getArtikli());
                System.out.println("Unesite kod artikla (unesite malo slovo \"c\" za odustajanje): ");
                String kod = scanner.nextLine();
                kod = scanner.nextLine();
                if(!kod.equals("c")){
                    Artikl a = supermarket.izbaciArtiklSaKodom(kod);
                    if(a != null){
                        if(korpa.dodajArtikl(a)) System.out.println("Artikl dodan u korpu.");
                        else {
                            supermarket.dodajArtikl(a);
                            System.out.println("Korpa je puna, artikl nije dodan!");
                        }
                    }
                }
            }
            else if(opcija == 2){
                System.out.println("Izbacivanje artikla iz korpe\nArtikli u korpi su: ");
                ispisArtikala(korpa.getArtikli());
                System.out.println("Unesite kod artikla (unesite malo slovo \"c\" za odustajanje): ");
                String kod = scanner.nextLine();
                kod = scanner.nextLine();
                if(!kod.equals("c")){
                    Artikl a = korpa.izbaciArtiklSaKodom(kod);
                    if(a != null){
                        supermarket.dodajArtikl(a);
                    }
                }
            }
            else if(opcija == 3){
                int cijena = korpa.dajUkupnuCijenuArtikala(), iznos;
                System.out.println("Ukupna cijena je " + korpa.dajUkupnuCijenuArtikala() + " KM.");
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
