package studentSystem5_0.Swing;
//��¼����
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class SwingUiLogin extends JFrame implements ActionListener{
	static boolean first = true;
	JPasswordField tf1 = new JPasswordField();
	
	
	/**
	 * @return tf1
	 */
	public JTextField getTf1() {
		return tf1;
	}
	/**
	 * @param tf1 Ҫ���õ� tf1
	 */
	public void setTf1(JPasswordField tf1) {
		this.tf1 = tf1;
	}
	/**
	 * @return first
	 */
	public static boolean isFirst() {
		return first;
	}
	/**
	 * @param first Ҫ���õ� first
	 */
	public static void setFirst(boolean first) {
		SwingUiLogin.first = first;
	}
	public void ui(){
		Font font = new Font("����",Font.BOLD,15);
    	UIManager.put("OptionPane.font", font);
    	UIManager.put("OptionPane.messageFont", font);
    	UIManager.put("OptionPane.buttonFont", font);
		JFrame jf = new JFrame("ѧ����Ϣ����ϵͳ5.1");
		JLabel jl = new JLabel();
		JLabel jl2 = new JLabel("����Ա��¼");
		JLabel jl3 = new JLabel("���룺");
		JPanel jp = new JPanel();
		JButton jb1 = new  JButton("��¼");
		
		ImageIcon icon = new ImageIcon("src/studentSystem5_0/pokebiome_wallpaper.gif"); // ��������ͼƬ����
		jl.setIcon(icon);// ���ñ�ǩ���Ҫ��ʾ��ͼƬ
		jb1.setBackground(Color.LIGHT_GRAY);
		
		
//		ActionListener jb1Listener = new Listener() ;
		//������
		tf1.addActionListener(this);
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				char[] ch = tf1.getPassword();
				String str = "";
				for(int i = 0;i < ch.length;i++) {
					str = str + ch[i];
				}
				String message = "�����������ѯ����Ա��";
//				JTextPane jtp = new JTextPane();
//				jtp.setSize(100, 50);
//				jtp.setText(message);
				if (str.equals("20190081110")) {
					JOptionPane.showMessageDialog(jp,"��½�ɹ�������������в���Ȩ�ޣ�","",JOptionPane.INFORMATION_MESSAGE);
					SwingUiRootMain rm = new SwingUiRootMain();
					rm.ui(first);
				}else {
					JOptionPane.showMessageDialog(jp,message,"����",JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		});
		jl2.setFont(new Font("����",Font.PLAIN,90));
		jl3.setFont(new Font("����",Font.BOLD,30));
		tf1.setFont(new Font("����",Font.PLAIN,30));
		jb1.setFont(new Font("����",Font.PLAIN,20));
		tf1.setFont(new Font("����",Font.PLAIN,20));
		
		jf.setBounds(0, 0, 1920, 1080);
		jl.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); // �����������ʾλ�ü���С
		jl2.setBounds(300, 80, 1200, 300);
		jl3.setBounds(230, 500, 100, 50);
		tf1.setBounds(330, 500, 500, 50);
		jb1.setBounds(230, 600, 600, 50);
		
		
		jp.add(jl);
		jp.add(jl2);
		jp.add(jl3);
		jp.add(tf1);
		jp.add(jb1);
		
		
		jp.setComponentZOrder(jl,1);// �����ڵڶ���
		jp.setComponentZOrder(jl2,0);//�����ڵ�һ��
		jp.setComponentZOrder(jl3,0);
		jp.setComponentZOrder(tf1,0);
		jp.setComponentZOrder(jb1,0);
		
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
//            ta1.setText("�����״α�Ϊ�ɼ�ʱ����");
        	first = false;
        }

        @Override
        public void windowClosing(WindowEvent e) {
            // TODO Auto-generated method stub
//            System.out.println("windowClosing");
//            jl4.setText("�û���ͼ�Ӵ��ڵ�ϵͳ�˵��йرմ���ʱ����");
        }

        @Override
        public void windowClosed(WindowEvent e) {
            // TODO Auto-generated method stub
            //System.out.println("windowClosed");
            //ta1.setText("��Դ��ڵ��� dispose ������ر�ʱ����");
        	first = true;
        }

        @Override
        public void windowIconified(WindowEvent e) {
            // TODO Auto-generated method stub
//            System.out.println("windowIconified");
//            jl4.setText("���ڴ�����״̬��Ϊ��С��״̬ʱ����");
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            // TODO Auto-generated method stub
//            System.out.println("windowDeiconified");
//            jl4.setText("���ڴ���С��״̬��Ϊ����״̬ʱ����");
        }

        @Override
        public void windowActivated(WindowEvent e) {
            // TODO Auto-generated method stub
//            System.out.println("windowActivated");
//            jl4.setText("�� Window ����Ϊ� Window ʱ����");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
           // TODO Auto-generated method stub
//            System.out.println("windowDeactivated");
//            jl4.setText("�� Window �����ǻ Window ʱ����");
        }

        
         
       }
	public void actionPerformed(ActionEvent e) {
		
	}
	
	

}
