package HospitalManagement;

public class Doctor {
    private static int idCounter = 1;

    private final int id;
    private final String name;
    private final String speciality;

    public Doctor(String name, String speciality) {
        this.id = idCounter++;
        this.name = name;
        this.speciality = speciality;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpeciality() {
        return speciality;
    }

    @Override
    public String toString() {
        return "Doctor ID: " + id + ", Name: " + name + ", Speciality: " + speciality;
    }
}
