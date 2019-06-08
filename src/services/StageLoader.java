package services;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StageLoader {
    private static String staticTitle = "AnimeTest";

    private static final String FXML_DIR = "../view/";

    public static Stage loadMain() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(StageLoader.class.getResource(FXML_DIR + "LogIn" + ".fxml"));
        loader.setClassLoader(StageLoader.class.getClassLoader());
        Scene scene = new Scene(loader.load(StageLoader.class.getResourceAsStream(FXML_DIR + "LogIn" + ".fxml")));
        stage.setScene(scene);
        stage.setTitle(staticTitle);
        return stage;
    }

    public static Stage loadScene(String fxmlName) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(StageLoader.class.getResource(FXML_DIR + fxmlName + ".fxml"));
        loader.setClassLoader(StageLoader.class.getClassLoader());
        Scene scene = new Scene(loader.load(StageLoader.class.getResource(FXML_DIR + fxmlName + ".fxml")));
        stage.setScene(scene);
        stage.setOnHidden(event -> Platform.exit());
        stage.setTitle(staticTitle);
        return stage;
    }

    public static Stage loadTabPane(String fxmlName) throws IOException {
        TabPane root = FXMLLoader.load(StageLoader.class.getResource(FXML_DIR + fxmlName + ".fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setOnHidden(event -> Platform.exit());
        stage.setTitle(staticTitle);
        return stage;
    }
}
