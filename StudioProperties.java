import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.Scanner;
import java.util.ListIterator;
import java.util.LinkedList;

public class StudioProperties {
    
    public static void main(String[] args) {
        String path = "";
        String property = "";
        String value = "";
        try{
            path = args[0];
            property = args[1];
            value = args[2];
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Missing arguments.");
            System.out.println("Example:");
            System.out.println("java StudioProperties (path to studio.properties file) (name of property) (new value of property)");
        } 
        try{
            File prefFile = new File(args[0]);
            Scanner prefReader = new Scanner(prefFile);
            LinkedList<String> prefLines = new LinkedList<String>();
            FileWriter prefWriter;
            
            while (prefReader.hasNextLine()) {
                prefLines.add(prefReader.nextLine());
            }
            prefReader.close();
            
            ListIterator<String> lineIterator = prefLines.listIterator(0);
            prefWriter = new FileWriter(args[0]);
            String temp; 
            
            while (lineIterator.hasNext()) {
                temp = lineIterator.next();
                if (temp.startsWith(property)) 
                {
                    temp=property+"="+value;
                }
                prefWriter.write(temp + "\n");
            }
            prefWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Preference file does not exist.");
        } catch (IOException e) {
            System.out.println("An unexpected error occurred...");
        }
    }
}