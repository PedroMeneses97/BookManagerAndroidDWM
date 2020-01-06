package pt.ipca.androidbookdwm;

public class User {
    //Variaveis
    private String name,email,username,password;
    private Address add1;

    //Construtor
    public User(String name, String email, String username, String password, Address add1) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.add1 = add1;
    }


    //Metodos
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getStreetName() {
        return add1.getStreetName();

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}