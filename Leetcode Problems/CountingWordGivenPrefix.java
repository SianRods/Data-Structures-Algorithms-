// Problem Number 2815 : Given an array of String Containing words count the number of words having the given prefix 
public class CountingWordGivenPrefix {
    public static void main(String[] args) {
        
    }
    static int prefixCount(String words[],String pre){
        // O(n) --> Solution
        int count=0;
        for(int i=0;i<words.length;i++){  
            if(words[i].startsWith(pre)){
                count++;
            }

        }
        return count;
    }
}
        