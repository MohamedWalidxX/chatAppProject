package chatPack;

import java.time.*;

//Task for : Mohamed yehia
public class Story {
    private final int storyUploaderId;
    private String storyText;
    private final LocalTime storyUploadedTime;
    private final LocalDate storyUploadedDate;

    public Story(int storyUploaderId, String storyText, LocalTime storyUploadedTime, LocalDate storyUploadedDate) {
        this.storyUploaderId = storyUploaderId;
        this.storyText = storyText;
        this.storyUploadedTime = storyUploadedTime;
        this.storyUploadedDate = storyUploadedDate;
    }


    public int getStoryUploaderId() {
        return storyUploaderId;
    }

    public String getStoryText() {
        return storyText;
    }

    public LocalTime getStoryUploadedTime() {
        return storyUploadedTime;
    }

    public void setStoryText(String storyText) {
        this.storyText = storyText;
    }

    public LocalDate getStoryUploadedDate() {
        return storyUploadedDate;
    }


}
