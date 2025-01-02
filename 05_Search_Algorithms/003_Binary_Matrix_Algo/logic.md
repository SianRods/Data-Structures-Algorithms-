# How to apporach the algorithm 
1. Trying to reduce the search space of our problems using the fact that elements are in sorted order 
2. Approaching the matrix problem in a similar way as compared to that of normal 1-D binary search
3. Deciding the upper and lower bounds is very important
4. Also deciding the end condition becomes important 


## Row and Column wise Sorted Matirx 
1.  Lower bound is starting element of the oth row and then changed 
2. Upper Bound is the End coloumn element of the given array 
3. Comparisons will be made as per the upper bound and lower bound and we will be columns in the search space will be decremented 
4. Time Complexity --> O(2n) --> O(n)