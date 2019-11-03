import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.ArrayList;

public class bejel_p2 {

    public String dataFile = "problem1.txt";
    public String outputFile = "unique_words.txt";

    public ArrayList<String> uniqueWords = new ArrayList<String>();
    public HashMap<String, Integer> wordCounter = new HashMap<>();

    public class DuplicateCounter {

        public void getWords(String dataFile) throws IOException {
            File infile = new File(dataFile);
            Scanner scan = new Scanner(infile);

            while(scan.hasNext()) {
                String s = scan.next();
                if(!uniqueWords.contains(scan.next())){
                    uniqueWords.add(s);
                }
            }


        }

        public void count(String dataFile) throws IOException {
            File infile = new File(dataFile);
            Scanner scan = new Scanner(infile);

            while(scan.hasNext()){
                String s = scan.next();
                if(!wordCounter.containsKey(s)){
                    wordCounter.put(s, 1);
                }
                else{
                    int count = wordCounter.get(s);
                    wordCounter.put(s, count+1);
                }
            }


        }

        public void write(String outputFile) throws IOException {
            File outfile = new File(outputFile);
            FileWriter fw = new FileWriter(outfile);

            for(String s : uniqueWords) {
                fw.write(wordCounter.get(s));
            }
        }
    }

    public class Application {

        public void main(String args[]) throws IOException {
            DuplicateCounter dc = new DuplicateCounter();
            dc.count(dataFile);
            dc.write(outputFile);
        }
    }
}
