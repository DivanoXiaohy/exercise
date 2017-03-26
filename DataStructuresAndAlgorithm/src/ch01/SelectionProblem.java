package ch01;

import java.util.Random;

public class SelectionProblem {

	//课后题1.1
	public static void main(String[] args) {
		long [] arr = createRandom(10000);
//		for(int i=0;i<arr.length;i++){
//			System.out.print(arr[i] + "  ");
//		}
		System.out.println();
		long t1 = System.currentTimeMillis();
		long a = findBySort(arr, 5000);
		long t2 = System.currentTimeMillis();
		long b = findByArray(arr, 5000);
		long t3 = System.currentTimeMillis();
		
		System.out.println(a+"  time:"+(t2-t1));
		System.out.println(b+"  time:"+(t3-t2));

	}
	
	
	//生成随机数组
	public static long[] createRandom(int n){
		long[] random = new long[n];
		Random r = new Random();
		for(int i=0;i<n;i++){
			random[i] = r.nextInt(1000);
		}
		return random;
	}
	
	//方法一：将数组进行排序，取前k个
	public static long findBySort(long[] arr,int k){
		quickSort(arr);
		
		return arr[arr.length-k];
	}
	
	//方法二：遍历随机数组，创建大小为k的数组，使该小数组在遍历过程中一直存放最大的k个数
	public static long findByArray(long[] arr,int k){
		long [] temp = new long[k];
		for(int i=0;i<k;i++){
			temp[i] = arr[i];
		}
		quickSort(temp);
		for(int j=k;j<arr.length;j++){
			if(arr[j] > temp[0]){
				temp[0] = arr[j];
				quickSort(temp);
			}
		}
		
		return temp[0];
	}
	
	//快速排序，从小到大
	private static long[] quickSort(long[] arr){
		sort(arr,0,arr.length-1);
		return arr;
	}
	private static void sort(long[] arr,int start,int end){
		if(start >= end){
			return;
		}
		int i=start,j=end;
		long tag = arr[i];
		boolean flag = true;
		while(i < j){
			if(flag){
				if(arr[j] < tag){
					long temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
					flag = !flag;
				}else{
					j--;
				}
			}else{
				if(arr[i] > tag){
					long temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
					flag = !flag;
				}else{
					i++;
				}
			}
		}
		
		sort(arr,start,i-1);
		sort(arr,j+1,end);
	}
	
	
	
	
	
	
}
