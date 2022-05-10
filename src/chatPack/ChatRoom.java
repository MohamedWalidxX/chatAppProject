package chatPack;

import java.util.ArrayList;

public class ChatRoom {
    private final int id;
    private String name;
    private ArrayList<User> userList;
    private Message lastMessageSent;
    private String chatroomImageLink;
    public boolean flag = false;
    public ChatRoom(int id, String name) {
        this.id = id;
        this.name = name;
        userList = new ArrayList<User>();
    }
    public ChatRoom(int id, String name, String chatroomImageLink){
        this.id = id;
        this.name=  name;
        this.chatroomImageLink = chatroomImageLink;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public Message getLastMessageSent() {
        return lastMessageSent;
    }

    public void setLastMessageSent(Message lastMessageSent) {
        this.lastMessageSent = lastMessageSent;
    }
}
