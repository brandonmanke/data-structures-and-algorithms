import random

# this is good to see some of the inital mistakes I made
# essentially we need not only a row of all 0's but a col of all 0's as well
# for the first row and col. (i.e. if weight is 0 or item is 0: table[weight][item] = 0)
# items is 0 (assuming item indices start at 1) this is where I messed up.
# Ended up making a messier hack of a solution because I didn't have a 0 col initialized
def knapsack(max_weight: int, itemWts: list, itemVals: list) -> None:
    table = { i:([-1] * len(itemWts)) for i in range((max_weight + 1)) }
    for i in range(len(itemWts)):
        table[0][i] = 0

    print('init table', table)

    #weight = row = j
    #num_items = col = i
    for weight in table:
        if weight == 0: continue
        items_used = set()
        for item_number in range(0, len(table[weight])):
            if item_number - 1 < 0: # no prev items available
                # sadly assumes that 0th item can be used at curr weight
                table[weight][item_number] = itemVals[0]
                continue
            if weight < itemWts[item_number]:
                table[weight][item_number] = table[weight][item_number - 1]
            else:
                # new_bag_val = this items val + the prev item(s) vals 
                # (available after updated weight)
                new_weight = weight - itemWts[item_number]
                items_used.add(item_number)
                if new_weight < 0:
                    new_weight = 0
                
                new_bag_val = itemVals[item_number] + table[new_weight][item_number - 1]
                table[weight][item_number] = max(table[weight][item_number - 1], new_bag_val)                
            
    print('after table', table)

if __name__ == '__main__':
    #itemWts = [random.randint(1, 5) for i in range(5)]
    #itemVals = [random.randint(1, 5) for i in range(5)]
    itemWts = [1,3,4,5]
    itemVals = [1,4,5,7]
    max_weight = 7
    print('0/1 Knapsack Problem')
    print('item weights:', itemWts)
    print('item vals:', itemVals)
    knapsack(max_weight, itemWts, itemVals)