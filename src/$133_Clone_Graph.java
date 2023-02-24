import java.util.*;

//label_bfs
//label_graph
//label_hashmap
public class $133_Clone_Graph {
    public static HashMap<Integer, Node> map = new HashMap<>();

    //solution 1: Recursive + DFS
    //https://leetcode.com/problems/clone-graph/discuss/42309/Depth-First-Simple-Java-Solution/249007
    public static Node cloneGraph(Node node) {
        return clone(node);
    }

    public static Node clone(Node node) {
        if (node == null) return null;

        if (map.containsKey(node.val))
            return map.get(node.val);

        Node newNode = new Node(node.val, new ArrayList<Node>());
        map.put(newNode.val, newNode);
        for (Node neighbor : node.neighbors)
            newNode.neighbors.add(clone(neighbor));
        return newNode;
    }

    //solution 2: Iterative + BFS
    //slight modified from https://leetcode.com/problems/clone-graph/discuss/42482/Java-BFS-solution/655120
    //https://www.youtube.com/watch?v=dlYe6DkzxXg

    // O(n^2) time where n is the number of nodes. This is because for each node we iterate through all its neighbours and in the worst case all nodes are connected to each other.
    // O(n) space because we have exactly one map entry for each node and each node gets added and removed from the queue exactly once.
    public static Node cloneGraph2(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();      // Maps a node from original graph to the corresponding node in the cloned graph.
        Queue<Node> queue = new LinkedList<>();     // Do a BFS to create a copy of all nodes and create a copy of all edges.
        map.put(node, new Node(node.val));
        queue.add(node);
        while (queue.size() > 0) {
            Node currNode = queue.poll();
            // Create edges for currNode in the cloned graph.
            for (Node currNeighbor : currNode.neighbors) {
                if (!map.containsKey(currNeighbor)) {
                    map.put(currNeighbor, new Node(currNeighbor.val));         // Create a copy of currNeighbor.
                    queue.add(currNeighbor);                               // Add currNeighbor to the queue so that its edges will be added to the cloned graph.
                }
                map.get(currNode).neighbors.add(map.get(currNeighbor));       // Create the edge between currNode and the currNeighbor in the cloned graph.
            }
        }
        return map.get(node);
    }

    public static void main(String [] args){
        /*
                1 —— 2
                |    |
                4 —— 3
         */
        Node node1 = new Node(1, new ArrayList<>());
        Node node2 = new Node(2, new ArrayList<>());
        Node node3 = new Node(3, new ArrayList<>());
        Node node4 = new Node(4, new ArrayList<>());
        List<Node> node1ArrayList = new ArrayList<Node>();
        node1ArrayList.add(node2);
        node1ArrayList.add(node4);
        node1.neighbors = node1ArrayList;
        List<Node> node2ArrayList = new ArrayList<Node>();
        node2ArrayList.add(node1);
        node2ArrayList.add(node3);
        node2.neighbors = node2ArrayList;
        List<Node> node3ArrayList = new ArrayList<Node>();
        node3ArrayList.add(node2);
        node3ArrayList.add(node4);
        node3.neighbors = node3ArrayList;
        List<Node> node4ArrayList = new ArrayList<Node>();
        node4ArrayList.add(node1);
        node4ArrayList.add(node3);
        node4.neighbors = node4ArrayList;

        //TODO: Discover difference between DFS and BFS here
        cloneGraph(node1);
        cloneGraph2(node1);
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
