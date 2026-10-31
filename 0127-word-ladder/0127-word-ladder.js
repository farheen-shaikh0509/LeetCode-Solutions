/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
    const wordSet = new Set(wordList);
    if (!wordSet.has(endWord)) {
        return 0;
    }
        const queue = [[beginWord, 1]];
    const visited = new Set([beginWord]);
    
    while (queue.length > 0) {
        const [currWord, level] = queue.shift();
        
        if (currWord === endWord) {
            return level;
        }
        
        for (let i = 0; i < currWord.length; i++) {
            for (let c = 97; c <= 122; c++) { 
                const charCode = String.fromCharCode(c);
                if (charCode === currWord[i]) continue;
                const nextWord = currWord.slice(0, i) + charCode + currWord.slice(i + 1);
                
                if (wordSet.has(nextWord) && !visited.has(nextWord)) {
                    visited.add(nextWord);
                    queue.push([nextWord, level + 1]);
                }
            }
        }
    }
    
    return 0;
};