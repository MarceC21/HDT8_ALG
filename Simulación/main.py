"""
===============================================================
Simulación
===============================================================
Autor: Jorge Villeda y Marcela Castillo
Fecha: 03/04/25
Descripción: Clase main y vista.

===============================================================
"""



import simpy
from recepcion import Recepcion

# Parámetros de la simulación
TIEMPO_SIMULACION = 300  # 300 minutos (5 horas)
TASA_LLEGADA = 5  # Un paciente cada 5 minutos
NUM_DOCTORES = 10
NUM_ENFERMERAS = 4
NUM_RAYOS_X = 1
NUM_LABORATORIO = 1

# Crear el entorno de SimPy
env = simpy.Environment()
hospital = Recepcion(env, NUM_DOCTORES, NUM_ENFERMERAS, NUM_RAYOS_X, NUM_LABORATORIO)

# Iniciar la simulación
env.process(hospital.llegada_pacientes(TASA_LLEGADA))
print("Iniciando simulación de emergencias del IGGS\n")
env.run(until=TIEMPO_SIMULACION)
print("\nSimulación ya terminó")
