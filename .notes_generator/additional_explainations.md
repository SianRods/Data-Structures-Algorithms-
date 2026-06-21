# Topic: [e.g., Binary Search]

## General Theory
[Explain the core invariant of Binary Search. E.g., The search space must be monotonic (sorted or having a clear boolean boundary like FFFFFTTTTT). Explain how to calculate `mid = left + (right - left) / 2` to avoid integer overflow.]

## Common Pitfalls
* Infinite loops when `left = mid` instead of `left = mid + 1`.
* Failing to recognize that the array does not need to be sorted, but rather a monotonic function can be applied to it.

## When to apply
* When the problem asks for the "minimum of a maximum" or "maximum of a minimum".
* When time complexity needs to drop from O(N) to O(log N).