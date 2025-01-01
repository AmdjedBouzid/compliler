import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();
        String path="C:\\Users\\TransHost\\Desktop\\3 ing\\s1\\Compelation\\tp\\projet\\lexical analyser\\input.txt";
        System.out.println();
        System.out.println();
       lexicalAnalyzer.analyse(path);
    //    for(Transition tr:lexicalAnalyzer.getTransitionsFromState(lexicalAnalyzer.getStateByName("0"))){
    //      System.out.println(tr.toString());
    //    }



        
    }


}
//   String keyWords[]={"répéter","jusqu'à","debut","fin","entier","caractère","réel","variable","constante","programme"};



