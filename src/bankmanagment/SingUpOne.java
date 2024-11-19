package bankmanagment;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;



public class SingUpOne extends JFrame implements ActionListener {

    long random;
    JTextField nameText, surnameText,emailText,addressText,cityText,stateText,pinCodeText;
    JButton next;
    JRadioButton male,fmale,married,unMarried, other;
    JDateChooser dateChooser;

    SingUpOne(){

        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO. " + random );
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personDetails = new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetails.setBounds(300,80,400,30);
        add(personDetails);

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        add(name);

        nameText = new JTextField();
        nameText.setFont(new Font("Raleway",Font.BOLD, 14));
        nameText.setBounds(250,140,400,30);
        add(nameText);

        JLabel surname = new JLabel("Surname: ");
        surname.setFont(new Font("Raleway", Font.BOLD, 20));
        surname.setBounds(100,180,100,32);
        add(surname);

        surnameText = new JTextField();
        surnameText.setFont(new Font("Raleway",Font.BOLD, 14));
        surnameText.setBounds(250,180,400,32);
        add(surnameText);

        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,220,200,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(250, 220,200,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,260,100,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(250,260,60,30);
        male.setBackground(Color.white);
        add(male);

        fmale = new JRadioButton("Fmale");
        fmale.setBounds(320,260,60,30);
        fmale.setBackground(Color.white);
        add(fmale);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(fmale);

        JLabel email = new JLabel("Email: ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,300,100,30);
        add(email);

        emailText = new JTextField();
        emailText.setFont(new Font("Raleway",Font.BOLD, 14));
        emailText.setBounds(250,300,400,32);
        add(emailText);

        JLabel marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,340,200,30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(250,340,70,30);
        married.setBackground(Color.white);
        add(married);

        unMarried = new JRadioButton("Unmarried");
        unMarried.setBounds(340,340,100,30);
        unMarried.setBackground(Color.white);
        add(unMarried);

        other = new JRadioButton("Other");
        other.setBounds(450,340,70,30);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unMarried);
        maritalGroup.add(other);

        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,380,200,30);
        add(address);

        addressText = new JTextField();
        addressText.setFont(new Font("Raleway",Font.BOLD, 14));
        addressText.setBounds(250,380,400,32);
        add(addressText);

        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,420,200,30);
        add(city);

        cityText = new JTextField();
        cityText.setFont(new Font("Raleway",Font.BOLD, 14));
        cityText.setBounds(250,420,400,32);
        add(cityText);

        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,460,200,30);
        add(state);

        stateText = new JTextField();
        stateText.setFont(new Font("Raleway",Font.BOLD, 14));
        stateText.setBounds(250,460,400,32);
        add(stateText);

        JLabel pinCode = new JLabel("Pin Code: ");
        pinCode.setFont(new Font("Raleway", Font.BOLD, 20));
        pinCode.setBounds(100,500,200,30);
        add(pinCode);

        pinCodeText = new JTextField();
        pinCodeText.setFont(new Font("Raleway",Font.BOLD, 14));
        pinCodeText.setBounds(250,500,400,32);
        add(pinCodeText);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(570, 600, 80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SingUpOne();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = " " + random;
        String name = nameText.getText();
        String surName = surnameText.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        } else if(fmale.isSelected()){
            gender = "Fmale";
        }
        String email = emailText.getText();
        String marital = null;
        if (married.isSelected()){
            marital = "Married";
        } else if (unMarried.isSelected()) {
            marital = "unMarried";
        } else if(other.isSelected()){
            marital = "Other";
        }

        String address = addressText.getText();
        String city = cityText.getText();
        String state = stateText.getText();
        String pin = pinCodeText.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name of Required");
            } else{
                Connect connect = new Connect();
                String query = "insert into singup values('"+formno+"','"+name+"','"+surName+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                connect.s.executeUpdate(query);
                setVisible(false);
                new SingUpTwo(formno).setVisible(true);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
