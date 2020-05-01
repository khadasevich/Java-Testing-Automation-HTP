package tables;

public class User {

    private int userId;
    private String userLogin;
    private String userPassword;


    public User(int id, String login, String password) {
        setId(id);
        setName(login);
        setDescription(password);
    }

    private void setId(int id) {
        this.userId = id;
    }

    public int getId() {
        return userId;
    }

    private void setName(String name) {
        this.userLogin = name;
    }

    public String getName() {
        return userLogin;
    }

    private void setDescription(String description) {
        this.userPassword = description;
    }

    public String getDescription() {
        return userPassword;
    }

    @Override
    public String toString() {
        return this.userId + " " + this.userLogin + " " + this.userPassword;
    }
}
