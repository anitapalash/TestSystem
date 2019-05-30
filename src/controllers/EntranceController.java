package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import libraries.Access;
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

        if (!loginText.equals("") && !loginPassword.equals("")) {
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
        }
    }

    @FXML
    void signUp(ActionEvent event) {
        try {
            Scene currentScene = authSignButton.getScene();
            //currentScene.getWindow().hide();
            Stage stage = StageLoader.loadScene("signUp");
            stage.showAndWait();
        } catch (IOException e) {
            System.out.println("Could not load signUp scene");
        }
    }

    private void loginUser(String loginText, String loginPassword) throws SQLException, IOException, ClassNotFoundException {
        //каким-то образом зафиксировать какой юзер залогинился
        User tempUser = Main.dbHandler.getUser(new User(loginText, loginPassword)); //взять из бд
        if (tempUser.getUserName().equals(loginText)) {
            if (tempUser.getPassword().equals(loginPassword)) {
                System.out.println("Log in successful");
                Main.currentUser = new User(loginText, loginPassword);
                Main.currentUser.setAccess(tempUser.getAccess());
                Main.currentUser.setFirstName(tempUser.getFirstName());
                Main.currentUser.setLastName(tempUser.getLastName());
                Main.currentUser.setGroup(tempUser.getGroup());
                Main.currentUser.setGender(tempUser.getGender());
                loadEnter();
            } else {
                System.out.println("Wrong password");
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

    private void loadEnter() {
        try {
            Scene currentScene = authSignButton.getScene();
            currentScene.getWindow().hide();
            if (Main.currentUser.getAccess() == Access.ADMIN) {
                Stage stage = StageLoader.loadScene("AdminView");
                stage.showAndWait();
            }
            else if (Main.currentUser.getAccess() == Access.ANALISER) {
                Stage stage = StageLoader.loadScene("AnaliserInterface");
                stage.showAndWait();
            }
            else {
                Stage stage = StageLoader.loadScene("UserView");
                stage.showAndWait();
            }
        } catch (IOException e) {
            System.out.println("Failed to load scene");
            e.printStackTrace();
        }
    }
}
