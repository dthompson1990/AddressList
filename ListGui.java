//Name: Darian Thompson
//Project 4
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ListGui
{
   public static void main (String []args)
   {
      //
      JFrame mainBox = new JFrame("Main Window");
      mainBox.setSize(600, 500);
      mainBox.setLayout(new BorderLayout());
      JButton emptyButton = new JButton ("isEmpty");
      JButton frontAdd = new JButton ("addToFront");
      JButton backAdd = new JButton ("addToBack");
      JButton toStringButton = new JButton ("toString");
      JButton reverseString = new JButton ("reverseToString");
      JButton reverseButton = new JButton ("reverse");
      JButton sizeButton = new JButton ("sizeOf");
      JButton phoneSearch = new JButton ("phoneNumberByName");
      JButton emailSearch = new JButton ("emailByPhoneNumber");
      JButton nameSearch = new JButton ("nameByPhone");
      JButton dobSearch = new JButton ("dobByName");
      JButton clearButton = new JButton ("Clear List");
      JPanel container = new JPanel();
      //text fields for adding input
      JTextField teleField = new JTextField();
      JTextField nameField = new JTextField();
      JTextField emailField = new JTextField();
      JTextField addressField = new JTextField();
      JTextField dobField = new JTextField();
      JTextArea resultsArea = new JTextArea("results", 15, 50);

      JPanel textCont = new JPanel();
      teleField.setColumns(12);
      nameField.setColumns(20);
      emailField.setColumns(30);
      addressField.setColumns(30);
      dobField.setColumns(10);
      container.add(emptyButton);
      container.add(frontAdd);
      container.add(backAdd);
      container.add(toStringButton);
      container.add(reverseString);
      container.add(reverseButton);
      container.add(sizeButton);
      container.add(phoneSearch);
      container.add(emailSearch);
      container.add(nameSearch);
      container.add(dobSearch);
      container.add(clearButton);

      textCont.add(nameField);
      textCont.add(emailField);
      textCont.add(teleField);
      textCont.add(addressField);
      textCont.add(dobField);
      mainBox.add(container,BorderLayout.NORTH);
      mainBox.add(textCont, BorderLayout.SOUTH);
      mainBox.add(resultsArea, BorderLayout.CENTER);
      mainBox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mainBox.pack();
      mainBox.setVisible(true);
      AddressList addList = new AddressList();
      addList.addToFront("John Smith", "5403255551", "jsmith05@gmail.com", "1000 Pine Tree St", "3/15/1985");
      addList.reset();
      addList.addToBack("Jessica Thomas", "7035553821", "jthomas@hotmail.com", "87 Red Woods Ct", "12/21/1980");
      addList.reset();
      addList.addToFront("Tiger James", "3215553312", "jtiger@aol.com", "800 Cypress Lane", "5/5/1991");
      addList.reset();
      addList.addToFront("Hawk Baldwin", "2553004050", "ahawkrising@gmail.com", "13877 Lime Springs Road", "1/13/1975");
      addList.reset();
      //Testing Buttons
      emptyButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            boolean state = addList.isEmpty();
            resultsArea.setText("isEmpty: " + state);
            addList.reset();
         }
      });
      frontAdd.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            if ((teleField.getText().equals("")) || (nameField.getText().equals("")) || addressField.getText().equals("") || dobField.getText().equals("")|| emailField.getText().equals(""))
            {
               resultsArea.setText("A required field is empty.");
            }
            else
            {
               String tele = teleField.getText();
               String name = nameField.getText();
               String address = addressField.getText();
               String dob = dobField.getText();
               String email = emailField.getText();
               addList.addToFront(name, tele, email, address, dob);
               resultsArea.setText("Address added.");
               addList.reset();
            }
         }
      });
      backAdd.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
         if ((teleField.getText().equals("")) || (nameField.getText().equals("")) || addressField.getText().equals("") || dobField.getText().equals("")|| emailField.getText().equals(""))
            {
               resultsArea.setText("A required field is empty.");
            }
            else
            {
               String tele = teleField.getText();
               String name = nameField.getText();
               String address = addressField.getText();
               String dob = dobField.getText();
               String email = emailField.getText();
               addList.addToBack(name, tele, email, address, dob);
               resultsArea.setText("Address added.");
               addList.reset();
            }
         }
      });
      toStringButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            resultsArea.setText(addList.toString());
            addList.reset();
         }
      });
      reverseString.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            resultsArea.setText(addList.reverseToString());
            addList.reset();
         }
      });
      reverseButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            addList.reverse();
            resultsArea.setText("Address List has been reversed");
            addList.reset();
         }
      });
      sizeButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            resultsArea.setText("sizeOf: " + addList.sizeOf());
            addList.reset();
         }
      });
      phoneSearch.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            if (nameField.getText().equals(""))
               resultsArea.setText("Name Field must not be empty.");
            else
            {
               resultsArea.setText(addList.phoneNumberByName(nameField.getText()));
               addList.reset();
            }
         }
      });
      emailSearch.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            if (nameField.getText().equals(""))
               resultsArea.setText("Name Field must not be empty.");
            else
            {
               resultsArea.setText(addList.emailByName(nameField.getText()));
               addList.reset();
            }
         }
      });
      nameSearch.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            if (teleField.getText().equals(""))
               resultsArea.setText("Telephone Field must not be empty.");
            else
            {
               resultsArea.setText(addList.nameByPhoneNumber(teleField.getText()));
               addList.reset();
            }
         }
      });  
      dobSearch.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            if (nameField.getText().equals(""))
               resultsArea.setText("Name Field must not be empty.");
            else
            {
               resultsArea.setText(addList.dobByName(nameField.getText()));
               addList.reset();
            }
         }
      });  
      clearButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            addList.clear();
            resultsArea.setText("Linked List has been cleared.");
         }
      });    
   }
}