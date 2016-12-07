package weatherorama.controllers;

import weatherorama.models.Weather;
import weatherorama.models.WeatherORama;
import weatherorama.views.WeatherConsole;
import weatherorama.views.WeatherFrame;

import java.io.*;
import java.util.Date;

public class WeatherController {
    private WeatherFrame frame;
    private WeatherConsole console;
    private WeatherORama collection;
    private WeatherMonitor monitor;
    private FileHandlerMonitor outputFile;
    private final String OUTPUT_FILENAME = "output.txt";


    public WeatherController(WeatherFrame frame) {
        this.frame = frame;
        console = new WeatherConsole();
        collection = new WeatherORama();
        monitor = new WeatherMonitor(this);
        outputFile = new FileHandlerMonitor(this);
        collection.addObserver(monitor);
        collection.addObserver(outputFile);
    }

    public void start() {
        while (true) {
            double[] weathers = console.inputWeather();
            collection.add(new Weather(weathers[0], weathers[1]));
            console.printOut("Weather added");
        }
    }

    public void updateCurrentWeatherToFrame(double temperature, double humidity) {
        frame.updateCurrent(temperature, humidity);
    }

    public void updateStatisticsWeatherToFrame(WeatherORama weatherORama) {
        double[] averages = weatherORama.average();
        double[] maximums = weatherORama.max();
        double[] minimums = weatherORama.min();
        frame.updateAverage(averages[0], averages[1]);
        frame.updateMaximum(maximums[0], maximums[1]);
        frame.updateMinimum(minimums[0], minimums[1]);
    }

    public void saveWeatherToFile(double temperature, double humidity) throws IOException {
        BufferedWriter buffer = new BufferedWriter(new FileWriter(OUTPUT_FILENAME, true));
        String line = (new Date()).toString() + " { ";
        line += "temperature: " + String.valueOf(temperature) + ", ";
        line += "humidity: " + String.valueOf(humidity) + " }\r\n";
        buffer.write(line);
        buffer.close();

    }
}
