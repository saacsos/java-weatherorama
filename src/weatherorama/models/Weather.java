package weatherorama.models;

public class Weather {
	private double temperature;
	private double humidity;

	public Weather(double temperature, double humidity) {
		this.temperature = temperature;
		this.humidity = humidity;
	}

	public double getTemperature() {
		return temperature;
	}

	public double getHumidity() {
		return humidity;
	}

}
