package weatherorama.views;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class WeatherFrame extends JFrame {
	private static final long serialVersionUID = -7737808761225276387L;
	private JTextArea jtaCurrent;
	private JTextArea[] jtaStatistics;

	public WeatherFrame() {
		jtaCurrent = new JTextArea();
		jtaStatistics = new JTextArea[] { new JTextArea(), new JTextArea(), new JTextArea() };

	}

	public void render() {
		setSize(200, 400);
		setPreferredSize(new Dimension(200, 400));
		setLayout(new GridLayout(6, 1));
		JLabel labelCurrent = new JLabel("Current");
		labelCurrent.setHorizontalAlignment(SwingConstants.CENTER);
		add(labelCurrent);
		jtaCurrent.setEditable(false);
		add(jtaCurrent);
		JLabel labelStatistics = new JLabel("Statistics");
		labelStatistics.setHorizontalAlignment(SwingConstants.CENTER);
		add(labelStatistics);
		for (JTextArea jta : jtaStatistics) {
			jta.setEditable(false);
			add(jta);
		}
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

	}

	public void updateCurrent(double temperature, double humidity) {
		jtaCurrent.setText(String.format("Current Temperature: %.2f\n Humidity: %.2f", temperature, humidity));
	}

	public void updateAverage(double temperature, double humidity) {
		jtaStatistics[0].setText(String.format("Average\nTemperature: %.2f\nHumidity: %.2f\n", temperature, humidity));
	}

	public void updateMaximum(double temperature, double humidity) {
		jtaStatistics[1].setText(String.format("Maximum\nTemperature: %.2f\nHumidity: %.2f\n", temperature, humidity));
	}

	public void updateMinimum(double temperature, double humidity) {
		jtaStatistics[2].setText(String.format("Minimum\nTemperature: %.2f\nHumidity: %.2f\n", temperature, humidity));
	}
}
