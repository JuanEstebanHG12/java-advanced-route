# Gestión de Objetos en la JVM y Optimización de Memoria

## 1. Introducción

La **Java Virtual Machine (JVM)** es responsable de ejecutar aplicaciones Java y de gestionar la memoria de manera eficiente. Uno de los componentes clave de la JVM es el **Garbage Collector (GC)**, encargado de liberar memoria automáticamente al eliminar objetos que ya no son referenciados.

---

## 2. La Memoria en la JVM

La memoria de la JVM se divide en varias áreas:

### 2.1 Heap
- Almacena los **objetos creados dinámicamente** (`new`).
- Se divide en:
    - **Young Generation**: objetos recién creados. Se recolectan frecuentemente.
        - **Eden**: espacio donde se crean la mayoría de los objetos.
        - **Survivor Spaces**: objetos que sobreviven a varias colecciones cortas pasan aquí.
    - **Old (Tenured) Generation**: objetos de larga vida.
- Objetos que viven mucho tiempo son promovidos de Young a Old Generation.

### 2.2 Stack
- Contiene variables locales y referencias a objetos en Heap.
- Cada hilo tiene su propio stack.
- Se limpia automáticamente al salir del scope de la variable.

### 2.3 Metaspace
- Almacena metadata de clases.
- Reemplaza al antiguo PermGen desde Java 8.
- Crece dinámicamente según necesidad.

---

## 3. El Garbage Collector (GC)

El GC es responsable de **identificar y eliminar objetos no referenciados** para liberar memoria.
### Tipos de recolección
- **Minor GC**: se ejecuta en Young Generation. Es rápido y frecuente.
- **Major/Full GC**: se ejecuta en Old Generation. Es más lento, pero libera objetos de larga vida.

### Algoritmos comunes
- **Mark-and-Sweep**: marca objetos accesibles y elimina los no marcados.
- **Generational GC**: separa objetos por edad para optimizar la recolección.
- **G1 GC (Garbage First)**: divide la heap en regiones y recolecta de forma concurrente.
- **ZGC / Shenandoah (Java 17/21)**: GC de baja latencia para aplicaciones grandes y concurrentes.

---

## 4. Optimización de Memoria

- **Promoción de objetos**: objetos que sobreviven a varias colecciones cortas son promovidos a Old Generation, reduciendo el costo de recolección frecuente.
- **Compactación**: GC mueve objetos activos para eliminar fragmentación y mejorar la asignación de memoria.
- **Escape Analysis**: la JVM puede determinar si un objeto no escapa de un método y asignarlo en la stack en lugar de heap.
- **Soft y Weak References**: permiten que ciertos objetos sean recolectados antes bajo presión de memoria.

---

## 5. Buenas prácticas para optimizar memoria

- Evitar referencias innecesarias a objetos.
- Usar colecciones adecuadas con tamaños estimados correctamente.
- Prefiere objetos inmutables cuando sea posible.
- Monitorear el uso de heap y el comportamiento del GC (JVM flags: `-Xmx`, `-Xms`, `-XX:+UseG1GC`, etc.).
- Liberar recursos externos manualmente (`close()`, `try-with-resources`).

---

## 6. Conclusión

La combinación de la **JVM** y el **Garbage Collector** permite a Java gestionar la memoria de forma automática y eficiente, reduciendo fugas de memoria y optimizando el rendimiento del sistema.  
Entender cómo funcionan estas herramientas ayuda a escribir aplicaciones más eficientes y predecibles.