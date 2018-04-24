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
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

public class SeleniumHelperGUI {

	private JFrame frmAutomationHelper;
	private JButton btnStart, btnClickOperation;
	private JTextField webLocatorTextField, urlTextField,appPackageTextField,activityNameTextField;
	private JRadioButton rdbtnXpath, rdbtnId, rdbtnName, rdbtnLinktext,rdbtnWeb,rdbtnMobile;
	private static SeleniumHelper seleniumHelper;
	private ButtonGroup locatorButtonGroup, automationTypeButtonGroup;
	private JTextArea codeSnippetTextArea,resultTextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleniumHelperGUI window = new SeleniumHelperGUI();
					window.frmAutomationHelper.setVisible(true);
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
		frmAutomationHelper = new JFrame();
		frmAutomationHelper.setTitle("Automation Helper");
		frmAutomationHelper.setBounds(100, 100, 982, 576);
		frmAutomationHelper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel2 = new JPanel();
		panel2.setBounds(19, 121, 279, 110);
		panel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
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
		panel3.setBounds(19, 242, 198, 197);
		panel3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel3.setLayout(null);

		btnClickOperation = new JButton("ClickOperation");
		btnClickOperation.setBounds(10, 11, 133, 23);
		panel3.add(btnClickOperation);

		resultTextArea = new JTextArea();
		resultTextArea.setBounds(10, 98, 176, 88);
		resultTextArea.setBorder(new TitledBorder(null, "Output", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel3.add(resultTextArea);
		resultTextArea.setLineWrap(true);
		resultTextArea.setWrapStyleWord(true);

		JPanel panel1 = new JPanel();
		panel1.setBounds(19, 6, 713, 109);
		panel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel1.setLayout(null);
		rdbtnWeb = new JRadioButton("Web", true);
		rdbtnWeb.setBounds(10, 7, 65, 23);
		panel1.add(rdbtnWeb);

		rdbtnMobile = new JRadioButton("Mobile");
		rdbtnMobile.setBounds(93, 7, 82, 23);
		panel1.add(rdbtnMobile);
		automationTypeButtonGroup = new ButtonGroup();
		frmAutomationHelper.getContentPane().setLayout(null);
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
		frmAutomationHelper.getContentPane().add(panel1);
		frmAutomationHelper.getContentPane().add(panel2);
		frmAutomationHelper.getContentPane().add(panel3);
		
		codeSnippetTextArea = new JTextArea();
		codeSnippetTextArea.setBounds(600, 126, 323, 315);
		codeSnippetTextArea.setBackground(Color.WHITE);
		codeSnippetTextArea.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Code snippet", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frmAutomationHelper.getContentPane().add(codeSnippetTextArea);
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
					if(appActivity.length()<1 ||appPackage.length()<1) {
						
					}else {
						seleniumHelper = new SeleniumHelper(appPackage, appActivity);
					}
					

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
