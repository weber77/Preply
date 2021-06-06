#include <iostream>
#include <string>
#include <fstream>

#include <time.h>


//things to figure out .--> what to do if the file size is unkown
//getting the time in terms of N^2
//why 0's disappear when printing into the new file

using namespace std;

struct data {
  public:
    int ss_number, b_day, zip_code;
    string f_name,l_name;
	
	data(int ss_number, int b_day, string f_name, string l_name, int zip_code); //constructor??
};

struct Link{
	data * content;
	Link * next;
	Link(data * i = NULL, Link * j = NULL)
	{
		content = i;
		next = j; 
	}
};

void print_person(data* a)
{
	if (a == NULL)
	{
		cout<<"the person does not exist"<<endl;
	}
	else
	{
		cout << a->ss_number << " " << a->b_day<< " " << a->f_name << " " << a->l_name << " " << a->zip_code << endl;
    }
}

void print_list(Link *a)
{
	while(a !=NULL)
	{
		print_person(a->content);
		a = a->next;
	}
}

data* People[1000];

void split(string str, int line_number) //this function separates each line of data into categories of ss number, birthday, first and last name, and account balance using the spaces in between to figure out how the data is split up
	//once the first name and last name is distinguished by the program, we can then use the last names (the last name 'string') to sort the data
{

    string temp_word = "";

    int spaceNo=0;
    for(int i=0; i<str.size() ; i+=1 ) 
    {
        if( str[i] == ' ' )
        {
            spaceNo = spaceNo+1;

            if(spaceNo==1)
            {
                People[line_number]->ss_number = stoi(temp_word);
            }
            else if(spaceNo==2)
            {
                People[line_number]->b_day = stoi(temp_word);
            }
            else if(spaceNo==3)
            {
                 People[line_number]->f_name = temp_word;
            }
             else if(spaceNo==4)
            {
                 People[line_number]->l_name = temp_word;
            }
            temp_word = "";
        }

        else
        {
            temp_word = temp_word + str[i];  
        }
    }
    People[line_number]->zip_code = stod(temp_word);
}



int find_firstperson(int position) //person with the alphabetically smallest last name, this operation is permoned N time, where N equals the amount of things in the array
{
    int firstperson_no=position;
    for(int i=position; i<10; i++)
    {
        if(People[i]->l_name < People[firstperson_no]->l_name )
        {
            firstperson_no = i;
        }

    }
    return firstperson_no;
}

void search_name(Link* data, string f_name, string l_name)
{
	cout << "Enter Name and Last Name: ";
    cin >> name >>" ">> lastname;
    cout << endl; 
	if (data == NULL)
	{
		cout<<"the person does not exist"<<endl;
	}
	while(data != NULL)
	{
		if(data->content->f_name == firstname && data->content->l_name == lastname)
	    {
	    	cout<< "Person found!"<< endl;
			print_person(data->content);
	    }
		data = data->next; //this way we go through every person in the list
	}
}

void search_lastname_all(Link* data, string lastname)
{
    cout << "Enter Name: ";
    cin >> lastname;
    cout << endl;
	if (data == NULL)
	{
		cout<<"the person does not exist"<<endl;
	}
	while(data != NULL)
	{
		if(data->content->l_name == lastname)
	    {
	    	cout<< "Person found!"<< endl;
			print_person(data->content);
	    }
		data = data->next; //this way we go through every person in the list
	}
}

void find_oldest(Link* data)
{
	if (data == NULL)
	{
		cout<<"the person does not exist"<<endl;
	}
	data* oldest = data ->content;
	
	while(data != NULL)
	{
		if(data->content->b_day > oldest->b_day)
		{
			oldest = data -> content;
		}
		data = data->next;
	}
   
	cout<< "Oldest person found!"<< endl;
	print_person(oldest->content);
}

void newlist_by_zip(Link* data, int zip_code)
{
	
}


void sort_people(int no_people) //the sorting function. this is the function that operates with ON^2, because the there is a for loop that performs the swap operation N times and there is an other for loop that performs the find_firsperson operation N times within the bigger loop. Therefore the sorting operation run through the array N*N times which equals N^2.
{	for(int i=0; i<no_people; i++)
    {
        int swap_no = find_firstperson(i);
	    data temp = People[swap_no];
	    People[swap_no] = People[i];
	    People[i] = temp;
	}

}

void print_newFile(ofstream & file2) //this prints the new array with the people sorted 
{
	//int N;
	//People.size= N;
    for(int i=0; i<10; i+=1)
    {
file2 << People[i].ss_number << " " << People[i].b_day << " " << People[i].f_name << " " << People[i].l_name << " " << People[i].zip_code << endl;
	   print_person(i);
    }

}

double get_cpu_time() //the timing function needed to get the time it took the computer to execute this program
{
    struct rusage ruse;
    getrusage(RUSAGE_SELF, &ruse);
    return ruse.ru_utime.tv_sec+ruse.ru_utime.tv_usec/1000000.0 + ruse.ru_stime.tv_sec+ruse.ru_stime.tv_usec/1000000.0;
}

int main()
{
	//int N;
	//People.size= N;

    cout << "Here is a list of the people alphabetically sorted:" << endl << "\n";

    ifstream file1("/Users/nisankorkmaz/Desktop/database1.txt");
    ofstream file2("/Users/nisankorkmaz/Desktop/newdatabasefile.txt");

    string line;
    int line_number;
    while(getline(file1,line))
    {
          split(line, line_number);
          line_number = line_number + 1;
    }
  
    sort_people(10);
    print_newFile(file2);
	search_name(name, lastname);
    search_lastname_all(lastname);
	
    cout<<"\n"<<"the time it took this program to execute is: "<< get_cpu_time()<< " seconds";

    return 0;
}

/*
You are to write a program that reads this file and stores its information in a 
linked list.

Once your program has constructed the list, it should enter an interactive loop,
taking commands from the user:

FIND firstname lastname
   - display all information about the named person,
     your program must not crash if no such person exists!

ALL lastname
   - display all information about all people who have the given last name.

ZIP zipcode
   - make a new linked list of all people living in the given zip code,
     then display the entire contents of that linked list.

OLDEST
   - print the name and zipcode of the oldest person in the database.

EXIT
   - exit from the program.
*/
