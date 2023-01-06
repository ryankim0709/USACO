def solution():
    global n, m, r
    max_profit = 0
    p_sale = 0
    p_rent = 0
    p_cow = 0
    
    while p_cow < n: 
        milk_amt = capacities[p_cow]
        last = 0
        curr_profit = 0
        curr_shop = p_sale
        
        while curr_shop < m:
            milk_to_sell = min(milk_amt, sales[curr_shop][1])
            milk_amt -= milk_to_sell
            curr_profit += milk_to_sell * sales[curr_shop][0]
             
            if milk_amt == 0: 
                last = milk_to_sell
                break
            else:
                curr_shop += 1
                
        # check rental or sale is better
        if (p_rent == r or rentals[p_rent] < curr_profit):
            # sell here
            max_profit += curr_profit
            sales[curr_shop][1] -= last
            p_sale = curr_shop
            p_cow += 1
        else:
            # rent here
            max_profit += rentals[p_rent]
            p_rent += 1
            n -= 1

    return max_profit