import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.Collections;
import java.nio.file.Files;
import java.nio.file.Path;
// FOUND CODE HERE: https://favtutor.com/blogs/binary-search-tree-java
// Binary Search Tree
// came partially commented but I changed it a little bit here and there 
public class BST {
    // initialized variables 
    boolean exists = false;
    boolean first = false;
    PrintWriter out1;
    PrintWriter out3;
    FileWriter outfile1;
    int diff;
    public class Node {
        //instance variable of Node class
        public String data;
        public Node left;
        public Node right;
        //constructor
        public Node(String data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }
    // instance variable
    public Node root;

    // constructor for initialise the root to null BYDEFAULT
    public void BinarySearchTree() {
        this.root = null;
    }
    
    // used to check if a node exists (debugging)
    public void Exists()
    {
        exists = true;
    }

    // insert method to insert the new Date
    public void insert(String newData) {
        this.root = insert(root, newData);
    }

    public Node insert(Node root, String newData) {
        // Base Case: root is null or not
        if (root == null) {
            // Insert the new data, if root is null.
            root = new Node(newData);
            // return the current root to his sub tree
            return root;
        }
        // Here checking for root data is greater or equal to newData or not - used compareTo for strings 
        else if (root.data.compareTo(newData) >= 1){
            // if current root data is greater than the new data then now process the left sub-tree
            root.left = insert(root.left, newData);
        } else {
            // if current root data is less than the new data then now process the right sub-tree
            root.right = insert(root.right, newData);
        }
        return root;
    }

    //Traversal
    public void preorder() {
        preorder(root);
    }

    public void preorder(Node root) {
        // base case 
        if (root == null) {
            return;
        }
        // prints our in pre order 
        System.out.print(root.data + "\n");
        preorder(root.left);
        preorder(root.right);

    }

    // writes out the equal terms to a file 
    public void writeEqual_BSTData(PrintWriter filename) {
        //System.out.println("MEWO");
        writeEqual_BSTData(root, filename);
    }
    public void writeEqual_BSTData(Node root, PrintWriter filename)
    {
        // try - catch for the file opening 
        try
        {
            // each tree appends to the file, to avoid errors / overlapping, exists is set to true 
            // so it doesnt come back for each node
            if (exists != true) 
            {
                File file = new File("resultsEqual.txt");
                out1 = new PrintWriter(new FileWriter(file, true));
                exists = true;
             }
                // base case
                if (root == null) {
                    return;
                }
                // checks each node's stored word 
                Word check = new Word(root.data);
                // gets the count from PT and YT
                int YTCount = check.getCountYT();
                int PTCount = check.getCountPT();

                // if they are equal, write to the resultsEqual.txt
                if (YTCount == PTCount)
                {
                    out1.println(check.getValue() + "\t" + "\t" + PTCount);
                }
                //System.out.print(root.data + "\n");
                // continue until tree is empty 
                writeEqual_BSTData(root.left, out1);
                writeEqual_BSTData(root.right, out1);

                // set to false in case node needs to be visited again (writeDiff)
                exists = false;

                // close file we were writing to
                out1.close();
        }
        catch(IOException e)
        {
            System.out.print("ERROPR");
            e.printStackTrace();
        }
    }

    // writes out the different terms to a file 
    public void writeDiff_BSTData(PrintWriter filename) {
        //System.out.println("MEWO");
        writeDiff_BSTData(root, filename);
    }
    public void writeDiff_BSTData(Node root, PrintWriter filename)
    {
        try
        {
            // each tree appends to the file, to avoid errors / overlapping, exists is set to true 
            // so it doesnt come back for each node
            if (exists != true) 
            {
                File file2 = new File("resultsDiff.txt");
                out3 = new PrintWriter(new FileWriter(file2, true));
                exists = true;
            }
            if (root == null) {
                return;
            }
            // checks each node's stored word
            Word check = new Word(root.data);
            // gets the count from PT and YT
            int YTCount = check.getCountYT();
            int PTCount = check.getCountPT();

            // makes sure the values are different
            if (YTCount != PTCount)
                {
                    // depending on which is bigger, the output to the file will change
                    if (PTCount > YTCount)
                    {
                        diff = PTCount - YTCount;
                        //System.out.println("PT GREATER");
                        if (YTCount == 0)
                        {
                            out3.println(check.getValue() + "\t" + "\t" + "+" + diff + " PT" + " - ZERO");
                        }
                        else
                        {
                            out3.println(check.getValue() + "\t" + "\t" + "+" + diff + " PT");
                        }
                    }
                    else if (YTCount > PTCount)
                    {

                        diff = YTCount - PTCount;
                        if (PTCount == 0)
                        {
                            out3.println(check.getValue() + "\t" + "\t" + "+" + diff + " YT" + " - ZERO");
                        }
                        else
                        {
                            out3.println(check.getValue() + "\t" + "\t" + "+" + diff + " YT");
                        }
                        
                    }
                    //outfile.println("FUCK");
                }
                //exists = true;
                writeDiff_BSTData(root.left, out3);
                writeDiff_BSTData(root.right, out3);

                // set to false in case node needs to be visited again (writeEqual)
                exists = false;

                // close file we were writing to
                out3.close();
        
        }
        catch(IOException e)
        {
            System.out.print("ERROPR");
            e.printStackTrace();
        }
    }
    
}