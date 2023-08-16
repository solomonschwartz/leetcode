import java.util.*;

class Trie {
    class Node{
        public Map<Character,Node> children;
        public boolean isWord;
        public Node(){
            this.children = new HashMap<>();
            this.isWord = false;
        }
        public void word(){
            this.isWord = true;
        }
    }
    Node root;
    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node current = this.root;
        char[] chars = word.toCharArray();
        for(char c:chars){
            if (current.children.get(c) == null){
                current.children.put(c,new Node());
            }
            current = current.children.get(c);
        }
        current.word();
    }

    public boolean search(String word) {
        Node current = this.root;
        char[] chars = word.toCharArray();
        for(char c:chars){
            if (current.children.get(c) == null){
                return false;
            }
            current = current.children.get(c);
        }
        return current.isWord;
    }

    public boolean startsWith(String prefix) {
        Node current = this.root;
        char[] chars = prefix.toCharArray();
        for(char c:chars){
            if (current.children.get(c) == null){
                return false;
            }
            current = current.children.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */