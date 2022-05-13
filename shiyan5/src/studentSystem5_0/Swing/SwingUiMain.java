package studentSystem5_0.Swing;
//�������Ϊ��������-����Ա���ο�
import java.awt.*;

import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

import studentSystem5_0.Swing.SwingUiLogin.MyWindowListener;

public class SwingUiMain{
	
	static JFrame jf = new JFrame("ѧ����Ϣ����ϵͳ5.1");
	JLabel jl = new JLabel();
	ImageIcon icon;
	ImageIcon icon2;
	public void uiMain() {
		Font font = new Font("����",Font.BOLD,20);
    	UIManager.put("OptionPane.font", font);
    	UIManager.put("OptionPane.messageFont", font);
    	UIManager.put("OptionPane.buttonFont", font);
		//�������
		JLabel jl2 = new JLabel("��ӭʹ��ѧ������ϵͳ5.1");
		JLabel jl3 = new JLabel("by-������");
		JLabel jl4 = new JLabel("CopyRight �0�8 2021-2021 ���� Right Reserved ���������Ұ�Ȩ���У�����ؾ�");
		JButton button1 = new JButton("���ǹ���Ա��");
		JButton button2 = new JButton("�����ο�...");
		JButton button3 = new JButton();
		JPanel jp = new JPanel();
		//��ȡͼƬ
		icon = new ImageIcon("src/studentSystem5_0/pokebiome_wallpaper.gif");
		icon2 = new ImageIcon("src/studentSystem5_0/2.gif"); // ��������ͼƬ����
		button3.setIcon(icon2);
		jl.setIcon(icon); // ���ñ�ǩ���Ҫ��ʾ��ͼƬ
		//�������λ�úʹ�С��
		jf.setBounds(0, 0, 1920, 1080);
		
		jl2.setFont(new Font("����",Font.BOLD,90));
		jl3.setFont(new Font("����",Font.BOLD,25));
		jl4.setFont(new Font("����",Font.BOLD,25));
		
		jl.setBounds(0, 0, 1920, 1080); // �����������ʾλ�ü���С
		jl2.setBounds(400, 100, 1200, 300);
		jl3.setBounds(900, 200, 800, 300);
		jl4.setBounds(450, 750, 1000, 300);
		
		button1.setBounds(580, 590, 200, 50);
		button1.setFont(new Font("����",Font.BOLD,25));
		button2.setBounds(1130, 590, 200, 50);
		button2.setFont(new Font("����",Font.BOLD,25));
		button3.setBounds(1800, 0, icon2.getIconWidth(), icon2.getIconHeight());
		
		//������
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
		//������
		jp.add(jl);
		jp.add(jl2);
		jp.add(jl3);
		jp.add(jl4);
		jp.add(button1);
		jp.add(button2);
		jp.add(button3);
		//�ֲ�
		jp.setComponentZOrder(jl,1);// �����ڵڶ���
		jp.setComponentZOrder(jl2,0);//�����ڵ�һ��
		jp.setComponentZOrder(jl3,0);//�����ڵ�һ��
		jp.setComponentZOrder(jl4,0);//�����ڵ�һ��
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
//	        ta1.setText("�����״α�Ϊ�ɼ�ʱ����");
	    	
	    }

	    @Override
	    public void windowClosing(WindowEvent e) {
	        // TODO Auto-generated method stub
//	        System.out.println("windowClosing");
//	        jl4.setText("�û���ͼ�Ӵ��ڵ�ϵͳ�˵��йرմ���ʱ����");
	    	JOptionPane.showMessageDialog(jf,"��л����ʹ�ã��������ʹ�ù����з������⣬��ӭ�����������ǣ�o(*�R���Q)�����䣺941680745@qq.com","",JOptionPane.INFORMATION_MESSAGE);
	    }

	    @Override
	    public void windowClosed(WindowEvent e) {
	        // TODO Auto-generated method stub
	        //System.out.println("windowClosed");
	        //ta1.setText("��Դ��ڵ��� dispose ������ر�ʱ����");
	    	
	    }

	    @Override
	    public void windowIconified(WindowEvent e) {
	        // TODO Auto-generated method stub
//	        System.out.println("windowIconified");
//	        jl4.setText("���ڴ�����״̬��Ϊ��С��״̬ʱ����");
	    }

	    @Override
	    public void windowDeiconified(WindowEvent e) {
	        // TODO Auto-generated method stub
//	        System.out.println("windowDeiconified");
//	        jl4.setText("���ڴ���С��״̬��Ϊ����״̬ʱ����");
	    }

	    @Override
	    public void windowActivated(WindowEvent e) {
	        // TODO Auto-generated method stub
//	        System.out.println("windowActivated");
//	        jl4.setText("�� Window ����Ϊ� Window ʱ����");
	    }

	    @Override
	    public void windowDeactivated(WindowEvent e) {
	       // TODO Auto-generated method stub
//	        System.out.println("windowDeactivated");
//	        jl4.setText("�� Window �����ǻ Window ʱ����");
	    }
}
}
