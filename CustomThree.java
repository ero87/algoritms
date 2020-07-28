package am.example.algoritms;

public class CustomThree {

    public static void main(String[] params) {
//        Node root =
//                new Node(20,
//                        new Node(7,
//                                new Node(4, null, new Node(6)), new Node(9)),
//                        new Node(35,
//                                new Node(31, new Node(28), null),
//                                new Node(40, new Node(38), new Node(52))));
        Node root = new Node(20);
        root.add(root, 7);
        root.add(root, 4);
        root.add(root, 3);
        root.add(root, 10);

        System.out.println("Sum = " + root.sum());
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(int value) {
            this.value = value;
        }


        private Node add(Node current, int value) {

            if (current == null) {
                return new Node(value);
            }

            if (value < current.value) {
                current.left = add(current.left, value);
            } else if (value > current.value) {
                current.right = add(current.right, value);
            }

            return current;
        }

        private boolean containsNode(Node current, int value) {
            if (current == null) {
                return false;
            }

            if (value == current.value) {
                return true;
            }

            return value < current.value
                    ? containsNode(current.left, value)
                    : containsNode(current.right, value);
        }

        private int minValue(Node root) {
            int minv = root.value;
            while (root.left != null) {
                minv = root.left.value;
                root = root.left;
            }
            return minv;
        }

        Node deleteRec(Node root, int key) {
            if (root == null) {
                return root;
            }
            if (key < root.value) {
                root.left = deleteRec(root.left, key);
            } else if (key > root.value) {
                root.right = deleteRec(root.right, key);
            } else {
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }
                root.value = minValue(root.right);
                root.right = deleteRec(root.right, root.value);
            }
            return root;
        }

        public int sum() {
            int summ = value;

            if (left != null) {
                summ += left.sum();
            }
            if (right != null) {
                summ += right.sum();
            }
            return summ;
        }
    }
}
