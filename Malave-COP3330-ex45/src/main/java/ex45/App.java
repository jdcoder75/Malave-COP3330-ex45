package ex45;

/*
 *  UCF COP3330 Fall 2021 Assignment 45 Solution
 *  Copyright 2021 Jose Malave
 */
import java.io.*;
import java.lang.IllegalStateException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class App 
{
    public static void output_File(String pathName, String original, String replace)throws IOException {

        Scanner scanner = new Scanner(System.in);

        //ask the user what they want the file name to be
        String outPut = scanner.nextLine();

        //get the path names for the input and output files
        Path path = Paths.get(pathName);
        Path toPath = Paths.get(outPut);

        //this is to help write over the words we want to change
        Charset charset = Charset.forName("UTF-8");

        //create the writer for the output
        BufferedWriter writer = Files.newBufferedWriter(toPath, charset);

        //here we want to scan in each line from the path
        // and writer it to the output
        Scanner sc = new Scanner(path, charset.name());
        String line;

        //similar to previous problems, take in the line
        //and output it
        //but before that we need to make sure that we are changing the original word to the new one
        while (sc.hasNextLine())
        {
            line = sc.nextLine();
            line = line.replaceAll(original, replace);
            writer.write(line);
            writer.newLine();
        }

        //close the scanner and writer
        scanner.close();
        writer.close();

    }
        public static void main (String[]args ) throws IOException {
        //send in the inpute file to the method outpute file, as well as the word that we want to change, and what
            //we want to change it to
            String path = "exercise45_input.txt";
            output_File(path, "utilize", "use");
        }


}
