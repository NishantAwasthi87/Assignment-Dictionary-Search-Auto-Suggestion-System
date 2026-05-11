import java.util.List;

public class DictionaryService {

    private Trie trie;

    public DictionaryService() {
        trie = new Trie();

        // Initial data
        trie.insert("apple");
        trie.insert("apply");
        trie.insert("application");
        trie.insert("banana");
        trie.insert("bat");
        trie.insert("ball");
    }

    // Add word
    public String addWord(String word) {

        word = word.toLowerCase();

        boolean inserted = trie.insert(word);

        if (inserted) {
            return "Word added successfully";
        }

        return "Word already exists";
    }

    // Search word
    public String searchWord(String word) {

        word = word.toLowerCase();

        boolean found = trie.search(word);

        if (found) {
            return "FOUND";
        }

        return "NOT FOUND";
    }

    // Suggest words
    public List<String> getSuggestions(String prefix, int k) {
        return trie.suggest(prefix.toLowerCase(), k);
    }
}