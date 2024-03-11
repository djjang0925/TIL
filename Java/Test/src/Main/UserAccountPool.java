package Main;

import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UserAccountPool {
    private Map<String, Account> accountMap;
    private Set<Account> currentUser;
    private File address;

    public UserAccountPool() {
        currentUser = new HashSet<>();
    }

    public Map<String, Account> getAccountMap() {
        return accountMap;
    }

    public void setAccountMap(Map<String, Account> accountMap) {
        this.accountMap = accountMap;
    }

    public Set<Account> getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Set<Account> currentUser) {
        this.currentUser = currentUser;
    }

    public File getAddress() {
        return address;
    }

    public void setAddress(File address) {
        this.address = address;
    }
}
