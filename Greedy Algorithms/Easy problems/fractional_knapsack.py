# Fractional Knapsack Problem
def fractional_knapsack(value, weight, capacity):
    n = len(value)
    
    # Calculate value/weight ratio
    ratio = []
    for i in range(n):
        ratio.append(value[i] / weight[i])
    
    # Sort items by ratio in descending order
    items = list(zip(value, weight, ratio))
    items.sort(key=lambda x: x[2], reverse=True)
    
    total_value = 0.0
    for v, w, r in items:
        if capacity >= w:
            # take the whole item
            capacity -= w
            total_value += v
        else:
            # take the fractional part
            total_value += r * capacity
            break
    return total_value


# Example
value = [60, 100, 120]
weight = [10, 20, 30]
capacity = 50

print("Maximum value (Fractional):", fractional_knapsack(value, weight, capacity))
