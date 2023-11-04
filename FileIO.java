import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.Collections;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileIO {
    //public static void main(String[] args) {
        boolean exists = false;
        PrintWriter outfile;
        StringTokenizer tokenizer;
        Vector<String> vector = new Vector<String>();
        Set<String> set = new TreeSet<>(vector);
        // checking if file can be opened 
        public boolean openTextFile(String filename)
        {
            Scanner infile = null;
            try
            {
                infile = new Scanner(new FileReader(filename));
                //System.out.println("File found!");
                return true;
                //infile = new Scanner(new FileReader(fileName));
            } 
            catch (FileNotFoundException e) 
            {
                System.out.println("File not found");
                e.printStackTrace(); // prints error(s)
                //System.exit(0); // Exits entire program
                return false;
            }
        }
        
        // Scanner scanner = new Scanner(System.in);

        // System.out.print("Please enter your filename := ");
        // String fileName = scanner.nextLine();
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

        // reads the textfile from input
        public Set readTextFile(String filename, boolean debug)
        {
            Scanner infile = null;
            try
            {
                infile = new Scanner(new FileReader(filename));
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
            // change to set to get rid of duplicates
            Set<String> set = new TreeSet<>(vector);
            //write to debug1 if true
            if (debug == true)
            {
                writeData();
            }

            return set;
  
        }
        // writes data from vector to debug1.txt
        public void writeData()
        {
            Collections.sort(vector);
            //if (set.isEmpty()) {}
            Set<String> set = new TreeSet<>(vector);
            try
            {
                outfile = new PrintWriter("debug1.txt");
                exists = true;
                Iterator itr = set.iterator();
                while (itr.hasNext())
                {
                    outfile.println(itr.next());
                }
                outfile.close();
        
            }
            catch(FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }
    
}
