package InterView;

import java.util.Scanner;

public class Main11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(print(str));
    }

    private static String print(String str){
        if (str.length() == 0){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < str.length(); i ++){
            if (str.charAt(i) == str.charAt(i-1)){
                ++ count;
            }
            if (str.charAt(i) != str.charAt(i-1) ){
                if (count > 1){
                    sb.append(str.charAt(i-1)).append(count);
                    count = 1;
                }else{
                    sb.append(str.charAt(i-1));
                }

            }
            if (i == str.length()-1){
                if (str.charAt(i) == str.charAt(i-1)){
                    sb.append(str.charAt(i-1)).append(count);
                    count = 1;
                }else{
                    sb.append(str.charAt(i));
                }

            }

        }

        return sb.toString();
    }
}
