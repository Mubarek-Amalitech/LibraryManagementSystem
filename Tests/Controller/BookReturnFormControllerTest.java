package Controller;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class BookReturnFormControllerTest {

    @Mock
    BookReturnFormController bookReturnFormController;


    @Mock
    MouseEvent event;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);


    }

    @Test
    void testInitializer() throws ClassNotFoundException {
        doNothing().when(bookReturnFormController).initialize();
        bookReturnFormController.initialize();
        verify(bookReturnFormController,times(1)).initialize();
    }

    @Test
    void testMouseBackClickActionMethod() throws IOException {

        doNothing().when(bookReturnFormController).img_back();
        bookReturnFormController.img_back();
        verify(bookReturnFormController,times(1)).img_back();
    }

    @Test
    void testMouseEnterAnimationMethodInvocation()  {

        doNothing().when(bookReturnFormController).playMouseEnterAnimation(event);
        bookReturnFormController.playMouseEnterAnimation(event);
        verify(bookReturnFormController,times(1)).playMouseEnterAnimation(event);
    }

    @Test
    void testMouseEnterAnimationMethodInvocationTwice()  {

        doNothing().when(bookReturnFormController).playMouseEnterAnimation(event);
        bookReturnFormController.playMouseEnterAnimation(event);
        bookReturnFormController.playMouseEnterAnimation(event);
        verify(bookReturnFormController,times(2)).playMouseEnterAnimation(event);
    }



    void testAddInventoryButtonInvocation() throws SQLException {

        doNothing().when(bookReturnFormController).btn_add_inveb();
        bookReturnFormController.btn_add_inveb();
        bookReturnFormController.btn_add_inveb();
        verify(bookReturnFormController,times(2)).btn_add_inveb();
    }

    @Test
    void testMouseEnterAnimationMethodThrowsExceptionGivenNull()  {
        assertThrows(Exception.class,()->{
            doThrow().when(bookReturnFormController).playMouseEnterAnimation(event);
        });
        bookReturnFormController.playMouseEnterAnimation(null);
    }



}
