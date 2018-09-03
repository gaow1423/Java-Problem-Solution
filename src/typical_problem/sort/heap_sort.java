/*
   1.create max-heap with all N keys.
   2.Repeatedly remove the maximum key.
 */
public class Heap{
	public static void sort(Comparable[] pq){
		int N = pq.length;
		for(int k = N/2; k >= 1)
			sink(pq, k, N);
		while (N > 1){
			exch(pq, 1, N);
			sink(pq, 1, --N);
		}
	}
	//To eliminate the violation(Child's key becomes larger key than its parent's key):
	private void swim(int k){
		while(k > 1 && less(k/2, k))
		{
			exch(k, k/2);
			k = k/2;
		}
	}
	//Parent's key becomes smaller key than its children's key
	private void sink(int k){
		while(2*k <= N)
		{
			int j = 2*k;
			if(j < N && less(j, j + 1)) j++;
			if(!less(k, j)) break;
			exch(k, j);
			k = j;
		}
	}
	private boolean less(int i, int j)
	{
		return pq[i].compareTo(pq[j]) < 0;
	}
	private void exch(int i, int j)
	{
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}
}
