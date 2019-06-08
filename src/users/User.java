package users;

import libraries.Access;
import services.Main;

public class User {
    private Long id;
    private String firstName;        //имя
    private String userName;       //логин
    private String password;    //пароль
    private String lastName;     //фамилия
    private String group;       //группа
    private Access access;      //уровень доступа
    private String gender;      //пол
    private boolean passedGL;
    private boolean passedOP;
    private boolean passedDN;
    private boolean passedN;
    private boolean passedAT;
    private boolean passedGen;


    public User() { this.access = Access.USER;
        passedAT = false; passedDN = false; passedGen = false;
        passedGL = false; passedN = false; passedOP = false;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.access = Access.USER;
        passedAT = false; passedDN = false; passedGen = false;
        passedGL = false; passedN = false; passedOP = false;
    }

    public User(String firstName, String userName, String password, String lastName, String group, String gender) {
        this.firstName = firstName;
        this.userName = userName;
        this.password = password;
        this.lastName = lastName;
        this.group = group;
        this.gender = gender;
        this.access = Access.USER;
        passedAT = false; passedDN = false; passedGen = false;
        passedGL = false; passedN = false; passedOP = false;
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
        Main.dbHandler.updateUser(this);
    }

    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
        Main.dbHandler.updateUser(this);
    }

    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
        Main.dbHandler.updateUser(this);
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
        Main.dbHandler.updateUser(this);
    }

    public String getGroup() {
        return group;
    }
    public void setGroup(String group) {
        this.group = group;
        Main.dbHandler.updateUser(this);
    }

    public Access getAccess() {
        return access;
    }
    public void setAccess(Access access) {
        this.access = access;
        Main.dbHandler.updateUser(this);
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
        Main.dbHandler.updateUser(this);
    }

    public boolean isPassedGL() {
        return passedGL;
    }
    public void setPassedGL(boolean passedGL) {
        this.passedGL = passedGL;
        Main.dbHandler.updateUser(this);
    }

    public boolean isPassedOP() {
        return passedOP;
    }
    public void setPassedOP(boolean passedOP) {
        this.passedOP = passedOP;
        Main.dbHandler.updateUser(this);
    }

    public boolean isPassedDN() {
        return passedDN;
    }
    public void setPassedDN(boolean passedDN) {
        this.passedDN = passedDN;
        Main.dbHandler.updateUser(this);
    }

    public boolean isPassedN() {
        return passedN;
    }
    public void setPassedN(boolean passedN) {
        this.passedN = passedN;
        Main.dbHandler.updateUser(this);
    }

    public boolean isPassedAT() {
        return passedAT;
    }
    public void setPassedAT(boolean passedAT) {
        this.passedAT = passedAT;
        Main.dbHandler.updateUser(this);
    }

    public boolean isPassedGen() {
        return passedGen;
    }
    public void setPassedGen(boolean passedGen) {
        this.passedGen = passedGen;
        Main.dbHandler.updateUser(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (!userName.equals(user.userName)) return false;
        if (!password.equals(user.password)) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (group != null ? !group.equals(user.group) : user.group != null) return false;
        if (access != user.access) return false;
        return gender != null ? gender.equals(user.gender) : user.gender == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + userName.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (access != null ? access.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", group='" + group + '\'' +
                ", access=" + access +
                ", gender='" + gender + '\'' +
                '}';
    }
}
