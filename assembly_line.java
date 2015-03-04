package assignment;

import java.util.Stack;

public class assembly_line {

	public static void fast_algo(int num, int start1, int start2, int end1,
			int end2, int[] s1, int[] s2, int[] t1, int[] t2) {
		int[] f1, f2, l1, l2;
		int optimal_cost, end;
		Stack st = new Stack();

		f1 = new int[num];
		f2 = new int[num];
		l1 = new int[num];
		l2 = new int[num];

		f1[0] = start1 + s1[0];
		f2[0] = start2 + s2[0];

		for (int j = 1; j < num; j++) {
			if ((f1[j - 1] + s1[j]) <= (f2[j - 1] + t2[j - 1] + s1[j])) {
				f1[j] = f1[j - 1] + s1[j];
				l1[j] = 1;
			} else {
				f1[j] = f2[j - 1] + t2[j - 1] + s1[j];
				l1[j] = 2;
			}

			if ((f2[j - 1] + s2[j]) <= (f1[j - 1] + t1[j - 1] + s2[j])) {
				f2[j] = f2[j - 1] + s2[j];
				l2[j] = 2;
			} else {
				f2[j] = f1[j - 1] + t1[j - 1] + s2[j];
				l2[j] = 1;
			}
		}

		if (f1[num - 1] + end1 < f2[num - 1] + end2) {
			optimal_cost = f1[num - 1] + end1;
			end = 1;
		} else {
			optimal_cost = f2[num - 1] + end2;
			end = 2;
		}

		int a = end;
		st.push(new Integer(end));

		for (int j = num - 1; j >= 1; j--) {

			if (a == 1) {
				a = l1[j];
				st.push(new Integer(a));

			} else {
				a = l2[j];
				st.push(new Integer(a));
			}
		}

		 
		
		System.out.println("\n\n\t\t\t The Result of simulation is \n\n");

		System.out.println("\n Optimal Cost is: " + optimal_cost);
		
		System.out.print("\n");
		System.out.print("The optimal cost for first station is : \n");
		
		
		 for(int r=0;r<num;r++)
		 {
			 
			 
			 System.out.print("  " +f1[r]);
			 
		 }
		 
		 
		 System.out.print("\n");
		 
		 System.out.print("The optimal cost for second station is : \n");
		 
		 for(int r=0;r<num;r++)
		 {
			 
			 
			 System.out.print("   " +f2[r]);
			 
		 }
		 
		 
		
		 System.out.println("\n");
		
		
		System.out.println("Optimal  Path\n");

		System.out.print(" Start-->");
		for (int j = 1; j <= num; j++) {

			Integer ans = (Integer) st.pop();
			System.out.print(" Station " + j + "  Line " + ans);
			if (j == num) {
				System.out.print(" --> Goal");
			} else {
				System.out.print(" --> ");
			}
		}

	}
}
