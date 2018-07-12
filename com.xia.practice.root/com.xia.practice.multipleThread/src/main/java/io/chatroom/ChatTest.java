package io.chatroom;

/**
 * Created by Lee on 2018/7/11.
 */
public class ChatTest {

    public static void main(String[] args) {
        ChatClient chatClient = ChatClient.getIntance();

        chatClient.sendMsg("hello Ahello Ahello Ahello Ahello A");
        System.out.println(chatClient.receiveMsg());
    }
}
