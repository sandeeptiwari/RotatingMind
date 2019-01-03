package cachetest;

import cache.LRUCache;
import modle.Address;
import modle.Employee;
import org.junit.Assert;
import org.junit.Test;

public class TestCache {

    @Test
    public void eldestElementShouldRemoveIfSizeGreaterThanInputedSize(){
        Address a1 =  new Address(20001, "delhi", "110096", "India");
        Employee e1 = new Employee(1009, "Sam", a1);
        Address a2 =  new Address(20002, "south delhi", "110090", "India");
        Employee e2 = new Employee(2009, "Ambay", a2);
        Address a3 =  new Address(20003, "wes delhi", "110078", "India");
        Employee e3 = new Employee(3009, "Joya", a3);
        Address a4 =  new Address(20004, "north delhi", "110077", "India");
        Employee e4 = new Employee(4009, "Boya", a4);
        Address a5 =  new Address(20005, "east delhi", "110075", "India");
        Employee e5 = new Employee(5009, "Sean", a5);

        LRUCache<Employee, Address> lru = LRUCache.newInstance(3);

        lru.put(e1, a1);
        lru.put(e2, a2);
        lru.put(e3, a3);
        lru.put(e4, a4);
        lru.put(e5, a5);

        Assert.assertNull(lru.get(e1));
    }
}
