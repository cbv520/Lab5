public class Test
{
    public static void main(String args[])
    {
        BinarySearchTree tree = new BinarySearchTree();

        String s10 = "10";
        String s20 = "20";
        String s25 = "25";
        String s30 = "30";
        String s35 = "35";
        String s40 = "40";
        String s50 = "50";
        String s27 = "27";
        String s33 = "33";
        String s21 = "21";
        String s23 = "23";
        tree.insert("key30", s30);
        tree.insert("key20", s20);
        tree.insert("key40", s40);
        tree.insert("key10", s10);
        tree.insert("key50", s50);
        tree.insert("key25", s25);
        tree.insert("key35", s35);
        tree.insert("key27", s27);
        tree.insert("key33", s33);
        tree.insert("key21", s21);
        tree.insert("key23", s23);
        System.out.println(tree.find("key50"));
        System.out.println(tree.find("key10"));
        System.out.println(tree.find("key20"));
        System.out.println(tree.find("key40"));
        System.out.println(tree.find("key30"));
        System.out.println(tree.find("key50"));

        System.out.println("======");


<<<<<<< HEAD
        tree.delete("key40");
        //tree.delete();
        //System.out.println(tree.find("key33"));
        //System.out.println(tree.find("key35"));
        System.out.println(tree.find("key50"));
        System.out.println(tree.find("key40"));
=======
        tree.delete("key20");
        System.out.println(tree.find("key10"));
        System.out.println(tree.find("key23"));
        System.out.println(tree.find("key25"));
        System.out.println(tree.find("key27"));
        System.out.println(tree.find("key20"));
>>>>>>> 1cd2afe74f8ee68615d15086ecdfc2f1238fa58f

        /*System.out.println(tree.find("key10"));
        System.out.println(tree.find("key20"));
        System.out.println(tree.find("key30"));
        System.out.println(tree.find("key40"));
        System.out.println(tree.find("key50"));*/

    }
}
