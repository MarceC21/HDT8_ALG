"""
===============================================================
Simulación
===============================================================
Autor: Jorge Villeda y Marcela Castillo
Fecha: 03/04/25
Descripción: Clase controlador que simula la recepción.



===============================================================
"""

import simpy
import random
from emergencia import Emergencia


class Recepcion:
    def __init__(self, env, num_doctores, num_enfermeras, num_rayos_x, num_laboratorio):
        self.env = env
        self.doctores = simpy.PriorityResource(env, capacity=num_doctores)
        self.enfermeras = simpy.Resource(env, capacity=num_enfermeras)
        self.rayos_x = simpy.PriorityResource(env, capacity=num_rayos_x)
        self.laboratorio = simpy.PriorityResource(env, capacity=num_laboratorio)


    #Función principal que atiende al paciente
    def atender_paciente(self, paciente):
        #Llegada
        llegada = self.env.now
        print(f"{paciente} llega a urgencias en t={llegada:.2f}")

        # Evaluación inicial con una enfermera
        with self.enfermeras.request() as req:
            yield req
            yield self.env.timeout(3)  # Evaluación inicial
            print(f"{paciente} fue evaluado en t={self.env.now:.2f}")

        prioridad = 6 - paciente.severidad  # Invertimos la prioridad (1 a 5, 5 a 1)


        with self.doctores.request(priority=prioridad) as req:
            yield req
            tiempo_atencion = random.randint(15, 30)
            yield self.env.timeout(tiempo_atencion)
            print(f"{paciente} atendido por doctor en t={self.env.now:.2f}")


        # Exámenes si son necesarios
        if random.random() < 0.3: #30% de probabilidad
            with self.rayos_x.request(priority=prioridad) as req:
                yield req
                yield self.env.timeout(20)
                print(f"{paciente} pasó por Rayos X en t={self.env.now:.2f}")

        if random.random() < 0.5: #50% de probabilidad
            with self.laboratorio.request(priority=prioridad) as req:
                yield req
                yield self.env.timeout(25)
                print(f"{paciente} pasó por Laboratorio en t={self.env.now:.2f}")

        # Paciente se va sanito y contento
        tiempo_total = self.env.now - llegada
        print(f"{paciente} salió del hospital en t={self.env.now:.2f} (Total: {tiempo_total:.2f} min)")

    def llegada_pacientes(self, tasa_llegada):
        #Genera los pacientes para nuestra sinmulación
        id_paciente = 0
        while True:
            yield self.env.timeout(random.expovariate(1.0 / tasa_llegada))
            paciente = Emergencia(id_paciente)
            self.env.process(self.atender_paciente(paciente))
            id_paciente += 1
