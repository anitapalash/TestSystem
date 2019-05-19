package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;

import java.awt.*;

public class UserInterfaceController {
    @FXML
    protected Tab personalInfo;

    @FXML
    protected Tab testTab;

    @FXML
    protected Button exitButton;

    @FXML
    protected Button editInfoButton;

    @FXML
    protected Button deleteProfileButton;

    @FXML
    protected TextField surnameTextField;

    @FXML
    protected TextField firstNameTextField;

    @FXML
    protected TextField userNameTextField;

    @FXML
    protected TextField groupTextField;

    @FXML
    protected TextField genderTextField;

    static {
        //заполнение полей персональных данных данными текущего пользователя
    }

    @FXML
    void editUserInfo(ActionEvent event) {

    }

    @FXML
    void deleteUser(ActionEvent event) {

    }

    @FXML
    void exit(ActionEvent event) {

    }
}
