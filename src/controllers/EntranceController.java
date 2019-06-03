package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import db.DataBaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import libraries.Access;
import services.StageLoader;
import users.User;

public class EntranceController {
    protected static User user = new User();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button authSignButton;

    @FXML
    private Button loginSignUpButton;

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
            StageLoader.loadScene("signUp").showAndWait();
        } catch (IOException e) {
            System.out.println("Could not load signUp scene");
        }
    }

    private void loginUser(String loginText, String loginPassword) throws SQLException, IOException, ClassNotFoundException {
        //каким-то образом зафиксировать какой юзер залогинился
        user.setUserName(loginText);
        user.setPassword(loginPassword);

        DataBaseHandler dbHandler = new DataBaseHandler();

        Long i = Long.parseLong("0");
        while (true) {
            User tempUser = dbHandler.getUserById(i); //взять из бд
            if (tempUser.getUserName().equals(user.getUserName())) {
                if (tempUser.getPassword().equals(user.getPassword())) {
                    System.out.println("Log in successful");
                    loadEnter();
                    break;
                } else {
                    System.out.println("Wrong password");
                    Shake userLoginAnim = new Shake(login_field);
                    Shake userPassAnim = new Shake(password_field);
                    userLoginAnim.playAnim();
                    userPassAnim.playAnim();
                }
            } else {
                if (!tempUser.getUserName().equals(null))
                    i++;
                else {
                    System.out.println("No such user in database");
                    break;
                }
            }
        }
    }

    private void loadEnter() {
        try {
            Scene currentScene = authSignButton.getScene();
            currentScene.getWindow().hide();
            if (user.getAccess() == Access.ADMIN)
                StageLoader.loadScene("AdminView");
            else if (user.getAccess() == Access.ANALISER)
                StageLoader.loadScene("AnaliserInterface");
            else
                StageLoader.loadScene("UserView");
        } catch (IOException e) {
            System.out.println("Failed to load scene");
        }
    }
}

