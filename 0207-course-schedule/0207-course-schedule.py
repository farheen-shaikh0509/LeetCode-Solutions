class Solution:
    def canFinish(self, numCourses, prerequisites):
        graph = [[] for _ in range(numCourses)]

        for course, prereq in prerequisites:
            graph[prereq].append(course)

        # 0 = unvisited, 1 = visiting, 2 = completed
        state = [0] * numCourses

        def dfs(course):
            if state[course] == 1:
                return False

            if state[course] == 2:
                return True

            state[course] = 1

            for next_course in graph[course]:
                if not dfs(next_course):
                    return False

            state[course] = 2
            return True

        for course in range(numCourses):
            if state[course] == 0:
                if not dfs(course):
                    return False

        return True