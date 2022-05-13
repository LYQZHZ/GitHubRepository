package studentSystem5_0.Swing;

import java.awt.Color;

import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
//游客界面，只可以通过不同的方式查找，不可以对数据进行修改
public class SwingUiCommenMain extends JFrame implements ActionListener{
	static boolean first = true;
	/**
	 * @return first
	 */
	public static boolean isFirst() {
		return first;
	}
	/**
	 * @param first 要设置的 first
	 */
	public static void setFirst(boolean first) {
		SwingUiCommenMain.first = first;
	}
	public void ui(boolean first){
		this.first = first;
		JFrame jf = new JFrame("学生信息管理系统5.1");
		JLabel jl = new JLabel();
		JLabel jl2 = new JLabel("请单击你想进行的功能");
		JPanel jp = new JPanel();
		JButton jb1 = new  JButton("添加学生信息");
		JButton jb2 = new  JButton("删除学生信息");
		JButton jb3 = new  JButton("按姓名查找学生信息");
		JButton jb4 = new  JButton("按学号查找学生信息");
		JButton jb5 = new  JButton("更改学生信息");
		JButton jb6 = new  JButton("列出所有信息");
		
		ImageIcon icon = new ImageIcon("src/studentSystem5_0/pokebiome_wallpaper.gif"); // 创建背景图片对象
		jl.setIcon(icon);// 设置标签组件要显示的图片
		
		
//		ActionListener jb1Listener = new Listener() ;
		//监听绑定
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		jb6.addActionListener(this);
		
		//设置字体
		jl2.setFont(new Font("宋体",Font.BOLD,90));
		jb1.setFont(new Font("宋体",Font.PLAIN,30));
		jb2.setFont(new Font("宋体",Font.PLAIN,30));
		jb3.setFont(new Font("宋体",Font.PLAIN,30));
		jb4.setFont(new Font("宋体",Font.PLAIN,30));
		jb5.setFont(new Font("宋体",Font.PLAIN,30));
		jb6.setFont(new Font("宋体",Font.PLAIN,30));
		
		jf.setBounds(0, 0, 1920, 1080);
		jl.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); // 设置组件的显示位置及大小
		jl2.setBounds(300, 80, 1200, 300);
		
		jb1.setBounds(300, 400, 500, 50);
		jb2.setBounds(750, 480, 500, 50);
		jb3.setBounds(300, 560, 500, 50);
		jb4.setBounds(750, 640, 500, 50);
		jb6.setBounds(300, 720, 500, 50);
		jb5.setBounds(750, 800, 500, 50);
		
		
		jp.add(jl);
		jp.add(jl2);
//		jp.add(jb1);
//		jp.add(jb2);
		jp.add(jb3);
		jp.add(jb4);
//		jp.add(jb5);
		jp.add(jb6);
		
		
		jp.setComponentZOrder(jl,1);// 放置在第二层
		jp.setComponentZOrder(jl2,0);//放置在第一层
//		jp.setComponentZOrder(jb1,0);
//		jp.setComponentZOrder(jb2,0);
		jp.setComponentZOrder(jb3,0);
		jp.setComponentZOrder(jb4,0);
//		jp.setComponentZOrder(jb5,0);
		jp.setComponentZOrder(jb6,0);
		
		
		jf.addWindowListener(new MyWindowListener());		
		jp.setLayout(null);
		jf.setContentPane(jp);
		jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);
		jf.setVisible(true);
		
	}
	static class MyWindowListener implements WindowListener {
        
        @Override
        public void windowOpened(WindowEvent e) {
            // TODO Auto-generated method stub
//            System.out.println("windowOpened");
//            ta1.setText("窗口首次变为可见时调用");
        	first = false;
        }

        @Override
        public void windowClosing(WindowEvent e) {
            // TODO Auto-generated method stub
//            System.out.println("windowClosing");
//            jl4.setText("用户试图从窗口的系统菜单中关闭窗口时调用");
        }

        @Override
        public void windowClosed(WindowEvent e) {
            // TODO Auto-generated method stub
            //System.out.println("windowClosed");
            //ta1.setText("因对窗口调用 dispose 而将其关闭时调用");
        	first = true;
        }

        @Override
        public void windowIconified(WindowEvent e) {
            // TODO Auto-generated method stub
//            System.out.println("windowIconified");
//            jl4.setText("窗口从正常状态变为最小化状态时调用");
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            // TODO Auto-generated method stub
//            System.out.println("windowDeiconified");
//            jl4.setText("窗口从最小化状态变为正常状态时调用");
        }

        @Override
        public void windowActivated(WindowEvent e) {
            // TODO Auto-generated method stub
//            System.out.println("windowActivated");
//            jl4.setText("将 Window 设置为活动 Window 时调用");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
           // TODO Auto-generated method stub
//            System.out.println("windowDeactivated");
//            jl4.setText("当 Window 不再是活动 Window 时调用");
        }

        
         
       }
	@Override
	public void actionPerformed(ActionEvent e) {
		String select = e.getActionCommand();
		if(select.equals("添加学生信息")) {
			SwingUiAdd add = new SwingUiAdd();
			add.ui();
		}else if(select.equals("删除学生信息")) {
			SwingUiRemove remove = new SwingUiRemove();
			remove.ui();
		}else if(select.equals("按姓名查找学生信息")) {
			SwingUiSearchByName searchByName = new SwingUiSearchByName();
			searchByName.ui(first);
		}else if(select.equals("按学号查找学生信息")) {
			SwingUiSearchByNo searchByNo = new SwingUiSearchByNo();
			searchByNo.ui();
		}else if(select.equals("更改学生信息")) {
			SwingUiModify modify = new SwingUiModify();
			modify.ui();
		}else if(select.equals("列出所有信息")) {
			SwingUiGetAll getAll = new SwingUiGetAll();
			getAll.ui(first);
		}
	}
		
}

