import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.Collections;
import java.nio.file.Files;
import java.nio.file.Path;

public class Driver {

        static Vector<String> vector = new Vector<String>();
        static Vector<String> vector2 = new Vector<String>();
        static Set<String> YT = new TreeSet<>(vector);
        static Set<String> PT = new TreeSet<>(vector2);
        //Word bee = new Word("bee", 5, 6);
        //Set<String> output = new TreeSet();
        static FileIO File = new FileIO();
        static Hashing Hash = new Hashing();

        public static void readFiles() 
        {
            //readFiles
            if (File.openTextFile("YT1.txt") == true) 
            {
                YT = (File.readTextFile("YT1.txt", false));
            }
            if (File.openTextFile("PT1.txt") == true) 
            {
                PT = (File.readTextFile("PT1.txt", false));
            } 
        }
        
        public static void debug()
        {
            //debug - above has to be called first or debug empty
            File.writeData(); 
        }
        

        public static void createListEqual()
        {
            // createListEqual
            Hash.writeListEqual();
        }
        
        public static void createListDiff()
        {
            //createListDifference
            Hash.writeListDifference();
        }
        public static void createEqual()
        {
            // createListEqual
            Hash.writeEqual();
        }

        public static void createDiff()
        {
            //createListDifference
            Hash.writeDifference();
        }
}

