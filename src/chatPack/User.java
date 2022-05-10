package chatPack;

import java.awt.image.BufferedImage;

// Task for : Mohamed Walid
public class User {
    private final int id;
    private String username, phoneNumber, password, profileDesc = "default";
    private boolean profileVisibility;
    private int currentChatId;
    private String userImageLink;
    private String lastDateOpened,lastTimeOpened;
    public User(int id, String username, String phoneNumber, String password, String profileDesc, boolean profileVisiblilty) {
        this.id = id;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.profileDesc = profileDesc;
        this.profileVisibility = profileVisiblilty;
    }
    public User(int id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;

    }
    public User(int id, String username, String password, String phoneNumber){
        this.id = id;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
    public User(int id, String date, String time, int ff){
        this.id = id;
        this.lastDateOpened = date;
        this.lastTimeOpened = time;
    }
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getProfileDesc() {
        return profileDesc;
    }

    public boolean isProfileVisibility() {
        return profileVisibility;
    }

    public int getCurrentChatId() {
        return currentChatId;
    }

    public String getUserImageLink() {
        return userImageLink;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfileDesc(String profileDesc) {
        this.profileDesc = profileDesc;
    }

    public void setProfileVisibility(boolean profileVisibility) {
        this.profileVisibility = profileVisibility;
    }

    public void setCurrentChatId(int currentChatId) {
        this.currentChatId = currentChatId;
    }

    public void setUserImageLink(String userImageLink) {
        this.userImageLink = userImageLink;
    }
}
