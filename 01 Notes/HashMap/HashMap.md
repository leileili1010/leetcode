# HashMap

## How to implement hashmap?

1. High-Level Overview

    The easiest way to describe it is: it’s basically an array of buckets, and each bucket can store either a single entry, a linked list of entries, or a red-black tree if collisions get too heavy.

2. How Keys Are Mapped to Buckets?

    When put(key, value) is called, a hash for the key is computed. It actually doesn’t use the raw hashCode() directly. There’s a small hash spreading function that mixes the high bits into the low bits: h ^ (h >>> 16)

    The goal is to avoid case where only the low bits vary, because the array size is always a power of two. After that, the bucket index is computed by: index = hash & (table.length - 1), So bucket selection is just a cheap bitwise AND, not a modulo.”

3. Collision Handling

    If two different keys land on the same bucket, the HashMap uses separate chaining. In Java 8 and later, chaining works in two modes:

    - Linked list – default
    - Red-black tree – when the chain gets too long

    When the number of entries in a single bucket exceeds 8 and the table is reasonably large (size ≥ 64), Java converts the linked list into a red-black tree. The idea is simple: avoid the worst-case O(n) lookup from a long list, and guarantee O(log n). But under normal distribution, we’re still close to O(1) average time.

4. Put Logic (What Actually Happens)

When inserting a value:

Compute hash

Find bucket index

If bucket is empty → place the node

If bucket is not empty → compare keys

If same key → overwrite value

If different key → add to the chain

If chain becomes too long → treeify

If size exceeds load factor threshold → resize

This shows interviewer you know the flow.

5. Load Factor & Resizing

A HashMap automatically resizes when the number of entries exceeds:

capacity × loadFactor


Default load factor is 0.75, which balances memory usage and collision probability. When resizing happens, the capacity doubles.

Java 8 optimizes rehashing during resize: each node either stays in the same bucket or moves to bucket + oldCapacity. So not every node needs a full rehash; it’s a small optimization.