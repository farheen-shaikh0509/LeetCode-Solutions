class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, graph.length - 1, graph, path, result);
        return result;
    }
    private void dfs(int node, int target, int[][] graph,
                     List<Integer> path, List<List<Integer>> result) {
        path.add(node);
        if (node == target) {
            result.add(new ArrayList<>(path));
        } else {
            for (int neighbor : graph[node]) {
                dfs(neighbor, target, graph, path, result);
            }
        }
        path.remove(path.size() - 1);
    }
}