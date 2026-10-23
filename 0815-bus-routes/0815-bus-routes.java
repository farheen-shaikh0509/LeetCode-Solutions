import java.util.*;

class Solution {
public int numBusesToDestination(int[][] routes, int source, int target) {
if (source == target) {
return 0;
}

    Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();
    for (int i = 0; i < routes.length; i++) {
        for (int stop : routes[i]) {
            stopToRoutes.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
        }
    }
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> visitedStops = new HashSet<>();
    Set<Integer> visitedRoutes = new HashSet<>();
    queue.offer(source);
    visitedStops.add(source);
    int buses = 0;
    while (!queue.isEmpty()) {
        int size = queue.size();
        buses++;
        for (int i = 0; i < size; i++) {
            int stop = queue.poll();
            for (int route : stopToRoutes.getOrDefault(stop, Collections.emptyList())) {
                if (!visitedRoutes.add(route)) {
                    continue;
                }
                for (int nextStop : routes[route]) {
                    if (nextStop == target) {
                        return buses;
                    }
                    if (visitedStops.add(nextStop)) {
                        queue.offer(nextStop);
                    }
                }
            }
        }
    }
    return -1;
}

}