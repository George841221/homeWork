package model;

public class Users {

    private int userId;
    private String userName;
    private Gender gender;
    private int age;
    private String regData;
    private String userEmail;
    private String userPassword;

    public Users(int userId, String userName, Gender gender, int age, String regData, String userEmail, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.gender = gender;
        this.age = age;
        this.regData = regData;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }
}
