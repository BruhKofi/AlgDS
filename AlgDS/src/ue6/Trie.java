package ue6;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * An object representing a single trie, i.e., a tree that is used to store a set of strings.
 */
public class Trie {
	
	static Boolean Debug = false;

	
	// Root node of the trie
	private Node root;

	public Trie() {
		root = new Node();
	}

	/**
	 * Add the given word to the trie.
	 */
	public void add(String word) {
		Node node = this.root;  // parent node
		word = word + "$";  // add finisher
		if (Debug) { System.out.print("Word:"+word+"="); }
		for ( int i = 0; i < word.length(); i ++ ) {  // for all chars of the word
			char c = word.charAt(i);  // extract it
			if (Debug) System.out.print("["+c+"] ");
			if (!node.getOutgoingEdgeLabels().contains(c)) { // if not existing as a node
				Node child = new Node();  // create new node
				node.addOutgoingEdge(c, child); // connect char to new node
			}
			node = node.getChild(c);
			
		}
		if (Debug) System.out.println(root.getOutgoingEdgeLabels());
	}

	/**
	 * Search the trie for the given word.
	 * 
	 * @return true if the trie contains the word, otherwise false.
	 */
	private boolean contains(String word) {
		Node node = this.root;  // parent node
		word = word + "$";  // add finisher
		if (Debug) System.out.print("Word:"+word+"=");
		for (int i = 0; i < word.length(); i++) {   // for all chars of the word
			char c = word.charAt(i);    // extract it
			if (Debug) System.out.print(" "+i+":"+c);
			if (node.getOutgoingEdgeLabels().contains(c)) {  // is is a existing node?
				node = node.getChild(c);	// yes - get next
				if (Debug) System.out.print(".");
			} else {
				return false; // no - throw false
			}
		}
		return true;
	}
	


	
	
	/**
	 * Print a list of all words in the trie.
	 */
	
	
	public String calcWords(Node node, String prefix) {
		String result = ""; 
		Set<Character> keyset = node.getOutgoingEdgeLabels(); // all branching chars
		if (Debug) System.out.println();
		if (Debug) System.out.print(prefix+" "+keyset);
		if (!keyset.isEmpty()) { //are there chars at all?
			for (char c : keyset) { // for every char check
				if (Debug) System.out.println(c);
				if (c=='$') {    // if $ then the prefix is a word
					result = result + "\n"+prefix;   // so we add the word
				} else {  // if not
			        result = result + calcWords(node.getChild(c),prefix+c); //recursive step down to next char
				}
			}
		}
		return result;
	}	
	
	
	public void printWords() {
		if (Debug) System.out.println("List: ");
		System.out.println(calcWords(root,""));
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

		
		//if (Debug) System.exit(0);
		
		
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

	
	public static void addcheck(Trie trie, String word) {
	  trie.add(word);
	  check(trie, word, true);
	  
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
