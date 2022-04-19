package chatPack;

import javax.management.Query;

// Task for Mohamed Yehia
public class DeletedMessage extends Message{
    private String deleteDate;
    private String deleteTime;
    public DeletedMessage(int id, int senderId, int chatId, String messageText, String date, String time, boolean seenStatus,String deleteDate,String deleteTime)
    {
        super(id,senderId,chatId,messageText,date,time,seenStatus);
        this.deleteDate=deleteDate;
        this.deleteTime=deleteTime;
    }
    void setDeleteDate(String Ddate)
    {
        deleteDate=Ddate;
    }
    void setDeleteTime(String Dtime)
    {
        deleteTime=Dtime;
    }
    String getDeleteDate()
    {
        return deleteDate;
    }
    String getDeleteTime()
    {
        return deleteTime;
    }


}