package Controller;

import com.jfoenix.controls.JFXComboBox;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class BookIssueFormControllerTest {

    @Mock
    BookIssueFormController bookIssueFormController;

    @Mock
    ActionEvent actionEvent;

 @Mock
    Connection connection;

 @Mock
    MouseEvent mouseEvent;

 @Mock
 PreparedStatement preparedStatement;

 @Mock
    ResultSet resultSet;



    @BeforeEach
     void  setup(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
     void  testAddActionInvocation() throws SQLException {
        doNothing().when(bookIssueFormController).add_Action(actionEvent);
        bookIssueFormController.add_Action(actionEvent);
        bookIssueFormController.add_Action(actionEvent);
        verify(bookIssueFormController,times(2)).add_Action(actionEvent);
    }


    @Test
    void  testNewActonInvocation() throws SQLException {
        doNothing().when(bookIssueFormController).new_action();
        bookIssueFormController.new_action();
        verify(bookIssueFormController,times(1)).new_action();
    }

    @Test
    void  testDeleteActonInvocation() throws SQLException {
        doNothing().when(bookIssueFormController).delete_Action(actionEvent);
        bookIssueFormController.delete_Action(actionEvent);
        bookIssueFormController.delete_Action(actionEvent);
        bookIssueFormController.delete_Action(actionEvent);
        verify(bookIssueFormController,times(3)).delete_Action(actionEvent);
    }


    @Test
    void  testDeleteActionThrowsExceptionWhenGivenNull() throws SQLException {
        assertThrows(Exception.class,()->{
            doThrow().when(bookIssueFormController).delete_Action(isNull());
        });
        bookIssueFormController.add_Action(null);

    }

    @Test
    void  testMouseAnimationMethodInvocation(){
        doNothing().when(bookIssueFormController).playMouseEnterAnimation(mouseEvent);
        bookIssueFormController.playMouseEnterAnimation(mouseEvent);
        verify(bookIssueFormController,times(1)).playMouseEnterAnimation(mouseEvent);

    }

    @Test
    void testMouseAnimationMethodThrowsExceptionWhenGivenNull(){
        assertThrows(Exception.class,()->{
            doThrow().when(bookIssueFormController).playMouseEnterAnimation(isNull());
        });
        bookIssueFormController.playMouseEnterAnimation(null);

    }
@Test
    void  testBackClickInvocation() throws IOException {
        doNothing().when(bookIssueFormController).back_click(mouseEvent);
        bookIssueFormController.back_click(mouseEvent);
        verify(bookIssueFormController,times(1)).back_click(mouseEvent);

    }

    @Test
    void testBackButtonThrowsExceptionWhenGivenNull(){
        assertThrows(Exception.class,()->{
            doThrow().when(bookIssueFormController).back_click(isNull());
        });
        bookIssueFormController.playMouseEnterAnimation(null);
    }

    @Test
    void testPrepareStatementThrowsExceptionWhenNull()  {
        assertThrows(NullPointerException.class,()->{
            bookIssueFormController.connection.prepareStatement("").executeQuery();

        });
    }

    @Test
    void testSelectAllReturnsSomething() throws SQLException {
        when(bookIssueFormController.getSelectALl()).thenReturn(preparedStatement);
        Assertions.assertEquals(preparedStatement,bookIssueFormController.getSelectALl());
        when(bookIssueFormController.getSelectALl().executeQuery()).thenReturn(resultSet);
    }

@Test
 void   testSelectBookDetailReturnsResult() throws SQLException {
      when(bookIssueFormController.getSelectbkdtl()).thenReturn(preparedStatement);
      Assertions.assertEquals(preparedStatement,bookIssueFormController.getSelectbkdtl());
      when(bookIssueFormController.getSelectbkdtl().executeQuery()).thenReturn(resultSet);

}
@Test
    void  testSelectMemberIdReturnResult() throws SQLException {
        when(bookIssueFormController.getSelectmemID()).thenReturn(preparedStatement);
        Assertions.assertEquals(preparedStatement,bookIssueFormController.getSelectmemID());
        when(bookIssueFormController.getSelectmemID().executeQuery()).thenReturn(resultSet);

    }


    @Test
    void  testTableInsertReturnsResult() throws SQLException {
        when(bookIssueFormController.getTable()).thenReturn(preparedStatement);
        Assertions.assertEquals(preparedStatement,bookIssueFormController.getTable());
        when(bookIssueFormController.getTable().executeQuery()).thenReturn(resultSet);

    }


    @Test
    void  testDeleteQueryReturnsResult() throws SQLException {
        when(bookIssueFormController.getDelete()).thenReturn(preparedStatement);
        Assertions.assertEquals(preparedStatement,bookIssueFormController.getDelete());
        when(bookIssueFormController.getDelete().executeQuery()).thenReturn(resultSet);

    }

    @Test
    void  testAddListenerToMemberIdSelection() throws ClassNotFoundException {
        doNothing().when(bookIssueFormController).initialize();
        bookIssueFormController.initialize();
        verify(bookIssueFormController,times(1)).initialize();

    }




}
