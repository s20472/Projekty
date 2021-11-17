import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import javax.swing.JLabel;

public class Gui
{
	LanguageService lang;
	private JFrame frame;
	private JTextField InputContent;

	/**
	 * Launch the application.
	 */
	public void show() 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() 
	{
		lang = new LanguageService();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 496, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		InputContent = new JTextField();
		InputContent.setBounds(10, 70, 460, 61);
		frame.getContentPane().add(InputContent);
		InputContent.setColumns(10);
		
		JLabel LabelInput = new JLabel("Input:");
		LabelInput.setBounds(10, 45, 46, 14);
		frame.getContentPane().add(LabelInput);
		
		JLabel LabelOutupt = new JLabel("Output");
		LabelOutupt.setBounds(10, 142, 46, 14);
		frame.getContentPane().add(LabelOutupt);
		
		JLabel OutputContent = new JLabel("");
		OutputContent.setBounds(10, 167, 460, 84);
		frame.getContentPane().add(OutputContent);
		
		JButton TestTrainSet = new JButton("Test Test Set");
		TestTrainSet.setBounds(68, 11, 155, 23);
		frame.getContentPane().add(TestTrainSet);
		TestTrainSet.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
						OutputContent.setText(lang.testFile());
					}
				}
				);
		
		JButton TestInput = new JButton("Test Custom Input");
		TestInput.setBounds(267, 11, 155, 23);
		frame.getContentPane().add(TestInput);
		TestInput.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				OutputContent.setText(lang.determineLanguage(InputContent.getText()));
			}
		}
		);
	}
}
