package business;

public class blUser {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private int userId;


    public String getEmail() {
        return email;

    }

    public void setEmail(String email) {
        this.email = email;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName =  firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getUserId(){
        return userId;
    }
    public void setUserId(int userId){
        this.userId = userId;
    }

}
