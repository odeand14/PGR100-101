import java.util.Random;

// Created by Andreas Ødegaard on 13.12.2016.
public class ExamExamples {

    public static void main(String[] args) {

    }

    /**
     * I utgangspunktet er det viktig å tenke på hva du har av informasjon,
     * parameter innhold sier ofte noe om hva det er forventet at du skal gjøre
     *
     */

    //Printe unik lottorekke
    public static int[] lotto() {
        int[] tall = new int[7]; //Lager nytt array med 7 plasser
        Random rand = new Random(); //Setter opp en random som jeg kan bruke til å få tall
        int tmpTall; //Gjør klar en placeholder int for å ta vare på et tall.

        for (int i = 0; i < tall.length; i++) { //itererer gjennom lotto-listen min som i utgangspunktet er tom men har 7 plasser.
            tmpTall = rand.nextInt(34) + 1; // gir tmpTall en random lottoverdi som utgangspunkt.
            while (contains(tall, tmpTall)) { //Bruker en while-løkke for å være sikker på at tallet ikke blir lagt til før det er unikt.
                tmpTall = rand.nextInt(34) + 1; // gir tmpTall en random lottoverdi helt til den er unik.
            }
            tall[i] = tmpTall; //tmpTall lagres på plassen tall[i]
        }
        return tall; //Og vi kan returnere en unik tallrekke.
    }

    //Hjelpemetode for lotto kan også puttes inni lotto, men like greit å gjøre det slik! Mer ryddig :)
    //Man kan ikke få trekk for å lage noe slikt, med mindre det er spesifisert at alt skal ligge i lotto.
    public static boolean contains(int[] list, int i) {
        for (int tall : list) { //Itererer gjennom listen
            if (tall == i) return true; //Returnerer true hvis elementet eksisterer.
        }
        return false; // ellers false.
    }

    //Største tall i array
    public static int bigestNumber(int[] list) {
        int tmp = list[0]; //starter på det første tallet i listen. (Kunne vært null, men da kunne det også blitt problemer med negative tall)
        for (int i = 0; i < list.length; i++) { //itererer gjennom parameter-listen
            if (list[i] > tmp) // Hvis tallet i listen på plass i er større enn tmp.
                tmp = list[i]; // Erstatt med tallet på plass i
        }
        return tmp; //Returnerer det største tallet.
    }

    // Fjerner alle "tall" i listen "list" og returnerer et nytt array uten "tall".
    public static int[] rydd(int[] list, int tall) {
        int length = list.length; // Teller som tar utgangspunkt i alle tallene i arrayet.
        for (int i = 0; i < list.length; i++) { //itererer gjennom parameter-listen
            if (list[i] == tall) length--; //Hvis tallet "tall" fins på plassen list[i] trekkes 1 fra "length".
        } //Kjapp og dirty måte å lage et array på riktig lengde før vi setter i gang.

        int[] tmp = new int[length]; // Nytt array med riktig lengde lages.
        int teller = 0; // Teller for å holde styr på hvilken plass i det nye arrayet (som burde være kortere) vi befinner oss.
        for (int i = 0; i < list.length; i++) { //itererer gjennom parameter-listen
            if (list[i] != tall) { // Hvis tallet på plassen list[i] ikke er tallet vi ser etter -
                tmp[teller] = list[i]; // legges det til den nye listen,
                teller++; // og telleren øker for å kunne plassere evt neste tall på rett plass.
            }
            // Dersom tallet på plassen list[i] er det tallet vi er ute etter kommer vi ikke inn i if-statementet og ingenting skjer
        }
        return tmp;
    }
}
