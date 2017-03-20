import java.util.*;
import java.io.*;

public class BSTTestHarness
{
    public static void main(String args[])
    {
        FileInputStream fis;
        InputStreamReader rdr;   
        BufferedReader br;

        FileOutputStream fos;
        PrintWriter pw;

        Person[] person = new Person[7000];
        BinarySearchTree tree = new BinarySearchTree();
        
        try
        {
            fis = new FileInputStream("RandomNames7000.csv");
            rdr = new InputStreamReader(fis); 
            br = new BufferedReader(rdr);    

            for(int i = 0; i < 7000; i++)
            {
                String[] entry = br.readLine().split(",");
                person[i] = new Person(entry[0], entry[1]);
                tree.insert(entry[0], entry[1]);
            }

            fis.close();
                
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            tree.print();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            fos = new FileOutputStream("BSTValueOutput.txt");
            pw = new PrintWriter(fos);

            for(int i = 0; i < 7000; i++)
            {
                pw.println(tree.find(person[i].getID()));
                
            }
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        catch(NoSuchElementException e)
        {
            System.out.println("Error finding node in BST");
            System.out.println(e.getMessage());
        }
    }

    private static class Person
    {
        String name;
        String id;

        Person(String inID, String inName)
        {
            id = inID;
            name = inName;
        }

        public String getID()
        {
            return id;
        }
    }
}
