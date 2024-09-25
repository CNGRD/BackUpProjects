package arrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CollectionExample {

	public static void main(String[] args) 
	{
		// List example
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        Collections.sort(list);
        System.out.println("Sorted List: " + list);

        // Set example
        Set<String> set = new HashSet<>(list);
        set.add("Banana"); // Duplicate, will not be added
        System.out.println("Set: " + set);

        // Map example
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Cherry", 3);
        System.out.println("Map: " + map);

        // Queue example
        Queue<String> queue = new LinkedList<>(list);
        System.out.println("Queue: " + queue);

	}

}
