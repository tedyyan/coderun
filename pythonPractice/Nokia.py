print("Hello world!")

#      10
#    /    \
#   6      14
#  / \    /  \
# 4   8  12  16

#      10
#    /    \
#   6      14
#  / \     /  \
# 4   18  12  16
 

class Node:
    def __init__(self,val = 0):
        self.left = None
        self.right = None
        self.val = val

 



    #maxvalue of left
    #minvalue of right

#pre visited tree put result into array, 

#get previous by pre visited, cur > previous 

#     5
#   4    6

#     5
#  10    12

previous = None
def dfs(node): #5 10
    global previous
    if node == None:
        return True;
    
    if not dfs(node.left): #5=>10 
        return False
    if previous != None and node.val < previous: #4  5 
        return False
    previous = node.val  # 10
    print(previous)
    if not dfs(node.right): 
        return False
    return True

head = Node(5)
head.left = Node(3)
head.left.left = Node(2)

print(dfs(head))

