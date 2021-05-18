package ucas.java.sunhanwu.gui;

import org.jfree.chart.ChartPanel;
import ucas.java.sunhanwu.cdn.AEntity;
import ucas.java.sunhanwu.utils.StatisticA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.List;

public class CdnQuery {
    private JComboBox typeBox;
    private JFrame mainWindow;
    private Panel querySubmitPanel;
    private JTextField queryTextField;
    private JPanel resultPanel;
    private Button submit;
    private Object FocusEvent;
    private JPanel savePanel;


    // constructor
    public CdnQuery(){};

    public void showMainWindow()
    {
        mainWindow = new JFrame();
        // set the title
        mainWindow.setTitle("cdn 域名查询工具");
        // set close method
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set size
        mainWindow.setBounds(200, 200, 800, 550);
        // set border layout
        mainWindow.setLayout(new FlowLayout());

        // create querySubmitPanel
        querySubmitPanel = new Panel();
        querySubmitPanel.setLayout(new FlowLayout());

        // create typebox
        JLabel label = new JLabel("记录类型:");
        label.setPreferredSize(new Dimension(65, 35));
        querySubmitPanel.add(label);
        typeBox = new JComboBox();
        typeBox.addItem("A记录");
        typeBox.addItem("CNAME记录");
        typeBox.setPreferredSize(new Dimension(100, 35));
        querySubmitPanel.add(typeBox);


        // create QueryTextField
        queryTextField = new JTextField();
        queryTextField.setPreferredSize(new Dimension(515, 35));
        queryTextField.addFocusListener(new JTextFieldHintListener(queryTextField, "请输入要查询的域名:"));
        querySubmitPanel.add(queryTextField);

        // create result textarea
        resultPanel = new JPanel();

        // create submit button
        submit = new Button("查询");
        submit.setPreferredSize(new Dimension(100, 35));
        int type = 0;
        String typeString = typeBox.getSelectedItem().toString();
        submit.addActionListener(new ButtonClickListener(queryTextField, this.typeBox, resultPanel));
        querySubmitPanel.add(submit);
        mainWindow.add(querySubmitPanel);


        savePanel = new JPanel();
//        JLabel savelabel = new JLabel("请选择存储位置:");
//        savePanel.add(savelabel);
        JButton saveButton = new JButton("导出原始数据");
        saveButton.addActionListener(new SaveButtonListener(this.queryTextField, this.typeBox));
        savePanel.add(saveButton);

        mainWindow.add(resultPanel);
        mainWindow.add(savePanel);






        // set visible
        mainWindow.setVisible(true);

    }

}
