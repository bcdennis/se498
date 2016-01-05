
public class BinarySearch {
   int low = 0;
   int high = Integer.MAX_VALUE;

   public int search(int needle, int[] haystack) {
   
      high = haystack.length - 1;
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


}