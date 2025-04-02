"""
===============================================================
Simulación
===============================================================
Autor: Jorge Villeda y Marcela Castillo
Fecha: 03/04/25
Descripción: Clase main y vista.

===============================================================
"""

from Recepcion import Recepcion, generar_pacientes
import simpy 


def main():
    env = simpy.Environment()
    recepcion = Recepcion(env, num_enfermeras=3, num_doctores=2, num_rayos_x=1, num_laboratorio=1)
    env.process(generar_pacientes(env, recepcion, intervalo_llegada=5))
    env.run(until=100)

if __name__ == "__main__":
    main()