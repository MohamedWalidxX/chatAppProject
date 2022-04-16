package chatPack;
// Task for:  Mohamed Walid
public class Message {
private final int id, senderId, chatId;
private final String messageText;
private String date, time;
private boolean seenStatus;

    public Message(int id, int senderId, int chatId, String messageText, String date, String time, boolean seenStatus) {
        this.id = id;
        this.senderId = senderId;
        this.chatId = chatId;
        this.messageText = messageText;
        this.date = date;
        this.time = time;
        this.seenStatus = seenStatus;
    }

    public int getId() {
        return id;
    }

    public int getSenderId() {
        return senderId;
    }

    public int getChatId() {
        return chatId;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public boolean isSeenStatus() {
        return seenStatus;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSeenStatus(boolean seenStatus) {
        this.seenStatus = seenStatus;
    }
}
