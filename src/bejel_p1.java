import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;

public class bejel_p1 {

    public String dataFile = "problem1.txt";
    public String outputFile = "unique_words.txt";

    public class DuplicateRemover {

        public ArrayList<String> uniqueWords = new ArrayList<String>();


        public void remove(String dataFile) throws IOException {
            File infile = new File(dataFile);
            Scanner scan = new Scanner(infile);

            while(scan.hasNext()) {
                String s = scan.next();
                if(!uniqueWords.contains(scan.next())){
                    uniqueWords.add(s);
                }
            }


        }

        public void write(String outputFile) throws IOException {
            File outfile = new File(outputFile);
            FileWriter fw = new FileWriter(outfile);

            for(String s : uniqueWords) {
                fw.write(s);
            }
        }
    }

    public class Application {

        public void main(String args[]) throws IOException {
            DuplicateRemover dr = new DuplicateRemover();
            dr.remove(dataFile);
            dr.write(outputFile);
        }
    }
}
