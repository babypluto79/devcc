//importing the classes to use 
import java.util.ArrayList;
import java.util.Scanner;

//declaring types to use in the application
enum Operators {
   ADD_OP, MULT_OP, VALUE, DIV_OP, SUB_OP, LEFT_PAREN, RIGHT_PAREN
}

public class LexicalAnalyzer<lexy, lexeme> {
	static int nextLexy;
	final static int ADD_OP = 21;
    private final lexy type;
    private final lexeme value;

    public LexicalAnalyzer(lexy t, lexeme value) {
        this.type = t;
        this.value = value;
    }

    public String toString() {
    	
        return "Next token is: " + this.type + "\t " +  "Next Lexeme is: " + this.value;
    }


private static String getOperand(String operand, int index) {

    int i = index;
    while (i < operand.length()) {
        if (Character.isDigit(operand.charAt(i))) {
            i++;
        } else {
            return operand.substring(index, i);
        }
    }
    return operand.substring(index, i);
}

private static ArrayList<LexicalAnalyzer<Operators, String>> lex(String expression) {

    ArrayList<LexicalAnalyzer<Operators, String>> lexys = new ArrayList<>();

    for (int i = 0; i < expression.length(); i++) {
        char currChar = expression.charAt(i);

        switch (currChar) {
        case '+':
            lexys.add(new LexicalAnalyzer<>(Operators.ADD_OP, String.valueOf(currChar)));
           
           
            
            i++;
            break;

        case '*':
            lexys.add(new LexicalAnalyzer<>(Operators.MULT_OP, String.valueOf(currChar)));
            i++;
            break;
            
        case '-':
        	lexys.add(new LexicalAnalyzer<>(Operators.SUB_OP, String.valueOf(currChar)));
        	i++;
        	break;
        case '/':
        	lexys.add(new LexicalAnalyzer<>(Operators.DIV_OP, String.valueOf(currChar)));
        	i++;
        	break;
        
        case '(':
        	lexys.add(new LexicalAnalyzer<>(Operators.LEFT_PAREN, String.valueOf(currChar)));
        	i++;
        	break;
        case ')':
        	lexys.add(new LexicalAnalyzer<>(Operators.RIGHT_PAREN, String.valueOf(currChar)));
        	i++;
        	break;
        default:
            if (Character.isWhitespace(currChar)) {
                i++;
            } else {
                String operand = getOperand(expression, i);
                i += operand.length();
                lexys.add(new LexicalAnalyzer<>(Operators.VALUE, operand));
            }
            break;
        }
    }
    return lexys;
}

public static void main(String[] args) {

    
		String input1 = "5 * 10 / 4";
		String input2 = "10 + 3 * 6";
		String input3 = "5 - 3";
        String input4 = "10 + 5 ";
        String input5 = "100* 25";
        String input6 = "(10 + 3 ) / 5";
        String input7 = "10 * 4 / 5";
        String input8 = "(10 - 5) + 6";
        String input9 = "10 * 7";
        String input10 = "(10)";
		ArrayList<LexicalAnalyzer<Operators, String>> lexys = lex(input1);
		ArrayList<LexicalAnalyzer<Operators, String>> lexys1 = lex(input2);
		ArrayList<LexicalAnalyzer<Operators, String>> lexys2 = lex(input3);
		ArrayList<LexicalAnalyzer<Operators, String>> lexys3 = lex(input4);
		ArrayList<LexicalAnalyzer<Operators, String>> lexys4 = lex(input5);
		ArrayList<LexicalAnalyzer<Operators, String>> lexys5 = lex(input6);
		ArrayList<LexicalAnalyzer<Operators, String>> lexys6 = lex(input7);
		ArrayList<LexicalAnalyzer<Operators, String>> lexys7 = lex(input8);
		ArrayList<LexicalAnalyzer<Operators, String>> lexys8 = lex(input9);
		ArrayList<LexicalAnalyzer<Operators, String>> lexys9 = lex(input10);
		
		System.out.println(input1);
		for (@SuppressWarnings("rawtypes") LexicalAnalyzer lexy : lexys) {
			
		    System.out.println(lexy);
		}
		System.out.println(input2);
		for (@SuppressWarnings("rawtypes") LexicalAnalyzer lexy : lexys1) {
			
		    System.out.println(lexy);
		}
		System.out.println(input3);
		for (@SuppressWarnings("rawtypes") LexicalAnalyzer lexy : lexys2) {
			
		    System.out.println(lexy);
		}
		System.out.println(input4);
		for (@SuppressWarnings("rawtypes") LexicalAnalyzer lexy : lexys3) {
			
		    System.out.println(lexy);
		}
		System.out.println(input5);
		for (@SuppressWarnings("rawtypes") LexicalAnalyzer lexy : lexys4) {
			
		    System.out.println(lexy);
		}
		System.out.println(input6);
		for (@SuppressWarnings("rawtypes") LexicalAnalyzer lexy : lexys5) {
			
		    System.out.println(lexy);
		}
		System.out.println(input7);
		for (@SuppressWarnings("rawtypes") LexicalAnalyzer lexy : lexys6) {
			
		    System.out.println(lexy);
		}
		System.out.println(input8);
		for (@SuppressWarnings("rawtypes") LexicalAnalyzer lexy : lexys7) {
			
		    System.out.println(lexy);
		}
		System.out.println(input9);
		for (@SuppressWarnings("rawtypes") LexicalAnalyzer lexy : lexys8) {
			
		    System.out.println(lexy);
		}
		System.out.println(input10);
		for (@SuppressWarnings("rawtypes") LexicalAnalyzer lexy : lexys9) {
			
		    System.out.println(lexy);
		}
		
	}
}
