public class Test
{
    public static void main(String args[])
    {
        BinarySearchTree tree = new BinarySearchTree();
        
        String s1 = "1";
        tree.insert("key1", s1);
        System.out.println(tree.find("key1"));
    }
}
