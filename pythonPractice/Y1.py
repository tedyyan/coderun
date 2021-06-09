from heapq import heapify, heappop
from bisect import bisect_left
from random import Random
from collections import OrderedDict
from collections import Counter
from collections import deque
from copy import deepcopy

s = "abc"
print(Counter(s))



dict1 =  ["abac","baac","ccca","accc"]

# search map
# {{"a2b1c1":["abac","baac"]},{"a1c3",:"ccca","accc"]}}


# m is the avg of differect charatcter in one word:  n * m * log(m)
# work length is m , sort mlog(m) total TC: n * m * log(m)

class anagramChecker:
    def hashcode(self,word):
        count = Counter(word) #
        hash = ""
        for key in sorted(count.keys()):
            hash += str(key) + str(count[key])
        return hash

    def __init__(self,dict):
        self.searchmap = {}
        # build searchmap
        for d in dict:
            self.addWord(d)
   
    def check(self,word):
        return self.searchmap.get(self.hashcode(word))

    def addWord(self,word):
        hash = self.hashcode(word)
        anagram = self.searchmap.get(hash)
        if anagram == None:
            self.searchmap[hash] = list()
            anagram = self.searchmap[hash]

        anagram.append(word)

    def removeWord(self,word):
        pass

checker = anagramChecker(dict1)
print(checker.check("aabc"))
print(checker.check("cca"))

