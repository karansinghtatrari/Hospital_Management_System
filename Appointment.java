package HospitalManagement;

import java.time.LocalDate;

public class Appointment {
    private static int idCounter = 1;

    private final int id;
    private final Patient patient;
    private final Doctor doctor;
    private final LocalDate date;

    public Appointment(Patient patient, Doctor doctor, LocalDate date) {
        this.id = idCounter++;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Appointment ID: " + id
                + " | Patient: " + patient.getName() + " (ID " + patient.getId() + ")"
                + " | Doctor: " + doctor.getName() + " (" + doctor.getSpeciality() + ")"
                + " | Date: " + date;
    }
}
