package nomor3;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class KonversiUang extends JFrame {

    private JPanel panel = null;
    private JPanel panel2 = null;
    private JLabel labelDollar = null;
    private JLabel labelRupiah = null;
    private JTextField jtextDollar = null;
    private JTextField jtextRupiah = null;
    private JButton convert1 = null;
    private JLabel labelDollar2 = null;
    private JLabel labelRupiah2 = null;
    private JTextField jtextDollar2 = null;
    private JTextField jtextRupiah2 = null;
    private JButton convert2 = null;

    private void initUI() {
        setSize(400, 300);
        setContentPane(getpanel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel getpanel() {
        if (panel == null) {
            panel = new JPanel(new MigLayout());
            panel.add(getlabelDollar());
            panel.add(getjtextDollar(),"wrap");
            panel.add(getconvert1(),"span, grow");
            panel.add(getlabelRupiah());
            panel.add(getjtextRupiah(),"wrap");
            panel.add(new JLabel(""),"wrap");
            panel.add(getlabelRupiah2());
            panel.add(getjtextRupiah2(),"wrap");
            panel.add(getconvert2(),"span, grow");
            panel.add(getlabelDollar2());
            panel.add(getjtextDollar2(),"wrap");
        }
        return panel;
    }

    private JLabel getlabelDollar() {
        if (labelDollar == null) {
            labelDollar = new JLabel("Dollar");
        }
        return labelDollar;
    }

    private JLabel getlabelRupiah() {
        if (labelRupiah == null) {
            labelRupiah = new JLabel("Rupiah");
        }
        return labelRupiah;
    }

    private JLabel getlabelDollar2() {
        if (labelDollar2 == null) {
            labelDollar2 = new JLabel("Mata Uang Dollar");
        }
        return labelDollar2;
    }

    private JLabel getlabelRupiah2() {
        if (labelRupiah2 == null) {
            labelRupiah2 = new JLabel(" Mata Uang Rupiah");
        }
        return labelRupiah2;
    }

    private JTextField getjtextDollar() {
        if (jtextDollar == null) {
            jtextDollar = new JTextField();
            jtextDollar.setPreferredSize(new Dimension(280, 30));
        }
        return jtextDollar;
    }

    private JTextField getjtextRupiah() {
        if (jtextRupiah == null) {
            jtextRupiah = new JTextField();
            jtextRupiah.setPreferredSize(new Dimension(280, 30));
        }
        return jtextRupiah;
    }
     private JTextField getjtextDollar2() {
        if (jtextDollar2 == null) {
            jtextDollar2 = new JTextField();
            jtextDollar2.setPreferredSize(new Dimension(280, 30));
        }
        return jtextDollar2;
    }

    private JTextField getjtextRupiah2() {
        if (jtextRupiah2 == null) {
            jtextRupiah2 = new JTextField();
            jtextRupiah2.setPreferredSize(new Dimension(280, 30));
        }
        return jtextRupiah2;
    }

    private JButton getconvert1() {
        if (convert1 == null) {
            convert1 = new JButton("Konversi");
            
            convert1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String input = jtextDollar.getText();
                    int dollar = Integer.parseInt(input);
                    int rupiah = dollar * 13000;
                    jtextRupiah.setText("Rp." + rupiah);
                }

            });
        }
        return convert1;
    }

    private JButton getconvert2() {
        if (convert2 == null) {
            convert2 = new JButton("Konversi ke");
            convert2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String inputrp = jtextRupiah2.getText();
                    double rupiah1 = Double.parseDouble(inputrp);
                    double dollar1 = rupiah1 / 13000;
                    jtextDollar2.setText("$" + dollar1);
                }
            });
        }
        return convert2;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                KonversiUang ku = new KonversiUang();
                ku.initUI();
            }
        });
    }
}