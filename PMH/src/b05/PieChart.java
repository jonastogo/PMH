package b05;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Rotation;

@SuppressWarnings("serial")
public class PieChart extends ApplicationFrame {
	private Main main;

	public PieChart(String applicationTitle, String chartTitle, Main main) {
		super(applicationTitle);
		this.main = main;
		this.setLayout(null);
		this.pack();
		this.setBounds(100, 100, 516, 311);
		RefineryUtilities.centerFrameOnScreen(this);
		this.setVisible(true);
		PieDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset, chartTitle);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setBounds(0, 0, 500, 270);
		setContentPane(chartPanel);

	}

	/**
	 * Creates a sample dataset
	 */

	private PieDataset createDataset() {
		DefaultPieDataset result = new DefaultPieDataset();
		result.setValue(main.getBestinfirst().getSpielerListe().get(0).getName(), main.getBestinfirst().getSpielerListe().get(0).getPunkte());
		result.setValue(main.getBestinfirst().getSpielerListe().get(1).getName(), main.getBestinfirst().getSpielerListe().get(1).getPunkte());
		result.setValue(main.getBestinfirst().getSpielerListe().get(2).getName(), main.getBestinfirst().getSpielerListe().get(2).getPunkte());
		return result;

	}

	/**
	 * Creates a chart
	 */

	private JFreeChart createChart(PieDataset dataset, String title) {

		JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true, true, true);

		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setStartAngle(290);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		return chart;

	}
}
