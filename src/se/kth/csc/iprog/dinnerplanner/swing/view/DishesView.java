package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

public class DishesView extends JPanel {

	private static final long serialVersionUID = 1L;

	private Set<Dish> dishes;

	private JPanel searchBarPanel;
	private JTextField searchInput;

	private JPanel dishesPanel;
	private JScrollPane scrollPane;

	private Dimension searchBarDimension = new Dimension(500, 50);
	private Dimension scrollDimension = new Dimension(500, 300);
	private Dimension dishDimension = new Dimension(150, 160);

	public DishesView(DinnerModel model, int type) {
		setLayout(new BorderLayout());

		searchInput = new JTextField();
		searchInput.setText("search");
		searchInput.setColumns(20);
		searchBarPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		searchBarPanel.setPreferredSize(searchBarDimension);
		searchBarPanel.add(searchInput);

		dishes = model.getDishesOfType(type);

		dishesPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		scrollPane = new JScrollPane(dishesPanel,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(scrollDimension);

		addDishes(dishes);

		this.add(searchBarPanel, BorderLayout.PAGE_START);
		this.add(scrollPane, BorderLayout.PAGE_END);
	}

	public void addDishes(Set<Dish> dishes) {
		this.dishes = dishes;

		dishesPanel.removeAll();
		dishesPanel.setPreferredSize(new Dimension(
				(10 + dishDimension.width) * 3, (10 + dishDimension.height)
						* ((int) Math.ceil(dishes.size() / 3.0))));

		for (Dish d : dishes) {
			JButton dishButton = new JButton(d.getName(), new ImageIcon(
					"images/" + d.getImage()));
			dishButton.setPreferredSize(dishDimension);
			dishButton.setVerticalTextPosition(AbstractButton.BOTTOM);
			dishButton.setHorizontalTextPosition(AbstractButton.CENTER);
			dishesPanel.add(dishButton);
		}

		this.updateUI();
	}

}
