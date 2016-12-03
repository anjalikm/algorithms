import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        //Stack<String before current operation>
        Stack<String>stack = new Stack<String>();
        Scanner in = new Scanner(System.in);
        String current_string = "";
        StringBuffer new_string = new StringBuffer("");
        int Q = in.nextInt();
        stack.push(current_string);
        //System.out.println("pushed on stack:"+current_string);
        for(int i = 0 ; i < Q; i++){
            new_string = new StringBuffer(current_string);
            int oper = in.nextInt();
            String argument;
            if( oper == 1 || oper == 2 || oper == 3)
                argument = in.next();
            else
                argument = null;
            //check the operation code and perform that operation on the string
            if( oper == 1){ //append
                new_string = new StringBuffer(current_string + argument);
            }
            else if(oper == 2){ //delete operation
                new_string = new StringBuffer (current_string.substring(0,current_string.length() - Integer.parseInt(argument) ));
            }
            else if(oper == 3) { // prnt kth character
                System.out.println(current_string.charAt(Integer.parseInt(argument) -1 ));
            }
            else{ // undo opeartion
                String temp_str = stack.pop();
                new_string = new StringBuffer(stack.pop());
            }
            current_string = new_string.toString();
            //save the string updated in the current opeartion by pushing onto the stack
            if(oper == 1 || oper == 2 || oper == 4){
                stack.push(current_string);
            }
        }
        
    }
}