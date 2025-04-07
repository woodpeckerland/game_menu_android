package de.bfw.mygameprojektspecht;

public class MyGameUser {

    private String name;
    private String password;
    private int score;
    private Boolean isRegistered;

    public MyGameUser(String name, String password, int score, Boolean isRegistered) {
        this.name = name;
        this.password = password;
        this.score = score;
        this.isRegistered = isRegistered;
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

    public Boolean getRegistered() {
        return isRegistered;
    }

    public void setRegistered(Boolean registered) {
        isRegistered = registered;
    }
}
