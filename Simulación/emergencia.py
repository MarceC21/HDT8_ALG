"""
===============================================================
Simulación
===============================================================
Autor: Jorge Villeda y Marcela Castillo
Fecha: 03/04/25
Descripción: Clase modelo de cada emergencia.



===============================================================
"""
import random

class Emergencia:
    def __init__(self, id_paciente):
        self.id_paciente = id_paciente
        self.severidad = random.randint(1, 5)  # Nivel de urgencia (1 es más grave)
    
    def __str__(self):
        return f"Paciente {self.id_paciente} (Severidad {self.severidad})"
