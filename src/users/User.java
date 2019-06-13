package users;

import libraries.Access;
import libraries.Status;

public class User {
    private Long id;
    private String firstName;        //имя
    private String userName;       //логин
    private String password;    //пароль
    private String lastName;     //фамилия
    private String group;       //группа
    private Access access;      //уровень доступа
    private Status status;      //статус
    private String gender;      //пол

    private boolean passedGL;
    private boolean passedGB;
    private boolean passedDN;
    private boolean passedAT;
    private boolean passedN;
    private boolean passedGen;


    public User() {
        this.access = Access.USER; this.status = Status.ACTIVE; passedAT = false; passedDN = false;
        passedGen = false; passedGB = false; passedGL = false; passedN = false;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.access = Access.USER;
        this.status = Status.ACTIVE;
        passedAT = false; passedDN = false; passedGen = false;
        passedGB = false; passedGL = false; passedN = false;
    }

    public User(String firstName, String userName, String password, String lastName, String group, String gender) {
        this.firstName = firstName;
        this.userName = userName;
        this.password = password;
        this.lastName = lastName;
        this.group = group;
        this.gender = gender;
        this.access = Access.USER;
        this.status = Status.ACTIVE;
        passedAT = false; passedDN = false; passedGen = false;
        passedGB = false; passedGL = false; passedN = false;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getGroup() {
        return group;
    }
    public void setGroup(String group) {
        this.group = group;
    }

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    public Access getAccess() {
        return access;
    }
    public void setAccess(Access access) {
        this.access = access;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isPassedGL() {
        return passedGL;
    }
    public void setPassedGL(boolean passedGL) {
        this.passedGL = passedGL;
    }

    public boolean isPassedGB() {
        return passedGB;
    }
    public void setPassedGB(boolean passedGB) {
        this.passedGB = passedGB;
    }

    public boolean isPassedDN() {
        return passedDN;
    }
    public void setPassedDN(boolean passedDN) {
        this.passedDN = passedDN;
    }

    public boolean isPassedAT() {
        return passedAT;
    }
    public void setPassedAT(boolean passedAT) {
        this.passedAT = passedAT;
    }

    public boolean isPassedN() {
        return passedN;
    }
    public void setPassedN(boolean passedN) {
        this.passedN = passedN;
    }

    public boolean isPassedGen() {
        return passedGen;
    }
    public void setPassedGen(boolean passedGen) {
        this.passedGen = passedGen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (passedGL != user.passedGL) return false;
        if (passedGB != user.passedGB) return false;
        if (passedDN != user.passedDN) return false;
        if (passedAT != user.passedAT) return false;
        if (passedN != user.passedN) return false;
        if (passedGen != user.passedGen) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (group != null ? !group.equals(user.group) : user.group != null) return false;
        if (access != user.access) return false;
        if (status != user.status) return false;
        return gender != null ? gender.equals(user.gender) : user.gender == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + access.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (passedGL ? 1 : 0);
        result = 31 * result + (passedGB ? 1 : 0);
        result = 31 * result + (passedDN ? 1 : 0);
        result = 31 * result + (passedAT ? 1 : 0);
        result = 31 * result + (passedN ? 1 : 0);
        result = 31 * result + (passedGen ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", lastName='" + lastName + '\'' +
                ", group='" + group + '\'' +
                ", access=" + access + '\'' +
                ", status=" + status + '\'' +
                ", gender='" + gender + '\'' +
                ", passedGL=" + passedGL +
                ", passedGB=" + passedGB +
                ", passedDN=" + passedDN +
                ", passedAT=" + passedAT +
                ", passedN=" + passedN +
                ", passedGen=" + passedGen +
                '}';
    }
}
