import javafx.application.Application;
import javafx.stage.Stage;
import services.StageLoader;

public class Main extends Application {
//по идее здесь надо только создать форму, прикрепить к ней контроллер и запустить
    @Override
    public void start(Stage primaryStage) throws Exception{
        StageLoader.loadMain();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
