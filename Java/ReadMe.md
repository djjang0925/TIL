# Java 공부 내역

## 1. [Socket](./socket/)
  - 소켓통신, 멀티스레드를 이용하여 구현한 간단한 채팅 코드
  - [Server](#server), [Client](#client), [Receiver](#receiver), [User](#user), [Send](#send)

### Server
- client들이 메세지를 주고받을 수 있는 공간

### Client
- 최초 접속시 닉네임을 입력 한 뒤 server와 socket을 통해 연결되는 순간 User의 권한을 얻고 채팅에 참가 가능

### Receiver
- Server에서 Client와 소켓을 통해 통신이 연결되면 Receiver 클래스에서 User를 등록해주고 메세지를 주고 받을 수 있도록 기초를 마련

### User
- Client에게 User권한을 부여하는 클래스

### Send
- client에서 입력하는 닉네임, 메세지 등을 서버에 전달하는 역할