class Solution:
    def topKFrequent(self, nums, k):
        # Step 1: Count the frequency of each number
        freq = {}

        for num in nums:
            freq[num] = freq.get(num, 0) + 1

        # Step 2: Create buckets indexed by frequency
        # Maximum possible frequency is len(nums)
        buckets = [[] for _ in range(len(nums) + 1)]

        # Step 3: Place each number into its frequency bucket
        for num, count in freq.items():
            buckets[count].append(num)

        # Step 4: Collect the k most frequent elements
        result = []

        # Traverse buckets from highest frequency to lowest
        for count in range(len(buckets) - 1, 0, -1):
            for num in buckets[count]:
                result.append(num)

                # Return once we have k elements
                if len(result) == k:
                    return result

        return result