package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

public class SelectionView extends Container {
	private static final long serialVersionUID = 1L;

	Dimension dimension = new Dimension(300, 380);

	JPanel dishSelection;

	public SelectionView(DinnerModel model) {
		setLayout(new GridBagLayout());
		setPreferredSize(dimension);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weighty = 1;

		JLabel numberOfPeople = new JLabel("Number of people: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(numberOfPeople, gbc);

		SpinnerModel spinnerModel = new SpinnerNumberModel(
				model.getNumberOfGuests(), 0, 15, 1);
		JSpinner spinner = new JSpinner(spinnerModel);
		spinner.setPreferredSize(new Dimension(30, 24));
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.add(spinner, gbc);

		JLabel totalCost = new JLabel("Total cost: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(totalCost, gbc);

		JLabel menuPrice = new JLabel("$ " + model.getTotalMenuPrice());
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(menuPrice, gbc);

		JLabel dinnerMenuText = new JLabel("Dinner Menu");
		dinnerMenuText.setFont(new Font("Sans Serif", Font.BOLD, 28));
		dinnerMenuText.setPreferredSize(new Dimension(dimension.width, 28));
		dinnerMenuText.setHorizontalAlignment(JLabel.CENTER);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		this.add(dinnerMenuText, gbc);

		dishSelection = new JPanel(new FlowLayout());
		dishSelection.setPreferredSize(new Dimension(dimension.width, 200));
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		this.add(dishSelection, gbc);
		setSelection(model);

		JButton preparationButton = new JButton("Preparations");
		preparationButton.setPreferredSize(new Dimension(150, 24));
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		this.add(preparationButton, gbc);

		JButton ingredientsButton = new JButton("Ingredients");
		ingredientsButton.setPreferredSize(new Dimension(150, 24));
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		this.add(ingredientsButton, gbc);
	}

	private void setSelection(DinnerModel model) {
		dishSelection.removeAll();
		for (Dish d : model.getFullMenu()) {
			DetailedDishView ddv = new DetailedDishView(d);
			dishSelection.add(ddv);
		}
		dishSelection.updateUI();
	}
}
