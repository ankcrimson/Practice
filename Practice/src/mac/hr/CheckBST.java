package mac.hr;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;



public class CheckBST {

	/**
	 * kept simple to make it short
	 * @author asriv5
	 *
	 */
	class Node{
		int val;
		Node left;
		Node right;
	}
	
	public boolean checkBST(Node root,int min, int max){
		
		boolean result=true;
		
		if(root.val<=min|| root.val>=max){
			return false;
		}
		
		int minLeft=Math.min(min, root.val);
		int maxLeft=root.val;
		int minRight=root.val;
		int maxRight=Math.max(max,root.val);
		
		result = (root.left==null||checkBST(root.left, minLeft, maxLeft))
				&& 
				(root.right==null || checkBST(root.right, minRight, maxRight));
		return result;
	}
	
	
	public Node createTree(String treeDetails, String rootVal){
		String[] treeData = treeDetails.split(",");
		Map<String,Node> references=new HashMap<>();
		
		for(String nodeData:treeData){
			String[] nodeDetails=nodeData.split("l");
			boolean left=true;
			if(nodeDetails.length==1){
			nodeDetails=nodeData.split("r");
			left=false;
			}
			Node currNode;
			if(references.containsKey(nodeDetails[0])){
				currNode=references.get(nodeDetails[0]);
			}else{
				currNode=new Node();
				currNode.val=Integer.parseInt(nodeDetails[0]);
				references.put(nodeDetails[0], currNode);
			}
			Node newNode=new Node();
			newNode.val=Integer.parseInt(nodeDetails[1]);
			if(left){
				currNode.left=newNode;
			}else{
				currNode.right=newNode;
			}
			references.put(nodeDetails[1], newNode);
		}
		return references.get(rootVal);
	}
	
	@Test
	public void positiveTest(){
		String treeDetails="50l10,10l5,10r30,30l20,30r40,50r80,80l70,80r90,90l85";
		Node root=createTree(treeDetails, "50");
		Assert.assertTrue("Tree is not BST: "+treeDetails,checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
	
	@Test
	public void negativeTest1(){
		String treeDetails="50l4,4l5,4r30,30l20,30r40,50r80,80l70,80r90,90l85";
		Node root=createTree(treeDetails, "50");
		Assert.assertFalse("Tree is BST: "+treeDetails,checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
	
	@Test
	public void negativeTest2(){
		String treeDetails="50l10,10l5,10r9,9l12,9r40,50r80,80l70,80r90,90l85";
		Node root=createTree(treeDetails, "50");
		Assert.assertFalse("Tree is BST: "+treeDetails,checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
	@Test
	public void negativeTest3(){
		String treeDetails="50l10,10l5,10r9,9l12,9r40,50r80,80l45,80r90,90l85";
		Node root=createTree(treeDetails, "50");
		Assert.assertFalse("Tree is BST: "+treeDetails,checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
}
