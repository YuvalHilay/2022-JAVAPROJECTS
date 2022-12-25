package tasks;

public class Tasks {
	private int num; //number of tasks
	private int [][] dep; //depends table
	public Tasks(int num) {    
		this.num=num;
		dep=new int[num][num];
	}
	public boolean dependsOn(int task1, int task2) { //func update depends table
		if(task1>num-1 ||task1<0 ||task2>num-1 ||task2<0)
			return false;
		dep[task1][task2]=1;
		return true;
	}
	public int[] order() {
		int sum=0,sum2=0; //define variables
		int index=0,backindex=0; 
		boolean flag=true; //flag for know when stop the do while
		int [][]copdep=new int[num][num];//array to save our array
		int [] out=new int[num]; //array for output
		for(int k=0;k<num;k++) {  //initialize out array to -1
			out[k]=-1;
		}
		for(int i =0;i<num;i++)//copy the array
			for(int j=0;j<num;j++)
				copdep[i][j]=dep[i][j];
		do {
			backindex=index;
			for(int i=0;i<num;i++) { 
				for(int j=0;j<num;j++) {
					if(copdep[i][j]==0) //check if row is only 0 using sum
						sum++;
			    }	
			if(sum==num) { //if the row is only 0
				for(int t=0;t<num;t++) { //check if the row number appear in the output
					if(out[t]!=i)
						sum2++;
				}
				if(sum2==num) { //if he don't appear insert him 
					out[index]=i;
					index++;
					for(int k=0;k<num;k++) { //zero the column accordingly
						copdep[k][i]=0;
					}
				}
				sum2=0;
			}
			sum=0;
		}
			if(backindex==index||index==num) { //check if to stop do while 
				flag=false;
			}
	}while(flag);	
		if(index==num) { //check what output to give
			return out;
		}
		else
			return null;
	}
}
