function canWePlace(stalls, dist, cows) {
    let cntCows = 1;
    let last = stalls[0];
    for (let i = 1; i < stalls.length; i++) {
        if (stalls[i] - last >= dist) {
            cntCows++;
            last = stalls[i];
        }
        if (cntCows >= cows) return true;
    }
    return false;
}

function aggressiveCows(stalls, k) {

    // first we will Sort the stalls
    stalls.sort((a, b) => a - b);
    const maxLimit = stalls[stalls.length - 1] - stalls[0];
    for (let i = 1; i <= maxLimit; i++) {
        if (!canWePlace(stalls, i, k)) {
            return i - 1;
        }
    }
    // else 
    return maxLimit;
}

const stalls = [1, 2, 4, 8, 9];
const k = 3;
const ans = aggressiveCows(stalls, k);
console.log(`The maximum possible minimum distance using
  binary search algo is ${ans}`);
