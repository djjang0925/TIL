package Chatting;

import java.net.*;

public class Server {
    public static void main(String[] args) {
        Socket socket = null;
        User user = new User();
        ServerSocket serverSocket = null;

        int count = 0; // 쓰레드 할당을 위한 정수
        Thread thread[] = new Thread[10]; // 10개까지 쓰레드 할당 => 채팅방에 10명 접속 가능

        try {
            serverSocket = new ServerSocket(4444);

            while (true) {
                socket = serverSocket.accept();
                thread[count] = new Thread(new Receiver(user, socket));
                thread[count].start();
                count++;
            }
        } catch (Exception e) {
        }
    }
}
