package Main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;

public class PersonalServer extends Thread {
    // static
    static UserAccountPool accountPool;     // 전체 유저와 현재 접속중인 유저 관리
    static DatagramSocket ds;               // UDP를 위한 소켓
    static List<Room> rooms;                // 생성된 방 관리

    static {
        accountPool = new UserAccountPool();
        rooms = new ArrayList<Room>();
        try {
            ds = new DatagramSocket(4444);
        } catch(IOException e) {
            System.out.println("alarmSocket create failed.." + e.toString());
        }
    }

    static void sendAlarmToAll(String alarm) {
        DatagramPacket dp = new DatagramPacket(alarm.getBytes(), alarm.getBytes().length);

        for(Account a : accountPool.getCurrentUser()) {
            dp.setSocketAddress(a.getSocketAddress());
            try {
                System.out.println("server UDP send");

                ds.send(dp);
            } catch(IOException e) {
                System.out.println("[server-Thread] send alarm failed .." + e.toString());
            }
        }
    }

    static void sendAlarmToUser(SocketAddress sa, String alarm) {
        DatagramPacket dp = new DatagramPacket(alarm.getBytes(), alarm.getBytes().length);
        dp.setSocketAddress(sa);
        try {
            System.out.println("server UDP send");
            ds.send(dp);
        } catch(IOException e) {
            System.out.println("[server-Thread] send alarm failed .." + e.toString());
        }
    }

    static void sendAlarmToUsers(Room r, String alarm) {
        DatagramPacket dp = new DatagramPacket(alarm.getBytes(), alarm.getBytes().length);

        for(Account a : r.getJoiner()) {
            SocketAddress sa = a.getSocketAddress();
            dp.setSocketAddress(sa);
            try {
                System.out.println("server UDP send");
                System.out.println("txt" + alarm);
                ds.send(dp);
            } catch (IOException e) {
                System.out.println("[server-Thread] send alarm failed .." + e.toString());
            }
        }
    }

    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private Account user;

    public PersonalServer(Socket socket) {
        this.socket = socket;
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {}
    }

    @Override
    public void run() {
        String[] command = null;
        while(socket.isConnected()) {
            String received;
            try {
                received = (String)ois.readObject();

                // try문 밖에서 사용해보 되는지 물어보기
                System.out.println("[server] received : " + received);
                command = received.split("#");
                Object resp = null;
                System.out.println(command[0]);
                switch (command[0]) {
                    // 클라 요청에 따른 처리
                }

            } catch (IOException | ClassNotFoundException e) {
                System.out.println("[server] 비정상 종료");
            }
        }
    }

    // TCP를 이용한 클라이언트에게 데이터전송
    private void sendToClient(Object resp) {
        try {
            oos.reset();
            oos.writeObject(resp);
            System.out.println(resp);
        } catch (IOException e) {
            System.out.println("server write fail.." + e.toString());
        }
    }
}
