package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class AdminInterfaceController extends UserInterfaceController {
    @FXML
    private Tab manageUsersTab;

    @FXML
    private Tab editTestsTab;

    @FXML
    private TextField searchUserField;

    @FXML
    private TableColumn<?, ?> loginColumn;

    @FXML
    private TableColumn<?, ?> firstNameColumn;

    @FXML
    private TableColumn<?, ?> surnameColumn;

    @FXML
    private TableColumn<?, ?> accessColumn;

    @FXML
    void searchUser(ActionEvent event) {

    }
}
