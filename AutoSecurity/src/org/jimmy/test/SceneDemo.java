package org.jimmy.test;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Timer;

import org.jimmy.module.Engine;
import org.jimmy.module.InterruptButton;
import org.jimmy.module.Monitor;
import org.jimmy.module.PLCSignal;
import org.jimmy.module.Speaker;
import org.jimmy.module.OpenedWindow;
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
		fr.setLayout(new GridLayout(2, 1));
		fr.setSize(400, 400); 
		fr.setLocation(450, 200);
		fr.setResizable(false);
//		fr.setMaximumSize(new Dimension(400, 400));
		
		fr.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(1, 3));
		
		TextArea txt = new TextArea();
		txt.setEditable(false);
		final Color initC = txt.getBackground();
		txt.setColumns(2);
		txt.setRows(3);
		txt.setText("1\tStartup; \n 2\tAction;");
		Timer t = new Timer(300, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpenedWindow.getInstance().refresh();
				if(PLCSignal.signal_speak == Speaker.SPEAK_ON) {
					if(txt.getBackground() == Color.RED) {
						txt.setBackground(initC);
					} else {
						txt.setBackground(Color.RED);
					}
					txt.setText("正在报警");
				} else {
					txt.setBackground(initC);
					String str = "";
					double angel = OpenedWindow.getInstance().getAngel();
					if (PLCSignal.signal_direction == Engine.SWITCH_FORWARD) {
						str = "正在关窗 \t" + angel + "度角";
					} else if (PLCSignal.signal_direction == Engine.SWITCH_REVERSAL) {
						str = "正在开窗 \t" + angel + "度角";
					} else {
						str = "静止中 \t" + angel + "度角";
					}
					txt.setText(str);
				}
			}
		});
//		txt.setEnabled(false);
		Button btn0 = new Button("STARTUP");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startup();
				t.start();
				btn0.setLabel("Monitoring");
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
		Button btn1 = new Button("Out");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Monitor.person_comming_signal = !Monitor.person_comming_signal;
				if (Monitor.person_comming_signal) {
					btn1.setLabel("In");
				} else {
					btn1.setLabel("Out");
				}
			}
		});
		Button btn2 = new Button("Igone");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterruptButton.getInstance().interrupt();
			}
		});
		btn0.setSize(200, 50);
		btn1.setSize(200, 50);
		btn2.setSize(200, 50);
		
		p1.add(btn0);
		p1.add(btn1);
		p1.add(btn2);
		
		fr.add(p1);
		fr.add(txt);
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
