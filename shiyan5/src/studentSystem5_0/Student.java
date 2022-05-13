package studentSystem5_0;

/**
 * 学生类，可以实现对信息的增删改查
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
	 * @param id 要设置的 id
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
			str = "学号输入有误，请重新输入！";
		}finally{
			if(stuNo.length()==11&flagNo==1) {
				this.stuNo = stuNo;//
				str = "添加成功！";
			}else if(stuNo.length()!=11&flagNo==1){
				flagNo=0;
				str = "学号长度输入有误，请重新输入！";
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
			str5 = "姓名不可为空！";
		}else {
			str5 = "添加成功！";
			this.name = name;
		}
		return str5;
	}
	
	
	public String getGender() {
		return gender;
	}
	public String setGender(String gender) {
		String str3 = "";
		if(gender.equals("男")||gender.equals("女")) {//
			this.gender = gender;//
			str3 = "添加成功！";
		}else {//
			str3 = "性别输入有误，只可为男或女！";//
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
			str4 = "添加成功！";
		}catch(Exception e) {//
			str4 = "年龄输入有误，必须为纯数字！";//
		}
		return str4;
	}
}
