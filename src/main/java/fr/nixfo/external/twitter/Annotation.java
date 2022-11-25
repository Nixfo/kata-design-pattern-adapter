package fr.nixfo.external.twitter;

public class Annotation {
    /**
     * Start index in the text.
     */
    public int start;

    /**
     * End index in the text.
     */
    public int end;

    /**
     * Probability of the detection
     */
    public double probability;
    public String type;

    public String normalized_text;

    public Annotation(int start, int end, double probability, String type, String normalized_text) {
        this.start = start;
        this.end = end;
        this.probability = probability;
        this.type = type;
        this.normalized_text = normalized_text;
    }
}
