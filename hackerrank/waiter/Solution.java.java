
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private static boolean isPrime(int num){
        for(int i = 2; i <= Math.sqrt(num); i++){
            if( num % i == 0)
                return false;
           
        }
        return true;
    }
    public static int nextPrime(int num){
        int next_num = num + 1;
        boolean found = false;
        while(!found){
            if(isPrime(next_num)){
                found = true;
            }
            else
                next_num++;
               
        }
        return next_num;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int Q = in.nextInt();
        Stack<Integer> org_stack = new Stack<Integer>();
        ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
        for(int i = 0 ; i < N; i++){
            org_stack.add(in.nextInt());
        }
        int prime = 1; 
        Stack<Integer>non_div_stack = new Stack<Integer>();
       // non_div_pile.addAll(org_stack);
        
        for(int q = 0; q < Q; q++){
            prime = nextPrime(prime);
            if(! non_div_stack.isEmpty())
                org_stack = non_div_stack;
            non_div_stack = new Stack<Integer>();
            Stack cur_stack = new Stack<Integer>();
            while(!org_stack.isEmpty()){
                int cur_num = org_stack.pop();
                if(cur_num % prime == 0)
                    cur_stack.push(cur_num);
                else
                    non_div_stack.push(cur_num);
            }
            stacks.add(cur_stack);
            
        }
        stacks.add(non_div_stack);
        // there might be Q or Q + 1 stacks
        Iterator itr = stacks.iterator();
        while(itr.hasNext()){
            Stack s = (Stack)itr.next();
            if( s != null){
                while(!s.isEmpty())
                    System.out.println(s.pop());
            }
        }
        
    }
}