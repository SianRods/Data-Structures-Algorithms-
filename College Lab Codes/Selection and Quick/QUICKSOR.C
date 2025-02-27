#include<stdio.h>
#include<conio.h>
int partition(int arr[],int start,int end)
{
   // choosing pivot as the end point of the array
	int pivot =arr[end];
	int i=start-1;
	int j,temp;
	for(j=start;j<end;j++){
		if(arr[j]<pivot){
			// incrementint the lower pointer
			i+=1;
			// swapping the ith and jth position
			temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
				 }
		}
	//Exchanging the pivot element and the i+1th(just after the lower element than the pivot) position after loop condition
	temp=arr[i+1];
	arr[i+1]=arr[end];
	arr[end]=temp;


	return i+1;
}

void quickSort(int arr[],int start,int end){
	if(start<end){
		int alpha=partition(arr,start,end);
		//breaking about alpha dividing array into two parts
		quickSort( arr,start,alpha-1);
		quickSort( arr,alpha+1,end);


}
}


void printArray(int arr[],int size){
	int i;
	for(i=0;i<size;i++){
		printf("%d-->",arr[i]);
		}
	printf("\n");
}


int main(){
	int arr[]={9,-3,5,2,6,8,-6,1,3};
	int size= sizeof(arr)/sizeof(arr[0]);
	printArray(arr,size);
	quickSort(arr,0,size-1);
	printArray(arr,size);
	getch();
	return 1;

}