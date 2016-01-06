
public class BinarySearch {


   public static int search(int needle, int[] haystack) {
      int low = 0;
      int high = haystack.length - 1;
      
      while (low <= high) {
         int mid = low + (high - low)/2;
         
         if (needle < haystack[mid]) {
            high = mid - 1;
         } 
         else if (needle > haystack[mid]) {
            low  = mid + 1;
         } 
         else {
            return mid;
         }
         
      }
      
      return -1;
   }

   public static void main(String[] args) {
      int[] list = { 1, 3, 12, 19, 22, 34, 44, 47, 52, 58, 66, 70, 80, 84, 90};

      System.out.println(BinarySearch.search(34, list));
   }
}