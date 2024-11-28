package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bingo {

    public void ejercicio1(){

        Scanner teclado = new Scanner(System.in);
        Random aleatorio = new Random();

        System.out.println("*** BIENVENIDO AL BINGO DEL CASINO CANTÁBRICO ***");

        // a) Creamos de forma aleatoria los numeros de las bolas
        int bolas = aleatorio.nextInt(40) + 10; //creacion de numeros aleatorios entre 10 y 40
        int[] vec_bolas = new int [bolas]; //creacion del vector bolas

        for (int i = 0; i < vec_bolas.length; i++) {
            vec_bolas[i] = aleatorio.nextInt(90) + 1; //creacion del vector de 90 numeros aleatorios
        }

        System.out.println("2º bolas exatraidas hasta ahora: " + Arrays.toString(vec_bolas));

        // b) Buscamos repetidos para recalcularlos
        Arrays.sort(vec_bolas);
        boolean repetido = true;
        while (repetido){
            repetido = false;
            for (int i = 0; i < vec_bolas.length; i++) {
                if (i != vec_bolas.length - 1 && vec_bolas[i] == vec_bolas.length){
                    vec_bolas[i] = aleatorio.nextInt(49) + 1;
                    repetido = true;
                }
                Arrays.sort(vec_bolas);
            }
        }

        // c) Introducir datos del cartón
        System.out.println("*** Introduce los datos de tu cartón ***");
        int[][] matriz_datos = new int[3][3];
        String formato_texto  = "\\d{1,2}-\\d{1,2}-\\d{1,2}";

        for (int i = 0; i < matriz_datos.length; i++) {
            System.out.println("Fila" + (i + 1) + ":");
            String[] separador = teclado.next().split("-");

            for (int j = 0; j < matriz_datos[i].length; j++) {

                matriz_datos[i][j] = Integer.parseInt(separador[j]);
            }
        }

        // d) Imprimir datos del cartón introducido
        System.out.println("Boletos del carton introducido");
        for (int i = 0; i < matriz_datos.length; i++) {
            for (int j = 0; j < matriz_datos[i].length; j++) {
                System.out.print(matriz_datos[i][j] + " ");
            }
            System.out.println("\n");
        }

        // e) Comprobar el premio bingo

        System.out.println("PREMIOS: ");

        boolean numeros =Arrays.asList(vec_bolas).contains(matriz_datos);
        if (numeros) {
            System.out.println("Hay Bingo !!");
        }else {
            System.out.println("No hay Bingo");
        }






    }
}
