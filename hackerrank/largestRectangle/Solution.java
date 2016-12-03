import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int total_buildings;
        Scanner in = new Scanner(System.in);
        total_buildings = in.nextInt();
        int [] heights_arr = new int[total_buildings];
        for(int b = 0 ; b < total_buildings; b++){
            heights_arr[b] = in.nextInt();
        }
        
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        int min_height = heights_arr[0];
        int max_area = 0 ;
        
        for(int b = 0; b < total_buildings; b++ ){
            //push new building to the stack2
            stack2.push(heights_arr[b]);
           // if(min_height > b[i])
           //     min_height = b[i];
            int cur_b_count = 0;
            min_height = stack2.peek();
            while(!stack2.isEmpty()){
                
                int new_h = stack2.pop();
                if(new_h < min_height)
                    min_height = new_h;
                stack1.push(new_h);
                cur_b_count++;
               
                int cur_area = cur_b_count * min_height;
                if(cur_area > max_area)
                    max_area = cur_area;
                
            }
            //pop from stack1 and push to stack2
            while(!stack1.isEmpty()){
                int h = stack1.pop();
                stack2.push(h);
            }
        }
        System.out.println(max_area);
    }
}