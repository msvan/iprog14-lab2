package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class SelectionView extends Container {
	private static final long serialVersionUID = 1L;

	public SelectionView(DinnerModel model){
		Dimension dimension = new Dimension(330, 400);
		
		setLayout(new BorderLayout());
		setPreferredSize(dimension);
        
	}
}
