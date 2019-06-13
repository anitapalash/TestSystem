package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import services.Main;

public class GeneralTestController {
    private List<String> lines = getLines("src/libraries/gen.txt");
    private String currentAnime;

    @FXML
    private TextArea discussionArea;

    @FXML
    private TextField answerField;

    @FXML
    private RadioButton var1;

    @FXML
    private RadioButton var2;

    @FXML
    private RadioButton var3;

    @FXML
    private RadioButton var4;

    @FXML
    private Button sendButton;

    @FXML
    private Button returnButton;

    private int currentQuestion;
    private String[] currentQuestionInfo;
    private int falseQuestionCounter;
    private int rightAnswersCount;

    public GeneralTestController() throws IOException {
        currentQuestion = rightAnswersCount = falseQuestionCounter = 0;
        currentAnime = "Гуррен-Лаганн";
    }

    private void loadQuestions() throws IOException, InterruptedException {
        String line = lines.get(currentQuestion);
        currentQuestionInfo = line.split(";");

        answerField.setVisible(true);
        sendButton.setVisible(true);

        discussionArea.setText(currentAnime + "\n" + currentQuestionInfo[2]);
        if (Integer.parseInt(currentQuestionInfo[1]) == 1) {
            var1.setVisible(true);
            var2.setVisible(true);
            var3.setVisible(false);
            var4.setVisible(false);
            var1.setText(currentQuestionInfo[3]);
            var2.setText(currentQuestionInfo[4]);

            answerField.setVisible(false);
            sendButton.setVisible(false);
        }

        if (Integer.parseInt(currentQuestionInfo[1]) == 2) {
            var1.setVisible(true);
            var2.setVisible(true);
            var3.setVisible(true);
            var4.setVisible(true);

            var1.setText(currentQuestionInfo[3]);
            var2.setText(currentQuestionInfo[4]);
            var3.setText(currentQuestionInfo[5]);
            var4.setText(currentQuestionInfo[6]);

            answerField.setVisible(false);
            sendButton.setVisible(false);
        }

        if (rightAnswersCount == 4) {
            currentAnime = "Атака Титанов";
            currentQuestion = 14;
            falseQuestionCounter = 0;
        }

        if (rightAnswersCount == 9) {
            currentAnime = "Наруто";
            currentQuestion = 29;
            falseQuestionCounter = 0;
        }

        if (rightAnswersCount == 14) {
            currentAnime = "Студия Гибли";
            currentQuestion = 44;
            falseQuestionCounter = 0;
        }

        if (rightAnswersCount == 19) {
            currentAnime = "Тетрадь смерти";
            currentQuestion = 59;
            falseQuestionCounter = 0;
        }

        if (rightAnswersCount == 25) {
            discussionArea.setText("Общий тест пройден успешно!");
            Main.currentUser.setPassedGen(true);
            Main.dbHandler.updateUser(Main.currentUser);

            var1.setVisible(false);
            var2.setVisible(false);
            var3.setVisible(false);
            var4.setVisible(false);

            returnButton.setVisible(true);
            answerField.setVisible(false);
            sendButton.setVisible(false);
        }
    }

    private List<String> getLines(String path) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(new File(path).getCanonicalFile()));
        while(true) {
            String line = br.readLine();
            if (line==null) break;
            lines.add(line);
        }
        br.close();
        return lines;
    }

    @FXML
    void sendAnswer (ActionEvent event) throws Exception {
        String answer;
        switch (Integer.parseInt(currentQuestionInfo[1])) {
            case 1:
                if (var1.isSelected()) answer = currentQuestionInfo[3];
                else answer = currentQuestionInfo[4];

                sendAnswer1(answer);
                break;
            case 2:
                if (var1.isSelected()) answer = currentQuestionInfo[3];
                else if (var2.isSelected()) answer = currentQuestionInfo[4];
                else if (var3.isSelected()) answer = currentQuestionInfo[5];
                else  answer = currentQuestionInfo[6];

                sendAnswer2(answer);
                break;
            case 3:
                answer = answerField.getText();
                sendAnswer3(answer);
                break;
        }
        currentQuestion++;

        if (falseQuestionCounter == 11 || (currentQuestion == lines.size() && rightAnswersCount < 25)) {
            discussionArea.setText("Тест не пройден. Стоит пересмотреть некоторые аниме!");
            returnButton.setVisible(true);
            answerField.setVisible(false);
            sendButton.setVisible(false);

            var1.setVisible(false);
            var2.setVisible(false);
            var3.setVisible(false);
            var4.setVisible(false);
        } else if (currentQuestion == lines.size() && rightAnswersCount == 25) {
            discussionArea.setText("Общий тест пройден успешно!");
            returnButton.setVisible(true);
            answerField.setVisible(false);
            sendButton.setVisible(false);

            var1.setVisible(false);
            var2.setVisible(false);
            var3.setVisible(false);
            var4.setVisible(false);

            Main.currentUser.setPassedGen(true);
            Main.dbHandler.updateUser(Main.currentUser);
        } else {
            answerField.setText("");

            var1.setSelected(false);
            var2.setSelected(false);
            var3.setSelected(false);
            var4.setSelected(false);

            var1.setVisible(false);
            var2.setVisible(false);
            var3.setVisible(false);
            var4.setVisible(false);

            loadQuestions();
        }
    }


    void sendAnswer1(String answer) throws Exception {
        String line = currentQuestionInfo[5].toLowerCase();

        if (line.equals(answer.toLowerCase())) {
            rightAnswersCount++;
        } else {
            falseQuestionCounter++;
        }
    }

    void sendAnswer2(String answer) throws Exception {
        String line = currentQuestionInfo[7].toLowerCase();
        if (line.equals(answer.toLowerCase())) {
            rightAnswersCount++;
        } else {
            falseQuestionCounter++;
        }
    }

    void sendAnswer3(String answer) throws Exception {
        String line1 = currentQuestionInfo[2].toLowerCase();
        String line2 = currentQuestionInfo[3].toLowerCase();
        String line3 = currentQuestionInfo[4].toLowerCase();
        answer = answer.toLowerCase();
        if (answer.equals(line1) || answer.equals(line2) || answer.equals(line3)) {
            rightAnswersCount++;
        } else {
            falseQuestionCounter++;
        }
    }

    @FXML
    private Button startButton;

    @FXML
    void startTest(ActionEvent event) throws IOException, InterruptedException {
        startButton.setVisible(false);
        loadQuestions();
    }

    @FXML
    void saveData(ActionEvent event) {
        sendButton.getScene().getWindow().hide();
    }
}