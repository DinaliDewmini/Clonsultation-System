

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ViewDoctors extends JFrame {

    /**
     *making the doctors list
     */

    public ViewDoctors(MainFrame mainFrame, ArrayList<Doctor> doctors, boolean  sort) {
        String[] ColumnName ={"FirstName", "Surname", "Date of Birth", "Mobile Number", "License Number", "Specialization"};
        String[][] ViewDoctor= new String[WestminsterSkinConsultationManager.Doctors.size()][ColumnName.length];

        /**
         *sort doctors names
         */


        if (sort){
            for (int x = 0; x<WestminsterSkinConsultationManager.Doctors.size(); x++){
                for (int y = 0; y<ColumnName.length; y++){
                    if (y == 0){
                        ViewDoctor[x][y] = WestminsterSkinConsultationManager.Doctors.get(x).getName();
                    } else if (y == 1) {
                        ViewDoctor[x][y] = WestminsterSkinConsultationManager.Doctors.get(x).getSurname();
                    }else if (y == 2) {
                        ViewDoctor[x][y] = String.valueOf(WestminsterSkinConsultationManager.Doctors.get(x).getDOB());
                    }else if (y == 3) {
                        ViewDoctor[x][y] = WestminsterSkinConsultationManager.Doctors.get(x).getMno();
                    }else if (y == 4) {
                        ViewDoctor[x][y] = WestminsterSkinConsultationManager.Doctors.get(x).getLicensenumber();
                    }else{
                        ViewDoctor[x][y] = WestminsterSkinConsultationManager.Doctors.get(x).getSpec();
                    }
                }
            }
        }else {
            int size = WestminsterSkinConsultationManager.Doctors.size();
            String [] array = new String[size];
            for (int i = 0; i<size; i++){
                array[i] = WestminsterSkinConsultationManager.Doctors.get(i).getSurname();
            }
            Arrays.sort(array);
            for (int n = 0; n<array.length; n++){
                for (Doctor doctor : WestminsterSkinConsultationManager.Doctors) {
                    if (array[n].equals(doctor.getSurname())) {
                        for (int y = 0; y < ColumnName.length; y++) {
                            if (y == 0) {
                                ViewDoctor[n][y] = doctor.getName();
                            } else if (y == 1) {
                                ViewDoctor[n][y] = doctor.getSurname();
                            } else if (y == 2) {
                                ViewDoctor[n][y] = String.valueOf(doctor.getDOB());
                            } else if (y == 3) {
                                ViewDoctor[n][y] = doctor.getMno();
                            } else if (y == 4) {
                                ViewDoctor[n][y] = doctor.getLicensenumber();
                            } else {
                                ViewDoctor[n][y] = doctor.getSpec();
                            }
                        }
                    }
                }
            }
        }

        /**
         * make application icon
         */

        ImageIcon image =new ImageIcon( "healthcare.png");
        ImageIcon Images =new ImageIcon( "image.png");


        /**
         * making the frame
         */

        setSize(800,600);
        setResizable(false);
        setTitle("Available Doctors");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        getContentPane().setBackground(new Color(154, 210, 245));
        setIconImage(image.getImage());

        JLabel images =new JLabel();
        images.setIcon(Images);
        add(images);

        /**
         * set table
         */


        JTable Tbl = new JTable();
        TableModel model = new DefaultTableModel(ViewDoctor,ColumnName);
        Tbl.setModel(model);
        Tbl.setBackground(new Color(154, 210, 245));
        JScrollPane scrollPane = new JScrollPane(Tbl);
        scrollPane.setPreferredSize(new Dimension(750,300));
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(scrollPane);
        add("North",panel);
        panel.setBackground(new Color(154, 210, 245));

        /**
         * sorting button
         */

        JButton Sortbutton = new JButton("Sort");
        Sortbutton.setPreferredSize(new Dimension(100,40));
        Sortbutton.setFont(new Font("Cinzel Black",Font.PLAIN,15));
        Sortbutton.setBackground(new Color(165, 188, 201));
        Sortbutton.addActionListener(e -> {
            new ViewDoctors(mainFrame,doctors,false).setVisible(true);
            dispose();
        });
        add(Sortbutton);


        /**
         * back button
         * go to main frame
         */

        JButton BackButton = new JButton("Back");
        BackButton.setPreferredSize(new Dimension(100,40));
        BackButton.setFont(new Font("Cinzel Black",Font.PLAIN,15));
        BackButton.setBackground(new Color(165, 188, 201));
        BackButton.addActionListener(e -> {
            MainFrame.visible();
            dispose();
        });
        add(BackButton);

    }


}
