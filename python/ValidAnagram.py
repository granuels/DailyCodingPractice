class Solution:
    def validAnagram(self, str1, str2):
        str1count={}

        for char in str1:
            if char in str1count:
                str1count[char]+=1
            else:
                str1count[char]=1

        for char in str2:
            if char not in str1count or str1count[char]==0:
                return False
            str1count[char]-=1
        return True

sol=Solution()
print(sol.validAnagram("aacc", "ccac"))