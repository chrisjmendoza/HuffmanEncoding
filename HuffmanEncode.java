import java.io.*;
import java.util.*;

public class HuffmanEncode {
	
	CharNode overallRoot;
	FileReader output;

	public HuffmanEncode(File object) throws IOException {
		output = new FileReader(object);
	}

	public void encode() throws IOException {
		HashMap<Character, Integer> valFreq = new HashMap<Character, Integer>();
		int c;
		while ((c = output.read()) != -1) {
			valFreq.putIfAbsent((char) c, 0);
			valFreq.replace((char) c, valFreq.get((char) c) + 1);
			//System.out.println(c);
			//System.out.println(valFreq.get((char) c));
		}
		output.close();
		
		// Push them all into a priority queue with your custom class
		PriorityQueue<CharNode> queue = new PriorityQueue<CharNode>();
		for (Map.Entry<Character, Integer> item : valFreq.entrySet()) {
			queue.add(new CharNode(item.getKey(), null, null, item.getValue()));
		}
		
		while(queue.size() > 1) {
			CharNode temp1 = queue.remove();
			CharNode temp2 = queue.remove();
			CharNode newNode = new CharNode(null, temp1, temp2, temp1.weight + temp2.weight);
			queue.add(newNode);
		}
		

		CharNode overallRoot = queue.remove();
		Map<Character, String> charMap = genMap(overallRoot);
		System.out.println(charMap.toString());
	}
	
	private Map<Character, String> genMap(CharNode root) {
	    Map<Character, String> map = new HashMap<Character, String>();
	    traversal(map, root, "");
	    return map;
	}

	private void traversal(Map<Character, String> map, CharNode root, String path) {
	    if (root.isLeaf()) {
	        map.put(root.symbol, path);
	    }
	    else {
	        traversal(map, root.leftChild, path + '0');
	        traversal(map, root.rightChild, path + '1');
	    }
	}

	private class CharNode implements Comparable<CharNode> {

		private Character symbol; // char to be encoded, empty if combined node
		CharNode leftChild;
		CharNode rightChild;
		CharNode parent;
		Integer weight; // occurrence # of this char in the text

		public CharNode(Character symbol, CharNode leftChild,
				CharNode rightChild, Integer weight) {
			this.symbol = symbol;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
			this.parent = parent;
			this.weight = weight;
		}

		
		public boolean isLeaf() {
			return leftChild == null && rightChild == null;
		}

		public int compareTo(CharNode o) {
			return this.weight - o.weight;
		}

	}
}
