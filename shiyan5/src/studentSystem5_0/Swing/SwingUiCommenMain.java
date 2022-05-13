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
//�οͽ��棬ֻ����ͨ����ͬ�ķ�ʽ���ң������Զ����ݽ����޸�
public class SwingUiCommenMain extends JFrame implements ActionListener{
	static boolean first = true;
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
		SwingUiCommenMain.first = first;
	}
	public void ui(boolean first){
		this.first = first;
		JFrame jf = new JFrame("ѧ����Ϣ����ϵͳ5.1");
		JLabel jl = new JLabel();
		JLabel jl2 = new JLabel("�뵥��������еĹ���");
		JPanel jp = new JPanel();
		JButton jb1 = new  JButton("���ѧ����Ϣ");
		JButton jb2 = new  JButton("ɾ��ѧ����Ϣ");
		JButton jb3 = new  JButton("����������ѧ����Ϣ");
		JButton jb4 = new  JButton("��ѧ�Ų���ѧ����Ϣ");
		JButton jb5 = new  JButton("����ѧ����Ϣ");
		JButton jb6 = new  JButton("�г�������Ϣ");
		
		ImageIcon icon = new ImageIcon("src/studentSystem5_0/pokebiome_wallpaper.gif"); // ��������ͼƬ����
		jl.setIcon(icon);// ���ñ�ǩ���Ҫ��ʾ��ͼƬ
		
		
//		ActionListener jb1Listener = new Listener() ;
		//������
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		jb6.addActionListener(this);
		
		//��������
		jl2.setFont(new Font("����",Font.BOLD,90));
		jb1.setFont(new Font("����",Font.PLAIN,30));
		jb2.setFont(new Font("����",Font.PLAIN,30));
		jb3.setFont(new Font("����",Font.PLAIN,30));
		jb4.setFont(new Font("����",Font.PLAIN,30));
		jb5.setFont(new Font("����",Font.PLAIN,30));
		jb6.setFont(new Font("����",Font.PLAIN,30));
		
		jf.setBounds(0, 0, 1920, 1080);
		jl.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); // �����������ʾλ�ü���С
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
		
		
		jp.setComponentZOrder(jl,1);// �����ڵڶ���
		jp.setComponentZOrder(jl2,0);//�����ڵ�һ��
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
	@Override
	public void actionPerformed(ActionEvent e) {
		String select = e.getActionCommand();
		if(select.equals("���ѧ����Ϣ")) {
			SwingUiAdd add = new SwingUiAdd();
			add.ui();
		}else if(select.equals("ɾ��ѧ����Ϣ")) {
			SwingUiRemove remove = new SwingUiRemove();
			remove.ui();
		}else if(select.equals("����������ѧ����Ϣ")) {
			SwingUiSearchByName searchByName = new SwingUiSearchByName();
			searchByName.ui(first);
		}else if(select.equals("��ѧ�Ų���ѧ����Ϣ")) {
			SwingUiSearchByNo searchByNo = new SwingUiSearchByNo();
			searchByNo.ui();
		}else if(select.equals("����ѧ����Ϣ")) {
			SwingUiModify modify = new SwingUiModify();
			modify.ui();
		}else if(select.equals("�г�������Ϣ")) {
			SwingUiGetAll getAll = new SwingUiGetAll();
			getAll.ui(first);
		}
	}
		
}

