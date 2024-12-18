package Model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class BookIssueTMTest {

@Mock
BookIssueTM bookIssueTM;


    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testMemberTM() {
        Mockito.when(bookIssueTM.getIssueId()).thenReturn("P001");
        Mockito.when(bookIssueTM.getMemberId()).thenReturn("M001");
        Mockito.when(bookIssueTM.getBookId()).thenReturn("B001");
        Mockito.when(bookIssueTM.getDate()).thenReturn("10-12-2024");
        assert (bookIssueTM.getIssueId()).equals("P001");
        assert (bookIssueTM.getMemberId().equals("M001"));
        assert (bookIssueTM.getDate().equals("10-12-2024"));
        assert (bookIssueTM.getBookId()).equals("B001");

    }

    @Test
    void testMemberException(){
        Mockito.when(bookIssueTM.getMemberId()).thenThrow( new NullPointerException());
        Assertions.assertThrows(NullPointerException.class,()->bookIssueTM.getMemberId());
        Mockito.when(bookIssueTM.getBookId()).thenThrow(new NullPointerException());
        Assertions.assertThrows(NullPointerException.class, ()->bookIssueTM.getBookId());
        Mockito.when(bookIssueTM.getIssueId()).thenThrow(new NullPointerException());
        Assertions.assertThrows(NullPointerException.class,()->bookIssueTM.getIssueId());
    }

}
