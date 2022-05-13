package studentSystem5_0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//业务层，可以实现数据库方面的增，删，改，查
public class StudentDao {
	public String studentdbPath = "jdbc:mysql://localhost:3306/studentdb";//数据库的地址
	public String userName = "root";//数据库用户名
	public String password = "121519";//数据库密码
/**
 * 李岩青
	 * 向数据库中添加一名学生
	 * @param student   student的对象
	 * @return  boolean值，true为添加成功、false为添加不成功
	 * @throws SQLException  不能正常关闭数据库时抛出SQLException异常
	 */
	public boolean addStudent(Student student){//
		//要返回的结果变量
		boolean result = false;
		//插入一本书的SQL语句字符串
		String sql = "INSERT INTO `studentdb`.`student` \r\n"
				+ "(`student_no`,\r\n"
				+ "`student_name`,\r\n"
				+ "`student_sex`,\r\n"
				+ "`student_age`,\r\n"
				+ "`student_major`,\r\n"
				+ "`student_grade`)\r\n"
				+ "VALUES('"
				+ student.getStuNo() + "','"
				+ student.getName() + "','"
				+ student.getGender() + "','"
				+ student.getAge() + "','"
				+ student.getMajor() + "','"
				+ student.getGrade() + "')";
		//定义数据库的连接
		Connection conn = null;
		try {
			//获取数据库的连接，通过这个连接操作数据库
			conn = DriverManager.getConnection(studentdbPath,userName,password);
			//获取一个语句对象，它用来执行SQL语句
			Statement st = conn.createStatement();
			//由语句对象对象执行SQL语句
			st.execute(sql);
            //st.getLargeUpdateCount()获取执行SQL语句影响的行数
			if(st.getLargeUpdateCount() == 1) {   
				result = true;
			};			
		} catch (SQLException e) {
			result = false;
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}		
		return result;		
	}
	/**
	 * 按Id查询一名学生
	 * @param id   是查询学生的id
	 * @return  返回查询到的学生信息，如果不处在则返回null;
	 * @throws SQLException 不能正常关闭数据库时抛出SQLException异常
	 */
	public Student getStudentById(int id) throws SQLException {
		//要返回的结果变量
		Student student = null;
		//查询一名学生的SQL语句字符串
		String sql = "SELECT `student`.`id`,\r\n"
				+ "    `student`.`student_no`,\r\n"
				+ "    `student`.`student_name`,\r\n"
				+ "    `student`.`student_sex`,\r\n"
				+ "    `student`.`student_age`,\r\n"
				+ "    `student`.`student_major`,\r\n"
				+ "    `student`.`student_grade`\r\n"
				+ "FROM `studentdb`.`student`\r\n"
				+ "WHERE `student`.`id`=" + id;
		//定义数据库的连接
		Connection conn = null;		
		try {
			//获取数据库的连接，通过这个连接操作数据库
			conn = DriverManager.getConnection(studentdbPath,userName,password);
			//获取一个语句对象，它用来执行SQL语句
			Statement st = conn.createStatement();
			//由语句对象对象执行SQL语句，返回查询结果集
			ResultSet rt = st.executeQuery(sql);
            //取结果集中的第一行
			if(rt.next()) {
   				student = new Student();
                //从当前行读取id列的值，并设置到student对象中
   				student.setId(rt.getInt("id")); 
                //从当前行读取student_no列的值，并设置到student对象中
   				student.setStuNo(rt.getString("student_no"));
                //从当前行读取student_name列的值，并设置到student对象中
   				student.setName(rt.getString("student_name"));
   				//从当前行读取student_sex列的值，并设置到student对象中     
   				student.setGender(rt.getString("student_sex"));
                //从当前行读取student_age列的值，并设置到student对象中 
   				student.setAge(rt.getString("student_age"));
                //从当前行读取student_major列的值，并设置到student对象中   
   				student.setMajor(rt.getString("student_major"));
   				//从当前行读取student_gander列的值，并设置到student对象中   
   				student.setGrade(rt.getString("student_grade"));
			}
		} catch (SQLException e) {
			//发生异常时要输出的信息
			System.out.println("查询失败，发生了：" + e.getMessage());
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
		return student;
	}
	/**
	 * 杜国旭
	 * 按学号查询一本书
	 * @param no   是查询学生的no
	 * @return  返回询到的学生，如果不处在则返回null;
	 * @throws SQLException 不能正常关闭数据库时抛出SQLException异常
	 */
	public Student getStudentByNo(String no){
		//要返回的结果变量
		Student student = null;
		//查询一本书的SQL语句字符串
		String sql = "SELECT `student`.`id`,\r\n"
				+ "    `student`.`student_no`,\r\n"
				+ "    `student`.`student_name`,\r\n"
				+ "    `student`.`student_sex`,\r\n"
				+ "    `student`.`student_age`,\r\n"
				+ "    `student`.`student_major`,\r\n"
				+ "    `student`.`student_grade`\r\n"
				+ "FROM `studentdb`.`student`\r\n"
				+ "WHERE `student`.`student_no`='" + no + "'";
		//定义数据库的连接
		Connection conn = null;		
		try {
			//获取数据库的连接，通过这个连接操作数据库
			conn = DriverManager.getConnection(studentdbPath,userName,password);
			//获取一个语句对象，它用来执行SQL语句
			Statement st = conn.createStatement();
			//由语句对象对象执行SQL语句，返回查询结果集
			ResultSet rt = st.executeQuery(sql);
            //取结果集中的第一行
			if(rt.next()) {  
				student = new Student();
                //从当前行读取id列的值，并设置到student对象中
   				student.setId(rt.getInt("id")); 
                //从当前行读取student_no列的值，并设置到student对象中
   				student.setStuNo(rt.getString("student_no"));
                //从当前行读取student_name列的值，并设置到student对象中
   				student.setName(rt.getString("student_name"));
   				//从当前行读取student_sex列的值，并设置到student对象中     
   				student.setGender(rt.getString("student_sex"));
                //从当前行读取student_age列的值，并设置到student对象中 
   				student.setAge(rt.getString("student_age"));
                //从当前行读取student_major列的值，并设置到student对象中   
   				student.setMajor(rt.getString("student_major"));
   				//从当前行读取student_gander列的值，并设置到student对象中   
   				student.setGrade(rt.getString("student_grade"));
			}
		} catch (SQLException e) {
			//发生异常时要输出的信息
			System.out.println("查询失败，发生了：" + e.getMessage());
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
		return student;
	}
	/**
	 * 田鹏雷
	 * 按书名查询一本书
	 * @param name   是查询书的书名
	 * @return  返回询到的书列表;
	 * @throws SQLException 不能正常关闭数据库时抛出SQLException异常
	 */
	public List<Student> getStudentByName(String name){
		//返回的结果变量
		List<Student> list = new ArrayList<Student>();
		//查询多本书的SQL语句字符串，LIKE实现模糊查询
		String sql = "SELECT `student`.`id`,\r\n"
				+ "    `student`.`student_no`,\r\n"
				+ "    `student`.`student_name`,\r\n"
				+ "    `student`.`student_sex`,\r\n"
				+ "    `student`.`student_age`,\r\n"
				+ "    `student`.`student_major`,\r\n"
				+ "    `student`.`student_grade`\r\n"
				+ "FROM `studentdb`.`student`\r\n"
				+ "WHERE `student`.`student_name` LIKE '%" + name + "%'";
		//定义数据库的连接
		Connection conn = null;	
		try {
			//获取数据库的连接，通过这个连接操作数据库
			conn = DriverManager.getConnection(studentdbPath,userName,password);
			//获取一个语句对象，它用来执行SQL语句
			Statement st = conn.createStatement();
			//由语句对象对象执行SQL语句，返回查询结果集
			ResultSet rt = st.executeQuery(sql);
			while(rt.next()) {   //取结果集中的每一行
				Student student = new Student();
                //从当前行读取id列的值，并设置到student对象中
   				student.setId(rt.getInt("id")); 
                //从当前行读取student_no列的值，并设置到student对象中
   				student.setStuNo(rt.getString("student_no"));
                //从当前行读取student_name列的值，并设置到student对象中
   				student.setName(rt.getString("student_name"));
   				//从当前行读取student_sex列的值，并设置到student对象中     
   				student.setGender(rt.getString("student_sex"));
                //从当前行读取student_age列的值，并设置到student对象中 
   				student.setAge(rt.getString("student_age"));
                //从当前行读取student_major列的值，并设置到student对象中   
   				student.setMajor(rt.getString("student_major"));
   				//从当前行读取student_gander列的值，并设置到student对象中   
   				student.setGrade(rt.getString("student_grade"));
                //把当前的这本书添加到列表中
				list.add(student);
			}
		} catch (SQLException e) {
			//发生异常时要输出的信息
			System.out.println("查询失败，发生了：" + e.getMessage());
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	/**
	 * 杨毅龙
	 * 查询所有的学生
	 * @return  返回询到的学生列表;
	 * @throws SQLException 不能正常关闭数据库时抛出SQLException异常
	 */
	public List<Student> getAllStudent(){
		//返回的结果变量
		List<Student> list = new ArrayList<Student>();
		//查询全部图书的SQL语句字符串，没有WHERE子句
		String sql = "SELECT `student`.`id`,\r\n"
				+ "    `student`.`student_no`,\r\n"
				+ "    `student`.`student_name`,\r\n"
				+ "    `student`.`student_sex`,\r\n"
				+ "    `student`.`student_age`,\r\n"
				+ "    `student`.`student_major`,\r\n"
				+ "    `student`.`student_grade`\r\n"
				+ "FROM `studentdb`.`student`\r\n";
		//定义数据库的连接
		Connection conn = null;	
		try {
			//获取数据库的连接，通过这个连接操作数据库
			conn = DriverManager.getConnection(studentdbPath,userName,password);
			//获取一个语句对象，它用来执行SQL语句
			Statement st = conn.createStatement();
			//由语句对象对象执行SQL语句，返回查询结果集
			ResultSet rt = st.executeQuery(sql);
			while(rt.next()) {   //取结果集中的每一行
				Student student = new Student();
                //从当前行读取id列的值，并设置到student对象中
   				student.setId(rt.getInt("id")); 
                //从当前行读取student_no列的值，并设置到student对象中
   				student.setStuNo(rt.getString("student_no"));
                //从当前行读取student_name列的值，并设置到student对象中
   				student.setName(rt.getString("student_name"));
   				//从当前行读取student_sex列的值，并设置到student对象中     
   				student.setGender(rt.getString("student_sex"));
                //从当前行读取student_age列的值，并设置到student对象中 
   				student.setAge(rt.getString("student_age"));
                //从当前行读取student_major列的值，并设置到student对象中   
   				student.setMajor(rt.getString("student_major"));
   				//从当前行读取student_gander列的值，并设置到student对象中   
   				student.setGrade(rt.getString("student_grade"));
                //把当前的这本书添加到列表中
				list.add(student);
			}
		} catch (SQLException e) {
			//发生异常时要输出的信息
			System.out.println("查询失败，发生了：" + e.getMessage());
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
		return list;		
	}
	/**
	 * 聂帅
	 * 修改一本书，将已经修改完的学生的信息通过student传过来
	 * @param book 要修改书的修改后的内容（id不变）
	 * @return  boolean值，true为修改成功、false为修改不成功
	 * @throws SQLException 不能正常关闭数据库时抛出SQLException异常
	 */	
	public boolean modifyStudent(Student student){
		//返回的结果变量
		boolean result = false;
		//修改图书的SQL语句字符串
		String sql = "UPDATE `studentdb`.`student`\r\n"
				+ "SET\r\n"
				+ "`student_no` = '" + student.getStuNo() + "',\r\n"
				+ "`student_name` = '" + student.getName() + "',\r\n"
				+ "`student_sex` = '" + student.getGender() + "',\r\n"
				+ "`student_age` = '" + student.getAge() +"',\r\n"
				+ "`student_major` = '" + student.getMajor() +"',\r\n"
				+ "`student_grade` = '" + student.getGrade() + "'\r\n"
				+ "WHERE `id` = " + student.getId();
		//定义数据库的连接
		Connection conn = null;
		try {
			//获取数据库的连接，通过这个连接操作数据库
			conn = DriverManager.getConnection(studentdbPath,userName,password);
			//获取一个语句对象，它用来执行SQL语句
			Statement st = conn.createStatement();
			
			//由语句对象对象执行SQL语句，返回查询结果集
			st.execute(sql);
            //st.getLargeUpdateCount()获取执行SQL语句影响的行数
			if(st.getLargeUpdateCount() == 1) {   
				result = true;
			};
		} catch (SQLException e) {
			//发生异常时要输出的信息
			System.out.println("修改失败，发生了：" + e.getMessage());
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return result;
	}
	/**
	 * 李杨
	 * 删除指定ISBN的一本书
	 * @param isbn  要删除书的ISBN
	 * @return  boolean值，true为删除成功、false为删除不成功
	 * @throws SQLException 不能正常关闭数据库时抛出SQLException异常
	 */
	public boolean removeStudentByNo(String no){
		//返回的结果变量
		boolean result = false;
		//删除图书的SQL语句字符串
		String sql = "DELETE FROM `studentdb`.`student`\r\n"
				+ "WHERE student_no = " + "'" + no + "'";
		//定义数据库的连接
		Connection conn = null;
		try {
			//获取数据库的连接，通过这个连接操作数据库
			conn = DriverManager.getConnection(studentdbPath,userName,password);
			//获取一个语句对象，它用来执行SQL语句
			Statement st = conn.createStatement();
			//由语句对象对象执行SQL语句，返回查询结果集
			st.execute(sql);
//st.getLargeUpdateCount()获取执行SQL语句影响的行数
			if(st.getLargeUpdateCount() == 1) {   
				result = true;
			};
		} catch (SQLException e) {
			//发生异常时要输出的信息
			System.out.println("删除失败，发生了：" + e.getMessage());
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}		
		return result;
	}
}
