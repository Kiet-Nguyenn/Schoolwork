#pragma once

#include <unordered_map>

#include "weighted-graph.hpp"
#include "graph-types.h"

template <typename T>
void computeIndegrees(const WeightedGraph<T>& graph, std::unordered_map<value_type<T>, int>& indegrees) {
    // TODO store the indegree for each vertex in the graph in the indegrees map

    /*
    n is the number of vertices
    m is the average number of edges in each adjacency list

    for vertex in graph:
        indegree[vertex] = 0

    for adj_list in graph:
        for vertex in adj_list:
            indegree[vertex] += 1
    */
}
