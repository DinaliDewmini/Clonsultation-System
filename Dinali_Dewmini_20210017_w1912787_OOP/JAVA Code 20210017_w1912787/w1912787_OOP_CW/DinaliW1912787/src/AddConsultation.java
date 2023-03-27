import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class AddConsultation extends JFrame{

    public static ArrayList<Consultation> consultations = new ArrayList();
    private String filename = null;
    public int spenttime;
    public int price;



    private final JButton PhotoBotton, AddBotton;
    private final  JTable table;
    private final JComboBox AddStartTimeH,AddEndTimeH,AddStartTimeM,AddEndTimeM,AddDoct;
    private JTextArea AddNote;
    private JLabel NameLable,SurNameLabel, DOBLabel,MobileLabel,AddNoteLabel, StartTimeLabel, EndTimeLabel, DOBlbl,PatientLabel,AddPhoto, ConsultationDateLabel,ConsultationDatesLabel,ConsultationDocLabel;
    private JTextField AddName,AddSurName,AddDOB,AddMobileNo,AddPatient,AddConsultationDates;
    private JCheckBox times;


    /**
     *Add consultation
     */

    public AddConsultation(MainFrame mainFrame) {

        String[] Columnname={"Name", "Surname", "Date of Birth", "Mobile Number", "Patient ID", "Specialisation","Amount"};
        ArrayList<Doctor> doctorArray = WestminsterSkinConsultationManager.Doctors;
        String[][] TwoDArray = new String[doctorArray.size()][Columnname.length];
        String[] consulIDA =new String[doctorArray.size()];

        for (int z = 0; z< doctorArray.size(); z++){
            consulIDA [z] = doctorArray.get(z).getLicensenumber();
        }
        /**
         *Add consultation frame
         */

        setSize(850,800);
        setResizable(true);
        setTitle("Add a new Consultation");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ImageIcon image =new ImageIcon( "healthcare.png");
        setIconImage(image.getImage());

        ImageIcon Images =new ImageIcon( "image.png");
        JLabel images =new JLabel();
        images.setIcon(Images);
        images.setBounds(55,285,800,700);

        /**
         *Add consultations table
         */

        table = new JTable();
        DefaultTableModel model = new DefaultTableModel(TwoDArray,Columnname);
        table.setModel(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(650,200));
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(scrollPane);
        add("North",panel);
        panel.setBackground(new Color(154, 210, 245));
        JPanel consulPanel= new JPanel();
        consulPanel.setPreferredSize(new Dimension(700,200));
        consulPanel.setLayout(null);
        consulPanel.setBackground(new Color(154, 210, 245));
        add(images);






        /**
         * *Getting user inputs for consultation
         */


        /**
         *Add name label
         */

        NameLable = new JLabel("Name:");
        NameLable.setBounds(70,75,100,20);
        AddName = new JTextField(1);
        AddName.setBounds(270,75,150,25);
        NameLable.setFont(new Font("Cinzel Black",Font.PLAIN,10));


        /**
         *Add surname label
         */

        SurNameLabel = new JLabel("SurName:");
        SurNameLabel.setBounds(70,105,100,20);
        AddSurName = new JTextField(1);
        AddSurName.setBounds(270,105,150,25);
        SurNameLabel.setFont(new Font("Cinzel Black",Font.PLAIN,10));

        /**
         *Checking is that first time of the consultation
         */

        times=new JCheckBox();
        times.setText("Is this your first consultation?");
        times.setBounds(100,10,230,45);
        times.setFont(new Font("Cinzel Black",Font.PLAIN,10));




        /**
         *Add mobile number label
         */

        MobileLabel = new JLabel("Mobile Number:");
        MobileLabel.setBounds(70,170,105,20);
        AddMobileNo = new JTextField(1);
        AddMobileNo.setBounds(270,170,150,25);
        MobileLabel.setFont(new Font("Cinzel Black",Font.PLAIN,10));

        /**
         *Add consultation start time label
         */

        StartTimeLabel = new JLabel("Start Time:");
        StartTimeLabel.setBounds(70,200,120,20);
        AddStartTimeH = new JComboBox(new String[] {"HH","07","08","09","10","11","12","13","14","15","16","17"});
        AddStartTimeH.setBounds(170,200,60,20);
        AddStartTimeM = new JComboBox(new String[] {"MIN","00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23",
                "24","25","26","27","28","29","30","31","32","33","34","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50",
                "51","52","53","54","55","56","57","58","59"});
        AddStartTimeM.setBounds(250,200,60,20);
        StartTimeLabel.setFont(new Font("Cinzel Black",Font.PLAIN,10));


        /**
         *Add consultation End time label
         */

        EndTimeLabel = new JLabel("End Time:");
        EndTimeLabel.setBounds(70,230,120,20);
        AddEndTimeH = new JComboBox(new String[] {"HH","07","08","09","10","11","12","13","14","15","16","17"});
        AddEndTimeH.setBounds(170,230,60,20);
        AddEndTimeM = new JComboBox(new String[] {"MIN","00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23",
                "24","25","26","27","28","29","30","31","32","33","34","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50",
                "51","52","53","54","55","56","57","58","59"});
        AddEndTimeM.setBounds(250,230,60,20);
        EndTimeLabel.setFont(new Font("Cinzel Black",Font.PLAIN,10));

        /**
         *Add date of birth label
         */

        DOBLabel = new JLabel("Date of Birth:");
        DOBLabel.setBounds(70,140,100,20);
        AddDOB = new JTextField(1);
        AddDOB.setBounds(270,140,150,25);
        DOBLabel.setFont(new Font("Cinzel Black",Font.PLAIN,10));

        DOBlbl = new JLabel("(YYYY-MM-DD)");
        DOBlbl.setBounds(75,150,100,20);
        DOBlbl.setFont(new Font("Cinzel Black",Font.PLAIN,10));

        /**
         *Add Select Doctor label
         */


        ConsultationDocLabel = new JLabel("Select Doctor :");
        ConsultationDocLabel.setBounds(70,320,120,20);
        AddDoct = new JComboBox(consulIDA);
        AddDoct.setBounds(270,320,100,20);
        ConsultationDocLabel.setFont(new Font("Cinzel Black",Font.PLAIN,10));

        /**
         *Add photo label
         */

        PhotoBotton = new JButton("Photo");
        PhotoBotton.setBounds(700,300,100,40);
        PhotoBotton.setBackground(new Color(165, 188, 201));
        AddPhoto = new JLabel();
        AddPhoto.setBounds(450,270,200,200);
        AddPhoto.setBackground(Color.WHITE);
        AddPhoto.setOpaque(true);


        /**
         *Add data label
         */

        AddBotton= new JButton("Add Data");
        AddBotton.setBounds(700,370,100,40);
        AddBotton.setBackground(new Color(165, 188, 201));


        /**
         *Add note label
         */



        AddNoteLabel = new JLabel("Enter a note here :");
        AddNoteLabel.setBounds(550,20,220,20);
        AddNote = new JTextArea();
        AddNote.setBounds(550,40,250,200);
        AddNoteLabel.setFont(new Font("Cinzel Black",Font.PLAIN,10));

        /**
         *Add patient ID label
         */

        PatientLabel = new JLabel("Patient ID :");
        PatientLabel.setBounds(70,260,120,20);
        AddPatient = new JTextField(1);
        AddPatient.setBounds(270,260,150,25);
        PatientLabel.setFont(new Font("Cinzel Black",Font.PLAIN,10));


        /**
         *Add consultation label
         */


        ConsultationDateLabel = new JLabel("9. Consultation Date :");
        ConsultationDateLabel.setBounds(70,290,150,20);
        ConsultationDateLabel.setFont(new Font("Cinzel Black",Font.PLAIN,10));
        ConsultationDatesLabel= new JLabel("(YYYY-MM-DD)");
        ConsultationDatesLabel.setBounds(75,300,120,20);
        AddConsultationDates = new JTextField(1);
        AddConsultationDates.setBounds(270,290,150,25);
        ConsultationDatesLabel.setFont(new Font("Cinzel Black",Font.PLAIN,10));


        /**
         * Action of the ADD button
         */

        AddBotton.addActionListener(e -> {

            System.out.println("data added");
            String name = AddName.getText();
            String surname = AddSurName.getText();
            LocalDate dob = LocalDate.parse(AddDOB.getText());
            String mobile = AddMobileNo.getText();
            String patientID = AddPatient.getText();
            String doctorID = (String)AddDoct.getSelectedItem();
            String stimeHours = (String)AddStartTimeH.getSelectedItem();
            String stimeMin = (String)AddStartTimeM.getSelectedItem();
            LocalTime startTime = LocalTime.parse(stimeHours+":"+stimeMin);
            System.out.println(startTime);
            String etimeHours = (String)AddEndTimeH.getSelectedItem();
            String etimeMin = (String)AddEndTimeM.getSelectedItem();
            LocalTime endTime = LocalTime.parse(etimeHours+":"+etimeMin);
            System.out.println(endTime);
            spenttime= (Integer.parseInt(etimeHours)-Integer.parseInt(stimeHours));
            LocalDate consulDate = LocalDate.parse(AddConsultationDates.getText());
            String note = AddNote.getText();
            consultations.add(new Consultation(name, surname, dob, mobile, patientID, startTime, endTime, consulDate,doctorID, note));
            saveData();
            System.out.println(consultations.get(0));

            int y=0;
            while (y<((doctorArray.size())-1)){
                if (consulIDA[y] == doctorID){
                    consulIDA[y]=consulIDA[y+1];};
                y++;
            }

            /**
             * Adding data about consultation to a table
             */

            String[] data ={AddName.getText(),AddSurName.getText(),AddDOB.getText(),AddMobileNo.getText(),AddPatient.getText(), (String) AddDoct.getSelectedItem(), String.valueOf("£"+amount())};
            model.addRow(data);

            PhotoBotton.addActionListener(e1 -> {
                try {
                    JFileChooser chooser = new JFileChooser();
                    chooser.showOpenDialog(null);
                    File photo = chooser.getSelectedFile();
                    AddPhoto.setIcon(new ImageIcon(photo.toString()));
                    filename = photo.getAbsolutePath();
                }catch (Exception ignored){}

                    this.dispose();

                });

        });

        /**
         * action of the back button
         * Going back to the main frame
         */
        JButton backbtn = new JButton("Back");
        backbtn.setBounds(700,430,100,40);
        backbtn.setBackground(new Color(165, 188, 201));
        backbtn.addActionListener(e -> {
            this.setVisible(false);
            mainFrame.visible();
        });


        /**
         * action of the photo button
         * getting photo
         */

        PhotoBotton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","gif","png");
                file.addChoosableFileFilter(filter);
                int result = file.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION){
                    File selectedFile = file.getSelectedFile();
                    String path = selectedFile.getAbsolutePath();
                    AddPhoto.setIcon((Icon) ResizeImage(path));
                } else if (result == JFileChooser.CANCEL_OPTION) {
                    System.out.println("No file selected");
                }};
            public ImageIcon ResizeImage(String ImagePath){
                ImageIcon MyImage = new ImageIcon(ImagePath);
                Image image = MyImage.getImage();
                Image newImg = image.getScaledInstance(AddPhoto.getWidth(), AddPhoto.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imagess =new ImageIcon(newImg);
                return imagess;
            }


        });


        /**
         * add items to the consultation frame
         */


        consulPanel.add(AddBotton);
        consulPanel.add(ConsultationDocLabel);
        consulPanel.add(backbtn);
        consulPanel.add(AddDoct);
        consulPanel.add(NameLable);
        consulPanel.add(AddName);
        consulPanel.add(AddEndTimeH);
        consulPanel.add(DOBlbl);
        consulPanel.add(ConsultationDatesLabel);
        consulPanel.add(PatientLabel);
        consulPanel.add(AddPatient);
        consulPanel.add(AddPhoto);
        consulPanel.add(PhotoBotton);
        consulPanel.add(ConsultationDateLabel);
        consulPanel.add(AddConsultationDates);
        consulPanel.add(SurNameLabel);
        consulPanel.add(AddSurName);
        consulPanel.add(DOBLabel);
        consulPanel.add(AddDOB);
        consulPanel.add(MobileLabel);
        consulPanel.add(AddMobileNo);
        consulPanel.add(AddNoteLabel);
        consulPanel.add(AddNote);
        consulPanel.add(StartTimeLabel);
        consulPanel.add(EndTimeLabel);
        consulPanel.add(AddStartTimeH);
        consulPanel.add(times);
        consulPanel.add(AddStartTimeM);
        consulPanel.add(AddEndTimeM);
        consulPanel.setLayout(null);
        this.add("Center",consulPanel);
        this.setVisible(true);

    }



    /**
     * save data to a file
     */
    private void saveData() {
        try {
            BufferedWriter text = new BufferedWriter(new FileWriter("Consultation.txt"));
            for (Consultation consultation :consultations) {
                text.write(consultation.getName() + "\n" + consultation.getSurname() + "\n" + consultation.getDOB() + "\n" + consultation.getMno() + "\n" + "\n" + consultation.getConsulid() + "\n" + consultation.getId() + "\n" + consultation.getDate() + "\n" + consultation.getStime() + "\n" + consultation.getEtime() + "\n" + consultation.getNotes());
            }
            System.out.println("Data Stored Successfully in Consultation.txt File !!");
            text.close();
        } catch (IOException e) {
            System.out.println("Error in the System !!");
        }
    }

    /**
     * check the amount according to the consultation times that patient have
     */
    private int amount() {
        if (times .isSelected()) {
            price = spenttime * 15;
        }else {
            price = spenttime * 25;
        }
        return price;
    }



}



