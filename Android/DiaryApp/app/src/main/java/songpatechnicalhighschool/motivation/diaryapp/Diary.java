package songpatechnicalhighschool.motivation.diaryapp;

public class Diary {

    String title;
    String content;
    String date;

    public Diary(String title, String cotent, String date) {
        this.title = title;
        this.content = cotent;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
