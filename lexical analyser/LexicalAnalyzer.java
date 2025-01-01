import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LexicalAnalyzer {
    public ArrayList<State> states;
    public ArrayList<Transition> transitions;
    public ArrayList<Error>Errors;
        public  ArrayList<Token> tokens;
    ArrayList<Character> allCharsAndChifrs = new ArrayList<>(Arrays.asList(
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y', 'z',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    ));
    public LexicalAnalyzer() {
        this.states = new ArrayList<>();
        this.transitions = new ArrayList<>();
        this.Errors=new ArrayList<>();
        this.tokens=new ArrayList<>();
        initializeStates();
        initializeTransitions();
    }
    public static boolean contains(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return true;  // Element found
            }
        }
        return false;  // Element not found
    }

    private void initializeStates() {
        for (int i = 0; i <= 79; i++) {
            boolean isFinal = i != 0; 
            states.add(new State(String.valueOf(i), !isFinal, isFinal, null));
            int[] keywordStates = {43, 39, 7, 33, 16, 24, 46,51, 70, 77};
            int[] operatorStates = {52, 53, 54, 55,56, 57, 58,79,65,66,60};
            if(contains(keywordStates,i)){
                states.get(i).tokenTypeOut="Keyword";
            }
            if(contains(operatorStates,i)){
                states.get(i).tokenTypeOut="operator";
            }
            if(!contains(operatorStates,i) && !contains(keywordStates,i) && i!=0){
                states.get(i).tokenTypeOut="id";
            }
        }
  
    }
    ArrayList<Character> getAllLettersAndDigitsExcluding(ArrayList<Character> excludedChars) {
        ArrayList<Character> allChars = new ArrayList<>(Arrays.asList(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
        ));

        // Remove the characters in excludedChars from allChars
        allChars.removeAll(excludedChars);

        // Return the filtered list
        return allChars;
    }
    ArrayList<Character> getAllLettersExcluding(ArrayList<Character> excludedChars) {
        ArrayList<Character> allChars = new ArrayList<>(Arrays.asList(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'
        ));

        // Remove the characters in excludedChars from allChars
        allChars.removeAll(excludedChars);

        // Return the filtered list
        return allChars;
    }
    private void initializeTransitions() {

  // Sequential transitions for the word 'program'
transitions.add(new Transition(
    0, 
    this.getStateByName("0"), 
    this.getStateByName("1"), 
    new ArrayList<>(Arrays.asList('p'))  // transition from state 0 to state 1 on 'p'
));

transitions.add(new Transition(
    1, 
    this.getStateByName("1"), 
    this.getStateByName("2"), 
    new ArrayList<>(Arrays.asList('r'))  // transition from state 1 to state 2 on 'r'
));

transitions.add(new Transition(
    2, 
    this.getStateByName("2"), 
    this.getStateByName("3"), 
    new ArrayList<>(Arrays.asList('o'))  // transition from state 2 to state 3 on 'o'
));

transitions.add(new Transition(
    3, 
    this.getStateByName("3"), 
    this.getStateByName("4"), 
    new ArrayList<>(Arrays.asList('g'))  // transition from state 3 to state 4 on 'g'
));

transitions.add(new Transition(
    4, 
    this.getStateByName("4"), 
    this.getStateByName("5"), 
    new ArrayList<>(Arrays.asList('r'))  // transition from state 4 to state 5 on 'r'
));

transitions.add(new Transition(
    5, 
    this.getStateByName("5"), 
    this.getStateByName("6"), 
    new ArrayList<>(Arrays.asList('a'))  // transition from state 5 to state 6 on 'a'
));

transitions.add(new Transition(
    6, 
    this.getStateByName("6"), 
    this.getStateByName("7"), 
    new ArrayList<>(Arrays.asList('m'))  // transition from state 6 to state 7 on 'm'
));


// Transitions from each state to state 78, excluding the next character of the word 'program'


transitions.add(new Transition(
    1, 
    this.getStateByName("1"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('r')))  // All except 'r'
));

transitions.add(new Transition(
    2, 
    this.getStateByName("2"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('o')))  // All except 'o'
));

transitions.add(new Transition(
    3, 
    this.getStateByName("3"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('g')))  // All except 'g'
));

transitions.add(new Transition(
    4, 
    this.getStateByName("4"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('r')))  // All except 'r'
));

transitions.add(new Transition(
    5, 
    this.getStateByName("5"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('a')))  // All except 'a'
));

transitions.add(new Transition(
    6, 
    this.getStateByName("6"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('m')))  // All except 'm'
));

transitions.add(new Transition(
    6, 
    this.getStateByName("7"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(allCharsAndChifrs) 
));


 //---constante---//

// Transition from state 0 to state 8 with 'c'
transitions.add(new Transition(
    0, 
    this.getStateByName("0"), 
    this.getStateByName("8"), 
    new ArrayList<>(Arrays.asList('c'))
));

// Transition from state 8 to state 9 with 'o'
transitions.add(new Transition(
    8, 
    this.getStateByName("8"), 
    this.getStateByName("9"), 
    new ArrayList<>(Arrays.asList('o'))
));

// Transition from state 9 to state 10 with 'n'
transitions.add(new Transition(
    9, 
    this.getStateByName("9"), 
    this.getStateByName("10"), 
    new ArrayList<>(Arrays.asList('n'))
));

// Transition from state 10 to state 11 with 's'
transitions.add(new Transition(
    10, 
    this.getStateByName("10"), 
    this.getStateByName("11"), 
    new ArrayList<>(Arrays.asList('s'))
));

// Transition from state 11 to state 12 with 't'
transitions.add(new Transition(
    11, 
    this.getStateByName("11"), 
    this.getStateByName("12"), 
    new ArrayList<>(Arrays.asList('t'))
));

// Transition from state 12 to state 13 with 'a'
transitions.add(new Transition(
    12, 
    this.getStateByName("12"), 
    this.getStateByName("13"), 
    new ArrayList<>(Arrays.asList('a'))
));

// Transition from state 13 to state 14 with 'n'
transitions.add(new Transition(
    13, 
    this.getStateByName("13"), 
    this.getStateByName("14"), 
    new ArrayList<>(Arrays.asList('n'))
));

// Transition from state 14 to state 15 with 't'
transitions.add(new Transition(
    14, 
    this.getStateByName("14"), 
    this.getStateByName("15"), 
    new ArrayList<>(Arrays.asList('t'))
));

// Transition from state 15 to state 16 with 'e'
transitions.add(new Transition(
    15, 
    this.getStateByName("15"), 
    this.getStateByName("16"), 
    new ArrayList<>(Arrays.asList('e'))
));



// Transition from state 8 to state 78 for all characters except 'o'
transitions.add(new Transition(
    8, 
    this.getStateByName("8"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('o','a')))
));

// Transition from state 9 to state 78 for all characters except 'n'
transitions.add(new Transition(
    9, 
    this.getStateByName("9"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('n')))
));

// Transition from state 10 to state 78 for all characters except 's'
transitions.add(new Transition(
    10, 
    this.getStateByName("10"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('s')))
));

// Transition from state 11 to state 78 for all characters except 't'
transitions.add(new Transition(
    11, 
    this.getStateByName("11"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('t')))
));

// Transition from state 12 to state 78 for all characters except 'a'
transitions.add(new Transition(
    12, 
    this.getStateByName("12"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('a')))
));

// Transition from state 13 to state 78 for all characters except 'n'
transitions.add(new Transition(
    13, 
    this.getStateByName("13"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('n')))
));

// Transition from state 14 to state 78 for all characters except 't'
transitions.add(new Transition(
    14, 
    this.getStateByName("14"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('t')))
));

// Transition from state 15 to state 78 for all characters except 'e'
transitions.add(new Transition(
    15, 
    this.getStateByName("15"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('e')))
));
transitions.add(new Transition(
    15, 
    this.getStateByName("16"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(this.allCharsAndChifrs))
));


//----aractere-----//

// Transition from state 8 to state 26 with 'a'
transitions.add(new Transition(
    8, 
    this.getStateByName("8"), 
    this.getStateByName("26"), 
    new ArrayList<>(Arrays.asList('a'))
));

// Transition from state 26 to state 27 with 'r'
transitions.add(new Transition(
    26, 
    this.getStateByName("26"), 
    this.getStateByName("27"), 
    new ArrayList<>(Arrays.asList('r'))
));

// Transition from state 27 to state 28 with 'a'
transitions.add(new Transition(
    27, 
    this.getStateByName("27"), 
    this.getStateByName("28"), 
    new ArrayList<>(Arrays.asList('a'))
));

// Transition from state 28 to state 29 with 'c'
transitions.add(new Transition(
    28, 
    this.getStateByName("28"), 
    this.getStateByName("29"), 
    new ArrayList<>(Arrays.asList('c'))
));

// Transition from state 29 to state 30 with 't'
transitions.add(new Transition(
    29, 
    this.getStateByName("29"), 
    this.getStateByName("30"), 
    new ArrayList<>(Arrays.asList('t'))
));

// Transition from state 30 to state 31 with 'é'
transitions.add(new Transition(
    30, 
    this.getStateByName("30"), 
    this.getStateByName("31"), 
    new ArrayList<>(Arrays.asList('é'))
));

// Transition from state 31 to state 32 with 'r'
transitions.add(new Transition(
    31, 
    this.getStateByName("31"), 
    this.getStateByName("32"), 
    new ArrayList<>(Arrays.asList('r'))
));

// Transition from state 32 to state 33 with 'e'
transitions.add(new Transition(
    32, 
    this.getStateByName("32"), 
    this.getStateByName("33"), 
    new ArrayList<>(Arrays.asList('e'))
));




// Transition from state 26 to state 78 for all characters except 'r'
transitions.add(new Transition(
    26, 
    this.getStateByName("26"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('r')))
));

// Transition from state 27 to state 78 for all characters except 'a'
transitions.add(new Transition(
    27, 
    this.getStateByName("27"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('a')))
));

// Transition from state 28 to state 78 for all characters except 'c'
transitions.add(new Transition(
    28, 
    this.getStateByName("28"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('c')))
));

// Transition from state 29 to state 78 for all characters except 't'
transitions.add(new Transition(
    29, 
    this.getStateByName("29"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('t')))
));

// Transition from state 30 to state 78 for all characters except 'é'
transitions.add(new Transition(
    30, 
    this.getStateByName("30"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('é')))
));

// Transition from state 31 to state 78 for all characters except 'r'
transitions.add(new Transition(
    31, 
    this.getStateByName("31"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('r')))
));

// Transition from state 32 to state 78 for all characters except 'e'
transitions.add(new Transition(
    32, 
    this.getStateByName("32"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('e')))
));

transitions.add(new Transition(
    32, 
    this.getStateByName("33"), 
    this.getStateByName("78"), 
    this.allCharsAndChifrs
));     

                    ////////////////////////////
                    /// 
                    

                   // Transition from state 0 to state 17 with 'v'

                   //////////variable/////
transitions.add(new Transition(
    0, 
    this.getStateByName("0"), 
    this.getStateByName("17"), 
    new ArrayList<>(Arrays.asList('v'))
));

// Transition from state 17 to state 18 with 'a'
transitions.add(new Transition(
    17, 
    this.getStateByName("17"), 
    this.getStateByName("18"), 
    new ArrayList<>(Arrays.asList('a'))
));

// Transition from state 18 to state 19 with 'r'
transitions.add(new Transition(
    18, 
    this.getStateByName("18"), 
    this.getStateByName("19"), 
    new ArrayList<>(Arrays.asList('r'))
));

// Transition from state 19 to state 20 with 'i'
transitions.add(new Transition(
    19, 
    this.getStateByName("19"), 
    this.getStateByName("20"), 
    new ArrayList<>(Arrays.asList('i'))
));

// Transition from state 20 to state 21 with 'a'
transitions.add(new Transition(
    20, 
    this.getStateByName("20"), 
    this.getStateByName("21"), 
    new ArrayList<>(Arrays.asList('a'))
));

// Transition from state 21 to state 22 with 'b'
transitions.add(new Transition(
    21, 
    this.getStateByName("21"), 
    this.getStateByName("22"), 
    new ArrayList<>(Arrays.asList('b'))
));

// Transition from state 22 to state 23 with 'l'
transitions.add(new Transition(
    22, 
    this.getStateByName("22"), 
    this.getStateByName("23"), 
    new ArrayList<>(Arrays.asList('l'))
));

// Transition from state 23 to state 24 with 'e'
transitions.add(new Transition(
    23, 
    this.getStateByName("23"), 
    this.getStateByName("24"), 
    new ArrayList<>(Arrays.asList('e'))
));

// Transition from state 0 to state 78 for all characters except 'v'
// transitions.add(new Transition(
//     0, 
//     this.getStateByName("0"), 
//     this.getStateByName("78"), 
//     this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('v')))
// ));

// Transition from state 17 to state 78 for all characters except 'a'
transitions.add(new Transition(
    17, 
    this.getStateByName("17"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('a')))
));

// Transition from state 18 to state 78 for all characters except 'r'
transitions.add(new Transition(
    18, 
    this.getStateByName("18"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('r')))
));

// Transition from state 19 to state 78 for all characters except 'i'
transitions.add(new Transition(
    19, 
    this.getStateByName("19"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('i')))
));

// Transition from state 20 to state 78 for all characters except 'a'
transitions.add(new Transition(
    20, 
    this.getStateByName("20"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('a')))
));

// Transition from state 21 to state 78 for all characters except 'b'
transitions.add(new Transition(
    21, 
    this.getStateByName("21"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('b')))
));

// Transition from state 22 to state 78 for all characters except 'l'
transitions.add(new Transition(
    22, 
    this.getStateByName("22"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('l')))
));

// Transition from state 23 to state 78 for all characters except 'e'
transitions.add(new Transition(
    23, 
    this.getStateByName("23"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('e')))
));

// Transition from state 24 to state 78 for all characters except 'e'
// transitions.add(new Transition(
//     24, 
//     this.getStateByName("24"), 
//     this.getStateByName("78"), 
//     this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('e')))
// ));
 
transitions.add(new Transition(
    24, 
    this.getStateByName("24"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(this.allCharsAndChifrs)
));
/////////////////////////////entier//////////////////
transitions.add(new Transition(
    24, 
    this.getStateByName("0"), 
    this.getStateByName("34"), 
    new ArrayList<>(Arrays.asList('e'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("34"), 
    this.getStateByName("35"), 
    new ArrayList<>(Arrays.asList('n'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("35"), 
    this.getStateByName("36"), 
    new ArrayList<>(Arrays.asList('t'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("36"), 
    this.getStateByName("37"), 
    new ArrayList<>(Arrays.asList('i'))
));
    
transitions.add(new Transition(
    24, 
    this.getStateByName("37"), 
    this.getStateByName("38"), 
    new ArrayList<>(Arrays.asList('e'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("38"), 
    this.getStateByName("39"), 
    new ArrayList<>(Arrays.asList('r'))
));
////
/// 
transitions.add(new Transition(
    19, 
    this.getStateByName("34"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('n','t')))
));

// Transition from state 20 to state 78 for all characters except 'a'
transitions.add(new Transition(
    20, 
    this.getStateByName("35"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('t')))
));

// Transition from state 21 to state 78 for all characters except 'b'
transitions.add(new Transition(
    21, 
    this.getStateByName("36"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('i')))
));

// Transition from state 22 to state 78 for all characters except 'l'
transitions.add(new Transition(
    22, 
    this.getStateByName("37"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('e')))
));

// Transition from state 23 to state 78 for all characters except 'e'
transitions.add(new Transition(
    23, 
    this.getStateByName("38"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('n')))
));    

transitions.add(new Transition(
    23, 
    this.getStateByName("39"), 
    this.getStateByName("78"), 
    this.allCharsAndChifrs
));    
transitions.add(new Transition(
    23, 
    this.getStateByName("66"), 
    this.getStateByName("78"), 
    this.allCharsAndChifrs
));       

transitions.add(new Transition(
    23, 
    this.getStateByName("34"), 
    this.getStateByName("66"), 
    new ArrayList<>(Arrays.asList('t'))
)); 


////reel////////

transitions.add(new Transition(
    24, 
    this.getStateByName("0"), 
    this.getStateByName("40"), 
    new ArrayList<>(Arrays.asList('r'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("40"), 
    this.getStateByName("41"), 
    new ArrayList<>(Arrays.asList('é'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("41"), 
    this.getStateByName("42"), 
    new ArrayList<>(Arrays.asList('e'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("42"), 
    this.getStateByName("43"), 
    new ArrayList<>(Arrays.asList('l'))
));

////////////
transitions.add(new Transition(
    19, 
    this.getStateByName("40"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('é')))
));

// Transition from state 20 to state 78 for all characters except 'a'
transitions.add(new Transition(
    20, 
    this.getStateByName("41"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('e','p')))
));

// Transition from state 21 to state 78 for all characters except 'b'
transitions.add(new Transition(
    21, 
    this.getStateByName("42"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('l')))
));

// Transition from state 22 to state 78 for all characters except 'l'
transitions.add(new Transition(
    22, 
    this.getStateByName("43"), 
    this.getStateByName("78"), 
   this.allCharsAndChifrs
));

// Transition from state 23 to state 78 for all characters except 'e'
transitions.add(new Transition(
    23, 
    this.getStateByName("38"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('n')))
));    
//////////fin/////

transitions.add(new Transition(
    23, 
    this.getStateByName("0"), 
    this.getStateByName("44"), 
    new ArrayList<>(Arrays.asList('f'))
));    
transitions.add(new Transition(
    23, 
    this.getStateByName("44"), 
    this.getStateByName("45"), 
    new ArrayList<>(Arrays.asList('i'))
));       

transitions.add(new Transition(
    23, 
    this.getStateByName("45"), 
    this.getStateByName("46"), 
    new ArrayList<>(Arrays.asList('n'))
)); 
////
transitions.add(new Transition(
    22, 
    this.getStateByName("44"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('i')))
));

// Transition from state 23 to state 78 for all characters except 'e'
transitions.add(new Transition(
    23, 
    this.getStateByName("45"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('n')))
)); 
transitions.add(new Transition(
    22, 
    this.getStateByName("46"), 
    this.getStateByName("78"), 
   this.allCharsAndChifrs
));

///////debut///
transitions.add(new Transition(
    24, 
    this.getStateByName("0"), 
    this.getStateByName("47"), 
    new ArrayList<>(Arrays.asList('d'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("47"), 
    this.getStateByName("48"), 
    new ArrayList<>(Arrays.asList('é'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("48"), 
    this.getStateByName("49"), 
    new ArrayList<>(Arrays.asList('b'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("49"), 
    this.getStateByName("50"), 
    new ArrayList<>(Arrays.asList('u'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("50"), 
    this.getStateByName("51"), 
    new ArrayList<>(Arrays.asList('t'))
));
//
transitions.add(new Transition(
    22, 
    this.getStateByName("47"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('é')))
));

// Transition from state 23 to state 78 for all characters except 'e'
transitions.add(new Transition(
    23, 
    this.getStateByName("48"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('b')))
)); 
transitions.add(new Transition(
    23, 
    this.getStateByName("49"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('u')))
)); 
transitions.add(new Transition(
    23, 
    this.getStateByName("50"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('t')))
)); 
transitions.add(new Transition(
    23, 
    this.getStateByName("50"), 
    this.getStateByName("78"), 
   this.allCharsAndChifrs
));

///// MOD.....
transitions.add(new Transition(
    24, 
    this.getStateByName("0"), 
    this.getStateByName("63"), 
    new ArrayList<>(Arrays.asList('m'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("63"), 
    this.getStateByName("64"), 
    new ArrayList<>(Arrays.asList('o'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("64"), 
    this.getStateByName("65"), 
    new ArrayList<>(Arrays.asList('d'))
));

///..

transitions.add(new Transition(
    23, 
    this.getStateByName("63"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('o')))
)); 
transitions.add(new Transition(
    23, 
    this.getStateByName("64"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('d')))
)); 
transitions.add(new Transition(
    23, 
    this.getStateByName("65"), 
    this.getStateByName("78"), 
   this.allCharsAndChifrs
));
////peter/////./////
/// 
transitions.add(new Transition(
    24, 
    this.getStateByName("41"), 
    this.getStateByName("66"), 
    new ArrayList<>(Arrays.asList('p'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("66"), 
    this.getStateByName("67"), 
    new ArrayList<>(Arrays.asList('é'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("67"), 
    this.getStateByName("68"), 
    new ArrayList<>(Arrays.asList('t'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("68"), 
    this.getStateByName("69"), 
    new ArrayList<>(Arrays.asList('e'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("69"), 
    this.getStateByName("70"), 
    new ArrayList<>(Arrays.asList('r'))
));
///////
transitions.add(new Transition(
    23, 
    this.getStateByName("66"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('é')))
)); 
transitions.add(new Transition(
    23, 
    this.getStateByName("67"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('t')))
)); 
transitions.add(new Transition(
    23, 
    this.getStateByName("68"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('e')))
)); 
transitions.add(new Transition(
    23, 
    this.getStateByName("69"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('r')))
)); 
transitions.add(new Transition(
    23, 
    this.getStateByName("70"), 
    this.getStateByName("78"), 
   this.allCharsAndChifrs
));

///jusqu'a
/// 
transitions.add(new Transition(
    24, 
    this.getStateByName("0"), 
    this.getStateByName("71"), 
    new ArrayList<>(Arrays.asList('j'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("71"), 
    this.getStateByName("72"), 
    new ArrayList<>(Arrays.asList('u'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("72"), 
    this.getStateByName("73"), 
    new ArrayList<>(Arrays.asList('s'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("73"), 
    this.getStateByName("74"), 
    new ArrayList<>(Arrays.asList('q'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("74"), 
    this.getStateByName("75"), 
    new ArrayList<>(Arrays.asList('u'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("75"), 
    this.getStateByName("76"), 
    new ArrayList<>(Arrays.asList('\''))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("76"), 
    this.getStateByName("77"), 
    new ArrayList<>(Arrays.asList('à'))
));
/////
transitions.add(new Transition(
    23, 
    this.getStateByName("71"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('u')))
)); 
transitions.add(new Transition(
    23, 
    this.getStateByName("72"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('s')))
)); 
transitions.add(new Transition(
    23, 
    this.getStateByName("73"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('q')))
)); 
transitions.add(new Transition(
    23, 
    this.getStateByName("74"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('u')))
)); 
transitions.add(new Transition(
    23, 
    this.getStateByName("75"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('\'')))
)); 
transitions.add(new Transition(
    23, 
    this.getStateByName("76"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('à')))
)); 
transitions.add(new Transition(
    23, 
    this.getStateByName("77"), 
    this.getStateByName("78"), 
   this.allCharsAndChifrs
));
///operators
transitions.add(new Transition(
    100, 
    this.getStateByName("0"), 
    this.getStateByName("79"), 
    new ArrayList<>(Arrays.asList('='))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("0"), 
    this.getStateByName("52"), 
    new ArrayList<>(Arrays.asList('>'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("52"), 
    this.getStateByName("53"), 
    new ArrayList<>(Arrays.asList('='))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("0"), 
    this.getStateByName("54"), 
    new ArrayList<>(Arrays.asList('<'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("54"), 
    this.getStateByName("55"), 
    new ArrayList<>(Arrays.asList('='))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("54"), 
    this.getStateByName("56"), 
    new ArrayList<>(Arrays.asList('<'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("0"), 
    this.getStateByName("61"), 
    new ArrayList<>(Arrays.asList('o'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("0"), 
    this.getStateByName("57"), 
    new ArrayList<>(Arrays.asList('+'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("0"), 
    this.getStateByName("58"), 
    new ArrayList<>(Arrays.asList('-'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("61"), 
    this.getStateByName("62"), 
    new ArrayList<>(Arrays.asList('u'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("61"), 
    this.getStateByName("78"), 
    this.getAllLettersAndDigitsExcluding(new ArrayList<>(Arrays.asList('u')))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("62"), 
    this.getStateByName("78"), 
  this.allCharsAndChifrs
));
transitions.add(new Transition(
    24, 
    this.getStateByName("76"), 
    this.getStateByName("77"), 
    new ArrayList<>(Arrays.asList('à'))
));
///nuumbers
transitions.add(new Transition(
    24, 
    this.getStateByName("0"), 
    this.getStateByName("25"), 
    new ArrayList<>(Arrays.asList('0','1','2','3','4','5','6','7','8','9'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("25"), 
    this.getStateByName("25"), 
    new ArrayList<>(Arrays.asList('0','1','2','3','4','5','6','7','8','9'))
));
transitions.add(new Transition(
    24, 
    this.getStateByName("0"), 
    this.getStateByName("78"), 
    this.getAllLettersExcluding(new ArrayList<>(Arrays.asList('r','e','p','c','v','f','d','l','m','p','o')))
));

transitions.add(new Transition(
    24, 
    this.getStateByName("78"), 
    this.getStateByName("78"), 
    this.allCharsAndChifrs
));

    }

     State getStateByName(String name) {
        return states.stream().filter(state -> state.name.equals(name)).findFirst().orElse(null);
    }

    public ArrayList<Transition> getTransitionsFromState(State state) {
        ArrayList<Transition> result = new ArrayList<>();
        for (Transition transition : transitions) {
            if (transition.fromState.equals(state)) {
                result.add(transition);
            }
        }
        return result;
    }

    public void analyse(String path) {
        StringBuilder result = new StringBuilder();
        State currentState = this.states.get(0); 
        int lineNumber = 1;
    
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (c == ' ') {
                        if (result.length() > 0) {
                          
                            this.tokens.add(new Token(currentState.tokenTypeOut, result.toString()));
                            result.setLength(0);
                        }
                        currentState = this.states.get(0); 
                        continue; 
                    }
                    Transition transitionFound = this.getTransitionFromStateAndCaracter(currentState, c);
    
                    if (transitionFound != null) {
                       
                        currentState = transitionFound.toState;
                        result.append(c);
                    } else {
                        
                        Transition initialTransition = this.getTransitionFromStateAndCaracter(this.getStateByName("0"), c);
    
                        if (initialTransition != null) {
                            this.Errors.add(new Error("token bad formed ", lineNumber));
                            if (result.length() > 0) {
                                this.tokens.add(new Token(currentState.tokenTypeOut, result.toString()));
                            }
                          
                            currentState = this.getStateByName("0");
                            result.setLength(0);
                            result.append(c);
                            currentState = initialTransition.toState;
                        } else {
                        
                            this.Errors.add(new Error("Invalid character", lineNumber));
                          
                            if (result.length() > 0) {
                                this.tokens.add(new Token(currentState.tokenTypeOut, result.toString()));
                            }
                            result.setLength(0);
                            currentState = this.states.get(0); // Reset to initial state
                        }
                    }
                }
                lineNumber++;
                if (result.length() > 0) {       
                    this.tokens.add(new Token(currentState.tokenTypeOut, result.toString()));
                    result.setLength(0);
                }
                currentState = this.states.get(0); 
            }
    
            if (result.length() > 0) {
                this.tokens.add(new Token(currentState.tokenTypeOut, result.toString()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        // Print the results at the end
        printResults();
    }
    
    
        
    
Transition getTransitionFromStateAndCaracter(State S, char c){
    Transition transition =null;
    for (Transition tr : this.getTransitionsFromState(S)) {
        if (tr.charList.contains(c)) {
            transition=tr;
            break;
        }
    }
    return transition;
    
}
public String removeLastCharacter(String input) {
    if (input != null && input.length() > 0) {
        return input.substring(0, input.length() - 1);
    }
    return input; // Return the original string if it's null or empty
}
void printResults() {
    // Define file names for tokens and errors
    String tokensFileName = "tokens_output.txt";
    String errorsFileName = "errors_output.txt";

    try (PrintWriter tokensWriter = new PrintWriter(new FileWriter(tokensFileName));
         PrintWriter errorsWriter = new PrintWriter(new FileWriter(errorsFileName))) {
        // Print tokens to file
        tokensWriter.println("Tokens:");
        for (Token token : tokens) {
            tokensWriter.println("(" + token.type + ", " + token.value + ")");
            // Also print tokens to console
            System.out.println("Token: (" + token.type + ", " + token.value + ")");
        }

        // Print errors to file
        errorsWriter.println("Errors:");
        for (Error error : this.Errors) {
            errorsWriter.println("Error: " + error.type + " on line " + error.line);
            // Also print errors to console
            System.out.println("Error: " + error.type + " on line " + error.line);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Confirm files were created
    System.out.println("Results printed to " + tokensFileName + " and " + errorsFileName);
}


}    
