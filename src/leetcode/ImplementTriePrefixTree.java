package leetcode;

class Trie {
    private TrieNode root;

    // inner class for trie node
    private class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEndWord;
    }


    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        int len = word.length();
        int index;
        int level;

        TrieNode curr = root;

        for(level=0; level<len; level++){
            index = word.charAt(level)-'a';
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        curr.isEndWord = true;
    }

    public boolean search(String word) {
        int len = word.length();
        int index;
        int level;

        TrieNode curr = root;

        for(level=0; level<len; level++){
            index = word.charAt(level)-'a';
            if(curr.children[index] == null) return false;
            curr = curr.children[index];
        }

        return curr.isEndWord;
    }

    public boolean startsWith(String prefix) {
        int len = prefix.length();
        int index;
        int level;

        TrieNode curr = root;

        for(level=0; level<len; level++){
            index = prefix.charAt(level)-'a';
            if(curr.children[index] == null) return false;
            curr = curr.children[index];
        }

        return true;
    }
}

public class ImplementTriePrefixTree {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
    }
}
