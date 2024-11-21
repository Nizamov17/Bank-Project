package bankmanagment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange  extends JFrame implements ActionListener {

    JPasswordField pin,repin;
    JButton change,back;
    String pinNumber;

    PinChange(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Change your PIN");
        text.setForeground(Color.BLACK);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(280,330,300,35);
        image.add(text);

        JLabel pinText = new JLabel("New PIN:");
        pinText.setForeground(Color.BLACK);
        pinText.setFont(new Font("System",Font.BOLD,16));
        pinText.setBounds(220,360,200,35);
        image.add(pinText);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 16));
        pin.setBounds(360,360,120,35);
        image.add(pin);

        JLabel repinText = new JLabel("Re-Enter New PIN:");
        repinText.setForeground(Color.BLACK);
        repinText.setFont(new Font("System",Font.BOLD,16));
        repinText.setBounds(217,400,700,35);
        image.add(repinText);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 16));
        repin.setBounds(360,400,120,35);
        image.add(repin);

        change = new JButton("Change");
        change.setBounds(355,494,125,20);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(379,530,100,20);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(500,80);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == change){
            try {
                String npin = pin.getText();
                String rpin = repin.getText();
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }

                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }

                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }

                Connect connect= new Connect();
                String query1 = "update bank set pin = '"+npin+"' where pin='"+pinNumber+"'";
                String query2 = "update login set pin = '"+npin+"' where pin='"+pinNumber+"'";
                String query3 = "update singupthree set pin = '"+npin+"' where pin='"+pinNumber+"'";

                connect.s.executeUpdate(query1);
                connect.s.executeUpdate(query2);
                connect.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");

                setVisible(false);
                new Transactions(rpin).setVisible(true);

            }catch(Exception e1){
                System.out.println(e1);
            }
        } else {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }



    }
}
