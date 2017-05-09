import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * 局部内部类实现时钟提示
 * 
 * @author XIEHEJUN
 * 
 */
public class InnerAlarmClock {
	/**
	 * 定义延迟时间
	 */
	private int delay;
	/**
	 * 电脑是否发出声音
	 */
	private boolean flag;

	/**
	 * 类初始化
	 * 
	 * @param delay
	 * @param flag
	 */
	public InnerAlarmClock(int delay, boolean flag) {
		this.delay = delay;
		this.flag = flag;
	}

	/**
	 * 局部内部类
	 */
	public void start() {
		class Printer implements ActionListener {

			@Override
			/**
			 * 局部内部类动作监控
			 */
			public void actionPerformed(ActionEvent e) {
				// 格式化当前日期
				SimpleDateFormat sdf = new SimpleDateFormat("k:m:s");
				String result = sdf.format(new Date());
				System.out.println("当前时间是：" + result);
				// 判断是否发出声音
				if (flag) {
					Toolkit.getDefaultToolkit().beep();
				}
			}
		}
		new Timer(delay, new Printer()).start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InnerAlarmClock clock = new InnerAlarmClock(1000, true);
		clock.start();
		// 弹出消息对话框
		JOptionPane.showMessageDialog(null, "是否退出？");
		System.exit(0);

	}
}
