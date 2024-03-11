package Main;

import java.net.Socket;
import java.util.Vector;

public class CCUser extends Thread{
    Server server;
    Socket socket;

    Vector<CCUser> allUser;
    Vector<CCUser> waitUser;
    Vector<Room> room;

    CCUser(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;

        allUser = server.allUser;
        waitUser = server.waitUser;
        room = server.room;
    }
}
