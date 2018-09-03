/*
   Binary heap: Array representation of a heap-ordered complete binary tree.

   Heap-ordered binary tree:
   1. Keys in nodes.
   2. Parent's key no smaller than children's keys.

   Array representation:
   1. Indices start at 1.
   2. Take nodes in level order.
   3. No explicit linkes needed!

   Parent of node at k is at k/2;
   Children of node at k are at 2k and 2k+1;
 */
public class MaxPQ<Key extends Comparable<Key>>
{
	private Key[] pq;
	private int N;

	public MaxPQ(int capacity)
	{
		pq = (Key[]) new Comparable[capacity+1];
	}

	public boolean isEmpty()
	{ 
		return N == 0;
	}

	public void insert(Key key)
	{
		pq[++N] = x;
		swim(N);//to fix the violation
	}
	public Key delMax(){
		Key max = pq[1];
		exch(1, N--);
		sink(1);
		pq[N+1] = null;
		return max;
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
