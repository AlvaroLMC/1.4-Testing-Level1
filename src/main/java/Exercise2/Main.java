package Exercise2;

import java.util.Scanner;

import static Exercise2.CalculateDNI.calculateDNI;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Indica los primeros 8 caracteres de un DNI: ");
        String numberStrDNI = scanner.nextLine().trim();
        scanner.close();

        try {
            if (!numberStrDNI.matches("\\d{8}")) {
                throw new IllegalArgumentException("Debes introducir exactamente 8 dígitos numéricos.");
            }
            String letter = calculateDNI(numberStrDNI);
            System.out.println("El DNI completo es: " + numberStrDNI + letter);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

