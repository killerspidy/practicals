# -*- coding: utf-8 -*-
"""Col into number.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1gR0W6MmwvNy4c0AsJClzFtsH6Ir4joAf
"""

import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn import preprocessing
ir=pd.read_csv('iris.csv')

#drop id coloum
ir=ir.drop('Id',axis=1)
print(ir)
#convet species coloumn in a numerical coloumn of the
#creating  labelEncoder
le = preprocessing.LabelEncoder()
#coverting string label into numbers
ir.Species =le.fit_transform(ir.Species)
x = ir.iloc[:, :-1].values
print(x)
y = ir.iloc[:,4].values
print(y)
plt.scatter(x[:, 0], x[: , 3], c=y ,cmap ='flag')
plt.xlabel('Sepal Length cm')
plt.ylabel('Petal Length cm')
plt.show()