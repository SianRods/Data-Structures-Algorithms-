# Deep Dive: Floor and Ceil in Binary Search

When navigating sorted datasets, you frequently need to find the closest approximation of a target value rather than an exact match. In algorithmic problem solving, these approximations are defined as the **Floor** and **Ceil** (Ceiling) of the target.

Using Binary Search, both parameters can be computed in strict $\mathcal{O}(\log N)$ time, providing a major optimization over linear scanning.

---

## 1. Theoretical Definitions & Invariants

Given a sorted array `arr` and a value `target`, Floor and Ceil act as bounding walls:

```text
       [Floor]  ≤  Target  ≤  [Ceil]
(Largest element ≤ X)    (Smallest element ≥ X)

```

### The Floor

The **Floor** of a target is the **largest element** in the array that is **less than or equal to** the target.


$$\text{Floor}(X) = \max(\{ \text{arr}[i] \mid \text{arr}[i] \le X \})$$

* If the target exists in the array, the Floor is the target itself.
* If the target does not exist, the Floor is the closest value to its left.
* If the target is smaller than the smallest element in the array, the Floor **does not exist** (returns `-1` or an out-of-bounds flag).

### The Ceil

The **Ceil** of a target is the **smallest element** in the array that is **greater than or equal to** the target.


$$\text{Ceil}(X) = \min(\{ \text{arr}[i] \mid \text{arr}[i] \ge X \})$$

* **Crucial Identity:** The definition of Ceil is mathematically identical to the **Lower Bound** algorithm.
* If the target exists in the array, the Ceil is the target itself.
* If the target does not exist, the Ceil is the closest value to its right.
* If the target is larger than the largest element in the array, the Ceil **does not exist**.

### State Matrix Comparison

Given the sorted array: `arr = [1, 2, 8, 10, 10, 12, 19]` (Size $N = 7$):

| Target | Floor Value (Index) | Ceil Value (Index) | Note |
| --- | --- | --- | --- |
| **5** | `2` (Index `1`) | `8` (Index `2`) | Target lies in an empty gap. |
| **10** | `10` (Index `3` or `4`) | `10` (Index `3`) | Target exists; both point to the target. |
| **0** | Not Found (`-1`) | `1` (Index `0`) | Target is below the array minimum. |
| **25** | `19` (Index `6`) | Not Found (`-1`) | Target is above the array maximum. |

---

## 2. Structural Code Implementations

To implement these safely, we track an explicit `ans` variable that updates only when a valid candidate is discovered, compressing the search boundaries at each step.

### Floor Implementation (Java)

```java
public static int findFloor(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    int ans = -1; // -1 denotes that a floor value does not exist
    
    while (low <= high) {
        int mid = low + (high - low) / 2;
        
        if (arr[mid] == target) {
            return mid; // Exact match is immediately the optimal floor
        } else if (arr[mid] < target) {
            ans = mid;      // arr[mid] is ≤ target. Store as candidate.
            low = mid + 1;  // Look for a larger value closer to target
        } else {
            high = mid - 1; // Element is too large; discard right side
        }
    }
    return ans; 
}

```

### Ceil Implementation (Java)

```java
public static int findCeil(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    int ans = -1; // -1 denotes that a ceil value does not exist
    
    while (low <= high) {
        int mid = low + (high - low) / 2;
        
        if (arr[mid] == target) {
            return mid; // Exact match is immediately the optimal ceil
        } else if (arr[mid] > target) {
            ans = mid;      // arr[mid] is ≥ target. Store as candidate.
            high = mid - 1; // Look for a smaller value closer to target
        } else {
            low = mid + 1;  // Element is too small; discard left side
        }
    }
    return ans;
}

```

---

## 3. High-Impact Practical Scenarios

### Scenario A: Building Closest Match/Approximation Systems

When implementing autocomplete systems, numeric range lookups, or routing tables (like network IP routing tables), you rarely get exact matches.

* **Example:** A database stores tax bracket cutoffs: `[10000, 30000, 70000, 150000]`. If a user makes `55000`, running a **Floor** query yields `30000`, identifying their base bracket instantly in $\mathcal{O}(\log N)$ time.

### Scenario B: Database Range Optimization Queries

If you need to query a massive, sorted sequence database for all entries within a strict range $[X, Y]$, executing linear scans wastes processing threads.

* **Optimization Framework:** 1. Find the starting element: `start_idx = findCeil(arr, X)`
2. Find the ending element: `end_idx = findFloor(arr, Y)`
3. The valid subset window spans cleanly from `start_idx` to `end_idx`.

---

## 4. Real-World Algorithmic Examples

### Problem 1: Search Insert Position

* **Problem Statement:** Given a sorted array of distinct values and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
* **Mechanic Link:** This problem directly implements **Ceil**. If the element is present, Ceil returns its current index. If it is missing, Ceil points to the smallest element greater than the target, which is precisely the index where the new target should be injected.

### Problem 2: Online Stock Span / Historical Range Price Checks

* **Problem Statement:** Imagine a system tracking historical high prices on an exchange platform. You need to calculate the closest trading day prior to today where a stock traded at a specific price ceiling $K$.
* **Solution Strategy:** If prices are stored chronologically in a sorted list tracking asset distributions, calculating the **Floor** of price value $K$ immediately returns the nearest valuation pivot point without evaluating millions of transactional logs.

---

## 5. Summary Reference Matrix

| Algorithm | Target Condition | Direction of Window Shift | Out of Bounds Condition |
| --- | --- | --- | --- |
| **Floor** | `arr[mid] <= target` | `low = mid + 1` (maximizing index) | Target is smaller than `arr[0]` |
| **Ceil** | `arr[mid] >= target` | `high = mid - 1` (minimizing index) | Target is larger than `arr[N-1]` |