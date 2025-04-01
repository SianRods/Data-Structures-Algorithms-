package PracticeProblems_intern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

 public class SellStocks {

    public static void main(String[] args) {
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println("The Sorted Indices are as follows : "+sortedIndices(prices));

    }

    static List<Integer> sortedIndices(int prices[]) {

 
    List<Integer> indices = new ArrayList<>();

    for(int i=0;i<prices.length;i++){
        indices.add(i) ;   }
    
  


    Comparator<Integer> comIndices = new Comparator<Integer>() {
        @Override
        public int compare(Integer i ,Integer j){
            if(prices[i]>prices[j]){
                return 1;
            }else{
                return -1;
            }
        }
    };

    Collections.sort(indices, comIndices);
    
    return indices;
        

    }



    static int getMaxProfit(List<Integer> ls, int prices []){
        int i=0;
        int j=ls.size()-1;

        while(ls.get(i)>ls.get(j)){
            j--;
        }

        if(i==j){
            return 0;
        }

        else{
            return (prices[j]-prices[i]);
        }

    }

}
