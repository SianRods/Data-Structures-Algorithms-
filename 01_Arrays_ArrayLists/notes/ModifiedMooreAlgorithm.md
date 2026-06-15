# Modified Moore's Voting Algorithm (Majority Element II)

## Problem Statement

Given an integer array `nums`, find all elements that appear **more than ⌊n/3⌋ times**.

Example:

```java
nums = [1,1,1,2,2,2,3]
```

Output:

```java
[1,2]
```

---

# Key Observation

## How many majority elements can exist?

For the original Majority Element problem:

```java
frequency > n/2
```

Only **one** majority element can exist.

For Majority Element II:

```java
frequency > n/3
```

At most **two** elements can satisfy this condition.

### Proof

Assume three elements exist:

```java
A appears > n/3 times
B appears > n/3 times
C appears > n/3 times
```

Then:

```text
count(A) + count(B) + count(C)
>
n/3 + n/3 + n/3
=
n
```

This is impossible because the array only contains `n` elements.

Therefore:

> There can never be more than **2** valid answers.

This is the reason we only track:

```java
candidate1
candidate2
count1
count2
```

---

# Intuition Behind Moore's Voting

Before understanding the modified version, let's recall the original one.

Suppose:

```java
[2,2,1,1,1,2,2]
```

Every time we see a different element:

```text
2 cancels 1
2 cancels 1
```

Eventually:

```text
2 survives
```

The majority element cannot be completely cancelled because it appears more than half the time.

---

# Extending This Idea to n/3

Instead of removing pairs:

```text
(A, B)
```

we remove triplets:

```text
(A, B, C)
```

where all three are different.

Why?

Because we're looking for elements occurring more than:

```java
n/3
```

An element appearing more than `n/3` times cannot be completely eliminated by repeatedly removing groups of 3 distinct elements.

This is the entire mathematical foundation of the algorithm.

---

# Core Idea

Whenever we encounter:

```text
candidate1
candidate2
new distinct value
```

we can safely remove one occurrence of each.

This corresponds to:

```java
count1--;
count2--;
```

---

# Why Decrementing Both Counts Makes Sense

Consider:

```java
[1,2,3]
```

No element can be a majority.

Think of removing:

```text
1
2
3
```

all together.

After removal:

```text
nothing remains
```

Now consider:

```java
[1,1,1,2,2,2,3]
```

Remove one triplet:

```text
1,2,3
```

Remaining:

```text
1,1
2,2
```

The true majority candidates:

```text
1 and 2
```

still survive.

Thus:

> Removing one occurrence from candidate1, candidate2, and the current third element does not affect the final answer.

---

# The Algorithm

We maintain:

```java
candidate1
candidate2

count1
count2
```

---

## Case 1

Current element equals candidate1

```java
count1++;
```

---

## Case 2

Current element equals candidate2

```java
count2++;
```

---

## Case 3

count1 == 0

```java
candidate1 = nums[i];
count1 = 1;
```

We have an empty slot.

---

## Case 4

count2 == 0

```java
candidate2 = nums[i];
count2 = 1;
```

We fill the second slot.

---

## Case 5

Current number matches neither candidate

and

```java
count1 > 0
count2 > 0
```

Then:

```java
count1--;
count2--;
```

This represents removing:

```text
candidate1
candidate2
currentElement
```

as one distinct triplet.

---

# Complete Flow

```java
for(num : nums)

    if(num == candidate1)
        count1++;

    else if(num == candidate2)
        count2++;

    else if(count1 == 0)
        candidate1 = num;
        count1 = 1;

    else if(count2 == 0)
        candidate2 = num;
        count2 = 1;

    else
        count1--;
        count2--;
```

---

# Most Important Edge Case Dry Run

Let's use:

```java
[1,2,3,1,2,3,1,2]
```

Expected answer:

```java
[1,2]
```

because:

```java
1 -> 3 times
2 -> 3 times
3 -> 2 times
```

and:

```java
n = 8
n/3 = 2
```

Need:

```java
count > 2
```

---

## Initial State

```java
candidate1 = ?
candidate2 = ?

count1 = 0
count2 = 0
```

---

### Read 1

```java
count1 == 0
```

Assign:

```java
candidate1 = 1
count1 = 1
```

State:

```java
c1=1 cnt1=1
c2=? cnt2=0
```

---

### Read 2

```java
count2 == 0
```

Assign:

```java
candidate2 = 2
count2 = 1
```

State:

```java
c1=1 cnt1=1
c2=2 cnt2=1
```

---

### Read 3

Matches neither.

Both counts > 0.

Decrement both:

```java
count1--
count2--
```

State:

```java
c1=1 cnt1=0
c2=2 cnt2=0
```

Interpretation:

```text
Removed (1,2,3)
```

---

### Read 1

```java
count1 == 0
```

Assign:

```java
candidate1 = 1
count1 = 1
```

State:

```java
c1=1 cnt1=1
c2=2 cnt2=0
```

---

### Read 2

```java
count2 == 0
```

Assign:

```java
candidate2 = 2
count2 = 1
```

State:

```java
c1=1 cnt1=1
c2=2 cnt2=1
```

---

### Read 3

Again:

```java
count1--
count2--
```

State:

```java
c1=1 cnt1=0
c2=2 cnt2=0
```

Interpretation:

```text
Removed another (1,2,3)
```

---

### Read 1

```java
candidate1 = 1
count1 = 1
```

---

### Read 2

```java
candidate2 = 2
count2 = 1
```

Final candidates:

```java
candidate1 = 1
candidate2 = 2
```

---

# Why Verification Pass Is Required

After phase 1:

```java
candidate1
candidate2
```

are only **potential candidates**.

They are not guaranteed answers.

Example:

```java
[1,2,3,4]
```

The voting phase will still leave some candidates.

But:

```java
1 -> 1
2 -> 1
3 -> 1
4 -> 1
```

No element appears more than:

```java
4/3 = 1
```

Need:

```java
count > 1
```

No valid answer.

Therefore we must count frequencies again.

---

# Verification Phase

```java
count1 = 0;
count2 = 0;

for(int num : nums)
{
    if(num == candidate1)
        count1++;

    else if(num == candidate2)
        count2++;
}
```

Then:

```java
if(count1 > n/3)
    add(candidate1);

if(count2 > n/3)
    add(candidate2);
```

---

# Complexity Analysis

### Voting Phase

```java
O(n)
```

### Verification Phase

```java
O(n)
```

Total:

```java
O(n)
```

---

### Space Complexity

Only:

```java
candidate1
candidate2
count1
count2
```

are stored.

Therefore:

```java
O(1)
```

---

# Mental Model to Remember

For the original Moore's algorithm:

```text
Remove pairs of different elements.
```

For Majority Element II:

```text
Remove triplets of distinct elements.
```

Whenever you see a third distinct value while both candidate slots are occupied:

```java
count1--;
count2--;
```

you are effectively removing:

```text
(candidate1, candidate2, currentElement)
```

from consideration.

Any element appearing more than `n/3` times can never be completely removed through this process, which is why the surviving candidates after Phase 1 are the only possible answers.
