package bankmanagment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;
import java.sql.ResultSet;

public class FastCash extends JFrame implements ActionListener {

    JButton b1,b2,b3,b4,b5,b6,back;
    String pinNumber;
    FastCash(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Select Withdrawl amount");
        text.setBounds(250,330,700,35);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        b1 = new JButton("$  100");
        b1.setBounds(213,423,100,20);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("$  500");
        b2.setBounds(210,458,100,20);
        b2.addActionListener(this);
        image.add(b2);

        b3 = new JButton("$  1000");
        b3.setBounds(207,494,100,20);
        b3.addActionListener(this);
        image.add(b3);

        b4 = new JButton("$  2000");
        b4.setBounds(380,423,100,20);
        b4.addActionListener(this);
        image.add(b4);

        b5 = new JButton("$  5000");
        b5.setBounds(380,458,100,20);
        b5.addActionListener(this);
        image.add(b5);

        b6 = new JButton("$  10000");
        b6.setBounds(380,494,100,20);
        b6.addActionListener(this);
        image.add(b6);

        back = new JButton("Back");
        back.setBounds(380,530,100,20);
        back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setLocation(500,80);
        setUndecorated(true);
        setVisible(true);

    }

    public static void main(String[] args) {
        new FastCash("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        } else {
            String amount = ((JButton)e.getSource()).getText().substring(3);
            Connect connect = new Connect();
            try {
                ResultSet rs = connect.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if(e.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values ('"+pinNumber+"','"+date+"','Withdrawl','"+amount+"')";
                connect.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"$  " + amount + " Debited Successfully");

                setVisible(false);
                new Transactions(pinNumber).setVisible(true);

            }catch (Exception e1){
                System.out.println(e1);
            }
        }
    }
}
