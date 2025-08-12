package com.alura.conversor;

import java.util.Scanner;

public class Conversor {

    private final String[][] opciones = {
            {"CLP", "ARS"},
            {"ARS", "CLP"},
            {"CLP", "BOB"},
            {"BOB", "CLP"},
            {"CLP", "BRL"},
            {"BRL", "CLP"},
            {"CLP", "COP"},
            {"COP", "CLP"},
            {"CLP", "USD"},
            {"USD", "CLP"},
            {"CLP", "CAD"},
            {"CAD", "CLP"}
    };

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("************************************************************");
            System.out.println("Bienvenido/a al Conversor del Peso Chileno.");
            System.out.println("************************************************************");
            System.out.println("En este conversor usted podrá conocer la conversión del\nPeso Chileno [CLP] a las siguientes monedas:\n" +
                    "\nARS: Peso Argentino.\nBOB: Boliviano.\nBRL: Real.\nCOP: Peso Colombiano.\nUSD: Dólar estadounidense.\nCAD: Dólar canadiense.\n");
            System.out.println("************************************************************");

            System.out.println("Estas son las opciones de conversión disponibles:\n");
            for (int i = 0; i < opciones.length; i++) {
                System.out.println((i + 1) + ". " + opciones[i][0] + " a " + opciones[i][1] + ".");
            }
            System.out.println((opciones.length + 1) + ". Salir de la aplicación.\n");
            System.out.println("************************************************************");

            // Validación de opción del menú con rango.
            int opcion = -1;
            while (true) {
                System.out.print("Ingrese el número correspondiente a la opción del menú\nque desea ejecutar: ");
                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    if (opcion >= 1 && opcion <= opciones.length + 1) {
                        break; // opción válida, salir del bucle.
                    } else {
                        System.out.println("************************************************************");
                        System.out.println("Opción inválida.\nDebe ingresar una opción del menú de 1 a " + (opciones.length + 1) + ".");
                    }
                } else {
                    System.out.println("************************************************************");
                    System.out.println("Entrada inválida.\nDebe ingresar un número entero del menú de 1 a " + (opciones.length + 1) + ".");
                    scanner.next(); // limpiar entrada inválida.
                }
            }

            if (opcion == opciones.length + 1) {
                continuar = false;
                System.out.println("Gracias por utilizar esta Aplicación. ¡Hasta Pronto!");
            } else {
                System.out.println("************************************************************");
                String monedaOrigen = opciones[opcion - 1][0];
                String monedaDestino = opciones[opcion - 1][1];
                // Validación del monto a convertir.
                double cantidad = 0;
                while (true) {
                    System.out.print("Ingrese la cantidad en " + monedaOrigen + ": ");
                    if (scanner.hasNextDouble()) {
                        cantidad = scanner.nextDouble();
                        if (cantidad > 0) {
                            break;
                        } else {
                            System.out.println("La cantidad debe ser mayor a cero.");
                        }
                    } else {
                        System.out.println("************************************************************");
                        System.out.println("Entrada inválida. Debe ingresar un número válido.");
                        scanner.next(); // limpiar entrada inválida.
                    }
                }

                ConsultaConversion consulta = new ConsultaConversion();
                try {
                    double tasa = consulta.obtenerTasaPar(monedaOrigen, monedaDestino);
                    double resultado = cantidad * tasa;
                    System.out.printf("%.2f [%s] equivalen a %.2f [%s].\n",
                            cantidad, monedaOrigen, resultado, monedaDestino);
                } catch (Exception e) {
                    System.out.println("Error en la conversión: " + e.getMessage());
                }
            }
        }
        scanner.close();
    }
}