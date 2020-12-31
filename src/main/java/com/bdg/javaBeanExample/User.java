package javaBeanExample;

public class User {
    private int password;
    private String name;

    public User(int password, String name) {
        this.password = password;
        this.name = name;
    }

    public User(){
        System.out.println("You must input name and password for log in");
    }


    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
