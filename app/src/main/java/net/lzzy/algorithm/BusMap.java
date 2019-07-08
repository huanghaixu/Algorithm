package net.lzzy.algorithm;

import android.util.SparseArray;
import android.widget.Button;

import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzzy_gxy on 2019/7/8.
 * Description:
 */
public class BusMap extends SimpleMap {
    private SparseArray<String> vertexes;
    private double minDistance;
    private int start, target;

    public BusMap(int v) {
        super(v);
        vertexes = new SparseArray<>();
        for (int i = 0; i < v; i++) {
            vertexes.append(i, String.valueOf(i));
        }
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public void renTarget(int target) {
        this.target = target;
    }

    public void rename(int i, String name) {
        vertexes.setValueAt(i, name);
    }

    //todo
    private void tryWay(int curVertex, double distance) {
        if (minDistance > 0 && distance > minDistance) {
            return;
        }
        if (curVertex == target) {
            if (minDistance == 0 || minDistance > distance) {
                minDistance = distance;

            }
            return;
        }
        List<Edge> vEdges = getConnectedEdges(curVertex);
        for (Edge edge : vEdges)
    }

    {
        if (visited.contains(edges.getTarget())) {
            continue;
        }
        visited.add(edges.getTarget());
        tryWay(edges.getTarget(), distance + edge.getDistance());
        visited.remove(edge.getTarget());
    }

    //todo
    private double[][] floyd() {
        double[][] distances = new double[vertexCount][vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                distances[i][j] = 999999;
            }
        }
        for (Edge edge : edges) {
            distances[edge.getSource()][edge.getTarget()] = edge.getDistance();

        }
        for (int k = 0; k < vertexCount; k++) {
            for (int i = 0; i < vertexCount; i++) {
                for (int j = 0; j < vertexCount; j++) {
                    if (distances[i][j] > distances[i][k] + distances[k][j]) {
                        distances[i][j] = distances[i][k] + distances[k][j];
                    }
                }
            }
        }
        return distances;
    }

    //todo
    private double[] dijkstra(int source) {
        double[] distances = new double[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            distances[i] = 999999;
        }
        distances[source] = 0;
        List<Edge> vEdges = getConnectedEdges(source);
        for (Edge edge : vEdges) {
            distances[edge.getTarget()] = edge.getDistance();
        }
        visited.add(source);
        int shortVertex = source;
        for (int i = 1; i < vertexCount; i++) {
            double shortDistance = 999999;
            for (int j = 0; j < vertexCount; j++) {
                if (visited.contains(j) || distances[j] >= shortDistance) {
                    continue;
                }
                shortDistance = distances[j];
                shortVertex = j;
            }
            visited.add(shortVertex);
            List<Edge> shortVertexEdges = getConnectedEdges(shortVertex);
            for (Edge edge : shortVertexEdges) {
                if (distances[edge.getTarget()] > distances[shortVertex] + edge.getDistance()) {

                distances[edge.getTarget()] > distances[shortVertex] + edge.getDistance();
            }
        }

        }
        return  distances;
    }

    public String getDistance(int key) {
        visited = new ArrayList<>();
        switch (key) {
            case 0:
                tryWay(start, 0);
                break;
            case 1:
                minDistance = floyd()[start][target];
                break;
            case 2:
                minDistance = dijkstra()[start][target];
                break;
                default:
                    minDistance=0;
                    break;
        }
        return "从"+start+"到"+target+"的最短距离为"+minDistance;
    }

}
