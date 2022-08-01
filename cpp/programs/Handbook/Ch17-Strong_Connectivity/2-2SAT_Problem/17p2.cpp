#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Graph {
    int N;
    unordered_map<string, vector<string>> adjList;
    unordered_map<string, vector<string>> reversedAdjList;
    set<string> allNodes;

    set<string> visited;
    int currTime = 0;
    set<pair<int, string>> dfsList;

    vector<unordered_set<string>> scc;
    unordered_set<string> currScc;

public:
    Graph(int N) {
        this->N = N;
    }

    void addEdge(string a, string b) {
        string nota = findNot(a);
        string notb = findNot(b);

        allNodes.insert(nota);
        allNodes.insert(notb);
        allNodes.insert(a);
        allNodes.insert(b);

        adjList[nota].push_back(b);
        adjList[notb].push_back(a);

        reversedAdjList[b].push_back(nota);
        reversedAdjList[a].push_back(notb);
    }

    string findNot(string a) {
        if (a.at(0) == *"~")
        {
            return a.substr(1, a.length());
        } else {
            return "~" + a;
        }
    }

    void expressAdjList() {
        for(auto key:reversedAdjList) {
            cout << key.first << ": ";
            for(string val:key.second) {
                cout << val << " ";
            }
            cout << "\n";
        }
    }

    void dfs1(string curr) {
        visited.insert(curr);
        for(string i:adjList[curr]) {
            if(!visited.count(i)) {
                currTime++;
                dfs1(i);
            }
        }
        currTime++;
        dfsList.insert({-currTime, curr});
    }

    void dfs1Prep() {
        for(string i:allNodes) {
            if(!visited.count(i)) {
                currTime++;
                dfs1(i);
            }
        }
    }

    void dfs2(string start, string curr) {
        reversedAdjList[curr];
        for (string i : reversedAdjList[curr])
        {
            if(currScc.count(i)) {
                if(i == start) {
                    scc.push_back(currScc);
                    return;
                } else {
                    currScc.clear();
                    currScc.insert(start);
                    scc.push_back(currScc);
                    return;
                }
            } else {
                if(visited.count(i))
                    continue;
                currScc.insert(i);
                visited.insert(i);
                dfs2(start, i);
            }
        }

        if(curr == start && currScc.size() == 1) {
            scc.push_back(currScc);
        }
    }

    void dfs2Prep() {
        visited.clear();

        for (auto u : dfsList)
        {
            string node = u.second;
            if(!visited.count(node)) {
                currScc.clear();
                currScc.insert(node);
                visited.insert(node);
                dfs2(node, node);
            }
        }
    }

    void twoSatIsPossible() {
        dfs1Prep();
        dfs2Prep();

        for(auto u:scc) {
            for(string i:u) {
                string noti = findNot(i);
                if(u.count(noti)) {
                    cout << "Not possible to find a solution\n";
                    return;
                }
            }
        }
        cout << "Possbile to find a solution\n";
        return;
    }

    void expressAllScc() {
        for(auto u:scc) {
            for(string i:u) {
                cout << i << " ";
            }
            cout << "\n";
        }
    }
};

int main() {
    Graph twoSat(4);

    twoSat.addEdge("2", "~1");
    twoSat.addEdge("~1", "~2");
    twoSat.addEdge("1", "3");
    twoSat.addEdge("~2", "~3");
    twoSat.addEdge("1", "4");

    twoSat.expressAdjList();
    twoSat.twoSatIsPossible();
    twoSat.expressAllScc();

    Graph twoSatLTwo(3);
    twoSatLTwo.addEdge("1", "2");
    twoSatLTwo.addEdge("1", "~2");
    twoSatLTwo.addEdge("~1", "3");
    twoSatLTwo.addEdge("~1", "~3");

    twoSatLTwo.twoSatIsPossible();
    twoSatLTwo.expressAllScc();
}