/**
 * 
 */
package studentSystem5_0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import studentSystem5_0.Swing.SwingUiMain;

/**
 * ѧ����Ϣ����ϵͳ������ʵ�ֶ�ѧ����Ϣ������ɾ���ģ��顣
 * 5.0�汾��4.0�汾������ʵ����swingͼ�ν��档
 * @author LYQ 2021��10��22�� 15��35��
 */
public class SystemMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingSelect select = new SwingSelect();
		select.select();
	}

}
