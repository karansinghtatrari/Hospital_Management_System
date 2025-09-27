package HospitalManagement;

public class Doctor {
	private static int IdCounter=1;
	private int Id;
	private String name;
	private String speciality;
	
	public Doctor(String name,String speciality) {
		this.Id=IdCounter++;
		this.name=name;
		this.speciality=speciality;
	}
	
	public String toString() {
		return "Doctor ID:"+Id+", Name:"+name+",Speciality:"+speciality;
	}
	public int getId() {
		return Id;
	}
	public String getname() {
		return name;
	}
	public String getspeciality() {
		return speciality;
	}
}


