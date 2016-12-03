import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PostfixEval {
	FixedStack opndStack; 
	
	
	public double eval(char[]expr){
		int length = expr.length;
		opndStack = new FixedStack(length);
		double answer;
		
		return answer;
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PostfixEval postfix = new PostfixEval();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String exprStr = br.readLine();
		char [] expr = exprStr.toCharArray();
		double answer = PostfixEval.eval(expr);
		
	}

}
