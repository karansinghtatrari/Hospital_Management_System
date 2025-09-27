package HospitalManagement;
public class Patient {
	private static int IdCounter=1;
	private int Id;
	private String name;
	private String gender;
	private int age;
	
	public Patient(String name,String gender,int age) {
		this.Id=IdCounter++;
		this.name=name;
		this.gender=gender;
		this.age=age;
	}
	
	public String toString() {
		return "Patient ID:"+Id+", Name:"+name+",Gender:"+gender+",Age:"+age;
	}
	public int getId() {
		return Id;
	}
	public String getname() {
		return name;         
	}
	public int getage() {
		return age;
	}
}  
