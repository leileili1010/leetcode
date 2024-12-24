##  Get Minimum Value

[New Grad][1]

[1]: https://www.fastprep.io/problems/amazon-get-minimum-value

```java
public int getMinimumValue(int[] power, int armor) {
  int sum = 0, max = -1;
  int res = 0;
  
  for (int num: power) {
     sum += num;
     Max = Math.max(max, num);
  }

  return sum+1-Math.min(armor, max);
}
```

## Get Max Skill Sum

[New Grad / Full-time][2]

[2]: https://www.fastprep.io/problems/amazon-get-max-skill-sum

```java
public static long getMaxSkillSum(int[] expertise, int[] skill) {
    int marketing = 0;
    for (int num: expertise) {
        if (num == 0) marketing++;
    }
    
    // find target number of employees
    int count = Math.min(marketing, expertise.length-marketing);
    if (count == 0) return 0;

    int left = 0;
    long curSkill = 0, maxSkill = 0;
    int dev = count, market = count;

    // two pointers to slide window
    for (int i = 0; i < expertise.length; i++) {
        if (expertise[i] == 0) market--;
        else dev--;

        curSkill += skill[i];

        // not valid yet
        while (i - left + 1 > 2 * count) {
            curSkill -= skill[left];
            if (expertise[left] == 0) market++;
            else dev++;
            left++;
        }

        // valid window
        if (i - left + 1 == 2 * count && market == 0 && dev == 0) {
            maxSkill = Math.max(maxSkill, curSkill);
        }
    }
    return maxSkill;
}
```

## Count Distinct Categories
[New Grad][3]

[3]: https://www.fastprep.io/problems/amazon-count-distinct-categories

### Approach 1 - Time O(N^2) but easy to understand 
```java
public static long countDistinctCategories(int[] categories) {
        int n = categories.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(categories[j]);
                res += set.size();
            }
        }
        return res;
    }
```

### Approach 2 - Time O(N) but hard to understand 

```java



```