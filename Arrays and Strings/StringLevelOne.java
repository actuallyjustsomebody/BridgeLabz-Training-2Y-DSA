import java.util.*;

public class StringLevelOne {
    // ========== Common Methods ==========
    static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    static String substringUsingCharAt(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    static char[] getChars(String str) {
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        return arr;
    }

    static boolean compareCharArrays(char[] a, char[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    static String toUpperCustom(String str) {
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                res += (char)(c - 32);
            } else {
                res += c;
            }
        }
        return res;
    }

    static String toLowerCustom(String str) {
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                res += (char)(c + 32);
            } else {
                res += c;
            }
        }
        return res;
    }

    // ========== Exception Methods ==========
    static void nullException() {
        String text = null;
        System.out.println(text.length());
    }

    static void handleNullException() {
        try {
            String text = null;
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Handled NullPointerException");
        }
    }

    static void stringIndexException(String str) {
        System.out.println(str.charAt(str.length() + 1));
    }

    static void handleStringIndexException(String str) {
        try {
            System.out.println(str.charAt(str.length() + 1));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Handled StringIndexOutOfBoundsException");
        }
    }

    static void illegalArgException(String str) {
        System.out.println(str.substring(5, 2));
    }

    static void handleIllegalArgException(String str) {
        try {
            System.out.println(str.substring(5, 2));
        } catch (Exception e) {
            System.out.println("Handled IllegalArgumentException");
        }
    }

    static void numberFormatException(String text) {
        int num = Integer.parseInt(text);
        System.out.println(num);
    }

    static void handleNumberFormatException(String text) {
        try {
            int num = Integer.parseInt(text);
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("Handled NumberFormatException");
        }
    }

    static void arrayIndexException(String[] arr) {
        System.out.println(arr[arr.length + 1]);
    }

    static void handleArrayIndexException(String[] arr) {
        try {
            System.out.println(arr[arr.length + 1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Handled ArrayIndexOutOfBoundsException");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ================= 1. Compare Strings =================
        System.out.println("Enter two strings:");
        String s1 = sc.next();
        String s2 = sc.next();

        boolean res1 = compareStrings(s1, s2);
        boolean res2 = s1.equals(s2);

        System.out.println("charAt compare: " + res1);
        System.out.println("equals() compare: " + res2);

        // ================= 2. Substring =================
        System.out.println("Enter string:");
        String str = sc.next();
        System.out.println("Enter start and end:");
        int start = sc.nextInt();
        int end = sc.nextInt();

        String sub1 = substringUsingCharAt(str, start, end);
        String sub2 = str.substring(start, end);

        System.out.println("Custom: " + sub1);
        System.out.println("Built-in: " + sub2);
        System.out.println("Same? " + compareStrings(sub1, sub2));

        // ================= 3. toCharArray =================
        System.out.println("Enter string:");
        String text = sc.next();

        char[] arr1 = getChars(text);
        char[] arr2 = text.toCharArray();

        System.out.println("Same arrays? " + compareCharArrays(arr1, arr2));

        // ================= 4. NullPointerException =================
        try {
            nullException();
        } catch (Exception e) {
            System.out.println("Exception occurred");
        }
        handleNullException();

        // ================= 5. StringIndexOutOfBounds =================
        System.out.println("Enter string:");
        String s = sc.next();

        try {
            stringIndexException(s);
        } catch (Exception e) {
            System.out.println("Exception occurred");
        }
        handleStringIndexException(s);

        // ================= 6. IllegalArgumentException =================
        try {
            illegalArgException(s);
        } catch (Exception e) {
            System.out.println("Exception occurred");
        }
        handleIllegalArgException(s);

        // ================= 7. NumberFormatException =================
        System.out.println("Enter number as string:");
        String numStr = sc.next();

        try {
            numberFormatException(numStr);
        } catch (Exception e) {
            System.out.println("Exception occurred");
        }
        handleNumberFormatException(numStr);

        // ================= 8. ArrayIndexOutOfBounds =================
        System.out.println("Enter number of names:");
        int n = sc.nextInt();
        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        try {
            arrayIndexException(names);
        } catch (Exception e) {
            System.out.println("Exception occurred");
        }
        handleArrayIndexException(names);

        // ================= 9. Uppercase =================
        sc.nextLine();
        System.out.println("Enter full text:");
        String fullText = sc.nextLine();

        String upper1 = toUpperCustom(fullText);
        String upper2 = fullText.toUpperCase();

        System.out.println("Custom: " + upper1);
        System.out.println("Built-in: " + upper2);
        System.out.println("Same? " + compareStrings(upper1, upper2));

        // ================= 10. Lowercase =================
        String lower1 = toLowerCustom(fullText);
        String lower2 = fullText.toLowerCase();

        System.out.println("Custom: " + lower1);
        System.out.println("Built-in: " + lower2);
        System.out.println("Same? " + compareStrings(lower1, lower2));

        sc.close();
    }
}