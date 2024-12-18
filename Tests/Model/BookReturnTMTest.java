package Model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class BookReturnTMTest {


    @Mock
    BookReturnTM bookReturnTM;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testMemberTM() {
        Mockito.when(bookReturnTM.getReturnedDate()).thenReturn("11-12-2024");
        Mockito.when(bookReturnTM.getIssuedDate()).thenReturn("10-12-2024");
        Mockito.when(bookReturnTM.getFine()).thenReturn(20f);
        Mockito.when(bookReturnTM.getId()).thenReturn("I-001");
        assert (bookReturnTM.getReturnedDate()).equals("11-12-2024");
        assert (bookReturnTM.getIssuedDate().equals("10-12-2024"));
        assert (bookReturnTM.getFine()==20f);
        assert (bookReturnTM.getId()).equals("I-001");

    }

    @Test
    void testMemberException(){
        Mockito.when(bookReturnTM.getId()).thenThrow( new NullPointerException());
        Assertions.assertThrows(NullPointerException.class,()->bookReturnTM.getId());
        Mockito.when(bookReturnTM.getReturnedDate()).thenThrow(new NullPointerException());
        Assertions.assertThrows(NullPointerException.class, ()->bookReturnTM.getReturnedDate());
        Mockito.when(bookReturnTM.getIssuedDate()).thenThrow(new NullPointerException());
        Assertions.assertThrows(NullPointerException.class,()->bookReturnTM.getReturnedDate());
    }

}
