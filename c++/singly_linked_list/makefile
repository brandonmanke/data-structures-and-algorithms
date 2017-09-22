# Makefile for singly linked list c++ implementation
CC = g++
CFLAG = -std=c++11 -c
OFLAG = -o
OBJ_DIR = obj/
BIN_DIR = bin/
SRC_DIR = src/
OBJS = $(OBJ_DIR)main.o $(OBJ_DIR)linked_list.o

default : main.o linked_list.o
	$(CC) $(OBJS) -o $(BIN_DIR)out

main.o : $(SRC_DIR)main.cpp
	$(CC) $(CFLAG) $(SRC_DIR)main.cpp -o $(OBJ_DIR)main.o

linked_list.o : $(SRC_DIR)linked_list.cpp
	$(CC) $(CFLAG) $(SRC_DIR)linked_list.cpp $(OFLAG) $(OBJ_DIR)linked_list.o

# CLEAN
clean :
	rm *.o out -r
