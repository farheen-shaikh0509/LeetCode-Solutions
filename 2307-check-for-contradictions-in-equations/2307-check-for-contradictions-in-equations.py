from typing import List

class Solution:
    def checkContradictions(self, equations: List[List[str]], values: List[float]) -> bool:
        str_to_int = {}
        for u, v in equations:
            if u not in str_to_int:
                str_to_int[u] = len(str_to_int)
            if v not in str_to_int:
                str_to_int[v] = len(str_to_int)
        graph = [[] for _ in range(len(str_to_int))]
        for (A, B), val in zip(equations, values):
            u = str_to_int[A]
            v = str_to_int[B]
            graph[u].append((v, val))
            graph[v].append((u, 1.0 / val))
            
        seen = {}
        
        def dfs(u: int, val: float) -> bool:
            if u in seen:
                return abs(val / seen[u] - 1.0) > 1e-5
            seen[u] = val
            for v, w in graph[u]:
                if dfs(v, val / w):
                    return True 
            return False

        for i in range(len(graph)):
            if i not in seen:
                if dfs(i, 1.0):
                    return True
                    
        return False