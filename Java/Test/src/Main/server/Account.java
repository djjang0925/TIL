package Main.server;

import java.io.Serializable;
import java.net.SocketAddress;

public class Account implements Serializable {
    private String nick;
    private String pass;
    private String name;
    private int joinRoomIndex;
    private SocketAddress socketAddress;

    public Account(String nick, String pass, String name) {
        this.nick = nick;
        this.pass = pass;
        this.name = name;
        joinRoomIndex = -1;
        this.socketAddress = null;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJoinRoomIndex() {
        return joinRoomIndex;
    }

    public void setJoinRoomIndex(int joinRoomIndex) {
        this.joinRoomIndex = joinRoomIndex;
    }

    public SocketAddress getSocketAddress() {
        return socketAddress;
    }

    public void setSocketAddress(SocketAddress socketAddress) {
        this.socketAddress = socketAddress;
    }
}
