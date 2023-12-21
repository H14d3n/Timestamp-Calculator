import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Timestamp {
    public static void main(String[] args) {
        // Essentielle Daten initialisieren
        Scanner scanner = new Scanner(System.in);
        String Auswahl = null;
        boolean exceptionOccurred;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");


        do {
            try {
                // Einleitung
                exceptionOccurred = false;
                String Datum;
                long unixTimestamp;

                System.out.println("Das ist der Unix-Timestamp Rechner. Was möchtest du tun?");
                System.out.println("1 - Timestamp mithilfe von Datum berechnen");
                System.out.println("2 - Datum mithilfe von Timestamp berechnen");
                System.out.println("3 - Erkläre mir, was ist die Unixzeit?");
                Auswahl = scanner.nextLine();

                switch (Auswahl) {
                    case "1":
                        System.out.println("Geben Sie nun ein Datum ein (Format: dd-MM-yyyy HH:mm:ss)");
                        Datum = scanner.nextLine();
                        Date parsedDate = dateFormat.parse(Datum);
                        unixTimestamp = parsedDate.getTime() / 1000;

                        System.out.println("Dein errechneter Timestamp ist: " + unixTimestamp);
                        break;

                    case "2":
                        System.out.println("Geben Sie nun eine Zahl ein.");
                        System.out.println("Die Zahl muss größer als 0 und kleiner als 2'147'483'647 sein");
                        unixTimestamp = scanner.nextLong();

                        if (unixTimestamp > 0 && unixTimestamp <= 2147483647) {
                            Date date = new Date(unixTimestamp * 1000L);
                            String formattedDate = dateFormat.format(date);

                            System.out.println("Dein errechnetes Datum ist: " + formattedDate);
                        } else {
                            throw new Exception();
                        }
                        break;

                    case "3":
                        unixTimeExplained();
                        exceptionOccurred = true;
                        break;

                    default:
                        System.out.println("Ungültige Eingabe");
                        exceptionOccurred = true;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Fehlerhafte Eingabe");
                exceptionOccurred = true;
                Auswahl = null;
                scanner.nextLine();
            }

        } while (exceptionOccurred || Auswahl.isBlank());
    }

    static void unixTimeExplained() {
        System.out.println("Die Unixzeit ist eine Zeitdefinition, die für das Betriebssystem Unix entwickelt und als POSIX-Standard festgelegt wurde.");
        System.out.println("Die Unixzeit zählt die vergangenen Sekunden seit Donnerstag, dem 1. Januar 1970, 00:00 Uhr UTC. Das Startdatum wird auch als The Epoch bezeichnet.");
        System.out.println("Die Umschaltung von einer Sekunde zur nächsten ist synchron zur UTC.");
        System.out.println("Vor Unix Version 6 (1975) zählte die Unix-Uhr in Hundertstelsekunden, daher musste die Epoche jedes Jahr neu festgelegt werden.");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
