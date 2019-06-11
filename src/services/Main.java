package services;

import db.DataBaseHandler;
import javafx.application.Application;
import javafx.application.Platform;
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
    public static User selectedUser;

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
                TabPane root = FXMLLoader.load(getClass().getResource("../view/UserViewA.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
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
