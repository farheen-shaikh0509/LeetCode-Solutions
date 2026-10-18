class Solution:
    def findWords(self, board, words):
        trie = {}

        for word in words:
            node = trie
            for ch in word:
                if ch not in node:
                    node[ch] = {}
                node = node[ch]
            node["$"] = word

        rows, cols = len(board), len(board[0])
        result = []

        def dfs(r, c, parent):
            ch = board[r][c]

            if ch not in parent:
                return

            node = parent[ch]

            if "$" in node:
                result.append(node.pop("$"))

            board[r][c] = "#"

            if r > 0 and board[r - 1][c] != "#":
                dfs(r - 1, c, node)
            if r < rows - 1 and board[r + 1][c] != "#":
                dfs(r + 1, c, node)
            if c > 0 and board[r][c - 1] != "#":
                dfs(r, c - 1, node)
            if c < cols - 1 and board[r][c + 1] != "#":
                dfs(r, c + 1, node)

            board[r][c] = ch

            if not node:
                parent.pop(ch)

        for r in range(rows):
            for c in range(cols):
                dfs(r, c, trie)

        return result