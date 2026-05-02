import java.util.*;

public class StringLevelThree {

    // ===================== 1. BMI =====================
    public static String[][] computeBMI(double[][] data) {
        String[][] result = new String[data.length][4];

        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightMeters = data[i][1] / 100.0;
            double bmi = weight / (heightMeters * heightMeters);

            String status;
            if (bmi <= 18.4) status = "Underweight";
            else if (bmi <= 24.9) status = "Normal";
            else if (bmi <= 39.9) status = "Overweight";
            else status = "Obese";

            result[i][0] = String.valueOf(data[i][1]);
            result[i][1] = String.valueOf(weight);
            result[i][2] = String.format("%.2f", bmi);
            result[i][3] = status;
        }
        return result;
    }

    // ===================== 2. Unique Characters =====================
    public static char[] uniqueChars(String str) {
        char[] temp = new char[str.length()];
        int index = 0;

        for (int i = 0; i < str.length(); i++) {
            boolean unique = true;
            for (int j = 0; j < i; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    unique = false;
                    break;
                }
            }
            if (unique) temp[index++] = str.charAt(i);
        }
        return Arrays.copyOf(temp, index);
    }

    // ===================== 3. First Non-Repeating =====================
    public static char firstNonRepeating(String str) {
        int[] freq = new int[256];

        for (char c : str.toCharArray()) freq[c]++;
        for (char c : str.toCharArray()) {
            if (freq[c] == 1) return c;
        }
        return '-';
    }

    // ===================== 4. Frequency using ASCII =====================
    public static int[] frequencyASCII(String str) {
        int[] freq = new int[256];
        for (char c : str.toCharArray()) freq[c]++;
        return freq;
    }

    // ===================== 5. Frequency using Unique =====================
    public static void frequencyUnique(String str) {
        char[] unique = uniqueChars(str);
        int[] freq = new int[256];

        for (char c : str.toCharArray()) freq[c]++;

        for (char c : unique) {
            System.out.println(c + " -> " + freq[c]);
        }
    }

    // ===================== 6. Frequency Nested =====================
    public static void frequencyNested(String str) {
        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') continue;

            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    arr[j] = '0';
                }
            }
            System.out.println(arr[i] + " -> " + count);
        }
    }

    // ===================== 7. Palindrome =====================
    public static boolean isPalindrome(String str) {
        int start = 0, end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    // ===================== 8. Anagram =====================
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] freq = new int[256];

        for (char c : s1.toCharArray()) freq[c]++;
        for (char c : s2.toCharArray()) freq[c]--;

        for (int f : freq) {
            if (f != 0) return false;
        }
        return true;
    }

    // ===================== 9. Calendar =====================
    public static void printCalendar(int month, int year) {
        String[] months = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};

        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            days[2] = 29;

        int d = 1;
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (d + x + (31*m0)/12) % 7;

        System.out.println(months[month] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < d0; i++) System.out.print("    ");

        for (int i = 1; i <= days[month]; i++) {
            System.out.printf("%3d ", i);
            if ((i + d0) % 7 == 0) System.out.println();
        }
    }

    // ===================== 10. Deck of Cards =====================
    public static String[] createDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};

        String[] deck = new String[suits.length * ranks.length];
        int index = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    public static void shuffleDeck(String[] deck) {
        Random rand = new Random();
        for (int i = 0; i < deck.length; i++) {
            int r = i + rand.nextInt(deck.length - i);
            String temp = deck[i];
            deck[i] = deck[r];
            deck[r] = temp;
        }
    }

    public static void distributeCards(String[] deck, int players) {
        int n = deck.length;

        if (n % players != 0) {
            System.out.println("Cannot distribute evenly");
            return;
        }

        int perPlayer = n / players;
        int index = 0;

        for (int i = 0; i < players; i++) {
            System.out.println("Player " + (i + 1));
            for (int j = 0; j < perPlayer; j++) {
                System.out.println(deck[index++]);
            }
            System.out.println();
        }
    }

    // ===================== MAIN =====================
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Example calls (you can modify input)

        // 2
        System.out.println(Arrays.toString(uniqueChars("programming")));

        // 3
        System.out.println(firstNonRepeating("swiss"));

        // 5
        frequencyUnique("hello");

        // 6
        frequencyNested("hello");

        // 7
        System.out.println(isPalindrome("madam"));

        // 8
        System.out.println(isAnagram("listen", "silent"));

        // 9
        printCalendar(7, 2005);

        // 10
        String[] deck = createDeck();
        shuffleDeck(deck);
        distributeCards(deck, 4);
    }
}