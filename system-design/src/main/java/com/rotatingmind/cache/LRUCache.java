package com.rotatingmind.cache;

import com.rotatingmind.cache.model.CacheItem;
import java.util.HashMap;
import java.util.Map;

/**
 * We'll follow two steps after a cache miss occurs:
 *
 * Add a new element in front of the list.
 * Add a new entry in HashMap and refer to the head of the list.
 *
 *
 * we'll do two steps after a cache hit:
 *
 * Remove the hit element and add it in front of the list.
 * Update HashMap with a new reference to the front of the list.
 * @param <K>
 * @param <V>
 */
public class LRUCache<K, V> {
    private Map<K, CacheItem> map;
    private CacheItem first, last;
    private int size;
    private final int CAPACITY;
    private int hitCount = 0;
    private int missCount = 0;

    public LRUCache(int capacity) {
        CAPACITY = capacity;  //
        map = new HashMap<>(CAPACITY);
    }

    public V get(K key) {
        if(!map.containsKey(key)) {
            return null;
        }
        CacheItem node = map.get(key);
        node.incrementHitCount();
        reorder(node);
        return (V) node.getValue();
    }

    public void delete(K key) {
        deleteNode(map.get(key));
    }

    public void put(K key, V value) {
        CacheItem node = new CacheItem(key, value);

        if(map.containsKey(key) == false) {
            if(size() >= CAPACITY) {
                deleteNode(first);
            }
            addNodeToLast(node);
        }
        map.put(key, node);
    }

    private void addNodeToFirst(CacheItem node) {
        if(first != null) {
            node.setNext(first);
            first.setPrev(node);
        }
        first = node;

        if(last == null) {
            last = node;
        }
        size++;
    }

    private void addNodeToLast(CacheItem node) {
        if(last != null) {
            last.setNext(node);
            node.setPrev(last);
        }

        last = node;
        if(first == null) {
            first = node;
        }
        size++;
    }

    private void deleteNode(CacheItem node) {
        if(node == null) {
            return;
        }
        if(last == node) {
            last = node.getPrev();
        }
        if(first == node) {
            first = node.getNext();
        }
        map.remove(node.getKey());
        node = null; // Optional, collected by GC
        size--;
    }

    private void reorder(CacheItem node) {
        if (last == node) {
            return;
        }
        if (first == node) {
            first = node.getNext();
        } else {
            node.getPrev().setNext(node.getNext());
        }
        last.setNext(node);
        node.setPrev(last);
        node.setNext(null);
        last = node;
    }

    private void reorder1(CacheItem node) {
        if(last == node) {
            return;
        }
        CacheItem nextNode = node.getNext();
        while (nextNode != null) {
            if(nextNode.getHitCount() > node.getHitCount()) {
                break;
            }
            if (first == node) {
                first = nextNode;
            }
            if (node.getPrev() != null) {
                node.getPrev().setNext(nextNode);
            }
            nextNode.setPrev(node.getPrev());
            node.setPrev(nextNode);
            node.setNext(nextNode.getNext());
            if(nextNode.getNext() != null) {
                nextNode.getNext().setPrev(node);
            }
            nextNode.setNext(node);
            nextNode = node.getNext();
        }
        if(node.getNext() == null) {
            last = node;
        }
    }

    public int size() {
        return size;
    }

    public int getHitCount() {
        return hitCount;
    }

    public int getMissCount() {
        return missCount;
    }
}
