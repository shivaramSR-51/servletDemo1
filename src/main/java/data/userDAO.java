package data;


public interface userDAO {

    void saveUser(dUser duser);
    dlUser validateUser(dlUser dluser);
    void addUserAddress(dAddress address);
    void addPhno(dPhno dphno);
}
