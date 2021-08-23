package Lavel2.lesson06.home;

public class Parts {
    private Integer temp_min;  //минимальная температура
    private Integer temp_max;  //максимальная температура
    private Integer feels_like;  //ощущаемая температура
    private String condition;  //погодное описание (ясно, дождь и т.д.) массив значений
    private float wind_speed;  //скорость вестра в м/с
    private String wind_dir; //направление ветра (массив значений)
    private Integer pressure_mm;  //атмосферное давление
    private Integer humidity; //влажность воздуха

    public Integer getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(Integer temp_min) {
        this.temp_min = temp_min;
    }

    public Integer getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(Integer temp_max) {
        this.temp_max = temp_max;
    }

    public Integer getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(Integer feels_like) {
        this.feels_like = feels_like;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public float getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(float wind_speed) {
        this.wind_speed = wind_speed;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public Integer getPressure_mm() {
        return pressure_mm;
    }

    public void setPressure_mm(Integer pressure_mm) {
        this.pressure_mm = pressure_mm;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }
}
