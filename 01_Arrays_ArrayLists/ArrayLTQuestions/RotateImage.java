package ArrayLTQuestions;

// The Concept is to Reverse Each row then swap it across the secodnary diagonal to obtain the 

// resultant 90 degrees rotation

class RotateImage {
    public static void main(String[] args) {
        int arr[][] = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }

        };
        display(arr);

        reverseArrayRows(arr);
        swapAlongSecondaryDiagnol(arr);

        display(arr);

        int NumOfRotations = 270;

        for (int i = 1; i <= 3; i++) {
            reverseArrayRows(arr);
            swapAlongSecondaryDiagnol(arr);
        }

        display(arr);

    }

    static void display(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println("\n");
        }
        System.out.println("\n");
    }

    static void swapAlongSecondaryDiagnol(int arr[][]) {
        // Swapping the Elements Along the Secodnary Diagonal
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                temp = arr[i][j];
                // Knowing and Setting the Bounds Properly is important
                // Else we will end up swapping twice the same thing
                // which will result in same anwser if it is done twice
                arr[i][j] = arr[arr.length - 1 - j][arr.length - 1 - i];
                arr[arr.length - 1 - j][arr.length - 1 - i] = temp;
            }
        }
    }

    static void horizontalFlip(int arr[][]) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length / 2; j++) {
                temp = arr[i][j];
                arr[i][j] = arr[i][arr.length - 1 - j];
                arr[i][arr.length - 1 - j] = temp;
            }
        }
    }


    static void verticalFlip(int arr[][]){
        
    }

    

}
