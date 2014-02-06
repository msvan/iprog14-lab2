package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

public class DetailedDishView extends Container {

	private static final long serialVersionUID = 1L;

	String[] types = { "", "Starter", "Main", "Desert" };

	public DetailedDishView(Dish dish) {
		setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(3, 3, 3, 3);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gbc.anchor = GridBagConstraints.WEST;
		ImageIcon image = new ImageIcon("images/" + dish.getImage());
		JLabel label = new JLabel("", image, JLabel.LEADING);
		label.setPreferredSize(new Dimension(50, 50));
		this.add(label, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		JLabel dishLabel = new JLabel(types[dish.getType()] + ": "
				+ dish.getName());
		dishLabel.setPreferredSize(new Dimension(175, 25));
		this.add(dishLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		JLabel costLabel = new JLabel("Cost" + ": " + "$ 1.0");

		costLabel.setBackground(new Color(255, 0, 0));
		this.add(costLabel, gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		JButton deleteButton = new JButton("X");
		this.add(deleteButton, gbc);
	}
}
