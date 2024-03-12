package Chatting;

import Chatting.Room.ChatManager;

import java.io.DataOutputStream;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        Socket socket = null;
        User user = new User();
        ServerSocket serverSocket = null;
        ChatManager chatManager = new ChatManager();

        int count = 0; // 쓰레드 할당을 위한 정수
        Thread thread[] = new Thread[10]; // 10개까지 쓰레드 할당 => 채팅방에 10명 접속 가능

        try {
            serverSocket = new ServerSocket(4444);

            while (true) {
                socket = serverSocket.accept();

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // 닉네임 입력
                thread[count] = new Thread(new Receiver(user, socket));

                // 채팅방 목록
                String rooms = chatManager.getAllRooms();
                out.writeUTF(rooms);

                // 커맨트
                chatManager.commandManager();
//                String command = in.readUTF();
//
//                if (command.equals("c")) {
//                    out.writeUTF("방 제목을 입력해 주세요.");
//                    String roomTitle = in.readUTF();
//                    chatManager.createRoom(roomTitle);
//
//                    String room = chatManager.getAllRooms();
//                    out.writeUTF(room);
//                } else {
//                    return;
//                }

                thread[count].start();
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
