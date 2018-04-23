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
import javax.swing.LayoutStyle.ComponentPlacement;

public class SeleniumHelperGUI {

	private JFrame frame;
	private JButton btnStart, btnClickOperation;
	private JTextField webLocatorTextField, codeSnipetTextField, urlTextField;
	private JRadioButton rdbtnXpath, rdbtnId, rdbtnName, rdbtnLinktext;
	private static SeleniumHelper seleniumHelper;
	private JTextArea resultTextArea;
	private ButtonGroup locatorButtonGroup, automationTypeButtonGroup;
	private JTextField appPackageTextField;
	private JTextField activityNameTextField;
	private JRadioButton rdbtnWeb;
	private JRadioButton rdbtnMobile;

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

		JPanel panel2 = new JPanel();
		panel2.setLayout(null);

		rdbtnXpath = new JRadioButton("XPath", true);
		rdbtnXpath.setBounds(6, 7, 65, 23);
		panel2.add(rdbtnXpath);

		rdbtnId = new JRadioButton("Id");
		rdbtnId.setBounds(73, 7, 46, 23);
		panel2.add(rdbtnId);

		rdbtnName = new JRadioButton("Name");
		rdbtnName.setBounds(121, 7, 58, 23);
		panel2.add(rdbtnName);

		rdbtnLinktext = new JRadioButton("LinkText");
		rdbtnLinktext.setBounds(181, 7, 88, 23);
		panel2.add(rdbtnLinktext);

		locatorButtonGroup = new ButtonGroup();
		locatorButtonGroup.add(rdbtnXpath);
		locatorButtonGroup.add(rdbtnId);
		locatorButtonGroup.add(rdbtnName);
		locatorButtonGroup.add(rdbtnLinktext);

		webLocatorTextField = new JTextField();
		webLocatorTextField.setBounds(16, 37, 253, 23);
		panel2.add(webLocatorTextField);
		webLocatorTextField.setColumns(10);

		JPanel panel3 = new JPanel();
		panel3.setLayout(null);

		btnClickOperation = new JButton("ClickOperation");
		btnClickOperation.setBounds(10, 11, 133, 23);
		panel3.add(btnClickOperation);

		resultTextArea = new JTextArea();
		resultTextArea.setBounds(10, 98, 176, 88);
		panel3.add(resultTextArea);
		resultTextArea.setLineWrap(true);
		resultTextArea.setWrapStyleWord(true);

		codeSnipetTextField = new JTextField();
		codeSnipetTextField.setColumns(10);

		JLabel lblCodeSnipet = new JLabel("Code snipet");

		JPanel panel1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(19)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 713, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
								.addGap(22)
								.addComponent(panel3, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(lblCodeSnipet, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addGap(10).addComponent(codeSnipetTextField, GroupLayout.PREFERRED_SIZE, 332,
										GroupLayout.PREFERRED_SIZE)))
				.addGap(30)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(6)
				.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(codeSnipetTextField, GroupLayout.PREFERRED_SIZE, 386,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(34, Short.MAX_VALUE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(4).addComponent(lblCodeSnipet,
										GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel3, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)))));
		panel1.setLayout(null);
		rdbtnWeb = new JRadioButton("Web", true);
		rdbtnWeb.setBounds(10, 7, 65, 23);
		panel1.add(rdbtnWeb);

		rdbtnMobile = new JRadioButton("Mobile");
		rdbtnMobile.setBounds(93, 7, 82, 23);
		panel1.add(rdbtnMobile);
		automationTypeButtonGroup = new ButtonGroup();
		automationTypeButtonGroup.add(rdbtnWeb);
		automationTypeButtonGroup.add(rdbtnMobile);

		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(10, 37, 46, 23);
		panel1.add(lblUrl);

		JLabel lblApppackage = new JLabel("AppPackage");
		lblApppackage.setBounds(10, 71, 73, 18);
		panel1.add(lblApppackage);

		urlTextField = new JTextField();
		urlTextField.setBounds(70, 37, 428, 22);
		panel1.add(urlTextField);
		urlTextField.setColumns(10);

		appPackageTextField = new JTextField();
		appPackageTextField.setBounds(106, 70, 186, 20);
		panel1.add(appPackageTextField);
		appPackageTextField.setColumns(10);

		JLabel lblActivityname = new JLabel("ActivityName");
		lblActivityname.setBounds(302, 73, 82, 14);
		panel1.add(lblActivityname);

		activityNameTextField = new JTextField();
		activityNameTextField.setBounds(394, 70, 207, 20);
		panel1.add(activityNameTextField);
		activityNameTextField.setColumns(10);

		btnStart = new JButton("Start");
		btnStart.setBounds(614, 37, 89, 23);
		panel1.add(btnStart);

		frame.getContentPane().setLayout(groupLayout);
	}

	public void startButtonEvent() {
		btnStart.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (rdbtnWeb.isSelected()) {
					String url = urlTextField.getText();
					if (url != null && url.length() > 1) {
						seleniumHelper = new SeleniumHelper(url);
					} else {
						seleniumHelper = new SeleniumHelper();
					}
				} else {
					String appActivity = activityNameTextField.getText();
					String appPackage = appPackageTextField.getText();
					seleniumHelper = new SeleniumHelper(appPackage, appActivity);

				}

			}
		});
	}

	public void clickOperationButtonEvent() {
		btnClickOperation.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String locatorValue = webLocatorTextField.getText();
				String locatorType = "";
				if (rdbtnXpath.isSelected()) {
					locatorType = "xpath";
				} else if (rdbtnId.isSelected()) {
					locatorType = "id";
				} else if (rdbtnName.isSelected()) {
					locatorType = "name";
				} else if (rdbtnLinktext.isSelected()) {
					locatorType = "linkText";
				}

				String message = seleniumHelper.click(locatorType, locatorValue);
				resultTextArea.append(message + "\n");
			}
		});
	}
}
