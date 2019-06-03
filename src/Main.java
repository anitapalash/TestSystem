import db.DataBaseHandler;
import javafx.application.Application;
import javafx.stage.Stage;
import services.StageLoader;

import java.sql.Connection;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        StageLoader.loadMain().showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
