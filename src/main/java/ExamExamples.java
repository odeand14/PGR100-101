
import java.util.Random;

// Created by Andreas Ødegaard on 13.12.2016.
public class ExamExamples {


    /**
     * Start med å lage det du vet hva skal være, som metoden med parametere og returverdi.
     * Så kan du se hva oppgaven spør etter.
     *
     * I lotto:
     * Den skal opprette et heltallsarray, ok da lager vi det først.
     * Den skal fylle inn noen random tall, da trenger vi en Random av noe slag, vi lager det.
     * Arrayen er returverdi, da kan vi legge inn det i bunn med en gang.
     * Å plassere inn tilfeldige tall i arrayet er nå lett, vi kan lage en løkke som gjør det.
     *
     * Det vanskelige her er å forsikre oss om at tallet som puttes i løkken er unikt,
     * for å være sikker på det må vi sjekke om det finnes i løkken allerede, før vi putter det inn.
     * og det holder ikke å sjekke én gang heller, for man kan jo ha uflaks og få et tall man har fra før igjen!
     * derfor må vi ha en løkke som sjekker helt til vi vet at tallet er unikt.
     * Derfor lager vi en while-loop. Her har jeg valgt å bruke en hjelpemetode for å se om tallet finnes i arrayet,
     * den ligger under og heter contains. Så i while-loopen sier vi at så lenge rekken inneholder tallet,
     * skal vi lage et nytt tilfeldig tall.
     * Når vi da kommer ut av løkken kan vi være sikre på at vi har et unikt tall og plassere det i rekken.
     * Så kan vi bare returnere :)
     */

    /**
     * Oppgave:
     * Skriv en metode lotto som oppretter en array med dimensjon 7,
     * og som fyller den med tilfeldige tall i område 1 – 34.
     * Metoden skal sørge for at ingen tall er like. Arrayen er returvedi.
     *
     * Metode for å printe unik lottorekke
     * @return array med unike lottotall.
     */
    public int[] lotto() {
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

    /**
     * Oppgave:
     * Del av lotto
     *
     * Hjelpemetode for lotto kan også puttes inni lotto, men like greit å gjøre det slik! Mer ryddig :)
     * Man kan ikke få trekk for å lage noe slikt, med mindre det er spesifisert at alt skal ligge i lotto.
     */
    public boolean contains(int[] list, int i) {
        for (int tall : list) { //Itererer gjennom listen
            if (tall == i) return true; //Returnerer true hvis elementet eksisterer.
        }
        return false; // ellers false.
    }

    /**
     * Oppgave:
     * Lag en metode som tar imot en heltallsarray og som returnerer det største tallet i arrayen.
     *
     * Metode for å printe ut største tall i et array
     * @param list array med tall
     * @return int høyeste tall.
     */
    public int bigestNumber(int[] list) {
        int tmp = list[0]; //starter på det første tallet i listen. (Kunne vært null, men da kunne det også blitt problemer med negative tall)
        for (int i = 0; i < list.length; i++) { //itererer gjennom parameter-listen
            if (list[i] > tmp) // Hvis tallet i listen på plass i er større enn tmp.
                tmp = list[i]; // Erstatt med tallet på plass i
        }
        return tmp; //Returnerer det største tallet.
    }

    /**
     * Oppgave:
     * skriv en metode rydd som har et heltall og et heltallsarray som parameter og en helttallsarray som retur.
     * Tallene i arrayen er sortert i stigende rekkefølge.
     * Metoden skal fjerne alle forekomster av tallet (parameter verdi) og flytte andre tall fremover
     *
     * Metode for å fjerne alle "tall" i listen "list" og returnerer et nytt array uten "tall".
     * @param list array med tall.
     * @param tall type tall du vil fjerne fra array.
     * @return nytt array uten tallet fra parameter.
     */
    public int[] rydd(int[] list, int tall) {
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
