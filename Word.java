import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.Collections;
import java.nio.file.Files;
import java.nio.file.Path;

public class Word {
    StringTokenizer tokenizer;
    Vector<String> vector = new Vector<String>();
    Vector<String> vector2 = new Vector<String>();
    Set<String> set = new TreeSet<>(vector);
    String value;
    int countPT;
    int countYT;

    public Word(String value){
        //super()?
        this.value = value;
        //updateCountPT();
        //updateCountYT();

        this.countPT = updateCountPT();
        this.countYT = updateCountYT();


    }

    public String puncCheck(String word)
    {
        if (word.endsWith(".") || word.endsWith(",") || word.endsWith("?") || word.endsWith("!") || word.endsWith(";") || word.endsWith(":") || word.endsWith(")") ||
            word.endsWith("]") || word.endsWith("}") || word.endsWith("\""))
        {
            //System.out.print(test);
            word = word.replace("?", "");
            word = word.replace(".", "");
            word = word.replace(",", "");
            word = word.replace("!", "");
            word = word.replace(";", "");
            word = word.replace(":", "");
            word = word.replace(")", "");
            word = word.replace("]", "");
            word = word.replace("}", "");
            word = word.replace("\"", "");
            word = word.replace("(", "");
            word = word.replace("[", "");
            word = word.replace("{", "");
            //System.out.print(test);

            return word;
        }

        return word;
    }

    public Vector readYT()
        {
            Scanner infile = null;
            try
            {
                infile = new Scanner(new FileReader("YT1.txt"));
                //System.out.println("File found!");
                //infile = new Scanner(new FileReader(fileName));
            } 
            catch (FileNotFoundException e) 
            {
                System.out.println("File not found");
                e.printStackTrace(); // prints error(s)
                System.exit(0); // Exits entire program

            }

            // goes until EOF
            while (infile.hasNextLine()) {
                String lineCheck = infile.nextLine();
                // if there are any numbers, skips lines (for timestamp lines)
                if (lineCheck.matches(".*\\d.*"))
                {
                    lineCheck = infile.nextLine();
                }
                else 
                {
                    tokenizer = new StringTokenizer(lineCheck);
                    
                    // splits the line into seperate words 
                    while(tokenizer.hasMoreTokens()) {
                        String word = tokenizer.nextToken();
                        // makes each word lowercase 
                        word = word.toLowerCase();
                        // removes puncuation - make method 
                        word = puncCheck(word); 
                        // adds word to vector
                        vector.add(word);
                    }
                }
            }

            Collections.sort(vector);
            return vector;

        }

    public Vector readPT()
    {
        Scanner infile = null;
        try
        {
            infile = new Scanner(new FileReader("PT1.txt"));
            //System.out.println("File found!");
            //infile = new Scanner(new FileReader(fileName));
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("File not found");
            e.printStackTrace(); // prints error(s)
            System.exit(0); // Exits entire program

        }

        // goes until EOF
        while (infile.hasNextLine()) {
            String lineCheck = infile.nextLine();
            // if there are any numbers, skips lines (for timestamp lines)
            if (lineCheck.matches(".*\\d.*"))
            {
                lineCheck = infile.nextLine();
            }
            else 
            {
                tokenizer = new StringTokenizer(lineCheck);
                
                // splits the line into seperate words 
                while(tokenizer.hasMoreTokens()) {
                    String word2 = tokenizer.nextToken();
                    // makes each word lowercase 
                    word2 = word2.toLowerCase();
                    // removes puncuation - make method 
                    word2 = puncCheck(word2); 
                    // adds word to vector
                    vector2.add(word2);
                }
            }
        }

        Collections.sort(vector2);
        return vector2;

    }

    public int updateCountPT() 
    {
        Vector PT = readPT();
        //System.out.println(PT);
        return Collections.frequency(PT, value);     
    }

    public int updateCountYT() 
    {
        Vector YT = readYT();
        //System.out.println("YT");
       // System.out.println(YT);
        return Collections.frequency(YT, value);     
    }

    public String getValue() { return this.value; }
    public void setValue(String value) { this.value = value; }

    public int getCountPT() { return countPT; }
    public void setCountPT(int countPT) { this.countPT = countPT; }

    public int getCountYT() { return this.countYT; }
    public void setCountYT(int countYT) { this.countYT = countYT; }

    //@Override
    public String toString() {
        return "----------\n" + getValue() + "\n" + getCountPT() + "\n" + getCountYT() + "\n";
    }

}
