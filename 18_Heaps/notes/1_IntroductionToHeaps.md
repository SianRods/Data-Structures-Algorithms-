# Heaps in Data Structures and Algorithms (Beginner Guide)

## 1. What is a Heap?

A **heap** is a specialized tree-based data structure that satisfies a specific property known as the **heap property**.

There are two main types of heaps:

* **Max Heap**: The value of each parent node is **greater than or equal to** its children.
* **Min Heap**: The value of each parent node is **less than or equal to** its children.

A heap is also a **complete binary tree**, which means:

* All levels are completely filled except possibly the last level.
* The last level is filled from **left to right**.

---

## 2. Heap Representation

### Tree Representation

A heap is visually represented as a binary tree:

Example (Max Heap):

```
        50
       /  \
     30    40
    /  \  /
  10  20 35
```

### Array Representation

Heaps are most efficiently stored using arrays.

For a node at index `i`:

* Left child = `2i + 1`
* Right child = `2i + 2`
* Parent = `(i - 1) // 2`

Example array for above heap:

```
[50, 30, 40, 10, 20, 35]
```

This eliminates the need for pointers and makes heaps memory-efficient.

---

## 3. When to Use Heaps?

Heaps are used when we need efficient access to the **minimum or maximum element**.

### Key Operations and Time Complexity

| Operation      | Time Complexity |
| -------------- | --------------- |
| Insert         | O(log n)        |
| Delete (root)  | O(log n)        |
| Peek (min/max) | O(1)            |
| Build Heap     | O(n)            |

### Why Heaps Optimize Performance

* Avoid full sorting when only min/max is needed
* Efficient priority handling
* Reduces time complexity compared to naive approaches

Example:

* Finding largest element repeatedly → Heap is better than sorting each time

---

## 4. How to Check if an Array is a Heap?

Two conditions must be satisfied:

### 1. Complete Binary Tree Property

* Implicitly satisfied if array representation is used correctly

### 2. Heap Property

#### For Max Heap:

```
arr[i] >= arr[2i+1]
arr[i] >= arr[2i+2]
```

#### For Min Heap:

```
arr[i] <= arr[2i+1]
arr[i] <= arr[2i+2]
```

### Algorithm

```
for i in range(n//2):
    if arr[i] < arr[2*i+1] or arr[i] < arr[2*i+2]:
        return False
return True
```

---

## 5. Insertion in Heap (Up-Heap / Heapify-Up)

### Steps

1. Insert the element at the **end** of the array
2. Compare it with its parent
3. If heap property is violated, swap
4. Repeat until property is restored

### Example (Max Heap)

Insert 60 into:

```
[50, 30, 40, 10, 20, 35]
```

#### Tree Visualization

Initial Heap:

```
        50
       /  \
     30    40
    /  \  /
  10  20 35
```

Insert 60 at last position:

```
        50
       /  \
     30    40
    /  \  / \
  10  20 35  60
```

Swap with parent (40):

```
        50
       /  \
     30    60
    /  \  / \
  10  20 35  40
```

Swap with parent (50):

```
        60
       /  \
     30    50
    /  \  / \
  10  20 35  40
```

#### Array Transformation

```
[50, 30, 40, 10, 20, 35, 60]
→ [50, 30, 60, 10, 20, 35, 40]
→ [60, 30, 50, 10, 20, 35, 40]
```

### Time Complexity

* O(log n)

---

## 6. Deletion in Heap (Down-Heap / Heapify-Down)

### Steps

1. Remove the root element
2. Replace it with the last element
3. Compare with children
4. Swap with the larger child (Max Heap)
5. Repeat until heap property is restored

### Example

Delete root from:

```
[60, 30, 50, 10, 20, 35, 40]
```

#### Tree Visualization

Initial Heap:

```
        60
       /  \
     30    50
    /  \  / \
  10  20 35  40
```

Replace root with last element (40):

```
        40
       /  \
     30    50
    /  \  /
  10  20 35
```

Swap with larger child (50):

```
        50
       /  \
     30    40
    /  \  /
  10  20 35
```

Heap restored

#### Array Transformation

```
[60, 30, 50, 10, 20, 35, 40]
→ [40, 30, 50, 10, 20, 35]
→ [50, 30, 40, 10, 20, 35]
```

### Time Complexity

* O(log n)

---

## 7. Real-Life Use Cases of Heaps

### 1. Priority Queues

* Task scheduling (OS)
* CPU job scheduling

### 2. Dijkstra’s Algorithm

* Shortest path in graphs

### 3. Heap Sort

* Efficient sorting algorithm (O(n log n))

### 4. Streaming Data

* Finding median in real-time

### 5. Top-K Problems

* Find K largest/smallest elements

### 6. Event Simulation Systems

* Handling time-based events

---

## Summary

* Heap is a complete binary tree with ordering property
* Efficient for min/max operations
* Stored as arrays for optimal performance
* Core operations take O(log n)
* Widely used in real-world systems and algorithms

---
