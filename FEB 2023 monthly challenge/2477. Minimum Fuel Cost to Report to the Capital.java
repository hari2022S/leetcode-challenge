class Solution {
    // tc = o(n) sc = o(n)
    long fuel ;
    private long dfs(List<List<Integer>> graph, int city, int prevCity, int seats) {
        long rider = 1;
        for (int nextCity: graph.get(city)) {
            if (prevCity != nextCity) {
                rider += dfs(graph, nextCity, city, seats);
            }
        }
        if (city != 0) {
            fuel += (rider + seats - 1)/seats; // Math.ceil(rider/seats)
        }
        return rider;
    }
    public long minimumFuelCost(int[][] roads, int seats) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= roads.length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e: roads) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        fuel = 0;
        dfs (graph, 0, -1, seats);
        return fuel;
    } 
}
