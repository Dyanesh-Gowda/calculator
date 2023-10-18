package calci;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener {
	JTextField text;
	JButton addB, subB, mulB, divB, decB, delB, ClrB, equB,negB;
	JButton[] numberB = new JButton[10];
	JButton[] functionB = new JButton[9];
	Font myF = new Font("system", Font.BOLD, 30);
	double num1 = 0, num2 = 0, res = 0;
	char Operator;
	JPanel panel;

	public Calculator() {
		// TODO Auto-generated constructor stub
		getContentPane().setBackground(Color.white);
		setLayout(null);

		text = new JTextField();
		text.setBounds(50, 20, 380, 60);
		text.setFont(new Font("system", Font.BOLD, 30));
		text.setEditable(false);
		add(text);

		addB = new JButton("+");
		subB = new JButton("-");
		mulB = new JButton("*");
		divB = new JButton("/");
		decB = new JButton(".");
		equB = new JButton("=");
		delB = new JButton("<<<");
		ClrB = new JButton("Clear");
		negB=new JButton("-");

		functionB[0] = addB;
		functionB[1] = subB;
		functionB[2] = mulB;
		functionB[3] = divB;
		functionB[4] = decB;
		functionB[5] = equB;
		functionB[6] = delB;
		functionB[7] = ClrB;
		functionB[8] = negB;

		for (int i = 0; i < 9; i++) {
			functionB[i].addActionListener(this);
			functionB[i].setFont(myF);
			functionB[i].setFocusable(false);
		}
		for (int i = 0; i < 10; i++) {
			numberB[i] = new JButton(String.valueOf(i));
			numberB[i].addActionListener(this);
			numberB[i].setFont(myF);
			numberB[i].setFocusable(false);

		}
		negB.setBounds(20,450,100,30);
		add(negB);
		delB.setBounds(150, 450, 140, 30);
		add(delB);
		ClrB.setBounds(320, 450, 120, 30);
		add(ClrB);

		panel = new JPanel();
		panel.setBounds(90, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		panel.add(numberB[1]);
		panel.add(numberB[2]);
		panel.add(numberB[3]);
		panel.add(addB);
		panel.add(numberB[4]);
		panel.add(numberB[5]);
		panel.add(numberB[6]);
		panel.add(subB);
		panel.add(numberB[7]);
		panel.add(numberB[8]);
		panel.add(numberB[9]);
		panel.add(mulB);
		panel.add(decB);
		panel.add(numberB[0]);
		panel.add(equB);
		panel.add(divB);
		add(panel);

		setSize(500, 600);
//		setLocation(350,150);
		setLocationRelativeTo(null);
		setTitle("Calculator");
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 10; i++) {
			if (e.getSource() == numberB[i]) {
				text.setText(text.getText().concat(String.valueOf(i)));
			}
		}
		if (e.getSource() == decB) {
			text.setText(text.getText().concat("."));
		}
		if(e.getSource()==addB && text.getText().equals("")) {
			text.setText("0");
		}
		if (e.getSource() == addB) {
			num1 = Double.parseDouble(text.getText());
			Operator='+';
			text.setText("");
		}
		if(e.getSource()==subB && text.getText().equals("")) {
			text.setText("0");
		}
		if (e.getSource() == subB) {
			num1 = Double.parseDouble(text.getText());
			Operator='-';
			text.setText("");
		
		}if(e.getSource()==mulB && text.getText().equals("")) {
			text.setText("0");
			
		}if (e.getSource() == mulB) {
			num1 = Double.parseDouble(text.getText());
			Operator='*';
			text.setText("");
		
		}
		if(e.getSource()==divB && text.getText().equals("")) {
			text.setText("0");
		}
		
		
		
		if (e.getSource() == divB) {
			num1 = Double.parseDouble(text.getText());
			Operator='/';
			text.setText("");
		}
		if(e.getSource()==equB && text.getText().equals("")) {
			text.setText("0");
		}
	
		
		
		if (e.getSource() == equB) {
			num2 = Double.parseDouble(text.getText());
			switch(Operator) {
			case'+':
				res=num1+num2;
				break;
			case'-':
				res=num1-num2;
				break;
			case'*':
				res=num1*num2;
				break;
			case'/':
				res=num1/num2;
				break;
			}
			text.setText(String.valueOf(res));
			num1=res;
		}
		if(e.getSource()==ClrB) {
			text.setText("");
		}
		if(e.getSource()==delB) {
			String string=text.getText();
			text.setText("");
			for(int i=0;i<string.length()-1;i++) {
				text.setText(text.getText()+string.charAt(i));
			}
		}
		if(e.getSource()==negB) {
			double temp=Double.parseDouble(text.getText());
			temp*=-1;
		text.setText(String.valueOf(temp));
		}

	}

	public static void main(String[] args) {
		new Calculator();
	}

}
