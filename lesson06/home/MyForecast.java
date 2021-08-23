package Lavel2.lesson06.home;

import java.util.Date;
import java.util.HashMap;

public class MyForecast {
    private HashMap<String, Parts> parts;
    private Date date; //прогноз на дату
    private String sunrise; //время восхода солнца
    private String sunset; //время захода солнца

    public HashMap<String, Parts> getParts() {
        return parts;
    }

    public void setParts(HashMap<String, Parts> parts) {
        this.parts = parts;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }
}


