class Solution:
    def groupAnagrams(self, strs):
        hm={}
        for word in strs:
            key="".join(sorted(word))
            if key in hm:
                hm[key].append(word)
            else:
                hm[key]=[word] 
        return list(hm.values())
    

sol= Solution()
print(sol.groupAnagrams(["eat", "ate", "ant", "tea", "bat", "tan"]))

