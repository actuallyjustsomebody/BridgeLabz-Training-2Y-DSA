import java.util.*;

public class ArraysLevelOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Voting Eligibility for 10 Students
        int[] ages = new int[10];
        for (int i = 0; i < ages.length; i++) {
            ages[i] = sc.nextInt();
        }
        for (int age : ages) {
            if (age < 0) {
                System.out.println("Invalid age");
            } else if (age >= 18) {
                System.out.println("The student with age " + age + " can vote");
            } else {
                System.out.println("The student with age " + age + " cannot vote");
            }
        }

        // 2. Number Check (Positive/Negative/Zero, Even/Odd)
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }
        for (int num : numbers) {
            if (num > 0) {
                if (num % 2 == 0)
                    System.out.println(num + " is positive and even");
                else
                    System.out.println(num + " is positive and odd");
            } else if (num < 0) {
                System.out.println(num + " is negative");
            } else {
                System.out.println(num + " is zero");
            }
        }
        if (numbers[0] == numbers[4])
            System.out.println("First and last are equal");
        else if (numbers[0] > numbers[4])
            System.out.println("First is greater than last");
        else
            System.out.println("First is less than last");

        // 3. Multiplication Table (1–10)
        int num = sc.nextInt();
        int[] table = new int[10];
        for (int i = 1; i <= 10; i++) {
            table[i - 1] = num * i;
        }
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " * " + i + " = " + table[i - 1]);
        }

        // 4. Store Numbers Until Limit or Negative/Zero
        double[] arr = new double[10];
        double total = 0.0;
        int index = 0;
        while (true) {
            double input = sc.nextDouble();
            if (input <= 0 || index == 10)
                break;
            arr[index++] = input;
        }
        for (int i = 0; i < index; i++) {
            total += arr[i];
            System.out.println(arr[i]);
        }
        System.out.println("Sum = " + total);

        // 5. Multiplication Table (6–9)
        int number = sc.nextInt();
        int[] result = new int[4];
        int idx = 0;
        for (int i = 6; i <= 9; i++) {
            result[idx++] = number * i;
        }
        idx = 0;
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + result[idx++]);
        }

        // 6. Mean Height of Football Team
        double[] heights = new double[11];
        double sum = 0;
        for (int i = 0; i < heights.length; i++) {
            heights[i] = sc.nextDouble();
            sum += heights[i];
        }
        double mean = sum / heights.length;
        System.out.println("Mean height = " + mean);

        // 7. Odd and Even Arrays
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Invalid input");
        } else {
            int[] even = new int[n / 2 + 1];
            int[] odd = new int[n / 2 + 1];
            int e = 0, o = 0;

            for (int i = 1; i <= n; i++) {
                if (i % 2 == 0)
                    even[e++] = i;
                else
                    odd[o++] = i;
            }

            System.out.println("Odd numbers:");
            for (int i = 0; i < o; i++)
                System.out.print(odd[i] + " ");
            System.out.println("\nEven numbers:");
            for (int i = 0; i < e; i++)
                System.out.print(even[i] + " ");
        }

        // 8. Factors of a Number
        int factNum = sc.nextInt();
        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        int count = 0;

        for (int i = 1; i <= factNum; i++) {
            if (factNum % i == 0) {
                if (count == maxFactor) {
                    maxFactor *= 2;
                    int[] temp = new int[maxFactor];
                    for (int j = 0; j < factors.length; j++)
                        temp[j] = factors[j];
                    factors = temp;
                }
                factors[count++] = i;
            }
        }
        System.out.println("Factors:");
        for (int i = 0; i < count; i++)
            System.out.print(factors[i] + " ");

        // 9. 2D Array to 1D Array
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = sc.nextInt();

        int[] oneD = new int[rows * cols];
        int k = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                oneD[k++] = matrix[i][j];

        System.out.println("1D Array:");
        for (int val : oneD)
            System.out.print(val + " ");

        // 10. FizzBuzz
        int limit = sc.nextInt();
        if (limit > 0) {
            String[] fizzBuzz = new String[limit + 1];

            for (int i = 0; i <= limit; i++) {
                if (i % 3 == 0 && i % 5 == 0)
                    fizzBuzz[i] = "FizzBuzz";
                else if (i % 3 == 0)
                    fizzBuzz[i] = "Fizz";
                else if (i % 5 == 0)
                    fizzBuzz[i] = "Buzz";
                else
                    fizzBuzz[i] = String.valueOf(i);
            }

            for (int i = 0; i <= limit; i++) {
                System.out.println("Position " + i + " = " + fizzBuzz[i]);
            }
        }

        sc.close();
    }
}