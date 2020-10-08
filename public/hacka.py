import pandas as pd
idlc= input("")
tipo1=input("Aqui va el id quiente c1")

'''Caso1 Managger caso2 '''
df1=pd.read_csv('usu.csv')
df2=pd.read_csv('cli.csv')

print(list(us))
print(list(cli))
Uni=us.loc[us['idCliente']==idcl,[],[],[]]


print(list(df2))
df1['check']=df2.prueba.isin(df1.producto)   Creamos una columna en df1, y vemos cuantos valores de producto coinsiden con pueba en la otra
print(df1['check'].value_counts())  value coubt agrupo los positivos y negaticos

