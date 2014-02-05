package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class ContentView extends Container {
	private static final long serialVersionUID = 1L;
	
	JTabbedPane tabbedPane = new JTabbedPane();
    String[] tabTitles = new String[] {
    		"Starter", "Main", "Desert"
	};
    
	public ContentView(DinnerModel model){
		Dimension dimension = new Dimension(500, 400);
		
		setLayout(new BorderLayout());
		setPreferredSize(dimension);
		
		tabbedPane.setPreferredSize(new Dimension(500, 390));
        
        for (int i = 0; i < tabTitles.length; ++i) {
			JPanel tmpPanel = new JPanel();
			tmpPanel.add(new DishesView(model, i+1));
			tabbedPane.addTab(tabTitles[i], tmpPanel);
        }
        
        this.add(tabbedPane,BorderLayout.PAGE_START);
	}
}
