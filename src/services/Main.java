package services;

import db.DataBaseHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import libraries.Access;
import users.User;

import java.io.IOException;

public class Main extends Application {
    public static DataBaseHandler dbHandler = new DataBaseHandler();
    public static User currentUser;

    @Override
    public void start(Stage primaryStage) throws Exception{
        StageLoader.loadMain().showAndWait();

        try {
            if (currentUser.getAccess() == Access.ADMIN) {
                Stage stage = StageLoader.loadTabPane("AdminView");
                stage.showAndWait();
            }
            else if (currentUser.getAccess() == Access.ANALISER) {
                Stage stage = StageLoader.loadTabPane("AnaliserInterface");
                stage.showAndWait();
            }
            else {
                Stage stage = StageLoader.loadTabPane("UserViewA");
                stage.showAndWait();
            }
        } catch (IOException e) {
            System.out.println("Failed to load scene");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
