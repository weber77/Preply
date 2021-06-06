import pandas as pd
from sklearn.tree import DecisionTreeClassifier
from sklearn import tree


if __name__ == "__main__":

    input_df = pd.DataFrame({
        "outlook": ['Sunny', 'Sunny',  'Overcast', 'Rain', 'Rain', 'Rain', 'Overcast', 'Sunny', 'Sunny', 'Rain', 'Sunny', 'Overcast', 'Overcast', 'Rain'],
        "temp": ['Hot', 'Hot', 'Hot', 'Mild', 'Cool', 'Cool', 'Cool',  'Mild',  'Cool', 'Mild', 'Mild', 'Mild', 'Hot', 'Mild'],
        "humidity": ['High', 'High', 'High', 'High', 'Normal', 'Normal', 'Normal', 'High', 'Normal', 'Normal', 'Normal', 'High', 'Normal', 'High'],
        "wind": ['Weak', 'Strong', 'Weak', 'Weak', 'Weak', 'Strong', 'Strong', 'Weak', 'Weak', 'Weak', 'Strong', 'Strong', 'Weak', 'Strong'],
        "did_run": [False, False, True, True, True, False, True, False, True, True, True, True, True, False]

    })

    feature_cols = ['outlook', 'temp', 'humidity', 'wind']
    X = pd.get_dummies(input_df[feature_cols])
    y = pd.get_dummies(input_df.did_run)
    classifier = DecisionTreeClassifier(criterion='entropy')
    classifier.fit(X, y)

    tree.export_graphviz(classifier, out_file="output_graph")

    test_df = pd.DataFrame({
        "outlook_Overcast":[0],
        "outlook_Rain":[0],
        "outlook_Sunny":[1],
        "temp_Cool":[0],
        "temp_Hot":[1],
        "temp_Mild":[0],
        "humidity_High":[0],
        "humidity_Normal":[1],
        "wind_Strong":[1],
        "wind_Weak": [0]
        })
    # test_df = pd.DataFrame({
    #     "outlook_Overcast":[0],
    #     "outlook_Rain":[0],
    #     "outlook_Sunny":[1],
    #     "temp_Cool":[0],
    #     "temp_Hot":[0],
    #     "temp_Mild":[1],
    #     "humidity_High":[0],
    #     "humidity_Normal":[1],
    #     "wind_Strong":[0],
    #     "wind_Weak": [1]
    #     })
    
    predict = classifier.predict( test_df)
    if(predict[0][0]==1):
        print("False")
    else:
        print("True")
