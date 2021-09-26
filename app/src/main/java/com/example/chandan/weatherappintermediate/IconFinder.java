package com.example.chandan.weatherappintermediate;

import java.util.Locale;

/**
 * Created by chandan on 25-06-2017.
 */

public class IconFinder {


    public int findIconId(String idFromServer, int id) {
        if (idFromServer.equals("01d") || idFromServer.equals("01dd")) return R.drawable.a01d;
        else if (idFromServer.equals("01n")) return R.drawable.a01n;
        else if (idFromServer.equals("02d")) return R.drawable.a02d;
        else if (idFromServer.equals("02n")) return R.drawable.a02n;
        else if (idFromServer.equals("03d")) return R.drawable.a03d;
        else if (idFromServer.equals("03n")) return R.drawable.a03n;
        else if (idFromServer.equals("04d")) return R.drawable.a04d;
        else if (idFromServer.equals("04n")) return R.drawable.a04n;
        else if (idFromServer.equals("09d") || (id >= 300 && id < 400) && (id >= 520 && id < 531))
            return R
                    .drawable
                    .a09d;
        else if (idFromServer.equals("09n")) return R.drawable.a09n;
        else if (idFromServer.equals("10d") || (id >= 500 && id <= 504)) return R.drawable.a10d;
        else if (idFromServer.equals("10n")) return R.drawable.a10n;
        else if (idFromServer.equals("11d") || (id >= 200 && id < 300)) return R.drawable.a11d;
        else if (idFromServer.equals("11n")) return R.drawable.a11n;
        else if (idFromServer.equals("13d") || id == 511 || (id >= 600 && id < 700))
            return R.drawable.a13d;
        else if (idFromServer.equals("13n")) return R.drawable.a13n;
        else if (idFromServer.equals("50d") || (id >= 700 && id < 800)) return R.drawable.a50d;
        else if (idFromServer.equals("50n")) return R.drawable.a50n;
        else return 0;
    }

    public int findBackgroundIconId(String idFromServer, int id) {
        if (idFromServer.equals("01d") || idFromServer.equals("01dd")) return R.drawable.clearskyd;
        else if (idFromServer.equals("01n")) return R.drawable.nightclearsky;
        else if (idFromServer.equals("02d")) return R.drawable.fewclouddd;
        else if (idFromServer.equals("02n")) return R.drawable.fewnightclouds;
        else if (idFromServer.equals("03d")) return R.drawable.scatdayclouds;
        else if (idFromServer.equals("03n")) return R.drawable.scatnightcloud;
        else if (idFromServer.equals("04d")) return R.drawable.brokencloudsday;
        else if (idFromServer.equals("04n")) return R.drawable.brokencloudsnight;
        else if (idFromServer.equals("09d") || (id >= 300 && id < 400) || (id >= 520 && id < 531))
            return R
                    .drawable.raiinday;
        else if (idFromServer.equals("09n")) return R.drawable.rainnighttshower;
        else if (idFromServer.equals("10d") || (id >= 500 && id <= 504))
            return R.drawable.raaindshower;
        else if (idFromServer.equals("10n")) return R.drawable.raindd;
        else if (idFromServer.equals("11d") || (id >= 200 && id < 300)) return R.drawable.daythuder;
        else if (idFromServer.equals("11n")) return R.drawable.thunderstormnight;
        else if (idFromServer.equals("13d") || id == 511 || (id >= 600 && id < 700))
            return R.drawable.snowni;
        else if (idFromServer.equals("13n")) return R.drawable.snowd;
        else if (idFromServer.equals("50d") || (id >= 700 && id < 800)) return R.drawable.mistday;
        else if (idFromServer.equals("50n")) return R.drawable.misttnight;
        else return 0;
    }

    public int findBackgroundSwipeIconId(String idFromServer, int id) {
        if (idFromServer.equals("01d") || idFromServer.equals("01dd"))
            return R.drawable.clearskydayf;
        else if (idFromServer.equals("01n")) return R.drawable.clearnightskyswipe;
        else if (idFromServer.equals("02d")) return R.drawable.fewcloudsdayswip;
        else if (idFromServer.equals("02n")) return R.drawable.fewcloudsnightswipe;
        else if (idFromServer.equals("03d")) return R.drawable.swipescatteredcloudsday;
        else if (idFromServer.equals("03n")) return R.drawable.scatteredcloudsnigghtswipe;
        else if (idFromServer.equals("04d")) return R.drawable
                .brokencloudsdayswipe;
        else if (idFromServer.equals("04n")) return R.drawable.brokencloudsnightswipe;
        else if (idFromServer.equals("09d") || (id >= 300 && id < 400) || (id >= 520 && id < 531))
            return R
                    .drawable.rainswipe;
        else if (idFromServer.equals("09n")) return R.drawable.rainnightswipe;
        else if (idFromServer.equals("10d") || (id >= 500 && id <= 504))
            return R.drawable.rainswipe;
        else if (idFromServer.equals("10n")) return R.drawable.rainnightswipe;
        else if (idFromServer.equals("11d") || (id >= 200 && id < 300))
            return R.drawable.thunderdayswipe;
        else if (idFromServer.equals("11n")) return R.drawable.thunderstormnightswipe;
        else if (idFromServer.equals("13d") || id == 511 || (id >= 600 && id < 700))
            return R.drawable.snowdayswipe;
        else if (idFromServer.equals("13n")) return R.drawable.snownightswipe;
        else if (idFromServer.equals("50d") || (id >= 700 && id < 800))
            return R.drawable.mistdayswipe;
        else if (idFromServer.equals("50n")) return R.drawable.mistnightswipe;
        else return 0;
    }


    public String getWeatherMessage(int id) {
        String msg ;
        switch (id) {
            case 200:
                msg = "thunderstorm with light rain";
                break;
            case 201:
                msg = "thunderstorm with rain";
                break;
            case 202:
                msg = "thunderstorm with heavy rain";
                break;
            case 210:
                msg = "light thunderstorm";
                break;
            case 211:
                msg = "thunderstorm";
                break;
            case 212:
                msg = "heavy thunderstorm";
                break;
            case 221:
                msg = "ragged thunderstorm";
                break;
            case 230:
                msg = "thunderstorm with light drizzle";
                break;
            case 231:
                msg = "thunderstorm with drizzle";
                break;
            case 232:
                msg = "thunderstorm with heavy drizzle";
                break;
            case 300:
                msg = "light intensity drizzle";
                break;
            case 301:
                msg = "drizzle";
                break;
            case 302:
                msg = "heavy intensity drizzle";
                break;
            case 310:
                msg = "light intensity drizzle rain";
                break;
            case 311:
                msg = "drizzle rain";
                break;
            case 312:
                msg = "heavy intensity drizzle rain";
                break;
            case 313:
                msg = "shower rain and drizzle";
                break;
            case 314:
                msg = "heavy shower rain and drizzle";
                break;
            case 321:
                msg = "shower drizzle";
                break;
            case 500:
                msg = "light rain";
                break;
            case 501:
                msg = "moderate rain";
                break;
            case 502:
                msg = "heavy intensity rain";
                break;
            case 503:
                msg = "very heavy rain";
                break;
            case 504:
                msg = "extreme rain";
                break;
            case 511:
                msg = "freezing rain";
                break;
            case 520:
                msg = "light intensity shower rain";
                break;
            case 521:
                msg = "shower rain";
                break;
            case 522:
                msg = "heavy intensity shower rain";
                break;
            case 531:
                msg = "ragged shower rain";
                break;
            case 600:
                msg = "light snow";
                break;
            case 601:
                msg = "snow";
                break;
            case 602:
                msg = "heavy snow";
                break;
            case 611:
                msg = "sleet";
                break;
            case 612:
                msg = "shower sleet";
                break;
            case 615:
                msg = "light rain and snow";
                break;
            case 616:
                msg = "rain and snow";
                break;
            case 620:
                msg = "light shower snow";
                break;
            case 621:
                msg = "shower snow";
                break;
            case 622:
                msg = "heavy shower snow";
                break;
            case 701:
                msg = "mist";
                break;
            case 711:
                msg = "smoke";
                break;
            case 721:
                msg = "haze";
                break;
            case 731:
                msg = "sand, dust whirls";
                break;
            case 741:
                msg = "fog";
                break;
            case 751:
                msg = "sand";
                break;
            case 761:
                msg = "dust";
                break;
            case 762:
                msg = "volcanic ash";
                break;
            case 771:
                msg = "squalls";
                break;
            case 781:
                msg = "tornado";
                break;
            case 800:
                msg = "clear sky";
                break;
            case 801:
                msg = "few clouds";
                break;
            case 802:
                msg = "scattered clouds";
                break;
            case 803:
                msg = "broken clouds";
                break;
            case 804:
                msg = "overcast clouds";
                break;
            case 900:
                msg = "tornado";
                break;
            case 901:
                msg = "tropical storm";
                break;
            case 902:
                msg = "hurricane";
                break;
            case 903:
                msg = "cold";
                break;
            case 904:
                msg = "hot";
                break;
            case 905:
                msg = "windy";
                break;
            case 906:
                msg = "hail";
                break;
            case 951:
                msg = "calm";
                break;
            case 952:
                msg = "light breeze";
                break;
            case 953:
                msg = "gentle breeze";
                break;
            case 954:
                msg = "moderate breeze";
                break;
            case 955:
                msg = "fresh breeze";
                break;
            case 956:
                msg = "strong breeze";
                break;
            case 957:
                msg = "high wind, near gale";
                break;
            case 958:
                msg = "gale";
                break;
            case 959:
                msg = "severe gale";
                break;
            case 960:
                msg = "storm";
                break;
            case 961:
                msg = "violent storm";
                break;
            case 962:
                msg = "hurricane";
                break;
            default:
                msg = "Not Available";

        }
        return msg.toUpperCase();
    }
}
