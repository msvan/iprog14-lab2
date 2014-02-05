package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;


public class MainView extends JPanel {
	
	private static final long serialVersionUID = 1L;
    
	public MainView(DinnerModel model){
		Dimension dimension = new Dimension(855, 400);
		
		setLayout(new FlowLayout());
		setPreferredSize(dimension);
		
		ContentView contentView = new ContentView(model);
		SelectionView selectionView = new SelectionView(model);
		JSeparator separator = new JSeparator();
		
		separator.setOrientation(JSeparator.NORTH);
		separator.setPreferredSize(new Dimension(1, 390));
		
		this.add(contentView);		
		this.add(separator);
		this.add(selectionView);
	}	
}
