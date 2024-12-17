package Controller;

import javafx.scene.input.MouseEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class BookSearchFormControllerTest {
    @Mock
    BookSearchFormController bookSearchFormController;

    @Mock
    MouseEvent mouseEvent;


    @BeforeEach
     void setup(){
        MockitoAnnotations.openMocks(this);


    }

    @Test
    void testInitializer(){
        doNothing().when(bookSearchFormController).initialize();
        bookSearchFormController.initialize();
        verify(bookSearchFormController,times(1)).initialize();
    }

    @Test
    void testMouseBackClickActionMethod() throws IOException {

        doNothing().when(bookSearchFormController).img_bk();
        bookSearchFormController.img_bk();
        verify(bookSearchFormController,times(1)).img_bk();
    }

    @Test
    void testMouseEnterAnimationMethodInvocation()  {

        doNothing().when(bookSearchFormController).playMouseEnterAnimation(mouseEvent);
        bookSearchFormController.playMouseEnterAnimation(mouseEvent);
        verify(bookSearchFormController,times(1)).playMouseEnterAnimation(mouseEvent);
    }

    @Test
    void testMouseEnterAnimationMethodInvocationTwice()  {

        doNothing().when(bookSearchFormController).playMouseEnterAnimation(mouseEvent);
        bookSearchFormController.playMouseEnterAnimation(mouseEvent);
        bookSearchFormController.playMouseEnterAnimation(mouseEvent);
        verify(bookSearchFormController,times(2)).playMouseEnterAnimation(mouseEvent);
    }


    @Test
    void testMouseEnterAnimationMethodThrowsExceptionGivenNull()  {
        assertThrows(Exception.class,()->{
            doThrow().when(bookSearchFormController).playMouseEnterAnimation(mouseEvent);
        });
        bookSearchFormController.playMouseEnterAnimation(null);
    }

}
