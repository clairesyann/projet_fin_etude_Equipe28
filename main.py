import random
import math

class RandomMap:
    @classmethod
    def generate_random_map(cls, n, m):
        if n <= 0 or m <= 0:
            return None
        rand = random.Random()
        map = {}
        for i in range(n):
            key = "liste_{}".format(rand.randint(0, n))
            lst = []
            for j in range(m):
                lst.append(rand.random())
            map[key] = lst
        return map

class MaxValue:
    @staticmethod
    def find_max_values(map):
        return max(val for vals in map.values() for val in vals)

class MinValue:
    @staticmethod
    def find_min_values(map):
        return min(val for vals in map.values() for val in vals)


class StandardDeviation:
    @staticmethod
    def find_standard_deviation_values(map):
        if not map:
            return None
        count = sum(len(vals) for vals in map.values())
        if count == 0:
            return None
        mean = MeanValue.find_mean_values(map)
        deviation_squared_sum = sum((val - mean) ** 2 for vals in map.values() for val in vals)
        return math.sqrt(deviation_squared_sum / (count - 1))

class MeanValue:
    @staticmethod
    def find_mean_values(map):
        count = sum(len(vals) for vals in map.values())
        if count == 0:
            return None
        return sum(val for vals in map.values() for val in vals) / count

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