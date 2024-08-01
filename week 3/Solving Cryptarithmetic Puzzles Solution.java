class Solution{
static boolean exhaustiveSolve(Puzzle puzzle, String lettersToAssign) {
    if (lettersToAssign.isEmpty()) // no more choices to make
        return puzzleSolved(puzzle); // checks arithmetic to see if works
    for (int digit = 0; digit <= 9; digit++) // try all digits
    {
        if (assignLetterToDigit(lettersToAssign.charAt(0), digit)) {
            if (exhaustiveSolve(puzzle, lettersToAssign.substring(1)))
                return true;
            unassignLetterFromDigit(lettersToAssign.charAt(0), digit);
        }
}
    return false; // nothing worked, need to backtrack
}
}
