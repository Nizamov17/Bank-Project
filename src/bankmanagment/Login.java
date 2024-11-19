package bankmanagment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login, singUp, clear;
    JTextField cardText;
    JPasswordField  pinText;

    Login(){
        setTitle("BANCK MANAGER");

        setLayout(null);

        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/pngwingcom.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text = new JLabel("Welcome to Bank");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardno = new JLabel("Card num:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        add(cardno);

        cardText =  new JTextField();
        cardText.setBounds(300,155,230,30);
        cardText.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardText);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);


        pinText =  new JPasswordField();
        pinText.setBounds(300,220,230,30);
        pinText.setFont(new Font("Arial", Font.BOLD,14));
        add(pinText);

        login = new JButton("SING IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        singUp = new JButton("SING UP");
        singUp.setBounds(300,350,230,30);
        singUp.setBackground(Color.BLACK);
        singUp.setForeground(Color.white);
        singUp.addActionListener(this);
        add(singUp);



        getContentPane().setBackground(Color.WHITE);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clear){
            cardText.setText("");
            pinText.setText("");
        } else if(e.getSource() == login){
            Connect connect = new Connect();
            String cardNumber = cardText.getText();
            String pinNumber = pinText.getText();
            String query = "select * from login where cardNumber = '"+cardNumber+"' and pin = '"+pinNumber+"'";
            try{
                ResultSet rs = connect.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                }
            }catch (Exception e1){
                System.out.println(e1);
            }
        } else if (e.getSource() == singUp) {
            setVisible(false);
            new SingUpOne().setVisible(true);
        }
    }
}
