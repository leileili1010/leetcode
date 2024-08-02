/**
 * @param {number[][]} image
 * @param {number} sr
 * @param {number} sc
 * @param {number} color
 * @return {number[][]}
 */
 var floodFill = function(image, sr, sc, color) {
    const m = image.length;
    const n = image[0].length;
    const initial = image[sr][sc];

    if (color === image[sr][sc]) {
      return image;
    }

    let que = [];
    que.push([sr, sc]); 
    
    while (que.length > 0) {
        console.log("que----------", que)
      let cur = que.shift();
      neighbors(cur[0], cur[1], m, n, image, que, initial);
      image[cur[0]][cur[1]] = color;
    }

    return image;
};

function neighbors(sr, sc, m, n, image, que, initial) {
    const directions = [[0, 1], [0, -1], [1, 0], [-1, 0]];
    
    for (let direction of directions) {
      let [row, col] = direction;
      let [newRow, newCol]= [sr+row, sc+col];
      let valid = newRow >= 0 && newRow < m && newCol >= 0 && newCol < n;
      
      if ( valid && image[newRow][newCol] === initial) {
        que.push([newRow, newCol] );
      }
  } 
}
