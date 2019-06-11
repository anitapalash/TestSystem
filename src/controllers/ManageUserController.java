package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import services.Main;

import java.awt.event.MouseEvent;

public class ManageUserController {

    @FXML
    private TextField loginField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField surnameField;

    @FXML
    private TextField groupField;

    @FXML
    private TextField accessField;

    @FXML
    private TextField statusField;

    @FXML
    private Button makeUserButton;

    @FXML
    private Button makeAnalystButton;

    @FXML
    private Button blockUserButton;

    @FXML
    private Button unlockButton;

    @FXML
    void blockUser(MouseEvent event) {

    }

    @FXML
    void makeAnalystRole(MouseEvent event) {

    }

    @FXML
    void makeUserRole(MouseEvent event) {

    }

    @FXML
    void unlockUser(MouseEvent event) {

    }
    public void initialize() {
        loginField.setText(Main.selectedUser.getUserName());
        nameField.setText(Main.selectedUser.getFirstName());
        surnameField.setText(Main.selectedUser.getLastName());
        groupField.setText(Main.selectedUser.getGroup());
        accessField.setText(String.valueOf(Main.selectedUser.getAccess()));
        statusField.setText(String.valueOf(Main.selectedUser.getStatus()));

        
    }
}
