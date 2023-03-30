#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#define MAX_SIZE 1000

float max_value() {
    FILE *file = fopen("map.txt", "r");
    if (!file) {
        printf("Error: could not open file 'map.txt'\n");
        return 0;
    }

    float max = 0;
    float num;
    char line[MAX_SIZE];

    while (fgets(line, MAX_SIZE, file)) {
        char *token = strtok(line, " ");
        while (token != NULL) {
            num = atof(token);
            if (num > max) {
                max = num;
            }
            token = strtok(NULL, " ");
        }
    }

    fclose(file);
    return max;
}


float min_value() {
    FILE *file = fopen("map.txt", "r");
    if (!file) {
        printf("Error: could not open file 'map.txt'\n");
        return 0;
    }

    float min = 1; // valeur initiale de min
    float num;
    char line[MAX_SIZE];

    while (fgets(line, MAX_SIZE, file)) {
        char *token = strtok(line, " ");
        while (token != NULL) {
            num = atof(token);
            //printf("%f\n",num);
            if (num < min) { // compare avec min au lieu de max
                min = num;
                printf("oui");
            }
            token = strtok(NULL, " ");
        }
    }

    fclose(file);
    return min;
}


float mean_value(){
      FILE *file = fopen("map.txt", "r");
      if (!file) {
         printf("Error: could not open file 'map.txt'\n");
         return 0;
      }
      float mean=0;
      int total;
      char line[MAX_SIZE];
      while (fgets(line, MAX_SIZE, file)){
             char *token = strtok(line, " ");
             while (token != NULL) {
             mean = mean + atof(token);
             total= total + 1;
             token = strtok(NULL, " ");
             }
      }
      fclose(file);
      return (mean/total);
}

float ecart_value(){
     FILE *file = fopen("map.txt", "r");
     if(!file){
         printf("Error: could not open file 'map.txt'\n");
         return 0;
     }
     float mean = mean_value();
     float ecart = 0;
     int total = 0;
     char line[MAX_SIZE];
     while(fgets(line,MAX_SIZE, file)){
         char *token = strtok(line, " ");
         while (token != NULL) {
         ecart = ecart + (atof(token)-mean)*(atof(token)-mean);
         total = total + 1;
         token = strtok(NULL, " ");
         }
       }
         float test = ecart/total;
         float epsilon = 0.000001;
         float x= test;
         while ((x-test/x)>epsilon){
               x=(x+test/x)/2;
         }
         fclose(file);
         //test = pow(test, 2);
         return x;
}


int main() {
    printf("The maximum number in 'map.txt' is %.15f\n", max_value());
    printf("The minimum number in 'map.txt' is %.100f\n", min_value());
    printf("The mean number in 'map.txt' is %.15f\n", mean_value());
    printf("ecart %.15f\n", ecart_value());
    printf("test");
    float val1=max_value();
    float val2=min_value();
    float val3= mean_value();
    float val4= ecart_value();
    FILE *fichier = fopen("calcul.txt","w");
    if (fichier == NULL) {
        printf("impossible");
        return 1;
    }
    fprintf(fichier,"%f\n%f\n%f\n%f\n",val1,val2,val3,val4);
    fclose(fichier);
    return 0;
}