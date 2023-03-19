// Time complexity O(n)
// Space Complexity O(n)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<TreeNode> pathP = new ArrayList<>();
    List<TreeNode> pathQ = new ArrayList<>();


    /**
     * Finds and stores path to given node in reverse order into the given
     * list
     */

    public boolean getPath(TreeNode root, TreeNode node, List<TreeNode> list){
        if(root == null){
            return false;
        }
    
        if(root.val == node.val){
            list.add(node);
            return true;
        }

        boolean onLeftPath = getPath( root.left,  node, list);
        boolean onRightPath = getPath(root.right, node, list);

        if(onLeftPath || onRightPath){
            list.add(root);
            return true;
        }

        return false;
    }


    /**
     * Start by finding and storing path to q and p
     * Iterate through each list and store the current node 
     * until we reach the end of eithier list
     * or the TreeNode values are different 
     * 
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        getPath(root, p, pathP);
        getPath(root, q, pathQ);

        int i = pathP.size() - 1;
        int j = pathQ.size() - 1;

        TreeNode minNode = root;

        while(i >= 0 && j >=0){
            if(pathP.get(i).val == pathQ.get(j).val){
                minNode = pathP.get(i);  
            }
            else{
                break;
            }
                i--;
                j--;      
        }

        return minNode;
    }
}