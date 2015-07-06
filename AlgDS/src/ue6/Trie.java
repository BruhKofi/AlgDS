package ue6;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * An object representing a single trie, i.e., a tree that is used to store a set of strings.
 */
public class Trie {
	// Root node of the trie
	private Node root;

	public Trie() {
		root = new Node();
	}

	/**
	 * Add the given word to the trie.
	 */
	public void add(String word) {
		//TODO: insert code here
	}

	/**
	 * Search the trie for the given word.
	 * 
	 * @return true if the trie contains the word, otherwise false.
	 */
	private boolean contains(String word) {
		//TODO: insert code here
		return true;
	}

	/**
	 * Print a list of all words in the trie.
	 */
	public void printWords() {
		//TODO: insert code here
	}

	/**
	 * Main method with a simple test case for the text tree. The output should look as follows (the order, in which words are printed, is of no importance):
	 * 
	 * sky
	 * so
	 * son
	 * i
	 * in
	 * inn
	 * CORRECT: Tree does not contain nose.
	 * CORRECT: Tree contains in.
	 * CORRECT: Tree does not contain .
	 * CORRECT: Tree does not contain inning.
	 * CORRECT: Tree contains sky.
	 * CORRECT: Tree does not contain s.
	 * CORRECT: Tree contains i.
	 */
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.add("in");
		trie.add("i");
		trie.add("inn");
		trie.add("sky");
		trie.add("so");
		trie.add("son");
		trie.printWords();
		check(trie, "nose", false);
		check(trie, "in", true);
		check(trie, "", false);
		check(trie, "inning", false);
		check(trie, "sky", true);
		check(trie, "s", false);
		check(trie, "i", true);
				check(trie, " ", false);
	}

	public static void check(Trie trie, String word, boolean correctResult) {
		if (trie.contains(word) == correctResult)
			System.out.println("CORRECT: Tree "
					+ (correctResult ? "contains " : "does not contain ")
					+ word + ".");
		else
			System.out.println("ERROR: " + word + " is falsely reported as "
					+ (correctResult ? "not contained." : "contained."));
	}

	/**
	 * A Node object represents one node in the trie.
	 */
	private class Node {
		private Map<Character, Node> outgoingEdges;

		public Node() {
			outgoingEdges = new HashMap<Character, Node>();
		}

		public void addOutgoingEdge(char c, Node child) {
			outgoingEdges.put(c, child);
		}

		public Set<Character> getOutgoingEdgeLabels() {
			return outgoingEdges.keySet();
		}

		public Node getChild(char c) {
			return outgoingEdges.get(c);
		}

	}
}
