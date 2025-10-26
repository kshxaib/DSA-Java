public class LetterToUppercase {
    public static void convertEachFirstLetterToUpper(String name){
        StringBuilder sb = new StringBuilder("");
        char ch = name.charAt(0);
        sb.append(Character.toUpperCase(ch));

        for(int i=1; i<name.length(); i++){
            if(name.charAt(i-1) == ' '){
                ch = name.charAt(i);
                sb.append(Character.toUpperCase(ch));
            } else {
                sb.append(name.charAt(i));
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) {
        String name = "khan mohd shoaib ";
        convertEachFirstLetterToUpper(name);
    }
}
