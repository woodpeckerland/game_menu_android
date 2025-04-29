package de.bfw.mygameprojektspecht;

import java.io.Serializable;

public class MyGameUser implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String password;
    private int level;
    private int score;
    private Boolean isRegistered;

    public MyGameUser(String name, String password, int level, int score, Boolean isRegistered) {
        this.name = name;
        this.password = password;
        this.level = level;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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
