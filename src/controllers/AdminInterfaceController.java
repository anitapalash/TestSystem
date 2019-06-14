package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import services.Main;
import services.StageLoader;
import users.User;

import javafx.scene.input.MouseEvent;
import java.io.IOException;
import javafx.stage.Stage;
import users.User;

import javafx.scene.input.MouseEvent;
import java.sql.SQLException;

public class AdminInterfaceController {
    private ObservableList<User> usersData = FXCollections.observableArrayList();

    @FXML
    private Tab personalInfo;
    @FXML
    private Tab UseralInfo;

    @FXML
    private Button searchUserButton;

    @FXML
    private TextField searchUserField;

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
    private Tab manageUsersTab;

    @FXML
    private Label label;

    @FXML
    private TableView<User> tableUsers;

    @FXML
    private TableColumn<User, Long> idColumn;

    @FXML
    private TableColumn<User, String> loginColumn;

    @FXML
    private TableColumn<User, String> firstNameColumn;

    @FXML
    private TableColumn<User, String> surnameColumn;

    @FXML
    private TableColumn<User, String> accessColumn;

    @FXML
    private TableColumn<User, String> statusColumn;

    @FXML
    private Tab editTestsTab;

    @FXML
    void deleteUser(ActionEvent event) {

    }

    @FXML
    void editUserInfo(ActionEvent event) {
        surnameTextField.setEditable(true);
        firstNameTextField.setEditable(true);
        userNameTextField.setEditable(true);
        groupTextField.setEditable(true);
        genderTextField.setEditable(true);
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
        genderTextField.setEditable(false);
        saveButton.setVisible(false);
    }

    @FXML
    void exit(ActionEvent event) throws IOException {
        Main.currentUser = null;
        exitButton.getScene().getWindow().hide();
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

    @FXML
    private Button manageUserButton;

    @FXML
    void changeUserData(MouseEvent event) {
        try {
            Scene currentScene = manageUserButton.getScene();
            Stage stage = StageLoader.loadScene("ManageUsersView");
            stage.showAndWait();
        } catch (IOException e) {
            System.out.println("Could not load signUp scene");
        }
    }

    @FXML
    void searchForUsers(ActionEvent event) throws SQLException {
        String request = searchUserField.getText();
        usersData.clear();
        usersData.addAll(Main.dbHandler.getUsersByRequest(request));
        idColumn.setCellValueFactory(new PropertyValueFactory<User, Long>("id"));
        loginColumn.setCellValueFactory(new PropertyValueFactory<User, String>("userName"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("firstName"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("lastName"));
        accessColumn.setCellValueFactory(new PropertyValueFactory<User, String>("access"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<User, String>("status"));
        // заполняем таблицу данными
        tableUsers.setItems(usersData);
    }

    @FXML
    void selectUser(MouseEvent event) throws IOException {
        Main.selectedUser = tableUsers.getSelectionModel().getSelectedItem();
        label.setText(Main.selectedUser.getUserName());
    }

    @FXML
    private void initialize() throws SQLException {
        initData();
        //заполнение личного кабинета
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

        // устанавливаем тип и значение которое должно хранится в колонке
        idColumn.setCellValueFactory(new PropertyValueFactory<User, Long>("id"));
        loginColumn.setCellValueFactory(new PropertyValueFactory<User, String>("userName"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("firstName"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("lastName"));
        accessColumn.setCellValueFactory(new PropertyValueFactory<User, String>("access"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<User, String>("status"));
        // заполняем таблицу данными
        tableUsers.setItems(usersData);
    }

    // подготавливаем данные для таблицы
    // вы можете получать их с базы данных
    private void initData() throws SQLException {
        //UserTable user1 = new UserTable("Anton", "trueAnimeshnik", "Sidorov", "USER", "ACTIVE");
        usersData.addAll(Main.dbHandler.getAllUsers());
    }
}


