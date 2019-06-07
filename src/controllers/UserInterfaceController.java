package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import static services.Main.currentUser;

public class UserInterfaceController {
    @FXML
    private TabPane tabPane;

    @FXML
    protected Tab personalInfo;

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

    @FXML
    public void initialize() {
        userNameTextField.setText(currentUser.getUserName());
        firstNameTextField.setText(currentUser.getFirstName());
        surnameTextField.setText(currentUser.getLastName());
        groupTextField.setText(currentUser.getGroup());
        genderTextField.setText(currentUser.getGender());
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

    //часть для управления запуска тестами
    @FXML
    private Tab testTab;

    @FXML
    private Accordion GurenLaganTab;

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

    @FXML
    void loadATTest(ActionEvent event) {
        TestController ATTestController = new TestController("attackTitan.txt");


    }

    @FXML
    void loadDNTest(ActionEvent event) {
        TestController DNTestController = new TestController("deathNote.txt");
    }

    @FXML
    void loadGLTest(ActionEvent event) {
        TestController GLTestController = new TestController("gurrenLagann.txt");

    }

    @FXML
    void loadGenTest(ActionEvent event) {
        TestController GenTestController = new TestController("general.txt");

    }

    @FXML
    void loadNTest(ActionEvent event) {
        TestController NTestController = new TestController("naruto.txt");

    }

    @FXML
    void loadOPTest(ActionEvent event) {
        TestController OPTestController = new TestController("onePiece.txt");

    }

}
