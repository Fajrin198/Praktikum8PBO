package nomor9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Window extends JFrame {

    private Container basePanel = null;
    private JPanel JPanelNorth = null;
    private JPanel JPanelCenter = null;
    private JLabel JLabelURL = null;
    private JTextField JTextFieldURL = null;
    private JButton JButtonParse = null;
    private JScrollPane JScrollPane = null;
    private JTextPane JTextPane = null;

    private void initUI() {
        setSize(600, 500);
        setContentPane(getBasePane1());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getBasePane1();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel getJPanelNorth() {
        if (JPanelNorth == null) {
            JPanelNorth = new JPanel(new FlowLayout());
            JPanelNorth.add(getJLabelURL());
            JPanelNorth.add(getJTextFieldURL());
            JPanelNorth.add(getJButtonParse());
        }
        return JPanelNorth;
    }

    private JPanel getJPanelCenter() {
        if (JPanelCenter == null) {
            JPanelCenter = new JPanel(new BorderLayout());
            JScrollPane = new JScrollPane();
            JTextPane = new JTextPane();
            JScrollPane.setViewportView(JTextPane);
            JPanelCenter.add(JScrollPane, BorderLayout.CENTER);
        }
        return JPanelCenter;
    }

    private Container getBasePane1() {
        if (basePanel == null) {
            basePanel = getContentPane();
            basePanel.add(getJPanelNorth(), BorderLayout.NORTH);
            basePanel.add(getJPanelCenter(), BorderLayout.CENTER);
        }
        return basePanel;
    }

    private JLabel getJLabelURL() {
        if (JLabelURL == null) {
            JLabelURL = new JLabel("URL");
        }

        return JLabelURL;
    }

    private JTextField getJTextFieldURL() {
        if (JTextFieldURL == null) {
            JTextFieldURL = new JTextField();
            JTextFieldURL.setPreferredSize(new Dimension(460, 28));
        }

        return JTextFieldURL;
    }
    
    private String hitungFrekuensi(String text){
        StringBuffer sb = new StringBuffer();
        // Filtering
        String hasil = text.toLowerCase().replaceAll("\\.|\\(|\\)|[0-9]\\:", " ").replaceAll("\\s+", " ");
        String[] kata = hasil.split("\\s");
        // Tokenizing
        ArrayList<Data> frekuensiKata = new ArrayList();
        // Perhitungan Frekuensi
        for(String s : kata){
            boolean sudahAda = false;
            for(Data d : frekuensiKata){
                if(d.kata.equalsIgnoreCase(s)){
                    d.incrementFrekuensi();
                    sudahAda = true;
                    break;
                }
            }
            if(!sudahAda){
                Data kataBaru = new Data(s);
                frekuensiKata.add(kataBaru);
            }
        }
        for(Data d : frekuensiKata){
            sb.append(d.kata+"("+d.frekuensi+") ");
        }
        return sb.toString();
    }
    
    private JButton getJButtonParse() {
        if (JButtonParse == null) {
            JButtonParse = new JButton("PARSE");
            JButtonParse.setBackground(Color.BLACK);
            JButtonParse.setForeground(Color.WHITE);
            //Aksi
            JButtonParse.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String sURL = JTextFieldURL.getText();
                        Document doc = Jsoup.connect(sURL).get();
                        String text = doc.text();
                        String textFrekuensi = hitungFrekuensi(text);
                        JTextPane.setText(textFrekuensi);
                    } catch (IOException ex) {
                        Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        }

        return JButtonParse;
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
