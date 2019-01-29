package Algorithm.UsingArray.BinarySearch;

public class BinarySearch {

    private BinarySearch(){}

    public static int binarySearch(Comparable[] arr, int n, Comparable target){

        int l = 0, r = n-1;// 在[l...r]的范围里寻找target
        while(l <= r) {    // 当 l == r时,区间[l...r]依然是有效的
            int mid = l + (r-l)/2;
            if (target.compareTo(arr[mid]) == 0){
                return mid;
            }
            if (target.compareTo(arr[mid]) > 0){
                l = mid + 1;// target在[mid+1...r]中; [l...mid]一定没有target
            }else{
                r = mid - 1;// target在[l...mid-1]中; [mid...r]一定没有target
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int l, int r, int target){

        if(l < 0 || l > arr.length)
            throw new IllegalArgumentException("l is out of bound");

        if(r < 0 || r > arr.length)
            throw new IllegalArgumentException("r is out of bound");

        while(l <= r){
            int mid = l + (r - l)/2;
            if(arr[mid] == target)
                return mid;
            if(target > arr[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = (int)Math.pow(10, 7);
        Integer data[] = Util.generateOrderedArray(n);

        long startTime = System.currentTimeMillis();
        for(int i = 0 ; i < n ; i ++)
            if(i != binarySearch(data, n, i))
                throw new IllegalStateException("find i failed!");
        long endTime = System.currentTimeMillis();

        System.out.println("Binary Search test complete.");
        System.out.println("Time cost: " + (endTime - startTime) + " ms");
    }
}
