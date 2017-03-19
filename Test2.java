public class Test2
{
    public static void main(String args[])
    {
        BinarySearchTree tree = new BinarySearchTree();

        String s50 = "50";
        String s25 = "25";
        String s12 = "12";
        String s38 = "38";
        String s6 = "6";
        String s20 = "20";
        String s31 = "31";
        String s44 = "44";
        String s3 = "3";
        String s10 = "10";
        String s15 = "15";
        String s23 = "23";
        String s75 = "75";
        String s60 = "60";
        String s85 = "85";
        String s55 = "55";
        String s100 = "100";


<<<<<<< HEAD
        tree.insert("key5.0", s50);
        tree.insert("key2.5", s25);
        tree.insert("key7.5", s75);
        tree.insert("key1.2", s12);
        tree.insert("key3.8", s38);
        tree.insert("key6.0", s60);
        tree.insert("key8.5", s85);
        tree.insert("key5.5", s55);
        tree.insert("key10.0", s100);
        tree.insert("key.6", s6);
        tree.insert("key2.0", s20);
        tree.insert("key3.1", s31);
        tree.insert("key4.4", s44);
        tree.insert("key.3", s3);
        tree.insert("key1.0", s10);
        tree.insert("key1.5", s15);
        tree.insert("key2.3", s23);

        tree.test();

        tree.delete("key2.5");

        System.out.println(tree.find("key1.2"));
        System.out.println(tree.find("key3.8"));
        System.out.println(tree.find("key.6"));
        System.out.println(tree.find("key2.0"));
        System.out.println(tree.find("key3.1"));
        System.out.println(tree.find("key4.4"));
        System.out.println(tree.find("key.3"));
        System.out.println(tree.find("key10.0"));
        System.out.println(tree.find("key1.5"));
        System.out.println(tree.find("key2.3"));
        try
        {
            System.out.println(tree.find("key2.5"));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
=======
        tree.insert("key50", s50);
        tree.insert("key25", s25);
        tree.insert("key75", s75);
        tree.insert("key12", s12);
        tree.insert("key38", s38);
        tree.insert("key60", s60);
        tree.insert("key85", s85);
        tree.insert("key55", s55);
        tree.insert("key100", s100);
        tree.insert("key6", s6);
        tree.insert("key20", s20);
        tree.insert("key31", s31);
        tree.insert("key44", s44);
        tree.insert("key3", s3);
        tree.insert("key10", s10);
        tree.insert("key15", s15);
        tree.insert("key23", s23);

        tree.delete("key25");

        System.out.println(tree.find("key12"));
        System.out.println(tree.find("key38"));
        System.out.println(tree.find("key6"));
        System.out.println(tree.find("key20"));
        System.out.println(tree.find("key31"));
        System.out.println(tree.find("key44"));
>>>>>>> 1cd2afe74f8ee68615d15086ecdfc2f1238fa58f

    }
}
