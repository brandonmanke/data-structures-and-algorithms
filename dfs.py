def dfs(start, adj):
    parent = {start: None}
    visited = set()
    visited.add(start)
    stack = []
    stack.append(start)
    print('start at:', start)
    while len(stack) != 0:
        curr = stack[-1]
        stack.pop()
        if curr not in visited:
            visited.add(curr)
            print('visited:', curr, 'from:', parent[curr])
        
        for v in adj[curr]:
            if v not in visited:
                parent[v] = curr
                stack.append(v)
        
if __name__ == '__main__':
    graph = {
        'a': {'b': True, 'e': True, 'f': True},
        'b': {'d': True, 'a': True},
        'c': {'d': True, 'f': True},
        'd': {'c': True, 'b': True, 'g': True},
        'e': {'c': True, 'a': True},
        'f': {'e': True, 'a': True, 'c': True},
        'g': {'d': True}
    }
    dfs('a', graph)