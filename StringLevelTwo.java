import java.util.*;

public class StringLevelTwo {

    static Scanner sc = new Scanner(System.in);

    // ------------------- 1. STRING LENGTH WITHOUT length() -------------------
    static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    static void program1() {
        System.out.print("Enter string: ");
        String s = sc.next();
        System.out.println("Custom Length: " + getLength(s));
        System.out.println("Built-in Length: " + s.length());
    }

    // ------------------- 2. SPLIT WITHOUT split() -------------------
    static String[] splitWords(String str) {
        List<String> words = new ArrayList<>();
        String temp = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                if (!temp.isEmpty()) words.add(temp);
                temp = "";
            } else {
                temp += ch;
            }
        }
        if (!temp.isEmpty()) words.add(temp);

        return words.toArray(new String[0]);
    }

    static void program2() {
        System.out.print("Enter sentence: ");
        sc.nextLine();
        String s = sc.nextLine();

        String[] custom = splitWords(s);
        String[] builtin = s.split(" ");

        System.out.println("Custom Split: " + Arrays.toString(custom));
        System.out.println("Built-in Split: " + Arrays.toString(builtin));
    }

    // ------------------- 3. WORDS WITH LENGTH (2D ARRAY) -------------------
    static void program3() {
        System.out.print("Enter sentence: ");
        sc.nextLine();
        String s = sc.nextLine();

        String[] words = splitWords(s);
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }

        System.out.println("Word\tLength");
        for (String[] row : result) {
            System.out.println(row[0] + "\t" + row[1]);
        }
    }

    // ------------------- 4. SHORTEST & LONGEST WORD -------------------
    static void program4() {
        System.out.print("Enter sentence: ");
        sc.nextLine();
        String s = sc.nextLine();

        String[] words = splitWords(s);

        String shortest = words[0];
        String longest = words[0];

        for (String w : words) {
            if (getLength(w) < getLength(shortest)) shortest = w;
            if (getLength(w) > getLength(longest)) longest = w;
        }

        System.out.println("Shortest: " + shortest);
        System.out.println("Longest: " + longest);
    }

    // ------------------- 5. COUNT VOWELS & CONSONANTS -------------------
    static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return "aeiou".indexOf(ch) != -1;
    }

    static void program5() {
        System.out.print("Enter string: ");
        sc.nextLine();
        String s = sc.nextLine();

        int v = 0, c = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                if (isVowel(ch)) v++;
                else c++;
            }
        }

        System.out.println("Vowels: " + v);
        System.out.println("Consonants: " + c);
    }

    // ------------------- 6. CHARACTER TYPE -------------------
    static void program6() {
        System.out.print("Enter string: ");
        sc.nextLine();
        String s = sc.nextLine();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetter(ch)) {
                if (isVowel(ch))
                    System.out.println(ch + " -> Vowel");
                else
                    System.out.println(ch + " -> Consonant");
            } else {
                System.out.println(ch + " -> Not a letter");
            }
        }
    }

    // ------------------- 7. TRIM WITHOUT trim() -------------------
    static String customTrim(String str) {
        int start = 0, end = str.length() - 1;

        while (start <= end && str.charAt(start) == ' ') start++;
        while (end >= start && str.charAt(end) == ' ') end--;

        String result = "";
        for (int i = start; i <= end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    static void program7() {
        System.out.print("Enter string with spaces: ");
        sc.nextLine();
        String s = sc.nextLine();

        System.out.println("Custom Trim: [" + customTrim(s) + "]");
        System.out.println("Built-in Trim: [" + s.trim() + "]");
    }

    // ------------------- 8. VOTING ELIGIBILITY -------------------
    static void program8() {
        int[] ages = new int[10];
        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            ages[i] = r.nextInt(60);
        }

        System.out.println("Age\tEligible");
        for (int age : ages) {
            System.out.println(age + "\t" + (age >= 18));
        }
    }

    // ------------------- 9. ROCK PAPER SCISSORS -------------------
    static String getComputerChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        return choices[new Random().nextInt(3)];
    }

    static String winner(String user, String comp) {
        if (user.equals(comp)) return "Draw";

        if ((user.equals("rock") && comp.equals("scissors")) ||
                (user.equals("paper") && comp.equals("rock")) ||
                (user.equals("scissors") && comp.equals("paper")))
            return "User";
        else
            return "Computer";
    }

    static void program9() {
        System.out.print("Enter number of games: ");
        int n = sc.nextInt();

        int userWin = 0, compWin = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter choice (rock/paper/scissors): ");
            String user = sc.next();
            String comp = getComputerChoice();

            String result = winner(user, comp);

            System.out.println("Computer: " + comp + " -> " + result);

            if (result.equals("User")) userWin++;
            else if (result.equals("Computer")) compWin++;
        }

        System.out.println("User Wins: " + userWin);
        System.out.println("Computer Wins: " + compWin);
    }

    // ------------------- 10. STUDENT GRADE SYSTEM -------------------
    static char getGrade(double p) {
        if (p >= 80) return 'A';
        else if (p >= 70) return 'B';
        else if (p >= 60) return 'C';
        else if (p >= 50) return 'D';
        else if (p >= 40) return 'E';
        else return 'R';
    }

    static void program10() {
        int n = 5;
        int[][] marks = new int[n][3];
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                marks[i][j] = 40 + r.nextInt(60);
            }
        }

        System.out.println("P C M Total % Grade");

        for (int i = 0; i < n; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double per = total / 3.0;
            char g = getGrade(per);

            System.out.println(marks[i][0] + " " + marks[i][1] + " " + marks[i][2] +
                    " " + total + " " + String.format("%.2f", per) + " " + g);
        }
    }

    // ------------------- MAIN MENU -------------------
    public static void main(String[] args) {
        while (true) {
            System.out.println("\nChoose Program (1-10, 0 to exit): ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1: program1(); break;
                case 2: program2(); break;
                case 3: program3(); break;
                case 4: program4(); break;
                case 5: program5(); break;
                case 6: program6(); break;
                case 7: program7(); break;
                case 8: program8(); break;
                case 9: program9(); break;
                case 10: program10(); break;
                case 0: return;
                default: System.out.println("Invalid choice");
            }
        }
    }
}