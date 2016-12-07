package weatherorama.models;

import java.util.ArrayList;
import java.util.Observable;

public class WeatherORama extends Observable {
	private Weather current;
	private ArrayList<Weather> data = new ArrayList<>();

	public void add(Weather weather) {
		current = weather;
		data.add(current);
		setChanged();
		notifyObservers(this);
	}

	public Weather getCurrent() {
		return current;
	}

	public double[] average() {
		if (data.size() == 0) {
			return new double[] { 0, 0 };
		}
		double tempTotal = 0;
		double humidTotal = 0;
		for (Weather w : data) {
			tempTotal += w.getTemperature();
			humidTotal += w.getHumidity();
		}
		return new double[] { tempTotal / data.size(), humidTotal / data.size() };
	}

	public double[] max() {
		if (data.size() == 0) {
			return new double[] { 0, 0 };
		}
		double maxTemp = data.get(0).getTemperature();
		double maxHumid = data.get(0).getHumidity();

		for (Weather w : data) {
			if (w.getTemperature() > maxTemp)
				maxTemp = w.getTemperature();
			if (w.getHumidity() > maxHumid)
				maxHumid = w.getHumidity();
		}

		return new double[] { maxTemp, maxHumid };
	}
	
	public double[] min() {
		if (data.size() == 0) {
			return new double[] { 0, 0 };
		}
		double minTemp = data.get(0).getTemperature();
		double minHumid = data.get(0).getHumidity();

		for (Weather w : data) {
			if (w.getTemperature() < minTemp)
				minTemp = w.getTemperature();
			if (w.getHumidity() < minHumid)
				minHumid = w.getHumidity();
		}

		return new double[] { minTemp, minHumid };
	}
}
