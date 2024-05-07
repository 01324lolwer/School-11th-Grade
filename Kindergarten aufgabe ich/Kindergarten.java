import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kindergarten {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SpieleSammlung spieleSammlung;
        List<Tüte> tüten = new ArrayList<Tüte>();
        int tütenAnzahl;
        int wuerfelspiele;
        int kartenspiele;
        int geschicklichkeitsspiele;
        int spieleGesamt;

        // in 1 (Tüten)
        System.out.print("Wie viele Tüten sollen es denn sein?: ");
        tütenAnzahl = scanner.nextInt();

        // In 2 (Spiel 1)
        System.out.print("Anzahl der Würfelspiele: ");
        wuerfelspiele = scanner.nextInt();

        // In 3 (Spiel 2)
        System.out.print("Anzahl der Kartenspiele: ");
        kartenspiele = scanner.nextInt();

        // In 4 (Spiel 3)
        System.out.print("Anzahl der Geschicklichkeitsspiele: ");
        geschicklichkeitsspiele = scanner.nextInt();

        // Scanner Schließen
        scanner.close();

        spieleSammlung = new SpieleSammlung(wuerfelspiele, kartenspiele, geschicklichkeitsspiele);
        spieleGesamt = spieleSammlung.GetSpieleGesamt();

        // Generierung der Leeren Tüten
        for (int i = 0; i < tütenAnzahl; i++) {
            SpieleSammlung s = new SpieleSammlung(0, 0, 0);
            Tüte tüte = new Tüte(s);
            tüten.add(tüte);
        }

        // Aufteilen
        if (spieleGesamt > 0) {
            if (spieleSammlung.GetWuerfelspieleProTüte(tütenAnzahl) != 0) {
                for (Tüte tüte : tüten) {
                    tüte.spieleSammlung.wuerfelspiele += spieleSammlung.GetWuerfelspieleProTüte(tütenAnzahl);
                    spieleGesamt -= spieleSammlung.GetWuerfelspieleProTüte(tütenAnzahl);
                }
            }
            if (spieleSammlung.GetKartenspieleProTüte(tütenAnzahl) != 0) {
                for (Tüte tüte : tüten) {
                    tüte.spieleSammlung.kartenspiele += spieleSammlung.GetKartenspieleProTüte(tütenAnzahl);
                    spieleGesamt -= spieleSammlung.GetKartenspieleProTüte(tütenAnzahl);
                }
            }
            if (spieleSammlung.GetGeschicklichkeitsspieleProTüte(tütenAnzahl) != 0) {
                for (Tüte tüte : tüten) {
                    tüte.spieleSammlung.geschicklichkeitsspiele += spieleSammlung
                            .GetGeschicklichkeitsspieleProTüte(tütenAnzahl);
                    spieleGesamt -= spieleSammlung.GetGeschicklichkeitsspieleProTüte(tütenAnzahl);
                }
            }
        } else {
            System.out.println("Leere Tüten für Alle!!");
            System.exit(0);
        }

        // Verteilung Restlicher Spiele
        SpieleSammlung reste = new SpieleSammlung(spieleSammlung.wuerfelspiele % tütenAnzahl,
                spieleSammlung.kartenspiele % tütenAnzahl, spieleSammlung.geschicklichkeitsspiele % tütenAnzahl);

        // Schleife Solange Spiele vorhanden sind (wird geprüft, wenn alle taschen einen
        // Rest bekommen haben)
        while (spieleGesamt > 0) {

            for (Tüte tüte : tüten) {

                // Nach jeder befüllung Abbruchprüfung
                if (spieleGesamt == 0) {
                    printResults(tüten);
                    System.exit(0);
                } else {
                    if (reste.wuerfelspiele > 0) {
                        tüte.spieleSammlung.wuerfelspiele++;
                        reste.wuerfelspiele--;
                    } else if (reste.kartenspiele > 0) {
                        tüte.spieleSammlung.kartenspiele++;
                        reste.kartenspiele--;
                    } else if (reste.geschicklichkeitsspiele > 0) {
                        tüte.spieleSammlung.geschicklichkeitsspiele++;
                        reste.geschicklichkeitsspiele--;
                    }
                    spieleGesamt--;
                }
            }
        }
        printResults(tüten);
    }

    public static void printResults(List<Tüte> tüten) {
        for (Tüte tüte : tüten) {
            System.out.println("Würfelspiele: " + tüte.spieleSammlung.wuerfelspiele + " Kartenspiele: "
                    + tüte.spieleSammlung.kartenspiele + " Geschicklichkeitsspiele: "
                    + tüte.spieleSammlung.geschicklichkeitsspiele);
        }
    }
}