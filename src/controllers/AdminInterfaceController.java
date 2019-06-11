package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import services.Main;
import services.StageLoader;

import java.io.IOException;

public class AdminInterfaceController {
    @FXML
    protected Tab personalInfoTab;

    @FXML
    protected Button exitButton;

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
    private Button GBTestButton;

    @FXML
    private Text failedGBLabel;

    @FXML
    private Text passedGBLabel;

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

    @FXML
    public void initialize() {
        //testTab.onSelectionChangedProperty(event -> tabPane.getSelectionModel().selectNext());
        userNameTextField.setText(currentUser.getUserName());
        firstNameTextField.setText(currentUser.getFirstName());
        surnameTextField.setText(currentUser.getLastName());
        groupTextField.setText(currentUser.getGroup());
        genderTextField.setText(currentUser.getGender());

        //заполнение тестового таба
        if (Main.currentUser.isPassedGL()) {
            passedGLLabel.setVisible(true);
        } else {
            failedGLLabel.setVisible(true);
        }
        if (Main.currentUser.isPassedGB()) {
            passedGBLabel.setVisible(true);
        } else {
            failedGBLabel.setVisible(true);
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
    private TableColumn<?, ?> loginColumn;

    @FXML
    private TableColumn<?, ?> firstNameColumn;

    @FXML
    private TableColumn<?, ?> surnameColumn;

    @FXML
    void loadATTest(ActionEvent event) throws IOException {
        TestController ATTestController = new TestController("snk.txt");
        Stage stage = StageLoader.loadTest("test", ATTestController);
        stage.showAndWait();
        if (currentUser.isPassedAT()) {
            failedATLabel.setVisible(false);
            passedATLabel.setVisible(true);
        }
    }

    @FXML
    void loadDNTest(ActionEvent event) throws IOException {
        TestController DNTestController = new TestController("dn.txt");
        Stage stage = StageLoader.loadTest("test", DNTestController);
        stage.showAndWait();

        if (currentUser.isPassedDN()) {
            failedDNLabel.setVisible(false);
            passedDNLabel.setVisible(true);
        }
    }

    @FXML
    void loadGLTest(ActionEvent event) throws IOException {
        TestController GLTestController = new TestController("ttgl.txt");
        Stage stage = StageLoader.loadTest("test", GLTestController);
        stage.showAndWait();

        if (currentUser.isPassedGL()) {
            failedGLLabel.setVisible(false);
            passedGLLabel.setVisible(true);
        }
    }

    @FXML
    void loadGenTest(ActionEvent event) throws IOException {
        TestController GenTestController = new TestController("general.txt");
        Stage stage = StageLoader.loadTest("test", GenTestController);
        stage.showAndWait();

        if (currentUser.isPassedGen()) {
            failedGenLabel.setVisible(false);
            passedGenLabel.setVisible(true);
        }
    }

    @FXML
    void loadNTest(ActionEvent event) throws IOException {
        TestController NTestController = new TestController("naruto.txt");
        Stage stage = StageLoader.loadTest("test", NTestController);
        stage.showAndWait();

        if (currentUser.isPassedN()) {
            failedNLabel.setVisible(false);
            passedNLabel.setVisible(true);
        }
    }

    @FXML
    void loadGBTest(ActionEvent event) throws IOException {
        TestController OPTestController = new TestController("gibli.txt");
        Stage stage = StageLoader.loadTest("test", OPTestController);
        stage.showAndWait();

        if (currentUser.isPassedGB()) {
            failedGBLabel.setVisible(false);
            passedGBLabel.setVisible(true);
        }
    }

    @FXML
    private Tab manageUsersTab;

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
    private TableColumn<?, ?> accessColumn;

    @FXML
    private Tab editTestsTab;
}
