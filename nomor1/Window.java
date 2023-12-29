/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nomor1;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class Window extends JFrame {

    private JPanel panel = null;
    private JComboBox<String> JComboBoxr = null;
    private JTextField JTextfieldInput = null;
    private JButton convert = null;
    private JComboBox<String> JComboBoxs = null;
    private JTextField JTextfieldOutput = null;

    private String[] label = new String[]{
        "KM", "HM", "DAM", "M", "DM", "CM", "MM"
    };

    private void initUI() {
        setSize(300, 300);
        setContentPane(getpanel());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel getpanel() {
        if (panel == null) {
            panel = new JPanel(new MigLayout());
            panel.add(getJComboBoxr());
            panel.add(getJTextfieldInput(),"wrap");
            panel.add(getconvert(),"span, grow");
            panel.add(getJComboBoxs());
            panel.add(getJTextfieldOutput());
            
        }
        return panel;
    }

    private JComboBox<String> getJComboBoxr() {
        if (JComboBoxr == null) {
            JComboBoxr = new JComboBox<>(label);
        }
        return JComboBoxr;
    }

    private JComboBox<String> getJComboBoxs() {
        if (JComboBoxs == null) {
             JComboBoxs = new JComboBox<>(label);
        }
        return JComboBoxs;
    }

    private JTextField getJTextfieldInput() {
        if (JTextfieldInput == null) {
            JTextfieldInput = new JTextField();
            JTextfieldInput.setPreferredSize(new Dimension(200, 28));
        }
        return JTextfieldInput;
    }

    private JTextField getJTextfieldOutput() {
        if (JTextfieldOutput == null) {
            JTextfieldOutput = new JTextField();
            JTextfieldOutput.setPreferredSize(new Dimension(200, 28));
        }
        return JTextfieldOutput;
    }

    private JButton getconvert() {
        if (convert == null) {
            convert = new JButton("Convert");
            convert.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int indexin = JComboBoxr.getSelectedIndex()+1;
                    int indexOut = JComboBoxs.getSelectedIndex()+1;
                    String sInput = JTextfieldInput.getText();
                    double input = Double.parseDouble(sInput);
                    double output = convert(indexin, indexOut, input);
                    JTextfieldOutput.setText(""+output);
                }
            });
        }
        return convert;
    }
    private double convert(int dari, int ke,double value){
        double result = value;
        double km = value/Math.pow(10, dari);
        result = km*Math.pow(10, ke);
        
        return result;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Window myWindow = new Window();
                myWindow.initUI();
            }

        });
    }

}
