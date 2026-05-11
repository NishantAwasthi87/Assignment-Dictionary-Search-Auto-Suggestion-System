import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Add word
    public boolean insert(String wordText) {

        TrieNode current = root;

        for (char ch : wordText.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }

        if (current.isEndOfWord) {
            return false;
        }

        current.isEndOfWord = true;
        current.word = new Word(wordText, 1);

        return true;
    }

    // Search exact word
    public boolean search(String wordText) {

        TrieNode current = root;

        for (char ch : wordText.toCharArray()) {

            if (!current.children.containsKey(ch)) {
                return false;
            }

            current = current.children.get(ch);
        }

        if (current.isEndOfWord) {
            current.word.incrementFrequency();
            return true;
        }

        return false;
    }

    // Get suggestions
    public List<String> suggest(String prefix, int k) {

        TrieNode current = root;

        for (char ch : prefix.toCharArray()) {

            if (!current.children.containsKey(ch)) {
                return new ArrayList<>();
            }

            current = current.children.get(ch);
        }

        List<Word> matchedWords = new ArrayList<>();

        dfs(current, matchedWords);

        // Sort:
        // Higher frequency first
        // Lexicographical if same frequency

        Collections.sort(matchedWords, new Comparator<Word>() {
            @Override
            public int compare(Word w1, Word w2) {

                if (w2.getFrequency() != w1.getFrequency()) {
                    return w2.getFrequency() - w1.getFrequency();
                }

                return w1.getText().compareTo(w2.getText());
            }
        });

        List<String> result = new ArrayList<>();

        for (int i = 0; i < Math.min(k, matchedWords.size()); i++) {
            result.add(matchedWords.get(i).toString());
        }

        return result;
    }

    private void dfs(TrieNode node, List<Word> result) {

        if (node.isEndOfWord) {
            result.add(node.word);
        }

        for (TrieNode child : node.children.values()) {
            dfs(child, result);
        }
    }
}