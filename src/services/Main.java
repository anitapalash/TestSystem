package services;

import db.DataBaseHandler;
import javafx.application.Application;
import javafx.stage.Stage;
import users.User;

public class Main extends Application {
    public static DataBaseHandler dbHandler = new DataBaseHandler();
    public static User currentUser;

    @Override
    public void start(Stage primaryStage) throws Exception{
        StageLoader.loadMain().showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
