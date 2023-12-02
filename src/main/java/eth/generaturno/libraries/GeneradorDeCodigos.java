package eth.generaturno.libraries;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Random;

public class GeneradorDeCodigos {

    private HashMap<Integer, Character> mapaHorasLetras;
    private HashMap<Integer, Integer> contadorPorIntervalo;
    private LocalDateTime ultimaActualizacion;
    private final int intervaloEnMinutos;

    public GeneradorDeCodigos(int intervaloEnMinutos) {
        this.intervaloEnMinutos = intervaloEnMinutos;
        ultimaActualizacion = LocalDateTime.now();
        generarMapaHorasLetras();
        inicializarContadores();
    }

    private void generarMapaHorasLetras() {
        mapaHorasLetras = new HashMap<>();
        Random random = new Random();

        for (int i = 0; i < 24 * 60 / intervaloEnMinutos; i++) {
            char letraAleatoria;
            do {
                letraAleatoria = (char) ('A' + random.nextInt(26));
            } while (mapaHorasLetras.containsValue(letraAleatoria));

            mapaHorasLetras.put(i, letraAleatoria);
        }
    }

    private void inicializarContadores() {
        contadorPorIntervalo = new HashMap<>();
        for (int i = 0; i < 24 * 60 / intervaloEnMinutos; i++) {
            contadorPorIntervalo.put(i, 1);
        }
    }

    public String generarCodigo() {
        verificarYActualizar();
        int intervaloActual = LocalDateTime.now().getHour() * 60 + LocalDateTime.now().getMinute();
        intervaloActual /= intervaloEnMinutos;

        char letra = mapaHorasLetras.getOrDefault(intervaloActual, 'A');
        int contador = contadorPorIntervalo.getOrDefault(intervaloActual, 1);
        contadorPorIntervalo.put(intervaloActual, contador + 1);
        return letra + String.format("%02d", contador);
    }

    private void verificarYActualizar() {
        LocalDateTime ahora = LocalDateTime.now();
        if (ahora.toLocalDate().isAfter(ultimaActualizacion.toLocalDate()) || ahora.getHour() * 60 + ahora.getMinute() / intervaloEnMinutos != ultimaActualizacion.getHour() * 60 + ultimaActualizacion.getMinute() / intervaloEnMinutos) {
            ultimaActualizacion = ahora;
            generarMapaHorasLetras();
            inicializarContadores();
        }
    }
}
