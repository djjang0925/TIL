package Chatting.Room;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatManager {
    Map<String, ChatRoom> chatRooms;
    Socket socket;
    DataOutputStream out;
    DataInputStream in;

    public ChatManager() {
        chatRooms = new HashMap<>();
    }

    public String getAllRooms() {
        StringBuilder sb = new StringBuilder();
        List<String> rooms = new ArrayList<>(chatRooms.keySet());

        if (!rooms.isEmpty()) {
            for (int i = 1; i < rooms.size() + 1; i++) {
                sb.append(i).append(". ").append(rooms.get(i - 1)).append("\n");
            }
            return sb.toString();
        }

        return "";
    }

    public void commandManager() {
        ChatManager chatManager = new ChatManager();
        try {
            in = new DataInputStream(socket.getInputStream());

            if (in.readUTF().equals("c")) {
                out.writeUTF("방 제목을 입력해 주세요.");
                String roomTitle = in.readUTF();
                chatManager.createRoom(roomTitle);

                String room = chatManager.getAllRooms();
                out.writeUTF(room);
            } else {
                // 인덱스 번호를 통한 방 입장 코드 작성
                return;
            }
        } catch (IOException e) {
        }
    }


    public synchronized ChatRoom createRoom(String roomName) {
        ChatRoom room = new ChatRoom(roomName);
        chatRooms.put(roomName, room);
        return room;
    }

    public ChatRoom getRoom(String roomName) {
        return chatRooms.get(roomName);
    }
}
