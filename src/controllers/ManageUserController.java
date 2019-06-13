package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import services.Main;

import java.sql.SQLException;

import static services.Main.selectedUser;

public class ManageUserController {

    @FXML
    private TextField loginField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField groupField;

    @FXML
    private TextField accessField;

    @FXML
    private TextField statusField;

    @FXML
    private Button analyserButton;

    @FXML
    private Button userButton;

    @FXML
    private Button blockButton;

    @FXML
    private Button unblockButton;

    @FXML
    void blockUser(MouseEvent event) {
        Long id = selectedUser.getId();
        Main.dbHandler.changeStatusToBlocked(id);
        userButton.setVisible(false);
        analyserButton.setVisible(false);
    }

    @FXML
    void makeAnalyserRole(MouseEvent event) {
        Long id = selectedUser.getId();
        Main.dbHandler.changeUserStatusToAnalyser(id);

    }

    @FXML
    void makeUserRole(MouseEvent event) {
        Long id = selectedUser.getId();
        Main.dbHandler.changeUserStatusToUser(id);

    }

    @FXML
    void unblockUser(MouseEvent event) {
        Long id = selectedUser.getId();
        Main.dbHandler.changeStatusToActive(id);
        userButton.setVisible(true);
        analyserButton.setVisible(true);
    }

    @FXML
    public void initialize() {

        loginField.setText(selectedUser.getUserName());
        firstNameField.setText(selectedUser.getFirstName());
        lastNameField.setText(selectedUser.getLastName());
        groupField.setText(selectedUser.getGroup());
        accessField.setText(selectedUser.getAccess().toString());
        statusField.setText(selectedUser.getStatus().toString());
        loginField.setEditable(false);
        firstNameField.setEditable(false);
        lastNameField.setEditable(false);
        groupField.setEditable(false);
        accessField.setEditable(false);
        statusField.setEditable(false);


    }

}
