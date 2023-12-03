# -*- coding: utf-8 -*-
"""value.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1pxDXoxA6cgUzf_oy_ELDnnTK7B38zdU1
"""

# slip 2: Write a python program to find all null values in a given dataset and remove them.
# importing pandas as pd
import pandas as pd

# Creating the dataframe
df = pd.DataFrame({"A": [12, 4, 5, None, 1], "B": [None, 2, 54, 3, None], "C": [20, 16, None, 3, 8], "D": [14, 3, None, None, 6]})

# Print the dataframe
print(df)  # Print the original dataframe

# Drop rows with any missing values
df = df.dropna()

# Print the dataframe after dropping rows with missing values
print(df)

# Import necessary modules
from sklearn.neighbors import KNeighborsClassifier
from sklearn.model_selection import train_test_split
from sklearn.datasets import load_iris

# Loading data
irisData = load_iris()

# Create feature and target arrays
X = irisData.data
y = irisData.target

# Split into training and test set
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Create KNeighborsClassifier
knn = KNeighborsClassifier(n_neighbors=7)

# Fit the model on the training set
knn.fit(X_train, y_train)

# Predict on the dataset which the model has not seen before
print(knn.predict(X_test))