package chatPack;
//Task for : Mohamed yehia
public class Story {
    private  String storyText;
    private String  time;
    public Story(String text,String date,String time)
    {
        this.storyText=text;
        this.time=time;
    }
    public void setStoryText(String text) {
        this.storyText=text;
    }
    public void SetTime(String time) {
        this.time=time;
    }
    public String getStoryText()
    {
        return storyText;
    }
    public String getTime()
    {
        return time;
    }

}
