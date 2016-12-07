package weatherorama.views;

import java.util.Scanner;

public class WeatherConsole {
	public double[] inputWeather() {
		System.out.print("Input temperature and humidity: ");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		double temperature = scanner.nextDouble();
		double humidity = scanner.nextDouble();
		return new double[] {temperature, humidity};
	}
	
	public void printOut(String str) {
		System.out.println(str);
	}
}
