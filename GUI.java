import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {
    public static final int DRAW_SIZE = 400;
    Calculator cal = new Calculator();
    JTextField panel1;

    public GUI(String title) {
        super(title);
        setSize(DRAW_SIZE, DRAW_SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel1 = new JTextField(25);
        panel1.addActionListener(this);
        panel1.setText("");
        JPanel pane = new JPanel();
        GridLayout panel2 = new GridLayout(4,4);
        JButton shape = new JButton("Shape");
        shape.addActionListener(this);
        JButton quit = new JButton("Quit");
        quit.addActionListener(this);
        pane.setLayout(panel2);
        JButton C = new JButton("C");
        JButton equal = new JButton("=");
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton divide = new JButton("/");
        JButton multiply = new JButton("*");
        JButton ln = new JButton("ln");
        JButton pow = new JButton("pow");
        JButton sqrt = new JButton("sqrt");
        JButton factorial = new JButton("!");
        JButton one = new JButton("1");
        JButton two = new JButton("2");
        JButton three = new JButton("3");
        JButton four = new JButton("4");
        JButton five = new JButton("5");
        JButton six = new JButton("6");
        JButton seven = new JButton("7");
        JButton eight = new JButton("8");
        JButton nine = new JButton("9");
        JButton zero = new JButton("0");
        C.setBackground(Color.RED);
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        zero.addActionListener(this);
        plus.addActionListener(this);
        minus.addActionListener(this);
        divide.addActionListener(this);
        multiply.addActionListener(this);
        equal.addActionListener(this);
        ln.addActionListener(this);
        pow.addActionListener(this);
        sqrt.addActionListener(this);
        C.addActionListener(this);
        factorial.addActionListener(this);
        equal.setBackground(Color.YELLOW);
        pane.add(zero);
        pane.add(one);
        pane.add(two);
        pane.add(three);
        pane.add(C);
        pane.add(four);
        pane.add(five);
        pane.add(six);
        pane.add(seven);
        pane.add(factorial);
        pane.add(eight);
        pane.add(nine);
        pane.add(plus);
        pane.add(minus);
        pane.add(multiply);
        pane.add(pow);
        pane.add(sqrt);
        pane.add(ln);
        pane.add(equal);
        pane.add(divide);
        this.add(panel1, BorderLayout.NORTH);
        this.add(pane);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if ((command == "0" || command == "1" || command == "2" || command == "3" || command == "4" || command == "5" || command == "6" || command == "7" || command == "8" || command == "9") && cal.getOp() == null) {
            cal.setFirst(command);
            panel1.setText(cal.getInter());
            cal.delOp();
        } else if ((command == "0" || command == "1" || command == "2" || command == "3" || command == "4" || command == "5" || command == "6" || command == "7" || command == "8" || command == "9") && (cal.getOp() == "+" || cal.getOp() == "-" || cal.getOp() == "/" || cal.getOp() == "*" || cal.getOp() == "pow")) {
            cal.setSecond(command);
            if (cal.getOp() == "pow") panel1.setText(cal.getFirst() + " ** " + cal.getInter());
            else panel1.setText(cal.getFirst() + " " + cal.getOp() + " " + cal.getInter());
        }
        if (command == "/") {
            cal.divide();
            cal.delInter();
            panel1.setText(cal.getFirst() + " " + command);
            cal.setTried(false);
        }
        if (command == "-" && cal.getTried() == true) {
            cal.subtract();
            cal.delInter();
            panel1.setText(cal.getFirst() + " " + command);
        }
        if (command == "-" && cal.getTried() == false && cal.getInter().equals("-") == false) {
            cal.setInter("-");
            panel1.setText(cal.getInter());
        }
        if (command == "-" && cal.getTried() == false && cal.getInter().equals("-") == false && (cal.getOp() == "*" || cal.getOp() == "/")) {
            cal.setInter("-");
            panel1.setText(cal.getInter());
        }
        if (command == "+") {
            cal.add();
            cal.delInter();
            panel1.setText(cal.getFirst() + " " + command);
        }
        if (command == "*") {
            cal.multiply();
            cal.delInter();
            panel1.setText(cal.getFirst() + " " + command);
            cal.setTried(false);
        }
        if (command == "pow") {
            cal.pow();
            cal.delInter();
            panel1.setText(cal.getFirst() + " " + "**");
        }
        if (command == "sqrt" ) {
            cal.rootSquare();
            cal.delInter();
            panel1.setText("sqrt(" + cal.getFirst() + ")");
        }
        if (command == "ln" ) {
            cal.nepLog();
            panel1.setText("ln(" + cal.getFirst() + ")");
        }
        if (command == "!") {
            cal.factorial();
            cal.delInter();
            panel1.setText(cal.getFirst() + command);
        }
        if (command == "=") {
            cal.compute();
            if (cal.getOp() == "sqrt") panel1.setText("sqrt(" + String.valueOf(cal.getFirst()) + ") = " + cal.getAnswer());
            else if (cal.getOp() == "ln") panel1.setText("ln(" + String.valueOf(cal.getFirst()) + ") = " + cal.getAnswer());
            else if(cal.getOp() == "!") panel1.setText(String.valueOf(cal.getFirst()) + "! = " + cal.getAnswer());
            else if(cal.getOp() == "pow") panel1.setText(String.valueOf(cal.getFirst()) + " ** " + String.valueOf(cal.getSecond()) + " = " + cal.getAnswer());
            else if(cal.getOp() == "+") panel1.setText(String.valueOf(cal.getFirst()) + " + " + String.valueOf(cal.getSecond()) + " = " + cal.getAnswer());
            else if(cal.getOp() == "-") panel1.setText(String.valueOf(cal.getFirst()) + " - " + String.valueOf(cal.getSecond()) + " = " + cal.getAnswer());
            else if(cal.getOp() == "/") panel1.setText(String.valueOf(cal.getFirst()) + " / " + String.valueOf(cal.getSecond()) + " = " + cal.getAnswer());
            else if(cal.getOp() == "*") panel1.setText(String.valueOf(cal.getFirst()) + " * " + String.valueOf(cal.getSecond()) + " = " + cal.getAnswer());
            cal.setRemember(true);
            cal.setTried(false);
            cal.delInter();
            cal.setFirst(cal.getAnswer());
        }
        if (command == "C") {
            cal.delOp();
            panel1.setText("");
            cal.delInter();
            cal.setFirst(0);
            cal.setSecond(0);
            cal.setRemember(false);
            cal.setTried(false);
        }
    }
    public static void main(String[] args) {
        GUI f;
        f = new GUI("CALCULATOR");
    }
}
