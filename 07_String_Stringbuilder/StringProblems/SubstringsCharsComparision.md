In Java, to check if a string contains a specific character, you can use a few simple ways:

### 1. Using `String.indexOf()`
```java
String str = "Hello World";
char ch = 'W';

if (str.indexOf(ch) != -1) {
    System.out.println("Character found!");
} else {
    System.out.println("Character not found.");
}
```
- `indexOf(char)` returns the index of the first occurrence of the character.
- If the character isn't found, it returns `-1`.

---

### 2. Using `String.contains()` (for strings, **not** single characters)
If you want to check for a **character** as a **string**, you can do:
```java
String str = "Hello World";
String ch = "W";

if (str.contains(ch)) {
    System.out.println("Character found!");
}
```
> But `contains()` works with a **CharSequence** (like `String`), not a `char`.  
> So if you have a `char`, you need to convert it to a `String` first.

---

### 3. Using a simple loop (alternative)
```java
String str = "Hello World";
char target = 'W';
boolean found = false;

for (char c : str.toCharArray()) {
    if (c == target) {
        found = true;
        break;
    }
}

if (found) {
    System.out.println("Character found!");
}
```

---

**Quick Tip**:  
- `indexOf()` is the most common and clean way if you're only checking presence.  
- Use a loop if you need more control (like counting multiple occurrences).

---


## Longest Non-Repeating Substring Optimised Approach 
Alright — here’s a clean explanation of your **optimized** code:

---

### Step-by-step:

#### 1. **Variables Setup**:
```java
int n = s.length();
int maxLength = 0;
int[] lastIndex = new int[128];
```
- `n` = length of the string.
- `maxLength` = the answer we want to calculate.
- `lastIndex` = array to store **last seen position** of each character.  
  (Assuming ASCII characters → size 128.)

---
#### 2. **Sliding Window** using two pointers:
```java
for (int start = 0, end = 0; end < n; end++)
```
- `start` = beginning index of current substring without duplicates.
- `end` = current character position we're checking.

---
#### 3. **At each `end` character**:

```java
char currentChar = s.charAt(end);
start = Math.max(start, lastIndex[currentChar]);
```
- **Check if** this character `currentChar` has appeared **after `start`**.  
- If yes, **move `start`** to **right after** its last appearance (`lastIndex[currentChar]`).
- We use `Math.max` to make sure `start` **only moves forward**, never backward.

---
#### 4. **Update maxLength**:

```java
maxLength = Math.max(maxLength, end - start + 1);
```
- Update the maximum substring length seen so far.
- Window size is `(end - start + 1)`.

---
#### 5. **Record the latest position**:

```java
lastIndex[currentChar] = end + 1;
```
- Store the **index + 1** (important!) of `currentChar`.  
- Why `end + 1`? Because when checking again, we want to move to **after** the last seen index.

---

### Quick Example: `"abcabcbb"`

| end | currentChar | lastIndex | start | window | maxLength |
|:---|:---|:---|:---|:---|:---|
| 0 | 'a' | 0 → 1 | 0 | (0-0+1)=1 | 1 |
| 1 | 'b' | 0 → 2 | 0 | (1-0+1)=2 | 2 |
| 2 | 'c' | 0 → 3 | 0 | (2-0+1)=3 | 3 |
| 3 | 'a' | 1 | 1 | (3-1+1)=3 | 3 |
| 4 | 'b' | 2 | 2 | (4-2+1)=3 | 3 |
| 5 | 'c' | 3 | 3 | (5-3+1)=3 | 3 |
| 6 | 'b' | 5 | 5 | (6-5+1)=2 | 3 |
| 7 | 'b' | 6 | 6 | (7-6+1)=2 | 3 |

Final answer: **3** (from "abc").

---

### Summary:

- This solution runs in **O(n)** time.
- Efficient because **each character is processed once**.
- `lastIndex` array gives **O(1)** lookup for last seen position.

---

