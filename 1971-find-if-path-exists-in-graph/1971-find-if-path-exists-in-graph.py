class Solution(object):
    def validPath(self, n, edges, source, destination):
 
        if source == destination:
            return True

        graph = [[] for _ in range(n)]

        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)

        visited = set()
        stack = [source]

        while stack:
            node = stack.pop()

            if node == destination:
                return True

            if node in visited:
                continue

            visited.add(node)

            for neighbor in graph[node]:
                if neighbor not in visited:
                    stack.append(neighbor)

        return False


# Time Complexity: O(V + E)
# Space Complexity: O(V + E)