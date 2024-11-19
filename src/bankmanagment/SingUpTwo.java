package bankmanagment;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;



public class SingUpTwo extends JFrame implements ActionListener {

    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JDateChooser dateChooser;
    JComboBox religion, category, income, education,occupation;
    String formno;

    SingUpTwo(String formno){
        this.formno = formno;
        setLayout(null);

        setTitle("New Account - Page 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(300,80,400,30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        add(name);

        String [] valReligition = {"Muslim","Christian","Hindu","Other"};
        religion = new JComboBox(valReligition);
        religion.setBounds(270,140,400,30);
        religion.setBackground(Color.white);
        add(religion);

        JLabel surname = new JLabel("Category: ");
        surname.setFont(new Font("Raleway", Font.BOLD, 20));
        surname.setBounds(100,180,100,32);
        add(surname);


        String [] valCategory = {"General", "OBC","SC","Other"};
        category = new JComboBox(valCategory);
        category.setBounds(270,180,400,32);
        category.setBackground(Color.white);
        add(category);

        JLabel dob = new JLabel("Income: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,220,200,30);
        add(dob);

        String [] IncomeCategory = {"Null", "< 1,50,000","< 2,50,0000","< 5,00,000","Upto 10,00,000"};
        income = new JComboBox(IncomeCategory);
        income.setBounds(270,220,400,32);
        income.setBackground(Color.white);
        add(income);

        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,260,150,30);
        add(gender);

        JLabel email = new JLabel("Qualification: ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,285,150,30);
        add(email);

        String [] educationValues = {"Non-Graduation", "Graduate","Post-Graduation","Doctorate","Other"};
        education = new JComboBox(educationValues);
        education.setBounds(270,285,400,32);
        education.setBackground(Color.white);
        add(education);

        JLabel marital = new JLabel("Occupation: ");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,340,200,30);
        add(marital);

        String [] occupationValues = {"Salaried", "Self-Employed","Business","Student","Retired", "Other"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(270,340,400,32);
        occupation.setBackground(Color.white);
        add(occupation);

        JLabel address = new JLabel("PAN Number: ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,380,200,30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD, 14));
        pan.setBounds(270,380,400,32);
        add(pan);

        JLabel city = new JLabel("Aadhaar Number: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,420,200,30);
        add(city);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD, 14));
        aadhar.setBounds(270,420,400,32);
        add(aadhar);

        JLabel state = new JLabel("Senior citizen: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,460,200,30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(270,460,50,30);
        syes.setBackground(Color.white);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(330,460,50,30);
        sno.setBackground(Color.white);
        add(sno);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);


        JLabel pinCode = new JLabel("Existing Account: ");
        pinCode.setFont(new Font("Raleway", Font.BOLD, 20));
        pinCode.setBounds(100,500,200,30);
        add(pinCode);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(280,500,50,30);
        eyes.setBackground(Color.white);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(340,500,50,30);
        eno.setBackground(Color.white);
        add(eno);

        ButtonGroup citizenGroup = new ButtonGroup();
        citizenGroup.add(eyes);
        citizenGroup.add(eno);

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
        new SingUpTwo("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String sineorCitizen = null;
        if(syes.isSelected()){
            sineorCitizen = "Yes";
        } else if(sno.isSelected()){
            sineorCitizen = "No";
        }

        String existingAccount = null;
        if (eyes.isSelected()){
            existingAccount = "Yes";
        } else if (eno.isSelected()) {
            existingAccount = "No";
        }

        String span = pan.getText();
        String saadhar = aadhar.getText();

        try{
            Connect connect = new Connect();
            String query = "insert into singuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+sineorCitizen+"','"+existingAccount+"')";
            connect.s.executeUpdate(query);
            setVisible(false);
            new SingupThree(formno).setVisible(true);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}

