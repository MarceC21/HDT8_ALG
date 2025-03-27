"""
===============================================================
Simulación
===============================================================
Autor: []
Fecha: []
Descripción:



===============================================================
"""
import random

# EMERGENCIA: numero, recursos (servicios de lab, equipos, etc.), doctor disponible



def generar_paciente(env, nombre, enfermedad, cola_procesos):
    """ Simula el ciclo de vida de un proceso en un sistema operativo """
    memoria_requerida = random.randint(1, 10)
    instrucciones_totales = random.randint(1, 10)

    print(f"{env.now}: {nombre} llega al sistema (requiere {memoria_requerida} de RAM)")

    # Solicitar RAM (espera hasta obtenerla)
    yield ram.get(memoria_requerida)
    print(f"{env.now}: {nombre} obtiene {memoria_requerida} de RAM y está listo para ejecutarse")

    # Agregar proceso a la cola para el CPU (espera en la cola hasta que CPU lo atienda)
    cola_procesos.append((nombre, instrucciones_totales, memoria_requerida))

def iniciar_simulacion(env, ram, num_procesos, intervalo_llegada, cola_procesos):
    """ Genera procesos siguiendo una distribución exponencial """
    for i in range(num_procesos):
        env.process(generar_proceso(env, f"Proceso-{i+1}", ram, cola_procesos))
        yield env.timeout(random.expovariate(1.0 / intervalo_llegada))


