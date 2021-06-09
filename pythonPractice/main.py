
from collections import defaultdict 
from copy import deepcopy
goods = [{"name":"productA","cnt":"1"},
         {"name":"p2","cnt":"3"},
         {"name":"p2","cnt":"-2"}]

def filter1(x):
    pass

def main():
    mapa = {}
    for g in goods:
        if mapa.get(g["name"]) != None:
            if mapa.get(g["name"]).get("cnt") > g.get("cnt"):
                mapa.get(g["name"])["cnt"] = g["cnt"]
        else:
            cp = deepcopy(g)
            cp["cnt"] = g.get("cnt")
            mapa[cp["name"]] = cp
    #print(sorted(goods, key= lambda x:(x["name"],x["cnt"])))

    print(list(filter(lambda x:x["name"] == "p2",goods)))
    k = mapa.get("p2",0)
    print(k)
        

    print("Hello World!")
    
def sumAtLeastK(arr,target):
    ans = float("inf")
    for i, val in enumerate(arr):
        if val >= target:
            return 1
        suma = val
        for j in range(i+1,len(arr)):
            suma += arr[j]
            if suma >= target:
                ans = min(ans, j-i + 1)
    return ans if ans != float("inf") else -1

if __name__ == "__main__":
    #main()
    arr = [1,2,3,4]
    target = 3
    #print(sumAtLeastK(arr,target))
    arr = [1,2,3,4]
    target = 12
    #print(sumAtLeastK(arr,target))

    mapa = {}
    #mapa.get(1,list()).append('a')
    if mapa.get(1)==None:
        mapa[1] = list()
    mapa[1].append('a')
    print(mapa)