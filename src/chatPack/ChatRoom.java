package chatPack;

import java.util.ArrayList;

// Task for ; Mohamed Mamdouh
public class ChatRoom {
    private final int id;
    private String name;
    private ArrayList<User> userList;

    public ChatRoom(int id, String name) {
        this.id = id;
        this.name = name;
        userList = new ArrayList<User>();
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
}
