package de.bfw.mygameprojektspecht;

public class MyGameUser {

    private String name;
    private String password;
    private int score;
    private Boolean isLoggedIn;

    public MyGameUser(String name, String password, int score, Boolean isLoggedIn) {
        this.name = name;
        this.password = password;
        this.score = score;
        this.isLoggedIn = isLoggedIn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Boolean getLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
}
