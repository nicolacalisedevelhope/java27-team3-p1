package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------MENU----------------------------------------------------------------");
        System.out.println("+ => somma | - => sottrazione | * => moltiplicazione | / => divisione | ^ => potenza | solo numero => pari o dispari | esci => per uscire");
        System.out.println("Per utilizare la potenza, serve solo 2 numeri, il primo è la base e il secondo la potenza");
        System.out.println("Tutte le altre operazioni possono essere eseguite con più di un numero, basta inserire il numero e l'operazione senza spazi!");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");

        //Variabile per uscire se c'è un errore nell'operazione
        boolean uscire = false;

        while (!uscire) {
            //Inserendo l'operazione come una stringa per accettare numeri e caratteri
            System.out.println("Inserisci l'operazione");
            String calcolo = scanner.nextLine();

            //Creazione di una lista in modo che non ci sia limite di inserimento, divisa tra inserimento di caratteri operazione o numeri inseriti
            List<String> arrayOperazione = new ArrayList<>();
            List<Double> arrayNumeri = new ArrayList<>();

            if (Objects.equals(calcolo.toUpperCase(), "ESCI") || Objects.equals(calcolo.toUpperCase(), "exit")) {
                uscire = true;
            } else {
                //Variabili di controllo logico per separare ciascun carattere
                boolean charOperazione = false;
                int ultimaPosition = 0;
                int controlo = 0;

                //"For" attraversa l'intera stringa in modo che possa eseguire la logica di ottenere la posizione dell'ultimo carattere dell'operazione se il numero ha più di due passaggi di loop
                for (int i = 0; i < calcolo.length(); i++) {
                    if (!((calcolo.charAt(i) == '0') || (calcolo.charAt(i) == '1') || (calcolo.charAt(i) == '2') || (calcolo.charAt(i) == '3') || (calcolo.charAt(i) == '4') || (calcolo.charAt(i) == '5') || (calcolo.charAt(i) == '6') || (calcolo.charAt(i) == '7') || (calcolo.charAt(i) == '8') || (calcolo.charAt(i) == '9'))) {
                        if ((ultimaPosition == i - 1 && i > 1) || i == 0) {
                            System.out.println("Sintaxe incorreta!");
                            arrayNumeri.clear();
                            arrayOperazione.clear();
                            break;
                        } else {
                            arrayOperazione.add(String.valueOf(calcolo.charAt(i)));
                            if (!(ultimaPosition == i - 1) || i == 1) {
                                charOperazione = true;
                            }
                            ultimaPosition = i;

                        }
                    }

                    if (calcolo.length() - 1 == i) {
                        charOperazione = true;
                        ultimaPosition = i + 1;
                    }

                    if (charOperazione) {
                        arrayNumeri.add(Double.valueOf(calcolo.substring(controlo, ultimaPosition)));
                        controlo = i + 1;
                        charOperazione = false;
                    }
                }
            }

            //Conteggio di controllo per arrayNumeri
            int cont = 0;

            //Variabile di archiviazione per l'ultima operazione eseguita
            double ultimo = 0;
            if (!(arrayNumeri.isEmpty()) && !(arrayOperazione.isEmpty())) {
                for (int i = 0; i < arrayOperazione.size(); i++) {
                    boolean errore = false;
                    switch (arrayOperazione.get(i)) {
                        case "+":
                            //somma();
                            break;

                        case "-":
                            double sotTotal;

                            ultimo = arrayNumeri.get(cont);
                            sotTotal = sottrazione(ultimo, arrayNumeri.get(cont + 1));


                            System.out.println("La sottrazione tra " + ultimo + " e " + arrayNumeri.get(cont + 1) + " risulta: " + sotTotal);
                            ultimo = sotTotal;
                            break;

                        case "*":
                            //moltiplicazione();
                            break;

                        case "/":
                            double[] ritorno;

                            //ritorno[0] = quoziente | ritorno[1] = resto | ritorno[2] = dividendo 0
                            if (i == 0) {
                                ultimo = arrayNumeri.get(cont);
                            }
                            ritorno = divisione(ultimo, arrayNumeri.get(cont + 1));

                            if (ritorno[2] == 1) {
                                errore = true;
                                System.out.println("Non è possibile dividere un numero per 0!");
                                break;
                            }

                            System.out.println("la divisione tra " + ultimo + " e " + arrayNumeri.get(cont + 1) + " risulta il quoziente: " + ritorno[0] + " Resto: " + ritorno[1]);
                            ultimo = ritorno[0];
                            break;

                        case "^":
                            System.out.println("Inserisci numero base");
                            float base = scanner.nextFloat();
                            System.out.println("Inserisci esponente");
                            int esponente = scanner.nextInt();
                            potenza(base, esponente);
                            break;

                        default:
                            System.out.println("Operazione non conosciuta");
                            errore = true;
                            break;

                    }
                    cont++;
                    if (errore) {
                        break;
                    }
                }
            } else if (!(arrayNumeri.isEmpty())) {
                //pari e dispare
                pariDispari(arrayNumeri.getFirst());
                System.out.println("Aqui!");
            }
        }
        scanner.close();
    }


    //metodo somma
    public static void somma() {

    }

    //metodo sottrazione
    public static double sottrazione(double num, double num2) {
        return num - num2;
    }

    //metodo moltiplicazione
    public static void moltiplicazione() {

    }

    //metodo divisione
    public static double[] divisione(double dividendo, double diviso) {
        //Matrice di 3 valori restituiti
        double[] ritorno = new double[3];

        //Caso il numero diviso sia 0, deve informare il main
        if (diviso == 0) {
            System.out.println("Impossibile dividere per 0!");
            ritorno[2] = 1;
        } else {
            ritorno[0] = dividendo / diviso;
            ritorno[1] = dividendo % diviso;
        }

        return ritorno;
    }

    //metodo potenza
    public static void potenza(float base, int esponente) {
        float risultato = 1;
        for (int i = 0; i < esponente; i++) {
            risultato = base * risultato;
        }
        System.out.println(base + " elevato " + esponente + " = " + risultato);
    }

    //metodo controllo pari o dispari
    public static void pariDispari(double numero) {
        if ((numero % 2) == 0) {
            System.out.println("Il numero inserito è pari");
        } else {
            System.out.println("Il numero inserito è dispari");
        }
    }
}