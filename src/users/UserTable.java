package users;

public class UserTable {
    public Long id;
    public String login;
    public String firstName;
    public String surname;
    public String access;
    public String status;
    public String passedTests;

    public UserTable(String login, String firstName, String surname, String access, String status, String passedTests) {
        this.login = login;
        this.firstName = firstName;
        this.surname = surname;
        this.access = access;
        this.status = status;
        this.passedTests = passedTests;

    }

    public Long getUserId() {
        return id;
    }

    public String getlogin() {
        return login;
    }

    public String firstName() {
        return firstName;
    }

    public String getsurname() {
        return surname;
    }

    public String getaccess() {
        return access;
    }

    public String getstatus() {
        return status;
    }

    public Long setUserId(Long id) {
        return this.id = id;
    }

    public String setlogin(String login) {
        return this.login = login;
    }

    public String firstName(String firstName) {
        return this.firstName = firstName;
    }

    public String setsurname(String surname) {
        return this.surname = surname;
    }

    public String setaccess(String access) {
        return this.access = access;
    }

    public String setstatus(String status) {
        return this.status = status;
    }

    public String setPassedTests(String passedTests) {
        return this.passedTests = passedTests;
    }
}
