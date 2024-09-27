import java.util.*;

public class BinarySearchTree {
   private TreeNode root;

   public BinarySearchTree() {
      root = null;
   }

   public void add(Comparable item) {
       root = add(root, item);
   }

   private TreeNode add(TreeNode tree, Comparable item) {
        if(tree == null) {
           return new TreeNode(item, null, null); // add the new node here
        } else if(item.compareTo(tree.getValue()) < 0) {
           tree.setLeft(add(tree.getLeft(), item)); // link nodes as you go left
        } else {
           tree.setRight(add(tree.getRight(), item)); // link nodes as you go right
        }
        return tree; // return the tree's root
   }

   // counts and returns the number of nodes in tree
   public int numNodes() {
      return numNodes(root);
   }

   public int numNodes(TreeNode node) {
        if(node == null) {
            return 0;
        } else {
            return 1 + numNodes(node.getLeft()) + numNodes(node.getRight());
        }
   }

   public int numLeaves() {
       return numLeaves(root);
   }

   // Part (a) - counts and returns the number of leaf nodes
   public int numLeaves(TreeNode node) {
        if(node == null) {
            return 0;
        }
        if(node.getLeft() == null && node.getRight() == null) {
            return 1; // This is a leaf node
        } else {
            return numLeaves(node.getLeft()) + numLeaves(node.getRight()); // Count leaves in subtrees
        }
   }

   public int numParents() {
       return numParents(root);
   }

   // Part (b) - counts and returns the number of parent nodes
   public int numParents(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int parentCount = 0;
        // Check if the current node is a parent
        if(node.getLeft() != null || node.getRight() != null) {
            parentCount = 1; // This is a parent node
        }
        // Recursively count parents in subtrees
        return parentCount + numParents(node.getLeft()) + numParents(node.getRight());
   }
      // returns true if all values stored in tree are less than key
      public boolean valsLess(int key) {
        return valsLess(root, key);
    }
 
    private boolean valsLess(TreeNode root, int key) {
        if(root == null)
            return true;
 
        int value = (Integer)root.getValue();
        return value < key && valsLess(root.getLeft(), key) && valsLess(root.getRight(), key);
    }
 
    // minValue - returns the minimum data value found in the tree (non-recursively)
    public Comparable minValue() {
        if (root == null) {
            return null; // or throw an exception if preferred
        }
        TreeNode current = root;
        while (current.getLeft() != null) {
            current = current.getLeft(); // traverse to the leftmost node
        }
        return (Comparable) current.getValue();
    }
 
    // treeHeight - returns the number of nodes along the longest path to a leaf
    public int treeHeight() {
        return treeHeight(root);
    }
 
    private int treeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = treeHeight(node.getLeft());
        int rightHeight = treeHeight(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1; // count current node
    }
 
    // hasPathSum - returns true if there is a path with a given sum
    public boolean hasPathSum(int sum) {
        return hasPathSum(root, sum);
    }
 
    private boolean hasPathSum(TreeNode node, int sum) {
        if (node == null) {
            return sum == 0; // If we reach a leaf, check if sum is 0
        }
        int value = (Integer)node.getValue();
        sum -= value; // Reduce sum by the current node's value
        // Check if we reach a leaf node
        if (node.getLeft() == null && node.getRight() == null) {
            return sum == 0;
        }
        // Recur for left and right subtrees
        return hasPathSum(node.getLeft(), sum) || hasPathSum(node.getRight(), sum);
    }
 
    // mirror - swaps the left and right children of all nodes
    public void mirror() {
        mirror(root);
    }
 
    private void mirror(TreeNode node) {
        if (node != null) {
            // Swap left and right children
            TreeNode temp = node.getLeft();
            node.setLeft(node.getRight());
            node.setRight(temp);
            // Recur for left and right subtrees
            mirror(node.getLeft());
            mirror(node.getRight());
        }
    }

   // prints tree vertically so that tree structure can be easily identified - uses reverse inorder
   public String toString() {
      return toString(root, 0);
   }

   // return string representation of tree's structure
   private String toString(TreeNode root, int level) {
        String str = "";
        if(root != null) {
            str += toString(root.getRight(), level + 1);
            for(int i = 1; i <= level; i++) {
                str += "  ";
            }
            str += root.getValue().toString() + "\n";
            str += toString(root.getLeft(), level + 1);
        }
        return str;
   }
}
