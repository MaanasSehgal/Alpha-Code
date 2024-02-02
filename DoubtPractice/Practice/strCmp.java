
public class strCmp {

    public static String compressString(String str) {
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            int count = 1;
            while (i < str.length() - 1 && str.charAt(i + 1) == currChar) {
                count++;
                i++;
            }

            sb.append(currChar);

            if (count > 1) {
                sb.append(Integer.toString(count));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "aaaabbcdddeeeeeffghhh";

        System.out.println(compressString(str));
    }
}
