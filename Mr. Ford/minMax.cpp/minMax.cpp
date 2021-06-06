
#include <iostream>
#include <vector>

using namespace std;

vector<int> dacMinMax(vector<int> vec, int l, int r){
    int min = 0;
    int max = 0;

    if(vec.size() == 1){
            vector<int> result;
            result.push_back(vec.at(0));
            result.push_back(vec.at(0));

            return result;
    }
    else if(vec.size() == 2){
        if (vec.at(0) < vec.at(1))
        {   
            vector<int> result;
            result.push_back(vec.at(0));
            result.push_back(vec.at(1));

            return result;
        }
        else{
            vector<int> result;
            result.push_back(vec.at(1));
            result.push_back(vec.at(0));

            return result;
        }     
    }

    // dividing vector into 2 each time
    vector<int> minMax;
    int middle = vec.size()/2;
    
    vector<int> left(vec.begin(), vec.begin() + middle);
    vector<int> right(vec.begin() + middle, vec.begin() + vec.size());

    
    left = dacMinMax(left, 0, left.size() - 1);
    right= dacMinMax(right, 0, right.size() -1);

    if (left.at(0) < right.at(0))
    {
        minMax.push_back(left.at(0));
    }
    else{
        minMax.push_back(right.at(0));
    }

    if (left.at(1) > right.at(1))
    {
        minMax.push_back(left.at(1));
    }
    else{
        minMax.push_back(right.at(1));
    }
    
    
    return dacMinMax(minMax, 0, minMax.size() -1);

}

int main() {
    vector<int> vect;
    vect.push_back(1);
 
    // If vector is size of 1, should return 1,1
    vector<int> ans = dacMinMax(vect, 0, vect.size() - 1);
    cout <<"lowest: " << to_string(ans[0]) << endl;
    cout <<"highest: " << to_string(ans[1]) << endl;
 
    static const int arr[] = {54, 26, 93, 100,17, 31, 44, 55, 20, 23, 5};
    vector<int> vect2 (arr, arr + sizeof(arr) / sizeof(arr[0]) );
    
    // Should return 2, 19
    ans = dacMinMax(vect2, 0, vect.size() - 1);
    cout <<"lowest: " << to_string(ans[0]) << endl;
    cout <<"highest: " << to_string(ans[1]) << endl;
    
    return 0;
}
