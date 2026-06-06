# Kadane's Algorithm - Complete Guide

## Introduction

Kadane's Algorithm is one of the most famous algorithms in computer science and is used to solve the:

> **Maximum Subarray Sum Problem**

### Problem Statement

Given an array of integers (positive, negative, or zero), find the contiguous subarray having the maximum possible sum.

### Example

```java
arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4}
```

Maximum subarray:

```java
{4, -1, 2, 1}
```

Sum:

```text
6
```

Output:

```java
6
```

---

# Brute Force Approach

Generate all possible subarrays.

For each subarray:

- Calculate its sum.
- Keep track of the maximum.

### Complexity

```text
Time  : O(n²) or O(n³)
Space : O(1)
```

Not efficient for large arrays.

---

# The Key Observation

Consider:

```java
arr = {4, -10, 5, 6}
```

While processing:

```text
Current Sum = 4
Current Sum = -6
```

At this point:

```text
Current Sum < 0
```

Question:

Will carrying this negative sum help future subarrays?

Answer:

```text
No
```

Suppose we continue:

```text
-6 + 5 = -1
```

versus

```text
5
```

Clearly:

```text
5 > -1
```

The negative running sum only hurts future calculations.

Therefore:

> Whenever the running sum becomes negative, we should discard it and start a new subarray.

This is the central insight behind Kadane's Algorithm.

---

# Intuition

Imagine carrying a backpack.

Positive numbers:

```text
Add profit
```

Negative numbers:

```text
Add loss
```

If your total profit becomes negative:

```text
You are carrying debt.
```

There is no reason to carry that debt into the future.

Simply start fresh.

---

# Core Idea

Maintain:

```java
currentSum
maxSum
```

### currentSum

Represents:

```text
Maximum subarray sum ending at current index
```

### maxSum

Represents:

```text
Maximum subarray sum seen so far
```

---

# Kadane's Algorithm

For every element:

```java
currentSum += arr[i];
```

If:

```java
currentSum > maxSum
```

update answer.

If:

```java
currentSum < 0
```

reset:

```java
currentSum = 0;
```

---

# Standard Implementation

```java
public static int kadane(int arr[]) {

    int maxSum = Integer.MIN_VALUE;
    int currentSum = 0;

    for (int num : arr) {

        currentSum += num;

        maxSum = Math.max(maxSum, currentSum);

        if (currentSum < 0) {
            currentSum = 0;
        }
    }

    return maxSum;
}
```

---

# Detailed Dry Run

Input:

```java
arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4}
```

---

## Initial

```text
currentSum = 0
maxSum = -∞
```

---

### Element = -2

```text
currentSum = -2
maxSum = -2
```

Negative:

```text
currentSum = 0
```

---

### Element = 1

```text
currentSum = 1
maxSum = 1
```

---

### Element = -3

```text
currentSum = -2
```

Negative:

```text
currentSum = 0
```

---

### Element = 4

```text
currentSum = 4
maxSum = 4
```

---

### Element = -1

```text
currentSum = 3
maxSum = 4
```

---

### Element = 2

```text
currentSum = 5
maxSum = 5
```

---

### Element = 1

```text
currentSum = 6
maxSum = 6
```

---

### Element = -5

```text
currentSum = 1
```

---

### Element = 4

```text
currentSum = 5
```

End:

```text
maxSum = 6
```

Answer:

```java
6
```

---

# Alternative DP Interpretation

Define:

```text
dp[i] = Maximum subarray sum ending at index i
```

Then:

```text
dp[i] =
max(
    arr[i],
    dp[i-1] + arr[i]
)
```

Either:

1. Start a new subarray.
2. Extend the previous one.

Kadane is simply a space-optimized version of this DP.

---

# Mathematical Formulation

For every index:

```text
Best ending at i
=
max(
    arr[i],
    bestEndingAt(i-1) + arr[i]
)
```

This becomes:

```java
currentSum =
Math.max(arr[i], currentSum + arr[i]);
```

---

# Handling All Negative Numbers

Consider:

```java
{-5, -2, -8}
```

The answer should be:

```java
-2
```

not:

```java
0
```

Therefore:

```java
maxSum = Integer.MIN_VALUE
```

must be initialized correctly.

---

# Robust Implementation

```java
public static int kadane(int arr[]) {

    int maxSum = arr[0];
    int currentSum = arr[0];

    for (int i = 1; i < arr.length; i++) {

        currentSum =
            Math.max(arr[i],
                     currentSum + arr[i]);

        maxSum =
            Math.max(maxSum,
                     currentSum);
    }

    return maxSum;
}
```

This version naturally handles:

```text
Positive numbers
Negative numbers
Mixed arrays
```

---

# Complexity Analysis

## Time Complexity

Single traversal:

```text
O(n)
```

---

## Space Complexity

Only two variables:

```text
currentSum
maxSum
```

Therefore:

```text
O(1)
```

---

# Relation to Prefix Sum Approach

You observed the following idea:

> Create a prefix sum array and find the maximum difference between a prefix sum and the minimum prefix sum before it.

This is actually extremely close to Kadane's Algorithm.

---

# Prefix Sum Formulation

Define:

```text
prefix[i]
=
arr[0] + arr[1] + ... + arr[i]
```

Then:

```text
Subarray Sum(l,r)
=
prefix[r] - prefix[l-1]
```

To maximize the subarray sum ending at index r:

```text
maximize:

prefix[r]
-
minimumPrefixSeenBeforeR
```

Thus:

```java
prefix += arr[i];

answer =
max(
    answer,
    prefix - minPrefix
);

minPrefix =
min(
    minPrefix,
    prefix
);
```

---

# Example

```java
arr = {4, -6, 3, 5}
```

Prefix sums:

```text
4
-2
1
6
```

At:

```text
prefix = 6
```

Minimum prefix seen before:

```text
-2
```

Maximum subarray:

```text
6 - (-2)
=
8
```

Corresponding subarray:

```java
{3,5}
```

---

# How Kadane Does the Same Thing

Kadane notices:

```text
Whenever running sum becomes negative,
it can never help future subarrays.
```

Prefix Sum Approach notices:

```text
Whenever a smaller prefix sum is found,
it becomes a better candidate for future subtraction.
```

Both are effectively tracking:

```text
Best place to start a subarray.
```

---

# Mathematical Equivalence

Prefix Sum View:

```text
Maximum Subarray Sum
=
max(
    prefix[i]
    -
    minimumPrefixBeforeI
)
```

Kadane View:

```text
Maximum Subarray Sum
=
max(
    BestSubarrayEndingAtI
)
```

But:

```text
BestSubarrayEndingAtI
=
prefix[i]
-
minimumPrefixBeforeI
```

Therefore:

```text
Both approaches compute the same quantity.
```

They are different perspectives of the same underlying optimization.

---

# Comparison

| Approach | Time | Space |
|-----------|--------|--------|
| Brute Force | O(n²) | O(1) |
| Prefix Sum + Min Prefix Tracking | O(n) | O(1) |
| Kadane's Algorithm | O(n) | O(1) |

---

# Interview Takeaways

1. Maximum Subarray Sum is one of the most important interview problems.
2. Kadane's Algorithm solves it optimally.
3. The key insight is:

   ```text
   Negative running sums should be discarded.
   ```

4. Kadane can be viewed as a Dynamic Programming solution.
5. Kadane and the Prefix Sum approach are mathematically equivalent.
6. Your prefix-sum intuition:

   ```text
   Maximum Prefix
   -
   Minimum Prefix Before It
   ```

   is a valid and powerful way to derive Kadane's Algorithm from first principles.

---

# Final Summary

Kadane's Algorithm works because a negative running sum can never improve a future subarray. By continuously maintaining the best subarray ending at the current position and the best answer seen so far, it computes the maximum subarray sum in:

```text
Time  : O(n)
Space : O(1)
```

Your prefix-sum approach arrives at the same result through a different lens:

```text
Maximum Subarray Sum
=
Current Prefix Sum
-
Smallest Prefix Sum Seen Earlier
```

Understanding both viewpoints provides a much deeper understanding of why Kadane's Algorithm works rather than simply memorizing it.