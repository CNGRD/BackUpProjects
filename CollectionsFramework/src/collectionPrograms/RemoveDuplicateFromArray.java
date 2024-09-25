package collectionPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateFromArray {

	public static void main(String[] args) 
	{
		// set approach is simple easy to remove duplicates
		int[] array = {1, 2, 3, 4, 2, 3, 5, 6};

        // Use LinkedHashSet to preserve order
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int num : array) 
        {
            set.add(num);
        }
 
        ArrayList<Integer> alist = new ArrayList<Integer>(set);
        Object[] obj = alist.toArray();
        for(int i =0 ; i<obj.length ; i++)
        {
        	System.out.println(obj[i]);
        }
	}

}
