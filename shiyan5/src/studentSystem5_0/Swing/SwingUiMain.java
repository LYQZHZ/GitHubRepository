package studentSystem5_0.Swing;
//主界面分为两个方向-管理员和游客
import java.awt.*;

import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

import studentSystem5_0.Swing.SwingUiLogin.MyWindowListener;

public class SwingUiMain{
	
	static JFrame jf = new JFrame("学生信息管理系统5.1");
	JLabel jl = new JLabel();
	ImageIcon icon;
	ImageIcon icon2;
	public void uiMain() {
		Font font = new Font("宋体",Font.BOLD,20);
    	UIManager.put("OptionPane.font", font);
    	UIManager.put("OptionPane.messageFont", font);
    	UIManager.put("OptionPane.buttonFont", font);
		//声明组件
		JLabel jl2 = new JLabel("欢迎使用学生管理系统5.1");
		JLabel jl3 = new JLabel("by-李岩青");
		JLabel jl4 = new JLabel("CopyRight © 2021-2021 浮生 Right Reserved 浮生工作室版权所有，翻版必究");
		JButton button1 = new JButton("我是管理员！");
		JButton button2 = new JButton("我是游客...");
		JButton button3 = new JButton();
		JPanel jp = new JPanel();
		//获取图片
		icon = new ImageIcon("src/studentSystem5_0/pokebiome_wallpaper.gif");
		icon2 = new ImageIcon("src/studentSystem5_0/2.gif"); // 创建背景图片对象
		button3.setIcon(icon2);
		jl.setIcon(icon); // 设置标签组件要显示的图片
		//设置组件位置和大小等
		jf.setBounds(0, 0, 1920, 1080);
		
		jl2.setFont(new Font("宋体",Font.BOLD,90));
		jl3.setFont(new Font("宋体",Font.BOLD,25));
		jl4.setFont(new Font("宋体",Font.BOLD,25));
		
		jl.setBounds(0, 0, 1920, 1080); // 设置组件的显示位置及大小
		jl2.setBounds(400, 100, 1200, 300);
		jl3.setBounds(900, 200, 800, 300);
		jl4.setBounds(450, 750, 1000, 300);
		
		button1.setBounds(580, 590, 200, 50);
		button1.setFont(new Font("宋体",Font.BOLD,25));
		button2.setBounds(1130, 590, 200, 50);
		button2.setFont(new Font("宋体",Font.BOLD,25));
		button3.setBounds(1800, 0, icon2.getIconWidth(), icon2.getIconHeight());
		
		//监听绑定
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUiLogin login = null;
				if (login.isFirst()==true) {
					login = new SwingUiLogin();
					login.ui();
				}
			}});
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUiCommenMain cm = new SwingUiCommenMain();
				boolean first=true;
				cm.ui(first);
			}});
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUiHuman human = new SwingUiHuman();
				boolean first=true;
				human.ui(first);
			}});
		//添加组件
		jp.add(jl);
		jp.add(jl2);
		jp.add(jl3);
		jp.add(jl4);
		jp.add(button1);
		jp.add(button2);
		jp.add(button3);
		//分层
		jp.setComponentZOrder(jl,1);// 放置在第二层
		jp.setComponentZOrder(jl2,0);//放置在第一层
		jp.setComponentZOrder(jl3,0);//放置在第一层
		jp.setComponentZOrder(jl4,0);//放置在第一层
		jp.setComponentZOrder(button1, 0);
		jp.setComponentZOrder(button2, 0);
		jp.setComponentZOrder(button3, 0);
		//
		
		jf.addWindowListener(new MyWindowListener());	
		jp.setLayout(null);
		jf.setContentPane(jp);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
	}	
	static class MyWindowListener implements WindowListener {
	    
	    @Override
	    public void windowOpened(WindowEvent e) {
	        // TODO Auto-generated method stub
//	        System.out.println("windowOpened");
//	        ta1.setText("窗口首次变为可见时调用");
	    	
	    }

	    @Override
	    public void windowClosing(WindowEvent e) {
	        // TODO Auto-generated method stub
//	        System.out.println("windowClosing");
//	        jl4.setText("用户试图从窗口的系统菜单中关闭窗口时调用");
	    	JOptionPane.showMessageDialog(jf,"感谢您的使用！如果您在使用过程中发现问题，欢迎您反馈给我们！o(*≧▽≦)ツ邮箱：941680745@qq.com","",JOptionPane.INFORMATION_MESSAGE);
	    }

	    @Override
	    public void windowClosed(WindowEvent e) {
	        // TODO Auto-generated method stub
	        //System.out.println("windowClosed");
	        //ta1.setText("因对窗口调用 dispose 而将其关闭时调用");
	    	
	    }

	    @Override
	    public void windowIconified(WindowEvent e) {
	        // TODO Auto-generated method stub
//	        System.out.println("windowIconified");
//	        jl4.setText("窗口从正常状态变为最小化状态时调用");
	    }

	    @Override
	    public void windowDeiconified(WindowEvent e) {
	        // TODO Auto-generated method stub
//	        System.out.println("windowDeiconified");
//	        jl4.setText("窗口从最小化状态变为正常状态时调用");
	    }

	    @Override
	    public void windowActivated(WindowEvent e) {
	        // TODO Auto-generated method stub
//	        System.out.println("windowActivated");
//	        jl4.setText("将 Window 设置为活动 Window 时调用");
	    }

	    @Override
	    public void windowDeactivated(WindowEvent e) {
	       // TODO Auto-generated method stub
//	        System.out.println("windowDeactivated");
//	        jl4.setText("当 Window 不再是活动 Window 时调用");
	    }
}
}
