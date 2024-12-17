package Controller;

import Model.MemberTM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

public class MemberTMTest {

    @Mock
    MemberTM memberTM;




    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testMemberTM() {
      Mockito.when(memberTM.getName()).thenReturn("kofi");
      Mockito.when(memberTM.getId()).thenReturn("1");
      Mockito.when(memberTM.getAddress()).thenReturn("East-Legon-BoundaryRoad");
      assert (memberTM.getName().equals("kofi"));
        assert (memberTM.getId().equals("1"));
        assert (memberTM.getAddress().equals("East-Legon-BoundaryRoad"));
    }

    @Test
    void testMemberException(){
        Mockito.when(memberTM.getId()).thenThrow( new NullPointerException());
        Assertions.assertThrows(NullPointerException.class,()->memberTM.getId());
        Mockito.when(memberTM.getAddress()).thenThrow(new NullPointerException());
        Assertions.assertThrows(NullPointerException.class, ()->memberTM.getAddress());
        Mockito.when(memberTM.getContact()).thenThrow(new NullPointerException());
        Assertions.assertThrows(NullPointerException.class,()->memberTM.getContact());
    }

    @Test
    void testMemberMethodCalls(){

    }

}
