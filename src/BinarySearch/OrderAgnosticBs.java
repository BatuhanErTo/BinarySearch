package BinarySearch;

public class OrderAgnosticBs {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int[] array2 = {74,52,12,5,6,1,-7};
        int ans = orderAgnosticBs(array,8);
        int ans2 = orderAgnosticBs(array2,52);
        System.out.println(ans);
        System.out.println(ans2);
    }
    static int orderAgnosticBs(int[] array, int target){
        int startPoint = 0;
        int endPoint = array.length-1;

        boolean isDesc = array[startPoint] > array[endPoint];

        while(startPoint <= endPoint){
            int midPoint = startPoint + (endPoint-startPoint)/2;

            if(array[midPoint] == target){
                return midPoint;
            }
            if(isDesc) {
                if(target<array[midPoint]){
                    startPoint = midPoint+1;
                }else{
                    endPoint = midPoint-1;
                }

            }else {
                if(target<array[midPoint]){
                    endPoint = midPoint-1;
                }else{
                    startPoint = midPoint+1;
                }
            }
        }
        return -1;
    }
}
