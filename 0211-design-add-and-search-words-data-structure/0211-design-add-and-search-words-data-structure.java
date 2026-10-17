class WordDictionary {

    private static class TriedNode {
       TriedNode[] children = new TriedNode[26];
       boolean isEnd;

    }
    private final TriedNode root;

    public WordDictionary() {

        root = new TriedNode();

    }
    
    public void addWord(String word) {
        TriedNode node = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(node.children[index] == null){
                node.children[index] = new TriedNode();
            }
            node = node.children[index];


        }
        node.isEnd = true;

    }
    
   public boolean search(String word) {

        return dfs(word, 0, root);

    }
    
    private boolean dfs(String word, int index, TriedNode node){
        if(node == null){
            return false;


        }
        if(index == word.length()){
            return node.isEnd;


        }
        char c = word.charAt(index);
      if (c == '.') {

            for (TriedNode child : node.children) {

                if (child != null && dfs(word, index + 1, child)) {

                    return true;
            }}

                    return false;

        }
                        return dfs(word, index + 1, node.children[c - 'a']);

    }}
    


 // addWord() - O(n), search()- O(L), 