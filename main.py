import random

class RandomMap:
    @staticmethod
    def generate_random_map(n, m):
        if n <= 0 or m <= 0:
            return None
        rand = random.Random()
        map = {}
        for i in range(n):
            key = "liste_"+ str(rand.randint(0, n))
            list = []
            for j in range(m):
                list.append(rand.random())
            map[key] = list
        return map

class MaxValue:
    @staticmethod
    def find_max_values(map):
        max_value = float('-inf')
        for key, values in map.items():
            if values:
                for value in values:
                    if value > max_value:
                        max_value = value
        return max_value

class MinValue:
    @staticmethod
    def find_min_values(map):
        min_value = float('inf')
        for key, values in map.items():
            if values:
                for value in values:
                    if value < min_value:
                        min_value = value
        return min_value


import math

class StandardDeviation:
    @staticmethod
    def find_standard_deviation_values(map):
        if not map:
            return None
        count = 0
        sum_values = 0
        for key, values in map.items():
            if values:
                for value in values:
                    sum_values += value
                    count += 1
        if count == 0:
            return None
        mean = sum_values / count
        temp = 0
        for key, values in map.items():
            if values:
                for value in values:
                    temp += (mean - value) ** 2
        return math.sqrt(temp / (count - 1))

class MeanValue:
    @staticmethod
    def find_mean_values(map):
        count = 0
        sum_values = 0
        for key, values in map.items():
            if values:
                for value in values:
                    sum_values += value
                    count += 1
        if count == 0:
            return None
        return sum_values / count
class Main:
    def main(args):
        print("Hello world!")

        random_map = RandomMap.generate_random_map(10001, 20)
        print(random_map)

        max_value = MaxValue.find_max_values(random_map)
        print(max_value)

        min_value = MinValue.find_min_values(random_map)
        print(min_value)

        mean_value = MeanValue.find_mean_values(random_map)
        print(mean_value)

        standard_deviation = StandardDeviation.find_standard_deviation_values(random_map)
        print(standard_deviation)

if __name__ == "__main__":
    Main.main(None)