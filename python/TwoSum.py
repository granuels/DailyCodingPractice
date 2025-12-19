class Leetcode:
    def twoSum(self, numbers, target):
        hashmap={}
        for idx in range(len(numbers)):
            complement= target - numbers[idx]
            if complement in hashmap:
                return [idx, hashmap[complement]]
            
            hashmap[numbers[idx]]= idx 
        return[]
    
l=Leetcode()
print(l.twoSum([2,7,10,23], 9))

        
