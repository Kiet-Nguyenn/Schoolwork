#include <iostream>
#include <fstream>
#include <string>
#include "logic.h"

using std::cout, std::endl, std::ifstream, std::string;

/**
 * TODO: Student implement this function
 * Load representation of the dungeon level from file into the 2D map.
 * Calls createMap to allocate the 2D array.
 * @param   fileName    File name of dungeon level.
 * @param   maxRow      Number of rows in the dungeon table (aka height).
 * @param   maxCol      Number of columns in the dungeon table (aka width).
 * @param   player      Player object by reference to set starting position.
 * @return  pointer to 2D dynamic array representation of dungeon map with player's location., or nullptr if loading fails for any reason
 * @updates  maxRow, maxCol, player
 */
char** loadLevel(const string& fileName, int& maxRow, int& maxCol, Player& player) {
    ifstream inFS;
    bool door = false;

    //test
    int rows;
    int cols;
    int startx;
    int starty;
    char input_buffer;

    inFS.open(fileName);
    if(!inFS.is_open()){
        return nullptr;
    }

    //inFS >> maxRow >> maxCol;

    //inFS >> player.row >> player.col;

    inFS >> maxRow;
    if(inFS.fail()){
        return nullptr;
    }
    inFS>> maxCol;
    if(inFS.fail()){
        return nullptr;
    }

    inFS >> player.row;
    if(inFS.fail()){
        return nullptr;
    }
    inFS >> player.col;
    if(inFS.fail()){
        return nullptr;
    }

    if(maxRow > 999999 || maxCol > 999999 || maxRow <= 0 || maxCol <= 0 || maxRow <= player.row || maxCol <= player.row || player.row < 0 || player.col < 0){
        return nullptr;
    }

    if(INT32_MAX/(maxRow*1.0) < (maxCol*1.0)){
        return nullptr;
    }

    if(INT32_MAX/(maxCol*1.0) < (maxRow*1.0)){
        return nullptr;
    }

    //2D dynamic Array
    char** map = createMap(maxRow, maxCol);

    if(map == nullptr || map == 0){
        inFS.close();
        return nullptr;
    }

    for (int i = 0; i < maxRow; i++){
        for (int j = 0; j < maxCol; j++){
            input_buffer = 0;
            inFS >> input_buffer;
            if(inFS.fail()){
                deleteMap(map, maxRow);
                inFS.close();
                return nullptr;
            }

            map[i][j] = input_buffer;
            if (map[i][j] != TILE_AMULET && map[i][j] != TILE_DOOR && map[i][j] != TILE_EXIT && map[i][j] != TILE_MONSTER && map[i][j] != TILE_OPEN && map[i][j] != TILE_PILLAR && map[i][j] != TILE_TREASURE){
                deleteMap(map, maxRow);
                inFS.close();
                return nullptr;
            }
            if (map[i][j] == TILE_DOOR || map[i][j] == TILE_EXIT){
                door = true;
            }
            //cout << map[i][j] << " ";
        }
    }

    inFS >> input_buffer;
    if(!inFS.fail()){
        deleteMap(map, maxRow);
        return nullptr;
    }
    map[player.row][player.col] = TILE_PLAYER;
    inFS.close();


    if (!door){
        deleteMap(map, maxRow);
        return nullptr;
    }

    
    return map;
}

/**
 * TODO: Student implement this function
 * Translate the character direction input by the user into row or column change.
 * That is, updates the nextRow or nextCol according to the player's movement direction.
 * @param   input       Character input by the user which translates to a direction.
 * @param   nextRow     Player's next row on the dungeon map (up/down).
 * @param   nextCol     Player's next column on dungeon map (left/right).
 * @updates  nextRow, nextCol
 */
void getDirection(char input, int& nextRow, int& nextCol) {
    switch (input){
        case MOVE_UP:
            nextRow = nextRow - 1;
            //cout << "up: " << nextRow << " " << nextCol << endl;
            break;
        case MOVE_DOWN:
            nextRow = nextRow + 1;
            //cout << "down: " << nextRow << " " << nextCol << endl;
            break;
        case MOVE_LEFT:
            nextCol = nextCol - 1;
            //cout << "left: " << nextRow << " " << nextCol << endl;
            break;
        case MOVE_RIGHT:
            nextCol = nextCol + 1;
            //cout << "right: " << nextRow << " " << nextCol << endl;
            break;
        //default:
            //cout << "No movement" << endl;
    }
}

/**
 * TODO: [suggested] Student implement this function
 * Allocate the 2D map array.
 * Initialize each cell to TILE_OPEN.
 * @param   maxRow      Number of rows in the dungeon table (aka height).
 * @param   maxCol      Number of columns in the dungeon table (aka width).
 * @return  2D map array for the dungeon level, holds char type.
 */
char** createMap(int maxRow, int maxCol) {
    char** map = new char*[maxRow];
    for (int i = 0; i < maxRow; i++){
        map[i] = new char[maxCol];
        for (int j = 0; j < maxCol; j++){
            map[i][j] = TILE_OPEN;
        }
    }
    return map;
}

/**
 * TODO: Student implement this function
 * Deallocates the 2D map array.
 * @param   map         Dungeon map.
 * @param   maxRow      Number of rows in the dungeon table (aka height).
 * @return None
 * @update map, maxRow
 */
void deleteMap(char**& map, int& maxRow) {
    if (maxRow > 0 && map != nullptr){
        for (int i = 0; i < maxRow; i++){
            delete[] map[i];
        }
    }
    delete[] map;
    map = nullptr;
    maxRow = 0;
}

/**
 * TODO: Student implement this function
 * Resize the 2D map by doubling both dimensions.
 * Copy the current map contents to the right, diagonal down, and below.
 * Do not duplicate the player, and remember to avoid memory leaks!
 * You can use the STATUS constants defined in logic.h to help!
 * @param   map         Dungeon map.
 * @param   maxRow      Number of rows in the dungeon table (aka height), to be doubled.
 * @param   maxCol      Number of columns in the dungeon table (aka width), to be doubled.
 * @return  pointer to a dynamically-allocated 2D array (map) that has twice as many columns and rows in size.
 * @update maxRow, maxCol
 */
char** resizeMap(char** map, int& maxRow, int& maxCol) {
    /*
    if (map == nullptr){
        return nullptr;
    }

    int oldRow = 0;
    int oldCol = 0;


    char** map_new = createMap(maxRow * 2, maxCol * 2);
    //subarray A
    for (int i = 0; i < maxRow; i++){
        for (int j = 0; j < maxCol; j++){
            map_new[i][j] = map[i][j];
        }
    }

    //subarray B
    oldRow = 0;
    oldCol = 0;
    for (int i = maxRow; i < maxRow * 2; i++){
        oldCol = 0;
        for (int j = 0; j < maxCol; j++){
            map_new[i][j] = map[oldRow][oldCol];

            if (map[oldRow][oldCol] == TILE_PLAYER){
                map_new[i][j] = TILE_OPEN;
            }
            oldCol++;
        }
        oldRow++;
    }

    //subarray C
    oldRow = 0;
    oldCol = 0;
    for (int i = 0; i < maxRow; i++){
        oldCol = 0;
        for (int j = maxCol; j < maxCol * 2; j++){
            map_new[i][j] = map[i][j];

            if (map[oldRow][oldCol] == TILE_PLAYER){
                map_new[i][j] = TILE_OPEN;
            }
            oldCol++;
        }
        oldRow++;
    }

    //subarray D
    oldRow = 0;
    oldCol = 0;
    for (int i = maxRow; i < maxRow * 2; i++){
        oldCol = 0;
        for (int j = maxCol; j < maxCol * 2; j++){
            map_new[i][j] = map[i][j];

            if (map[oldRow][oldCol] == TILE_PLAYER){
                map_new[i][j] = TILE_OPEN;
            }
            oldCol++;
        }
        oldRow++;
    }

    oldRow = maxRow;
    deleteMap(map, oldRow);
    maxRow = maxRow * 2;
    maxCol = maxCol * 2;

    return map_new;
    */
    return nullptr;
}

/**
 * TODO: Student implement this function
 * Checks if the player can move in the specified direction and performs the move if so.
 * Cannot move out of bounds or onto TILE_PILLAR or TILE_MONSTER.
 * Cannot move onto TILE_EXIT without at least one treasure. 
 * If TILE_TREASURE, increment treasure by 1.
 * Remember to update the map tile that the player moves onto and return the appropriate status.
 * You can use the STATUS constants defined in logic.h to help!
 * @param   map         Dungeon map.
 * @param   maxRow      Number of rows in the dungeon table (aka height).
 * @param   maxCol      Number of columns in the dungeon table (aka width).
 * @param   player      Player object to by reference to see current location.
 * @param   nextRow     Player's next row on the dungeon map (up/down).
 * @param   nextCol     Player's next column on dungeon map (left/right).
 * @return  Player's movement status after updating player's position.
 * @update map contents, player
 */
int doPlayerMove(char** map, int maxRow, int maxCol, Player& player, int nextRow, int nextCol) {
    map[player.row][player.col] = TILE_OPEN;

    if (nextRow < 0 || nextRow >= maxRow || nextCol < 0 || nextCol >= maxCol){
        nextRow = player.row;
        nextCol = player.col;
        map[player.row][player.col] = TILE_PLAYER;
        //cout << "stayed" << endl;
        return STATUS_STAY;
    }
    if (map[nextRow][nextCol] == TILE_PILLAR || map[nextRow][nextCol] == TILE_MONSTER){
        nextRow = player.row;
        nextCol = player.col;
        map[player.row][player.col] = TILE_PLAYER;
        //cout << "stayed" << endl;
        return STATUS_STAY;
    }

    if (map[nextRow][nextCol] == TILE_OPEN){
        player.row = nextRow;
        player.col = nextCol;
        map[player.row][player.col] = TILE_PLAYER;
        //cout << "moved" << endl;
        return STATUS_MOVE;
    }

    if (map[nextRow][nextCol] == TILE_TREASURE){
        player.treasure += 1;
        player.row = nextRow;
        player.col = nextCol;
        map[player.row][player.col] = TILE_PLAYER;
        //cout << "treasure" << endl;
        return STATUS_TREASURE;
    }

    if (map[nextRow][nextCol] == TILE_AMULET){
        player.row = nextRow;
        player.col = nextCol;
        map[player.row][player.col] = TILE_PLAYER;
        //cout << "amulet" << endl;
        return STATUS_AMULET;
    }

    if (map[nextRow][nextCol] == TILE_DOOR){
        player.row = nextRow;
        player.col = nextCol;
        map[player.row][player.col] = TILE_PLAYER;
        //cout << "leave" << endl;
        return STATUS_LEAVE;
    }

    if (map[nextRow][nextCol] == TILE_EXIT){
        if (player.treasure > 0){
            player.row = nextRow;
            player.col = nextCol;
            map[player.row][player.col] = TILE_PLAYER;
            //cout << "escape" << endl;
            return STATUS_ESCAPE;
        }
        else {
            nextRow = player.row;
            nextCol = player.col;
            map[player.row][player.col] = TILE_PLAYER;
            //cout << "stayed" << endl;
            return STATUS_STAY;
        }
    }

    return 0;
}

/**
 * TODO: Student implement this function
 * Update monster locations:
 * We check up, down, left, right from the current player position.
 * If we see an obstacle, there is no line of sight in that direction, and the monster does not move.
 * If we see a monster before an obstacle, the monster moves one tile toward the player.
 * We should update the map as the monster moves.
 * At the end, we check if a monster has moved onto the player's tile.
 * @param   map         Dungeon map.
 * @param   maxRow      Number of rows in the dungeon table (aka height).
 * @param   maxCol      Number of columns in the dungeon table (aka width).
 * @param   player      Player object by reference for current location.
 * @return  Boolean value indicating player status: true if monster reaches the player, false if not.
 * @update map contents
 */
bool doMonsterAttack(char** map, int maxRow, int maxCol, const Player& player) {
    return false;
}
