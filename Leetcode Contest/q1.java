int cEven = 0;
        int cOdd = 0;
        int validPairs = 0;
        int i = 0;

        while (i < nums.length - 1) {
            // Increment by 2 as we are only considering the neighbouring pair 
            // Thus Each element being considered only once throughout as it is distinct
            if ((nums[i] % 2 == 0 && nums[i + 1] % 2 == 1) || (nums[i] % 2 == 1 && nums[i + 1] % 2 == 0)) {
                validPairs++;
            } else if (nums[i] % 2 == 0 && nums[i + 1] % 2 == 0) {
                cEven++;
            } else {
                cOdd++;
            }
            i ++;
        }

        if(cOdd==0 && cEven==0){
            return 0;
        }

        if(cEven>=cOdd){
            return cEven-cOdd+validPairs;
        }else{
            return cOdd-cEven+validPairs;
        }
