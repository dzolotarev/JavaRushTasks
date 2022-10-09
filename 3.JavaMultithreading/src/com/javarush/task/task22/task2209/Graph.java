package com.javarush.task.task22.task2209;

public class Graph {
    private int maxN = 10;
    private int[][] mas;
    Vertex[] vertexList;
    private int curN;

    public Graph(){
         vertexList = new Vertex[maxN];
         mas = new int[maxN][maxN];
         curN=0;
    }

    public void addVertex(String name){
        vertexList[curN++]=new Vertex(name);
    }

    public void addEdge(int start, int end, int val){
        mas[start][end]=1;
        mas[end][start]=val;

    }

}
