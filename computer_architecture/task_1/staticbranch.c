// s0829961 Lynne Wallace
// complete static branch predictor 
// inputs -  trace file, predictor mode
// outputs - technique, misprediction rate


#include <stdio.h>
#include <string.h>
#include <glib.h>


int simplepredictor(char *filename, char *mode) {

  // File line variables
  char branch;
  char location[20];
  int taken;
  
  // Misprediction variables
  int total = 0;
  int correct = 0;
  float misprediction;

  // Predictor
  int predictor;

  // Branch trace file
  FILE *file = fopen(filename, "r");

  // Does file exist
  if(file == 0) {
    printf("Could not open file\n");
    exit(2);
  }

  // Set predictor
  if(strcmp(mode, "taken") == 0) {
    predictor = 1;
  } else if (strcmp(mode, "not_taken") == 0) {
    predictor = 0;
  }

  // While there are still lines to read
  while(fscanf(file, "%c %s %d\n", &branch, location, &taken) == 3) {

    // Update misprediction values
    if(taken == predictor) {
      correct++;
    }
    total++;
  } 

  // Misprediction rate
  misprediction = (total-correct)*100.0/total*1.0;

  // Print details
  printf("\nPredictor: %s\n", mode); 
  printf("Misprediction rate: %.4f\n", misprediction);

  // Close file
  fclose(file);
}


int profileprediction(char *filename) {

  // File line variables
  char branch;
  char location[20];
  int taken;

  // Branch trace file (2 copies)
  FILE *file = fopen(filename, "r");
  FILE *file2 = fopen(filename, "r");

  // Predictor variables
  GHashTable* hash = g_hash_table_new(g_str_hash, g_int_equal);
  int predictor;
  int predicttaken;

  // Misprediction variables
  int total = 0;
  int correct = 0;

  // Real file
  if ( file == 0 ) {
    printf( "Could not open file\n" );
    exit(2);
  }

  // While there are still lines to read
  while(fscanf(file, "%c %s %d\n", &branch, location, &taken) == 3) {

    // If location not stored
    if (g_hash_table_lookup_extended(hash, location, NULL, NULL) != TRUE) {

      // Set up and add predictor
      g_hash_table_insert(hash, g_strdup(location), 0);
      predictor = 0;

    // Already stored
    } else {

      // Get predictor value
      predictor = g_hash_table_lookup(hash, location);
    }

    // Increment if taken otherwise decrement
    if(taken) {
      predictor++;
    } else {
      predictor--;
    }

    // Update value
    g_hash_table_replace(hash, g_strdup(location), predictor);
  }
  
  // While there are still lines to read
  while(fscanf(file2, "%c %s %d\n", &branch, location, &taken) == 3) {

    // Look up predictor
    predictor = g_hash_table_lookup(hash, location);
    
    // Does predictor tell to take
    if(predictor >= 0) {
      predicttaken = 1;
    } else {
      predicttaken = 0;
    }

    // Correct prediction
    if(predicttaken == taken) {
      correct++;
    }
    total++;
  }

  float misprediction = (total-correct)*100.0/total*1.0;

  printf("\nPredictor: profile\n"); 
  printf("Misprediction rate: %.4f\n", misprediction);

  fclose(file);
  fclose(file2);
}


int main(int argc, char *argv[]) {
  
  // Check for the correct number of arguments
  if(argc != 3) {
    printf("Usage: %s <trace file> <mode>\n", argv[0]);
    exit(1);
  }  

  // Simple predictors
  if(strcmp(argv[2], "taken") == 0 || strcmp(argv[2], "not_taken") == 0) {
    simplepredictor(argv[1], argv[2]);
  }

  // Profile guided prediction
  if(strcmp(argv[2], "profile") == 0) {
    profileprediction(argv[1]);
  }
}
