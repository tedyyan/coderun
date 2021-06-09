from random import Random
from collections import OrderedDict
import random

t = Random()

print(t.randint(0,5))
print(t.randint(0,5))

k = [(1,2),(2,3),(1,2)]
#k.remove((1,2))
#k.pop(1)
print(k)

s = set(k)
#s.remove((2,3))

print(s)

od = OrderedDict()
od['A1'] = 11
od['B'] = 2
od['C'] = 3
od['A'] = 1
del od['A1']
od['A1'] = 11
for k,v in od.items():
    print(k,v)
print(od)


a_list = [t.randint(1,10) for item in range(10)]
b_list = [t.randint(1,10) for item in range(10)]
print(a_list)
print(b_list)

ret_list = []

for item in a_list:
    if item not in b_list:
        ret_list.append(item)


for item in b_list:
    if item not in a_list:
        ret_list.append(item)

print(ret_list)

setA = set([1,2,3])
setB = set([2,3,4])
print(setA^setB)
print(setA|setB)
print(setA&setB)
print(setA-setB)

print(random.randint(1,20))