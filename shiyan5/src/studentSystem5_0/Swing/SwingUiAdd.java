package studentSystem5_0.Swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import studentSystem5_0.Student;
import studentSystem5_0.StudentDao;

public class SwingUiAdd  extends JFrame implements ActionListener{
	String no;
	String name;
	String gender;
	String age;
	String major;
	String grade;
	JFrame jf = new JFrame("ѧ����Ϣ����ϵͳ5.1");
	JLabel jl1 = new JLabel();
	JLabel jl2 = new JLabel("���ѧ��");
	JLabel jl9 = new JLabel();
	JPanel jp = new JPanel();
	
	JLabel jl3 = new JLabel("ѧ�ţ�");
	JLabel jl4 = new JLabel("������");
	JLabel jl5 = new JLabel("�Ա�");
	JLabel jl6 = new JLabel("���䣺");
	JLabel jl7 = new JLabel("רҵ��");
	JLabel jl8 = new JLabel("�꼶��");
	JTextField textFiled1 = new JTextField();
	JTextField textFiled2 = new JTextField();
	JTextField textFiled3 = new JTextField();
	JTextField textFiled4 = new JTextField();
	JTextField textFiled5 = new JTextField();
	JTextField textFiled6 = new JTextField();
	JButton jb1 = new JButton("���");
	
	ImageIcon icon = new ImageIcon("src/studentSystem5_0/pokebiome_wallpaper.gif"); // ��������ͼƬ����
	public void ui(){
		
		jl1.setIcon(icon);// ���ñ�ǩ���Ҫ��ʾ��ͼƬ
		
		jf.setBounds(0, 0, 1920, 1080);
		jl1.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); // �����������ʾλ�ü���С
		jl2.setBounds(300, 80, 1200, 300);
		
		jl3.setBounds(310, 350, 200, 50);
		jl4.setBounds(310, 430, 200, 50);
		jl5.setBounds(310, 510, 200, 50);
		jl6.setBounds(310, 590, 200, 50);
		jl7.setBounds(310, 670, 200, 50);
		jl8.setBounds(310, 750, 200, 50);
		jl9.setBounds(310, 800, 1000, 50);
		textFiled1.setBounds(410, 350, 260, 50);
		textFiled2.setBounds(410, 430, 260, 50);
		textFiled3.setBounds(410, 510, 260, 50);
		textFiled4.setBounds(410, 590, 260, 50);
		textFiled5.setBounds(410, 670, 260, 50);
		textFiled6.setBounds(410, 750, 260, 50);
		jb1.setBounds(290, 880, 400, 50);
		
		jl9.setForeground(Color.red);
		
		jl2.setFont(new Font("����",Font.BOLD,90));
		jl3.setFont(new Font("����",Font.BOLD,30));
		jl4.setFont(new Font("����",Font.BOLD,30));
		jl5.setFont(new Font("����",Font.BOLD,30));
		jl6.setFont(new Font("����",Font.BOLD,30));
		jl7.setFont(new Font("����",Font.BOLD,30));
		jl8.setFont(new Font("����",Font.BOLD,30));
		jl9.setFont(new Font("����",Font.BOLD,20));
		textFiled1.setFont(new Font("����",Font.BOLD,20));
		textFiled2.setFont(new Font("����",Font.BOLD,20));
		textFiled3.setFont(new Font("����",Font.BOLD,20));
		textFiled4.setFont(new Font("����",Font.BOLD,20));
		textFiled5.setFont(new Font("����",Font.BOLD,20));
		textFiled6.setFont(new Font("����",Font.BOLD,20));
		jb1.setFont(new Font("����",Font.BOLD,30));
	
		
		jp.add(jl1);
		jp.add(jl2);
		
		jp.add(jl3);
		jp.add(jl4);
		jp.add(jl5);
		jp.add(jl6);
		jp.add(jl7);
		jp.add(jl8);
		jp.add(jl9);
		jp.add(textFiled1);
		jp.add(textFiled2);
		jp.add(textFiled3);
		jp.add(textFiled4);
		jp.add(textFiled5);
		jp.add(textFiled6);
		jp.add(jb1);
		
		//����
//		textFiled1.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				no = e.getActionCommand();
//			}
//			
//		});
//		textFiled2.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				name = e.getActionCommand();
//				
//			}
//			
//		});
//		textFiled3.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				sex = e.getActionCommand();
//				
//			}
//			
//		});
//		textFiled4.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				age = e.getActionCommand();
//				
//			}
//			
//		});
//		textFiled5.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				major = e.getActionCommand();
//				
//			}
//			
//		});
//		textFiled6.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				grade = e.getActionCommand();
//				
//			}
//			
//		});	
		jb1.addActionListener(this);	
		
		jp.setComponentZOrder(jl1,1);// �����ڵڶ���
		jp.setComponentZOrder(jl2,0);//�����ڵ�һ��
		
		jp.setComponentZOrder(jl3,0);//�����ڵ�һ��
		jp.setComponentZOrder(jl4,0);//�����ڵ�һ��
		jp.setComponentZOrder(jl5,0);//�����ڵ�һ��
		jp.setComponentZOrder(jl6,0);//�����ڵ�һ��
		jp.setComponentZOrder(jl7,0);//�����ڵ�һ��
		jp.setComponentZOrder(jl8,0);//�����ڵ�һ��
		jp.setComponentZOrder(jl9,0);//�����ڵ�һ��
		jp.setComponentZOrder(textFiled1,0);//�����ڵ�һ��
		jp.setComponentZOrder(textFiled2,0);//�����ڵ�һ��
		jp.setComponentZOrder(textFiled3,0);//�����ڵ�һ��
		jp.setComponentZOrder(textFiled4,0);//�����ڵ�һ��
		jp.setComponentZOrder(textFiled5,0);//�����ڵ�һ��
		jp.setComponentZOrder(textFiled6,0);//�����ڵ�һ��
		jp.setComponentZOrder(jb1,0);
		
		jp.setLayout(null);
		jf.setContentPane(jp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		no = textFiled1.getText();
		name = textFiled2.getText();
		gender = textFiled3.getText();
		age = textFiled4.getText();
		major = textFiled5.getText();
		grade = textFiled6.getText();
		System.out.println(textFiled2.getText());
		boolean addFlag = true;
		Student stu = new Student();
		if(stu.setStuNo(no) != ("��ӳɹ���")) {
			jl9.setText(stu.setStuNo(no));
		}else if(stu.setName(name) != ("��ӳɹ���")){
			jl9.setText(stu.setName(name));
		}else if(stu.setGender(gender) != ("��ӳɹ���")){
			jl9.setText(stu.setGender(gender));
		}else if(stu.setAge(age) != ("��ӳɹ���")){
			jl9.setText(stu.setAge(age));
		}else if(stu.setStuNo(no) == ("��ӳɹ���")&&stu.setName(name)== "��ӳɹ���"&&stu.setGender(gender) == ("��ӳɹ���")&&stu.setAge(age) == ("��ӳɹ���")) {
			stu.setMajor(major);
			stu.setGrade(grade);
			StudentDao sd = new StudentDao();
			addFlag = sd.addStudent(stu);
			if(addFlag == true) {
				textFiled1.setText("");
				textFiled2.setText("");
				textFiled3.setText("");
				textFiled4.setText("");
				textFiled5.setText("");
				textFiled6.setText("");
				jl9.setText("��ӳɹ����ɼ�����ӣ�");
			}else {
				jl9.setText("���ʧ�ܣ���ѧ���ѱ�ʹ�ã�");
			}
		}
	}
}
