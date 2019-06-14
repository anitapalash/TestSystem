package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static services.Main.selectedTest;

public class EditTestController {

    @FXML
    private TextField testNameField;

    @FXML
    private TextField testFileNameField;

    @FXML
    private Button importButton;

    @FXML
    private Button exportButton;
    @FXML
    private Label label;

    @FXML
    void importTest(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        Stage stage;
        stage = (Stage) label.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);
        File selectedTestfile = new File("src/libraries/" + selectedTest.getTestFileName());

        String absolutePath = selectedTestfile.getAbsolutePath();
        try {
            Files.copy(selectedFile.toPath(), Paths.get(absolutePath), REPLACE_EXISTING);
            System.out.println("File has been updated");
        } catch (IOException e) {
            System.out.println("Could not update test file");
        }
    }

    @FXML
    void exportTest(MouseEvent event) {
        javax.swing.filechooser.FileSystemView.getFileSystemView().getHomeDirectory();
    }

    public void initialize() {
        testNameField.setText(Main.selectedTest.getTestName());
        testFileNameField.setText(Main.selectedTest.getTestFileName());
        testNameField.setEditable(false);
        testFileNameField.setEditable(false);
    }
}
