package pt.uab.sm.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String username;
    private String password;
    private String genre;
    private int age;
    private List<Book> favorites;
    private List<Book> purchasing;
    private List<Integer> friends;


    public User(int id, String username, String password, String genre, int age, List<Book> favorites, List<Book> purchasing, List<Integer> friends) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.genre = genre;
        this.age = age;
        this.favorites = favorites;
        this.purchasing = purchasing;
        this.friends = friends;
    }

    public User(int id, String username, String password, String genre, int age, List<Book> favorites, List<Integer> friends) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.genre = genre;
        this.age = age;
        this.favorites = favorites;
        this.purchasing = new ArrayList<>();
        this.friends = friends;
    }

    public User(int id, String username, String password, String genre, int age, List<Integer> friends) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.genre = genre;
        this.age = age;
        this.favorites = new ArrayList<>();
        this.purchasing = new ArrayList<>();
        this.friends = friends;
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

    public void setPurchasing(List<Book> purchasing) { this.purchasing = purchasing; }

    public List<Book> getPurchasing() { return purchasing; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public List<Integer> getFriends() { return friends; }

    public void setFriends(List<Integer> friends) { this.friends = friends; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", genre='" + genre + '\'' +
                ", age=" + age +
                ", favorites=" + favorites +
                ", purchasing=" + purchasing +
                ", friends=" + friends +
                '}';
    }
}
