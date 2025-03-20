import java.util.Scanner;

public class Parantheses2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        StringBuilder curr = new StringBuilder();
        StringBuilder stack = new StringBuilder();
        genParaBrace(0,0,0,0,curr,stack,n,m);
    }
    public static void genParaBrace(int lp, int rp, int lb, int rb, StringBuilder curr, StringBuilder stack, int n, int m){

        if(lb == m && rb == m && lp == n && rp == n && stack.length()==0){
            System.out.println(curr.toString());
        }

        //if ( is available
        if(lp < n){
            curr.append('(');
            stack.append('(');
            genParaBrace(lp+1,rp,lb,rb,curr,stack,n,m);
            curr.deleteCharAt(curr.length()-1);
            stack.deleteCharAt(stack.length()-1);
        }

        //if { is available
        if(lb < m){
            curr.append('{');
            stack.append('{');
            genParaBrace(lp,rp,lb+1,rb,curr,stack,n,m);
            curr.deleteCharAt(curr.length()-1);
            stack.deleteCharAt(stack.length()-1);
        }

        if(stack.length()>0) {


            //closing with ) if condition allows
            if (stack.charAt(stack.length() - 1) == '(') {
                curr.append(')');
                stack.deleteCharAt(stack.length() - 1);
                genParaBrace(lp, rp + 1, lb, rb, curr, stack, n, m);
                stack.append('(');
                curr.deleteCharAt(curr.length() - 1);
            }

            if (stack.charAt(stack.length() - 1) == '{') {
                curr.append('}');
                stack.deleteCharAt(stack.length() - 1);
                genParaBrace(lp, rp, lb, rb + 1, curr, stack, n, m);
                stack.append('{');
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }
}

/*

    Love the effort! Let’s break this down **step by step** so you don’t just "understand" it, but actually **see** the recursion and backtracking *visually* and *logically* in action.

---
 ✅ 1. What’s happening overall:
- We are generating all combinations of balanced parentheses `()` and braces `{}` with given counts `n` and `m`.
- `curr` holds the current string we are building.
- `stack` simulates which bracket we need to close next.
   - If the last element is `(`, we must eventually close it with `)`.
   - If the last element is `{`, we must eventually close it with `}`.

---

✅ 2. The recursion tree idea
Each recursive call does either:
- Add an opening bracket (`(` or `{`) if still available.
- Add a closing bracket (`)` or `}`) if it matches the last opened bracket and thus maintain correctness.

So at each step, you branch into either:
- "Add `"("` if possible
- "Add `"{"` if possible
- "Close a bracket" if the stack top allows it

---
 ✅ 3. Now, the **"last two code snippets"** you asked about — why are these lines necessary?

Let’s zoom into these two pieces:

```java
// closing with ) if condition allows
if (stack.charAt(stack.length() - 1) == '(') {
    curr.append(')');
    stack.deleteCharAt(stack.length() - 1);
    genParaBrace(lp, rp + 1, lb, rb, curr, stack, n, m);
    stack.append('(');  // <== THIS LINE
    curr.deleteCharAt(curr.length() - 1); // <== THIS LINE
}
```
And similarly:
```java
if (stack.charAt(stack.length() - 1) == '{') {
    curr.append('}');
    stack.deleteCharAt(stack.length() - 1);
    genParaBrace(lp, rp, lb, rb + 1, curr, stack, n, m);
    stack.append('{'); // <== THIS LINE
    curr.deleteCharAt(curr.length() - 1); // <== THIS LINE
}
```

---

✅ 4. Why these lines?
> The reason is **backtracking**.

- `curr.append(')')` or `curr.append('}')` moves forward in one "choice branch".
- But after you come back from that recursive call (once that path has been explored), you **need to undo your choice** so that the next iteration or branch can explore other possibilities.
- `curr.deleteCharAt(curr.length()-1);` is like:
> "Okay, I tried adding this `)` or `}`, done exploring that path, now let's erase that character and try something else."

- `stack.append('(');` or `stack.append('{');`
  This one can be confusing:
  - You popped the last opened bracket from `stack` when you decided to close it (simulate that it's been closed).
  - But after recursion returns, you need to **restore** the stack to the previous state so other branches can work with the same conditions.

**Analogy:**
Imagine walking down a maze and leaving a breadcrumb for every turn.
- When you backtrack, you need to pick up that breadcrumb so that on the next exploration branch, the breadcrumbs are laid correctly.

---

✅ 5. Visual Dry Run Example (small case: `n=1`, `m=1`)
You have:
- Need one pair of `()` and one pair of `{}`.

#### At the start:
- curr = `""`, stack = `""`
- Add `(` → curr = `"("`, stack = `"("`
- Recurse: now add `{` → curr = `"({"`, stack = `"({"`
- Now you can either close `{` or close `(` or open something else (none available). So let's try closing `{`:
  - curr = `"({}"`, stack = `"("`
  - Recurse: Now can close `(`:
    - curr = `"({})"`, stack = `""`
    - Perfect! Print `({})`
  - Backtrack: remove `)`, restore stack with `(` back.
- After that, backtrack: remove `}`, add `{` back to stack, remove `{` from curr.
- Then go to other branches, like:
  - Start with `{` first, then `(`, etc.
  - Each time, after recursion call finishes, we roll back both `curr` and `stack` to explore other branches.

---

✅ 6. Mental model for those two lines:
| Action inside recursion                         | Why?                                                                    |
|-------------------------------------------------|-------------------------------------------------------------------------|
| `stack.append(...)` after the recursive call    | Restore the stack to its original state after exploring one branch.     |
| `curr.deleteCharAt(...)` after the recursive call | Erase the last character added in `curr` so you can try another option. |

---

✅ 7. Conclusion: The essence
Backtracking =
> Try something → Recurse → Done exploring that path → Undo changes → Try next possibility.

These two lines are exactly that **"undo changes"** part.

---

### ✅ If you want, I can draw the recursion tree visually for a small example (`n=1, m=1`) — do you want me to? 😄



Start: curr="", stack=""
   |
   +-- Add '('
   |    curr="(", stack="("
   |       |
   |       +-- Add '{'
   |       |    curr="({", stack="({"
   |       |       |
   |       |       +-- Close '{'
   |       |       |    curr="({}", stack="("
   |       |       |       |
   |       |       |       +-- Close '('
   |       |       |            curr="({})", stack=""   <-- Output #1
   |       |       |
   |       |       +-- (Backtrack)
   |       |
   |       +-- Close '('
   |            curr="()", stack=""
   |               |
   |               +-- Add '{'
   |                    curr="(){", stack="{"
   |                       |
   |                       +-- Close '{'
   |                            curr="(){}", stack=""  <-- Output #2
   |
   +-- Add '{'
        curr="{", stack="{"
           |
           +-- Add '('
           |    curr="{(", stack="{("
           |       |
           |       +-- Close '('
           |            curr="{()", stack="{"
           |               |
           |               +-- Close '{'
           |                    curr="{()}", stack=""   <-- Output #3
           |
           +-- Close '{'
                (not explored because no more '(' available)

 */