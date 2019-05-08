package controllers;

import javafx.fxml.FXML;
import users.User;

import java.awt.*;
import java.awt.event.MouseEvent;

public class RegistrationController {

    @FXML
    private Button submitButton;

    @FXML
    void reg(MouseEvent event) {
        User user = new User();
        //заполнить данные пользователя из полей
        //положить в базу
    }
}
