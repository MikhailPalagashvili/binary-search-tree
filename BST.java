public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node leftLink, rightLink;
        private int count;

        public Node(Key key, Value val, int count) {
            this.key = key;
            this.val = val;
            this.count = count;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else           return x.count;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null)                  return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)                    return get(x.leftLink, key);
        else if (cmp > 0)               return get(x.rightLink, key);
        else                            return x.val;

    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)  x.leftLink = put(x.leftLink, key, val);
        else if (cmp > 0) x.rightLink = put(x.rightLink, key, val);
        else x.val = val;
        x.count = size(x.leftLink) + size(x.rightLink) + 1;
        return x;
    }

    public Key min() {
        return min(root).key;
    }
    private Node min(Node x) {
        if(x.leftLink == null) return x;
        return min(x.leftLink);
    }

    public Key floor(Key key)
    {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }
    private Node floor(Node x, Key key)
    {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0)  return floor(x.leftLink, key);
        Node t = floor(x.rightLink, key);
        if (t != null) return t;
        else           return x;
    }
}
