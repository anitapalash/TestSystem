package controllers;

public class TestController {
    //класс, который проводит тестирование
    private String currentTest;     //сюда записывать название текстового документа

    public TestController(String currentTest) {
        this.currentTest = currentTest;
    }

    //метод проведения теста
    //...

    public String getCurrentTest() {
        return currentTest;
    }

    public void setCurrentTest(String currentTest) {
        this.currentTest = currentTest;
    }
}
