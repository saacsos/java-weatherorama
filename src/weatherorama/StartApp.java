package weatherorama;

import weatherorama.controllers.WeatherController;
import weatherorama.views.WeatherFrame;

public class StartApp {

	public static void main(String[] args) {
		WeatherFrame frame = new WeatherFrame();
		WeatherController controller = new WeatherController(frame);
		frame.render();
		controller.start();
	}

}
