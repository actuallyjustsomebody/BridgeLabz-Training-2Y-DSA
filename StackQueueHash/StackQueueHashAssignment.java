import java.util.*;

public class StackQueueHashAssignment {

    // ===================== STACK & QUEUE =====================

    // 1. Queue using Two Stacks
    static class MyQueue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        void enqueue(int x) {
            s1.push(x);
        }

        int dequeue() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.isEmpty() ? -1 : s2.pop();
        }
    }

    // 2. Sort Stack using Recursion
    static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            sortStack(stack);
            insertSorted(stack, top);
        }
    }

    static void insertSorted(Stack<Integer> stack, int x) {
        if (stack.isEmpty() || stack.peek() <= x) {
            stack.push(x);
            return;
        }
        int temp = stack.pop();
        insertSorted(stack, x);
        stack.push(temp);
    }

    // 3. Stock Span Problem
    static int[] stockSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        return span;
    }

    // 4. Sliding Window Maximum
    static int[] slidingWindowMax(int[] arr, int k) {
        int n = arr.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            if (!dq.isEmpty() && dq.peek() == i - k) {
                dq.poll();
            }

            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
                dq.pollLast();
            }

            dq.offer(i);

            if (i >= k - 1) {
                result[i - k + 1] = arr[dq.peek()];
            }
        }
        return result;
    }

    // 5. Circular Tour Problem
    static int circularTour(int[] petrol, int[] dist) {
        int start = 0, total = 0, curr = 0;

        for (int i = 0; i < petrol.length; i++) {
            int diff = petrol[i] - dist[i];
            total += diff;
            curr += diff;

            if (curr < 0) {
                start = i + 1;
                curr = 0;
            }
        }
        return (total >= 0) ? start : -1;
    }

    // ===================== HASH MAP =====================

    // 6. Subarrays with Zero Sum
    static void zeroSumSubarrays(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;

        map.put(0, new ArrayList<>(Arrays.asList(-1)));

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    System.out.println("Subarray: " + (start + 1) + " to " + i);
                }
            }

            map.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
    }

    // 7. Pair with Given Sum
    static boolean hasPair(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(target - num)) return true;
            set.add(num);
        }
        return false;
    }

    // 8. Longest Consecutive Sequence
    static int longestConsecutive(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) set.add(num);

        int longest = 0;

        for (int num : arr) {
            if (!set.contains(num - 1)) {
                int current = num;
                int count = 1;

                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    // 9. Custom HashMap (Basic)
    static class MyHashMap {
        static class Node {
            int key, value;
            Node next;

            Node(int k, int v) {
                key = k; value = v;
            }
        }

        int SIZE = 10;
        Node[] table = new Node[SIZE];

        int hash(int key) {
            return key % SIZE;
        }

        void put(int key, int value) {
            int index = hash(key);
            Node newNode = new Node(key, value);

            if (table[index] == null) {
                table[index] = newNode;
            } else {
                Node temp = table[index];
                while (temp.next != null) {
                    if (temp.key == key) {
                        temp.value = value;
                        return;
                    }
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }

        int get(int key) {
            int index = hash(key);
            Node temp = table[index];

            while (temp != null) {
                if (temp.key == key) return temp.value;
                temp = temp.next;
            }
            return -1;
        }
    }

    // 10. Two Sum (Indices)
    static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }

    // ===================== MAIN =====================
    public static void main(String[] args) {

        // Queue using stacks
        MyQueue q = new MyQueue();
        q.enqueue(10);
        q.enqueue(20);
        System.out.println("Dequeue: " + q.dequeue());

        // Sort stack
        Stack<Integer> st = new Stack<>();
        st.push(3); st.push(1); st.push(4);
        sortStack(st);
        System.out.println("Sorted Stack: " + st);

        // Stock span
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        System.out.println("Stock Span: " + Arrays.toString(stockSpan(prices)));

        // Sliding window
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println("Sliding Max: " + Arrays.toString(slidingWindowMax(arr, 3)));

        // Circular tour
        int[] petrol = {4, 6, 7, 4};
        int[] dist = {6, 5, 3, 5};
        System.out.println("Start Pump: " + circularTour(petrol, dist));

        // Zero sum subarrays
        zeroSumSubarrays(new int[]{1, -1, 2, -2});

        // Pair sum
        System.out.println("Has Pair: " + hasPair(arr, 4));

        // Longest sequence
        System.out.println("Longest Sequence: " + longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));

        // Custom HashMap
        MyHashMap map = new MyHashMap();
        map.put(1, 100);
        System.out.println("Get Key 1: " + map.get(1));

        // Two sum
        System.out.println("Two Sum: " + Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
    }
}