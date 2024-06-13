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
                    //sottrazione();
                    break;
                case 3:
                    //moltiplicazione();
                    break;
                case 4:
                    //divisione();
                    break;
                case 5:
                    //potenza();
                    break;
                case 6:
                    //pariDispari();
                    break;
                case 7:
                    a=false;
                    System.out.println("Hai spento la calcolatrice");
                default:
                    System.out.println("Comando non conosciuto");
            }
        }while(a);
    }

    //metodo somma
    public void somma(){

    }

    //metodo sottrazione
    public void sottrazione(){

    }

    //metodo moltiplicazione
    public void moltiplicazione(){

    }

    //metodo divisione
    public void divisione(){

    }

    //metodo potenza
    public void potenza(){

    }

    //metodo controllo pari o dispari
    public void pariDispari(){

    }


}
