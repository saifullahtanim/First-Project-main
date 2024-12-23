import java.util.ArrayList;
import java.util.Scanner;

class Donor {
    private String name;
    private int age;
    private String bloodGroup;
    private String contactNumber;
    private String address;

    public Donor(String name, int age, String bloodGroup, String contactNumber, String address) {
        this.name = name;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getAddress() {
        return address;
    }

    // Setters for updating donor information
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

class BloodBank {
    private ArrayList<Donor> donors;

    public BloodBank() {
        donors = new ArrayList<>();
    }

    public void addDonor(Donor donor) {
        donors.add(donor);
    }

    public ArrayList<Donor> searchDonors(String bloodGroup, String location) {
        ArrayList<Donor> result = new ArrayList<>();
        for (Donor donor : donors) {
            if (donor.getBloodGroup().equalsIgnoreCase(bloodGroup) && donor.getAddress().equalsIgnoreCase(location)) {
                result.add(donor);
            }
        }
        return result;
    }

    public boolean updateDonor(String name, Donor newDonorInfo) {
        for (Donor donor : donors) {
            if (donor.getName().equalsIgnoreCase(name)) {
                donor.setName(newDonorInfo.getName());
                donor.setAge(newDonorInfo.getAge());
                donor.setBloodGroup(newDonorInfo.getBloodGroup());
                donor.setContactNumber(newDonorInfo.getContactNumber());
                donor.setAddress(newDonorInfo.getAddress());
                return true;
            }
        }
        return false;
    }

    public boolean deleteDonor(String name) {
        for (Donor donor : donors) {
            if (donor.getName().equalsIgnoreCase(name)) {
                donors.remove(donor);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Donor> getAllDonors() {
        return donors;
    }

    public void clearAllDonors() {
        donors.clear();
    }
}

public class BloodBankManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BloodBank bloodBank = new BloodBank();

        // Login Page
        System.out.println("Blood Bank Management System");
        System.out.println("Login:");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.println("\nWelcome, Saifulla Tanim!");
        System.out.println("Department of Computer Science");

        // Menu
        while (true) {
            System.out.println("\nBlood Bank Management System");
            System.out.println("1. Add Donor");
            System.out.println("2. Search Donors");
            System.out.println("3. Update Donor Information");
            System.out.println("4. Delete Donor");
            System.out.println("5. Show all Donors");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("\nEnter Donor Details:");
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    System.out.print("Blood Group: ");
                    String bloodGroup = scanner.nextLine();
                    System.out.print("Contact Number: ");
                    String contactNumber = scanner.nextLine();
                    System.out.print("Address: ");
                    String address = scanner.nextLine();
                    bloodBank.addDonor(new Donor(name, age, bloodGroup, contactNumber, address));
                    System.out.println("Donor added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Blood Group: ");
                    String searchBloodGroup = scanner.nextLine();
                    System.out.print("Enter Location: ");
                    String searchLocation = scanner.nextLine();
                    ArrayList<Donor> searchResult = bloodBank.searchDonors(searchBloodGroup, searchLocation);
                    if (searchResult.isEmpty()) {
                        System.out.println("No donors found matching the criteria.");
                    } else {
                        System.out.println("Donors found:");
                        for (Donor donor : searchResult) {
                            System.out.println("Name: " + donor.getName() +
                                    ", Age: " + donor.getAge() +
                                    ", Blood Group: " + donor.getBloodGroup() +
                                    ", Contact Number: " + donor.getContactNumber() +
                                    ", Address: " + donor.getAddress());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter the name of the donor to update: ");
                    String updateName = scanner.nextLine();
                    System.out.println("Enter new details for the donor:");
                    System.out.print("Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Age: ");
                    int newAge = Integer.parseInt(scanner.nextLine());
                    System.out.print("Blood Group: ");
                    String newBloodGroup = scanner.nextLine();
                    System.out.print("Contact Number: ");
                    String newContactNumber = scanner.nextLine();
                    System.out.print("Address: ");
                    String newAddress = scanner.nextLine();
                    Donor newDonorInfo = new Donor(newName, newAge, newBloodGroup, newContactNumber, newAddress);
                    if (bloodBank.updateDonor(updateName, newDonorInfo)) {
                        System.out.println("Donor information updated successfully!");
                    } else {
                        System.out.println("Donor not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter the name of the donor to delete: ");
                    String deleteName = scanner.nextLine();
                    if (bloodBank.deleteDonor(deleteName)) {
                        System.out.println("Donor deleted successfully!");
                    } else {
                        System.out.println("Donor not found.");
                    }
                    break;

                case 5:
                    ArrayList<Donor> allDonors = bloodBank.getAllDonors();
                    if (allDonors.isEmpty()) {
                        System.out.println("No donors found in the blood bank.");
                    } else {
                        System.out.println("List of all donors:");
                        for (Donor donor : allDonors) {
                            System.out.println("Name: " + donor.getName() +
                                    ", Age: " + donor.getAge() +
                                    ", Blood Group: " + donor.getBloodGroup() +
                                    ", Contact Number: " + donor.getContactNumber() +
                                    ", Address: " + donor.getAddress());
                        }
                    }
                    break;

                case 6:
                    bloodBank.clearAllDonors();
                    System.out.println("All donor details deleted. Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
