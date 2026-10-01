package presentation;

public class phUser {

    private int userId;
    private String phnoCode;
    private String phno;

    public int getUserId(){
        return userId;
    }
    public void setUserId(int userId){
        this.userId = userId;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getPhnoCode() {
        return phnoCode;
    }
    public void setPhnoCode(String phnoCode){
        this.phnoCode = phnoCode;
    }
}
