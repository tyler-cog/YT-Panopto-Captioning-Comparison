import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.Collections;
import java.nio.file.Files;
import java.nio.file.Path;

public class Hashing {
    FileIO File = new FileIO();
    Map<String, Vector<String>> map = new HashMap<String, Vector<String>>();
    Vector<String> vector = new Vector<String>();
    Set<String> set = new TreeSet<>(vector);
    boolean treeCheck = false;
    boolean tableCheck = false;
    PrintWriter outfile;
    PrintWriter outfile1;
    PrintWriter outfile2;
    BST a = new BST();
    BST b = new BST();
    BST c = new BST();
    BST d = new BST();
    BST e = new BST();
    BST f = new BST();
    BST g = new BST();
    BST h = new BST();
    BST i = new BST();
    BST j = new BST();
    BST k = new BST();
    BST l = new BST();
    BST m = new BST();
    BST n = new BST();
    BST o = new BST();
    BST p = new BST();
    BST q = new BST();
    BST r = new BST();
    BST s = new BST();
    BST t = new BST();
    BST u = new BST();
    BST v = new BST();
    BST w = new BST();
    BST x = new BST();
    BST y = new BST();
    BST z = new BST();


    
    public void fillTable()
    {
        Vector<String> a = new Vector<String>();
        Vector<String> b = new Vector<String>();
        Vector<String> c = new Vector<String>();
        Vector<String> d = new Vector<String>();
        Vector<String> e = new Vector<String>();
        Vector<String> f = new Vector<String>();
        Vector<String> g = new Vector<String>();
        Vector<String> h = new Vector<String>();
        Vector<String> i = new Vector<String>();
        Vector<String> j = new Vector<String>();
        Vector<String> k = new Vector<String>();
        Vector<String> l = new Vector<String>();
        Vector<String> m = new Vector<String>();
        Vector<String> n = new Vector<String>();
        Vector<String> o = new Vector<String>();
        Vector<String> p = new Vector<String>();
        Vector<String> q = new Vector<String>();
        Vector<String> r = new Vector<String>();
        Vector<String> s = new Vector<String>();
        Vector<String> t = new Vector<String>();
        Vector<String> u = new Vector<String>();
        Vector<String> v = new Vector<String>();
        Vector<String> w = new Vector<String>();
        Vector<String> x = new Vector<String>();
        Vector<String> y = new Vector<String>();
        Vector<String> z = new Vector<String>();

        if (File.openTextFile("YT1.txt") == true) 
        {
            set = File.readTextFile("YT1.txt", false);
        }
        if (File.openTextFile("PT1.txt") == true) 
        {
            set = File.readTextFile("PT1.txt", false);
        } 

        //System.out.println(set);
        
        //String vec_name = start_char;
        for (String set: set)
        {
            //System.out.println(set);
            if (set.startsWith("a"))
            {
                a.add(set);
            }
            else if (set.startsWith("b"))
            {
                b.add(set);
            }
            else if (set.startsWith("c"))
            {
                c.add(set);
            }
            else if (set.startsWith("d"))
            {
                d.add(set);
            }
            else if (set.startsWith("e"))
            {
                e.add(set);
            }
            else if (set.startsWith("f"))
            {
                f.add(set);
            }
            else if (set.startsWith("g"))
            {
                g.add(set);
            }
            else if (set.startsWith("h"))
            {
                h.add(set);
            }
            else if (set.startsWith("i"))
            {
                i.add(set);
            }
            else if (set.startsWith("j"))
            {
                j.add(set);
            }
            else if (set.startsWith("k"))
            {
                k.add(set);
            }
            else if (set.startsWith("l"))
            {
                l.add(set);
            }
            else if (set.startsWith("m"))
            {
                m.add(set);
            }
            else if (set.startsWith("n"))
            {
                n.add(set);
            }
            else if (set.startsWith("o"))
            {
                o.add(set);
            }
            else if (set.startsWith("p"))
            {
                p.add(set);
            }
            else if (set.startsWith("q"))
            {
                q.add(set);
            }
            else if (set.startsWith("r"))
            {
                r.add(set);
            }
            else if (set.startsWith("s"))
            {
                s.add(set);
            }
            else if (set.startsWith("t"))
            {
                t.add(set);
            }
            else if (set.startsWith("u"))
            {
                u.add(set);
            }
            else if (set.startsWith("v"))
            {
                v.add(set);
            }
            else if (set.startsWith("w"))
            {
                w.add(set);
            }
            else if (set.startsWith("x"))
            {
                x.add(set);
            }
            else if (set.startsWith("y"))
            {
                y.add(set);
            }
            else if (set.startsWith("z"))
            {
                z.add(set);
            }
        }

        map.put("A", a);
        map.put("B", b);
        map.put("C", c);
        map.put("D", d);
        map.put("E", e);
        map.put("F", f);
        map.put("G", g);
        map.put("H", h);
        map.put("I", i);
        map.put("J", j);
        map.put("K", k);
        map.put("L", l);
        map.put("M", m);
        map.put("N", n);
        map.put("O", o);
        map.put("P", p);
        map.put("Q", q);
        map.put("R", r);
        map.put("S", s);
        map.put("T", t);
        map.put("U", u);
        map.put("V", v);
        map.put("W", w);
        map.put("X", x);
        map.put("Y", y);
        map.put("Z", z);

       //tableCheck = true;
        
    }

    public boolean tableFilled()
    {
        return tableCheck;
    }
   
        
    public void writeListEqual()
    {
        if (tableFilled() == false)
        {
            fillTable();
        }
        

        try
        {
            outfile = new PrintWriter("resultsListEqual.txt");

            for (Map.Entry<String, Vector<String>> entry : map.entrySet()) 
            {
                String key = entry.getKey();
                Vector<String> values = entry.getValue();
                Iterator itr = values.iterator();
                while (itr.hasNext())
                {
                    String word = (String) itr.next();
                    //System.out.println("word = " + word);
                    Word check = new Word(word);
                    int YTCount = check.getCountYT();
                    int PTCount = check.getCountPT();
                    // System.out.println("YTCOUNT = " + check.getCountYT()); //, "PTCOUNT = " + check.getCountPT());
                    // System.out.println("PTCOUNT = " + check.getCountPT());
                    if (YTCount == PTCount)
                    {
                        //outfile.println("FUCK");
                        outfile.println(check.getValue() + "\t" + "\t" + check.getCountPT());
                    }
                }
                // System.out.println("Key = " + key);
                // System.out.println("Values = " + values + "n");
    
            }
            outfile.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public void writeListDifference()
    {

        if (tableFilled() == false)
        {
            fillTable();
        }
     

        try
        {
            outfile = new PrintWriter("resultsListDiff.txt");

            for (Map.Entry<String, Vector<String>> entry : map.entrySet()) 
            {
                String key = entry.getKey();
                Vector<String> values = entry.getValue();
                Iterator itr = values.iterator();
                while (itr.hasNext())
                {
                    String word = (String) itr.next();
                    //System.out.println("word = " + word);
                    Word check = new Word(word);
                    int YTCount = check.getCountYT();
                    int PTCount = check.getCountPT();
                    // System.out.println("YTCOUNT = " + check.getCountYT()); //, "PTCOUNT = " + check.getCountPT());
                    // System.out.println("PTCOUNT = " + check.getCountPT());
                    if (YTCount != PTCount)
                    {
                        if (PTCount > YTCount)
                        {
                            int diff = PTCount - YTCount;
                            //System.out.println("PT GREATER");
                            if (YTCount == 0)
                            {
                                outfile.println(check.getValue() + "\t" + "\t" + "+" + diff + " PT" + " - ZERO");
                            }
                            else
                            {
                                outfile.println(check.getValue() + "\t" + "\t" + "+" + diff + " PT");
                            }
                        }
                        else if (YTCount > PTCount)
                        {
                            // System.out.println("YTCOUNT = " + check.getCountYT()); //, "PTCOUNT = " + check.getCountPT());
                            //System.out.println("PTCOUNT = " + check.getCountPT());
                            //System.out.println("YT GREATER");
                            int diff = YTCount - PTCount;
                            if (PTCount == 0)
                            {
                                outfile.println(check.getValue() + "\t" + "\t" + "+" + diff + " YT" + " - ZERO");
                            }
                            else
                            {
                                outfile.println(check.getValue() + "\t" + "\t" + "+" + diff + " YT");
                            }
                            
                        }
                        //outfile.println("FUCK");
                    }
                }
                // System.out.println("Key = " + key);
                // System.out.println("Values = " + values + "n");
    
            }
            outfile.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }



    public void fillTree()
    {
        


        if (File.openTextFile("YT1.txt") == true) 
        {
            set = File.readTextFile("YT1.txt", false);
        }
        if (File.openTextFile("PT1.txt") == true) 
        {
            set = File.readTextFile("PT1.txt", false);
        } 

        //System.out.println(set);
        
        //String vec_name = start_char;
        for (String set: set)
        {
            if (set.startsWith("a"))
                {
                    a.insert(set);
                    //a.First();
                }
                else if (set.startsWith("b"))
                {
                    b.insert(set);
                    //a.insert(set);
                    //b.Exists();
                }
                else if (set.startsWith("c"))
                {
                    c.insert(set);
                    //c.Exists();
                }
                else if (set.startsWith("d"))
                {
                    d.insert(set);
                    //d.Exists();
                }
                else if (set.startsWith("e"))
                {
                    e.insert(set);
                    //e.Exists();
                }
                else if (set.startsWith("f"))
                {
                    f.insert(set);
                    //f.Exists();
                }
                else if (set.startsWith("g"))
                {
                    g.insert(set);
                    //g.Exists();
                }
                else if (set.startsWith("h"))
                {
                    h.insert(set);
                    //h.Exists();
                }
                else if (set.startsWith("i"))
                {
                    i.insert(set);
                    //i.Exists();
                }
                else if (set.startsWith("j"))
                {
                    j.insert(set);
                    //j.Exists();
                }
                else if (set.startsWith("k"))
                {
                    k.insert(set);
                    //k.Exists();
                }
                else if (set.startsWith("l"))
                {
                    l.insert(set);
                    //l.Exists();
                }
                else if (set.startsWith("m"))
                {
                    m.insert(set);
                    //m.Exists();
                }
                else if (set.startsWith("n"))
                {
                    n.insert(set);
                    //n.Exists();
                }
                else if (set.startsWith("o"))
                {
                    o.insert(set);
                    //o.Exists();
                }
                else if (set.startsWith("p"))
                {
                    p.insert(set);
                    //p.Exists();
                }
                else if (set.startsWith("q"))
                {
                    q.insert(set);
                    //q.Exists();
                }
                else if (set.startsWith("r"))
                {
                    r.insert(set);
                    //r.Exists();
                }
                else if (set.startsWith("s"))
                {
                    s.insert(set);
                    //s.Exists();
                }
                else if (set.startsWith("t"))
                {
                    t.insert(set);
                    //t.Exists();
                }
                else if (set.startsWith("u"))
                {
                    u.insert(set);
                    //u.Exists();
                }
                else if (set.startsWith("v"))
                {
                    v.insert(set);
                    //v.Exists();
                }
                else if (set.startsWith("w"))
                {
                    w.insert(set);
                    //w.Exists();
                }
                else if (set.startsWith("x"))
                {
                    x.insert(set);
                    //x.Exists();
                }
                else if (set.startsWith("y"))
                {
                    y.insert(set);
                    //y.Exists();
                }
                else if (set.startsWith("z"))
                {
                    z.insert(set);
                    //z.Exists();
                }
        }
        treeCheck = true;
        //a.preorder();
        // b.preorder();
    }

    public boolean treeFilled()
    {
        return treeCheck;
    }
    public void writeEqual()
    {
        if (treeFilled() == false)
        {
            fillTree();
        }
        //a.preorder();

        //a.preorder();
        // System.out.println("FUCK");
        try {
            File file2 = new File("resultsEqual.txt");
            PrintWriter out = new PrintWriter(new FileWriter(file2, false));
            a.writeEqual_BSTData(out);
            b.writeEqual_BSTData(out);
            c.writeEqual_BSTData(out);
            d.writeEqual_BSTData(out);
            e.writeEqual_BSTData(out);
            f.writeEqual_BSTData(out);
            g.writeEqual_BSTData(out);
            h.writeEqual_BSTData(out);
            i.writeEqual_BSTData(out);
            j.writeEqual_BSTData(out);
            k.writeEqual_BSTData(out);
            l.writeEqual_BSTData(out);
            m.writeEqual_BSTData(out);
            n.writeEqual_BSTData(out);
            o.writeEqual_BSTData(out);
            p.writeEqual_BSTData(out);
            q.writeEqual_BSTData(out);
            r.writeEqual_BSTData(out);
            s.writeEqual_BSTData(out);
            t.writeEqual_BSTData(out);
            u.writeEqual_BSTData(out);
            v.writeEqual_BSTData(out);
            w.writeEqual_BSTData(out);
            x.writeEqual_BSTData(out);
            y.writeEqual_BSTData(out);
            z.writeEqual_BSTData(out);

            out.close();
            //outfile2.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
        
    }



    public void writeDifference()
    {
        if (treeFilled() == false)
        {
            fillTree();
        }
        try {
            File file3 = new File("resultsDiff.txt");
            PrintWriter out2 = new PrintWriter(new FileWriter(file3, false));
            a.writeDiff_BSTData(out2);
            b.writeDiff_BSTData(out2);
            c.writeDiff_BSTData(out2);
            d.writeDiff_BSTData(out2);
            g.writeDiff_BSTData(out2);
            h.writeDiff_BSTData(out2);
            i.writeDiff_BSTData(out2);
            j.writeDiff_BSTData(out2);
            k.writeDiff_BSTData(out2);
            l.writeDiff_BSTData(out2);
            m.writeDiff_BSTData(out2);
            n.writeDiff_BSTData(out2);
            o.writeDiff_BSTData(out2);
            p.writeDiff_BSTData(out2);
            q.writeDiff_BSTData(out2);
            r.writeDiff_BSTData(out2);
            s.writeDiff_BSTData(out2);
            t.writeDiff_BSTData(out2);
            u.writeDiff_BSTData(out2);
            v.writeDiff_BSTData(out2);
            w.writeDiff_BSTData(out2);
            x.writeDiff_BSTData(out2);
            y.writeDiff_BSTData(out2);
            z.writeDiff_BSTData(out2);

            out2.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

}
