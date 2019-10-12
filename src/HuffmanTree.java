import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * Implementation of a Huffman Tree
 * 
 * @author Eduardo Andrade
 * @author Marcelo Heredia
 */
public class HuffmanTree {
	Node treeRoot;

	/**
	 * Tree node implementation
	 */
	private class Node implements Comparable<Node> {
		private Character character;
		private Integer frequency;
		private Node left;
		private Node right;

		/**
		 * Creates a new node with left and right as null.
		 * 
		 * @param character char to be saved in the node
		 * @param frequency frequency the character appears
		 */
		public Node(Character character, Integer frequency) {
			this.character = character;
			this.frequency = frequency;
			this.left = null;
			this.right = null;
		}

		/**
		 * Creates a new node.
		 * 
		 * @param character char to be saved in the node
		 * @param frequency frequency the character appears
		 * @param left      left child node
		 * @param right     right child node
		 */
		public Node(Character character, Integer frequency, Node left, Node right) {
			this.character = character;
			this.frequency = frequency;
			this.left = left;
			this.right = right;
		}

		@Override
		public int compareTo(Node n) {
			return Integer.compare(this.frequency, n.frequency);
		}

		public boolean hasCharacter() {
			return this.character != null;
		}

		public boolean hasLeft() {
			return this.left != null;
		}

		public boolean hasRight() {
			return this.right != null;
		}

	}

	public HuffmanTree(HashMap<Character, Integer> map) {
		treeRoot = this.MapToNodeTree(map);
	}

	public HashMap<Character, String> NodeTreeToCodeMap() {
		HashMap<Character, String> codeMap = new HashMap<Character, String>();
		GetCode(treeRoot, codeMap, "");
		return codeMap;
	}

	private static void GetCode(Node root, HashMap<Character, String> codeMap, String str) {
		if (!root.hasLeft() && !root.hasRight() && root.hasCharacter()) {
			codeMap.put(root.character, str);
			return;
		}
		if (root.hasLeft()) {
			GetCode(root.left, codeMap, str + "0");
		}
		if (root.hasRight()) {
			GetCode(root.right, codeMap, str + "1");
		}
	}

	private Node MapToNodeTree(HashMap<Character, Integer> hashMap) {
		PriorityQueue<Node> tempQueue = new PriorityQueue<Node>();
		for (Entry<Character, Integer> entry : hashMap.entrySet()) {
			tempQueue.add(new Node(entry.getKey(), entry.getValue()));
		}

		while (tempQueue.size() >= 2) {
			Node[] removed = { tempQueue.poll(), tempQueue.poll() };
			int frequencySum = removed[0].frequency + removed[1].frequency;
			Node newNode = new Node(null, frequencySum, removed[0], removed[1]);
			tempQueue.add(newNode);
		}

		return tempQueue.element();
	}

}
