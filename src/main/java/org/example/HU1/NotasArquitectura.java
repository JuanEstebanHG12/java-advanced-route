package org.example.HU1;

public class NotasArquitectura {

    /*
     * ============================================
     * Java 8 (Legacy)
     * ============================================
     *
     * 1. Streams y Lambdas fueron introducidos por primera vez,
     *    pero algunas APIs todavía eran muy verbosas.
     * 2. Optional se introdujo, pero su uso no estaba totalmente
     *    extendido en frameworks legacy.
     * 3. La inmutabilidad se tenía que reforzar manualmente
     *    mediante patrones o clases finales.
     * 4. Se dependía mucho de interfaces tradicionales
     *    y clases abstractas para diseño.
     * 5. Record y sealed classes NO existían.
     * 6. Módulos NO disponibles (Java 9 introdujo módulos).
     * 7. Soporte limitado para pattern matching, switch expressions,
     *    text blocks, y null safety helpers.
     *
     */

    /*
     * ============================================
     * Java 17/21 (LTS Actual)
     * ============================================
     *
     * 1. Records: simplifican la creación de clases inmutables
     *    con menos código boilerplate.
     * 2. Pattern Matching: permite checks más claros en instanceof
     *    y switch expressions más potentes.
     * 3. Text Blocks: manejo de strings multilínea más limpio.
     * 4. Sealed Classes: controlan qué clases pueden extenderlas.
     * 5. Mejor integración con Optional y Streams.
     * 6. Garbage Collector mejorado (ZGC, G1 GC optimizado).
     * 7. APIs modernas para fechas, colecciones y concurrente.
     * 8. Java 21 incluye Virtual Threads (Project Loom) para
     *    concurrencia más eficiente.
     *
     * En general, las versiones actuales fomentan:
     * - Código más conciso y expresivo.
     * - Inmutabilidad por defecto.
     * - Patrones de diseño más seguros y fáciles de leer.
     * - Mejor rendimiento y escalabilidad.
     */

    public static void main(String[] args) {
        System.out.println("Clase de notas de arquitectura Java 8 vs 17/21");
    }
}
