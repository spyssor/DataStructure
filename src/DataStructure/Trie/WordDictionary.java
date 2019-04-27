package DataStructure.Trie;

import java.util.TreeMap;

public class WordDictionary {

    class Node{

        private boolean isWord;
        private TreeMap<Character, Node> next;

        public Node(boolean isWord){

            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    private Node root;

    public WordDictionary(){

        root = new Node();
    }

    public void  addWords(String word){

        Node cur = root;
        for (int i = 0; i < word.length(); i ++){
            char c = word.charAt(i);
            if (cur.next.get(c) == null){
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord){
            cur.isWord = true;
        }
    }

    public boolean search(String word){

        return match(root, word, 0);
    }

    private boolean match(Node node, String word, int index){

        //"cat" index=2 c='t' -> index=3 ->单词匹配完  返回isWord
        if (index == word.length()){
            return node.isWord;
        }

        char c = word.charAt(index);
        if (c != '.'){
            if (node.next.get(c) == null){
                return false;
            }
            return match(node.next.get(c), word, index + 1);
        }else{
            for (char nextChar : node.next.keySet()){
                if (match(node.next.get(nextChar), word, index + 1)){
                    return true;
                }
                return false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWords("string");
        wordDictionary.addWords("structure");
        wordDictionary.addWords("cat");
        wordDictionary.addWords("dog");
        wordDictionary.addWords("category");


        wordDictionary.search("c.t");
    }
}
