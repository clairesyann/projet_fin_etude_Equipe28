#!/usr/bin/python3
# a mettre dans /usr/lib/cgi-bin
#from art import *
#Art=text2art("",font='block',chr_ignore=True)
#print('Content-Type: text/plain')
#print(Art)

import random
import json
import os


class RandomMap:
    @classmethod
    def generate_random_map(cls, n, m):
        if n <= 0 or 0 >= m:
            return None
        rand = random.Random()
        random.seed(n + m)
        map = {}
        for i in range(n):
            key = "liste_{}".format(rand.randint(0, n))
            lst = []
            for j in range(m):
                lst.append(rand.random())
            map[key] = lst
        return map

    def convert_to_json(random_map):
        return json.dumps(random_map)

    def write_map_to_file(random_map):
        directory = '/var/www/your_domain/'
        if not os.path.exists(directory):
            os.makedirs(directory)
        with open("map.txt", "w") as file:
            json.dump(random_map, file)


class Main:
    def main(args):
        n = random.randint(1, 10000)
        m = random.randint(1, 100)
        random_map = RandomMap.generate_random_map(n, m)

        json_data = RandomMap.convert_to_json(random_map)
        print(json_data)

        RandomMap.write_map_to_file(random_map)


if __name__ == "__main__":
    Main.main(None)
