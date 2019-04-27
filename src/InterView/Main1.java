package InterView;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int total=1024-n;
        sum(total);
    }

    public static void sum(int total){
        int c1=total/64,r1=total%64;
        int c2=r1/16,r2=r1%16;
        int c3=r2/4,r3=r2%4;
        int c4=r3;
        int sum=c1+c2+c3+c4;
        System.out.println(sum);
    }

}
