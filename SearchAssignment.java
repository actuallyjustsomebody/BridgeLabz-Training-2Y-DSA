import java.util.*;

public class SearchAssignment {

    // ===================== LINEAR SEARCH =====================

    // 1. First Negative Number
    public static int firstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) return i;
        }
        return -1;
    }

    // 2. Search Word in Sentences
    public static String findSentence(String[] sentences, String word) {
        for (String s : sentences) {
            if (s.contains(word)) return s;
        }
        return "Not Found";
    }

    // ===================== BINARY SEARCH =====================

    // 3. Rotation Point (Smallest Element Index)
    public static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // 4. Peak Element
    public static int findPeak(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // 5. Search in 2D Matrix
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int r = mid / cols;
            int c = mid % cols;

            if (matrix[r][c] == target) return true;
            else if (matrix[r][c] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    // 6. First and Last Occurrence
    public static int firstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static int lastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    // ===================== CHALLENGE =====================

    // 7. First Missing Positive (Linear Search concept)
    public static int firstMissingPositive(int[] arr) {
        int n = arr.length;

        boolean[] present = new boolean[n + 1];

        for (int num : arr) {
            if (num > 0 && num <= n) {
                present[num] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!present[i]) return i;
        }

        return n + 1;
    }

    // Binary Search for Target
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // ===================== MAIN =====================
    public static void main(String[] args) {

        // Linear Search 1
        int[] arr1 = {5, 3, -2, 9};
        System.out.println("First Negative Index: " + firstNegative(arr1));

        // Linear Search 2
        String[] sentences = {
                "Java is powerful",
                "DSA is important",
                "I love coding"
        };
        System.out.println("Sentence Found: " + findSentence(sentences, "DSA"));

        // Binary Search 1 (Rotation)
        int[] rotated = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Rotation Index: " + findRotationPoint(rotated));

        // Binary Search 2 (Peak)
        int[] peakArr = {1, 3, 20, 4, 1};
        System.out.println("Peak Index: " + findPeak(peakArr));

        // Binary Search 3 (2D Matrix)
        int[][] matrix = {
                {1, 3, 5},
                {7, 9, 11},
                {13, 15, 17}
        };
        System.out.println("Found in Matrix: " + searchMatrix(matrix, 9));

        // Binary Search 4 (First & Last)
        int[] arr2 = {1, 2, 2, 2, 3, 4};
        System.out.println("First Occurrence: " + firstOccurrence(arr2, 2));
        System.out.println("Last Occurrence: " + lastOccurrence(arr2, 2));

        // Challenge
        int[] arr3 = {3, 4, -1, 1};
        System.out.println("First Missing Positive: " + firstMissingPositive(arr3));

        Arrays.sort(arr3);
        System.out.println("Binary Search Index: " + binarySearch(arr3, 3));
    }
}