package ucas.java.sunhanwu.gui;
import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.Color;

public class JTextFieldHintListener implements FocusListener
{
    private String hintText;
    private JTextField textField;

    // constructor
    public JTextFieldHintListener(JTextField jTextField, String hintText)
    {
        this.hintText = hintText;
        this.textField = jTextField;
        jTextField.setText(hintText);
        jTextField.setForeground(Color.GRAY);
    }

    @Override
    public void focusGained(FocusEvent e)
    {
        String temp = textField.getText();
        if(temp.equals(hintText))
        {
            textField.setText("");
            textField.setForeground(Color.BLACK);
        }

    }

    @Override
    public void focusLost(FocusEvent e)
    {
        String temp = textField.getText();
        if(temp.equals(""))
        {
            textField.setForeground(Color.GRAY);
            textField.setText(hintText);
        }
    }
}
