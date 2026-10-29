
class SQL {
    private Map<String, Integer> cols;
    private Map<String, Map<Integer, List<String>>> rows;
    private Map<String, Integer> nxt;

    public SQL(List<String> names, List<Integer> columns) {
        cols = new HashMap<>();
        rows = new HashMap<>();
        nxt = new HashMap<>();
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            cols.put(name, columns.get(i));
            rows.put(name, new HashMap<>());
            nxt.put(name, 1);
        }
    }
    
    public boolean ins(String name, List<String> row) {
        if (!cols.containsKey(name) || row.size() != cols.get(name)) {
            return false;
        }
        int id = nxt.get(name);
        nxt.put(name, id + 1);
        rows.get(name).put(id, row);
        return true;
    }
    
    public void rmv(String name, int rowId) {
        if (rows.containsKey(name)) {
            rows.get(name).remove(rowId);
        }
    }
    
    public String sel(String name, int rowId, int columnId) {
        Map<Integer, List<String>> table = rows.get(name);
        if (table == null) {
            return "<null>";
        }
        List<String> row = table.get(rowId);
        if (row == null || columnId < 1 || columnId > row.size()) {
            return "<null>";
        }
        return row.get(columnId - 1);
    }
    
    public List<String> exp(String name) {
        Map<Integer, List<String>> table = rows.get(name);
        if (table == null) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        List<Integer> sortedIds = new ArrayList<>(table.keySet());
        Collections.sort(sortedIds);
        for (int id : sortedIds) {
            StringBuilder sb = new StringBuilder();
            sb.append(id);
            for (String cell : table.get(id)) {
                sb.append(",").append(cell);
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}