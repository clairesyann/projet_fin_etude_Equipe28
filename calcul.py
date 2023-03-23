#!/usr/bin/python3
# a mettre dans /usr/lib/cgi-bin
#from art import *
#Art=text2art("",font='block',chr_ignore=True)
#print('Content-Type: text/plain')
#print(Art)

import math
import json
import os

class Readfile:
    @staticmethod
    def read_map_from_file(filename):
        with open(filename, "r") as file:
            content = file.read()
            random_map = json.loads(content)
        return random_map

    def convert_to_json(resultats):
        return json.dumps(resultats)

    def write_results_to_file(resultats):
        directory = '/var/www/your_domain/'
        if not os.path.exists(directory):
            os.makedirs(directory)
        with open("calcul_result.txt", "w") as file:
            json.dump(resultats, file)
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
        random_map = Readfile.read_map_from_file("map.txt")

        max_value = MaxValue.find_max_values(random_map)
        #print(max_value)

        min_value = MinValue.find_min_values(random_map)
        #print(min_value)

        mean_value = MeanValue.find_mean_values(random_map)
        #print(mean_value)

        standard_deviation = StandardDeviation.find_standard_deviation_values(random_map)
        #print(standard_deviation)

        resultats = [max_value, min_value, mean_value, standard_deviation]
        print(resultats)
        json_data = Readfile.convert_to_json(resultats)
        print(json_data)

        Readfile.write_results_to_file(resultats)


if __name__ == "__main__":
    Main.main(None)