package bankmanagment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class WithDrawl extends JFrame implements ActionListener {

    JButton withdraw,back;
    JTextField amount;
    String pinNumber;

    WithDrawl(String pinNumber){

        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setFont(new Font("System",Font.BOLD,13));
        text.setBounds(217,330,400,20);
        text.setForeground(Color.BLACK);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD,22));
        amount.setBounds(217 ,355 ,250, 25);
        add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355,494,125,20);
        withdraw.addActionListener(this);
        image.add(withdraw);

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
        new WithDrawl("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == withdraw){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to Withdraw");
            } else {
                try {
                    Connect connect = new Connect();
                    String query = "insert into bank values('" + pinNumber + "','" + date + "','Withdrawl','" + number + "')";
                    connect.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Withdraw Successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }catch (Exception e1){
                    System.out.println(e1);
                }
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
}
