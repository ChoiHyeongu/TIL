package songpatechnicalhighschool.motivation.openweatherservice;

public class Weather {

    String text;
    String temperature;

    public Weather() {
    }

    public Weather(String text, String temperature) {
        this.text = text;
        this.temperature = temperature;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
