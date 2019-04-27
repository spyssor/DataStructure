package DataStructure.Set;

import java.util.TreeSet;

public class UniqueMorseRepresentations {

    public static int solution(String[] words) {

        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        TreeSet<String> set = new TreeSet<>();
        for (String word : words) {
            StringBuilder res = new StringBuilder();
            word = word.toLowerCase();
            for (int i = 0; i < word.length(); i++) {
                res.append(codes[word.charAt(i) - 'a']);
            }
            set.add(res.toString());
        }

        return set.size();
    }

    public static void main(String[] args) {

        String[] words = {"giN", "zen", "Gig", "mSg"};

        int count = solution(words);

        System.out.println(count);

    }

}
