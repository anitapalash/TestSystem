package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import libraries.Status;
import services.Main;
import services.StageLoader;
import users.User;

public class EntranceController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button authSignButton;

    @FXML
    private Button signUpButton;

    @FXML
    void logIn(ActionEvent event) {
        String loginText = login_field.getText().trim();
        String loginPassword = password_field.getText().trim();

        if (!loginText.equals("") && !loginPassword.equals("") ) {
            try {
                loginUser(loginText, loginPassword);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Login and Password is Empty");
            //добавить окно с выводом ошибки, какой юзер дурак - ничего не написал
        }
    }

    @FXML
    void signUp(ActionEvent event) {
        try {
            Scene currentScene = authSignButton.getScene();
            Stage stage = StageLoader.loadScene("signUp");
            stage.showAndWait();
        } catch (IOException e) {
            System.out.println("Could not load signUp scene");
        }
    }

    private void loginUser(String loginText, String loginPassword) throws SQLException, IOException, ClassNotFoundException {
        User tempUser = Main.dbHandler.getUser(new User(loginText)); //взять из бд
        if (tempUser != null) {
            if (tempUser.getPassword().equals(loginPassword)) {
                if(tempUser.getStatus().equals(Status.ACTIVE)) {
                    System.out.println("Log in successful");
                    Main.currentUser = tempUser;
                    Scene currentScene = authSignButton.getScene();
                    currentScene.getWindow().hide();
                } else {
                    try {
                        Scene currentScene = authSignButton.getScene();
                        Stage stage = StageLoader.loadScene("Blocked");
                        stage.showAndWait();
                    } catch (IOException e) {
                        System.out.println("Could not load blocked scene");
                    }
                }
            } else {
                System.out.println("Wrong password or you are blocked/deleted");
                Shake userLoginAnim = new Shake(login_field);
                Shake userPassAnim = new Shake(password_field);
                userLoginAnim.playAnim();
                userPassAnim.playAnim();
            }
        } else {
            System.out.println("No such user in the database");
            Shake userLoginAnim = new Shake(login_field);
            Shake userPassAnim = new Shake(password_field);
            userLoginAnim.playAnim();
            userPassAnim.playAnim();
        }
    }
}
