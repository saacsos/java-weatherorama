package weatherorama.controllers;

import java.util.Observable;
import java.util.Observer;

import weatherorama.models.Weather;
import weatherorama.models.WeatherORama;

public class WeatherMonitor implements Observer {
	private WeatherController controller;
	
	public WeatherMonitor (WeatherController controller) {
		this.controller = controller;
	}

	@Override
	public void update(Observable obj, Object arg) {
		if (obj instanceof WeatherORama) {
			WeatherORama weatherO = (WeatherORama) arg;
			Weather weather = weatherO.getCurrent();
			controller.updateCurrentWeatherToFrame(weather.getTemperature(), weather.getHumidity());
			controller.updateStatisticsWeatherToFrame(weatherO);
		}
	}

}
