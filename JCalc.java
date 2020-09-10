// p745-748

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JCalc extends JFrame implements ItemListener
{
	//data field variables and constants
	final int BASE_PRICE = 200;
	final int WEEKEND_PREMIUM = 100;
	final int BREAKFAST_PREMIUM = 20;
	final int GOLF_PREMIUM = 75;
	int totalPrice = BASE_PRICE;

	//Create 3 JCheckBox objects
	JCheckBox weekendBox = new JCheckBox("Weekend Premium $" + WEEKEND_PREMIUM, false);
	JCheckBox breakfastBox = new JCheckBox("Breakfast $" + BREAKFAST_PREMIUM, false);
	JCheckBox golfBox = new JCheckBox("Golf $" + GOLF_PREMIUM, false);

	//Create 4 JLabel objects
	JLabel resortLabel = new JLabel("Resort Price Calculator");
	JLabel optionExplainLabel = new JLabel("Base price for a room is $" + BASE_PRICE + ".");
	JLabel optionExplainLabel2 = new JLabel("Check the options you want to add.");
	JLabel priceLabel = new JLabel("The price for your stay is");

	//Create 1 JTextField object
	JTextField priceField = new JTextField(4);

	//Constructor
	public JCalc()
	{
		super("Resort Price Estimator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		//add gui components to frame
		add(resortLabel);
		add(optionExplainLabel);
		add(optionExplainLabel2);
		add(weekendBox);
		add(breakfastBox);
		add(golfBox);
		add(priceLabel);
		add(priceField);

		//set the priceField value when the GUI loads
		priceField.setText("$" + totalPrice);

		//add the event listeners for the JCheckbox objects
		weekendBox.addItemListener(this);
		breakfastBox.addItemListener(this);
		golfBox.addItemListener(this);
	}

	//event handling method
	@Override
	public void itemStateChanged(ItemEvent event)
	{
		Object source = event.getSource();
		int select = event.getStateChange();

		//Decide which component triggered this event
		//Adjust the totalPrice accordingly
		if(source == weekendBox)
		{
			//if box is checked add premium
			if(select == ItemEvent.SELECTED)
			{
				totalPrice += WEEKEND_PREMIUM;
			}
			else
			{
				totalPrice -= WEEKEND_PREMIUM;
			}
		}
		else if(source == breakfastBox)
		{
			if(select == ItemEvent.SELECTED)
			{
				totalPrice += BREAKFAST_PREMIUM;
			}
			else
			{
				totalPrice -= BREAKFAST_PREMIUM;
			}
		}
		else //source == golfBox
		{
			if(select == ItemEvent.SELECTED)
			{
				totalPrice += GOLF_PREMIUM;
			}
			else
			{
				totalPrice -= GOLF_PREMIUM;
			}
		}

		priceField.setText("$" + totalPrice);
	}

	public static void main(String[] args) 
	{
		//create JCalc object
		JCalc aFrame = new JCalc();
		aFrame.setSize(300, 200);
		aFrame.setVisible(true);
	}
}