package com.scienitificgames.AutomationProject;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;

public class SeleniumHelperGUI {

	private JFrame frmAutomationHelper;
	private JButton btnStart, btnClickOperation, btnSendkeysoperation, selectOperationButton, waitButton, btnHighlight,btnReset,
			btnRun, btnStop;
	private JTextField webLocatorTextField, urlTextField, appPackageTextField, activityNameTextField, sendKeysTextField,
			selectOperationTextField, waitTextField;
	private JRadioButton rdbtnXpath, rdbtnId, rdbtnName, rdbtnLinktext, rdbtnWeb, rdbtnMobile, rdbtnRecordingOn;
	private static SeleniumHelper seleniumHelper;
	private ButtonGroup locatorButtonGroup, automationTypeButtonGroup;
	private JTextArea codeSnippetTextArea, resultTextArea;
	private JComboBox browserComboBox;
	private static ArrayList<String> executionSteps;

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
					window.stopButtonEvent();
					window.clickOperationButtonEvent();
					window.sendKeysButtonEvent();
					window.highlightEvent();
					window.selectOperationButtonEvent();
					window.waitButtonEvent();
					window.runButtonEvent();
					window.resetButtonEvent();

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
		executionSteps = new ArrayList<String>();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAutomationHelper = new JFrame();
		frmAutomationHelper.setAlwaysOnTop(true);
		frmAutomationHelper.setBackground(Color.LIGHT_GRAY);
		frmAutomationHelper.setTitle("Automation Helper");
		frmAutomationHelper.setBounds(100, 100, 982, 576);
		frmAutomationHelper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel2 = new JPanel();
		panel2.setBounds(19, 121, 279, 78);
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
		panel3.setBounds(19, 207, 494, 284);
		panel3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel3.setLayout(null);

		btnClickOperation = new JButton("ClickOperation");
		btnClickOperation.setBounds(10, 11, 133, 23);
		panel3.add(btnClickOperation);

		resultTextArea = new JTextArea();
		resultTextArea.setBounds(294, 11, 195, 125);
		resultTextArea.setBorder(new TitledBorder(null, "Output", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel3.add(resultTextArea);
		resultTextArea.setLineWrap(true);
		resultTextArea.setWrapStyleWord(true);

		JPanel panel1 = new JPanel();
		panel1.setBounds(19, 6, 713, 109);
		panel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel1.setLayout(null);
		rdbtnWeb = new JRadioButton("Web");
		rdbtnWeb.setBounds(10, 7, 65, 23);
		panel1.add(rdbtnWeb);

		rdbtnMobile = new JRadioButton("Mobile");
		rdbtnMobile.setBounds(210, 7, 82, 23);
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

		btnStop = new JButton("Stop");
		btnStop.setBounds(614, 69, 89, 23);
		panel1.add(btnStop);
		
		browserComboBox = new JComboBox();
		browserComboBox.setBounds(81, 8, 81, 20);
		browserComboBox.addItem("Chrome");
		browserComboBox.addItem("IE");
		browserComboBox.addItem("Firefox");
		panel1.add(browserComboBox);
		browserComboBox.setAutoscrolls(true);

		
		frmAutomationHelper.getContentPane().add(panel2);
		frmAutomationHelper.getContentPane().add(panel3);

		btnSendkeysoperation = new JButton("SendKeys");

		btnSendkeysoperation.setBounds(10, 45, 133, 23);
		panel3.add(btnSendkeysoperation);

		selectOperationButton = new JButton("SelectOperation");
		selectOperationButton.setBounds(10, 79, 133, 23);
		panel3.add(selectOperationButton);

		sendKeysTextField = new JTextField();
		sendKeysTextField.setBounds(151, 46, 133, 22);
		panel3.add(sendKeysTextField);
		sendKeysTextField.setColumns(10);

		selectOperationTextField = new JTextField();

		selectOperationTextField.setBounds(153, 80, 131, 20);
		panel3.add(selectOperationTextField);
		selectOperationTextField.setColumns(10);

		waitButton = new JButton("Wait");

		waitButton.setBounds(10, 113, 133, 23);
		panel3.add(waitButton);

		waitTextField = new JTextField();
		waitTextField.setBounds(151, 114, 133, 22);
		panel3.add(waitTextField);
		waitTextField.setColumns(10);

		btnHighlight = new JButton("Highlight");

		btnHighlight.setBounds(153, 11, 89, 23);
		panel3.add(btnHighlight);

		JPanel panel = new JPanel();
		panel.setBounds(518, 126, 438, 365);
		frmAutomationHelper.getContentPane().add(panel);
		panel.setLayout(null);

		codeSnippetTextArea = new JTextArea();
		codeSnippetTextArea.setBounds(10, 56, 328, 298);
		panel.add(codeSnippetTextArea);
		codeSnippetTextArea.setBackground(Color.WHITE);
		codeSnippetTextArea.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Code snippet",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));

		rdbtnRecordingOn = new JRadioButton("Recording On");
		rdbtnRecordingOn.setBounds(6, 7, 109, 23);
		panel.add(rdbtnRecordingOn);

		btnRun = new JButton("Run");
		btnRun.setBounds(121, 7, 89, 23);
		panel.add(btnRun);
		
		btnReset = new JButton("Reset");

		btnReset.setBounds(220, 7, 89, 23);
		panel.add(btnReset);
	}

	public void startButtonEvent() {
		btnStart.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Object browser = browserComboBox.getSelectedItem();
				if (rdbtnWeb.isSelected()) {
					String url = urlTextField.getText();
					if (url != null && url.length() > 1) {
						seleniumHelper = new SeleniumHelper(browser,url);
					} else {
						seleniumHelper = new SeleniumHelper(browser);
					}
				} else {
					String appActivity = activityNameTextField.getText();
					String appPackage = appPackageTextField.getText();
					if (appActivity.length() < 1 || appPackage.length() < 1) {

					} else {
						seleniumHelper = new SeleniumHelper(appPackage, appActivity);
					}

				}

			}
		});
	}

	public void stopButtonEvent() {
		btnStop.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				seleniumHelper.close();
			}
		});
	}

	public void clickOperationButtonEvent() {
		btnClickOperation.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String locatorValue = webLocatorTextField.getText();
				String locatorType = getLocatorType();
				String message = seleniumHelper.click(locatorType, locatorValue);
				if (rdbtnRecordingOn.isSelected()) {
					String step = "clickOperation:" + locatorType + ":" + locatorValue;
					executionSteps.add(step);
					codeSnippetTextArea.append(step.replace(":", " : ") + "\n");
				}
				resultTextArea.append(message + "\n");
			}
		});
	}

	public void sendKeysButtonEvent() {
		btnSendkeysoperation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String locatorValue = webLocatorTextField.getText();
				String locatorType = getLocatorType();
				String sendKeysValue = sendKeysTextField.getText();
				String message = seleniumHelper.sendKeys(locatorType, locatorValue, sendKeysValue);
				if (rdbtnRecordingOn.isSelected()) {
					String step = "sendKeys:" + locatorType + ":" + locatorValue + ":" + sendKeysValue;
					executionSteps.add(step);
					codeSnippetTextArea.append(step.replace(":", " : ") + "\n");
				}
				resultTextArea.append(message + "\n");
			}
		});
	}

	public void selectOperationButtonEvent() {
		selectOperationTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String locatorValue = webLocatorTextField.getText();
				String locatorType = getLocatorType();
				String selectOptionValue = selectOperationTextField.getText();
				String message = seleniumHelper.selectOperation(locatorType, locatorValue, selectOptionValue);
				if (rdbtnRecordingOn.isSelected()) {
					String step = "selectOperation:" + locatorType + ":" + locatorValue + ":" + selectOptionValue;
					executionSteps.add(step);
					codeSnippetTextArea.append(step.replace(":", " : ") + "\n");
				}
				resultTextArea.append(message + "\n");
			}
		});
	}

	public void waitButtonEvent() {
		waitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String waitValue = waitTextField.getText();
				String message = seleniumHelper.wait(waitValue);
				resultTextArea.append(message + "\n");
			}
		});
	}

	public void highlightEvent() {
		btnHighlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String locatorValue = webLocatorTextField.getText();
				String locatorType = getLocatorType();
				String message = seleniumHelper.highlight(locatorType, locatorValue);
				resultTextArea.append(message + "\n");
			}
		});
	}

	public void runButtonEvent() {
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleniumHelper.perfromMultipleSteps(executionSteps);
			}
		});
	}
	
	public void resetButtonEvent() {
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				codeSnippetTextArea.setText(null);
				executionSteps.clear();
			}
		});
	}

	public String getLocatorType() {
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
		return locatorType;
	}
}
