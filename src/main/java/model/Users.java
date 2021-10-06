package model;

import java.sql.Timestamp;

public class Users {

    private int userId;
    private String userName;
    private final Gender gender;
    private Status status;
    private int age;
    private final Timestamp REG_DATE;
    private String userEmail;
    private String userPassword;

    public Users(int userId, String userName, Gender gender, Status status, int age,
                 Timestamp REG_DATE, String userEmail, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.gender = gender;
        this.status = status;
        this.age = age;
        this.REG_DATE = REG_DATE;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        }

        @Override
        public String toString() {
            return userId +
                    ", " + userName +
                    ", " + gender +
                    ", " + status +
                    ", " + age +
                    ", " + REG_DATE +
                    ", " + userEmail +
                    ", " + userPassword;
    }
}
