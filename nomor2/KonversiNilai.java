package nomor2;

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

public class KonversiNilai extends JFrame {

    private JPanel panel = null;
    private JLabel labelNilai = null;
    private JTextField jtextnilai = null;
    private JLabel labelhuruf = null;
    private JTextField jtexthuruf = null;
    private JButton convert = null;

    private void initUI() {
        setTitle("Konversi Nilai");
        setSize(200, 150);
        setContentPane(getpanel());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel getpanel() {
        if (panel == null) {
            panel = new JPanel(new MigLayout());
            panel.add(getlabelNilai());
            panel.add(getjtextnilai(),"wrap");
            panel.add(getconvert(),"span, grow");
            panel.add(getlabelHuruf());
            panel.add(getjtexthuruf());

        }
        return panel;
    }

    private JLabel getlabelNilai() {
        if (labelNilai == null) {
            labelNilai = new JLabel("Nilai Angka : ");
        }
        return labelNilai;
    }

    private JLabel getlabelHuruf() {
        if (labelhuruf == null) {
            labelhuruf = new JLabel("Nilai Huruf : ");
        }
        return labelhuruf;
    }

    private JTextField getjtextnilai() {
        if (jtextnilai == null) {
            jtextnilai = new JTextField();
            jtextnilai.setPreferredSize(new Dimension(100, 30));
        }
        return jtextnilai;
    }

    private JTextField getjtexthuruf() {
        if (jtexthuruf == null) {
            jtexthuruf = new JTextField();
            jtexthuruf.setPreferredSize(new Dimension(100,30));
        }
        return jtexthuruf;
    }

    private JButton getconvert() {
        if (convert == null) {
            convert = new JButton("Konversi");
            convert.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int angka = Integer.parseInt(jtextnilai.getText());
                    String sinput = convert(angka);
                    jtexthuruf.setText(sinput);
                }
            });
        }
        return convert;
    }

    private String convert(int angka) {
        if (angka >= 0 && angka <= 100) {
            if (angka >= 85) {
                return "A";
            } else if (angka >= 80) {
                return "A-";
            } else if (angka >= 75) {
                return "B+";
            } else if (angka >= 70) {
                return "B";
            } else if (angka >= 65) {
                return "B-";
            } else if (angka >= 50) {
                return "C";
            } else if (angka >= 40) {
                return "D";
            } else {
                return "E";
            }
        }else{
            return "error";
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                KonversiNilai konversi = new KonversiNilai();
                konversi.initUI();
            }

        });
    }
}
