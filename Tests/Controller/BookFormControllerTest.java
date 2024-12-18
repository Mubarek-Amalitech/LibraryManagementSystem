package Controller;

import javafx.scene.input.MouseEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class BookFormControllerTest {

@Mock
BookFormController bookFormController;


    @Mock
    MouseEvent mouseEvent;


    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);


    }

    @Test
    void testInitializer() throws ClassNotFoundException {
        doNothing().when(bookFormController).initialize();
        bookFormController.initialize();
        verify(bookFormController,times(1)).initialize();
    }

    @Test
    void testMouseBackClickActionMethod() throws IOException {

        doNothing().when(bookFormController).img_back();
        bookFormController.img_back();
        verify(bookFormController,times(1)).img_back();
    }

    @Test
    void testMouseEnterAnimationMethodInvocation()  {

        doNothing().when(bookFormController).playMouseEnterAnimation(mouseEvent);
        bookFormController.playMouseEnterAnimation(mouseEvent);
        verify(bookFormController,times(1)).playMouseEnterAnimation(mouseEvent);
    }

    @Test
    void testMouseEnterAnimationMethodInvocationTwice()  {

        doNothing().when(bookFormController).playMouseEnterAnimation(mouseEvent);
        bookFormController.playMouseEnterAnimation(mouseEvent);
        bookFormController.playMouseEnterAnimation(mouseEvent);
        verify(bookFormController,times(2)).playMouseEnterAnimation(mouseEvent);
    }


    @Test
    void testMouseEnterAnimationMethodThrowsExceptionGivenNull()  {
        assertThrows(Exception.class,()->{
            doThrow().when(bookFormController).playMouseEnterAnimation(mouseEvent);
        });
        bookFormController.playMouseEnterAnimation(null);

    }

    @Test
    void testDeleteButtonInvocation() throws SQLException {
        doNothing().when(bookFormController).btn_dlt();
        bookFormController.btn_dlt();
        verify(bookFormController,times(1)).btn_dlt();
    }

    @Test
    void testAddButtonInvocation() throws SQLException {
        doNothing().when(bookFormController).btn_Add();
        bookFormController.btn_Add();
        verify(bookFormController,times(1)).btn_Add();
    }

    @Test
    void testNewButtonInvocation() throws SQLException {
        doNothing().when(bookFormController).btn_new();
        bookFormController.btn_new();
        verify(bookFormController,times(1)).btn_new();
    }


}
