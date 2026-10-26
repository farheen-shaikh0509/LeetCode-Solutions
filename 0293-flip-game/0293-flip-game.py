class Solution:
    def generatePossibleNextMoves(self, currentState: str) -> list[str]:
        if not currentState or len(currentState) < 2:
            return []
        
        result = []
        for i in range(len(currentState) - 1):
            if currentState[i:i+2] == "++":
                result.append(currentState[:i] + "--" + currentState[i+2:])
        return result