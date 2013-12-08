

import java.io.*;
import java.lang.String;
import java.nio.CharBuffer;



public class MaxSum {
    //File file;
    Reader reader;
    public int mode,row,line;
    int x1,y1,x2,y2;
    public int[][] matrix;
    public int[][] answer;
    public int[][] pre;
    String[] args;
    String filename;
    public String input;
    
    int sum = -1,max = 0;
	int columnsMax = 0;
	int prex1=0;
	int rowNumL;
	int rowNumR;
	int lineD;
	
    MaxSum(String string){
    	input = string;
    	matrix = new int[100][100];
    	answer = new int[100][100];
    	pre = new int[100][100];
    	String2Matrix();
    	System.out.println("");
      	for(int i=0; i<=row+1; i++){
    		for(int j=0; j<=line+1; j++)
    			System.out.print(this.answer[i][j] + " ");
    		System.out.println("");
    	}
      	System.out.println(this.max);
      	rowNumL = 1;
      	rowNumR = 1;
      	lineD = 1;
      	getPretreatment();
    }
    //字符串装换为数组
    void String2Matrix(){
    	int temp=0;
    	String[] nums = null;
    	nums = input.split(",");
    	System.out.println(nums.length);
    	for(int i=0; i<nums.length; i++){
    		temp = 0;
    		int set=1;
    		for(int j=0; j<nums[i].length();j++){
    			char here = nums[i].charAt(j);
    			if(here == '-')
    				set = -1;
    			if (here >= '0' &&  here <= '9')    //字符串转为数字
    				temp = temp*10+ (here - '0' );
    		}
    		temp = temp * set;
    		System.out.println(temp+" "+i);
    		if(i==0)
    			this.row = temp;
    		else if(i==1)
    			this.line = temp;
    		else matrix[(i-2)/this.line+1][(i-2)%this.line+1] = temp;
    	}
    	for(int i=0; i<=row+1; i++){
    		for(int j=0; j<=line+1; j++)
    			System.out.print(matrix[i][j] + " ");
    		System.out.println("");
    	}
    }
    
    //预处理函数  累加
    void getPretreatment(){
    	for(int i=1;i<=row;i++)
    		for(int j=1;j<=line;j++)
    			pre[i][j] = pre[i][j-1] + matrix[i][j];
    	oneStep(1,1, 1);
    }
    
    public int nstep(int n){
    	
    	while((n--)!=0){
//    	for(int i=1; i<=row; i++)
//    		for(int j=i;j<=row;j++){
//    			for(int k=1; k<=line; k++)
    	//上面for循环的 if实现
	    	lineD++;
	    	if(lineD > line){
	    		this.rowNumR++;
	    		if(this.rowNumR > row){
	    			rowNumL++;
	    			if(rowNumL > row){
	    				System.out.println(columnsMax);
	    				return -1;
	    			}
	    			rowNumR = 1;
	    		}
	    		lineD = 1;
	    		sum = -1;
	    	}
	    	oneStep( rowNumL, rowNumR, lineD);
    	}
    	System.out.println(rowNumL+" "+rowNumR+" "+lineD);
    	return 0;
    }
    
    void oneStep(int i,int j, int k){
        if(sum<0){
        	prex1 = k;
			sum=pre[k][j] - pre[k][i-1];
        }
        else
			sum+=pre[k][j] - pre[k][i-1];
		if(columnsMax < sum){
			columnsMax = sum;
			x1=prex1;
			y1=i;
			x2=k;
			y2=j;
			
			for(i=1; i<=this.row; i++)
	    	    for(j=1; j<=this.line; j++){
	    	    	this.answer[i][j] = 0;
	    	    }
			for(i=x1; i<=x2; i++)
	    	    for(j=y1; j<=y2; j++){
	    	    	this.answer[i][j] = 1;
	    	    }
		}
		
    }
    
}
