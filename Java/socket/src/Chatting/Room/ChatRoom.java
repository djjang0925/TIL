package Chatting.Room;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ChatRoom {
    String roomName;
    Map<String, Socket> clients;

    public ChatRoom(String roomName) {
        this.roomName = roomName;
        this.clients = new HashMap<>();
    }

    public synchronized void addClient(String name, Socket socket) {
        clients.put(name, socket);
    }

    public synchronized void removeClient(String name) {
        clients.remove(name);
    }

    // 메시지 전송 로직 추가
}
