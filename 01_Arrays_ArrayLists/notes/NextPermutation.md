# Next Permutation: Understanding the Breakpoint Approach

## 1. Problem Statement

Given an array representing a permutation of numbers, find the **next lexicographically greater permutation**.

If no such permutation exists (i.e., the current permutation is already the largest possible permutation), rearrange the array into the **smallest possible permutation**.

### Example

```text
Input  : [1, 2, 3]
Output : [1, 3, 2]
```

The permutations of `[1,2,3]` in lexicographical order are:

```text
[1,2,3]
[1,3,2]
[2,1,3]
[2,3,1]
[3,1,2]
[3,2,1]
```

The next permutation after `[1,2,3]` is `[1,3,2]`.

---

# 2. What Does "Next Permutation" Mean?

Think of permutations as dictionary words.

For example:

```text
12345
12354
12435
12453
12534
...
```

We want the **smallest permutation that is greater than the current one**.

Not:

```text
Any larger permutation
```

but specifically:

```text
The immediate next larger permutation
```

This requirement is what makes the problem interesting.

---

# 3. Core Observation

Consider:

```text
[1, 3, 5, 4, 2]
```

Look from right to left:

```text
5 > 4 > 2
```

The suffix:

```text
[5,4,2]
```

is already in descending order.

A descending sequence represents the **largest possible arrangement** of those elements.

For example:

```text
[5,4,2]
```

is larger than:

```text
[5,2,4]
[4,5,2]
[4,2,5]
...
```

Therefore:

> No larger permutation can be created by rearranging only this suffix.

To get a larger permutation, we must modify something before this descending suffix.

This observation leads to the concept of the **breakpoint**.

---

# 4. Finding the Breakpoint

## Definition

The breakpoint is the first index from the right where:

```text
arr[i] < arr[i+1]
```

This indicates that we can still create a larger permutation.

---

### Example

```text
[1, 3, 5, 4, 2]
```

Checking from right:

```text
4 > 2
5 > 4
3 < 5   ← Breakpoint
```

Breakpoint index:

```text
i = 1
```

Value:

```text
3
```

Visual:

```text
[1, 3, 5, 4, 2]
    ↑
 breakpoint
```

---

# 5. Why Is the Breakpoint Important?

Everything to the right of the breakpoint is already:

```text
Descending
```

which means:

```text
Maximum arrangement
```

So changing only that suffix cannot produce the next larger permutation.

The breakpoint is the first position where we can increase the number and create a larger overall permutation.

---

# 6. What Should We Swap With?

Suppose we have:

```text
[1, 3, 5, 4, 2]
```

Breakpoint value:

```text
3
```

The suffix is:

```text
[5,4,2]
```

We need a number:

```text
Greater than 3
```

Candidates:

```text
5
4
```

---

## Why Not Swap With 5?

If we swap with 5:

```text
[1,5,3,4,2]
```

This becomes much larger than necessary.

Remember:

```text
We need the immediate next permutation.
```

Therefore we must increase the number as little as possible.

---

## Correct Choice

Choose:

```text
Smallest element greater than 3
```

which is:

```text
4
```

After swapping:

```text
[1,4,5,3,2]
```

---

# 7. Why Search From the Right?

The suffix is already descending.

Example:

```text
[5,4,2]
```

The first element encountered from the right that is larger than the breakpoint automatically becomes the smallest valid larger element.

Example:

```text
5,4,2
```

Searching from right:

```text
2  → not > 3
4  → yes
```

Choose:

```text
4
```

No sorting or searching is required.

---

# 8. Why Is Swapping Alone Not Enough?

After swap:

```text
[1,4,5,3,2]
```

This is larger than the original permutation.

But is it the immediate next permutation?

No.

The suffix:

```text
[5,3,2]
```

is still in descending order.

Descending order represents the largest arrangement.

We want the smallest possible arrangement after fixing the prefix.

---

# 9. Why Reverse the Suffix?

Current array:

```text
[1,4,5,3,2]
```

Suffix:

```text
[5,3,2]
```

Descending order means:

```text
Largest arrangement
```

To get the immediate next permutation we need:

```text
Smallest arrangement
```

which is:

```text
[2,3,5]
```

Result:

```text
[1,4,2,3,5]
```

This is the next permutation.

---

# 10. Why Does Reversal Work?

Before swapping, the suffix was descending:

```text
[5,4,2]
```

After swapping it remains descending:

```text
[5,3,2]
```

The smallest arrangement of a descending sequence is simply its reverse.

```text
[5,3,2]
↓
[2,3,5]
```

Therefore:

```text
Reverse
```

is sufficient.

No sorting is required.

---

# 11. Complete Example

Input:

```text
[2,4,5,3,1]
```

---

### Step 1: Find Breakpoint

From right:

```text
3 > 1
5 > 3
4 < 5
```

Breakpoint:

```text
4
```

Index:

```text
1
```

---

### Step 2: Find Smallest Greater Element

Suffix:

```text
[5,3,1]
```

Numbers greater than 4:

```text
5
```

Swap:

```text
[2,5,4,3,1]
```

---

### Step 3: Reverse Suffix

Suffix:

```text
[4,3,1]
```

Reverse:

```text
[1,3,4]
```

Final:

```text
[2,5,1,3,4]
```

---

# 12. What If No Breakpoint Exists?

Consider:

```text
[5,4,3,2,1]
```

Checking from right:

```text
5 > 4
4 > 3
3 > 2
2 > 1
```

We never find:

```text
arr[i] < arr[i+1]
```

No breakpoint exists.

---

# 13. What Does No Breakpoint Mean?

The entire array is descending:

```text
[5,4,3,2,1]
```

A descending permutation is the largest possible permutation.

It is already the last permutation in lexicographical order.

There is no larger permutation available.

---

# 14. How Do We Handle This Case?

We return the smallest permutation.

Since the array is descending:

```text
[5,4,3,2,1]
```

Reverse it:

```text
[1,2,3,4,5]
```

This becomes the first permutation.

---

# 15. Complete Algorithm

### Step 1

Find breakpoint:

```text
arr[i] < arr[i+1]
```

from right to left.

---

### Step 2

If no breakpoint exists:

```text
Reverse entire array
Return
```

---

### Step 3

Find the first element from the right:

```text
arr[j] > arr[i]
```

---

### Step 4

Swap:

```text
arr[i]
arr[j]
```

---

### Step 5

Reverse:

```text
i+1 ... n-1
```

---

# 16. Time Complexity

Finding breakpoint:

```text
O(N)
```

Finding swap candidate:

```text
O(N)
```

Reversing suffix:

```text
O(N)
```

Total:

```text
O(N)
```

Space:

```text
O(1)
```

---

# Final Intuition

The algorithm works because:

1. The breakpoint identifies the first position that can still be increased.
2. Swapping with the smallest larger element creates the smallest possible increase.
3. Reversing the suffix makes the remaining portion as small as possible.
4. If no breakpoint exists, the permutation is already the largest, so we reset to the smallest permutation.

Thus we obtain the **immediate next lexicographical permutation** in linear time and constant space.
