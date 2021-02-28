package pt.uab.sm.model;

import java.util.ArrayList;
import java.util.List;

public class User {


    private String username;
    private String password;
    private String genre;
    private int age;
    private List<Book> favorites;


    public User(String username, String password, String genre, int age, List<Book> favorites) {
        this.username = username;
        this.password = password;
        this.genre = genre;
        this.age = age;
        this.favorites = favorites;
    }

    public User(String username, String password, String genre, int age) {
        this.username = username;
        this.password = password;
        this.genre = genre;
        this.age = age;
        this.favorites = new ArrayList<>();
    }

    public void setGenre(String genre) { this.genre = genre; }

    public void setAge(int age) { this.age = age; }

    public String getGenre() { return genre; }

    public int getAge() { return age; }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Book> getFavorites() {
        return favorites;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFavorites(List<Book> favorites) {
        this.favorites = favorites;
    }


}