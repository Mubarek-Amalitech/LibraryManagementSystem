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
import static org.mockito.Mockito.doThrow;

public class HomeFormControllerTest {


    @Mock
    MouseEvent event;

    @Mock
    HomeFormController homeFormController;
    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);


    }

    @Test
    void testMouseNavigationMethod() throws IOException {
        doNothing().when(homeFormController).navigate(event);
        homeFormController.navigate(event);

        verify(homeFormController,times(1)).navigate(event);
    }



    @Test
    void testMouseExitAnimationMethodInvocation()  {

        doNothing().when(homeFormController).playMouseExitAnimation(event);
        homeFormController.playMouseExitAnimation(event);
        verify(homeFormController,times(1)).playMouseExitAnimation(event);
    }


    @Test
    void testMouseEnterAnimationMethodInvocation()  {

        doNothing().when(homeFormController).playMouseEnterAnimation(event);
        homeFormController.playMouseEnterAnimation(event);
        verify(homeFormController,times(1)).playMouseEnterAnimation(event);
    }

    @Test
    void testMouseEnterAnimationMethodInvocationTwice()  {

        doNothing().when(homeFormController).playMouseEnterAnimation(event);
        homeFormController.playMouseEnterAnimation(event);
        homeFormController.playMouseEnterAnimation(event);
        verify(homeFormController,times(2)).playMouseEnterAnimation(event);
    }

    @Test
    void testMouseExitAnimationMethodInvocationTwice()  {
        doNothing().when(homeFormController).playMouseExitAnimation(event);
        homeFormController.playMouseExitAnimation(event);
        homeFormController.playMouseExitAnimation(event);
        verify(homeFormController,times(2)).playMouseExitAnimation(event);
    }


@Test
    void testNavigateThrowsExceptionWhenGivenNull() throws IOException {
        assertThrows(Exception.class,()->{
            doThrow().when(homeFormController).navigate(isNull());
        });
        homeFormController.navigate(null);
    }

    @Test
    void testMouseEnterAnimationMethodThrowsExceptionGivenNull()  {
        assertThrows(Exception.class,()->{
            doThrow().when(homeFormController).playMouseEnterAnimation(event);
        });
        homeFormController.playMouseEnterAnimation(null);
    }


    @Test
    void testMouseExitAnimationMethodThrowsExceptionGivenNull()  {
        assertThrows(Exception.class,()->{
            doThrow().when(homeFormController).playMouseExitAnimation(event);
        });
        homeFormController.playMouseExitAnimation(event);
    }


}
