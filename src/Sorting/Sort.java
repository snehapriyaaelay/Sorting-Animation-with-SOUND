package Sorting;

import java.awt.*;

public class Sort extends AlgorithmAnimator{
	protected int arr[];
	protected String algName;

	protected void scramble(){
		arr = new int[getSize().height/2];
		for(int i= arr.length;--i>0;){
			arr[i]=i;
		}
		for(int i=arr.length; --i>=0;){
			int j=(int)(i*Math.random());
			swap(arr,i,j);
		}
	}
	public void bubbleSort(int a[]){
		for(int i=a.length;--i>=0;){
			for(int j=0;j<i;j++){
				if(a[j]>a[j+1]){
					swap(a,j,j+1);
				}
				pause();
			}
			
		}
		
	}
	protected void quickSort(int a[],int lo0, int hi0){
		int lo= lo0, hi= hi0,mid;
		pause();
		if(hi0 > lo0){
			mid = a[(lo0+hi0) / 2];
			while(lo <= hi){
				while((lo < hi0) && (a[lo])< mid){
					++lo;
				}
				while((hi> lo0) && (a[hi] > mid)){
					--hi;
				}
				if(lo<=hi){
					swap(a,lo,hi);
					pause();
					++lo;
					--hi;
				}
			}
			if(lo0<hi){
				quickSort(a,lo0,hi);
			}
			if(lo<hi0){
				quickSort(a,lo,hi0);
			}
		}
		
		
	}
	protected void initAnimator(){
		algName = "BubbleSort";
		String at = getParameter("alg");
		if(at!=null){
			algName = at;
		}
		setDelay(20);
		scramble();
	}
	public void swap(int a[],int i,int j){
		int temp= a[i];
		a[i]= a[j];
		a[j]= temp;
		
	}
	
	@Override
	protected void algorithm() {
		// TODO Auto-generated method stub
		if("BubbleSort".equals(algName)){
			bubbleSort(arr);
		}
		else if("QuickSort".equals(algName)){
			quickSort(arr,0,arr.length-1);
		}
		else{
			bubbleSort(arr);
		}
	}

	@Override
	protected void paintFrame(Graphics g) {
		// TODO Auto-generated method stub
		Dimension d = getSize();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, d.width, d.height);
		g.setColor(Color.black);
		int y= d.height-1;
		double f= d.width/ (double) arr.length;
		for(int i= arr.length; --i>=0;y-=2){
			g.drawLine(0, y, (int)(arr[i]*f), y);
		}
		
		
	}

	
}
