package assignment;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

public class FileGUI extends FileProcessing implements ActionListener{
	
	JButton button1, button2,button3,button4,button5;
	JTextField Comparison, Stop;
	JPanel panel1,panel2,panel3,panel4,panel5;
	JFrame frame1;
	File readingFile, readingFile1;
	JFileChooser choosingFile;
	JFileChooser choosingFile1 = new JFileChooser();
	int i;
	
	public FileGUI(String title)  
	{
	super (title);
	
	frame1= new JFrame("The File GUI");
	
	frame1.setVisible(true);
	frame1.setSize(350,350);
	frame1.setLayout(new FlowLayout());
	frame1.getContentPane().setBackground(Color.YELLOW);
	
	JPanel panel1 = new JPanel();
	frame1.add(panel1);
	
	JPanel panel2 = new JPanel();
	frame1.add(panel2);
	
	JPanel panel3 = new JPanel();
	frame1.add(panel3);
	Stop = new JTextField("Add stop number");
	panel3.add(Stop);
	
	JPanel panel4 = new JPanel();
	frame1.add(panel4);
	Comparison = new JTextField("Number of words to compare");
	panel4.add(Comparison);
	
	JPanel panel5 = new JPanel();
	frame1.add(panel5);
	
	button1 = new JButton();
	panel1.add(button1);
	button1.setText("Select a File");
	button1.setToolTipText("Click to select");
	button1.addActionListener(this);
	
	
	button2 = new JButton();
	panel2.add(button2);
	button2.setText("Select another file");
	button2.setToolTipText("Click to select");
	button2.addActionListener(this);
	
	button3 = new JButton();
	panel3.add(button3);
	button3.setText("Add stop word");
	button3.setToolTipText("Press for word inputted to register");
	button3.addActionListener(this);
	
	button4 = new JButton();
	panel4.add(button4);
	button4.setText("Enter");
	button4.setToolTipText("Click to compare the two files selected");
	button4.addActionListener(this);
	
	button5 = new JButton();
	panel5.add(button5);
	button5.setText("Compare");
	button5.setToolTipText("Click to compare the two files selected");
	button5.addActionListener(this);
	
	}

	public void actionPerformed(ActionEvent e) {
		
		
		JFileChooser choosingFile = new JFileChooser();
		JFileChooser choosingFile1 = new JFileChooser();
		int choose;
		int choose1;
		String fname;
		String fname1;
		float relation;
		
		
		if(e.getSource() == button1)
		{
           
             choose = choosingFile.showOpenDialog(null);

       
            if(choose == JFileChooser.APPROVE_OPTION)
            {
                readingFile = new File(choosingFile.getSelectedFile().getAbsolutePath());

                Filename = readingFile.getAbsolutePath();
            }
            
		}
		
		else if (e.getSource() == button2)
		{

            choose1 = choosingFile1.showOpenDialog(null);

            if(choose1 == JFileChooser.APPROVE_OPTION)
            {
                readingFile1 = new File(choosingFile1.getSelectedFile().getAbsolutePath());

                Filename = readingFile1.getAbsolutePath();
            }
 
		}
		
		
		else if (e.getSource() == button3)
		{
			
			stopList.add(Stop.getText());
		}
		
		else if (e.getSource() == button4)
		{
			
			i = Integer.parseInt(Comparison.getText());
		}
		
		else if (e.getSource() == button5)
		{
			
			
			fname = readingFile.getAbsolutePath();;
			fname1 = readingFile1.getAbsolutePath();
			
			
			FileProcessing file1 = new FileProcessing(fname);
			FileProcessing file2 = new FileProcessing(fname1);
			
			file1.readFile(fname1,i);
			file2.readFile(fname, i);
			
		
			relation = tally*100/Temporary.size();
			System.out.println(relation);
            
		
			if(relation == 100.0)
           {
               JOptionPane.showMessageDialog(null,"The two files being compared are identical");
           }
           else if(relation > 70.0)
           {
               JOptionPane.showMessageDialog(null,"The two files being compared are very similar and most likely is about the same topic");
           }
           
           else if(relation < 25.0)
           {
               JOptionPane.showMessageDialog(null,"The two files don't have much in common and not likely to be about the same topic");
           }
           
           else if(relation == 0.0)
           {
               JOptionPane.showMessageDialog(null,"The two files share nothing in common");
           }
           
