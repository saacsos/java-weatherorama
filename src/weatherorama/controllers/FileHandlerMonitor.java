package weatherorama.controllers;

import weatherorama.models.Weather;
import weatherorama.models.WeatherORama;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class FileHandlerMonitor implements Observer{
    private WeatherController controller;

    public FileHandlerMonitor(WeatherController controller) {
        this.controller = controller;
    }

    @Override
    public void update(Observable obj, Object arg) {
        if (obj instanceof WeatherORama) {
            WeatherORama weatherO = (WeatherORama) arg;
            Weather weather = weatherO.getCurrent();
            try {
                controller.saveWeatherToFile(weather.getTemperature(), weather.getHumidity());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
