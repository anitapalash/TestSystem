package services;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StageLoader {
    //инъекция заголовка главного окна
    private String appTitle;
    private static String staticTitle;

    private static final String FXML_DIR = "../view/";
    private static final String MAIN_STAGE = "LogIn";

    /**
     * Загрузка корневого узла и его дочерних элементов из fxml шаблона
     * @param fxmlName наименование *.fxml файла в ресурсах
     * @return объект типа Parent
     * @throws IOException бросает исключение ввода-вывода
     */
    private static Parent load(String fxmlName) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        // setLocation необходим для корректной загрузки включенных шаблонов, таких как productTable.fxml,
        // без этого получим исключение javafx.fxml.LoadException: Base location is undefined.
        loader.setLocation(StageLoader.class.getResource(FXML_DIR + fxmlName + ".fxml"));
        // setLocation необходим для корректной того чтобы loader видел наши кастомные котнролы
        loader.setClassLoader(StageLoader.class.getClassLoader());
        return loader.load(StageLoader.class.getResourceAsStream(FXML_DIR + fxmlName + ".fxml"));
    }

    public static Stage loadMain() throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(load(MAIN_STAGE)));
        stage.setOnHidden(event -> Platform.exit());
        stage.setTitle(staticTitle);
        return stage;
    }

    public static Stage loadScene(String fxmlName) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(load(fxmlName)));
        return stage;
    }
}
