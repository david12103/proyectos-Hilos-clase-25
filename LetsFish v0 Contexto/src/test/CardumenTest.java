package test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Cardumen;
import modelo.Coordenada;
import modelo.EspeciePez;

class CardumenTest {
	// Datos de prueba
	EspeciePez especie;
	Coordenada posicion;
	int pesoInicial; // Peso inicial del cardumen
	double velocidadRegeneracion;
	// Crear el cardumen
	Cardumen cardumen;

	@BeforeEach
	void before() {
		// Datos de prueba
		especie = EspeciePez.ATUN;
		posicion = new Coordenada(0, 0);
		pesoInicial = 1000; // Peso inicial del cardumen
		velocidadRegeneracion = 10;
		// Crear el cardumen
		cardumen = new Cardumen(especie, posicion, pesoInicial, velocidadRegeneracion);
	}

	@Test
	void testMovimiento() {
		int cantidad = 100;
		for (int i = 0; i < cantidad; i++) {
			Coordenada antigua = new Coordenada(cardumen.getPosicion());
			cardumen.mover();
			assertNotEquals(antigua, cardumen.getPosicion());
		}
	}

	@Test
	void testIsLimiteAlcanzado() {
		// Comprobar que no ha alcanzado el l�mite biol�gico al inicio
		assertFalse(cardumen.isLimiteAlcanzado(),
				"El cardumen no deber�a haber alcanzado el l�mite biol�gico al inicio.");
		int pesca = 0;
		// Simular pesca para reducir el peso a justo el l�mite biol�gico
		int capacidad = 1000;
		synchronized (cardumen) {
			for (int i = 0; i < capacidad; i++) {
				pesca += cardumen.pescar();
			}
		}
		assertNotEquals(pesca, capacidad);
		// Comprobar que ahora ha alcanzado el l�mite biol�gico
		assertEquals(cardumen.getPeso() + pesca, cardumen.getPesoInicial());
		assertTrue(cardumen.isLimiteAlcanzado(), "El cardumen deber�a haber alcanzado el l�mite biol�gico.");
	}

	@Test
	void testIsLimiteAlcanzadoBelowLimit() {

		int pesca = 0;
		int capacidad = 10;
		// Reducir el peso, pero mantenerlo por encima del l�mite biol�gico
		synchronized (cardumen) {
			for (int i = 0; i < capacidad; i++) {
				pesca += cardumen.pescar();
			}
		}
		// Comprobar que no ha alcanzado el l�mite biol�gico
		assertFalse(cardumen.isLimiteAlcanzado(), "El cardumen no deber�a haber alcanzado el l�mite biol�gico.");
	}
	
	@Test
	void testRegeneracionCardumen() {
		int pesca=600;
		for (int i = 0; i < pesca; i++) {
			cardumen.pescar();
		}
		double peso = cardumen.getPeso();
		cardumen.regenerar();
		assertNotEquals(peso,cardumen.getPeso());
		assertEquals(peso+velocidadRegeneracion,cardumen.getPeso());
	}
}
