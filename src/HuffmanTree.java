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
	HashMap<Character, Integer> map;
	PriorityQueue<Node> queue;

	private class Node implements Comparable<Node> {
		private Character character;
		private Integer frequency;
		private Node father;
		private Node left;
		private Node right;

		public Node(Character character, Integer frequency) {
			this.character = character;
			this.frequency = frequency;
			this.father = null;
			this.left = null;
			this.right = null;
		}

		@Override
		public int compareTo(Node n) {
			return Integer.compare(this.frequency, n.frequency);
		}

		public boolean hasCharacter() {
			return this.character != null;
		}

		public boolean hasFather() {
			return this.father != null;
		}

		public boolean hasLeft() {
			return this.left != null;
		}

		public boolean hasRight() {
			return this.right != null;
		}

	}

	public HuffmanTree(HashMap<Character,Integer> map) {
		this.map = map;
		queue = this.MapToNodeQueue(map);
	}

	private PriorityQueue<Node> MapToNodeQueue(HashMap<Character, Integer> hashMap) {
		PriorityQueue<Node> tempQueue = new PriorityQueue<Node>;
		for (Entry<Character, Integer> entry : map.entrySet()) {
			entry.
		}
	}

}
