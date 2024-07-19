"""
Runtime: 52 ms, faster than 95.31% of Python3 online submissions for N-Queens.
Memory Usage: 14.3 MB, less than 26.71% of Python3 online submissions for N-Queens.

Goal: Place a queen somewhere such that no queen are attacking each other
Approach: backtracking
- each recursive layer will decide on a row and also the placement of the queen
- the constraint is making sure we do not place a queen where its in sight of another queen. How?
    1) make sure it is not on the same column --> create a column set
    2) make sure it is not in same diagonal path --> create a diagonal set (calculated via r+c)
    3) make sure it is not in a antidiagonal path --> create a antidiagonal set (calculated via r-c)
    
    We dont need to worry about rows because it is handled by the backtracking parameter that always recurse
    to next level of the row
    
    ** note: if you dont know why r+c and r-c are diagonal paths --> Draw it out and check why it does!! 
    

"""

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        if n == 0: return []
        
        col = set()
        diagonal = set()    # determined by r+c
        antidiagonal = set() #
        output = []
        result = []
        
        def backtrack(r):
            nonlocal n,col,diagonal,antidiagonal,output,result
            if r == n:
                result.append(output[:])
                return
            
            for c in range(n):
                if c in col or (r+c) in diagonal or (r-c) in antidiagonal: continue
                
                col.add(c)
                diagonal.add(r+c)
                antidiagonal.add(r-c)
                output.append('.'*c + 'Q' + '.'*(n-c-1))
                backtrack(r+1)
                
                col.remove(c)
                diagonal.remove(r+c)
                antidiagonal.remove(r-c)
                output.pop()
        
        backtrack(0)
        return result
            
