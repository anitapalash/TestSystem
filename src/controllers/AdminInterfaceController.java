package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class AdminInterfaceController extends UserViewController {

    @FXML
    private Tab manageUsersTab;

    @FXML
    private TableColumn<?, ?> loginColumn;

    @FXML
    private TableColumn<?, ?> firstNameColumn;

    @FXML
    private TableColumn<?, ?> surnameColumn;

    @FXML
    private TableColumn<?, ?> accessColumn;

    @FXML
    private Tab editTestsTab;


}
