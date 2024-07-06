class Solution:
    def countNumbersWithUniqueDigits(self, n: int) -> int:
        def generate_numbers_with_distinct_digits(max_digits):
            results = []
            def backtrack(path, used_digits):
                # if len(path) > 0 and int("".join(path)) <= m:
                if len(path) > 0:
                    results.append(int("".join(path)))
                if len(path) == max_digits:
                    return
                for digit in map(str, range(10)):
                    if digit in used_digits or (len(path) == 0 and digit == '0'):
                        continue
                    used_digits.add(digit)
                    backtrack(path + [digit], used_digits)
                    used_digits.remove(digit)
                return None

            backtrack([], set())
            return results

        # count = 0
        valid_numbers = generate_numbers_with_distinct_digits(n)
        # for number in valid_numbers:
        #     if number < 10^n:
        #         count += 1
        
        return len(valid_numbers)+1