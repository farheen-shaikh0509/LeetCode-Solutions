class Solution:
    def pacificAtlantic(self, heights):
        if not heights or not heights[0]:
            return []
        m, n = len(heights), len(heights[0])
        pacific = set()
        atlantic = set()
        def dfs(r, c, visited):
            visited.add((r, c))
            for dr, dc in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                nr, nc = r + dr, c + dc
                if (0 <= nr < m and
                    0 <= nc < n and
                    (nr, nc) not in visited and
                    heights[nr][nc] >= heights[r][c]):
                    dfs(nr, nc, visited)
        # Pacific Ocean: top and left boundaries
        for c in range(n):
            dfs(0, c, pacific)
        for r in range(m):
            dfs(r, 0, pacific)
        # Atlantic Ocean: bottom and right boundaries
        for c in range(n):
            dfs(m - 1, c, atlantic)
        for r in range(m):
            dfs(r, n - 1, atlantic)
        return [list(cell) for cell in pacific & atlantic]