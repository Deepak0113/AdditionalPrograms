package MidJan;

import java.util.Scanner;
import java.util.Stack;

public class Question1 {

    public static boolean is_valid(String expression) {
        boolean result = true;
        // alphabets
        Stack<Integer> st1 = new Stack<>();
        // brackets
        Stack<Character> st2 = new Stack<>();
        boolean isTrue = true;

        for (int i = 0; i < expression.length(); i++) {
            char temp = expression.charAt(i);
            /*if the character is a digit, we push it to st1*/
            if (isDigit(temp)) {
                st1.push(temp - '0');
                if(isTrue) {
                    isTrue = false;
                }
                else {
                    return false;
                }
            }
            /*if the character is an operator, we push it to st2*/
            else if (isOperator(temp)) {
                st2.push(temp);
                isTrue = true;
            }
            else {
                /*if the character is an opening parantheses we push it to st2*/
                if(isBracketOpen(temp)) {
                    st2.push(temp);
                }
                /*If it is a closing bracket*/
                else {
                    boolean flag = true;
                    /*we keep on removing characters until we find the corresponding
                    open bracket or the stack becomes empty*/
                    while (!st2.isEmpty()) {
                        char c = st2.pop();
                        if (c == getCorrespondingChar(temp)) {
                            flag = false;
                            break;
                        }
                        else {
                            if (st1.size() < 2) {
                                return false;
                            }
                            else {
                                st1.pop();
                            }
                        }
                    }
                    if (flag) {
                        return false;
                    }

                }
            }
        }
        while (!st2.isEmpty()) {
            char c = st2.pop();
            if (!isOperator(c)) {
                return false;
            }
            if (st1.size() < 2) {
                return false;
            }
            else {
                st1.pop();
            }
        }
        if (st1.size() > 1 || !st2.isEmpty()) {
            return false;
        }
        return result;
    }

    /*method to get corresponding opening and closing bracket.*/
    public static char getCorrespondingChar(char c) {
        if (c == ')') {
            return '(';
        }
        else if (c == ']') {
            return '[';
        }
        return '{';
    }

    /*checks if the given bracket is open or not.*/
    public static boolean isBracketOpen(char c) {
        if (c == '(' || c == '[' || c == '{') {
            return true;
        }
        return false;
    }

    /*checks if the given character is a digit.*/
    public static boolean isDigit(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    public static boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*') {
            return true;
        }
        return false;
    }

    private boolean validate1(String string){
        char[] characters = string.toCharArray();
        Stack<Character> stack = new Stack<>();

        if(characters[0]==')' || characters[0]=='/' || characters[0]=='*')
            return false;

        stack.push(characters[0]);

        for(int i=1; i<characters.length; i++){
            System.out.println("Looping: "+stack);
            if(characters[i]=='('){
                stack.push(characters[i]);
            } else if(Character.isAlphabetic(characters[i])){
                if(!stack.isEmpty() && Character.isAlphabetic(stack.peek())) {
                    System.out.print(" False 1");
                    return false;
                }
                stack.push(characters[i]);
            } else if(characters[i]==')'){
                if(i+1 < characters.length && Character.isAlphabetic(characters[i+1]))
                    return false;
                if(characters[i-1] == '(')
                    return false;
                while(stack.peek()!='(' && !stack.isEmpty()){
                    stack.pop();
                }

                if(stack.isEmpty()) {
                    System.out.print(" False 2");
                    return false;
                }
                stack.pop();
            } else if(!Character.isAlphabetic(characters[i])){
                if(Character.isAlphabetic(stack.peek()))
                    stack.push(characters[i]);
                else{
                    if(!isOperationValid(characters[i])) {
                        if(!Character.isAlphabetic(stack.peek())) {
                            System.out.print(" False 3");
                            return false;
                        }
                        stack.push(characters[i]);
                    } else if(Character.isAlphabetic(stack.peek())){
                        stack.push(characters[i]);
                    } else{
                        char temp = stack.pop();
                        if(stack.isEmpty() || stack.peek()!='('){
                            System.out.print(" False 4");
                            return false;
                        }
                        stack.push(temp);
                        stack.push(characters[i]);
                    }
                }
            }
        }

        System.out.println(stack);

        return stack.isEmpty();
    }

    private boolean isOperationValid(Character operator){
        return operator != '*' && operator != '/';
    }

    private boolean validate(String string){
        char ch = string.charAt(0);
        if(ch == ')') return false;
        if(ch=='*' || ch=='/') return false;

        Stack<Character> stack = new Stack<>();

        stack.add(string.charAt(0));
        int i=1;

        while(!stack.empty() && i<string.length()){
            ch = string.charAt(i);

            if(ch>='a' && ch<='z'){
                if(Character.isAlphabetic(stack.peek())) return false;

                if(stack.peek() == '('){
                    stack.push(ch);
                } else{
                    stack.pop();
                    stack.pop();
                    stack.push(ch);
                }
            } else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                if(!(stack.peek()>='a' && stack.peek()<='z')) return false;
                stack.push(ch);
            } else if(ch == ')'){
                if(!(stack.peek()>='a' && stack.peek()<='z')) return false;

                while(stack.peek() != '('){
                    stack.pop();
                }
                stack.pop();
            } else if(ch == '('){
                stack.push(ch);
            }

            i++;
        }

        if(!stack.empty()) return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Question1 q1 = new Question1();
        String[] testcases = new String[]{"(a+b)(a*b)","(ab)(ab+)","((a+b)","()()a+b",
                "(a)(b)","((a+b+c)a+b)","((a++b)","()","(a+)","+a","(a+b)c",
                "(a+b)++(a-b)","(a)*(b)","a+b+c","a++b","a+-b","a*+b","a*-b"};

//        while (true) {
//            System.out.print("Enter pattern or q for quit: ");
//            String pattern = sc.nextLine();
//            if(pattern.equals("q"))
//                break;
//            System.out.println(q1.validate1(pattern));
//        }

        for(String s: testcases){
            System.out.println(s);
            System.out.println(q1.validate(s));
            System.out.println("----------------------");
        }
    }
}
