class Solution {
    class Node {
        String dest;
        double weight;
        public Node(String dest, double weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // construct graph using equations and values
        HashMap<String, ArrayList<Node>> graph = constructGraph(equations, values); // a/b=2.0 
        // a: [b, 2.0]
        // b: [a, 1/2.0]
        double[] result = new double[queries.size()];
        int index = 0;
        for (List<String> query : queries) {
            String src = query.get(0), dest = query.get(1);
            if (!graph.containsKey(src) || !graph.containsKey(dest)) {
                result[index++] = -1.0;
                continue;
            }
            // dfs algorithm
            HashSet<String> visited = new HashSet<>();
            double value = dfs(graph, src, dest, visited);
            result[index++] = value;
        }
        return result;
    }
    public HashMap<String, ArrayList<Node>> constructGraph(List<List<String>> equations, double[] values) {
        HashMap<String, ArrayList<Node>> graph = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            // a/b=2.0, b/a=1/2.0
            double weight = values[i];
            String src = equations.get(i).get(0), dest = equations.get(i).get(1);
            // check src -> dest
            if (graph.containsKey(src)) {
                graph.get(src).add(new Node(dest, weight));
            } else {
                ArrayList<Node> tmp = new ArrayList<>();
                tmp.add(new Node(dest, weight));
                graph.put(src, tmp);
            }
            // dest -> src
            if (graph.containsKey(dest)) {
                graph.get(dest).add(new Node(src, 1.0 / weight));
            } else {
                ArrayList<Node> tmp = new ArrayList<>();
                tmp.add(new Node(src, 1.0 / weight));
                graph.put(dest, tmp);
            }
        }
        return graph;
    }
    public double dfs(HashMap<String, ArrayList<Node>> graph, String src, String dest, HashSet<String> visited) {
        // base case
        if (src.equals(dest)) return 1;
        if (visited.contains(src)) return -1;
        visited.add(src);
        // recursive case
        for (Node adj : graph.get(src)) {
            String currNode = adj.dest;
            double weight = adj.weight;
            double result = dfs(graph, currNode, dest, visited);
            if (result != -1) return weight * result;
        }
        return -1;
    }
}
/*
TC: O(N * (V + E))
SC: O(V + E) */