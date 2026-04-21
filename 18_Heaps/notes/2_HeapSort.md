# Heap Sort – Detailed Guide (DSA)

## 1. What is Heap Sort?

Heap Sort is a **comparison-based sorting algorithm** that uses the **heap data structure** (usually a max heap) to sort elements.

It works in two main phases:

1. Build a heap from the input data
2. Repeatedly extract the maximum element and place it at the end

---

## 2. Key Idea

* Convert array into a **Max Heap**
* The largest element will be at the root
* Swap root with last element
* Reduce heap size and heapify again

---

## 3. Algorithm Steps

### Step 1: Build Max Heap

Convert the array into a max heap.

```
for i = n/2 - 1 down to 0:
    heapify(arr, n, i)
```

### Step 2: Extract Elements

```
for i = n-1 down to 1:
    swap(arr[0], arr[i])
    heapify(arr, i, 0)
```

---

## 4. Heapify Function

Heapify ensures subtree rooted at index `i` satisfies heap property.

```
heapify(arr, n, i):
    largest = i
    left = 2*i + 1
    right = 2*i + 2

    if left < n and arr[left] > arr[largest]:
        largest = left

    if right < n and arr[right] > arr[largest]:
        largest = right

    if largest != i:
        swap(arr[i], arr[largest])
        heapify(arr, n, largest)
```

---

## 5. Example

### Input:

```
[4, 10, 3, 5, 1]
```

### Step 1: Build Max Heap

```
        10
       /  \
      5    3
     / \
    4   1
```

Array:

```
[10, 5, 3, 4, 1]
```

---

### Step 2: Sorting Process

#### Iteration 1:

Swap 10 and 1

```
[1, 5, 3, 4, 10]
```

Heapify:

```
        5
       / \
      4   3
     /
    1
```

---

#### Iteration 2:

Swap 5 and 1

```
[1, 4, 3, 5, 10]
```

Heapify:

```
        4
       / \
      1   3
```

---

#### Iteration 3:

Swap 4 and 3

```
[3, 1, 4, 5, 10]
```

Heapify:

```
        3
       /
      1
```

---

#### Final Sorted Array:

```
[1, 3, 4, 5, 10]
```

---

## 6. Java Implementation

```java
class HeapSort {

    public static void sort(int[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n/2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
}
```

---

## 7. Time Complexity

| Case    | Complexity |
| ------- | ---------- |
| Best    | O(n log n) |
| Average | O(n log n) |
| Worst   | O(n log n) |

### Breakdown:

* Build Heap → O(n)
* Heapify n times → O(log n)

---

## 8. Space Complexity

* O(1) (In-place sorting)
* No extra memory required

---

## 9. Advantages

* In-place algorithm
* No extra space required
* Guaranteed O(n log n)

---

## 10. Disadvantages

* Not stable (order of equal elements may change)
* Slower than QuickSort in practice

---

## 11. When to Use Heap Sort

Use Heap Sort when:

* Memory is limited
* You need guaranteed O(n log n)
* Stability is not required

---

## 12. Comparison with Other Sorting Algorithms

| Algorithm  | Time Complexity | Space    | Stable |
| ---------- | --------------- | -------- | ------ |
| Heap Sort  | O(n log n)      | O(1)     | No     |
| Merge Sort | O(n log n)      | O(n)     | Yes    |
| Quick Sort | O(n log n)*     | O(log n) | No     |

---

## Summary

* Heap Sort uses heap structure to sort elements
* Works by repeatedly extracting max element
* Time complexity is always O(n log n)
* Space efficient but not stable

