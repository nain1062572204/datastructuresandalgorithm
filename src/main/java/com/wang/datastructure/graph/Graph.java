package com.wang.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {
    /**
     * 顶点类
     */
    private static class Vertex<T> {
        List<Edge<T>> edges = new ArrayList<>();
        Boolean visited = false;

        void add(Edge e) {
            edges.add(e);
        }

    }

    /**
     * 边
     */
    private static class Edge<T> {
        //顶点
        Vertex<T> vertex;
        //权值
        Double weight;

        public Edge(Vertex<T> vertex, Double weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}
