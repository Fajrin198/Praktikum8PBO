package nomor1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Passing Web");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        JLabel JLabel1 = new JLabel("Masukkan Satuan :");
        JLabel1.setBounds(10, 20, 120, 20);
        frame.add(JLabel1);

        JTextField JTextField1 = new JTextField();
        JTextField1.setPreferredSize(new Dimension(100, 20));
        JTextField1.setBounds(122, 20, 150, 20);
        frame.add(JTextField1);

        String[] opsiSatuan = {"KM", "HM", "DAM", "M", "DM", "CM", "MM"};
        JComboBox<String> satuanPanjang01 = new JComboBox(opsiSatuan);
        satuanPanjang01.setBounds(273, 20, 50, 20);
        frame.add(satuanPanjang01);

        JButton JButtonParse = new JButton("KONVERSI");
        JButtonParse.setBackground(Color.BLACK);
        JButtonParse.setForeground(Color.WHITE);
        JButtonParse.setSize(40, 20);
        JButtonParse.setBounds(120, 45, 120, 20);
        frame.add(JButtonParse);

        JLabel JLabel2 = new JLabel();
        JLabel2.setText("Hasil :");
        JLabel2.setBounds(10, 70, 120, 20);
        frame.add(JLabel2);

        JTextField JTextField2 = new JTextField();
        JTextField2.setPreferredSize(new Dimension(100, 20));
        JTextField2.setBounds(122, 70, 150, 20);
        frame.add(JTextField2);

        String[] opsiSatuan2 = {"KM", "HM", "DAM", "M", "DM", "CM", "MM"};
        JComboBox<String> satuanPanjang02 = new JComboBox(opsiSatuan2);
        satuanPanjang02.setBounds(273, 70, 50, 20);
        frame.add(satuanPanjang02);

        //Aksi
        JButtonParse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // fungsinya untuk menangkap string yang dituliskan pada JTextFieldURL
                String inputSatuan01 = satuanPanjang01.getSelectedItem().toString();
                String inputSatuan02 = satuanPanjang02.getSelectedItem().toString();
                String inputString = JTextField1.getText();
                double nilai = Double.parseDouble(inputString);
                String[] satuan = {"km", "hm", "dam", "m", "dm", "cm", "mm"};
                int nilaiAwal = 0;
                int nilaiAkhir = 0;
                for (int i = 0; i < satuan.length; i++) {
                    if (!(inputSatuan01.equalsIgnoreCase(satuan[i]))) {
                        nilaiAwal++;
                    } else {
                        break;
                    }
                }
                for (int i = 0; i < satuan.length; i++) {
                    if (!(inputSatuan02.equalsIgnoreCase(satuan[i]))) {
                        nilaiAkhir++;
                    } else {
                        break;
                    }
                }
                System.out.println(nilaiAwal);
                System.out.println(nilaiAkhir);
                if (nilaiAwal < nilaiAkhir) {
                    for (int j = nilaiAwal; j < nilaiAkhir; j++) {
                        nilai *= 10;
                    }
                } else {
                    for (int j = nilaiAwal; j > nilaiAkhir; j--) {
                        nilai /= 10.0;
                    }
                    System.out.println(nilai);
                }
                JTextField2.setText(String.valueOf(nilai));
            }
        });
    }
}
