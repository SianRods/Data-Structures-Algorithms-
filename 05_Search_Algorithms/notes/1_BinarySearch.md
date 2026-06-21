# Mastering Binary Search: Algorithmic Invariants, Design Patterns, and Optimization Scenarios

Binary Search is one of the most powerful optimization techniques in computer science. While frequently introduced as a simple method to find an element in a sorted array, its true utility lies in its capability to optimize search spaces from linear time $\mathcal{O}(N)$ to logarithmic time $\mathcal{O}(\log N)$.

This document details the core invariant logic of the algorithm, standard structural implementation templates, and major problem-solving paradigms.

---

## 1. Core Concepts & Algorithmic Foundations

At its core, Binary Search does not strictly require a sorted array; it requires a **monotonic search space** or a property that divides the search space into two distinct, contiguous halves based on a condition function $P(x)$.

### The Monotonic Invariant

Given a range $[L, R]$, a condition function $P(x)$ must satisfy the property that if $P(x)$ is true, then for all $y > x$, $P(y)$ is also true (or vice-versa). This creates a predictable boolean boundary:

$$\text{Search Space: } [F, F, F, F, T, T, T, T]$$

The objective of Binary Search is to find the exact transition index from $F$ to $T$ (the first true) or from $T$ to $F$ (the last true).

### Preventing Integer Overflow

In standard implementations, calculating the midpoint as `mid = (low + high) / 2` can cause an integer overflow error if the sum of `low` and `high` exceeds the maximum capacity of a 32-bit signed integer ($2^{31} - 1$).

To prevent this, calculate the midpoint algebraically:


$$\text{mid} = \text{low} + \frac{\text{high} - \text{low}}{2}$$

---

## 2. Standard Implementation Templates

### Template 1: Classic Exact Match (1D Array)

Used when searching for a specific target value within a strictly sorted array.

#### Pseudo-code

```text
Function binarySearchExact(arr, target):
    low = 0
    high = len(arr) - 1
    
    While low <= high:
        mid = low + (high - low) / 2
        
        If arr[mid] == target:
            Return mid  // Target found
        Else If arr[mid] < target:
            low = mid + 1  // Discard left half
        Else:
            high = mid - 1  // Discard right half
            
    Return -1  // Target does not exist

```

### Template 2: Boundary Search (Lower/Upper Bound)

Used when searching for a transition point. This template maintains the invariant within the window and does not prematurely return upon encountering a value.

#### Pseudo-code (Finding First True / Lower Bound)

```text
Function binarySearchLowerBound(arr, target):
    low = 0
    high = len(arr)     // Notice high initialized to len(arr)
    ans = len(arr)      // Default fallback fallback
    
    While low < high:
        mid = low + (high - low) / 2
        
        If arr[mid] >= target:
            ans = mid   // Potential candidate found
            high = mid  // Narrow search space to the left side
        Else:
            low = mid + 1 // Discard left half
            
    Return ans

```

---

## 3. Major Problem Scenarios & Categorizations

### Scenario A: Binary Search on Monotonic Answers (Search Space Optimization)

This pattern applies to optimization problems where you need to find the "minimum possible maximum" or "maximum possible minimum" value satisfying a constraint. Instead of searching over an array, you search over a range of integers representing potential answers.

#### 1. Optimization Approach

1. Define the search space bounds: `low` = minimum possible answer value, `high` = maximum possible answer value.
2. Implement a helper function `isValid(val)` that checks if the current value satisfies the problem constraints in linear time $\mathcal{O}(N)$.
3. Use Binary Search to systematically test `mid`. If `isValid(mid)` passes, log it as a potential optimal answer and narrow your window to find a better constraint value.

#### 2. Classic Problem Example: Aggressive Cows / Book Allocation

* **Description:** You are given an array of coordinates representing stalls and a specific integer representing the count of cows. You must assign stalls to the cows such that the minimum distance between any two of them is as large as possible.
* **Edge-case Example:** Stalls: `[1, 2, 8, 4, 9]`, Cows: `3`.
* *Boundary Thinking:* Sorting stalls gives `[1, 2, 4, 8, 9]`. If bounds are checked assuming minimal distance `mid = 3`, placing cows at index `1`, `4`, and `8` yields differences of `3` and `4`. The minimal component is `3`. Testing higher options reveals `4` is the absolute max-min configuration limit.



#### 3. Pseudo-code Execution Pipeline

```text
Function canPlaceCows(stalls, numCows, minDist):
    countCows = 1
    lastPlacedPosition = stalls[0]
    
    For i from 1 to len(stalls) - 1:
        If stalls[i] - lastPlacedPosition >= minDist:
            countCows += 1
            lastPlacedPosition = stalls[i]
            If countCows == numCows:
                Return True
    Return False

Function maxMinCowDistance(stalls, numCows):
    Sort(stalls)
    low = 1
    high = stalls[len(stalls)-1] - stalls[0]
    ans = 0
    
    While low <= high:
        mid = low + (high - low) / 2
        
        If canPlaceCows(stalls, numCows, mid) == True:
            ans = mid      // Current distance is viable
            low = mid + 1  // Try to find a larger minimum distance
        Else:
            high = mid - 1 // Distance too large, decrease constraints
            
    Return ans

```

* **Time Complexity:** $\mathcal{O}(N \log(\text{high} - \text{low}))$ where $N$ represents array iteration verification.
* **Space Complexity:** $\mathcal{O}(1)$ supplementary stack framework allocation.

---

### Scenario B: Binary Search on 2D Matrix Search Spaces

When data layout transitions from linear arrays to multidimensional grids, Binary Search can be adapted to navigate structural multi-axis properties.

#### 1. Optimization Approach

* **Case 1 (Flat Matrix):** If rows are sorted continuously (the first element of a row is greater than the last element of the previous row), map the 2D matrix directly to a virtual 1D array. A virtual index `mid` maps to the matrix indices via:

$$\text{row} = \text{mid} / \text{cols}, \quad \text{col} = \text{mid} \% \text{cols}$$


* **Case 2 (Row-Column Sorted Matrix):** If rows are sorted left-to-right and columns are sorted top-to-bottom, start from the top-right corner $(0, \text{cols}-1)$ and eliminate a row or column at each step.

#### 2. Classic Problem Example: Search in a 2D Matrix

* **Description:** Efficiently locate a target value within an $M \times N$ integer matrix where each row is sorted in ascending order, and the first integer of each row is greater than the last integer of the preceding row.
* **Edge-case Example:** Matrix = `[[1, 3, 5], [10, 11, 16], [23, 30, 34]]`, Target = `3`.
* *Boundary Thinking:* An empty matrix layout or rows containing only a single element can cause boundary index issues if coordinate transforms are handled incorrectly.



#### 3. Pseudo-code Execution Pipeline

```text
Function searchMatrix(matrix, target):
    if len(matrix) == 0: Return False
    
    rows = len(matrix)
    cols = len(matrix[0])
    low = 0
    high = (rows * cols) - 1
    
    While low <= high:
        mid = low + (high - low) / 2
        // Virtual 2D transformation mapping
        currentRow = mid / cols
        currentCol = mid % cols
        val = matrix[currentRow][currentCol]
        
        If val == target:
            Return True
        Else If val < target:
            low = mid + 1
            Input target space boundary shifts right
        Else:
            high = mid - 1
            
    Return False

```

* **Time Complexity:** $\mathcal{O}(\log(M \times N))$ equivalent to a standard binary reduction path.
* **Space Complexity:** $\mathcal{O}(1)$ absolute workspace memory requirements.

---

### Scenario C: Unsorted Search Spaces (Peak Element / Rotated Arrays)

A common misconception is that binary search requires the entire array to be sorted. It can be used on unsorted arrays as long as a local property allows you to discard half of the search space at each step.

#### 1. Optimization Approach

By evaluating the neighborhood relationship of the midpoint (`arr[mid]` vs `arr[mid+1]`), you can determine which half of the array is guaranteed to contain the target element (such as a peak or pivot), allowing you to discard the other half.

#### 2. Classic Problem Example: Find Peak Element

* **Description:** Find a local maximum element, where an element is a peak if it is strictly greater than its neighbors.
* **Edge-case Example:** Array = `[1, 2, 1, 3, 5, 6, 4]`.
* *Boundary Thinking:* Arrays containing strictly increasing elements (`[1, 2, 3, 4]`) or strictly decreasing elements will place peaks at the boundary elements. The problem assumes `arr[-1] = arr[N] = -∞` to ensure a peak always exists.



#### 3. Pseudo-code Execution Pipeline

```text
Function findPeakElement(arr):
    low = 0
    high = len(arr) - 1
    
    While low < high:
        mid = low + (high - low) / 2
        
        If arr[mid] < arr[mid + 1]:
            // You are on an upward slope. 
            // A peak must exist to the right of mid.
            low = mid + 1
        Else:
            // You are on a downward slope.
            // mid could be a peak, or the peak is to the left.
            high = mid
            
    Return low // low and high converge to a peak element index

```

* **Time Complexity:** $\mathcal{O}(\log N)$ tree reduction trajectory execution paths.
* **Space Complexity:** $\mathcal{O}(1)$ auxiliary allocation tracking.

---

## 4. Summary Matrix: Quick Reference Guide

| Scenario Type | Core Monotonic Invariant | Midpoint Discard Criterion | Standard Complexity |
| --- | --- | --- | --- |
| **1D Sorted Array Match** | Element values increase uniformly ($A[i] \le A[i+1]$). | Direct comparison against target value. | $\mathcal{O}(\log N)$ |
| **Binary Search on Answers** | The feasibility function produces a contiguous block of valid configurations ($[T, T, T, F, F]$). | Validity check function logic output status. | $\mathcal{O}(N \log(\text{Max} - \text{Min}))$ |
| **Flat Matrix (2D)** | Global continuous ordering wraps across rows. | Index calculation mapping: `row = mid / cols`. | $\mathcal{O}(\log(M \times N))$ |
| **Peak Element Selection** | Slope direction invariants guarantees local maxima boundaries. | Element derivative comparisons: `arr[mid] < arr[mid + 1]`. | $\mathcal{O}(\log N)$ |