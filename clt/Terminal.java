/**
 *
 * @author Mahmoud Abd El-Ghany Ebrahim
 * @version 1.0
 */

/*
Biko
*/

import java.io.File;
import java.util.Scanner;

public class Terminal {

    static String user_dir = System.getProperty("user.dir");
    static String user_home = System.getProperty("user.home");

    static Scanner inp = new Scanner(System.in);

    //Implement each command in a method, for example:
    Parser pe = new Parser();

    //check input from user
    public void check(String input) {
        boolean flag = pe.parse(input);
        if (flag == false) {
            System.out.println("Error command not found");

        }
        chooseCommandAction(pe.commandName);

    }

    //return rhe home directory
    public String pwd() {

        return user_home;
    }

    //print the input of user
    public void echo(String[] word) {
        int i = 0;
        while (i != word.length) {
            System.out.print(word[i++] + " ");
        }
    }

    /*
    first case return the previos path of the current path
    second case return the home directory
    third case return enter path of user and go to it
     */
    public String cd(String[] str) {
        //System.out.print("haay1");
        if (str[0].equals("..")) {
            int index = user_dir.lastIndexOf("\\");
            String pre = user_dir.substring(0, index);
            System.setProperty("user.dir", pre);
            //user_dir = pre;
            user_dir = System.getProperty("user.dir");

            // System.out.print("haay2");
            return user_dir;
        } else {
            if (str.length == 0) {
                System.setProperty("user.dir", user_home);
                user_dir = System.getProperty("user.dir");

                return user_dir;
            } else {
                StringBuffer bf = new StringBuffer();
                for (int i = 0; i < str.length; i++) {
                    bf.append(str[i]);
                }
                String New = bf.toString();
                System.setProperty("user.dir", New);
                //user_dir = New;
                user_dir = System.getProperty("user.dir");
                return user_dir;

            }
        }
    }

    public static void ls() {
        File directoryPath = new File(user_dir);
        String[] NameOfFiles = directoryPath.list();
        for (int i = 0; i < NameOfFiles.length; i++) {
            System.out.println(NameOfFiles[i]);
        }

    }

    public static void lsreverse() {
        File directoryPath = new File(user_dir);
        String[] NameOfFiles = directoryPath.list();

        for (int j = NameOfFiles.length - 1; j >= 0; j--) {

            System.out.println(NameOfFiles[j]);
        }

    }
    public static void rm(String []str)
      {
          if(str[0].equals("*")){
              File directory = new File("D:\\HAY");

                // delete the directory
             boolean result = directory.delete();
          }
              
          /*File f = new File("D:\\aya\\heba.txt");
          if(f.equals(fileToDelete))
          {
              f.delete();
          }
          else
          {
              System.out.println("File Not Exist");
          }*/
      }

    public void chooseCommandAction(String command) {
        //  String swit = check(String inp);
        switch (command) {
            case "echo": {
                echo(pe.args);
                break;
            }
            case "pwd": {
                System.out.println(pwd());
                break;
            }
            case "cd": {
                cd(pe.args);
                break;
            }
            case "ls": {
                ls();
                break;
            }
            case "ls -r":{
                lsreverse();
                break;
            }
            case "rmdir":{
                rm(pe.args);
                break;
                
            }
        }
    }

    // public void cd(String[] args) {
    // }
// ...
//This method will choose the suitable command method to be called
    public static void main(String[] args) {
        Terminal term = new Terminal();
        String[] arr = {""};
        // String[] arr={"C:\\Users","\\user\\Documents\\","Rockstar Games\\Red Dead Redemption 2"};
        while (true) {
            String comm = inp.nextLine();
            term.check(comm);
        }
        //term.pe.parse(comm);
        //System.out.println(term.pe.getCommandName());
        // System.out.println(term.pe.getArgs());
        //  System.out.println(term.cd(arr)); 

    }
}
