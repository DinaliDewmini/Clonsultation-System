import java.io.*;
import java.time.LocalDate;
import java.util.*;
public class WestminsterSkinConsultationManager {
    public static Scanner scanner = new Scanner(System.in);

    /**
     * making a arraylist for doctors
     */

    public static ArrayList<Doctor> Doctors = new ArrayList<>();
    public static void main(String[] args) {

        while (true) {
            System.out.println("""
                            
                            
                            --------------OPTIONS-------------
               
                    Add a new doctor                            --> 01
                    Delete a doctor                             --> 02
                    Print the list of the doctors               --> 03
                    Save all the information into a text file   --> 04
                    Read all the information from text file     --> 05
                    Load all the information from text file     --> 06
                    Load GUI                                    --> 07
                    Exit from the program                       --> 00
                    
                    
                    
                    """);
            System.out.println("Enter a option number :");
            String option = scanner.nextLine();
            switch (option) {
                case "01", "1" -> AddNewDoctor();
                case "02", "2" -> DeleteADoctor();
                case "03", "3" -> PrintDoctorList();
                case "04", "4" -> SaveInformation();
                case "05", "5" -> ReadInformation();
                case "06", "6" -> LoadData();
                case "07", "7" -> new MainFrame();
                case "00", "0" -> System.exit(0);
            }
        }
    }


    /**
     * adding doctor details to structure
     */

    public static String DoctorsDetails(){
        String run= "stop";
        for (Doctor doctor : Doctors){
            run  = "start";
            System.out.println("Name of the doctor       : " + doctor.getName());
            System.out.println("Surname of the doctor    : " + doctor.getSurname());
            System.out.println("Mobile number            : " + doctor.getMno());
            System.out.println("Date of Birth            : " + doctor.getDOB());
            System.out.println("Specialisation           : " + doctor.getSpec());
            System.out.println("License Number           : " + doctor.getLicensenumber());
        }
        return run;
    }


    /**
     * Add a new doctor to the list
     */

    public static void AddNewDoctor() {
        System.out.println("----------------Enter Details---------------");
        System.out.println("Add the name of the doctor:");
        String Name = scanner.nextLine();
        System.out.println("Add the surname of the doctor:");
        String Surname = scanner.nextLine();
        System.out.println("Add the medical licence number of the doctor :");
        String Licensenumber = scanner.nextLine();
        System.out.println("Add the specialization of the doctor:");
        String Spec = scanner.nextLine();
        System.out.println("Add the mobile number:");
        String Mno = scanner.nextLine();
        LocalDate DOB;
        try {
            System.out.println("Add the date of birth  (yyyy-mm-dd) :");
            DOB = LocalDate.parse(scanner.next());
        } catch (Exception e){
            System.out.println("Add a valid date of birth  (yyyy-mm-dd)/(2004-01-19) :");   //getting valid date of birth again if user inputs wrong format
            DOB = LocalDate.parse(scanner.next());
        }
        Doctors.add(new Doctor(Name, Surname, DOB, Mno, Licensenumber, Spec));
    }



    /**
     * delete a doctor from a list
     */

    public static void DeleteADoctor() {
        System.out.println("Delete Doctors from list");
        if (DoctorsDetails().equals("start")){
            System.out.println("\n Enter the medical License that you want to remove :");
            String LNODelete = scanner.next();
            for (int x = 0 ; x < Doctors.size(); x++){
                if (LNODelete.equals(Doctors.get(x).getLicensenumber())){
                    System.out.println("\n----------List of Details of Erasing Doctor----------\n\n");
                    System.out.println("Name of the doctor       : " + Doctors.get(x).getName());
                    System.out.println("Surname of the doctor    : " + Doctors.get(x).getSurname());
                    System.out.println("Mobile number            : " + Doctors.get(x).getMno());
                    System.out.println("Date of Birth            : " + Doctors.get(x).getDOB());
                    System.out.println("Specialisation           : " + Doctors.get(x).getSpec());
                    System.out.println("License Number           : " + Doctors.get(x).getLicensenumber());


                    Doctors.remove(x);
                    if (Doctors.size() == 1){
                        System.out.println("doctors details are removed from the list");

                        /**
                         * shows the remaining doctors list
                         */


                        System.out.println("\t\tThere is one doctor on the List");
                        DoctorsDetails();
                    } else if (Doctors.size() > 1) {
                        System.out.println("Doctor details are successfully removed from the list");
                        System.out.println("There are " + Doctors.size() + " Doctors exists now ");
                        DoctorsDetails();
                    }else {
                        System.out.println("doctors details are removed from the list\n");


                        //validating that there are no more doctors to remove



                        System.out.println("There are no any Doctors available at the moment !!!! ");
                    }

                }else {
                    System.out.println("There is no Doctor with this License Number !!!! ");
                }
            }
        }else {
            System.out.println("Can't Find any Doctor details !!!!");
        }
    }


    /**
     * save information into a text file
     */

    private static void SaveInformation() {
        try {
            FileWriter text = new FileWriter("Doctors.txt");
            for (Doctor doctor : Doctors){
                text.write(doctor.getName() + "\n" + doctor.getSurname() + "\n" + doctor.getDOB() + "\n" + doctor.getMno() + "\n" + doctor.getLicensenumber() + "\n" + doctor.getSpec() + "\n\n");

            }
            System.out.println("  data successfully entered :) ");
            text.close();

        }catch (IOException e){
            System.out.println("oops! Something went wrong  :( ");
        }

    }


    /**
     * print doctors arraylist
     */

    private static void PrintDoctorList() {
        for (Doctor doctor : Doctors) {
            System.out.println(doctor);
        }
    }


    /**
     * read information from the file
     */

    private static void ReadInformation() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Doctors.txt"));
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();
            } catch (IOException ex) {
                System.out.println("oops! Something went wrong  :( ");
                ex.printStackTrace();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("oops! Something went wrong  :( ");

        }

    }


    /**
     * load data from the file
     */

    private static void LoadData() {
        try {
            String tempdetails;
            ArrayList<String> TArray = new ArrayList<>();
            BufferedReader tempread = new BufferedReader(new FileReader("Doctors.txt"));
            while ((tempdetails = tempread.readLine()) != null) {
                if (tempdetails.equals("")) {
                    continue;
                } else {
                    TArray.add(tempdetails);
                }
            }
            for (int x = 0; x <= (TArray.size() / 6); x++) {
                if (Doctors.size() == 0) {
                    Doctors.add(new Doctor(TArray.get(0), TArray.get(1), LocalDate.parse(TArray.get(2)), TArray.get(3), TArray.get(4), TArray.get(5)));
                    TArray.subList(0, 6).clear();
                } else {
                    if (Doctors.size() <= 10) {
                        boolean read = true;
                        for (int y = 0; y <= (TArray.size() / 6); y++) {
                            for (Doctor doctor : Doctors) {
                                if (doctor.getLicensenumber().equals(TArray.get(4))) {
                                    read = false;
                                    TArray.subList(0, 6).clear();
                                } else {
                                    read = true;
                                }
                            }
                        }
                        if (read) {
                            Doctors.add(new Doctor(TArray.get(0), TArray.get(1), LocalDate.parse(TArray.get(2)), TArray.get(3), TArray.get(4), TArray.get(5)));
                            TArray.subList(0, 6).clear();
                        }
                    } else {
                        break;
                    }
                }
            }
            System.out.println("Loaded data successfully");
            tempread.close();
        } catch (IOException e) {
            System.out.println("No previous data found !!!!");  //validating that there is no data in the list
        }

    }


}
