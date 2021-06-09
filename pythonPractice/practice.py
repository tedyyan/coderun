from heapq import heapify, heappop
from bisect import bisect_left
from functools import reduce

print("Hello world")

k = [2,112,3,4,59,21]
heapify(k)
while len(k)>0:
    print(heappop(k))

input = [2,3,5,1,-12,-4,6,-7,9]

input2 = sorted(input, key = lambda x: x*x)
print(input2)

print("1".isalpha())


seta = set()
seta.add(1)
seta.add(21)
seta.add(10)
seta.add(1)


print(seta)


# filter generate prime, yeild and primes
# 注意到Iterator是惰性计算的序列，所以我们可以用Python表示“全体自然数”，“全体素数”这样的序列，而代码非常简洁。
def _odd_iter():
    n = 1
    while True:
        n = n + 2
        print(n)
        yield n

def _not_divisible(n):
    return lambda x: x % n > 0

def primes():
    yield 2
    it = _odd_iter() # 初始序列
    while True:
        n = next(it) # 返回序列的第一个数
        yield n
        it = filter(_not_divisible(n), it) # 构造新序列

def printPrime():
    # 打印1000以内的素数:
    for n in primes():
        if n < 10:
            print(n)
        else:
            break

k = filter(lambda x:x>2, [1,4,9,10])
print(list(k))
print(next(k,None))

f = map(lambda x:x*2, [1,1,9,10])
print((set(f)))
y = reduce(lambda x,y:x*y, [1,1,9,10])
print(y)

mapa = {}
mapa.get("1",list()).append("21")
print(mapa)

a = [1,6,23,11,5]
heapify(a)
print(heappop(a))
print(heappop(a))

print(heappop(a))


a_list = [random.randint(1,10) for item in range(10)]
b_list = [random.randint(1,10) for item in range(10)]
print(a_list)
print(b_list)