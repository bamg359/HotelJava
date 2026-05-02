package application.util;

import application.domain.enums.PersonState;
import java.util.Scanner;

public class FormValidationUtil {

    private final static Scanner sc = new Scanner(System.in);

    public static int validateInt(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                String input = sc.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
            }
        }
    }

    public static double validateDouble(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                String input = sc.nextLine().trim();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número decimal.");
            }
        }
    }

    public static String validateString(String prompt) {
        while (true) {
            System.out.println(prompt);
            String value = sc.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Entrada no válida. El texto no puede estar vacío. Intente de nuevo.");
        }
    }

    // Nuevo método para PersonState
    public static PersonState validatePersonState(String prompt) {
        while (true) {
            System.out.println(prompt);
            System.out.println("1. ACTIVO");
            System.out.println("2. INACTIVO");
            String input = sc.nextLine().trim();
            if (input.equals("1")) {
                return PersonState.ACTIVE;
            } else if (input.equals("2")) {
                return PersonState.INACTIVE;
            }
            System.out.println("Entrada no válida. Por favor, ingrese 1 para ACTIVO o 2 para INACTIVO.");
        }
    }
}



