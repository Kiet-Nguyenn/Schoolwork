#pragma once

#include <optional>
#include <unordered_map>

#include "weighted-graph.hpp"
#include "graph-types.h"

// HINT when calling relax, you have to specify the template arugment.
// Therefore, relax(u, v, w, d, p) doesn't work.
// For example, you must say relax<int>(u, v, w, d, p).

template <typename T>
bool relax(value_type<T> u, value_type<T> v, weight_type<T> w,
std::unordered_map<value_type<T>, weight_type<T>>& distances,
std::unordered_map<value_type<T>, std::optional<value_type<T>>>& predecessors)
{
    // TODO relax the distance to v from u with weight w by changing the distances and predecessors maps as necessary

    /*
    u the node at the start of the edge
    v the node at the end of the edge
    w the weight of the edge from u to v
    distances the mapping of vertices to their distances from the source
    predecessors the mapping of vertices to their predecessors along the shortest path from the source
    if distance[v] > distance[u] + w:
        distance[v] = distance[u] + w
        predecessor[v] = u
        return True

    return False
    */
}

template <typename T>
weight_type<T> infinity() {
    return std::numeric_limits<weight_type<T>>::max();
}

template <typename T>
void initializeSingleSource(const WeightedGraph<T>& graph, vertex_type<T> initial_node,
std::unordered_map<value_type<T>, weight_type<T>>& distances,
std::unordered_map<value_type<T>, std::optional<value_type<T>>>& predecessors)
{
    for (auto it = graph.begin(); it != graph.end(); ++it) {
        const auto& vertex = it->first;
        distances[vertex] = infinity<T>();
        predecessors[vertex] = std::nullopt;
    }
    distances.at(initial_node) = 0;
}

template <typename T>
class DijkstraComparator {
    std::unordered_map<value_type<T>, weight_type<T>>& distances;
public:
    DijkstraComparator(std::unordered_map<value_type<T>, weight_type<T>>& distances) : distances{distances} {}
    bool operator()(const value_type<T>& a, const value_type<T>& b) {
        return distances.at(a) > distances.at(b);
    }
};

template <typename T>
void updateHeap(std::priority_queue<value_type<T>, std::vector<value_type<T>>, DijkstraComparator<T>>& q,
std::unordered_map<value_type<T>, weight_type<T>>& distances)
{
    std::make_heap(const_cast<value_type<T>*>(&q.top()),
            const_cast<value_type<T>*>(&q.top()) + q.size(),
            DijkstraComparator<T>{distances});
}
