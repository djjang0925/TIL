package Main.server;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;

public class Room implements Serializable {
    private String title;
    private String pass;
    private List<Account> joiner;

    public Room(Account owner, String title, String pass) {
        joiner = new Vector<>();
        joiner.add(owner);
        this.title = title;
        this.pass = pass;
    }

    public Room(Account owner, String title) {
        this(owner, title, "");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public List<Account> getJoiner() {
        return joiner;
    }

    public void setJoiner(List<Account> joiner) {
        this.joiner = joiner;
    }
}
