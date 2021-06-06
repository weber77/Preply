#include <iostream>
#include <string>
#include <ctime>
#include <cstdlib>

using namespace std;

class GameObject{
		

	public:
		char symbol;
		int x;
		int y;
		GameObject();
		GameObject( char s);
};

GameObject::GameObject(){
}

GameObject::GameObject( char s){
	symbol = s;
}


class Map{
	GameObject *grid [10][10];
	
	public:
		Map();

		void place(GameObject *go);
		void draw();
		bool movePlayer(char direction);
		bool moveZombies();

};

Map::Map(){
	for(int i=0; i <10; i++){
		for(int j= 0; j < 10; j++){
			grid[i][j] = NULL;
		}
	}
};

void Map::place(GameObject *go){
	while(true){
		srand(time(0)); 
		int x = (rand() % 10);
		int y = (rand() % 10);

		if(grid[x][y] == NULL){
			go->y = y;
			go->x = x;
			grid[x][y] = go;
			return;
		}
	}

};

void Map::draw(){
	for(int i=0; i <10; i++){
		for(int j= 0; j < 10; j++){
			if(grid[i][j] == NULL){
				cout << ".";
			}
			else{
				cout << grid[i][j]->symbol;
			}
		}
		cout << endl;
	}
};

bool Map::movePlayer(char d){

	for(int i=0; i <10; i++){
		for(int j= 0; j < 10; j++){
			if(grid[i][j] != NULL && grid[i][j]->symbol == 'P'){
				
				if(d == 'n'){

					if(i-1 < 0){
						cout << "You hit a wall\n";
					}
					else if( grid[i-1][j] != NULL && grid[i-1][j]->symbol == 'G'){
						cout<< "You WIN!\n";
						return true;
					}else if( grid[i-1][j] != NULL && grid[i-1][j]->symbol == 'Z' ){
						cout << "You LOSE!\n";
						return true;
					}
					else{
						grid[i-1][j] = grid[i][j]; 
						grid[i][j] = NULL;
						return false;
					}

				}
				else if(d == 's'){

					if(i+1 >= 10){
						cout << "You hit a wall\n";
					}
					else if( grid[i+1][j] != NULL && grid[i+1][j]->symbol == 'G'){
						cout<< "You WIN!\n";
						return true;
					}else if( grid[i+1][j] != NULL && grid[i+1][j]->symbol == 'Z' ){
						cout << "You LOSE!\n";
						return true;
					}
					else{
						grid[i+1][j] = grid[i][j]; 
						grid[i][j] = NULL;
						return false;
					}
				}else if(d == 'e'){
					cout << j <<endl;
					if(j-1 < 0){
						cout << "You hit a wall.\n";
					}
					else if( grid[i][j-1] != NULL && grid[i][j-1]->symbol == 'G'){
						cout<< "You WIN!\n";
						return true;
					}else if( grid[i][j-1] != NULL && grid[i][j-1]->symbol == 'Z' ){
						cout << "You LOSE!\n";
						return true;
					}
					else{
						grid[i][j-1] = grid[i][j]; 
						grid[i][j] = NULL;
						return false;
					}
				}
				else if(d == 'w'){
					if(j+1 >= 10){
						cout << "You hit a wall\n";
					}
					else if( grid[i][j+1] != NULL && grid[i][j+1]->symbol == 'G'){
						cout<< "You WIN!\n";
						return true;
					}else if( grid[i][j+1] != NULL && grid[i][j+1]->symbol == 'Z' ){
						cout << "You LOSE!\n";
						return true;
					}
					else{
						grid[i][j+1] = grid[i][j]; 
						grid[i][j] = NULL;
						return false;
					}
				
			}
				else{
					cout << "invalid input\n";
					return false;
				}
				}
				
		}
	}

	return false;

};

bool Map::moveZombies(){
	for(int i=0; i <10; i++){
		for(int j= 0; j < 10; j++){
			if(grid[i][j] != NULL && grid[i][j]->symbol == 'Z'){
				while(true){
					srand(time(0)); 
					int x = (rand() % 10);
					int y = (rand() % 10);

					if(grid[x][y] == NULL){
						
						grid[x][y] = grid[i][j];
						grid[i][j] = NULL;
						return false;
						
					}
					else if(grid[x][y] != NULL && grid[x][y]->symbol == 'P')
					{
						cout<< "You Lose!";
						return true;
						
					}
				}
			}
		}
	}

	return false;

};


int main(){
	GameObject player('P');
	GameObject Goal('G');
	GameObject zombies[5];
	Map map;
	bool gameStatus = false;
	char direction;

	//init zombies
	for(int i = 0; i < 5; i++){
		zombies[i].symbol = 'Z';
	}


	GameObject *tmp;

	//position player
	map.place(tmp = &player);

	//position Goal
	map.place(tmp= &Goal);

	//position zombies
	for(int i = 0; i < 5; i++){
		map.place(tmp= &zombies[i]);
	}

	map.draw();

	while(true){
		cout << "Enter direction (n, s, e, w): ";
		cin >> direction;
		gameStatus = map.movePlayer(direction);
		if(gameStatus){
			exit(0);
		}
		
		gameStatus = map.moveZombies();
		if(gameStatus){
			exit(0);
		}

		map.draw();

	}




	




}


