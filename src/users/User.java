package users;

import libraries.Access;

import java.text.SimpleDateFormat;

public class User {
    private String name;        //имя
    private String login;       //логин
    private String password;    //пароль
    private String surname;     //фамилия
    private SimpleDateFormat dateOfBirth;   //дата рождения
    private String group;       //группа
    private int secretQuestion; //оридинальный номер секретного вопроса в файле
    private String phoneNumber; //номер телефона
    private Access access;      //уровень доступа

    public User() { }
    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.access = Access.USER;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public SimpleDateFormat getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(SimpleDateFormat dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getSecretQuestion() {
        return secretQuestion;
    }

    public void setSecretQuestion(int secretQuestion) {
        this.secretQuestion = secretQuestion;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }
}
