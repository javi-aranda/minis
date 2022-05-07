import numpy as np
import pandas as pd

class LinearRegressor:
        def __init__(self):
            # Inicializamos a 0 los valores de intercept, slope y R^2
            self.intercept = 0
            self.slope = 0
            self.r_squared = 0
        

        def train(self, input_X, input_Y):
            # Tamaño del array de datos
            n = np.size(input_X) 
  
            # Medias de las variables X,Y
            x_mean, y_mean = np.mean(input_X), np.mean(input_Y) 
          
            # Sumatorios de cuadrados de XY, X, Y
            SS_xy = np.sum(input_Y*input_X) - n*y_mean*x_mean 
            SS_xx = np.sum(input_X*input_X) - n*x_mean*x_mean
            SS_yy = np.sum(input_Y*input_Y) - n*y_mean*y_mean 
          
            # Cálculo de parámetros
            self.slope = SS_xy / SS_xx 
            self.intercept = y_mean - self.slope*x_mean 
            self.r_square = SS_xy*SS_xy / (SS_xx * SS_yy)
            
            # Inicialización DataFrame
            d = {'Indicator': ['Intercept', 'X1'], 'Coefficient': [self.intercept, self.slope]}
            self.df_results = pd.DataFrame(data=d)

        def output(self):
            print(self.df_results)
            print("-"*30)
            print(f"R^2 : {self.r_square}")
