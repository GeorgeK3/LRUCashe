# LRUCashe

**LRUCashe** is a Java-based cache implementation that leverages a HashMap and a FIFO queue to achieve LRU (Least Recently Used) cache behavior. The HashMap offers fast add, remove, and lookup operations, while the FIFO queue tracks key usage and enables updates for cache freshness.

## Features

- **HashMap Integration:**  
  Provides O(1) average time for add, remove, and lookup operations.
  
- **FIFO Queue for LRU:**  
  Maintains key order; an update(T item) method refreshes a key's usage when accessed.
  
- **LRU Eviction:**  
  Combines the strengths of both data structures to efficiently evict the least recently used entries.
