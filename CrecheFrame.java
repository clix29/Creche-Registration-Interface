
package za.ac.tut.crecheframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import za.ac.tut.child.Child;
public class CrecheFrame extends JFrame{
    private JPanel namePnl;
    private JPanel genderPnl;
    private JPanel registerPnl;
    private JPanel displayPnl;
    private JPanel registerAndDisplayCombinedPnl;
    private JPanel commentPnl;
    private JPanel mainPnl;
    private JPanel headingCombinedPnl;
    private JPanel registerDisplayCenterPnl;
    private JPanel commentSouthPnl;
    private JLabel nameLbl;
    private JLabel genderLbl;
    private JPanel nameGenderCombinedPnl;
    private JTextField nameTxtFld;
    private ArrayList<Child> children;
    private JRadioButton maleBtn;
    private JRadioButton femaleBtn;
    private JButton registerBtn;
    private JButton displayBtn;
    private JTextArea commentTxtArea;
    private JScrollPane scrollPane; 
    public CrecheFrame() {
        setTitle("CRECHE 4 YOUR KIDDIE");
        setSize(600,650);
        setDefaultLookAndFeelDecorated(true);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        children = new ArrayList<>();
        namePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        registerPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        displayPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        registerAndDisplayCombinedPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        mainPnl = new JPanel(new BorderLayout());
        headingCombinedPnl = new JPanel(new BorderLayout());
        registerDisplayCenterPnl = new JPanel(new BorderLayout());
        commentSouthPnl = new JPanel(new BorderLayout());
        nameGenderCombinedPnl = new JPanel(new GridLayout(2,1));
        commentPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameLbl = new JLabel("Name: ");
        genderLbl = new JLabel("Gender:");
        nameTxtFld = new JTextField(15);
        maleBtn = new JRadioButton("Male");
        femaleBtn = new JRadioButton("Female");
        registerBtn = new JButton("Register kiddie");
        displayBtn = new JButton("Display kiddies");
        commentTxtArea = new JTextArea(10,30);
        commentTxtArea.setBorder(new TitledBorder(new LineBorder(Color.BLUE,1)));
        scrollPane = new JScrollPane(commentTxtArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        namePnl.add(nameLbl);
        namePnl.add(nameTxtFld);
        genderPnl.add(genderLbl);
        genderPnl.add(maleBtn);
        genderPnl.add(femaleBtn);
        registerPnl.add(registerBtn);
        displayPnl.add(displayBtn);
        registerAndDisplayCombinedPnl.add(registerPnl);
        registerAndDisplayCombinedPnl.add(displayPnl);
        nameGenderCombinedPnl.add(namePnl);
        nameGenderCombinedPnl.add(genderPnl);
        commentPnl.add(scrollPane);
        mainPnl.add(nameGenderCombinedPnl, BorderLayout.NORTH);
        mainPnl.add(registerAndDisplayCombinedPnl, BorderLayout.CENTER);
        mainPnl.add(commentPnl, BorderLayout.SOUTH);
        add(mainPnl);
        pack();
        ActionListenerMethod();
        setVisible(true);
    } 
    public void ActionListenerMethod()
    {
         registerBtn.addActionListener(new ActionListener()
         {
              @Override
              public void actionPerformed(ActionEvent e)
              {
                 registerKiddie(); 
              }
         });
         displayBtn.addActionListener(new ActionListener()
         {
              @Override
              public void actionPerformed(ActionEvent e)
              {
                displayKiddies();  
              }
         }
         );   
    }
    public void registerKiddie()
    {
      String name = nameTxtFld.getText();
      String gender = maleBtn.isSelected() ? "Male" : femaleBtn.isSelected() ? "Female" : "";
      if(!name.isEmpty() && !gender.isEmpty())
      {
         children.add(new Child(name,gender));
         nameTxtFld.setText("");
         maleBtn.setSelected(false);
         femaleBtn.setSelected(false);
      }
      else
      {
        JOptionPane.showMessageDialog(null,"Please Enter name and select gender");  
      }        
    }
    public void displayKiddies()
    {
      String message = "";
      for(Child child: children)
      {
        message += child.Display()+"\n";
      }
      commentTxtArea.setText(message);
    }
}
