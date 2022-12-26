
def tstep(n, steps, memo):
    if n < 0: return 0
    if n == 0: return 1
    if n in memo: return memo[n]
    for s in steps:
        if n not in memo: memo[n] = 0
        memo[n] += tstep(n - s, steps, memo)
    return memo[n]

def tstep_bot(n, steps):
    if (n < 0): return 0
    memo = [1,2,4]
    for i in range(3, n + 1):
        memo[i % 3] = memo[0] + memo[1] + memo[2]

    return memo[(n - 1) % 3]

if __name__ == '__main__':
    memo = {}
    n = 12
    steps = [1,2,3]
    print('top down:', tstep(n, steps, memo))
    print('bot up:', tstep_bot(n, steps))