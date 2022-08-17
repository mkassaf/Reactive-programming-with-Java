import java.util.Stack;

public class StackExample {


    public static void main(String[] args) {
        Stack<String> myStack = new Stack<>();
        myStack.push("A");
        myStack.push("B");
        myStack.push("C");

        System.out.println(myStack);//A, B, C
        System.out.println(myStack.size());//3
        System.out.println(myStack.isEmpty());//false
        System.out.println("peek " + myStack.peek());//C
        System.out.println(myStack);//A, B, C
        System.out.println("pop " + myStack.pop());//C
        System.out.println(myStack);//A, B
        System.out.println("pop " + myStack.pop());//B
        System.out.println(myStack);//A
        System.out.println("pop " + myStack.pop());//A
        System.out.println(myStack.isEmpty());//true

    }
}
