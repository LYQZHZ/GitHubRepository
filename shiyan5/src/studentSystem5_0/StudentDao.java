package studentSystem5_0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//ҵ��㣬����ʵ�����ݿⷽ�������ɾ���ģ���
public class StudentDao {
	public String studentdbPath = "jdbc:mysql://localhost:3306/studentdb";//���ݿ�ĵ�ַ
	public String userName = "root";//���ݿ��û���
	public String password = "121519";//���ݿ�����
/**
 * ������
	 * �����ݿ������һ��ѧ��
	 * @param student   student�Ķ���
	 * @return  booleanֵ��trueΪ��ӳɹ���falseΪ��Ӳ��ɹ�
	 * @throws SQLException  ���������ر����ݿ�ʱ�׳�SQLException�쳣
	 */
	public boolean addStudent(Student student){//
		//Ҫ���صĽ������
		boolean result = false;
		//����һ�����SQL����ַ���
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
		//�������ݿ������
		Connection conn = null;
		try {
			//��ȡ���ݿ�����ӣ�ͨ��������Ӳ������ݿ�
			conn = DriverManager.getConnection(studentdbPath,userName,password);
			//��ȡһ��������������ִ��SQL���
			Statement st = conn.createStatement();
			//�����������ִ��SQL���
			st.execute(sql);
            //st.getLargeUpdateCount()��ȡִ��SQL���Ӱ�������
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
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}		
		return result;		
	}
	/**
	 * ��Id��ѯһ��ѧ��
	 * @param id   �ǲ�ѯѧ����id
	 * @return  ���ز�ѯ����ѧ����Ϣ������������򷵻�null;
	 * @throws SQLException ���������ر����ݿ�ʱ�׳�SQLException�쳣
	 */
	public Student getStudentById(int id) throws SQLException {
		//Ҫ���صĽ������
		Student student = null;
		//��ѯһ��ѧ����SQL����ַ���
		String sql = "SELECT `student`.`id`,\r\n"
				+ "    `student`.`student_no`,\r\n"
				+ "    `student`.`student_name`,\r\n"
				+ "    `student`.`student_sex`,\r\n"
				+ "    `student`.`student_age`,\r\n"
				+ "    `student`.`student_major`,\r\n"
				+ "    `student`.`student_grade`\r\n"
				+ "FROM `studentdb`.`student`\r\n"
				+ "WHERE `student`.`id`=" + id;
		//�������ݿ������
		Connection conn = null;		
		try {
			//��ȡ���ݿ�����ӣ�ͨ��������Ӳ������ݿ�
			conn = DriverManager.getConnection(studentdbPath,userName,password);
			//��ȡһ��������������ִ��SQL���
			Statement st = conn.createStatement();
			//�����������ִ��SQL��䣬���ز�ѯ�����
			ResultSet rt = st.executeQuery(sql);
            //ȡ������еĵ�һ��
			if(rt.next()) {
   				student = new Student();
                //�ӵ�ǰ�ж�ȡid�е�ֵ�������õ�student������
   				student.setId(rt.getInt("id")); 
                //�ӵ�ǰ�ж�ȡstudent_no�е�ֵ�������õ�student������
   				student.setStuNo(rt.getString("student_no"));
                //�ӵ�ǰ�ж�ȡstudent_name�е�ֵ�������õ�student������
   				student.setName(rt.getString("student_name"));
   				//�ӵ�ǰ�ж�ȡstudent_sex�е�ֵ�������õ�student������     
   				student.setGender(rt.getString("student_sex"));
                //�ӵ�ǰ�ж�ȡstudent_age�е�ֵ�������õ�student������ 
   				student.setAge(rt.getString("student_age"));
                //�ӵ�ǰ�ж�ȡstudent_major�е�ֵ�������õ�student������   
   				student.setMajor(rt.getString("student_major"));
   				//�ӵ�ǰ�ж�ȡstudent_gander�е�ֵ�������õ�student������   
   				student.setGrade(rt.getString("student_grade"));
			}
		} catch (SQLException e) {
			//�����쳣ʱҪ�������Ϣ
			System.out.println("��ѯʧ�ܣ������ˣ�" + e.getMessage());
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
		return student;
	}
	/**
	 * �Ź���
	 * ��ѧ�Ų�ѯһ����
	 * @param no   �ǲ�ѯѧ����no
	 * @return  ����ѯ����ѧ��������������򷵻�null;
	 * @throws SQLException ���������ر����ݿ�ʱ�׳�SQLException�쳣
	 */
	public Student getStudentByNo(String no){
		//Ҫ���صĽ������
		Student student = null;
		//��ѯһ�����SQL����ַ���
		String sql = "SELECT `student`.`id`,\r\n"
				+ "    `student`.`student_no`,\r\n"
				+ "    `student`.`student_name`,\r\n"
				+ "    `student`.`student_sex`,\r\n"
				+ "    `student`.`student_age`,\r\n"
				+ "    `student`.`student_major`,\r\n"
				+ "    `student`.`student_grade`\r\n"
				+ "FROM `studentdb`.`student`\r\n"
				+ "WHERE `student`.`student_no`='" + no + "'";
		//�������ݿ������
		Connection conn = null;		
		try {
			//��ȡ���ݿ�����ӣ�ͨ��������Ӳ������ݿ�
			conn = DriverManager.getConnection(studentdbPath,userName,password);
			//��ȡһ��������������ִ��SQL���
			Statement st = conn.createStatement();
			//�����������ִ��SQL��䣬���ز�ѯ�����
			ResultSet rt = st.executeQuery(sql);
            //ȡ������еĵ�һ��
			if(rt.next()) {  
				student = new Student();
                //�ӵ�ǰ�ж�ȡid�е�ֵ�������õ�student������
   				student.setId(rt.getInt("id")); 
                //�ӵ�ǰ�ж�ȡstudent_no�е�ֵ�������õ�student������
   				student.setStuNo(rt.getString("student_no"));
                //�ӵ�ǰ�ж�ȡstudent_name�е�ֵ�������õ�student������
   				student.setName(rt.getString("student_name"));
   				//�ӵ�ǰ�ж�ȡstudent_sex�е�ֵ�������õ�student������     
   				student.setGender(rt.getString("student_sex"));
                //�ӵ�ǰ�ж�ȡstudent_age�е�ֵ�������õ�student������ 
   				student.setAge(rt.getString("student_age"));
                //�ӵ�ǰ�ж�ȡstudent_major�е�ֵ�������õ�student������   
   				student.setMajor(rt.getString("student_major"));
   				//�ӵ�ǰ�ж�ȡstudent_gander�е�ֵ�������õ�student������   
   				student.setGrade(rt.getString("student_grade"));
			}
		} catch (SQLException e) {
			//�����쳣ʱҪ�������Ϣ
			System.out.println("��ѯʧ�ܣ������ˣ�" + e.getMessage());
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
		return student;
	}
	/**
	 * ������
	 * ��������ѯһ����
	 * @param name   �ǲ�ѯ�������
	 * @return  ����ѯ�������б�;
	 * @throws SQLException ���������ر����ݿ�ʱ�׳�SQLException�쳣
	 */
	public List<Student> getStudentByName(String name){
		//���صĽ������
		List<Student> list = new ArrayList<Student>();
		//��ѯ�౾���SQL����ַ�����LIKEʵ��ģ����ѯ
		String sql = "SELECT `student`.`id`,\r\n"
				+ "    `student`.`student_no`,\r\n"
				+ "    `student`.`student_name`,\r\n"
				+ "    `student`.`student_sex`,\r\n"
				+ "    `student`.`student_age`,\r\n"
				+ "    `student`.`student_major`,\r\n"
				+ "    `student`.`student_grade`\r\n"
				+ "FROM `studentdb`.`student`\r\n"
				+ "WHERE `student`.`student_name` LIKE '%" + name + "%'";
		//�������ݿ������
		Connection conn = null;	
		try {
			//��ȡ���ݿ�����ӣ�ͨ��������Ӳ������ݿ�
			conn = DriverManager.getConnection(studentdbPath,userName,password);
			//��ȡһ��������������ִ��SQL���
			Statement st = conn.createStatement();
			//�����������ִ��SQL��䣬���ز�ѯ�����
			ResultSet rt = st.executeQuery(sql);
			while(rt.next()) {   //ȡ������е�ÿһ��
				Student student = new Student();
                //�ӵ�ǰ�ж�ȡid�е�ֵ�������õ�student������
   				student.setId(rt.getInt("id")); 
                //�ӵ�ǰ�ж�ȡstudent_no�е�ֵ�������õ�student������
   				student.setStuNo(rt.getString("student_no"));
                //�ӵ�ǰ�ж�ȡstudent_name�е�ֵ�������õ�student������
   				student.setName(rt.getString("student_name"));
   				//�ӵ�ǰ�ж�ȡstudent_sex�е�ֵ�������õ�student������     
   				student.setGender(rt.getString("student_sex"));
                //�ӵ�ǰ�ж�ȡstudent_age�е�ֵ�������õ�student������ 
   				student.setAge(rt.getString("student_age"));
                //�ӵ�ǰ�ж�ȡstudent_major�е�ֵ�������õ�student������   
   				student.setMajor(rt.getString("student_major"));
   				//�ӵ�ǰ�ж�ȡstudent_gander�е�ֵ�������õ�student������   
   				student.setGrade(rt.getString("student_grade"));
                //�ѵ�ǰ���Ȿ����ӵ��б���
				list.add(student);
			}
		} catch (SQLException e) {
			//�����쳣ʱҪ�������Ϣ
			System.out.println("��ѯʧ�ܣ������ˣ�" + e.getMessage());
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	/**
	 * ������
	 * ��ѯ���е�ѧ��
	 * @return  ����ѯ����ѧ���б�;
	 * @throws SQLException ���������ر����ݿ�ʱ�׳�SQLException�쳣
	 */
	public List<Student> getAllStudent(){
		//���صĽ������
		List<Student> list = new ArrayList<Student>();
		//��ѯȫ��ͼ���SQL����ַ�����û��WHERE�Ӿ�
		String sql = "SELECT `student`.`id`,\r\n"
				+ "    `student`.`student_no`,\r\n"
				+ "    `student`.`student_name`,\r\n"
				+ "    `student`.`student_sex`,\r\n"
				+ "    `student`.`student_age`,\r\n"
				+ "    `student`.`student_major`,\r\n"
				+ "    `student`.`student_grade`\r\n"
				+ "FROM `studentdb`.`student`\r\n";
		//�������ݿ������
		Connection conn = null;	
		try {
			//��ȡ���ݿ�����ӣ�ͨ��������Ӳ������ݿ�
			conn = DriverManager.getConnection(studentdbPath,userName,password);
			//��ȡһ��������������ִ��SQL���
			Statement st = conn.createStatement();
			//�����������ִ��SQL��䣬���ز�ѯ�����
			ResultSet rt = st.executeQuery(sql);
			while(rt.next()) {   //ȡ������е�ÿһ��
				Student student = new Student();
                //�ӵ�ǰ�ж�ȡid�е�ֵ�������õ�student������
   				student.setId(rt.getInt("id")); 
                //�ӵ�ǰ�ж�ȡstudent_no�е�ֵ�������õ�student������
   				student.setStuNo(rt.getString("student_no"));
                //�ӵ�ǰ�ж�ȡstudent_name�е�ֵ�������õ�student������
   				student.setName(rt.getString("student_name"));
   				//�ӵ�ǰ�ж�ȡstudent_sex�е�ֵ�������õ�student������     
   				student.setGender(rt.getString("student_sex"));
                //�ӵ�ǰ�ж�ȡstudent_age�е�ֵ�������õ�student������ 
   				student.setAge(rt.getString("student_age"));
                //�ӵ�ǰ�ж�ȡstudent_major�е�ֵ�������õ�student������   
   				student.setMajor(rt.getString("student_major"));
   				//�ӵ�ǰ�ж�ȡstudent_gander�е�ֵ�������õ�student������   
   				student.setGrade(rt.getString("student_grade"));
                //�ѵ�ǰ���Ȿ����ӵ��б���
				list.add(student);
			}
		} catch (SQLException e) {
			//�����쳣ʱҪ�������Ϣ
			System.out.println("��ѯʧ�ܣ������ˣ�" + e.getMessage());
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
		return list;		
	}
	/**
	 * ��˧
	 * �޸�һ���飬���Ѿ��޸����ѧ������Ϣͨ��student������
	 * @param book Ҫ�޸�����޸ĺ�����ݣ�id���䣩
	 * @return  booleanֵ��trueΪ�޸ĳɹ���falseΪ�޸Ĳ��ɹ�
	 * @throws SQLException ���������ر����ݿ�ʱ�׳�SQLException�쳣
	 */	
	public boolean modifyStudent(Student student){
		//���صĽ������
		boolean result = false;
		//�޸�ͼ���SQL����ַ���
		String sql = "UPDATE `studentdb`.`student`\r\n"
				+ "SET\r\n"
				+ "`student_no` = '" + student.getStuNo() + "',\r\n"
				+ "`student_name` = '" + student.getName() + "',\r\n"
				+ "`student_sex` = '" + student.getGender() + "',\r\n"
				+ "`student_age` = '" + student.getAge() +"',\r\n"
				+ "`student_major` = '" + student.getMajor() +"',\r\n"
				+ "`student_grade` = '" + student.getGrade() + "'\r\n"
				+ "WHERE `id` = " + student.getId();
		//�������ݿ������
		Connection conn = null;
		try {
			//��ȡ���ݿ�����ӣ�ͨ��������Ӳ������ݿ�
			conn = DriverManager.getConnection(studentdbPath,userName,password);
			//��ȡһ��������������ִ��SQL���
			Statement st = conn.createStatement();
			
			//�����������ִ��SQL��䣬���ز�ѯ�����
			st.execute(sql);
            //st.getLargeUpdateCount()��ȡִ��SQL���Ӱ�������
			if(st.getLargeUpdateCount() == 1) {   
				result = true;
			};
		} catch (SQLException e) {
			//�����쳣ʱҪ�������Ϣ
			System.out.println("�޸�ʧ�ܣ������ˣ�" + e.getMessage());
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
	 * ����
	 * ɾ��ָ��ISBN��һ����
	 * @param isbn  Ҫɾ�����ISBN
	 * @return  booleanֵ��trueΪɾ���ɹ���falseΪɾ�����ɹ�
	 * @throws SQLException ���������ر����ݿ�ʱ�׳�SQLException�쳣
	 */
	public boolean removeStudentByNo(String no){
		//���صĽ������
		boolean result = false;
		//ɾ��ͼ���SQL����ַ���
		String sql = "DELETE FROM `studentdb`.`student`\r\n"
				+ "WHERE student_no = " + "'" + no + "'";
		//�������ݿ������
		Connection conn = null;
		try {
			//��ȡ���ݿ�����ӣ�ͨ��������Ӳ������ݿ�
			conn = DriverManager.getConnection(studentdbPath,userName,password);
			//��ȡһ��������������ִ��SQL���
			Statement st = conn.createStatement();
			//�����������ִ��SQL��䣬���ز�ѯ�����
			st.execute(sql);
//st.getLargeUpdateCount()��ȡִ��SQL���Ӱ�������
			if(st.getLargeUpdateCount() == 1) {   
				result = true;
			};
		} catch (SQLException e) {
			//�����쳣ʱҪ�������Ϣ
			System.out.println("ɾ��ʧ�ܣ������ˣ�" + e.getMessage());
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}		
		return result;
	}
}
