# Deep Dive: Lower Bound and Upper Bound in Binary Search

In structural algorithmic problem solving, basic binary search is often insufficient. Most advanced search space problems require finding a precise transition boundary rather than an exact match. This is where **Lower Bound** and **Upper Bound** algorithms become essential toolsets.

---

## 1. Theoretical Definitions & Invariants

Both Lower Bound and Upper Bound operate on a sorted array and return an **index**. The fundamental difference lies in how they handle duplicate elements and strict inequality boundaries.

### Lower Bound

The Lower Bound of a target value is the index of the **first element** in the array that is **greater than or equal to** the target.


$$\text{Lower Bound Index } i \implies \text{First position where } \text{arr}[i] \ge \text{target}$$

* If the target exists in the array, lower bound points to its **first occurrence**.
* If the target does not exist, it points to the index where the target **should be inserted** to maintain sorted order.

### Upper Bound

The Upper Bound of a target value is the index of the **first element** in the array that is **strictly greater than** the target.


$$\text{Upper Bound Index } i \implies \text{First position where } \text{arr}[i] > \text{target}$$

* Even if the target exists multiple times, upper bound will always point to the index **immediately after its last occurrence**.

### Boundary Matrix Summary

Given the sorted array: `arr = [1, 2, 4, 4, 4, 6, 7]` (Size $N = 7$):

| Target | Lower Bound (Index / Value) | Upper Bound (Index / Value) |
| --- | --- | --- |
| **4** (Exists with duplicates) | Index `2` (Value `4`) | Index `5` (Value `6`) |
| **3** (Does not exist) | Index `2` (Value `4`) | Index `2` (Value `4`) |
| **8** (Greater than max element) | Index `7` (Out of bounds / $N$) | Index `7` (Out of bounds / $N$) |
| **0** (Less than min element) | Index `0` (Value `1`) | Index `0` (Value `1`) |

---

## 2. Structural Code Implementations

To guarantee that your binary search terminates safely without infinite loops, you must maintain a consistent window invariant.

### Lower Bound Implementation (Java)

```java
public static int getLowerBound(int[] arr, int target) {
    int low = 0;
    int high = arr.length; // Crucial: Initialized to N to handle out-of-bounds insertions
    int ans = arr.length;  // Fallback if no element satisfies the condition
    
    while (low <= high) {
        int mid = low + (high - low) / 2;
        
        if (arr[mid] >= target) {
            ans = mid;         // Mid is a potential candidate
            high = mid - 1;    // Look for a smaller index on the left
        } else {
            low = mid + 1;     // Discard left half completely
        }
    }
    return ans;
}

```

* **Time Complexity:** $\mathcal{O}(\log N)$
* **Space Complexity:** $\mathcal{O}(1)$

### Upper Bound Implementation (Java)

```java
public static int getUpperBound(int[] arr, int target) {
    int low = 0;
    int high = arr.length;
    int ans = arr.length;
    
    while (low <= high) {
        int mid = low + (high - low) / 2;
        
        if (arr[mid] > target) {
            ans = mid;         // Mid is strictly greater, save it
            high = mid - 1;    // Compress window to the left
        } else {
            low = mid + 1;     // arr[mid] <= target, discard left and mid
        }
    }
    return ans;
}

```

* **Time Complexity:** $\mathcal{O}(\log N)$
* **Space Complexity:** $\mathcal{O}(1)$

---

## 3. High-Impact Practical Scenarios

Understanding the mechanical behaviors of these two variants allows you to solve several downstream coordination patterns instantly.

### Scenario A: Finding First and Last Occurrence of an Element

This is the most common application. Given a sorted array with duplicate entries, find the absolute boundaries of a target value.

* **First Occurrence:** `idx = lower_bound(arr, target)`. If `idx == N` or `arr[idx] != target`, the element does not exist.
* **Last Occurrence:** `idx = upper_bound(arr, target) - 1`. If the element exists, this points to its final instance.

### Scenario B: Counting Frequencies of a Target Value

Instead of linearly iterating to count how many times a value appears (which takes $\mathcal{O}(N)$ time), you can subtract the boundaries to find the frequency in exact $\mathcal{O}(\log N)$ time:


$$\text{Frequency} = \text{upper\_bound}(arr, target) - \text{lower\_bound}(arr, target)$$

> **Example Calculation:** `arr = [1, 4, 4, 4, 5]`, target = `4`.
> * `upper_bound` returns index `4` (value `5`).
> * `lower_bound` returns index `1` (value `4`).
> * $\text{Frequency} = 4 - 1 = 3$.
> 
> 

### Scenario C: Finding Element Predecessors and Successors

When navigating a dataset, you often need to locate closest relative neighbors:

* **Strictly smaller element (Predecessor):** `lower_bound(arr, target) - 1`
* **Smaller or equal element:** `upper_bound(arr, target) - 1`
* **Strictly greater element (Successor):** `upper_bound(arr, target)`

---

## 4. Real-World Algorithmic Examples

### Problem 1: Search Insert Position

* **Problem Statement:** Given a sorted array of distinct values and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
* **Edge-case Test:** `arr = [1, 3, 5, 6]`, target = `2`.
* **Solution Strategy:** This problem statement perfectly mirrors the exact definition of a **Lower Bound**. By applying the lower bound logic, if `2` is evaluated, the first element matching `arr[mid] >= 2` is index `1` (value `3`). Returning index `1` provides the exact correct insertion path.

### Problem 2: Arranging Coins (Search Space Transition)

* **Problem Statement:** You have $N$ coins and want to build a staircase where the $i$-th row has exactly $i$ coins. Find the maximum number of complete rows you can build.
* **Mathematical Invariant:** The sum of $k$ complete rows is given by the function:

$$f(k) = \frac{k \times (k + 1)}{2}$$


* **Solution Strategy:** You need to find the maximum integer $k$ such that $f(k) \le N$. This is equivalent to finding the first row structure where $f(k) > N$ (**Upper Bound**) and subtracting `1` from the resulting index.
* **Pseudo-code Mapping:**
```text
low = 1, high = N
ans = 0
while low <= high:
    mid = low + (high - low) / 2
    cost = mid * (mid + 1) / 2

    if cost <= N:
        ans = mid      // Valid configuration, save it
        low = mid + 1  // Try to maximize row count
    else:
        high = mid - 1 // Too costly, reduce row counts
return ans

```