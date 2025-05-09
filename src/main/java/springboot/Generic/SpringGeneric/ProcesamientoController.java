package springboot.Generic.SpringGeneric;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProcesamientoController {

    @GetMapping(

    )
    public Map<String, Object> procesar() {
        // Procesamiento: calcular la suma de los números del 1 al 100
        int suma = 0;
        for (int i = 1; i <= 100; i++) {
            suma += i;
        }

        // Crear una respuesta en formato JSON
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("mensaje", "VERSION 2");
        respuesta.put("resultado", suma);

        return respuesta;
    }
}
