public class Test
{
    public static void main(String args[])
    {
        BinarySearchTree tree = new BinarySearchTree();

        String s1 = "1";
        String s2 = "2";
        String s3 = "3";
        String s4 = "4";
        String s5 = "5";
        tree.insert("key3", s2);
        tree.insert("key2", s3);
        tree.insert("key4", s4);
        tree.insert("key1", s1);
        tree.insert("key5", s5);
        System.out.println(tree.find("key5"));
        System.out.println(tree.find("key1"));
        System.out.println(tree.find("key2"));
        System.out.println(tree.find("key4"));
        System.out.println(tree.find("key3"));
        System.out.println(tree.find("key5"));

    }
}
