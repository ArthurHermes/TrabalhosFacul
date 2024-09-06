import unittest
import math



def soma(a,b):
    return a + b


def subtracao(a,b):
    return a - b


def multiplicacao(a,b):
    return a * b

def divisao(a,b):
    return a / b

def potencia(a,b):
    return a ** b

def modulo(a, b):
    return a % b

def divisao_inteira(a,b):
    return a // b

def area(base, altura):
    return base * altura

def area_circulo(raio):
    return math.pi * raio ** 2

def area_triangulo(base, altura):
    return 0.5 * base * altura

def real_para_dolar(real):
    dolar = 5.50
    return real * dolar
    


a = float(input("Digite o valor de A: "))
b = float(input("Digite o valor de B: "))
c = float(input("Digite o valor de C(Real, raio): "))
print ("Soma: ", soma(a, b))
print ("Subtraçao: ", subtracao(a, b))
print ("Multiplicação: ", multiplicacao (a, b))
print ("Divisão: ", divisao(a, b))
print ("Potencia: ", potencia(a, b))
print ("Modulo: ", modulo(a, b))
print ("Divisão Inteira: ", divisao_inteira(a, b))
print ("Area: ", area (a, b))
print ("Area Circulo: ", area_circulo (c))
print("Area Triangulo: ", area_triangulo(a, b))
print("Real Para dolar: ", real_para_dolar(c))




