package db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;

public class DBConnectionTest {



    @Mock
    DBConnection dbConnection;

    @Mock
    Connection connection;
    @BeforeEach
    void setup(){

        MockitoAnnotations.openMocks(this);
    }


    @Test

     void  testDbConnectionInstance(){

        Mockito.when(dbConnection.getConnection()).thenReturn(connection);
        assert(dbConnection.getConnection().equals(connection));

    }


}
