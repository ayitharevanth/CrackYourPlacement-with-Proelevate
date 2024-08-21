//Minimize Cash Flow among a given set of friends who have borrowed money from each other.java

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Vector;
import java.util.Arrays;
import java.util.Collections;

// Class representing a pair of integers
class Pair {
    private int key;
    private int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}

// Comparator for ascending order sorting of pairs based on values
class AscCmp implements Comparator<Pair> {
    public int compare(Pair p1, Pair p2) {
        return p1.getValue() - p2.getValue();
    }
}

// Comparator for descending order sorting of pairs based on values
class DscCmp implements Comparator<Pair> {
    public int compare(Pair p1, Pair p2) {
        return p2.getValue() - p1.getValue();
    }
}

// Class implementing the solution algorithm
class Solution {
    private PriorityQueue<Pair> minQ; // Priority queue for minimum values
    private PriorityQueue<Pair> maxQ; // Priority queue for maximum values

    // Constructor initializing the priority queues
    public Solution() {
        minQ = new PriorityQueue<>(new DscCmp());
        maxQ = new PriorityQueue<>(new AscCmp());
    }

    // Fills the priority queues with positive and negative amounts
    private void constructMinMaxQ(Vector<Integer> amount) {
        for (int i = 0; i < amount.size(); ++i) {
            if (amount.get(i) == 0)
                continue;
            if (amount.get(i) > 0) {
                maxQ.add(new Pair(i, amount.get(i)));
            } else {
                minQ.add(new Pair(i, amount.get(i)));
            }
        }
    }

    // Solves transactions until both queues are empty
    private void solveTransaction() {
        while (!minQ.isEmpty() && !maxQ.isEmpty()) {
            Pair maxCreditEntry = maxQ.poll();
            Pair maxDebitEntry = minQ.poll();

            int transaction_val = maxCreditEntry.getValue() + maxDebitEntry.getValue();

            int debtor = maxDebitEntry.getKey();
            int creditor = maxCreditEntry.getKey();
            int owed_amount;

            if (transaction_val == 0) {
                owed_amount = maxCreditEntry.getValue();
            } else if (transaction_val < 0) {
                owed_amount = maxCreditEntry.getValue();
                minQ.add(new Pair(maxDebitEntry.getKey(), transaction_val));
            } else {
                owed_amount = -maxDebitEntry.getValue();
                maxQ.add(new Pair(maxCreditEntry.getKey(), transaction_val));
            }

            // Print result
            System.out.println("Person " + debtor + " pays " + owed_amount + " to Person " + creditor);
        }
    }

    // Calculates the amount to be credited/debited to/from each person and solves the transactions
    public void minCashFlow(Vector<Vector<Integer>> graph) {
        int n = graph.size();

        // Calculate the cash to be credited/debited to/from each person and store in vector amount
        Vector<Integer> amount = new Vector<>(Collections.nCopies(n, 0));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int diff = graph.get(j).get(i) - graph.get(i).get(j);
                amount.set(i, amount.get(i) + diff);
            }
        }

        // Fill in both queues minQ and maxQ using amount vector
        constructMinMaxQ(amount);

        // Solve the transaction using minQ, maxQ, and amount vector
        solveTransaction();
    }
}

public class Main {
    public static void main(String[] args) {
        // Test case 1
        Vector<Vector<Integer>> graph = new Vector<>();
        graph.add(new Vector<>(Arrays.asList(0, 1000, 2000)));
        graph.add(new Vector<>(Arrays.asList(0, 0, 5000)));
        graph.add(new Vector<>(Arrays.asList(0, 0, 0)));

        System.out.println("Solution 1 : ");
        Solution S = new Solution();
        S.minCashFlow(graph);

        // Test case 2
        Vector<Vector<Integer>> graph2 = new Vector<>();
        graph2.add(new Vector<>(Arrays.asList(2, 63, 0, 85, 49)));
        graph2.add(new Vector<>(Arrays.asList(0, 76, 0, 0, 27)));
        graph2.add(new Vector<>(Arrays.asList(0, 0, 0, 17, 0)));
        graph2.add(new Vector<>(Arrays.asList(73, 32, 50, 6, 71)));
        graph2.add(new Vector<>(Arrays.asList(0, 86, 0, 0, 10)));

        System.out.println("Solution 2 : ");
        Solution S2 = new Solution();
        S2.minCashFlow(graph2);
    }
}
