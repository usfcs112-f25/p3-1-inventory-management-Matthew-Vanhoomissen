Matthew Vanhoomissen
I am attempting a B
You run javac Main.java then java Main ____ which is filled by a valid file name

The biggest challenge was meshing all of the data structure methods into one
program as to not have to repeat code. I did this by having the similar 
methods be in the same spot and the sets use the table for generation

✅ Specifications for a C (70)

To earn a C on Part 1, your program must successfully implement all the following:

Core Data Structures

✔️ Hash table that maps product IDs to product objects with O(1) average lookup
✔️ BST that stores products sorted by price (using the in-class BST implementation)
✔️ At least 2 sets for different tags/categories (e.g., “electronics”, “on-sale”)

Basic Operations

✔️ Add a new product (insert into hash table, BST by price, and appropriate tag sets)
✔️ Look up a product by exact ID using the hash table
✔️ Display all products sorted by price
✔️ Menu options to:
    ✔️ Search by product ID
    ✔️ Display all products sorted by price
    ✔️ Display all products in a specific category/set

Code Quality & Design

✔️ Javadoc comments for all project files, including a preamble for each file
✔️ UML Diagram for all classes (each class in a separate Java file)
✔️ Basic error handling (e.g., product ID not found)
✔️ Clear, readable function/method names
✔️ Includes at least 8 sample products from a CSV file provided at the command line

✅ Specifications for a B (80)

Complete all the requirements for a C and implement the following:

Custom Hash Table

✔️ Build your own hash table instead of Java’s HashMap
✔️ Use linear or quadratic probing for collision handling

Additional Operations

✔️ Remove a product by ID (remove from hash table, BST, and all tag sets)
✔️ Find products within a price range using the BST
✔️ Find most expensive and least expensive products in O(log n)
✔️ Maintain at least 3 different tag/category sets

Search Feature

✔️ Find and display all products with a user-specified tag/category

Code Quality and Validation

✔️ Comprehensive comments explaining data-structure interactions
✔️ Input validation (reject negative prices, empty IDs, duplicate IDs)
✔️ Includes at least 15 sample products from a CSV file provided at the command line
✔️ Menu options to:
    ✔️ Remove products
    ✔️ Find products
    ✔️ Display most/least expensive
    ✔️ Display products by category