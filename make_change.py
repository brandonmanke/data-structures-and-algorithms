import math
import sys

memo = {0: 0}
# top down
def make_change(n: int, coins: list) -> int:
    if n == 0: return 0
    if n in memo:
        #print(n, 'in memo, val:', memo[n])
        return memo[n]

    minimum = sys.maxsize

    for coin in coins:
        if coin <= n:
            result = make_change(n - coin, coins)
            if result != sys.maxsize and (result + 1) < minimum:
                minimum = result + 1
                memo[n] = minimum

    return minimum


# bottom up - not checking for overflow lol idc
def make_change2(n: int, coins: list) -> int:
    mem = [(sys.maxsize - 1) for i in range(n + 1)]
    mem[0] = 0

    for i in range(1, n + 1):
        for coin in coins:
            if coin > i: continue # skip
            mem[i] = min(mem[i - coin] + 1, mem[i])
    
    return mem[n]

def count_change(n: int, coins: list) -> int:
    mem = [0 for i in range(n + 1)]
    mem[0] = 1

    for i in range(0, len(coins)):
        j = coins[i]
        while j <= n:
            mem[j] += mem[j - coins[i]]
            j += 1

    return mem[n]

if __name__ == '__main__':
    change = 126
    coins = [1,2,5,6,9]
    print('make change for:', change, 'w/', coins)
    print('min #:', make_change(change, coins))
    print('bottom up min#: ', make_change2(change, coins))

    print('count change:', count_change(change, coins))
