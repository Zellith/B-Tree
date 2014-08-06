import java.util.*;

public class MQ2V3 {


	public static void main(String[] args) {
		int[] ia = { 9, 6, 12, 8, 23 };
		int[] ia2 = { 15, 2, 33, 21, 29 };
		PriorityQueue<Integer> left = new PriorityQueue<Integer>();
		PriorityQueue<Integer> right = new PriorityQueue<Integer>();
		PriorityQueue<Integer> top = new PriorityQueue<Integer>();
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
		PriorityQueue<Integer> mid = new PriorityQueue<Integer>();
		// use offer() method to add elements to the PriorityQueue pq1
		for (int z : ia) {
			pq1.offer(z);
		}

		System.out.println("Priority Queue: " + pq1);

		//checks if the size of the queue exceeds the max Amount of Leaf nodes
		if(pq1.size() >= 4){ 
			for(int j=0; j<=1; j++){
				left.offer(pq1.poll());
				System.out.println(pq1);
				System.out.println("LEFT: "+left);//checks
			}
			top.offer(pq1.poll());
			System.out.println("TOP: "+top);//Checks
			for(int k =0; k<=1; k++){
				right.offer(pq1.poll());
				System.out.println("RIGHT: "+right);//checks 
			}
			right.offer(top.peek());
		}

		for(int z : ia2) {
			pq1.offer(z);
		}
		
		if(pq1.size() >= 4){ 
			for(int j=0; j<=1; j++){
				left.offer(pq1.poll());
				System.out.println(pq1);
				System.out.println("LEFT: "+left);//checks
			}
			top.offer(pq1.poll());
			System.out.println("TOP: "+top);//Checks
			for(int k =0; k<=1; k++){
				right.offer(pq1.poll());
				System.out.println("RIGHT: "+right);//checks 
			}

		}
		
		if(right.size() >= 4){ 
			for(int j=0; j<=1; j++){
				mid.offer(right.poll());
				System.out.println(right);
			}
			right.offer(right.peek());
			top.offer(right.poll());
			System.out.println("TOP: "+top);//Checks

		}
		
		
		System.out.println("TOP: "+top);
		System.out.println("LEFT: "+left);
		System.out.println("MID: "+mid);
		System.out.println("RIGHT: "+right);
		


		/*
			x = pq1.poll();
			y = pq1.poll();
			if(x<y)
			{
				e.offer(x);
				flag = true;
			}
		 */
	}
}
