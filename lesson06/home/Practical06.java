package Lavel2.lesson06.home;

import com.google.gson.Gson;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Practical06 {
    public static void main(String[] args) {
        Map<String, String> conditionValue = new HashMap<String, String>();
        fillConditionValue(conditionValue);
        Map<String, String> wind_dirValue = new HashMap<String, String>();
        fillWind_dirValue(wind_dirValue);
        Map<String, String> timesOfDayValue = new HashMap<String, String>();
        fillTimesOfDay(timesOfDayValue);
        System.out.println(parsingYaWeather(connectYa(), conditionValue, wind_dirValue, timesOfDayValue));
    }

    public static String parsingYaWeather(String jsonResponse, Map conditionValue, Map wind_dirValue, Map timesOfDayValue) {
        String getForecast = "";
        String[] timesOfDayArray = {"night", "morning", "day", "evening"};
        Integer iNumber;
        //System.out.println(jsonResponse);
        Gson g = new Gson();
        Forecasts fore = g.fromJson(jsonResponse, Forecasts.class);
        //MyForecast myForecast = fore.getForecasts()[1];
        for (MyForecast myForecast : fore.getForecasts()) {
            iNumber = 0;
            getForecast += "Прогноз погоды в городе Санкт-Петербург на: ";
            getForecast += parseDate(myForecast.getDate()) + "\n";
            getForecast += "Время восхода солнца: " + myForecast.getSunrise() + "\n";
            getForecast += "Время захода солнца: " + myForecast.getSunset() + "\n";
            HashMap<String, Parts> result = myForecast.getParts();
            Set<Map.Entry<String, Parts>> set;
            set = result.entrySet();

            //не совсем элигантное решение, но не смог достать значения в нужном мне порядке, придумал такой способ
            do {
                for (Map.Entry<String, Parts> pair : set) {
                    if (pair.getKey().equals(timesOfDayArray[iNumber])) {
                        Parts parts = pair.getValue();
                        getForecast += "Погода " + timesOfDayValue.get(timesOfDayArray[iNumber]) + ":\nТемпература: " + parts.getTemp_min() + " - " + parts.getTemp_max() + "\u00b0С\n";
                        getForecast += "Ощущается как: " + parts.getFeels_like() + "\u00b0С\n";
                        getForecast += conditionValue.get(parts.getCondition()) + "\n";
                        getForecast += "Ветер: " + wind_dirValue.get(parts.getWind_dir()) + ", " + parts.getWind_speed() + " м/с \n";
                        getForecast += "Атмосферное давление: " + parts.getPressure_mm() + " мм рт. ст. \n";
                        getForecast += "Влажность воздуха: " + parts.getHumidity() + " %\n";
                        getForecast += "________________________\n";
                        break;
                    }
                }
                iNumber++;
           } while (iNumber < 4);
        }
        return getForecast;
    }

    public static String connectYa() {
        String jsonResponse = null;
        OkHttpClient client = new OkHttpClient();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("api.weather.yandex.ru")
                .addPathSegment("v2")
                .addPathSegment("forecast")
                .addQueryParameter("lat", "59.89444")
                .addQueryParameter("lon", "30.26417")
                .addQueryParameter("lang", "ru_RU")
                .addQueryParameter("limit", "5")
                .addQueryParameter("hours", "false")
                .addQueryParameter("extra", "false")
                .build();

        //System.out.println(url.toString());
        Request requestHttp = new Request.Builder()
                .addHeader("X-Yandex-API-Key", "03e820fc-c461-4436-9794-300f59eda67e")
                .addHeader("Host", "")
                .addHeader("accept", "application/json")
                .url(url)
                .build();

        try {
            jsonResponse = client.newCall(requestHttp).execute().body().string();
        } catch (IOException e) {
            System.err.println("Ошибка получения json от Yandex, " + e.getStackTrace());
        }
        return jsonResponse;
    }

    public static void fillConditionValue(Map conditionValue){
        conditionValue.put("clear", "ясно");
        conditionValue.put("partly-cloudy", "малооблачно");
        conditionValue.put("cloudy", "облачно с прояснениями");
        conditionValue.put("overcast", "пасмурно");
        conditionValue.put("partly-cloudy-and-light-rain", "малооблачно, небольшой дождь");
        conditionValue.put("partly-cloudy-and-rain", "малооблачно, дождь");
        conditionValue.put("light-rain", "малооблачно, дождь");
        conditionValue.put("rain", "дождь");
        conditionValue.put("overcast-and-rain", "значительная облачность, сильный дождь");
        conditionValue.put("overcast-thunderstorms-with-rain", "сильный дождь с грозой");
        conditionValue.put("cloudy-and-light-rain", "облачно, небольшой дождь");
        conditionValue.put("overcast-and-light-rain", "значительная облачность, небольшой дождь");
        conditionValue.put("cloudy-and-rain", "облачно, дождь");
        conditionValue.put("overcast-and-wet-snow", "дождь со снегом");
        conditionValue.put("partly-cloudy-and-light-snow", "небольшой снег");
        conditionValue.put("partly-cloudy-and-snow", "малооблачно, снег");
        conditionValue.put("overcast-and-snow", "ясно");
        conditionValue.put("cloudy-and-light-snow", "снегопад");
        conditionValue.put("overcast-and-light-snow", "значительная облачность, небольшой снег");
        conditionValue.put("cloudy-and-snow", "облачно, снег");
    }

    public static void fillWind_dirValue(Map fillWind_dirValue){
        fillWind_dirValue.put("nw", "северо-западный");
        fillWind_dirValue.put("n", "северный");
        fillWind_dirValue.put("ne", "северо-восточный");
        fillWind_dirValue.put("e", "восточный");
        fillWind_dirValue.put("se", "юго-восточный");
        fillWind_dirValue.put("s", "южный");
        fillWind_dirValue.put("sw", "юго-западный");
        fillWind_dirValue.put("w", "западный");
        fillWind_dirValue.put("с", "штиль");
    }

    public static void fillTimesOfDay(Map fillTimeOfDay){
        fillTimeOfDay.put("night", "ночью");
        fillTimeOfDay.put("morning", "утром");
        fillTimeOfDay.put("day", "днём");
        fillTimeOfDay.put("evening", "вечером");

    }

    public static String parseDate(Date date) {
        String dt = new SimpleDateFormat("dd.MM.yyyy").format(date);
        return dt;
    }

}

