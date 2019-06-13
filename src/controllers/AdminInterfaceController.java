package controllers;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.Main;
import services.StageLoader;
import users.User;
import users.UserTable;

import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

import static services.Main.selectedUser;

public class AdminInterfaceController  {
    private ObservableList<User> usersData = FXCollections.observableArrayList();
 //   private ObservableList<UserTable> usersTableData = FXCollections.observableArrayList();

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

    }

    @FXML
    void exit(ActionEvent event) {

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
@FXML
private Button manageUserButton;
    @FXML
    void  changeUserData(MouseEvent event)
    {
        try {
            Scene currentScene = manageUserButton.getScene();
            Stage stage = StageLoader.loadScene("ManageUsersView");
            stage.showAndWait();
         //   Scene currentScene = manageUserButton.getScene();
           // Stage stage = StageLoader.loadScene("view/ManageUsersView");

        } catch (IOException e) {
            System.out.println("Could not load signUp scene");
        }
    }


    @FXML
    void searchForUsers(ActionEvent event) {

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
void selectUser(MouseEvent event)
{

    selectedUser = tableUsers.getSelectionModel().getSelectedItem();

    label.setText(selectedUser.getUserName());

}
    @FXML
    private void initialize() throws SQLException {
        initData();

        // устанавливаем тип и значение которое должно хранится в колонке
        idColumn.setCellValueFactory(new PropertyValueFactory<User, Long>("id"));
        loginColumn.setCellValueFactory(new PropertyValueFactory<User, String>("userName"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("firstName"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("lastName"));
        accessColumn.setCellValueFactory(new PropertyValueFactory<User, String>("access"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<User, String>("status"));
        // заполняем таблицу данными
        tableUsers.setItems(usersData);

     //   tableUsers.setItems(usersTableData);
    }

    // подготавливаем данные для таблицы
    // вы можете получать их с базы данных
    private void initData() throws SQLException {
      //UserTable user1 = new UserTable("Anton", "trueAnimeshnik", "Sidorov", "USER", "ACTIVE");
       usersData.addAll(Main.dbHandler.getAllUsers());

   //     System.out.println(user1.getlogin());
   //     System.out.println(usersTableData.isEmpty());



    }




}


