package Model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class BookTMTest {

    @Mock
    BookTM bookTM;


    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testMemberTM() {
        Mockito.when(bookTM.getAuthor()).thenReturn("Perry-Oppong");
        Mockito.when(bookTM.getId()).thenReturn("1");
        Mockito.when(bookTM.getStatus()).thenReturn("Available");
        Mockito.when(bookTM.getTitle()).thenReturn("Tales of kwaku Ananse");
        assert (bookTM.getAuthor()).equals("Perry-Oppong");
        assert (bookTM.getTitle().equals("Tales of kwaku Ananse"));
        assert (bookTM.getId().equals("1"));
        assert (bookTM.getStatus()).equals("Available");

    }

    @Test
    void testMemberException(){
        Mockito.when(bookTM.getId()).thenThrow( new NullPointerException());
        Assertions.assertThrows(NullPointerException.class,()->bookTM.getId());
        Mockito.when(bookTM.getStatus()).thenThrow(new NullPointerException());
        Assertions.assertThrows(NullPointerException.class, ()->bookTM.getStatus());
        Mockito.when(bookTM.getTitle()).thenThrow(new NullPointerException());
        Assertions.assertThrows(NullPointerException.class,()->bookTM.getTitle());
    }

}
