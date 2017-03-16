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
            throw new IllegalArgumentException("Key " + key + " not found");
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

        }
        else if(key.compareTo(currentNode.getKey()) < 0)
        {
            System.out.println("LEFT");
            currentNode.setLeft(insertRecursive(key, data, currentNode.getLeft()));
        }
        else
        {
            System.out.println("RIGHT");
            currentNode.setRight(insertRecursive(key, data, currentNode.getRight()));
        }

        return upDateNode;

    }

    private TreeNode deleteRecursive(String key, TreeNode currentNode)
    {
        TreeNode updateNode = currentNode;
        if(currentNode == null)
        {
            throw new IllegalArgumentException("Key " + key + " not found");
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
            System.out.println(key + " no child");
        }
        else if(delNode.getLeft() != null && delNode.getRight() == null)
        {
            System.out.println(key + " left child");
            updateNode = delNode.getLeft();
        }
        else if(delNode.getLeft() == null && delNode.getRight() != null)
        {
            System.out.println(key + " right child");
            updateNode = delNode.getRight();
        }
        else
        {
            System.out.println(key + " 2 child");
            updateNode = promoteSuccessor(delNode.getRight());
        }

        return updateNode;
    }

    private TreeNode promoteSuccessor(TreeNode currentNode)
    {
        TreeNode successor = currentNode;

        if(currentNode.getLeft() == null)
        {
            successor = currentNode;
        }
        else
        {
            successor = promoteSuccessor(currentNode.getLeft());
            if(currentNode.getKey().equals(successor.getLeft().getKey()))
            {
                currentNode.setLeft(successor.getRight());
            }
        }

        return successor;
    }
}
