1
import java.util.Scanner;
2
import java.util.concurrent.ThreadLocalRandom;
3
 
4
// How to create a Jumble word game in Java
5
 
6
public class JumbleGame {
7
 
8
    private static final String[] WORDS_DATABASE = new String[] {
9
        "superman","jungle","programmer","letter","house","helium"
10
    };
11
     
12
    public static void main(String[] args) {
13
        JumbleGame jg = new JumbleGame();
14
        jg.startGame();
15
    }
16
 
17
    /**
18
     * Run a game of Jumble in Java. The steps in the game are,
19
     * 1. Get a random word from the words database
20
     * 2. Shuffle/jumble the word by randomly shuffling characters
21
     * 3. Present the jumbled word to the user and ask him to guess the word.
22
     * 4. Repeat the guess till answer is found or user decides to quit.
23
     */
24
    private void startGame() {
25
        int numberOfGuesses = 0;
26
        String original = selectRandomWord();
27
        String shuffled = getShuffledWord(original);
28
        boolean gameOn = true;
29
        while(gameOn) {
30
            System.out.println("Shuffled word is: "+shuffled);
31
            numberOfGuesses++;
32
            String userGuess = getUserGuess();
33
            if(original.equalsIgnoreCase(userGuess)) {
34
                System.out.println("Congratulations! You found the word in "+numberOfGuesses+" guesses");
35
                gameOn = false;
36
            }else {
37
                System.out.println("Sorry, Wrong answer");
38
            }
39
        }       
40
    }
41
     
42
    /**
43
     * Get the user's word guess from command line
44
     * @return
45
     */
46
    public String getUserGuess() {
47
        Scanner sn = new Scanner(System.in);
48
        System.out.println("Please type in the original word: ");
49
        return sn.nextLine();
50
    }
51
     
52
    /**
53
     * Select a random word from the WORDS_DATABASE array.
54
     * @return
55
     */
56
    public String selectRandomWord() {
57
        int rPos = ThreadLocalRandom.current().nextInt(0, WORDS_DATABASE.length);
58
        return WORDS_DATABASE[rPos];
59
    }
60
     
61
    /**
62
     * Shuffle the original word by randomly swapping characters 10 times
63
     * @param original
64
     * @return
65
     */
66
    public String getShuffledWord(String original) {
67
        String shuffledWord = original; // start with original
68
        int wordSize = original.length();
69
        int shuffleCount = 10; // let us randomly shuffle letters 10 times
70
        for(int i=0;i<shuffleCount;i++) {
71
            //swap letters in two indexes
72
            int position1 = ThreadLocalRandom.current().nextInt(0, wordSize);
73
            int position2 = ThreadLocalRandom.current().nextInt(0, wordSize);
74
            shuffledWord = swapCharacters(shuffledWord,position1,position2);
75
        }
76
        return shuffledWord;
77
    }
78
 
79
    /**
80
     * Swaps characters in a string using the given character positions
81
     * @param shuffledWord
82
     * @param position1
83
     * @param position2
84
     * @return
85
     */
86
    private String swapCharacters(String shuffledWord, int position1, int position2) {
87
        char[] charArray = shuffledWord.toCharArray();
88
        // Replace with a "swap" function, if desired:
89
        char temp = charArray[position1];
90
        charArray[position1] = charArray[position2];
91
        charArray[position2] = temp;
92
        return new String(charArray);
93
    }
94
}
