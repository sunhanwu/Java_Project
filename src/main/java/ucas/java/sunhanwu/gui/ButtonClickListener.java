package ucas.java.sunhanwu.gui;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import ucas.java.sunhanwu.cdn.AEntity;
import ucas.java.sunhanwu.utils.QueryDatabase;

import javax.swing.*;
import java.util.*;

import ucas.java.sunhanwu.utils.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ButtonClickListener implements ActionListener
{
    private JTextField queryTextField;
    private JPanel resultArea;
    private JComboBox typeBox;

    //constructor
    public ButtonClickListener(JTextField query, JComboBox typeBox, JPanel resultArea)
    {
        this.typeBox = typeBox;
        this.queryTextField = query;
        this.resultArea = resultArea;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String query = this.queryTextField.getText();
        QueryDatabase queryDatabase = new QueryDatabase();
        JOptionPane jOptionPane = new JOptionPane();
        try {
            int type=1;
            if (this.typeBox.getSelectedItem().toString()=="A记录")
                type = 0;
            List result = queryDatabase.query(query, type);
            if (this.typeBox.getSelectedItem().toString() == "A记录")
            {
                StatisticA statisticA = new StatisticA(result);
                Hashtable<String, Integer> statistic = statisticA.statistic();
                CreateBar bar = new CreateBar(statistic);
                ChartPanel chartPanel = bar.createBarPanel();
                this.resultArea.removeAll();
                this.resultArea.add(chartPanel);
                this.resultArea.revalidate();
                chartPanel.validate();
                JOptionPane.showMessageDialog(null, "总共查询到A记录域名" + result.size() + "个！");

            }
            else
            {
                StatisticCname statisticCname = new StatisticCname(result);
                Hashtable<String, Integer> statistic = statisticCname.statistic();
                CreateBar bar = new CreateBar(statistic);
                ChartPanel chartPanel = bar.createBarPanel();
                this.resultArea.removeAll();
                this.resultArea.add(chartPanel);
                this.resultArea.revalidate();
//                this.resultArea.add(new JLabel("总共查询到CNAME记录域名" + result.size() + "个！"));
                chartPanel.validate();
                JOptionPane.showMessageDialog(null, "总共查询到A记录域名" + result.size() + "个！");
            }
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }
}
