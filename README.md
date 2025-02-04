# Algorithms and Data Structures Laboratory Work

This repository contains fragments of laboratory work focused on various algorithms and data structures. The aim is to provide practical implementations and insights into the functioning of different sorting and hashing algorithms. 

## Table of Contents

1. [Laboratory Work 1](src/Lab_1_SortingAndHeap)  
   - Sorting Algorithms  
2. [Laboratory Work 2](src/Lab_2_HashingTechniques)  
   - Hashing Techniques  
3. [Laboratory Work 3](src/Lab_3_OpenAddressingTechniques)  
   - Open Addressing  
4. [Laboratory Work 4](src/Lab_4_RBT)  
   - Red-Black Tree  
5. [Laboratory Work 6](src/Lab_6_DynamicProgramming)  
   - Dynamic Programming  
6. [Laboratory Work 7](src/Lab_7_Graph)  
   - Graph Algorithms  
7. [Usage](#usage)  
8. [Contributing](#contributing)  
9. [License](#license)  


## [Laboratory Work 1](src/Lab_1_SortingAndHeap)
This section contains implementations of several sorting algorithms:

### Sorting Algorithms
1. **Heap Sort**
   - An efficient sorting algorithm based on a comparison.
2. **Quick Sort (ST Quick Sort)**
   - A highly efficient sorting algorithm using the divide-and-conquer approach. Variants included:
   - Iterative implementations: Lomuto, Hoare, Median-of-Three, Random with Insertion Sort.
   - Recursive implementations: Lomuto, Hoare.
3. **Selection Sort**
   - A simple comparison-based sorting algorithm that repeatedly selects the minimum element.
4. **Insertion Sort (ST Insertion Sort)**
   - An efficient algorithm for small datasets, building a sorted array one element at a time.
5. **Merge Sort (ST Merge Sort)**
   - A divide-and-conquer algorithm that divides the dataset into smaller subsets to sort them.
6. **Refalgsort**
   - An implementation of a reference sorting algorithm.
7. **Bubble Sort**
   - A simple comparison-based sorting algorithm.
8. **Counting Sort**
   - A non-comparison-based sorting algorithm that counts occurrences of each value.

## [Laboratory Work 2](src/Lab_2_HashingTechniques)
This section focuses on different hashing techniques:

### Hashing Techniques
1. **BasicHashTableImplementation**
   - BAsic implementation of a hash table   
2. **HashListChaining**
   - Implementation of a hash table that uses chaining for collision resolution.
3. **HashListChainingModularHashing**
   - A modular approach to hash list chaining.
4. **HashListChainingMultiplicativeHashing**
   - A multiplicative method for hash list chaining, improving distribution.

## [Laboratory Work 3](src/Lab_3_OpenAddressingTechniques)
This section focuses on different open addressing techniques:

### Open addressing techniques
1. **Linear Probing**
   - Simple to implement; finds the next available slot but can cause primary clustering as the table fills.
2. **Quadratic Probing**
   - Reduces primary clustering with quadratic jumps, though still vulnerable to secondary clustering.
3. **Double Hashing**
   - Uses two hash functions to minimize clustering and increase probe sequence variety.

## [Laboratory Work 4](src/Lab_4_RBT)
This section focuses on **Red-Black Trees**, a type of self-balancing binary search tree.

### Red-Black Tree
- Ensures balanced tree height for efficient operations.
- Guarantees **O(log n)** time complexity for insertion, deletion, and search.
- Uses color properties (Red/Black) and rotations to maintain balance.

## [Laboratory Work 6](src/Lab_6_DynamicProgramming)
This section covers **Dynamic Programming (DP)**, a technique for solving optimization problems.

### Dynamic Programming
- Breaks problems into overlapping subproblems.
- Uses memoization or tabulation to improve efficiency.

## [Laboratory Work 7](src/Lab_7_Graph)
This section focuses on **Graph Algorithms**, covering key traversal and pathfinding techniques.

### Graph Algorithms
- **Breadth-First Search (BFS)** and **Depth-First Search (DFS)** for graph traversal.
- **Dijkstra's Algorithm** for shortest path in weighted graphs.
- **Bellman-Ford Algorithm** for shortest paths with negative weights.
- **Kruskal’s and Prim’s Algorithm** for Minimum Spanning Tree (MST).

## Usage
To use the algorithms, clone the repository and navigate to the desired algorithm's directory. Each algorithm Each algorithm a test that can be used to verify it.

```bash
git clone https://github.com/yourusername/algorithms-data-structures.git
cd algorithms-data-structures
