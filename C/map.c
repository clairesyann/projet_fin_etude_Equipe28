#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>


#define N 1000
#define M 500

typedef struct {
    double* values;
} List;

typedef struct {
    List* lists;
} Map;


Map* generate_random_map(int n, int m) {
    if (n <= 0 || m <= 0) {
        return NULL;
    }
    srand(n + m);
    Map* map = (Map*)malloc(sizeof(Map));
    map->lists = (List*)malloc(n * sizeof(List));

    for (int i = 0; i < n; i++) {
        char key[10];
        sprintf(key, "liste_%d", rand() % n);
        List* lst = (List*)malloc(sizeof(List));
        lst->values = (double*)malloc(m * sizeof(double));
        int first = 1;
        //srand(time(NULL));
        for (int j = 0; j < m; j++) {
            /*if (first == 1) {
              first=0;
              srand(time(NULL));
              lst->values[j] = (double)rand() / RAND_MAX;
            }
            else {
              lst->values[j] = (double)rand() / RAND_MAX;
        }*/
        lst->values[j] = (double)rand() / RAND_MAX;
       }

        map->lists[i] = *lst;
    }

    return map;
}

void write_map_to_file(Map* map, int n, int m) {
    FILE* file = fopen("map.txt", "w");

    if (file != NULL) {
        fprintf(file, "{\n");

        for (int i = 0; i < n; i++) {
            char key[10];
            sprintf(key, "liste_%d", i);

            fprintf(file, "    \"%s\": [", key);

            for (int j = 0; j < m; j++) {
                fprintf(file, "%.4f", map->lists[i].values[j]);

                if (j != m - 1) {
                    fprintf(file, ", ");
                }
            }

            fprintf(file, "]");

            if (i != n - 1) {
                fprintf(file, ",");
            }

            fprintf(file, "\n");
        }

        fprintf(file, "}\n");
        fclose(file);
    }
}

int main() {
    srand(time(NULL));
    int n = rand() % 10000 + 1;
    srand(time(NULL));
    int m = rand() % 100 + 1;
    Map* map = generate_random_map(n, m);
    write_map_to_file(map, n, m);
    free(map);
    return 0;
}