
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SwingTemperatureConverter implements ActionListener {
    String selected= "Celsius:";
    JLabel lb1,lb2;
    JTextArea t1,t2;
    JButton swi,submit;
    SwingTemperatureConverter(){
        JFrame frame = new JFrame("Temperature Converter");
        JPanel p = new JPanel();
        p.setLayout(null);

        JLabel head = new JLabel("Temperature Convertor");
        head.setBounds(150,30,220,40);
        head.setFont(new Font("Serif", Font.BOLD, 20));
        p.add(head);


        lb1 = new JLabel("Celsius:");
        lb1.setBounds(150,120,90,25);
        lb1.setFont(new Font("Calibri", Font.BOLD, 17));

        t1 = new JTextArea();
        t1.setBounds(240,120,120,25);
        t1.setBorder(BorderFactory.createLineBorder(Color.black));
        t1.setFont(new Font("Calibri", Font.BOLD, 17));

        p.add(lb1);
        p.add(t1);


        swi = new JButton("↑↓");
        swi.setBounds(265,155,70,30);
        swi.setFont(new Font("Calibri", Font.BOLD, 15));
        swi.setFocusPainted(false);
        swi.addActionListener(this);
        p.add(swi);



        lb2 = new JLabel("Fahrenheit:");
        lb2.setBounds(150,195,90,25);
        lb2.setFont(new Font("Calibri", Font.BOLD, 17));

        t2 = new JTextArea();
        t2.setBounds(240,195,120,25);
        t2.setBorder(BorderFactory.createLineBorder(Color.black));
        t2.setFont(new Font("Calibri", Font.BOLD, 17));
        t2.setEditable(false);
        p.add(lb2);
        p.add(t2);

        submit = new JButton("Convert");
        submit.setBounds(230,240,100,40);
        submit.setFont(new Font("Calibri", Font.BOLD, 15));
        submit.setFocusPainted(false);
        submit.addActionListener(this);
        p.add(submit);

        t1.setForeground(Color.BLUE);
        t2.setForeground(Color.RED);
        t2.setBackground(Color.yellow);
        t1.setBackground(Color.yellow);
        frame.add(p);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(550,400);
        frame.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s=e.getActionCommand();
        if(s.equals("↑↓")){
            if(selected.equals("Fahrenheit:")){
                selected="Celsius:";
                lb1.setText(selected);
                lb2.setText("Fahrenheit:");
            }
            else {
                selected="Fahrenheit:";
                lb1.setText(selected);
                lb2.setText("Celsius:");
            }
        }
        if(s.equals("Convert")){
            float deg = Float.parseFloat(t1.getText());
            double ans = selected.equals("Celsius:") ? (deg* 1.8 )+32 : (double) (deg -32)*(5.0/9.0);
            char inner;
            if(selected.equals("Celsius:")){
                inner='F';
            }
            else {
                inner='C';
            }
            t2.setText(Double.toString((Math.round(ans * 10000.0) / 10000.0)) +" \u00B0"+inner);
        }

    }
}


public class TemperatureConverter {
    public static void main(String[] args) {
        new SwingTemperatureConverter();
    }
}
