package org.jimmy.test;

import java.awt.Button;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Timer;

import org.jimmy.module.Engine;
import org.jimmy.module.InterruptButton;
import org.jimmy.module.Monitor;
import org.jimmy.module.PLCSignal;
import org.jimmy.module.Speaker;
import org.jimmy.module.Window;
import org.jimmy.util.SystemUtil;

public class SceneDemo extends Frame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SceneDemo(String title) {
		super(title);
	}
	
	private static void startup() {
		Monitor monitor = Monitor.getInstance();
		Engine engine = Engine.getInstance();
		Speaker speaker = Speaker.getInstance();
		// 启动信号系统中心
		PLCSignal.startup();
		new Thread(monitor).start();
		new Thread(engine).start();
		new Thread(speaker).start();
		
		System.out.println("=====================");
		System.out.println("====Scene prepared====");
		System.out.println("=====================");
		
	}
	
	private static void testScene01() {
		SystemUtil.sleeping(3);
		// 模拟有人闯入
		System.out.println("======Child comming ... ...");
		Monitor.person_comming_signal = true;

		SystemUtil.sleeping(10);
		System.out.println("//====Child safe ... ...");
		Monitor.person_comming_signal = false;
		
		SystemUtil.sleeping(8);
		// 模拟有人闯入
		System.out.println("======Child comming ... ...");
		Monitor.person_comming_signal = true;
		
	}
	
	private static void testScene02() {
		SystemUtil.sleeping(30);
		// 模拟有人闯入
		System.out.println("======Child comming ... ...");
		Monitor.person_comming_signal = true;
		
		SystemUtil.sleeping(10);
		System.out.println("//====Child safe ... ...");
		Monitor.person_comming_signal = false;

		SystemUtil.sleeping(30);
		// 模拟有人闯入
		System.out.println("======Child comming ... ...");
		Monitor.person_comming_signal = true;

		SystemUtil.sleeping(8);
		System.out.println("//====Interrupt ... ...");
		InterruptButton.getInstance().interrupt();
		
	}

	public static void main(String[] args) {
		SceneDemo fr = new SceneDemo("Security Demo"); 
		fr.setSize(300,200); 
		fr.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		TextArea txt = new TextArea();
		Timer t = new Timer(500, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PLCSignal.signal_speak == Speaker.SPEAK_ON) {
					txt.setText("Bee Bee Bee ... ...");
				} else {
					txt.setText("窗口开度：" + Window.getInstance().getAngle());
				}
			}
		});
//		txt.setEnabled(false);
		Button btn0 = new Button("STARTUP");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startup();
				t.start();
//				new Thread(new Runnable() {
//					public void run() {
//						while(true) {
//							txt.setText("窗口开度：" + Window.getInstance().getAngle());
//						}
//					}
//					
//				}).start();
				btn0.setEnabled(false);
			}
		});
		Button btn1 = new Button("NOBODY");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Monitor.person_comming_signal = !Monitor.person_comming_signal;
				if (Monitor.person_comming_signal) {
					btn1.setLabel("BABY");
				} else {
					btn1.setLabel("NOBODY");
				}
			}
		});
		Button btn2 = new Button("INTERRUPT");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterruptButton.getInstance().interrupt();
			}
		});
		btn0.setSize(200, 50);
		btn1.setSize(200, 50);
		btn2.setSize(200, 50);
		fr.add(btn0, "North");
		fr.add(btn1, "East");
		fr.add(btn2, "South");
		fr.add(txt, "Center");
		fr.setVisible(true); 
		
//		startup();
//		System.out.println("==> CASE 1");
//		testScene01();
//		System.out.println("==> CASE 2");
//		testScene02();
//		SystemUtil.sleeping(18);
//		System.out.println("用例完成");
	}

}
