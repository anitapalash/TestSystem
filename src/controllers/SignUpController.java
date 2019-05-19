package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import libraries.DataBaseHandler;
import users.User;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField signUpName;

    @FXML
    private TextField signUpLastName;

    @FXML
    private TextField signUpCity;

    @FXML
    private CheckBox signUpCheckBoxMale;

    @FXML
    private CheckBox signUpCheckBoxFemale;

    @FXML
    void initialize() {
        signUpButton.setOnAction(event -> {
            signUpNewUser();
        });
    }

    private void signUpNewUser() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        String firstName= signUpName.getText();
        String lastName= signUpLastName.getText();
        String userName= login_field.getText();
        String password= password_field.getText();
        String location= signUpCity.getText();
        String gender= "";
        if(signUpCheckBoxMale.isSelected())
            gender="Мужской";
        else
            gender="Женский";
        User user = new User(firstName, lastName, userName, password, gender, location );
        dbHandler.signUpUser(user);
    }
}
