import db.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.sql.SQLException;
import java.util.Objects;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
        try {
            DBConnection.getInstance().getConnection().close();
        } catch (SQLException e) {
            throw  new RuntimeException(e.getMessage());
        }
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/View/HomeFormView.fxml")))));
        primaryStage.show();
    }
}
