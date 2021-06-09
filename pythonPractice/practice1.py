

from collections import Counter
def func1(a):
    mapa = Counter(a)
    return mapa
#print(func1("abc"))


import csv
mapa = {}
mapts = {}
mapcombine = {}
with open('/Users/teddy/Downloads/screen_share_interview_data.csv') as csvfile:
    reader =  csv.reader(csvfile, delimiter=',', quotechar='"')
    line_count = 0
    for row in reader:
        if line_count == 0:
            line_count += 1
            continue 
        #print(row[2])
        line_count += 1
        if mapa.get(row[2]) == None:
            mapa[row[2]] = [0,0,0]
            
        mapa[row[2]][0] += 1
        if row[3]:
            mapa[row[2]][1] += float(row[3]) 
        if row[4]:
            mapa[row[2]][2] += float(row[4])  

        #-----------------------------
        if mapts.get(row[1]) == None:
            mapts[row[1]] = 0
        mapts[row[1]] += 0 if not row[3] else float(row[3])
        mapts[row[1]] += 0 if not row[4] else float(row[4])

        #-----------------------------
        combinekey = (row[1], row[2])
        if mapcombine.get(combinekey) == None:
            mapcombine[combinekey] = 0
        mapcombine[combinekey] += (float(row[3]) * 8) if row[3] else 0


arr = []
for k,v in mapa.items():
    arr.append((-v[0],k,v[1],v[2]))
#arr.sort()

topn = len(arr)
#for i in range(topn):
    #print(arr[i])
        
arrts = []
for k,v in mapts.items():
    arrts.append((-v,k))
#arrts.sort()

topn = 3
#for i in range(topn):
#    print(arrts[i])

site = "twitter.com"
sumbitsAvg = 0
tsCount = 0
for k,v in mapcombine.items():
    if k[1] == site:
        sumbitsAvg += (v / 300)
        tsCount +=1

print(sumbitsAvg / tsCount)


