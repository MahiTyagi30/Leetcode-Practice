class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
          ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        int numOfPrerequisites = prerequisites.length;

        // Add edges to the graph based on prerequisites
        for (int i = 0; i < numOfPrerequisites; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];
            adjacencyList.get(prerequisite).add(course);
        }

        // Perform Topological Sort

        // Initialize an array to store the in-degree of each course
        int[] inDegree = new int[numCourses];

        // Calculate in-degree for each course
        for (int i = 0; i < numCourses; i++) {
            for (int neighbor : adjacencyList.get(i)) {
                inDegree[neighbor]++;
            }
        }

        // Use a queue to store nodes with in-degree 0 (no prerequisites)
        Queue<Integer> queue = new LinkedList<>();

        // Add courses with in-degree 0 to the queue
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Initialize an array to store the topological order of courses
        int[] topologicalOrder = new int[numCourses];
        int index = 0;

        // Perform BFS to find the topological order
        while (!queue.isEmpty()) {
            int course = queue.peek();
            queue.remove();
            topologicalOrder[index++] = course;

            // Decrease in-degree of neighbors and add them to the queue if their in-degree becomes 0
            for (int neighbor : adjacencyList.get(course)) {
                inDegree[neighbor]--;

                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // If all courses are included in the topological order, return the order array
        if (index == numCourses) {
            return topologicalOrder;
        }

        // If there is a cycle in the graph (not all courses are included), return an empty array
        int[] emptyArray = {};
        return emptyArray;
        
        
    }
}