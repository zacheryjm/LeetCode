class Solution {
    public int[][] kClosest(int[][] points, int K) {
        
        PointComparator comparable = new PointComparator();
        Queue<int []> maxHeap = new PriorityQueue<int []>(comparable);
        
        for(int i = 0; i < points.length; ++i) {
            maxHeap.add(points[i]);
            
            if(maxHeap.size() > K) {
                maxHeap.poll();
            } 
        }
        
        int [][] results = new int[K][];
        
        for(int j = 0; j < results.length; ++j) {
            results[j] = maxHeap.poll();
        }
        
        return results;
    }
    
    public class PointComparator implements Comparator<int []> {
      
        public int compare(int [] arr1, int [] arr2) {
            double sqrtArr1 = Math.sqrt(Math.pow(arr1[0],2) + Math.pow(arr1[1],2));
            double sqrtArr2 = Math.sqrt(Math.pow(arr2[0],2) + Math.pow(arr2[1],2));
            
            if(sqrtArr1 < sqrtArr2) return 1;
            else if(sqrtArr1 == sqrtArr2) return 0;
            else return -1;
        }
    }
    
}