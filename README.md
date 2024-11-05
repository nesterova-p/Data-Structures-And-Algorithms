# Algorithms and Data Structures Laboratory Work

This repository contains fragments of laboratory work focused on various algorithms and data structures. The aim is to provide practical implementations and insights into the functioning of different sorting and hashing algorithms. 

## Table of Contents

1. [Laboratory Work 1](src/Lab_1_SortingAndHeap)
   - Sorting Algorithms
2. [Laboratory Work 2](src/Lab_2_HashingTechniques)
   - Hashing Techniques
3. [Laboratory Work 3](src/Lab_3_OpenAddressingTechniques)
   - Open Addressing
3. [Usage](#usage)
4. [Contributing](#contributing)
5. [License](#license)

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
Uses two hash functions to minimize clustering and increase probe sequence variety.

## Usage
To use the algorithms, clone the repository and navigate to the desired algorithm's directory. Each algorithm Each algorithm a test that can be used to verify it.

```bash
git clone https://github.com/yourusername/algorithms-data-structures.git
cd algorithms-data-structures
