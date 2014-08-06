import java.util.*;

public class MQ2V3 {

	public static void main(String[] args) {
		int[] ia = { 9, 6, 12, 8, 23 };
		int[] ia2 = { 15, 2, 33, 21, 29 };
		int peek;
		PriorityQueue<Integer> left = new PriorityQueue<Integer>();
		PriorityQueue<Integer> right = new PriorityQueue<Integer>();
		PriorityQueue<Integer> top = new PriorityQueue<Integer>();
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
		PriorityQueue<Integer> mid = new PriorityQueue<Integer>();

		//puts the values of array ia into PriorityQueue pq1
		for (int z : ia) {
			pq1.offer(z);
		}

		System.out.println("First Insert: " + pq1);

		//checks if the size of the queue exceeds the max Amount of Leaf nodes
		if(pq1.size() >= 4){ 
			//pops all values and stores them depending on the conditions they meet
			for(int j=0; j<=1; j++){
				System.out.println("poll("+pq1.peek()+")");
				peek = pq1.peek();
				left.offer(pq1.poll());
				System.out.println("Remaining : "+pq1);
				System.out.println("\noffer("+peek+")");
				System.out.println("LEFT: "+left+"\n");//checks left
			}

			//puts the value into the PQueue "top"
			peek = pq1.peek();
			top.offer(pq1.poll());
			System.out.println("offer ("+peek+")");
			System.out.println("TOP: "+top);//Checks top


			for(int k =0; k<=1; k++){
				peek = pq1.peek();
				right.offer(pq1.poll());
				System.out.println("\noffer ("+peek+")");
				System.out.println("RIGHT: "+right);//checks right
			}
			right.offer(top.peek()); //copies the value before splitting and inputs it into the right PQueue
		}
		//inserts the second array of elements
		//stores new values into PQueue "pq1"
		for(int z : ia2) {
			pq1.offer(z);
		}
		System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
		//arrange them based on the conditions

		System.out.println("First Insert: " + pq1);
		if(pq1.size() >= 4){ 
			for(int j=0; j<=1; j++){
				peek = pq1.peek();
				left.offer(pq1.poll());
				System.out.println("\noffer ("+peek+")");
				System.out.println("Remaning: "+pq1);
				System.out.println("LEFT: "+left);
			}

			peek = pq1.peek();
			top.offer(pq1.poll());
			System.out.println("offer ("+peek+")");
			System.out.println("TOP: "+top);
			for(int k =0; k<=1; k++){
				peek = pq1.peek();
				right.offer(pq1.poll());
				System.out.println("\noffer ("+peek+")");
				System.out.println("RIGHT: "+right); 
			}
		}

		//checks if the right queue exceeds the max allowed Leaf nodes and splits them
		if(right.size() >= 4){ 
			for(int j=0; j<=1; j++){
				peek = right.peek();
				mid.offer(right.poll());
				System.out.println("\npoll ("+peek+")");
				System.out.println("RIGHT: "+right);
				System.out.println("\noffer ("+peek+")");
				System.out.println("MID: "+mid); //stores into the new queue
			}
			right.offer(right.peek()); //copies the value before switching
			top.offer(right.poll());
		}


		System.out.println("\nTOP: "+top);
		System.out.println("LEFT: "+left);//Priority Queue arranges things in Natural Order but it seems it displays them quite differently
		System.out.println("MID: "+mid);
		System.out.println("RIGHT: "+right);

		
		int[] leftLeaf = new int[5];
		//int[] root = new int[5];	// ||==================||
		//int[] midLeaf = new int[5];	// ||Checker fields ||
		//int[] rightLeaf = new int[5];	// ||==================||
		
		/*
		for(int j=0; j<=top.size()+1 ; j++){
			root[j] = top.poll();
			//System.out.print(root[j]+" "); //checks if the leafs are properly arranged
		}*/
		
		//since PQueue was used needed to rearrange one more time b4 printing
		for(int j=0; j<=left.size()+2 ; j++){
			leftLeaf[j] = left.poll();
			//System.out.print(leftLeaf[j]+" "); //checks if the leafs are properly arranged
		}
		/* 
		for(int j=0; j<=mid.size() ; j++){
			midLeaf[j] = mid.poll();
			//System.out.print(midLeaf[j]+" "); //checks if the leafs are properly arranged
		}
		
		for(int j=0; j<=right.size()+1 ; j++){
			rightLeaf[j] = right.poll();
			//System.out.print(rightLeaf[j]+" "); //checks if the leafs are properly arranged
			}*/
		String str;
		StringBuilder sb = new StringBuilder();
		
		for(int j=0; j<=left.size()+3; j++)
		{
			str = Integer.toString(leftLeaf[j]);
			sb.append(" "+str+" ");
		}
		
		
		System.out.println("\n\n\t\t"+top+"\n"+"["+sb+"]"+"\t"+mid+"\t"+right);
		
	}
}
