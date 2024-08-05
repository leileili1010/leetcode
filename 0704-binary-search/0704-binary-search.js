/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    let left = 0;
    let right = nums.length-1;

    while (left <= right) {
       let mid = Math.round((left + right) / 2);
       if (nums[mid] === target) {
            return mid;
       } else if (nums[mid] > target) {
           right = mid - 1;
       } else {
            left = mid + 1;
       }
    }
    
    return -1;
};