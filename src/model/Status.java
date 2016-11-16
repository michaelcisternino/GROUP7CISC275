package model;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import game.Game;

public class Status extends JPanel {
	JLabel statusLabel = new JLabel();
	public Status(){
//		super();
//		super.setPreferredSize(new Dimension(Game.WIDTH*Game.SCALE, Game.HEIGHT*Game.SCALE));
		setBorder(new BevelBorder(BevelBorder.LOWERED));
		setPreferredSize(new Dimension(100, 20));
		setLayout(new BorderLayout());
		statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
		add(statusLabel);
	}
	public void update(){
		statusLabel.setText("Trash Bags: " + Game.gameControl.crabby.trashBagCnt + " Hay: " + Game.gameControl.crabby.hayCnt + " Seeds: " + Game.gameControl.crabby.seedCnt + " Compost: " + Game.gameControl.crabby.compCnt);
	}

}