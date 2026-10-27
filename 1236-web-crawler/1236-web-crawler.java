class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostname = getHostname(startUrl);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        queue.offer(startUrl);
        visited.add(startUrl);
        
        List<String> result = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            result.add(curr);
            
            for (String nextUrl : htmlParser.getUrls(curr)) {
                if (!visited.contains(nextUrl) && getHostname(nextUrl).equals(hostname)) {
                    visited.add(nextUrl);
                    queue.offer(nextUrl);
                }
            }
        }
        
        return result;
    }
    
    private String getHostname(String url) {
        int idx = url.indexOf("://");
        int nextSlash = url.indexOf('/', idx + 3);
        return nextSlash == -1 ? url : url.substring(0, nextSlash);
    }
}