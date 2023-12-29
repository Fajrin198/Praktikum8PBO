package nomor11;

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

public class CaesarCipher extends JFrame {
    
    private JPanel bestPanel = null;
    private JTextField JTextFieldMassege = null;
    private JTextField JTextFieldKeyword = null;
    private JTextField JTextFieldEncrypt = null;
    private JTextField JTextFieldDecrypt = null;
    private JLabel JLabelMassege = null;
    private JLabel JLabelKeyword = null;
    private JLabel JLabelEncrypt = null;
    private JLabel JLabelDecrypt = null;
    private JButton JButtonOK = null;
    private JButton JButton2 = null;
    
    private void initUI() {
        setContentPane(getBestPanel());
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private JPanel getBestPanel() {
        if (bestPanel == null) {
            bestPanel = new JPanel(new MigLayout());
            bestPanel.add(getLabelMassege());
            bestPanel.add(getJTextFieldMassege(),"wrap");
            bestPanel.add(getLabelKeyword());
            bestPanel.add(getJTextFieldKeyword(),"wrap");
            bestPanel.add(getJButtonOK(), "span, grow");
            bestPanel.add(getLabelEncrypt());
            bestPanel.add(getJTextFieldEncrypt(),"wrap");
            bestPanel.add(getJButton2(),"span, grow");
            bestPanel.add(getLabelDecrypt());
            bestPanel.add(getJTextFieldDecrypt());
            
        }
        return bestPanel;
    }
    
    private JLabel getLabelMassege() {
        if (JLabelMassege == null) {
            JLabelMassege = new JLabel("Massege");
        }
        
        return JLabelMassege;
    }
    private JLabel getLabelKeyword() {
        if (JLabelKeyword == null) {
            JLabelKeyword = new JLabel("Shift");
        }
        
        return JLabelKeyword;
    }
    
    private JLabel getLabelEncrypt() {
        if (JLabelEncrypt == null) {
            JLabelEncrypt = new JLabel("Ciphertext");
        }
        
        return JLabelEncrypt;
    }
    
    private JLabel getLabelDecrypt() {
        if (JLabelDecrypt == null) {
            JLabelDecrypt = new JLabel("Plaintext");
        }
        
        return JLabelDecrypt;
    }
    
    private JTextField getJTextFieldMassege() {
        if (JTextFieldMassege == null) {
            JTextFieldMassege = new JTextField();
            JTextFieldMassege.setPreferredSize(new Dimension(200, 28));
        }
        
        return JTextFieldMassege;
    }
    private JTextField getJTextFieldKeyword() {
        if (JTextFieldKeyword == null) {
            JTextFieldKeyword = new JTextField();
            JTextFieldKeyword.setPreferredSize(new Dimension(200, 28));
        }
        
        return JTextFieldKeyword;
    }
    
    private JTextField getJTextFieldEncrypt() {
        if (JTextFieldEncrypt == null) {
            JTextFieldEncrypt = new JTextField();
            JTextFieldEncrypt.setPreferredSize(new Dimension(200,28));
        }
        
        return JTextFieldEncrypt;
    }
    
    private JTextField getJTextFieldDecrypt() {
        if (JTextFieldDecrypt == null) {
            JTextFieldDecrypt = new JTextField();
            JTextFieldDecrypt.setPreferredSize(new Dimension(200,28));
        }
        
        return JTextFieldDecrypt;
    }
    
    public static String encrypt(String message, int shift){
        String plaintext=message.toUpperCase();
        char[] charArray = plaintext.toCharArray();
        StringBuilder b = new StringBuilder();
        for ( int i = 0; i < charArray.length; i++){
            int a = (int) charArray[i]-65;
            int c = a;
            if( a>= 0 && a < 26){
                c = (a + shift)%26;
            }
            c = c + 65;
            b.append((char)c);
        }
        String ciphertext = b.toString();
        return ciphertext;
    }
    
    public static String decrypt(String message, int shift){
        String ciphertext = message.toUpperCase();
        char[] charArray = ciphertext.toCharArray();
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < charArray.length; i++){
            int c = (int)charArray[i]-65;
            int a = c;
            if ( c >= 0 && c<26){
                a = (c - shift) % 26;
                if ( a < 0){
                    a = 26+ a;
                }
            }
            a = a + 65;
            b.append((char)a);
        }
        String plaintext = b.toString();
        return plaintext;
    }
    
    private JButton getJButtonOK() {
        if (JButtonOK == null) {
            JButtonOK = new JButton("Encrypt");
            JButtonOK.setPreferredSize(new Dimension(240,28));
            //Aksi
            JButtonOK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String message = JTextFieldMassege.getText();
                    int shift = Integer.parseInt(JTextFieldKeyword.getText());
                    String ciphertext = encrypt(message, shift);
                    JTextFieldEncrypt.setText(ciphertext);
                }
            });
        }
        
        return JButtonOK;
    }
    
    private JButton getJButton2() {
        if (JButton2 == null) {
            JButton2 = new JButton("Decrypt");
            JButton2.setPreferredSize(new Dimension(240,28));
            //Aksi
            JButton2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String message = JTextFieldMassege.getText();
                    int shift = Integer.parseInt(JTextFieldKeyword.getText());
                    String ciphertext = encrypt(message, shift);
                    String plaintext = decrypt(ciphertext, shift);
                    JTextFieldDecrypt.setText(plaintext);
                }
            });
        }
        
        return JButton2;
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CaesarCipher cc = new CaesarCipher();
                cc.initUI();
            }
        });
    }
}
