public class Driver {


   public static void main(String[] args) {
      int[] list = { 1, 3, 12, 19, 22, 34, 44, 47, 52, 58, 66, 70, 80, 84, 90};
      
      BinarySearch s = new BinarySearch();
      
      System.out.println(s.search(34, list));
   }
}