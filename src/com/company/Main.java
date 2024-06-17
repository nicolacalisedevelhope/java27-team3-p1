package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean a = true;
        do{
            System.out.println("1 somma, 2 sottrazione, 3 moltiplicazione, 4 divisione, 5 potenza, 6 controllo pari o dispari, 7 esci");
            int scelta = scanner.nextInt();

            switch (scelta){
                case 1:
                    //somma();
                    break;
                case 2:
                    System.out.println("Con quanti numeri vuoi fare l'operazione?");
                    int qntNum = scanner.nextInt();
                    double[] arraySot = new double[qntNum];
                    double sotTotal = 0;

                    for (int i = 0; i < qntNum ; i++) {
                        System.out.println("Inserisci un numero:");
                        double num = scanner.nextDouble();
                        sotTotal = sottrazione(num,sotTotal,i);
                        arraySot[i] = num;
                    }

                    for (int i = 0; i < qntNum; i++) {
                        if (i<qntNum-1) {
                            System.out.print(arraySot[i] + " - ");
                        }else {
                            System.out.print(arraySot[i] + " = "+sotTotal);
                        }
                    }
                    System.out.println("");

                    break;
                case 3:
                    //moltiplicazione();
                    break;
                case 4:
                    //divisione();
                    break;
                case 5:
                    System.out.println("Inserisci numero base");
                    float base = scanner.nextFloat();
                    System.out.println("Inserisci esponente");
                    int esponente = scanner.nextInt();
                    potenza(base,esponente);
                    break;
                case 6:
                    System.out.println("Inserisci il numero da controllare");
                    int numero = scanner.nextInt();
                    pariDispari(numero);
                    break;
                case 7:
                    a=false;
                    System.out.println("Chiusura calcolatrice");
                    break;
                default:
                    System.out.println("Comando non conosciuto");
            }
        }while(a);

        scanner.close();
    }

    //metodo somma
    public static void somma(){

    }

    //metodo sottrazione

    public static double sottrazione(double num, double sotTotal, int position){
            if (position==0){
                return sotTotal = num;
            }else{
                return sotTotal -= num;
            }
    }

    //metodo moltiplicazione
    public static void moltiplicazione(){

    }

    //metodo divisione
    public static void divisione(){

    }

    //metodo potenza
    public static void potenza(float base, int esponente){
        float risultato = 1;
        for(int i = 0; i < esponente; i++){
            risultato = base * risultato;
        }
        System.out.println(base + " elevato " + esponente + " = " + risultato);
    }

    //metodo controllo pari o dispari
    public static void pariDispari(int numero){
        if((numero % 2) == 0){
            System.out.println("Il numero è pari");
        } else {
            System.out.println("Il numero è dispari");
        }
    }


}
