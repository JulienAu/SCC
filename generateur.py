#!/usr/bin/env python3

import random

def generateur(i , n):
	
	graphI = ""
	graphI = graphI + str(i) +"->"
	voisins = random.randint(1, (n - 2))
	voisinsAtteint = set()
	for j in range(voisins): 
		voisin = random.randint(1, n)
		if(voisin != i):
			voisinsAtteint.add(voisin)
			#graphI = graphI + str(voisin) + ","
	for voisin in voisinsAtteint :
		graphI = graphI + str(voisin)+","

	voisin = random.randint(1, n)
	while(voisin in voisinsAtteint or voisin == i):
		voisin = random.randint(1, n)
	graphI = graphI + str(voisin)
	return graphI



for j in range(3, 5000 , 50):
	graph=""
	for i in range(j+4):
		graph= graph +generateur(i+1,j+4)+"/"
	print(graph)
