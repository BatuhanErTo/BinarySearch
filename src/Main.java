public class Main {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int ans = binarySearch(array,8);
        System.out.println(ans);
    }
    static int binarySearch(int[] array, int target){
        int startPoint = 0;
        int endPoint = array.length-1;

        while(startPoint <= endPoint){
            int midPoint = startPoint + (endPoint-startPoint)/2;
            if(target<array[midPoint]){
                endPoint = midPoint-1;
            }else if(target>array[midPoint]){
                startPoint = midPoint+1;
            }else{
                return midPoint;
            }
        }
        return -1;
    }
}