package HospitalManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Patient> patients = new ArrayList<>();
        ArrayList<Doctor> doctors = new ArrayList<>();
        ArrayList<Appointment> appointments = new ArrayList<>();

        while (true) {
            System.out.println("\n---- Hospital Management System ----");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Book Appointment");
            System.out.println("4. View Patients");
            System.out.println("5. View Doctors");
            System.out.println("6. View Appointments");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();  // consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String pname = sc.nextLine();
                    System.out.print("Enter patient gender: ");
                    String pgender = sc.nextLine();
                    System.out.print("Enter patient age: ");
                    int page = sc.nextInt();
                    sc.nextLine();
                    patients.add(new Patient(pname, pgender, page));
                    System.out.println("Patient added successfully!");
                    break;

                case 2:
                    System.out.print("Enter doctor name: ");
                    String dname = sc.nextLine();
                    System.out.print("Enter doctor speciality: ");
                    String dspeciality = sc.nextLine();
                    doctors.add(new Doctor(dname, dspeciality));
                    System.out.println("Doctor added successfully!");
                    break;

                case 3:
                    if (patients.isEmpty() || doctors.isEmpty()) {
                        System.out.println("Add at least one patient and one doctor first!");
                    } else {
                        System.out.println("Available Patients:");
                        for (int i = 0; i < patients.size(); i++) {
                            System.out.println((i + 1) + ". " + patients.get(i));
                        }
                        System.out.print("Select patient number: ");
                        int pindex = sc.nextInt() - 1;

                        System.out.println("Available Doctors:");
                        for (int i = 0; i < doctors.size(); i++) {
                            System.out.println((i + 1) + ". " + doctors.get(i));
                        }
                        System.out.print("Select doctor number: ");
                        int dindex = sc.nextInt() - 1;
                        sc.nextLine();

                        System.out.print("Enter appointment date (e.g., 2025-05-01): ");
                        String date = sc.nextLine();

                        appointments.add(new Appointment(patients.get(pindex), doctors.get(dindex), date));
                        System.out.println("Appointment booked successfully!");
                    }
                    break;

                case 4:
                    System.out.println("Patients List:");
                    for (Patient p : patients) {
                        System.out.println(p);
                    }
                    break;

                case 5:
                    System.out.println("Doctors List:");
                    for (Doctor d : doctors) {
                        System.out.println(d);
                    }
                    break;

                case 6:
                    System.out.println("Appointments List:");
                    for (Appointment a : appointments) {
                        System.out.println(a);
                    }
                    break;

                case 7:
                    System.out.println("Exiting system. Thank you!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
        










