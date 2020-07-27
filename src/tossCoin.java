import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

public class tossCoin extends JFrame{
    private JPanel panel;
    private JPanel top;
    private JPanel bottom;
    private JPanel left;
    private JPanel right;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton tossCoin_btn;
    private JButton info_btn;
    private JLabel image_label;

    private String player1;
    private String player2;
    private String win;

    public tossCoin() {
        comboBox2.setEnabled(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ΠΡΟΓΡΑΜΜΑ ΠΡΟΣΟΜΕΙΩΣΗΣ ΡΙΨΗΣ ΚΕΡΜΑΤΟΣ");
        this.setContentPane(panel);
        this.pack();

        fillComboBox();
        tossCoin_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toss();
            }
        });

        info_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel, "ΠΡΟΓΡΑΜΜΑ ΠΡΟΣΟΜΕΙΩΣΗΣ ΡΙΨΗΣ ΚΕΡΜΑΤΟΣ\nΠΡΟΓΡΑΜΜΑΤΙΣΗΣ : ΨΑΛΤΑΚΗΣ ΝΙΚΟΛΑΟΣ",
                        "ΠΛΗΡΟΦΟΡΙΕΣ", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (comboBox1.getSelectedIndex() == 1){
                    comboBox2.setSelectedIndex(2);
                    player1 = comboBox1.getSelectedItem().toString();
                    player2 = comboBox2.getSelectedItem().toString();
                }else if (comboBox1.getSelectedIndex() == 2){
                    comboBox2.setSelectedIndex(1);
                    player1 = comboBox1.getSelectedItem().toString();
                    player2 = comboBox2.getSelectedItem().toString();
                }
            }
        });

    }

    public void fillComboBox() {
        comboBox1.addItem("ΚΑΝΕ ΤΗΝ ΕΠΙΛΟΓΗ ΣΟΥ");
        comboBox1.addItem("HEADS");
        comboBox1.addItem("TAILS");
        comboBox2.addItem("ΚΑΝΕ ΤΗΝ ΕΠΙΛΟΓΗ ΣΟΥ");
        comboBox2.addItem("HEADS");
        comboBox2.addItem("TAILS");
    }

    public void toss() {
        Random r = new Random();
        int rand = r.nextInt(100);
        if (rand % 2 != 0) {
            image_label.setIcon(new ImageIcon("images/tails.jpg"));
            win = "TAILS";
        }else {
            image_label.setIcon(new ImageIcon("images/heads.jpg"));
            win = "HEADS";
        }
        if (win == player1) {
            JOptionPane.showMessageDialog(panel, "ΚΕΡΔΙΣΕ Ο 1ος ΠΑΙΧΤΗΣ ΜΕ " + player1,
                    "ΝΙΚΗΤΗΣ", JOptionPane.INFORMATION_MESSAGE);
        }else if (win == player2) {
            JOptionPane.showMessageDialog(panel, "ΚΕΡΔΙΣΕ Ο 2ος ΠΑΙΧΤΗΣ ΜΕ " + player2,
                    "ΝΙΚΗΤΗΣ", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new tossCoin();
        frame.setSize(750, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
