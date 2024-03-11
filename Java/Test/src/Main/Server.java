package Main;

import java.io.IOException;
import java.net.*;
import java.util.*;

public class Server {
    ServerSocket ss = null;

    Vector<CCUser> allUser;
    Vector<CCUser> waitUser;
    Vector<Room> room;

    public static void main(String[] args) {
        Server server = new Server();

        server.allUser = new Vector<>();
        server.waitUser = new Vector<>();
        server.room = new Vector<>();

        try {
            server.ss = new ServerSocket(4444);
            System.out.println("[Server] Ready");

            while(true) {
                Socket socket = server.ss.accept();
                CCUser c = new CCUser(socket, server);

                c.start();
            }
        } catch (SocketException e) {
            System.out.println("[Server] socket error" + e.toString());
        } catch (IOException e) {
            System.out.println("[Server] input output error" + e.toString());
        }
    }
}
