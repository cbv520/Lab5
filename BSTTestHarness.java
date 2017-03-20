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

        String[] id = new String[7000];
        BinarySearchTree tree = new BinarySearchTree();

        /***********************************************
            importing data from RandomNames7000.csv
        ***********************************************/
        try
        {
            fis = new FileInputStream("RandomNames7000.csv");
            rdr = new InputStreamReader(fis);
            br = new BufferedReader(rdr);

            int i = 0;
            String[] entry;
            String line = br.readLine();
            while(line != null)
            {
                entry = line.split(",");
                try
                {
                    tree.insert(entry[0], entry[1]);
                    id[i] = entry[0];
                    i++;
                }
                catch(IllegalArgumentException e)
                {
                    System.out.println("Error: " + e.getMessage());
                }
                line = br.readLine();
            }

            fis.close();

        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        /***********************************************
           traverse tree in-order and print key and
           value to file BSTTreePrint.txt
        ***********************************************/
        tree.print();

        /***********************************************
            find all IDs in BST and print values to
            new file BSTValueOutput.txt
            (excludes values with a duplicate ID)
        ***********************************************/
        try
        {
            fos = new FileOutputStream("BSTValueOutput.txt");
            pw = new PrintWriter(fos);

            int i = 0;
            while(id[i] != null)
            {
                pw.println(tree.find(id[i]));
                i++;
            }

            pw.close();
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
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
