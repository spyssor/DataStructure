package InterView;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0 ; i < n; i ++){
            arr.add(sc.next());
        }
        for (int i = 0; i < n; i ++){
            printNew(arr.get(i));
        }
    }

    private static class Pair<K, V>{
        public K key;
        public V value;
        Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }

        public V getValue(){
            return value;
        }
    }

    public static void printNew(String str){
        ArrayList<Pair<Character, Integer>> record = new ArrayList<>();
        int n = str.length();
        record.add(new Pair<>(str.charAt(0), 1));
        int index = 1;
        int i = 1;
        while(index < n){
            char c = str.charAt(index);
            if (record.get(i-1).getKey().equals(c)){
                record.set(i-1, new Pair<>(record.get(i-1).getKey(), record.get(i-1).getValue()+1));
                if (record.get(i-1).getValue().equals(3)){
                    record.set(i-1, new Pair<>(record.get(i-1).getKey(), record.get(i-1).getValue()-1));
                }
                if (i-2 >= 0){
                    if (record.get(i-1).getValue() == 2 && record.get(i-2).getValue() == 2){
                        record.set(i-2, new Pair<>(record.get(i-2).getKey(), record.get(i-2).getValue()-1));
                    }
                }
            }else{
                record.add(new Pair<>(str.charAt(index), 1));
                i ++;
            }
            index ++;
        }

        StringBuilder sb = new StringBuilder();

        for (int k = 0 ; k < record.size(); k ++){
            for (int j = 0 ; j < record.get(k).getValue(); j ++){
                sb.append(record.get(k).getKey());
            }
        }

        System.out.println(sb.toString());
    }
}
