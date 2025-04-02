"""
===============================================================
Simulación
===============================================================
Autor: Jorge Villeda y Marcela Castillo
Fecha: 03/04/25
Descripción: Clase controlador que simula la recepción.



===============================================================
"""

import random
import simpy
#importar Emergencia cuando este hecha 

class Recepcion:
    def __init__(self, env, num_enfermeras, num_doctores, num_rayos_x, num_laboratorio):
        self.env = env
        self.enfermeras = simpy.PriorityResource(env, num_enfermeras)
        self.doctores = simpy.PriorityResource(env, num_doctores)
        self.rayos_x = simpy.PriorityResource(env, num_rayos_x)
        self.laboratorio = simpy.PriorityResource(env, num_laboratorio)

    def atender_paciente(self, paciente):
        yield self.env.process(paciente.atender(self.enfermeras, self.doctores, self.rayos_x, self.laboratorio))
        print(f'{paciente.nombre} atendido en {self.env.now - paciente.tiempo_llegada:.2f} minutos')


def generar_pacientes(env, recepcion, intervalo_llegada):
    paciente_id = 0
    while True: #En este caso si vale porque el límite lo ponemos en el Main.py
        yield env.timeout(random.expovariate(1.0 / intervalo_llegada))
        severidad = random.randint(1, 5)
        paciente = Emergencia(env, f'Paciente {paciente_id}', severidad)
        env.process(recepcion.atender_paciente(paciente))
        paciente_id += 1