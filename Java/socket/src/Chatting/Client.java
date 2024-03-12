package Chatting;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        DataInputStream in = null;
        BufferedReader in2 = null;
        DataOutputStream out = null;

        try {
            InetAddress ia = null;
//            ia = InetAddress.getLocalHost();
            socket = new Socket("192.168.100.107", 4444);

            in = new DataInputStream(socket.getInputStream());
            in2 = new BufferedReader(new InputStreamReader(System.in));
            out = new DataOutputStream(socket.getOutputStream());

            System.out.print("닉네임을 입력해 주세요: ");
            String data = in2.readLine();
            out.writeUTF(data);

            // 방 리스트 출력
            String roomList = in.readUTF();
            System.out.println(roomList);

            // 커맨드
            System.out.print("방을 생성하려면 'c'를, 참여하려면 방 번호를 입력하세요: ");
            String choice = in2.readLine();
            out.writeUTF(choice);

            // 커맨드 입력 후 응답
            String response = in.readUTF();
            System.out.println(response);

            Thread th = new Thread(new Send(out));
            th.start();
        } catch (IOException e) {
        }

        try {
            while (true) {
                String str2 = in.readUTF();
                System.out.println(str2);
            }
        } catch (IOException e) {
        }
    }
}
