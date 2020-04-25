import javax.swing.*;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JPanel panel;
    private JRadioButton вводТутRadioButton;
    private JTextField textField1;
    private JButton вводButton;
    private JPanel chartRoot;

    private int nameNum = 0;
    private XChartPanel<PieChart> chartPanel;

    MainForm() {
        final PieChart chart = new PieChartBuilder().width(600).height(400).title("Area Chart").build();

        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        chart.getStyler().setDefaultSeriesRenderStyle(PieSeries.PieSeriesRenderStyle.Donut);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                setContentPane(panel);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                chartPanel = new XChartPanel<PieChart>(chart);
                chartRoot.add(chartPanel);
                pack();
                setVisible(true);
            }


        });
        вводButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                chart.addSeries(String.valueOf(nameNum++), Integer.valueOf(textField1.getText()));
                chartPanel.updateUI();
            }
        });
    }

    public static void main(String[] args) {
        var form = new MainForm();
    }
}
