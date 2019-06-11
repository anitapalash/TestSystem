package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.Main;
import services.StageLoader;

import java.io.IOException;

public class AnaliserInterfaceController {
    @FXML
    private Tab personalInfo;

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
    private Button saveButton;

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
    private Tab editTestsTab;

    @FXML
    private Tab statisticsTab;

    @FXML
    void deleteUser(ActionEvent event) {

    }

    @FXML
    void editUserInfo(ActionEvent event) {
        surnameTextField.setEditable(true);
        firstNameTextField.setEditable(true);
        userNameTextField.setEditable(true);
        groupTextField.setEditable(true);
        saveButton.setVisible(true);
    }

    @FXML
    void saveChanges(ActionEvent event) {
        Main.currentUser.setLastName(surnameTextField.getText());
        Main.currentUser.setFirstName(firstNameTextField.getText());
        Main.currentUser.setUserName(userNameTextField.getText());
        Main.currentUser.setGroup(groupTextField.getText());
        Main.dbHandler.updateUser(Main.currentUser);
        surnameTextField.setEditable(false);
        firstNameTextField.setEditable(false);
        userNameTextField.setEditable(false);
        groupTextField.setEditable(false);
        saveButton.setVisible(false);
    }

    @FXML
    void exit(ActionEvent event) throws IOException {
        Main.currentUser = null;
        exitButton.getScene().getWindow().hide();
        StageLoader.loadMain();
    }

    //часть для управления запуска тестами
    @FXML
    void loadATTest(ActionEvent event) throws IOException {
        TestController ATTestController = new TestController("snk.txt");
        Stage stage = StageLoader.loadTest("test", ATTestController);
        stage.showAndWait();

        if (Main.currentUser.isPassedAT()) {
            failedATLabel.setVisible(false);
            passedATLabel.setVisible(true);
        }
    }

    @FXML
    void loadDNTest(ActionEvent event) throws IOException {
        TestController DNTestController = new TestController("dn.txt");
        Stage stage = StageLoader.loadTest("test", DNTestController);
        stage.showAndWait();

        if (Main.currentUser.isPassedDN()) {
            failedDNLabel.setVisible(false);
            passedDNLabel.setVisible(true);
        }
    }

    @FXML
    void loadGLTest(ActionEvent event) throws IOException {
        TestController GLTestController = new TestController("ttgl.txt");
        Stage stage = StageLoader.loadTest("test", GLTestController);
        stage.showAndWait();

        if (Main.currentUser.isPassedGL()) {
            failedGLLabel.setVisible(false);
            passedGLLabel.setVisible(true);
        }
    }

    @FXML
    void loadGenTest(ActionEvent event) throws IOException {
        GeneralTestController GenTestController = new GeneralTestController();
        Stage stage = StageLoader.loadGenTest("generalTest", GenTestController);
        stage.showAndWait();

        if (Main.currentUser.isPassedGen()) {
            failedGenLabel.setVisible(false);
            passedGenLabel.setVisible(true);
        }
    }

    @FXML
    void loadNTest(ActionEvent event) throws IOException {
        TestController NTestController = new TestController("naruto.txt");
        Stage stage = StageLoader.loadTest("test", NTestController);
        stage.showAndWait();

        if (Main.currentUser.isPassedN()) {
            failedNLabel.setVisible(false);
            passedNLabel.setVisible(true);
        }
    }

    @FXML
    void loadGBTest(ActionEvent event) throws IOException {
        TestController GBTestController = new TestController("gibli.txt");
        Stage stage = StageLoader.loadTest("test", GBTestController);
        stage.showAndWait();

        if (Main.currentUser.isPassedGB()) {
            failedGBLabel.setVisible(false);
            passedGBLabel.setVisible(true);
        }
    }
}
