import java.util.*;

class Graph1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertex");
        int n= sc.nextInt();
        System.out.println("Enter the number of edges");
        int e = sc.nextInt();
        Edge[] obj=new Edge[e];
        for (int i = 0; i <e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int weight = sc.nextInt();
            obj[i]=new Edge(v1,v2,weight);
        }

        Edge[] ans=kruskal(obj,n);
        for (Edge an : ans) {
            System.out.println(an.v1 + " " + an.v2 + "  " + an.weight);
        }
    }

    public static Edge[] kruskal(Edge[] edges, int v)
    {
        Arrays.sort(edges);
        Edge[] ans = new Edge[v-1];
        int flag=0;
        int i=0;
        int[] parent = new int[v];
        for (int j = 0; j <v ; j++) {
            parent[j] = j;
        }
        while(flag != v-1)
        {
            Edge curr = edges[i++];
            int v1 = find(curr.v1,parent);
            int v2 = find(curr.v2, parent);
            if(v1 != v2)
            {
                ans[flag]= curr;
                flag++;
                parent[v1]= v2;
            }

        }
        return ans;
    }

    private static int find(int v1, int[] parent) {
        if(v1 == parent[v1])
        {
            return v1;
        }
        return find(parent[v1],parent);
    }
}

class Edge implements  Comparable<Edge>
{
    int v1;
    int v2;
    int weight;

    public Edge(int v1, int v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight-o.weight;
    }
}
