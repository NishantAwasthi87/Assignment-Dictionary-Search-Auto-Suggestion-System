public class Word {

    private String text;
    private int frequency;

    public Word(String text, int frequency) {
        this.text = text;
        this.frequency = frequency;
    }

    public String getText() {
        return text;
    }

    public int getFrequency() {
        return frequency;
    }

    public void incrementFrequency() {
        frequency++;
    }

    @Override
    public String toString() {
        return text + " (frequency=" + frequency + ")";
    }
}