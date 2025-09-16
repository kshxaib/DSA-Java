public class Subtring {
    public static String substring(String str, int start, int end){
        String subStr = "";
        for(int i=start; i<end; i++){
            subStr += str.charAt(i);
        }

        return subStr;
    }

    public static void main(String[] args) {
        String str = "HelloWorld";

        System.out.print(substring(str, 3, 5));
    }
}
