package com.askade.ideallq.model.nlp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.stream.XMLStreamException;

import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.cmdline.postag.POSModelLoader;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;

import opennlp.tools.sentdetect.SentenceModel;

import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.ObjectStream;

import opennlp.tools.util.PlainTextByLineStream;


/**
 *
 * @author mcealera
 */
public class NLPUtils {
    
      static String[] findSentences(String text) throws FileNotFoundException, IOException, XMLStreamException {

        String paragraph = text;
        
        System.out.println("Working Directory = " +
                      System.getProperty("user.dir"));

        InputStream is = new FileInputStream("lib/en-sent.bin");
        SentenceModel model = new SentenceModel(is);
        SentenceDetectorME sdetector = new SentenceDetectorME(model);

        String sentences[] = sdetector.sentDetect(paragraph);

        is.close();

        return sentences;

    }

    static List getWords(String filepath) throws FileNotFoundException {

        Scanner s = new Scanner(new File(filepath));
        ArrayList<String> wordList = new ArrayList<String>();
        while (s.hasNext()) {
            wordList.add(s.next());
        }
        s.close();

        return wordList;

    }
    
    static List getNouns(String text){
    
        List<String> words = new ArrayList();
        String[] elements = text.split("[\\s\\xA0]+");
        
         for (String word : elements) {
            if (word.endsWith("NN") || word.endsWith("NNS") || word.endsWith("NNP") || word.endsWith("NNPS")) {
                words.add(word.substring(0, word.indexOf("_")).replace(",", ""));
            }
    
       
    }
          return words;
    }
    

    static List simpleResolve(String text) {

        List<NLPWord> words = new ArrayList();
        String[] elements = text.split("[\\s\\xA0]+");

        for (String word : elements) {
            if (word.endsWith("NN") || word.endsWith("NNS") || word.endsWith("NNP") || word.endsWith("NNPS")) {
                words.add(new NLPWord(word.substring(0, word.indexOf("_")), "Noun"));
            } else if (word.endsWith("VB") || word.endsWith("VBD") || word.endsWith("VBG") || word.endsWith("VBN") || word.endsWith("VBP") || word.endsWith("VBZ")) {
                words.add(new NLPWord(word.substring(0, word.indexOf("_")), "Verb"));
            }

        }

        return words;
    }

    static List resolve(String text) {

        List<NLPWord> words = new ArrayList();
        String[] elements = text.split("[\\s\\xA0]+");

        for (String word : elements) {
            if (word.endsWith("NN")) {
                words.add(new NLPWord(word.substring(0, word.indexOf("_")), "Noun"));
            } else if (word.endsWith("NNS")) {
                words.add(new NLPWord(word.substring(0, word.indexOf("_")), "Noun Plural"));
            } else if (word.endsWith("NNP")) {
                words.add(new NLPWord(word.substring(0, word.indexOf("_")), "Proper Noun, Singular"));
            }
        }

        return words;

    }
    
     static String posTest(String text) throws IOException, FileNotFoundException, XMLStreamException{
    
        System.out.println("POS Test: ");
        StringBuilder results = new StringBuilder();
        
        POSModel model = new POSModelLoader().load(new File("lib/en-pos-maxent.bin"));
        PerformanceMonitor perfMon = new PerformanceMonitor(System.err, "sent");
        POSTaggerME tagger = new POSTaggerME(model);
    
        String input = text;
        ObjectStream<String> lineStream =
                new PlainTextByLineStream(new StringReader(input));
    
        perfMon.start();
        String line;
        while ((line = lineStream.read()) != null) {
    
            String whitespaceTokenizerLine[] = WhitespaceTokenizer.INSTANCE.tokenize(line);
            String[] tags = tagger.tag(whitespaceTokenizerLine);
    
            POSSample sample = new POSSample(whitespaceTokenizerLine, tags);
          
            System.out.println(sample.toString());
            results.append(sample.toString());
          
    
            perfMon.incrementCounter();
        }
        perfMon.stopAndPrintFinalResult();
        
        return results.toString();
    }

}
