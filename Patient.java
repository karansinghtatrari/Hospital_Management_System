package HospitalManagement;

public class Patient {
    private static int idCounter = 1;

    private final int id;
    private final String name;
    private final String gender;
    private final int age;

    public Patient(String name, String gender, int age) {
        this.id = idCounter++;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Patient ID: " + id + ", Name: " + name + ", Gender: " + gender + ", Age: " + age;
    }
}
	 
