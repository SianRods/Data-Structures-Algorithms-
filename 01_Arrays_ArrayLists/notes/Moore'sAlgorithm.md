# Moore's Voting Algorithm - Complete Guide

## Introduction

Moore's Voting Algorithm is an elegant algorithm used to find the **Majority Element** in an array.

A majority element is defined as:

```text
An element that appears more than ⌊n/2⌋ times.
```

### Example

```java
arr = {2, 2, 1, 1, 1, 2, 2}
```

Frequency:

```text
2 -> 4 times
1 -> 3 times
```

Since:

```text
4 > 7/2
```

the majority element is:

```java
2
```

---

# Problem Statement

Given an array of size `n`, find the element whose frequency is greater than:

```text
n/2
```

---

# Traditional Approaches

## 1. Brute Force

For every element:

- Count its occurrences.
- Check whether frequency > n/2.

### Complexity

```text
Time  : O(n²)
Space : O(1)
```

---

## 2. HashMap

Store frequencies.

```java
HashMap<Integer,Integer> freq
```

### Complexity

```text
Time  : O(n)
Space : O(n)
```

---

## 3. Sorting

Sort the array.

If majority is guaranteed:

```java
return arr[n/2];
```

### Complexity

```text
Time  : O(n log n)
Space : Depends on sorting implementation
```

---

# Moore's Voting Algorithm

Moore's Voting Algorithm achieves:

```text
Time  : O(n)
Space : O(1)
```

which is optimal.

---

# Core Observation

Suppose a majority element exists.

Example:

```java
{2,2,2,1,1}
```

Frequency:

```text
2 -> 3
1 -> 2
```

Notice:

```text
Majority Count > Sum of all other counts
```

Because:

```text
3 > 2
```

Therefore:

Even if every non-majority element cancels one occurrence of the majority element,

the majority element will still survive.

This is the central idea behind Moore's Voting Algorithm.

---

# Voting Interpretation

Think of every occurrence as a vote.

Example:

```java
{2,2,1,1,1,2,2}
```

Votes:

```text
2 = +1 vote
1 = opposing vote
```

Whenever we see different elements:

```text
Cancel one vote from each side
```

Eventually only the majority element remains.

---

# The Algorithm

Maintain:

```java
candidate
count
```

Initially:

```java
count = 0;
candidate = -1;
```

For every element:

### Case 1

If:

```java
count == 0
```

Choose current element as candidate.

```java
candidate = num;
count = 1;
```

---

### Case 2

If:

```java
num == candidate
```

Increase support.

```java
count++;
```

---

### Case 3

If:

```java
num != candidate
```

Decrease support.

```java
count--;
```

---

# Implementation

```java
public static int majorityElement(int arr[]) {

    int candidate = -1;
    int count = 0;

    for (int num : arr) {

        if (count == 0) {
            candidate = num;
            count = 1;
        }

        else if (num == candidate) {
            count++;
        }

        else {
            count--;
        }
    }

    return candidate;
}
```

---

# Detailed Example

Input:

```java
{2,2,1,1,1,2,2}
```

---

## Step 1

```text
candidate = none
count = 0
```

Current:

```java
2
```

Since:

```java
count == 0
```

Set:

```text
candidate = 2
count = 1
```

---

## Step 2

Current:

```java
2
```

Same candidate.

```text
count = 2
```

---

## Step 3

Current:

```java
1
```

Different element.

```text
count = 1
```

---

## Step 4

Current:

```java
1
```

Different again.

```text
count = 0
```

Candidate loses all support.

---

## Step 5

Current:

```java
1
```

Since:

```java
count == 0
```

Choose new candidate.

```text
candidate = 1
count = 1
```

---

## Step 6

Current:

```java
2
```

Different.

```text
count = 0
```

---

## Step 7

Current:

```java
2
```

Choose new candidate.

```text
candidate = 2
count = 1
```

End.

Result:

```java
candidate = 2
```

Correct.

---

# Why Does This Work?

Let's understand the cancellation principle.

---

## Example

```java
{2,2,2,1,1}
```

Frequency:

```text
2 -> 3
1 -> 2
```

Pair:

```text
2 cancels 1
2 cancels 1
```

Remaining:

```text
2
```

The majority survives.

---

# Another Example

```java
{5,5,5,5,2,2,2}
```

Pairing:

```text
5 cancels 2
5 cancels 2
5 cancels 2
```

Remaining:

```text
5
```

Again the majority survives.

---

# Mathematical Intuition

Suppose:

```text
Majority Frequency = M
Other Elements     = O
```

Majority exists:

```text
M > O
```

Cancel one majority element with one non-majority element repeatedly.

After all possible cancellations:

```text
Remaining = M - O
```

Since:

```text
M > O
```

we get:

```text
M - O > 0
```

Therefore the majority element survives.

---

# Important Caveat

Moore's Voting Algorithm only guarantees:

```text
The final candidate MAY be the majority element.
```

If the problem does NOT guarantee a majority element exists,

we must verify.

---

# Example Without Majority

```java
{1,2,3,4}
```

Run algorithm:

```text
candidate = 4
```

But:

```text
4 occurs only once
```

No majority exists.

Therefore candidate is incorrect.

---

# Verification Pass

When majority is not guaranteed:

```java
public static int majorityElement(int arr[]) {

    int candidate = -1;
    int count = 0;

    for (int num : arr) {

        if (count == 0) {
            candidate = num;
            count = 1;
        }

        else if (candidate == num) {
            count++;
        }

        else {
            count--;
        }
    }

    int freq = 0;

    for (int num : arr) {
        if (num == candidate)
            freq++;
    }

    return freq > arr.length / 2 ? candidate : -1;
}
```

---

# Why Count Can Reach Zero

Many beginners get confused here.

Example:

```java
{2,2,1,1}
```

Processing:

```text
2 -> count=1
2 -> count=2
1 -> count=1
1 -> count=0
```

Count becomes zero because:

```text
Equal support exists for both sides.
```

At this point:

```text
All previous votes have effectively cancelled out.
```

Therefore we can safely choose a new candidate.

---

# Visualization

Think of a balance scale.

Example:

```java
{A,A,A,B,B}
```

Balance:

```text
A A A
B B
```

Cancel:

```text
A
```

Remaining:

```text
A
```

Majority survives.

---

# Complexity Analysis

## Time Complexity

First pass:

```text
O(n)
```

Verification pass:

```text
O(n)
```

Total:

```text
O(n)
```

---

## Space Complexity

Only:

```java
candidate
count
```

are used.

```text
O(1)
```

---

# Interview Takeaways

## When Majority Is Guaranteed

Use:

```java
Moore's Voting Algorithm
```

No verification needed.

---

## When Majority Is Not Guaranteed

Use:

```java
Moore's Voting Algorithm
+
Verification Pass
```

---

# Key Insights

1. Majority means frequency > n/2.
2. Majority frequency is larger than the sum of all other frequencies combined.
3. Pairwise cancellation is the foundation of the algorithm.
4. Different elements cancel each other's votes.
5. The majority element can never be completely eliminated.
6. After all cancellations, the majority element survives as the candidate.
7. If majority is not guaranteed, always perform a second verification pass.
8. Moore's Voting Algorithm is optimal:

```text
Time  : O(n)
Space : O(1)
```

and is the preferred interview solution for the Majority Element problem.