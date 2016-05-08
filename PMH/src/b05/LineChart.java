package b05;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * A simple demonstration application showing how to create a line chart using data from an
 * {@link XYDataset}.
 *
 */
public class LineChart extends ApplicationFrame {

	/**
	 * Creates a new demo.
	 *
	 * @param title
	 *            the frame title.
	 */
	public LineChart(final String title) {
		super(title);
		this.setLayout(null);
		this.pack();
		this.setBounds(100, 100, 1016, 541);
		RefineryUtilities.centerFrameOnScreen(this);
		this.setVisible(true);
		final XYDataset dataset = createDataset();
		final JFreeChart chart = createChart(dataset);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setBounds(0, 0, 1000, 500);
		setContentPane(chartPanel);
	}

	/**
	 * Creates a sample dataset.
	 * 
	 * @return a sample dataset.
	 */
	private XYDataset createDataset() {

		final XYSeries series1 = new XYSeries("Bielefeld");
		series1.add(1, 1);
		series1.add(2, 2);
		series1.add(3, 3);
		series1.add(4, 6);
		series1.add(5, 6);
		series1.add(6, 7);
		series1.add(7, 8);
		series1.add(8, 9);

		final XYSeries series2 = new XYSeries("Düsseldorf");
		series2.add(1, 0);
		series2.add(2, 0);
		series2.add(3, 1);
		series2.add(4, 3);
		series2.add(5, 3);
		series2.add(6, 6);
		series2.add(7, 7);
		series2.add(8, 7);

		final XYSeries series3 = new XYSeries("Greuther Fürth");
		series3.add(1, 3);
		series3.add(2, 6);
		series3.add(3, 6);
		series3.add(4, 7);
		series3.add(5, 7);
		series3.add(6, 8);
		series3.add(7, 11);
		series3.add(8, 12);

		final XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		dataset.addSeries(series3);

		return dataset;
	}

	/**
	 * Creates a chart.
	 * 
	 * @param dataset
	 *            the data for the chart.
	 * 
	 * @return a chart.
	 */
	private JFreeChart createChart(final XYDataset dataset) {

		final JFreeChart chart = ChartFactory.createXYLineChart("Punkte jeder Mannschaft", "Spieltag", "Punkte", dataset, PlotOrientation.VERTICAL, true, true, false);

		chart.setBackgroundPaint(Color.white);

		final XYPlot plot = chart.getXYPlot();
		plot.setBackgroundPaint(Color.lightGray);

		final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesLinesVisible(0, true);
		renderer.setSeriesShapesVisible(0, true);
		renderer.setSeriesLinesVisible(1, true);
		renderer.setSeriesShapesVisible(1, true);
		renderer.setSeriesLinesVisible(2, true);
		renderer.setSeriesShapesVisible(2, true);
		plot.setRenderer(renderer);

		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		return chart;
	}

}
