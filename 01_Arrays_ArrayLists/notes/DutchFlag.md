# Dutch National Flag Algorithm - Complete Guide

## Introduction

The Dutch National Flag Algorithm is an elegant in-place sorting algorithm proposed by **Edsger W. Dijkstra**.

It is used to sort an array containing only:

```text
0, 1, and 2
```

in a single traversal of the array.

### Example

Input:

```java
{2, 0, 2, 1, 1, 0}
```

Output:

```java
{0, 0, 1, 1, 2, 2}
```

The algorithm achieves:

- Time Complexity: **O(n)**
- Space Complexity: **O(1)**

without using any extra array.

---

# Why Not Use Traditional Sorting?

A traditional sorting algorithm would require:

```text
O(n log n)
```

time.

Since we know the array contains only three distinct values:

```text
0, 1, 2
```

we can do much better.

The Dutch National Flag Algorithm solves the problem in:

```text
O(n)
```

time.

---

# Core Idea

Instead of sorting the entire array, we divide the array into four logical regions.

We maintain three pointers:

```java
low
mid
high
```

Initially:

```java
low = 0;
mid = 0;
high = n - 1;
```

---

# Regions Maintained

At every point during execution, the array is conceptually divided as:

```text
+-------------+-------------+-------------+-------------+
|     0s      |     1s      |  Unknown    |     2s      |
+-------------+-------------+-------------+-------------+
0           low           mid          high           n-1
```

More formally:

```text
[0 ... low-1]       -> all 0s
[low ... mid-1]     -> all 1s
[mid ... high]      -> unknown
[high+1 ... n-1]    -> all 2s
```

This is the most important concept of the algorithm.

---

# The Invariant

The algorithm relies on maintaining the following invariant:

```text
Before every iteration:

[0 ... low-1]       contains only 0s
[low ... mid-1]     contains only 1s
[mid ... high]      contains unprocessed elements
[high+1 ... n-1]    contains only 2s
```

As long as this invariant is maintained, the algorithm is guaranteed to work correctly.

---

# Processing Rules

We only examine:

```java
arr[mid]
```

because everything before `mid` has already been classified.

---

## Case 1: arr[mid] == 0

### Action

```java
swap(arr[low], arr[mid]);
low++;
mid++;
```

### Why?

A 0 belongs in the left region.

Therefore move it to the beginning.

---

### Example

Current state:

```text
0 0 1 1 0 2 2
    ^     ^
   low   mid
```

Regions:

```text
[0,0] -> 0s
[1,1] -> 1s
[0]   -> unknown
[2,2] -> 2s
```

Swap:

```text
0 0 0 1 1 2 2
```

Then:

```java
low++;
mid++;
```

---

# Important Question

## Why Do We Increment Mid?

Many people assume:

```java
swap(low, mid);
low++;
```

and then recheck the new element at mid.

However this is unnecessary.

Let's understand why.

---

# The Famous Doubt

Suppose:

```text
arr[low] = 2
arr[mid] = 0
```

After swapping:

```text
2 comes to mid
```

Shouldn't we reprocess it?

---

## Answer

This situation can never occur.

---

# Understanding the Invariant

Remember:

```text
[low ... mid-1]
```

contains only 1s.

Therefore when:

```text
low < mid
```

we know:

```java
arr[low] == 1
```

always.

Not 0.

Not 2.

Only 1.

---

## Example

Current state:

```text
0 0 1 1 0 2 2
    ^   ^
   low mid
```

By invariant:

```java
arr[low] = 1
arr[mid] = 0
```

Swap:

```text
0 0 0 1 1 2 2
```

The element arriving at mid is:

```java
1
```

which is already correctly placed.

Therefore:

```java
mid++;
```

is perfectly safe.

---

# What If Low == Mid?

Example:

```text
0 0 0 1 2
      ^
    low,mid
```

and:

```java
arr[mid] == 0
```

Then:

```java
swap(mid, mid)
```

which changes nothing.

Then:

```java
low++;
mid++;
```

Again safe.

---

# Therefore

This situation:

```java
arr[low] == 2
arr[mid] == 0
```

cannot happen while maintaining the invariant.

This is the key insight that makes the algorithm work.

---

# Case 2: arr[mid] == 1

### Action

```java
mid++;
```

### Why?

1 belongs in the middle region.

Nothing else needs to be done.

---

### Example

Current:

```text
0 0 1 1 0 2 2
        ^
       mid
```

Since the value is already a 1:

```java
mid++;
```

---

# Case 3: arr[mid] == 2

### Action

```java
swap(arr[mid], arr[high]);
high--;
```

### Important

Do NOT increment mid.

---

# Why Not Increment Mid?

The element coming from the right side belongs to the unknown region.

We have not processed it yet.

---

## Example

Current:

```text
1 0 2 1 0
    ^   ^
   mid high
```

Swap:

```text
1 0 0 1 2
    ^
   mid
```

The new value at mid is:

```java
0
```

which still needs processing.

Therefore:

```java
high--;
```

only.

Do not move mid.

---

# Complete Algorithm

```java
public static void sort012(int arr[]) {

    int low = 0;
    int mid = 0;
    int high = arr.length - 1;

    while (mid <= high) {

        if (arr[mid] == 0) {

            swap(arr, low, mid);
            low++;
            mid++;
        }

        else if (arr[mid] == 1) {

            mid++;
        }

        else {

            swap(arr, mid, high);
            high--;
        }
    }
}
```

---

# Dry Run

Input:

```java
{2,0,2,1,1,0}
```

---

## Initial

```text
2 0 2 1 1 0
^         ^
m         h
```

---

## Step 1

```java
arr[mid] = 2
```

Swap with high:

```text
0 0 2 1 1 2
^       ^
m       h
```

```java
high--
```

---

## Step 2

```java
arr[mid] = 0
```

Swap low and mid:

```text
0 0 2 1 1 2
  ^
 lm
```

```java
low++
mid++
```

---

## Step 3

```java
arr[mid] = 0
```

Swap:

```text
0 0 2 1 1 2
    ^
   mid
```

```java
low++
mid++
```

---

## Step 4

```java
arr[mid] = 2
```

Swap with high:

```text
0 0 1 1 2 2
    ^
   mid
```

```java
high--
```

---

## Step 5

```java
arr[mid] = 1
```

```java
mid++
```

---

## Step 6

```java
arr[mid] = 1
```

```java
mid++
```

Now:

```text
mid > high
```

Stop.

Result:

```java
{0,0,1,1,2,2}
```

---

# Complexity Analysis

## Time Complexity

Each element is processed at most once.

```text
O(n)
```

---

## Space Complexity

No extra data structures are used.

```text
O(1)
```

---

# Key Takeaways

1. The algorithm maintains four logical regions.
2. The invariant is the heart of the algorithm.
3. When processing a 0:
   - swap with low
   - increment both low and mid
4. When processing a 1:
   - only increment mid
5. When processing a 2:
   - swap with high
   - decrement high
   - do NOT increment mid
6. The concern:

   ```java
   arr[low] == 2 && arr[mid] == 0
   ```

   can never occur because the invariant guarantees that when `low < mid`, `arr[low]` must be a 1.

Understanding the invariant is far more important than memorizing the code. Once the invariant is clear, the pointer movements become completely intuitive.