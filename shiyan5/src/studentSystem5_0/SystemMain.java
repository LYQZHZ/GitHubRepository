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
 * 学生信息管理系统：可以实现对学生信息的增，删，改，查。
 * 5.0版本在4.0版本基础上实现了swing图形界面。
 * @author LYQ 2021年10月22日 15点35分
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
