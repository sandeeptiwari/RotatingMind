### Graph:

Tree has no cycle, where graph may have cycle
- Every tree is a special graph which doesn't has cycle
- Node and edges form graph
- geographical Map is graph
-  city1 ----- city2
      \        /
         city2
- The edges are undirected know as Undirected Graph (node1 --- Node2) bi-direction in nature
- If there is direction from node to other node A ----> B
- A------->B
   <------

Mean undirected graph can represented using 2 directed graph

- Where edges and some extra attributes(like small/greater) know as wighted graph
- Completed Graph: every node is directly connected with every other node
  no of node in graph = N
  out of N if I select any 2 nodes, They would have an edge so number of edges = nC2 = n * (n-2) / 2
- 
## Directed Complete Graph :
   no of edges = 2 * NC2

### Adjacent/ Neighbours: 
    A------B

### reachable Node:
  If there ia a path(sequences of edges) between node then Node is reachable
  
### Disconnected Nodes:


### Self loop

    1---->2---
              |
           2<---
connected with themself


### Cycle in a graph:

If I am able to reach back to source node from any other node means there is cycle.

  A---2
  |    |
  C--- B
Here you can see source A and we can come back from C

### Bipartite Graph:

Graph can be colored using ONLY 2 colos such that no 2 adjacent node have same color:

e.g.
c1   c2
A---2
|    |
C--- B c1
c2

all node has diff colored
c1     c2
1 ----> 2
         \
          3 c1
         /
5-----4 c2

No color left for node 5, So its non Bipartite Graph