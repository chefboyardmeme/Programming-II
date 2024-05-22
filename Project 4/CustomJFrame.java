import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

/**
 * CustomJFrame that creates the Dietary Survey GUI when constructed
 */
public class CustomJFrame extends JFrame
{
	private JLabel headingLabel, firstNameLabel, lastNameLabel, phoneNumberLabel, emailLabel, dietaryLabel, genderLabel, waterLabel, mealsLabel, checkBoxLabel, walkLabel, weigthLabel;
	private JTextField firstNameTextField, lastNameTextField, phoneNumberTextField,  emailTextField;
	private JRadioButton maleRadioButton, femaleRadioButton, preferRadioButton;
	private ButtonGroup radioButtonGroup;
	private JSpinner waterIntakeSpinner;
	private JSlider mealSlider;
	private JCheckBox wheatCheckBox, sugarCheckBox, dairyCheckBox;
	private JComboBox walkComboBox;
	private String[] walkOptions = {"Less than 1 Mile", "More than 1 mile but less than 2 miles", "More than 2 miles but less than 3 miles", "More than 3 miles"};
	private JFormattedTextField weightFormattedTextField;
	private JButton clearButton, submitButton;
	private FileHandler fileHandler;
	
	public CustomJFrame()
	{
	    setSize(400, 850);
	    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    setLayout(new GridBagLayout());	// set the layout manager
	    GridBagConstraints layoutManager = new GridBagConstraints();
	    //initialize labels
	    headingLabel = new JLabel("Personal Information"); 
	    firstNameLabel = new JLabel("First Name:"); 
	    lastNameLabel = new JLabel("Last Name:"); 
	    phoneNumberLabel = new JLabel("Phone Number:"); 
	    emailLabel = new JLabel("Email:");  
	    dietaryLabel = new JLabel("Dietary Questions"); 
	    genderLabel = new JLabel("Sex:"); 
	    waterLabel = new JLabel("How many cups of water on average do you drink a day?"); 
	    mealsLabel = new JLabel("How many meals on average do you eat a day?"); 
	    checkBoxLabel = new JLabel("Do any of these meals regularly contain:"); 
	    walkLabel = new JLabel("On average how many miles do you walk in a day?"); 
	    weigthLabel = new JLabel("How much do you weigh?"); 
	    //personal information
	    layoutManager.gridx = 0;
	    layoutManager.gridy = 0;
	    layoutManager.insets = new Insets(10, 10, 10, 10);//(top,left,bottom,right)
	    add(headingLabel, layoutManager);  
	    layoutManager.gridx = 0;
	    layoutManager.gridy = 1;
	    add(firstNameLabel, layoutManager); 
	    layoutManager.gridx = 1;
	    layoutManager.gridy = 1;
	    firstNameTextField = new JTextField("",20);
	    add(firstNameTextField, layoutManager);
	    layoutManager.gridx = 0;
	    layoutManager.gridy = 2;
	    add(lastNameLabel, layoutManager);
	    layoutManager.gridx = 1;
	    layoutManager.gridy = 2;
	    lastNameTextField = new JTextField("",20);
	    add(lastNameTextField, layoutManager);
	    layoutManager.gridx = 0;
	    layoutManager.gridy = 3;
	    add(phoneNumberLabel, layoutManager);
	    layoutManager.gridx = 1;
	    layoutManager.gridy = 3;
	    phoneNumberTextField = new JTextField("",20);
	    add( phoneNumberTextField, layoutManager);
	    layoutManager.gridx = 0;
	    layoutManager.gridy = 4;
	   add(emailLabel, layoutManager);
	    layoutManager.gridx = 1;
	    layoutManager.gridy = 4;
	    emailTextField = new JTextField("",20);
	    add(emailTextField, layoutManager);
	    //gender button group
	    layoutManager.gridx = 0;
	    layoutManager.gridy = 5;
	    add(genderLabel, layoutManager);
	    maleRadioButton = new JRadioButton();
	    maleRadioButton.setText("Male");
	    maleRadioButton.setActionCommand("Male");
	    femaleRadioButton = new JRadioButton();
	    femaleRadioButton.setText("Female");
	    femaleRadioButton.setActionCommand("Female");
	    preferRadioButton = new JRadioButton();
	    preferRadioButton.setText("Prefer not to say");
	    preferRadioButton.setSelected(false);
	    preferRadioButton.setActionCommand("null");
	    radioButtonGroup = new ButtonGroup();
	    radioButtonGroup.add(maleRadioButton);
	    radioButtonGroup.add(femaleRadioButton);
	    radioButtonGroup.add(preferRadioButton);
	    layoutManager.gridx = 1;
	    layoutManager.gridy = 5;
	    layoutManager.insets = new Insets(10, 0, 10, 100);//(top,left,bottom,right)
	    Box radioButtonBox = Box.createVerticalBox();
	    radioButtonBox.add(maleRadioButton);
	    radioButtonBox.add(femaleRadioButton);
	    radioButtonBox.add(preferRadioButton);
	    add(radioButtonBox, layoutManager);
	    //dietary
	    layoutManager.gridx = 0;
	    layoutManager.gridy = 6;
	    layoutManager.insets = new Insets(10, 10, 10, 10);//(top,left,bottom,right)
	    add(dietaryLabel, layoutManager);
	    //water spinner
	    layoutManager.gridx = 1;
	    layoutManager.gridy = 7;
	    layoutManager.insets = new Insets(10, -100, 10, 10);//(top,left,bottom,right)
	    add(waterLabel, layoutManager);
	    SpinnerNumberModel spinnerModel = new SpinnerNumberModel(15,0,50,1);
	    waterIntakeSpinner = new JSpinner(spinnerModel);
	    int value = (int) waterIntakeSpinner.getValue();
	    layoutManager.gridx = 1;
	    layoutManager.gridy = 8;
	    add(waterIntakeSpinner,layoutManager);
	    //meal slider
	    layoutManager.gridx = 0;
	    layoutManager.gridy = 9;
	    layoutManager.insets = new Insets(10, 10, 10, -250);//(top,left,bottom,right)
	    add(mealsLabel, layoutManager);
	    layoutManager.gridx = 0;
	    layoutManager.gridy = 10;
	    mealSlider = new JSlider(SwingConstants.HORIZONTAL, 0,10,3);
	    mealSlider.setMajorTickSpacing(1);
	    mealSlider.setPaintTicks(true);
	    mealSlider.setPaintLabels(true);
	    add(mealSlider, layoutManager);
	    //meal checkbox
	    layoutManager.gridx = 0;
	    layoutManager.gridy = 11;
	    add(checkBoxLabel, layoutManager);
	    Box checkBoxBox = Box.createHorizontalBox();
	    layoutManager.gridx = 0;
	    layoutManager.gridy = 12;
	    dairyCheckBox = new JCheckBox("Dairy");
	    checkBoxBox.add(dairyCheckBox);
	    wheatCheckBox = new JCheckBox("Wheat");
	    checkBoxBox.add(wheatCheckBox);
	    sugarCheckBox = new JCheckBox("Sugar");
	    checkBoxBox.add(sugarCheckBox);
	    add(checkBoxBox, layoutManager);
	    //miles dropdown
	    layoutManager.gridx = 0;
	    layoutManager.gridy = 13;
	    add(walkLabel, layoutManager);
	    layoutManager.gridx = 0;
	    layoutManager.gridy = 14;
	    walkComboBox = new JComboBox<String>(walkOptions);
	    add(walkComboBox, layoutManager);
	    //weight formatted text field
	    layoutManager.gridx = 0;
	    layoutManager.gridy = 15;
	    add(weigthLabel, layoutManager);
	    NumberFormat numberFormatter = NumberFormat.getNumberInstance();
	    layoutManager.gridx = 0;
	    layoutManager.gridy = 16;
	    weightFormattedTextField = new JFormattedTextField(numberFormatter);
	    weightFormattedTextField.setColumns(20);
	    add(weightFormattedTextField, layoutManager);
	    //submit & clear buttons
	    layoutManager.insets = new Insets(10, 0, 10, 0);//(top,left,bottom,right)
	    clearButton = new JButton("Clear");
	    clearButton.setName("Clear");
	    submitButton = new JButton("Submit");
	    submitButton.setName("Submit");
	    fileHandler = new FileHandler();
	    /**
	     * Action Listener for Submit & Clear Buttons
	     * Determines which button was pressed then takes appropriate action
	     */
	    class InnerActionListener implements ActionListener
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String tempData="";
				JButton button = (JButton) e.getSource();
				if(button.getName().equals("Submit"))
				{
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//date format for string
					Date date = new Date();
					//DateTime to string
					tempData += dateFormat.format(date)+",";
					//Text Fields to string
					tempData += firstNameTextField.getText()+",";
					tempData += lastNameTextField.getText()+",";
					tempData += phoneNumberTextField.getText()+",";
					tempData += emailTextField.getText()+",";
					//Get radio button selection to string
					if(maleRadioButton.isSelected())
					{tempData += maleRadioButton.getActionCommand()+",";}
					else if(femaleRadioButton.isSelected())
					{tempData += femaleRadioButton.getActionCommand()+",";}
					else
					{tempData += preferRadioButton.getActionCommand()+",";}
					//spinner to string
					tempData += waterIntakeSpinner.getValue()+",";
					//slider to string
					tempData += mealSlider.getValue()+",";
					//checkbox selection to string
					tempData += wheatCheckBox.isSelected()+",";
					tempData += sugarCheckBox.isSelected()+",";
					tempData += dairyCheckBox.isSelected()+",";
					//dropdown selection to string
					tempData += walkComboBox.getSelectedItem()+",";
					//text field to string
					tempData += weightFormattedTextField.getText();
					fileHandler.writeResults(tempData);
					clearForm();
					tempData="";
				}//end if
				else if(button.getName().equals("Clear"))
				{
					clearForm();
					tempData="";
				}//end else if
			}//end action performed
			/**
			 * Returns all fields to their orignal state
			 * @return
			 */
			private void clearForm()
			{
				firstNameTextField.setText(""); 
				lastNameTextField.setText("");
				phoneNumberTextField.setText("");
				emailTextField.setText("");
				radioButtonGroup.clearSelection();
				waterIntakeSpinner.setValue(15);
				mealSlider.setValue(3);
				wheatCheckBox.setSelected(false);
				sugarCheckBox.setSelected(false);
				dairyCheckBox.setSelected(false);
				walkComboBox.setSelectedItem(walkOptions[0]);
				weightFormattedTextField.setText("");
			}//end clearForm
		}//end inner class
	    InnerActionListener listener = new InnerActionListener();
	    layoutManager.gridx = 0;
	    layoutManager.gridy = 17;
	    clearButton.addActionListener(listener);
	    add(clearButton, layoutManager);
	    layoutManager.insets = new Insets(10, 100, 10, 0);//(top,left,bottom,right)
	    layoutManager.gridx = 1;
	    layoutManager.gridy = 17;
	    submitButton.addActionListener(listener);
	    add(submitButton, layoutManager);
	}//end constructor
}//end class
