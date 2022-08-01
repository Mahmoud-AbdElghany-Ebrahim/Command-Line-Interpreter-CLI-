package com.mycompany.clt;

/**
 *
 * @author user
 */
public class Parser {

    String commandName;
    String[] args=null;
    String[] command = {"echo", "pwd", "cd", "ls", "ls -r", "mkdir",
        "rmdir", "touch", "cp", "cp -r", "rm", "cat", ">", ">>"};

//This method will divide the input into commandName and args
//where "input" is the string command entered by the user 
    public boolean parse(String input) {
        int ind = input.indexOf(" ");
        String []word={""};
        boolean found = ind != -1 ? true : false;
        if (found == false) {
            for (int i = 0; i < command.length; i++) {
                if (input.equals(command[i])) {
                    commandName = input;
                    break;
                } else if (i == command.length - 1) {
                   // System.out.println("Error command not found");
                    return false;
                }
                input=input.substring(ind+1, input.length());
               // System.out.println(input+" 1");
                
            }
            
        } else {
            int index = input.indexOf("-");
            boolean found1 = index != -1 ? true : false;
            if (found == true) {
                String chec = input.substring(0, ind);
                for (int i = 0; i < command.length; i++) {
                    if (chec.equals(command[i])) {
                        commandName = chec;
                        break;
                    } else if (i == command.length - 1) {
                       // System.out.println("Error command not found");
                        return false;
                    }
                }
                input=input.substring(ind+1, input.length());
              //  System.out.println(input);
                //word = input.split("\\s");
                args = input.split("\\s");
                
            } else {
                String chec = input.substring(0, index + 2);
                for (int i = 0; i < command.length; i++) {
                    if (chec.equals(command[i])) {
                        commandName = chec;
                        break;
                    } else if (i == command.length - 1) {
                      //  System.out.println("Error command not found");
                        return false;
                    }
                }
                input=input.substring(index + 2, input.length());
                //System.out.println(input);
               // word = input.split("\\s");

                args = input.split("\\s");
            }
            

        }
       /* for(String w:word){
            System.out.print(w);  
        }*/
        return true;
    }

    public String getCommandName() {
        return commandName;
    }

    public String[] getArgs() {
        
        return args;
    }


    public boolean check(String command) {

        return true;
    }

}
