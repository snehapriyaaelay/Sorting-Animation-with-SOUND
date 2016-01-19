package SortingAlgorithm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Sort2 extends AlgorithmAnimator{

protected SortAlgorithm theAlgorithm;
protected StaticAlgoFactory algorithmFactory;
protected int arr[];
protected String algName;

protected void initAnimator(){
	algName = "BubbleSort";
	String at = getParameter("alg");
	if(at!=null){
		algName = at;
	}
	algorithmFactory = new StaticAlgoFactory(this);
	theAlgorithm= algorithmFactory.makeSortAlgorithm(algName);
	setDelay(20);
	scramble();
	
}
protected void algorithm(){
	if(theAlgorithm!=null)
		theAlgorithm.sort(arr);
}

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

protected void paintFrame(Graphics g){
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
public void swap(int a[],int i,int j){
	int temp= a[i];
	a[i]= a[j];
	a[j]= temp;
	
}
}
