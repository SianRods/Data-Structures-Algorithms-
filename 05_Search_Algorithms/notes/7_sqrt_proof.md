# Mathematical Proof: Bound of the Square Root Function

In the design and analysis of algorithms—specifically when optimizing search spaces for prime factorization, trial division, and binary search bounds—it is a foundational invariant that:

$$\forall n \ge 4, \quad \sqrt{n} \le \frac{n}{2}$$

Below is the detailed formal mathematical proof of this property using algebraic manipulation, calculus, and mathematical induction.

---

## 1. Domain Clarification & The Baseline Pivot

Before proving the general case, we must evaluate the behavior of the functions $f(n) = \sqrt{n}$ and $g(n) = \frac{n}{2}$ across different intervals of the real number system ($n \in \mathbb{R}^+$).

* **Interval $0 < n < 4$:** In this small window, $\sqrt{n} > \frac{n}{2}$.
* *Example ($n=1$):* $\sqrt{1} = 1$, whereas $\frac{1}{2} = 0.5$. Here, $1 > 0.5$.
* *Example ($n=2$):* $\sqrt{2} \approx 1.414$, whereas $\frac{2}{2} = 1$. Here, $1.414 > 1$.


* **The Equivalence Pivot ($n = 4$):** This is the exact intersection point where the two functions meet.

$$\sqrt{4} = 2 \quad \text{and} \quad \frac{4}{2} = 2 \implies \sqrt{4} = \frac{4}{2}$$



Thus, the claim that $\sqrt{n}$ is bounded by $\frac{n}{2}$ strictly holds true for all **$n \ge 4$**.

---

## 2. Method 1: Algebraic Proof (Direct Demonstration)

We want to prove that $\sqrt{n} \le \frac{n}{2}$ for all $n \ge 4$.

**Step 1:** Assume the inequality holds true:


$$\sqrt{n} \le \frac{n}{2}$$

**Step 2:** Since both sides of the inequality are strictly positive for $n \ge 4$, we can square both sides without altering the direction of the inequality sign:


$$(\sqrt{n})^2 \le \left(\frac{n}{2}\right)^2$$

$$n \le \frac{n^2}{4}$$

**Step 3:** Multiply both sides by $4$ to clear the denominator:


$$4n \le n^2$$

**Step 4:** Rearrange the terms into a standard quadratic inequality form:


$$n^2 - 4n \ge 0$$

$$n(n - 4) \ge 0$$

### Analysis of the Result:

For the product $n(n - 4)$ to be greater than or equal to zero, both components must share the same sign.

* Since our domain is strictly positive integers/real numbers ($n \ge 4$), the term $n$ is strictly positive ($n > 0$).
* The term $(n - 4)$ will be strictly greater than or equal to zero if and only if $n \ge 4$.

Because our initial steps were entirely reversible algebraic operations, the fact that $n(n-4) \ge 0$ is true for all $n \ge 4$ logically proves that our original assumption, $\sqrt{n} \le \frac{n}{2}$, is **indisputably true** for the same domain. $\blacksquare$

---

## 3. Method 2: Calculus-Based Proof (Rate of Growth Analysis)

We can analyze the behavior of these two functions by defining a continuous difference function:

$$D(n) = \frac{n}{2} - \sqrt{n}$$

Our goal is to show that $D(n) \ge 0$ for all $n \ge 4$.

**Step 1: Evaluate the base boundary condition ($n = 4$)**


$$D(4) = \frac{4}{2} - \sqrt{4} = 2 - 2 = 0$$

**Step 2: Compute the first derivative to evaluate the rate of growth**


$$D'(n) = \frac{d}{dn}\left(\frac{n}{2} - n^{1/2}\right)$$

$$D'(n) = \frac{1}{2} - \frac{1}{2\sqrt{n}}$$

**Step 3: Analyze the sign of $D'(n)$ for $n > 4$**
If $n > 4$, then it follows that:


$$\sqrt{n} > \sqrt{4} \implies \sqrt{n} > 2$$

$$\frac{1}{\sqrt{n}} < \frac{1}{2}$$

$$\frac{1}{2\sqrt{n}} < \frac{1}{4}$$

Substituting this back into our derivative expression:


$$D'(n) = \frac{1}{2} - \text{something smaller than } \frac{1}{2} \implies D'(n) > 0$$

### Conclusion of Derivative Analysis:

Because the derivative $D'(n)$ is strictly positive for all $n > 4$, the function $D(n)$ is **monotonically increasing**. Since it starts exactly at $0$ when $n=4$ and grows continually larger as $n$ increases, the difference $\frac{n}{2} - \sqrt{n}$ can never drop below zero. Therefore, $\sqrt{n}$ can never exceed $\frac{n}{2}$ for $n \ge 4$. $\blacksquare$

---

## 4. Algorithmic Impact: Why This Matters in DSA

This mathematical truth directly dictates structural loop constraints when writing highly optimized code:

```text
// Highly Optimized Prime Verification Loop
For (int i = 2; i * i <= n; i++) { ... }

```

Because $\sqrt{n}$ is mathematically guaranteed to be significantly smaller than $n/2$ for all large numbers, checking factors up to $\sqrt{n}$ limits search execution steps to $\mathcal{O}(\sqrt{N})$ iterations.

Attempting to search for factors up to $n/2$ (a common brute-force pitfall) forces the CPU to iterate through a vastly larger linear space, ignoring the mathematical bound established above.