package Exercise3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static Exercise3.ArrayIndex.getElementAtIndex;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayIndexTest {

    private List<Integer> myArray;

    @BeforeEach
    public void setUp() {
        myArray = new ArrayList<>();
        myArray.add(1);
        myArray.add(2);
        myArray.add(3);
    }

    @Test
    void testArrayIndexOutOfBoundsException() {

        assertThrows(IndexOutOfBoundsException.class, () -> getElementAtIndex(myArray, 3));
    }
}
