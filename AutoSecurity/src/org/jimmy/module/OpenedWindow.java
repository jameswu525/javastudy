package org.jimmy.module;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JFrame;

import org.jimmy.util.MathUtil;
import org.jimmy.util.PanelUtil;
import org.jimmy.util.SystemUtil;

public class OpenedWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Double LENGTH_C_MIN = 55.0;
	private static final Double LENGTH_C_MAX = 85.0;
	private static final Double LENGTH_C_STEP = 15.0;

	private static OpenedWindow instance;
	private Double length_a = 30.0;
	private Double length_b = 60.0;
	private Double length_c = 55.0;
	private PanelUtil p = null;

	private OpenedWindow() {
		super();
		this.setSize(250, 300);
		this.setResizable(false);
		this.setLocation(150, 100);

		p = new PanelUtil();
		this.add(p);
		this.setVisible(true);
		refresh();
	}

	public void refresh() {
		p.setData(PLCSignal.signal_direction != Engine.SWITCH_STOP, getAngel());
		p.paint(p.getGraphics());
		this.repaint();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponents(g);
	}

	/**
	 * 返回当前状态的窗户角度
	 * @return
	 */
	public double getAngel() {
		return Math.round(Math.toDegrees(Math.acos(
				(length_a * length_a + length_c * length_c - length_b * length_b) / (2.0 * length_a * length_c))));
	}

	/**
	 * 关闭窗户，每次将滑轨移动一个STEP
	 * @return
	 */
	public boolean closing() {
		length_c = Math.min(length_c + length_c / LENGTH_C_STEP, LENGTH_C_MAX);
		SystemUtil.print(this, "opening ..." + getAngel());
		System.out.println(SystemUtil.printTime(this) + "opening ..." + getAngel() + " || TAN :"+ Math.tan(Math.toRadians(this.getAngel())));
		return MathUtil.isEqual(length_c, LENGTH_C_MAX);
	}

	/**
	 * 开启窗户，每次将滑轨移动一个STEP
	 * @return
	 */
	public boolean opening() {
		length_c = Math.max(length_c - length_c / LENGTH_C_STEP, LENGTH_C_MIN);
		SystemUtil.print(this, "closing ..." + getAngel());
		System.out.println(SystemUtil.printTime(this) + "closing ..." + getAngel() + " || TAN :" + Math.tan(Math.toRadians(this.getAngel())));
		return MathUtil.isEqual(length_c, LENGTH_C_MIN);
	}

	public static OpenedWindow getInstance() {
		if (instance == null) {
			instance = new OpenedWindow();
		}
		return instance;
	}

	public static void main(String[] args) {
				OpenedWindow window = OpenedWindow.getInstance();
		//		double angle = window.getAngel();
		//		System.out.println(angle);
		//		while (!window.opening()) {
		//			angle = window.getAngel();
		//			System.out.println(angle);
		//		}
		//		while (!window.closing()) {
		//			angle = window.getAngel();
		//			System.out.println(angle);
		//		}
	}

}
