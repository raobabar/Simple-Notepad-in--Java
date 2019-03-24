

    package project;

import java.awt.FileDialog;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.*;
import javax.swing.filechooser.*;
class notepad extends JFrame implements ActionListener
{
    JMenuBar menubar;
    JMenu file,edit;
    JMenuItem n,open,save,saveas,exit,cut,copy,paste,delete;
    TextArea textarea=new TextArea();
    String s,a,f;
   notepad()
   {
       setSize(800,600);
       setTitle("Notepad");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       menubar=new JMenuBar();
       setJMenuBar(menubar);
       file=new JMenu("File");
       edit=new JMenu("Edit");
       menubar.add(file);
       menubar.add(edit);
       n=new JMenuItem("New");
       open=new JMenuItem("Open");
       save=new JMenuItem("Save");
       saveas=new JMenuItem("Save As");
       exit=new JMenuItem("Exit");
       cut=new JMenuItem("Cut");
        copy=new JMenuItem("Copy");
         paste=new JMenuItem("Paste");
          delete=new JMenuItem("Delete");
         
       file.add(n);
       file.add(open);
       file.add(save);
       file.add(saveas);
       file.add(exit);
       edit.add(cut);
       edit.add(copy);
       edit.add(paste);
       edit.add(delete);
        n.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
         open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
          save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
       getContentPane().add(textarea);
       exit.addActionListener(this);
       n.addActionListener(this);
       cut.addActionListener(this);
       copy.addActionListener(this);
       delete.addActionListener(this);
       paste.addActionListener(this);
       save.addActionListener(this);
       open.addActionListener(this);
   }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==exit)
       {
       System.exit(0);
       }
          if(e.getSource()==n)
        {
            textarea.setText(" ");
    }
      else if(e.getSource()==delete)
       {
           textarea.setText("");
       }
      if(e.getSource()==copy)
        {
            s= textarea.getSelectedText();
            JOptionPane.showMessageDialog(null,s);
          }
      else if(e.getSource()==cut)
          {
            
            s= textarea.getSelectedText();
             textarea.setText("");
          }
      else if(e.getSource()==paste)
     {
         //s=textarea.getText();
          textarea.setText(s+s);
     }
       else if(e.getSource()==open)
        {
            try
            {
                FileDialog fd=new FileDialog(this,"Open File",FileDialog.LOAD);
                fd.setVisible(true);
                String dir=fd.getDirectory();
                String fname=fd.getFile();
                FileInputStream fis=new FileInputStream(dir+fname);
                DataInputStream dis=new DataInputStream(fis);
                String str=" ",msg=" ";
                while((str=dis.readLine())!=null)
                {
                    msg=msg+str;
                    msg+="\n";
                }
                textarea.setText(msg);
                dis.close();
            }
            
            
            catch(Exception E){
                    }
        }
        else if(e.getSource()==save)
        {
            try
            {
                FileDialog fd=new FileDialog(this,"Save File",FileDialog.SAVE);
                fd.setVisible(true);
                String txt=textarea.getText();
                String dir=fd.getDirectory();
                String fname=fd.getFile();
                FileOutputStream fos=new FileOutputStream(dir+fname);
                DataOutputStream dos=new DataOutputStream(fos);
                dos.writeBytes(txt);
                dos.close();
            }
            catch(Exception E)
            {
                
            }
        }
      }
    }

public class Project {

    
    public static void main(String[] args) {
      notepad n=new notepad();
      n.setVisible(true);
    }
    
}