package Exercise2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CalculateDNI {
    private final String numberStrDNI;

    public CalculateDNI(String numberStrDNI) {
        this.numberStrDNI = numberStrDNI;
    }
    public String getNumberStrDNI() {
        return numberStrDNI;
    }

    public static String calculateDNI(String numberStrDNI) {
        int numberIntDNI = Integer.parseInt(numberStrDNI.trim());
        int residue = numberIntDNI % 23;

        List<String> letters = Arrays.asList(
                "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X",
                "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"
        );

        return letters.get(residue);
    }
}




