public class StackFrameDemo {
    public static void main(String[] args) {
        System.out.println("Main method started");
        simpleMethod(11);
        System.out.println("Main method finished");
    }

    public static void simpleMethod(int num) {
        System.out.println("Simple method started");
        int result = num * 2;
        System.out.println("Result: " + result);
        System.out.println("Simple method finished");
    }
}
