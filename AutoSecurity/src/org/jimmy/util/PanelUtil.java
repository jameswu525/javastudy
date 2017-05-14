package org.jimmy.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PanelUtil extends JPanel {
	/**
	 * 
	 */
	private boolean refresh = false;
	private double rotate = 0.0;
	
	private static final long serialVersionUID = 1L;

	public PanelUtil() {
		super();
	}

	public void setData(boolean refresh, double rotate) {
		this.refresh = refresh;
		this.rotate = rotate;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		super.removeAll();
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.RED);
		g2.drawLine(20, 250, 250, 250);
		g2.drawLine(20, 251, 250, 251);
		g2.drawLine(20, 252, 250, 252);
//		if (refresh) {
			int pt = (int)(251 - (230 * Math.tan(Math.toRadians(this.rotate))));
			g2.drawLine(20, 251, 250, pt);
//		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponents(g);
	}
}
