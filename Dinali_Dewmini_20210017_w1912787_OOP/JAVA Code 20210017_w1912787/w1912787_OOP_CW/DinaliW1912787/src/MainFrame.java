import javax.swing.*;
import  javax.swing.ImageIcon;
import java.awt.*;

public class MainFrame extends JFrame  {

    static JFrame f;

    /**
     * main GUI frame of the code
     */

    public MainFrame(){

        /*
           make labels to the main frame
         */

        ImageIcon image =new ImageIcon( "healthcare.png");

        JButton ViewDoc=new JButton("View Doctors");
        ViewDoc.setBounds(600,300,170,30);
        ViewDoc.setFont(new Font("Cinzel Black",Font.PLAIN,15));
        ViewDoc.setBackground(new Color(165, 188, 201));


        JButton AddConsultation=new JButton("Consultation");
        AddConsultation.setBounds(600,400,170,30);
        AddConsultation.setFont(new Font("Cinzel Black",Font.PLAIN,15));
        AddConsultation.setBackground(new Color(165, 188, 201));


        JButton End=new JButton("Exit");
        End.setBounds(600,500,170,30);
        End.setFont(new Font("Cinzel Black",Font.PLAIN,15));
        End.setBackground(new Color(165, 188, 201));


        JLabel name = new JLabel();
        name.setText("Skin Consultation Centre");
        name.setBounds(150,15,550,50);
        name.setVerticalAlignment(JLabel.CENTER);
        name.setFont(new Font("Britannic Bold",Font.PLAIN,40));


        JLabel images =new JLabel();
        images.setIcon(image);
        images.setSize(800,700);


        /*
          add items to the main frame
         */



        f= new JFrame("Skin Consultation Centre");
        f.setSize(800,600);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setIconImage(image.getImage());
        f.setResizable(false);
        f.getContentPane().setBackground(new Color(154, 210, 245));

        f.add(ViewDoc);
        f.add(AddConsultation);
        f.add(End);
        f.add(images);
        f.add(name);


        /*
          action of the view doctor button
          go to the doctors list
         */


        ViewDoc.addActionListener(e -> {
            f.setVisible(false);
            new ViewDoctors(this, WestminsterSkinConsultationManager.Doctors,true).setVisible(true);
        });


        /*
          action of the Add consultation button
          go to the add consultation frame
         */

        AddConsultation.addActionListener(e -> {
            f.setVisible(false);
            new AddConsultation(this).setVisible(true);
        });

        End.addActionListener(e -> {
            f.dispose();
        });



    }

    public static void visible() {f.setVisible(true);
    }


}
