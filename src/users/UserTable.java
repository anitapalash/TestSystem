package users;

public class UserTable {
    public Long id;
    public String login;
    public String firstName;
    public String surname;
    public String access;
    public String status;

    public UserTable(String login, String firstName, String surname, String access, String status) {
        this.login = login;
        this.firstName = firstName;
        this.surname = surname;
        this.access = access;
        this.status = status;

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAccess() {
        return access;
    }
    public void setAccess(String access) {
        this.access = access;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
