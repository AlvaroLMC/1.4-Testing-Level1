package Exercise2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static Exercise2.CalculateDNI.calculateDNI;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateDNITest {
    @ParameterizedTest
    @CsvSource({
        "12345678, Z",
        "00000000, T",
        "11111111, H",
        "22222222, J",
        "33333333, P",
        "44444444, A",
        "55555555, K",
        "66666666, Q",
        "77777777, B",
        "88888888, Y"
    })

    public void testCalculateDNI(String number, String expectedLetter) {
            String actualLetter = calculateDNI(number);
            assertEquals(expectedLetter, actualLetter, "La letra del DNI no coincide");
        }

}
