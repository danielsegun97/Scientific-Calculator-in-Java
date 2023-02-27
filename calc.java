package CSIT211Final;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Font;

public class calc extends JFrame implements ActionListener {

	private JFrame frmStandardCalculator;
	private JTextField textField;

	/**
	 * Launch the application.
	 * Project by Daniel Onitilo and Mimi Ogunyemi
	 * Scientific Calculator
	 */
	double firstnum,secondnum,result;
	String operations, answer;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calc window = new calc();
					window.frmStandardCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				calc f = new calc();
				f.setTitle("ScientificCalculator");
				f.pack();
				f.setVisible(true);
			}
		});
	}

	/**
	 * Create the application.
	 */
	public calc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStandardCalculator = new JFrame();
		frmStandardCalculator.setTitle("Standard Calculator"); //calculator frame
		frmStandardCalculator.setBounds(100, 100, 378, 502);
		frmStandardCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar txtDisplay = new JMenuBar();
		frmStandardCalculator.setJMenuBar(txtDisplay);
		
		JMenu mnFile = new JMenu("File");
		txtDisplay.add(mnFile);
		
		JMenuItem mntmStandard = new JMenuItem("Standard");
		mntmStandard.addActionListener(new ActionListener() { //frame for standard calculator
			public void actionPerformed(ActionEvent e) {
				frmStandardCalculator.setTitle("Standard Calculator");
				frmStandardCalculator.setBounds(100, 100, 446, 502);
				txtDisplay.setBounds(10, 11, 243, 37);
			}
		});
		mnFile.add(mntmStandard);
		
		JMenuItem mntmScientific = new JMenuItem("Scientific");
		mntmScientific.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //frame for the scientific calculator
				frmStandardCalculator.setTitle("Scientific Calculator");
				frmStandardCalculator.setBounds(100, 100, 700, 502);
				txtDisplay.setBounds(10, 11, 243, 37);
			}
		});
		mnFile.add(mntmScientific);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStandardCalculator.setTitle("Exit");
				System.exit(0);
				frmStandardCalculator.setBounds(100, 100, 446, 502);
				txtDisplay.setBounds(10, 11, 243, 37);
			}
		});
		mnFile.add(mntmExit);
		frmStandardCalculator.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 412, 76);
		frmStandardCalculator.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnback = new JButton("\u2190");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String backspace=null;
				if(textField.getText().length()>0) { //function for the backspace button
					StringBuilder strB = new StringBuilder(textField.getText());
					strB.deleteCharAt(textField.getText().length()-1);
					backspace=strB.toString();
					textField.setText(backspace);
				}
			}
		});
		btnback.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnback.setBounds(0, 107, 74, 65);
		frmStandardCalculator.getContentPane().add(btnback);
		
	
		
		JButton btnC_1 = new JButton("C");
		btnC_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			} //fucntion for the clear button
		});
		btnC_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnC_1.setBounds(146, 107, 74, 65);
		frmStandardCalculator.getContentPane().add(btnC_1);
		
		JButton btnplusminus = new JButton("\u00B1");
		btnplusminus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//function for the plusminus button
				double ops= Double.parseDouble((String.valueOf(textField.getText())));
				ops=ops*(-1);
				textField.setText(String.valueOf(ops));
			}
		});
		btnplusminus.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnplusminus.setBounds(217, 107, 74, 65);
		frmStandardCalculator.getContentPane().add(btnplusminus);
		
		JButton btnsqrRoot = new JButton("\u221A");
		btnsqrRoot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double ops= Double.parseDouble((String.valueOf(textField.getText())));
					ops=Math.sqrt(ops); //function for the sqrt button
					textField.setText(String.valueOf(ops));
				}catch (Exception eg) {
					textField.setText("Invalid entry");
				}
				
			}
		});
		btnsqrRoot.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnsqrRoot.setBounds(288, 107, 74, 65);
		frmStandardCalculator.getContentPane().add(btnsqrRoot);
		
		JButton btnLog = new JButton("Log");
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//function for the log button
				double ops= Double.parseDouble((String.valueOf(textField.getText())));
				ops=Math.log(ops);
				textField.setText(String.valueOf(ops));
			}
		});
		btnLog.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLog.setBounds(398, 107, 74, 65);
		frmStandardCalculator.getContentPane().add(btnLog);
		
		JButton btnSin = new JButton("Sin");
		btnSin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { //function for the sine button
					double ops= Double.parseDouble((String.valueOf(textField.getText())));
					ops=Math.sin(ops);
					textField.setText(String.valueOf(ops));

				}catch(Exception f) {
					textField.setText("Enter in a valid input");
				}
			}
		});
		btnSin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSin.setBounds(470, 107, 74, 65);
		frmStandardCalculator.getContentPane().add(btnSin);
		
		JButton btnSinh = new JButton("Sinh");
		btnSinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {          //function for the sineh button
					double ops= Double.parseDouble((String.valueOf(textField.getText())));
					ops=Math.sinh(ops);
					textField.setText(String.valueOf(ops));

				}catch(Exception f) {
					textField.setText("Enter in a valid input");
				}
			}
		});
		btnSinh.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSinh.setBounds(542, 107, 74, 65);
		frmStandardCalculator.getContentPane().add(btnSinh);
		
		JButton btn7 = new JButton("7");
		btn7.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  //function for the 7 button
				String iNum=textField.getText()+btn7.getText();
				textField.setText(iNum);
			}
		});
		btn7.setBounds(0, 170, 74, 65);
		frmStandardCalculator.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //function for the 8 button
				
				String iNum=textField.getText()+btn8.getText();
				textField.setText(iNum);
			}
		});
		btn8.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn8.setBounds(70, 170, 74, 65);
		frmStandardCalculator.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //function for the 9 button
				
				String iNum=textField.getText()+btn9.getText();
				textField.setText(iNum);
			}
		});
		btn9.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn9.setBounds(146, 170, 74, 65);
		frmStandardCalculator.getContentPane().add(btn9);
		
		JButton button_10 = new JButton("/");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				                                    //function for the division button
				firstnum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "/";
			}
		});
		button_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_10.setBounds(217, 170, 74, 65);
		frmStandardCalculator.getContentPane().add(button_10);
		
		JButton btnpi = new JButton("\u03C0");
		btnpi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//function for the pi button
				double ops;
				ops = 3.1415926535897932384626433832795;
				textField.setText(String.valueOf(ops));
			}
		});
		btnpi.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnpi.setBounds(398, 170, 74, 65);
		frmStandardCalculator.getContentPane().add(btnpi);
		
		JButton btnCos = new JButton("Cos");
		btnCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {              //function for the cos button
					double ops= Double.parseDouble((String.valueOf(textField.getText())));
					ops=Math.cos(ops);
					textField.setText(String.valueOf(ops));

				}catch(Exception f) {
					textField.setText("Enter in a valid input");
				}
			}
		});
		btnCos.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCos.setBounds(470, 170, 74, 65);
		frmStandardCalculator.getContentPane().add(btnCos);
		
		JButton btnCosh = new JButton("Cosh");
		btnCosh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {                              //function for the cosh button
					double ops= Double.parseDouble((String.valueOf(textField.getText())));
					ops=Math.cosh(ops);
					textField.setText(String.valueOf(ops));

				}catch(Exception f) {
					textField.setText("Enter in a valid input");
				}
			}
		});
		btnCosh.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCosh.setBounds(542, 170, 74, 65);
		frmStandardCalculator.getContentPane().add(btnCosh);
		
		JButton btnLnx = new JButton("ln(x)");
		btnLnx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {                      //function for the ln(x) button
					double ops= Double.parseDouble((String.valueOf(textField.getText())));
					ops=Math.log10(ops);
					textField.setText(String.valueOf(ops));

				}catch(Exception f) {
					textField.setText("Enter in a valid input");
				}
				
			}
		});
		btnLnx.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLnx.setBounds(606, 170, 84, 65);
		frmStandardCalculator.getContentPane().add(btnLnx);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//function for the 4 button
				String iNum=textField.getText()+btn4.getText();
				textField.setText(iNum);
			}
		});
		btn4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn4.setBounds(0, 231, 74, 65);
		frmStandardCalculator.getContentPane().add(btn4);
		
		JButton btn5 = new JButton("5"); 
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//function for the 5 button
				String iNum=textField.getText()+btn5.getText();
				textField.setText(iNum);
			}
		});
		btn5.setFont(new Font("Cambria Math", Font.BOLD, 12));
		btn5.setBounds(70, 231, 74, 65);
		frmStandardCalculator.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //function for the 6 button
				
				String iNum=textField.getText()+btn6.getText();
				textField.setText(iNum);
			}
		});
		btn6.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn6.setBounds(146, 231, 74, 65);
		frmStandardCalculator.getContentPane().add(btn6);
		
		JButton btnmultip = new JButton("\u00D7");
		btnmultip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //function for the multip button
				
				firstnum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "�";
			}
		});
		btnmultip.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnmultip.setBounds(217, 231, 74, 65);
		frmStandardCalculator.getContentPane().add(btnmultip);
		
		JButton btnpower = new JButton("x^y");
		btnpower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {               //function for the power button
					double ops= Double.parseDouble((String.valueOf(textField.getText())));
					ops=Math.pow(ops,ops);
					textField.setText(String.valueOf(ops));
				}catch(Exception f) {
					textField.setText("Enter in a number first");
				}
				

				
			}
		});
		btnpower.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnpower.setBounds(398, 231, 74, 65);
		frmStandardCalculator.getContentPane().add(btnpower);
		
		JButton btnTan = new JButton("Tan");
		btnTan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {                                                  //function for the tan button
					double ops= Double.parseDouble((String.valueOf(textField.getText())));
					ops=Math.tan(ops);
					textField.setText(String.valueOf(ops));

				}catch(Exception f) {
					textField.setText("Enter in a valid input");
				}
			}
		});
		btnTan.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTan.setBounds(470, 231, 74, 65);
		frmStandardCalculator.getContentPane().add(btnTan);
		
		JButton btnTanh = new JButton("Tanh");
		btnTanh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {                                    //function for the tanh button
					double ops= Double.parseDouble((String.valueOf(textField.getText())));
					ops=Math.tanh(ops);
					textField.setText(String.valueOf(ops));

				}catch(Exception f) {
					textField.setText("Enter in a valid input");
				}
				
							}
		});
		btnTanh.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTanh.setBounds(542, 231, 74, 65);
		frmStandardCalculator.getContentPane().add(btnTanh);
		
		JButton btnC = new JButton("Exp");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					firstnum = Double.parseDouble(textField.getText());
					textField.setText("");
					operations = "Exp";  //function for the exponent button

				}catch(Exception f) {
					textField.setText("Enter in a valid input");
				}	
				
			}
		});
		btnC.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnC.setBounds(606, 231, 84, 65);
		frmStandardCalculator.getContentPane().add(btnC);
		
		JButton btnMod = new JButton("Mod");
		btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {                   //function for the mod button
					firstnum = Double.parseDouble(textField.getText());
					textField.setText("");
					operations = "Mod";

				}catch(Exception f) {
					textField.setText("Enter in a valid input");
				}
				
			}
		});
		btnMod.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMod.setBounds(606, 107, 84, 65);
		frmStandardCalculator.getContentPane().add(btnMod);
		
		JButton btnpercent = new JButton("%");
		btnpercent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//function for the % button
				firstnum = Double.parseDouble(textField.getText());
				firstnum=firstnum/100;
				textField.setText(Double.toString(firstnum));
				operations = "%";
			}
		});
		btnpercent.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnpercent.setBounds(288, 170, 74, 65);
		frmStandardCalculator.getContentPane().add(btnpercent);
		
		JButton btnfract = new JButton("1/x");
		btnfract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {    //function for the 1/x button
					firstnum = Double.parseDouble(textField.getText());
					firstnum=1/firstnum;
					textField.setText(Double.toString(firstnum));
				}catch(Exception r) {
					textField.setText("Enter in a number ");
				}
				
				
			}
		});
		btnfract.setFont(new Font("Cambria Math", Font.BOLD, 12));
		btnfract.setBounds(288, 231, 74, 65);
		frmStandardCalculator.getContentPane().add(btnfract);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {   //function for the 1 button
				
				String iNum=textField.getText()+btn1.getText();
				textField.setText(iNum);
			}
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn1.setBounds(0, 295, 74, 65);
		frmStandardCalculator.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  //function for the 2 button
				
				String iNum=textField.getText()+btn2.getText();
				textField.setText(iNum);
			}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn2.setBounds(70, 295, 74, 65);
		frmStandardCalculator.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {   //function for the 3 button
				
				String iNum=textField.getText()+btn3.getText();
				textField.setText(iNum);
			}
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn3.setBounds(146, 295, 74, 65);
		frmStandardCalculator.getContentPane().add(btn3);
		
		JButton btnminus = new JButton("-");
		btnminus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  //function for the minus button
				
				firstnum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "-";
			}
		});
		btnminus.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnminus.setBounds(217, 295, 74, 65);
		frmStandardCalculator.getContentPane().add(btnminus);
		
		JButton btneql = new JButton("=");
		btneql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  //the if statements detail the various functions of the = button
				try {
					String answer;
					secondnum = Double.parseDouble(textField.getText());
					if (operations=="+") {
						result=firstnum+secondnum; //function for plus
						answer = String.format("%.2f",result );
						textField.setText(answer);
					} 
					else if (operations=="-") {
						result=firstnum-secondnum;
						answer = String.format("%.2f",result ); //function for the minus button
						textField.setText(answer);
						}
					else if (operations=="�") {
						result=firstnum*secondnum;
						answer = String.format("%.2f",result ); //function for the multiplication button
						textField.setText(answer);
						}
					
					else if (operations=="/") {
						result=firstnum/secondnum;
						answer = String.format("%.2f",result ); //function for the division button
						textField.setText(answer);
						}
					else if (operations=="Mod") {
						result=firstnum%secondnum;
						answer = String.format("%.2f",result ); //function for the modulus button
						textField.setText(answer);
						}
					else if (operations=="Exp") {
						result=Math.pow(firstnum, secondnum); //function for the Exp button
						answer = String.format("%.2f",result );
						textField.setText(answer);
						}
				} catch (Exception eh) {
					textField.setText("Invalid entry");
				}
				
			}
		});
		btneql.setFont(new Font("Tahoma", Font.BOLD, 11));
		btneql.setBounds(288, 295, 74, 137);
		frmStandardCalculator.getContentPane().add(btneql);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //function for the 0 button
				
				String iNum=textField.getText()+btn0.getText();
				textField.setText(iNum);
			}
		});
		btn0.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn0.setBounds(0, 367, 144, 65);
		frmStandardCalculator.getContentPane().add(btn0);
		
		JButton btndot = new JButton(".");
		btndot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  //function for the decimal button
				textField.setText(textField.getText() + ".");
			}
		});
		btndot.setFont(new Font("Tahoma", Font.BOLD, 11));
		btndot.setBounds(146, 367, 74, 65);
		frmStandardCalculator.getContentPane().add(btndot);
		
		JButton btnplus = new JButton("+");
		btnplus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //function for the plus button
				
				firstnum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "+";
			}
		});
		btnplus.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnplus.setBounds(217, 367, 74, 65);
		frmStandardCalculator.getContentPane().add(btnplus);
		
		JButton btnsquare = new JButton("x^2");
		btnsquare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					double ops= Double.parseDouble((String.valueOf(textField.getText())));
					ops=(ops*ops);
					textField.setText(String.valueOf(ops));  //function for the square button
				}catch(Exception f) {
					textField.setText("Enter in a number first");
				}
				
				
			}
		});
		btnsquare.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnsquare.setBounds(398, 295, 74, 65);
		frmStandardCalculator.getContentPane().add(btnsquare);
		
		JButton btnCbr = new JButton("Cbroot");
		btnCbr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {                                                        //function for the cbroot button
				double ops= Double.parseDouble((String.valueOf(textField.getText())));
				ops=Math.cbrt(ops);
				textField.setText(String.valueOf(ops));
			}catch(Exception f) {
				textField.setText("Enter in a number first");
			}
			}
		});
		btnCbr.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCbr.setBounds(470, 295, 74, 65);
		frmStandardCalculator.getContentPane().add(btnCbr);
		
		JButton btnRund = new JButton("Rund");
		btnRund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					double ops= Double.parseDouble((String.valueOf(textField.getText()))); //function for the approximation button
					ops=Math.round(ops);
					textField.setText(String.valueOf(ops));
				}catch (Exception jr) {
					textField.setText("Invalid entry");
				}

			}
		});
		btnRund.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRund.setBounds(542, 295, 74, 65);
		frmStandardCalculator.getContentPane().add(btnRund);
		
		JButton button_38 = new JButton("2*\u03C0");
		button_38.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops;  //function for the 2pi button
				ops = 3.1415926535897932384626433832795*2;
				textField.setText(String.valueOf(ops));
			}
		});
		button_38.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_38.setBounds(606, 295, 84, 65);
		frmStandardCalculator.getContentPane().add(button_38);
		
		JButton btncube = new JButton("x^3");
		btncube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {  //function for the cube button
					double ops= Double.parseDouble((String.valueOf(textField.getText())));
					ops=(ops*ops*ops);
					textField.setText(String.valueOf(ops));
				}catch(Exception f) {
					textField.setText("Enter in a number first");
				}
				
			}
		});
		btncube.setFont(new Font("Cambria Math", Font.BOLD, 12));
		btncube.setBounds(398, 367, 74, 65);
		frmStandardCalculator.getContentPane().add(btncube);
		
		JButton btnBin = new JButton("Bin");
		btnBin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int a= Integer.parseInt((String.valueOf(textField.getText()))); //function for the binary button
	
					textField.setText(Integer.toString(a,2));
					
				} catch (Exception xe) {
					textField.setText("Cannot convert non-integers to binary");	
				}
				
				
			}
		});
		btnBin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBin.setBounds(470, 367, 74, 65);
		frmStandardCalculator.getContentPane().add(btnBin);
		
		JButton btnHex = new JButton("Hex");
		btnHex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {

						int a= Integer.parseInt((String.valueOf(textField.getText()))); //function for the hexadecimal button
						
						textField.setText(Integer.toString(a,16));
					
				} catch (Exception xe) {
					textField.setText("Cannot convert non-integers to hexadecimals");	
				}
				
				
			}
		});
		btnHex.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnHex.setBounds(542, 367, 74, 65);
		frmStandardCalculator.getContentPane().add(btnHex);
		
		JButton btnOctal = new JButton("Octal");
		btnOctal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {                                            //function for the octal button
					int a= Integer.parseInt((String.valueOf(textField.getText())));
					
					textField.setText(Integer.toString(a,8));
					
				} catch (Exception je) {
					textField.setText("Cannot convert non-integers to octadecimals");
				}
				
				
			}
		});
		btnOctal.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOctal.setBounds(616, 367, 74, 65);
		frmStandardCalculator.getContentPane().add(btnOctal);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub //action performed method
		
	}
}
