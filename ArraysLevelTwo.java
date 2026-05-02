import java.util.*;

public class ArraysLevelTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ================= 1. Employee Bonus =================
        int n = 10;
        double[] salary = new double[n];
        int[] years = new int[n];
        double[] bonus = new double[n];
        double[] newSalary = new double[n];

        double totalBonus = 0, totalOld = 0, totalNew = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("Enter salary and years of service:");
            salary[i] = sc.nextDouble();
            years[i] = sc.nextInt();

            if (years[i] > 5)
                bonus[i] = salary[i] * 0.05;
            else
                bonus[i] = salary[i] * 0.02;

            newSalary[i] = salary[i] + bonus[i];

            totalBonus += bonus[i];
            totalOld += salary[i];
            totalNew += newSalary[i];
        }

        System.out.println("Total Bonus: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOld);
        System.out.println("Total New Salary: " + totalNew);

        // ================= 2. Youngest & Tallest =================
        int[] age = new int[3];
        double[] height = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter age and height:");
            age[i] = sc.nextInt();
            height[i] = sc.nextDouble();
        }

        int youngest = age[0];
        double tallest = height[0];

        for (int i = 1; i < 3; i++) {
            if (age[i] < youngest) youngest = age[i];
            if (height[i] > tallest) tallest = height[i];
        }

        System.out.println("Youngest Age: " + youngest);
        System.out.println("Tallest Height: " + tallest);

        // ================= 3. Largest & Second Largest Digit =================
        System.out.println("Enter a number:");
        int num = sc.nextInt();

        int[] digits = new int[10];
        int index = 0;

        while (num != 0 && index < 10) {
            digits[index++] = num % 10;
            num /= 10;
        }

        int largest = 0, second = 0;

        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                second = largest;
                largest = digits[i];
            } else if (digits[i] > second && digits[i] != largest) {
                second = digits[i];
            }
        }

        System.out.println("Largest: " + largest);
        System.out.println("Second Largest: " + second);

        // ================= 4. Dynamic Array Version =================
        System.out.println("Enter a number:");
        num = sc.nextInt();

        int size = 10;
        int[] arr = new int[size];
        index = 0;

        while (num != 0) {
            if (index == size) {
                size += 10;
                int[] temp = new int[size];
                for (int i = 0; i < arr.length; i++) {
                    temp[i] = arr[i];
                }
                arr = temp;
            }
            arr[index++] = num % 10;
            num /= 10;
        }

        largest = 0;
        second = 0;

        for (int i = 0; i < index; i++) {
            if (arr[i] > largest) {
                second = largest;
                largest = arr[i];
            } else if (arr[i] > second && arr[i] != largest) {
                second = arr[i];
            }
        }

        System.out.println("Largest: " + largest);
        System.out.println("Second Largest: " + second);

        // ================= 5. Reverse Number =================
        System.out.println("Enter a number:");
        num = sc.nextInt();

        int[] reverseArr = new int[10];
        index = 0;

        while (num != 0) {
            reverseArr[index++] = num % 10;
            num /= 10;
        }

        System.out.print("Reversed Number: ");
        for (int i = 0; i < index; i++) {
            System.out.print(reverseArr[i]);
        }
        System.out.println();

        // ================= 6. BMI =================
        System.out.println("Enter number of persons:");
        int p = sc.nextInt();

        double[] weight = new double[p];
        double[] heightArr = new double[p];
        double[] bmi = new double[p];
        String[] status = new String[p];

        for (int i = 0; i < p; i++) {
            System.out.println("Enter weight and height:");
            weight[i] = sc.nextDouble();
            heightArr[i] = sc.nextDouble();

            bmi[i] = weight[i] / (heightArr[i] * heightArr[i]);

            if (bmi[i] <= 18.4) status[i] = "Underweight";
            else if (bmi[i] <= 24.9) status[i] = "Normal";
            else if (bmi[i] <= 39.9) status[i] = "Overweight";
            else status[i] = "Obese";
        }

        for (int i = 0; i < p; i++) {
            System.out.println("BMI: " + bmi[i] + " Status: " + status[i]);
        }

        // ================= 7. BMI using 2D Array =================
        double[][] person = new double[p][3];
        String[] stat = new String[p];

        for (int i = 0; i < p; i++) {
            System.out.println("Enter weight and height:");
            person[i][0] = sc.nextDouble();
            person[i][1] = sc.nextDouble();

            person[i][2] = person[i][0] / (person[i][1] * person[i][1]);

            if (person[i][2] <= 18.4) stat[i] = "Underweight";
            else if (person[i][2] <= 24.9) stat[i] = "Normal";
            else if (person[i][2] <= 39.9) stat[i] = "Overweight";
            else stat[i] = "Obese";
        }

        for (int i = 0; i < p; i++) {
            System.out.println("BMI: " + person[i][2] + " Status: " + stat[i]);
        }

        // ================= 8. Student Grades =================
        System.out.println("Enter number of students:");
        int s = sc.nextInt();

        double[] percent = new double[s];
        char[] grade = new char[s];

        for (int i = 0; i < s; i++) {
            System.out.println("Enter marks of 3 subjects:");
            int m1 = sc.nextInt();
            int m2 = sc.nextInt();
            int m3 = sc.nextInt();

            percent[i] = (m1 + m2 + m3) / 3.0;

            if (percent[i] >= 80) grade[i] = 'A';
            else if (percent[i] >= 70) grade[i] = 'B';
            else if (percent[i] >= 60) grade[i] = 'C';
            else if (percent[i] >= 50) grade[i] = 'D';
            else if (percent[i] >= 40) grade[i] = 'E';
            else grade[i] = 'R';
        }

        for (int i = 0; i < s; i++) {
            System.out.println("Percentage: " + percent[i] + " Grade: " + grade[i]);
        }

        // ================= 9. Grades using 2D Array =================
        int[][] marks = new int[s][3];

        for (int i = 0; i < s; i++) {
            System.out.println("Enter marks:");
            marks[i][0] = sc.nextInt();
            marks[i][1] = sc.nextInt();
            marks[i][2] = sc.nextInt();

            percent[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;

            if (percent[i] >= 80) grade[i] = 'A';
            else if (percent[i] >= 70) grade[i] = 'B';
            else if (percent[i] >= 60) grade[i] = 'C';
            else if (percent[i] >= 50) grade[i] = 'D';
            else if (percent[i] >= 40) grade[i] = 'E';
            else grade[i] = 'R';
        }

        for (int i = 0; i < s; i++) {
            System.out.println("Percentage: " + percent[i] + " Grade: " + grade[i]);
        }

        // ================= 10. Frequency of Digits =================
        System.out.println("Enter a number:");
        num = sc.nextInt();

        int[] freq = new int[10];

        while (num != 0) {
            int d = num % 10;
            freq[d]++;
            num /= 10;
        }

        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0) {
                System.out.println(i + " occurs " + freq[i] + " times");
            }
        }

        sc.close();
    }
}