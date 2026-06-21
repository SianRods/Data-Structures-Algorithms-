# Advanced Binary Search Invariants: Peak Elements, Rotation Pivots, and Single Element Detection

A common misconception is that Binary Search requires a completely sorted array. In reality, it only requires a **decidable local property** that guarantees one half of the search space can be safely eliminated.

This guide provides a detailed structural breakdown of three classic problems that leverage unsorted or partially sorted search spaces to achieve $\mathcal{O}(\log N)$ time complexity.

---

## 1. The Peak Element Concept: Binary Search on Gradients

A **Peak Element** is an entry that is strictly greater than its immediate neighbors. For boundary elements, the out-of-bounds neighbors are treated as $-\infty$.

### The Invariant: Following the Upward Slope

Instead of looking for sorted values, we evaluate the **local slope (gradient)** at our midpoint.

* If $\text{arr}[\text{mid}] < \text{arr}[\text{mid} + 1]$, we are on an **upward slope** moving left-to-right. A peak is guaranteed to exist somewhere to the right of `mid`.
* If $\text{arr}[\text{mid}] > \text{arr}[\text{mid} + 1]$, we are on a **downward slope**. A peak is guaranteed to exist either at `mid` itself or somewhere to the left.

By tracking the upward slope, we navigate toward a local maximum, eliminating half the array at each step.

```text
Visualizing the Slope Invariant:

       arr[mid+1] (Peak must be to the right -> low = mid + 1)
         /
       arr[mid]
       /
      
-----------------------------------------------------------------

       arr[mid] (Peak could be mid or to the left -> high = mid)
         \
         arr[mid+1]
           \

```

### Structural Code Implementation (Java)

```java
public int findPeakElement(int[] nums) {
    int low = 0;
    int high = nums.length - 1;
    
    while (low < high) {
        int mid = low + (high - low) / 2;
        
        // Evaluate the local gradient
        if (nums[mid] < nums[mid + 1]) {
            // Upward slope: Discard left half including mid
            low = mid + 1;
        } else {
            // Downward slope: mid could be a peak, discard elements past mid
            high = mid;
        }
    }
    // low and high converge to a valid peak index
    return low;
}

```

* **Time Complexity:** $\mathcal{O}(\log N)$
* **Space Complexity:** $\mathcal{O}(1)$

---

## 2. Finding the Pivot in a Rotated Sorted Array

In a rotated sorted array (e.g., `[4, 5, 6, 7, 0, 1, 2]`), the **Pivot** is the inflection point where the sorted property breaks. It represents either the maximum element or the minimum element (the original starting position). We will define the pivot here as the **minimum element**.

### The Invariant: Real vs. Distorted Halves

Compare `arr[mid]` directly against the rightmost boundary element `arr[high]`:

* **Case 1:** `arr[mid] > arr[high]`
* *Meaning:* The right boundary value is smaller than `mid`. This proves the inflection transition occurs strictly to the right of `mid`. The left half is normally sorted and contains only large values.
* *Action:* Eliminate the left half (`low = mid + 1`).


* **Case 2:** `arr[mid] <= arr[high]`
* *Meaning:* The elements from `mid` to `high` are correctly sorted in increasing order. The minimum element could be `mid` itself, or it lies to the left of `mid`.
* *Action:* Eliminate the right half while keeping `mid` as a candidate (`high = mid`).



### Structural Code Implementation (Java)

```java
public int findPivotMin(int[] nums) {
    int low = 0;
    int high = nums.length - 1;
    
    while (low < high) {
        int mid = low + (high - low) / 2;
        
        if (nums[mid] > nums[high]) {
            // Inflection point is to the right; left side is discarded
            low = mid + 1;
        } else {
            // Right side is perfectly sorted; mid could be the minimum
            high = mid;
        }
    }
    return nums[low]; // Returns the minimum element value
}

```

* **Time Complexity:** $\mathcal{O}(\log N)$
* **Space Complexity:** $\mathcal{O}(1)$

---

## 3. Detecting the Single Element in a Duplicated Array

**Problem Statement:** You are given a sorted array where every element appears exactly twice except for one single element that appears exactly once. Find this single element in $\mathcal{O}(\log N)$ time.

> **Example:** `nums = [1, 1, 2, 3, 3, 4, 4, 8, 8]` $\implies$ Output: `2`

### Method 1: Index Parity Analysis (Binary Search)

Before the single element appears, duplicate pairs always start on an **even index** and end on an **odd index** `(even, odd)`.
After the single element appears, this pattern shifts; pairs now start on an **odd index** and end on an **even index** `(odd, even)`.

```text
Index:    0  1  2  3  4  5  6  7  8
Array:   [1, 1, 2, 3, 3, 4, 4, 8, 8]
Pairs:   |--- |    |--- |---|---|     <- '2' disrupts the alignment

```

#### The Elimination Invariant at `mid`:

* If `mid` is **even**, its duplicate partner should be at `mid + 1`.
* If `mid` is **odd**, its duplicate partner should be at `mid - 1`.

If the partner matches this pattern, we are still on the **left side** of the single element. We eliminate the left half. If it doesn't match, we have passed the single element, so we eliminate the right half.

#### Structural Code Implementation (Java)

```java
public int singleNonDuplicate(int[] nums) {
    int low = 0;
    int high = nums.length - 1;
    
    // Boundary check handling to avoid index errors inside the loop
    if (high == 0) return nums[0];
    
    while (low < high) {
        int mid = low + (high - low) / 2;
        
        // Trick: Bitwise XOR with 1 flips the last bit.
        // If mid is even, mid ^ 1 = mid + 1
        // If mid is odd,  mid ^ 1 = mid - 1
        int partnerIndex = mid ^ 1;
        
        if (nums[mid] == nums[partnerIndex]) {
            // Pattern matches: We are in the left partition
            low = mid + 1;
        } else {
            // Pattern disrupted: Single element is at mid or to its left
            high = mid;
        }
    }
    return nums[low];
}

```

* **Time Complexity:** $\mathcal{O}(\log N)$
* **Space Complexity:** $\mathcal{O}(1)$

---

### Method 2: Bitwise Bit-Manipulation (XOR Approach)

If the problem does not strictly enforce an $\mathcal{O}(\log N)$ execution limit, or if the array is **unsorted**, you can leverage the algebraic properties of the bitwise XOR (`^`) operator.

#### The Invariant

* $X \oplus X = 0$ (Any number XORed with itself cancels out to zero).
* $X \oplus 0 = X$ (Any number XORed with zero remains unchanged).

By computing the cumulative XOR sum across the entire array, all matching duplicate pairs cancel each other out, leaving only the single unique element behind.

#### Structural Code Implementation (Java)

```java
public int singleNonDuplicateXOR(int[] nums) {
    int xorResult = 0;
    for (int num : nums) {
        xorResult ^= num;
    }
    return xorResult;
}

```

* **Time Complexity:** $\mathcal{O}(N)$ (Linear scan required to process every element).
* **Space Complexity:** $\mathcal{O}(1)$ static register tracker storage.

---

## 4. Comparison Summary Matrix

| Problem Scenario | Local Invariant Property | Space Elimination Logic | Special Edge Cases |
| --- | --- | --- | --- |
| **Peak Element** | Local Gradient Slope Direction. | Follow the upward slope: `arr[mid] < arr[mid+1]`. | Monotonically strictly increasing/decreasing arrays. |
| **Rotation Pivot** | Subarray ordering boundary verification. | If `arr[mid] > arr[high]`, minimum lies strictly to the right. | Arrays that are already fully sorted (0 rotations). |
| **Single Element** | Parity matching index configurations `(even, odd)`. | `mid ^ 1` structural check matching conditions. | Single element positioned at the first or last index. |