package ucas.java.sunhanwu.gui;

import ucas.java.sunhanwu.cdn.AEntity;
import ucas.java.sunhanwu.cdn.CnameEntity;
import ucas.java.sunhanwu.utils.IP2Area;
import ucas.java.sunhanwu.utils.QueryDatabase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveButtonListener implements ActionListener {
    private JTextField queryTextField;
    private JComboBox typeBox;

    //constructor
    public SaveButtonListener(JTextField queryTextField, JComboBox typeBox)
    {
        this.queryTextField = queryTextField;
        this.typeBox = typeBox;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String query = this.queryTextField.getText();
        QueryDatabase queryDatabase = new QueryDatabase();
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jfc.showDialog(new JLabel(), "选择");
        String filePath = jfc.getSelectedFile().toString() + "/" + query + "_" + this.typeBox.getSelectedItem().toString() + ".csv";
        System.out.println(filePath);
        JOptionPane jOptionPane = new JOptionPane();
        try {
            if (this.typeBox.getSelectedItem().toString()=="A记录")
            {
                List<AEntity> result = queryDatabase.query(query, 0);
                File file = new File(filePath);
                if (!file.exists())
                    file.createNewFile();
                BufferedWriter out = new BufferedWriter(new FileWriter(file));
                out.write("No.,dns,ip,area,depth,date\n");
                for (int i=0;i<result.size();i++)
                {
                    AEntity item = result.get(i);
                    String line = (i+1) + "," + item.getDns() + "," + item.getIp() + "," + IP2Area.ip2Area(item.getArea()) + "," + item.getDepth() + "," + item.getDate() + "\n";
                    out.write(line);
                }
                out.close();
                JOptionPane.showMessageDialog(null, filePath + "导出完毕");
            }
            else
            {
                List<CnameEntity> result = queryDatabase.query(query, 1);
                File file = new File(filePath);
                if (!file.exists())
                    file.createNewFile();
                BufferedWriter out = new BufferedWriter(new FileWriter(file));
                out.write("No.,dns1,dns2,area,date\n");
                for (int i=0;i<result.size();i++)
                {
                    CnameEntity item = result.get(i);
                    String line = (i+1) + "," + item.getDns1() + "," + item.getDns2() + "," + IP2Area.ip2Area(item.getArea()) + "," + item.getDate() + "\n";
                    out.write(line);
                }
                out.close();
                JOptionPane.showMessageDialog(null, filePath + "导出完毕");
            }
        } catch (IllegalAccessException | IOException ex) {
            ex.printStackTrace();
        }
    }

}
