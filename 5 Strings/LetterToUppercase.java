public class LetterToUppercase {
    public static void convertEachFirstLetterToUpper(String name){
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<name.length(); i++){
            if( i == 0|| name.charAt(i-1) == ' '){
                char ch = name.charAt(i);
                sb.append(Character.toUpperCase(ch));
            } else {
                sb.append(name.charAt(i));
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) {
        String name = "khan mohd shoaib";
        convertEachFirstLetterToUpper(name);
    }
}
