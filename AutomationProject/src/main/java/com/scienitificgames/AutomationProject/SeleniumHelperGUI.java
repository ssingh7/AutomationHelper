package com.scienitificgames.AutomationProject;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class SeleniumHelperGUI {

	private JFrame frame;
	private JButton btnStart, btnClickOperation;
	private JTextField webLocatorTextField, codeSnipetTextField, urlTextField;
	private JRadioButton rdbtnXpath, rdbtnId, rdbtnName, rdbtnLinktext;
	private static SeleniumHelper seleniumHelper;
	private JTextArea resultTextArea;
	private ButtonGroup buttonGroup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleniumHelperGUI window = new SeleniumHelperGUI();
					window.frame.setVisible(true);
					window.startButtonEvent();
					window.clickOperationButtonEvent();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SeleniumHelperGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 982, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnStart = new JButton("Start");

		JLabel lblUrl = new JLabel("URL");

		JPanel panel = new JPanel();
		panel.setLayout(null);

		rdbtnXpath = new JRadioButton("XPath",true);
		rdbtnXpath.setBounds(6, 7, 65, 23);
		panel.add(rdbtnXpath);

		rdbtnId = new JRadioButton("Id");
		rdbtnId.setBounds(73, 7, 46, 23);
		panel.add(rdbtnId);

		rdbtnName = new JRadioButton("Name");
		rdbtnName.setBounds(121, 7, 58, 23);
		panel.add(rdbtnName);

		rdbtnLinktext = new JRadioButton("LinkText");
		rdbtnLinktext.setBounds(181, 7, 88, 23);
		panel.add(rdbtnLinktext);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnXpath);
		buttonGroup.add(rdbtnId);
		buttonGroup.add(rdbtnName);
		buttonGroup.add(rdbtnLinktext);

		webLocatorTextField = new JTextField();
		webLocatorTextField.setBounds(16, 37, 253, 23);
		panel.add(webLocatorTextField);
		webLocatorTextField.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);

		btnClickOperation = new JButton("ClickOperation");
		btnClickOperation.setBounds(10, 11, 133, 23);
		panel_1.add(btnClickOperation);
		
		resultTextArea = new JTextArea();
		resultTextArea.setBounds(10, 98, 176, 88);
		panel_1.add(resultTextArea);
		resultTextArea.setLineWrap(true);
		resultTextArea.setWrapStyleWord(true);

		codeSnipetTextField = new JTextField();
		codeSnipetTextField.setColumns(10);

		JLabel lblCodeSnipet = new JLabel("Code snipet");

		urlTextField = new JTextField();
		urlTextField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUrl, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(36)
									.addComponent(urlTextField, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)))
							.addGap(81)
							.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
							.addGap(22)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblCodeSnipet, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(codeSnipetTextField, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUrl, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(urlTextField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnStart))
					.addGap(90)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblCodeSnipet, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(codeSnipetTextField, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	public void startButtonEvent() {
		btnStart.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String url = urlTextField.getText();
				if (url != null && url.length()>1) {
					seleniumHelper = new SeleniumHelper(url);
				} else {
					seleniumHelper = new SeleniumHelper();
				}

			}
		});
	}

	public void clickOperationButtonEvent() {
		btnClickOperation.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String locatorValue = webLocatorTextField.getText();
				String locatorType="";
				if(rdbtnXpath.isSelected()) {
					locatorType = "xpath";
				}else if(rdbtnId.isSelected()){
					locatorType = "id";
				}else if(rdbtnName.isSelected()){
					locatorType = "name";
				}else if(rdbtnLinktext.isSelected()){
					locatorType = "linkText";
				}

				String message = seleniumHelper.click(locatorType, locatorValue);
				resultTextArea.append(message+"\n");
			}
		});
	}
}
