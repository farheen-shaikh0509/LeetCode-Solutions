class TrieNode {
    constructor() {
        this.children = new Map();
        this.counts = new Map();
    }
}

/**
 * @param {string[]} sentences
 * @param {number[]} times
 */
var AutocompleteSystem = function(sentences, times) {
    this.root = new TrieNode();
    this.currentPrefix = "";
        for (let i = 0; i < sentences.length; i++) {
        this.addSentence(sentences[i], times[i]);
    }
};

AutocompleteSystem.prototype.addSentence = function(sentence, count) {
    let curr = this.root;
    for (let i = 0; i < sentence.length; i++) {
        let char = sentence[i];
        if (!curr.children.has(char)) {
            curr.children.set(char, new TrieNode());
        }
        curr = curr.children.get(char);
        curr.counts.set(sentence, (curr.counts.get(sentence) || 0) + count);
    }
};

/** 
 * @param {character} c
 * @return {string[]}
 */
AutocompleteSystem.prototype.input = function(c) {
    if (c === '#') {
        this.addSentence(this.currentPrefix, 1);
        this.currentPrefix = "";
        return [];
    }
    
    this.currentPrefix += c;
    let curr = this.root;
        for (let i = 0; i < this.currentPrefix.length; i++) {
        let char = this.currentPrefix[i];
        if (!curr.children.has(char)) {
            return []; 
        }
        curr = curr.children.get(char);
    }
        let list = [];
    for (let [sentence, count] of curr.counts.entries()) {
        list.push({ sentence, count });
    }
    
    // Sort by frequency (descending), then lexicographically (ascending)
    list.sort((a, b) => {
        if (a.count !== b.count) {
            return b.count - a.count;
        }
        return a.sentence.localeCompare(b.sentence);
    });
    
    // Extract the top 3 sentences
    let result = [];
    for (let i = 0; i < Math.min(3, list.length); i++) {
        result.push(list[i].sentence);
    }
    
    return result;
};