package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import services.Main;
import services.StageLoader;

import java.io.IOException;

public class UserViewController {
    @FXML
    private Tab personalInfoTab;

    @FXML
    private Button exitButton;

    @FXML
    private TextField surnameTextField;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField userNameTextField;

    @FXML
    private TextField groupTextField;

    @FXML
    private TextField genderTextField;

    @FXML
    private Button editInfoButton;

    @FXML
    private Button deleteProfileButton;

    @FXML
    private Tab testTab;

    @FXML
    private Accordion tests;

    @FXML
    private Button GLTestButton;

    @FXML
    private Text failedGLLabel;

    @FXML
    private Text passedGLLabel;

    @FXML
    private Button OPTestButton;

    @FXML
    private Text failedOPLabel;

    @FXML
    private Text passedOPLabel;

    @FXML
    private Button DNTestButton;

    @FXML
    private Text failedDNLabel;

    @FXML
    private Text passedDNLabel;

    @FXML
    private Button ATTestButton;

    @FXML
    private Text failedATLabel;

    @FXML
    private Text passedATLabel;

    @FXML
    private Button NTestButton;

    @FXML
    private Text failedNLabel;

    @FXML
    private Text passedNLabel;

    @FXML
    private Button GenTestButton;

    @FXML
    private Text failedGenLabel;

    @FXML
    private Text passedGenLabel;

    public void initialize() {
        userNameTextField.setText(Main.currentUser.getUserName());
        firstNameTextField.setText(Main.currentUser.getFirstName());
        surnameTextField.setText(Main.currentUser.getLastName());
        groupTextField.setText(Main.currentUser.getGroup());
        genderTextField.setText(Main.currentUser.getGender());

        //заполнение тестового таба
        if (Main.currentUser.isPassedGL()) {
            passedGLLabel.setVisible(true);
        } else {
            failedGLLabel.setVisible(true);
        }
        if (Main.currentUser.isPassedOP()) {
            passedOPLabel.setVisible(true);
        } else {
            failedOPLabel.setVisible(true);
        }
        if (Main.currentUser.isPassedDN()) {
            passedDNLabel.setVisible(true);
        } else {
            failedDNLabel.setVisible(true);
        }
        if (Main.currentUser.isPassedAT()) {
            passedATLabel.setVisible(true);
        } else {
            failedATLabel.setVisible(true);
        }
        if (Main.currentUser.isPassedN()) {
            passedNLabel.setVisible(true);
        } else {
            failedNLabel.setVisible(true);
        }
        if (Main.currentUser.isPassedGen()) {
            passedGenLabel.setVisible(true);
        } else {
            failedGenLabel.setVisible(true);
        }
    }

    @FXML
    void deleteUser(ActionEvent event) {

    }

    @FXML
    void editUserInfo(ActionEvent event) {

    }

    @FXML
    void exit(ActionEvent event) throws IOException {
        Main.currentUser = null;
        exitButton.getScene().getWindow().hide();
        StageLoader.loadMain();
    }

    @FXML
    void loadATTest(ActionEvent event) {

    }

    @FXML
    void loadDNTest(ActionEvent event) {

    }

    @FXML
    void loadGLTest(ActionEvent event) {

    }

    @FXML
    void loadGenTest(ActionEvent event) {

    }

    @FXML
    void loadNTest(ActionEvent event) {

    }

    @FXML
    void loadOPTest(ActionEvent event) {

    }
}
