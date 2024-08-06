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
    stalls.sort((a, b) => a - b);
    let low = 1, high = stalls[stalls.length - 1] - stalls[0];
    let ans = 0;
    // Initialize answer variable

    // Binary search
    while (low <= high) {
        // Calculate mid 
        let mid = Math.floor((low + high) / 2);
        if (canWePlace(stalls, mid, k)) {
            // Update answer
            ans = mid;
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }

    return ans;
}


const stalls = [1, 2, 4, 8, 9];
const k = 3;
const ans = aggressiveCows(stalls, k);
console.log(`The maximum possible minimum distance using
  binary search algo is ${ans}`);
