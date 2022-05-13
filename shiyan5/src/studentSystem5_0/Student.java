package studentSystem5_0;

/**
 * ѧ���࣬����ʵ�ֶ���Ϣ����ɾ�Ĳ�
 * @author LYQ
 *
 */
public class Student {
	private Integer id;
	private String stuNo;
	private String name;
	private String gender;
	private String major;
	private String grade;
	private int age;
	int flagNo = 1;
	public Student() {
		
	}
	public static Student getStudent() {
		return new Student();
	}
	
	
	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id Ҫ���õ� id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStuNo() {
		return stuNo;
	}
	public String setStuNo(String stuNo) {
		String str = "";
		try {
			Long.parseLong(stuNo);
			flagNo=1;
		}catch(Exception e) {//
			flagNo=0;
			str = "ѧ�������������������룡";
		}finally{
			if(stuNo.length()==11&flagNo==1) {
				this.stuNo = stuNo;//
				str = "��ӳɹ���";
			}else if(stuNo.length()!=11&flagNo==1){
				flagNo=0;
				str = "ѧ�ų��������������������룡";
			}
		}
		return str;
	}
	
	
	public String getName() {
		return name;
	}
	public String setName(String name) {
		String str5 = "";
		if(name.trim().equals("")) {
			str5 = "��������Ϊ�գ�";
		}else {
			str5 = "��ӳɹ���";
			this.name = name;
		}
		return str5;
	}
	
	
	public String getGender() {
		return gender;
	}
	public String setGender(String gender) {
		String str3 = "";
		if(gender.equals("��")||gender.equals("Ů")) {//
			this.gender = gender;//
			str3 = "��ӳɹ���";
		}else {//
			str3 = "�Ա���������ֻ��Ϊ�л�Ů��";//
		}
		return str3;
	}
	
	
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	public String getAge() {
		return String.valueOf(age);
	}
	public String setAge(String age) {
		String str4 = "";
		try {//
			this.age = (Integer.parseInt(age));//
			str4 = "��ӳɹ���";
		}catch(Exception e) {//
			str4 = "�����������󣬱���Ϊ�����֣�";//
		}
		return str4;
	}
}
