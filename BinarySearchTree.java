import java.util.NoSuchElementException;
import java.io.*;

public class BinarySearchTree
{
    private class TreeNode
    {
        private String m_key;
        private Object m_value;
        private TreeNode m_leftChild;
        private TreeNode m_rightChild;

        TreeNode(String inKey, Object inValue)
        {
            if(inKey == null)
            {
                throw new IllegalArgumentException("Key cannot be null");
            }

            m_key = inKey;
            m_value = inValue;
            m_leftChild = null;
            m_rightChild = null;
        }

        public String getKey()
        {
            return m_key;
        }

        public Object getValue()
        {
            return m_value;
        }

        public TreeNode getLeft()
        {
            return m_leftChild;
        }

        public void setLeft(TreeNode inLeft)
        {
            m_leftChild = inLeft;
        }

        public void setRight(TreeNode inRight)
        {
            m_rightChild = inRight;
        }
        public TreeNode getRight()
        {
            return m_rightChild;
        }
    }

    TreeNode m_root;

    public BinarySearchTree()
    {
        m_root = null;
    }

    public Object find(String key)
    {
        return ((TreeNode)findRecursive(key, m_root)).getValue();
    }

    public void insert(String key, Object value)
    {
        insertRecursive(key, value, m_root);
    }

    public void delete(String key)
    {
        deleteRecursive(key, m_root);
    }

    public int height()
    {
        return 6;
    }

    private Object findRecursive(String key, TreeNode currentNode)
    {
        Object returnObj = null;

        if(currentNode == null)
        {
            throw new NoSuchElementException("Key " + key + " not found");
        }
        else if(currentNode.getKey().equals(key))
        {
            returnObj = currentNode;
        }
        else if(key.compareTo(currentNode.getKey()) < 0)
        {
            returnObj = findRecursive(key, currentNode.getLeft());
        }
        else
        {
            returnObj = findRecursive(key, currentNode.getRight());
        }

        return returnObj;
    }

    private TreeNode insertRecursive(String key, Object data, TreeNode currentNode)
    {
        TreeNode upDateNode = currentNode;

        if(currentNode == null)
        {
            TreeNode newNode = new TreeNode(key, data);
            upDateNode = newNode;
            if(m_root == null)
            {
                m_root = newNode;
            }
        }
        else if(key.equals(currentNode.getKey()))
        {
            System.out.println(currentNode.getKey() + "," + currentNode.getValue()
                               + " is alread in the tree and is being replaced");
        }
        else if(key.compareTo(currentNode.getKey()) < 0)
        {
            currentNode.setLeft(insertRecursive(key, data, currentNode.getLeft()));
        }
        else
        {
            currentNode.setRight(insertRecursive(key, data, currentNode.getRight()));
        }

        return upDateNode;

    }

    private TreeNode deleteRecursive(String key, TreeNode currentNode)
    {
        TreeNode updateNode = currentNode;
        if(currentNode == null)
        {
            throw new NoSuchElementException("Key " + key + " not found");
        }
        else if(key.equals(currentNode.getKey()))
        {
            updateNode = deleteNode(key, currentNode);
        }
        else if(key.compareTo(currentNode.getKey()) < 0)
        {
            currentNode.setLeft(deleteRecursive(key, currentNode.getLeft()));
        }
        else
        {
            currentNode.setRight(deleteRecursive(key, currentNode.getRight()));
        }
        return updateNode;
    }

    private TreeNode deleteNode(String key, TreeNode delNode)
    {
        TreeNode updateNode = null;

        if(delNode.getLeft() == null && delNode.getRight() == null)
        {
        }
        else if(delNode.getLeft() != null && delNode.getRight() == null)
        {
            updateNode = delNode.getLeft();
        }
        else if(delNode.getLeft() == null && delNode.getRight() != null)
        {
            updateNode = delNode.getRight();
        }
        else
        {
            updateNode = promoteSuccessor(delNode.getRight());
            updateNode.setLeft(delNode.getLeft());
        }

        return updateNode;
    }

    private TreeNode promoteSuccessor(TreeNode currentNode)
    {
        TreeNode successor = currentNode;

        if(currentNode.getLeft() != null)
        {
            successor = promoteSuccessor(currentNode.getLeft());
            if(successor.getKey().equals(currentNode.getLeft().getKey()))
            {
                if(successor.getRight() != null)
                {
                    currentNode.setLeft(successor.getRight());
                }
                successor.setRight(currentNode);
            }
        }

        return successor;
    }

    public void print()
    {
        printRec(m_root);
    }

    private void printRec(TreeNode currentNode)
    {

        if(currentNode.getLeft() != null)
        {
            printRec(currentNode.getLeft());
        }

        try
        { 
            FileOutputStream fos = new FileOutputStream("BSTTreePrint.txt", true);
            PrintWriter pw = new PrintWriter(fos);
            pw.println(currentNode.getKey() + "," + currentNode.getValue());
            pw.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        if(currentNode.getRight() != null)
        {
            printRec(currentNode.getRight());
        }
    }


}
