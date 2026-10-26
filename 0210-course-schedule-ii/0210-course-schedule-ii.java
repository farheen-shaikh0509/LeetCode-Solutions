class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i =0; i < numCourses; i++){
            adjList.add(new ArrayList<>());


        }

        int[] inDegree = new int[numCourses];
        for( int[] p: prerequisites){
            int dest = p[0];
            int src = p[1];
            adjList.get(src).add(dest);
            inDegree[dest]++;

           
        }
    }
    Queue<Integer> queue = new LinkedList<>();
    for(int i =1; i < numCourses; i++){
        if (inDegree[i] == 0) {
                queue.offer(i);
            }


    }

    int[] order = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order[index++] = curr;
            
            for (int neighbor : adjList.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        if (index == numCourses) {
            return order;
        }
                return new int[0];
}