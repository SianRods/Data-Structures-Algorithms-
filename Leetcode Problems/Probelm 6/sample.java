public class sample {
    public static void main(String args[]){
        int sampleArray[]={1,2,3,4};
        for(int i=0;i<resultArray(sampleArray).length;i++){
            System.out.println(resultArray(sampleArray)[i]);
        }
    }
    static int [] resultArray(int arr[]){
        int  arrr[]= new int[arr.length];  // In order to declare array with custome size
        for(int i=0,j=arr.length;i<arr.length;i++,j--){
            int product=1;
            if(i==j){
                continue;
            }else{
                product*=arr[j];
            }
            
        }
            return arrr;
    }

}
// int product=1;
// for(int j=0;j<arr.length;j++){
//     if(j==i){
//         continue;
//     }else{
//         product*=arr[j];
//     }
// }
// arrr[i]=product;
