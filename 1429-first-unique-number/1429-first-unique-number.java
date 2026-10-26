class FirstUnique {

    public FirstUnique(int[] nums) {
   private Map<Integer, Integer> countMap;
    private Queue<Integer> queue;
    }
    
    public int showFirstUnique() {
        countMap = new HashMap<>();
        queue = new LinkedList<>();
        for (int num : nums) {
            add(num);
        }
        
    }
    
    public void add(int value) {
        
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */