class Solution:
    def validPalindrome(self, s):
        newStr= "".join(char for char in s if char.isalnum()).lower()
        startp=0
        endp=len(newStr)-1
        while startp<endp:
            if newStr[startp] != newStr[endp]:
                return False
            startp+=1
            endp-=1
        return True
    
sol= Solution()
print(sol.validPalindrome("A man, a plan, a canal: Panama"))