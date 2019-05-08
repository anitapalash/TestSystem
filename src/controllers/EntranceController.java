package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class EntranceController {
    //логика входа в систему
    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    private Hyperlink registrationLink;

    @FXML
    private Button enterButton;

    @FXML
    void enterButtonPressed(ActionEvent event) {
        submit(loginField.getText(), passwordField.getText());
    }

    @FXML
    void signUp(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/RegistrationWindow.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Registration");
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void submit(String login, String password) {
        //сверка логина/пароля с базой
    }
}
