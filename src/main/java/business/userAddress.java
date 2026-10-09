package business;

import java.util.List;

public interface userAddress {

    void addAddress(bAddress address);
    List<bAddress> getAddress(int userId);


}
