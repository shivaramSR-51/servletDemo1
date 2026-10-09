package data;


import java.util.List;

public interface userDAO {

    void saveUser(dUser duser);
    dlUser validateUser(dlUser dluser);
    void addUserAddress(dAddress address);
    void addPhno(dPhno dphno);
    List<dAddress> getAddresses(int userId);
    List<dPhno> getPhno(int userId);
}
