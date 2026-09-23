package HospitalManagement;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final List<Patient> patients = new ArrayList<>();
    private static final List<Doctor> doctors = new ArrayList<>();
    private static final List<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1: addPatient(); break;
                case 2: addDoctor(); break;
                case 3: bookAppointment(); break;
                case 4: printAll("Patients List:", patients); break;
                case 5: printAll("Doctors List:", doctors); break;
                case 6: printAll("Appointments List:", appointments); break;
                case 7: searchDoctorsBySpeciality(); break;
                case 8: cancelAppointment(); break;
                case 9: running = false; break;
                default: System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Exiting system. Thank you!");
        sc.close();
    }

    // ---------- Menu ----------

    private static void printMenu() {
        System.out.println("\n---- Hospital Management System ----");
        System.out.println("1. Add Patient");
        System.out.println("2. Add Doctor");
        System.out.println("3. Book Appointment");
        System.out.println("4. View Patients");
        System.out.println("5. View Doctors");
        System.out.println("6. View Appointments");
        System.out.println("7. Search Doctors by Speciality");
        System.out.println("8. Cancel Appointment");
        System.out.println("9. Exit");
    }

    // ---------- Features ----------

    private static void addPatient() {
        String name = readText("Enter patient name: ");
        String gender = readText("Enter patient gender: ");
        int age = readIntInRange("Enter patient age: ", 0, 120);

        patients.add(new Patient(name, gender, age));
        System.out.println("Patient added successfully!");
    }

    private static void addDoctor() {
        String name = readText("Enter doctor name: ");
        String speciality = readText("Enter doctor speciality: ");

        doctors.add(new Doctor(name, speciality));
        System.out.println("Doctor added successfully!");
    }

    private static void bookAppointment() {
        if (patients.isEmpty() || doctors.isEmpty()) {
            System.out.println("Add at least one patient and one doctor first!");
            return;
        }

        Patient patient = choosePatient();
        Doctor doctor = chooseDoctor();
        LocalDate date = readFutureDate("Enter appointment date (yyyy-MM-dd): ");

        if (isDoctorBusy(doctor, date)) {
            System.out.println("Dr. " + doctor.getName() + " already has an appointment on " + date + ".");
            return;
        }

        appointments.add(new Appointment(patient, doctor, date));
        System.out.println("Appointment booked successfully!");
    }

    private static void cancelAppointment() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments to cancel.");
            return;
        }

        printAll("Appointments List:", appointments);
        int id = readInt("Enter appointment ID to cancel: ");

        boolean removed = appointments.removeIf(a -> a.getId() == id);
        System.out.println(removed ? "Appointment cancelled." : "No appointment found with ID " + id + ".");
    }

    private static void searchDoctorsBySpeciality() {
        String keyword = readText("Enter speciality to search: ").toLowerCase();
        boolean found = false;

        for (Doctor d : doctors) {
            if (d.getSpeciality().toLowerCase().contains(keyword)) {
                System.out.println(d);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No doctor found for that speciality.");
        }
    }

    // ---------- Helpers ----------

    private static Patient choosePatient() {
        System.out.println("Available Patients:");
        for (int i = 0; i < patients.size(); i++) {
            System.out.println((i + 1) + ". " + patients.get(i));
        }
        int number = readIntInRange("Select patient number: ", 1, patients.size());
        return patients.get(number - 1);
    }

    private static Doctor chooseDoctor() {
        System.out.println("Available Doctors:");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println((i + 1) + ". " + doctors.get(i));
        }
        int number = readIntInRange("Select doctor number: ", 1, doctors.size());
        return doctors.get(number - 1);
    }

    private static boolean isDoctorBusy(Doctor doctor, LocalDate date) {
        for (Appointment a : appointments) {
            if (a.getDoctor().getId() == doctor.getId() && a.getDate().equals(date)) {
                return true;
            }
        }
        return false;
    }

    private static <T> void printAll(String title, List<T> list) {
        System.out.println(title);
        if (list.isEmpty()) {
            System.out.println("  (nothing here yet)");
            return;
        }
        for (T item : list) {
            System.out.println("  " + item);
        }
    }

    // ---------- Safe input methods ----------

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static int readIntInRange(String message, int min, int max) {
        while (true) {
            int value = readInt(message);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Please enter a number between " + min + " and " + max + ".");
        }
    }

    private static String readText(String message) {
        while (true) {
            System.out.print(message);
            String text = sc.nextLine().trim();
            if (!text.isEmpty()) {
                return text;
            }
            System.out.println("This field cannot be empty.");
        }
    }

    private static LocalDate readFutureDate(String message) {
        while (true) {
            System.out.print(message);
            try {
                LocalDate date = LocalDate.parse(sc.nextLine().trim());
                if (date.isBefore(LocalDate.now())) {
                    System.out.println("Date cannot be in the past.");
                } else {
                    return date;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date. Use format yyyy-MM-dd (e.g., 2026-10-05).");
            }
        }
    }
}
