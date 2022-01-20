# NavegantesMaritimos2018

  Trabajo Práctico Final para la materia Estructura de Datos de la Universidad Nacional del Comahue (UNCo).
  ![alt imagenEjemplo](https://github.com/Fedeag-92/NavegantesMaritimos2018/blob/main/NavegantesRun.JPG?raw=true)
## Construido con 🛠️

  - [Java](https://www.w3schools.com/java/default.asp) - Lenguaje utilizado.

  - [NetBeans](https://netbeans.apache.org/) - Entorno de desarrollo utilizado.
 
## Requerimientos del sistema 📄
Se desea implementar un sistema de información para navegantes marítimos. </br>
Para administrar el sistema es necesario contar con información de todas los puertos en una Tabla de
Búsqueda. De cada puerto se almacena la siguiente información: nombre, país, cantidad de dársenas, las
dársenas con los datos del barco amarrado en cada una, y los barcos que desean ingresar al puerto.</br>
Como requerimiento de implementación, se pide representar la Tabla de Búsqueda mediante una estructura de árbol AVL, donde el orden de los puertos está dado por su nombre (identificador unívoco).</br>
Además, es necesario guardar, mediante un grafo, los datos de todas las rutas marítimas que unen los
puertos, indicando su distancia en millas marinas. Ejemplo, entre los puertos de Mar del Plata y Cabo
Buena Esperanza (Sudáfrica) hay una distancia de 4164.78 millas marinas (6702.57 km).</br>
El movimiento de cada puerto se administra, por un lado, con las dársenas ocupadas por barcos, y por
otro lado, mediante una cola de prioridad en la que se almacenan los datos de los barcos que desean ingresar al puerto. Los barcos están identificados por un código o nombre, tipo, y una bandera (país del
cual proceden). Para el tipo de barco, se distingue entre barcos pesqueros, barcos de pasajeros y barcos
de carga, dato que les marca la prioridad de ingreso al puerto; los barcos de pesca deben ingresar lo más
urgente posible para evitar que el pescado se estropee, a continuación los barcos de pasajeros y por último los barcos de carga, ya que se considera que su carga es no-perecedera. Los barcos deben almacenarse en una Tabla Hash por su código o nombre.</br>
Realizar una clase NavegantesMarítimos que contenga un menú que permita las siguientes tareas:</br>
1. Alta y baja de un puerto (recordar que cada puerto está almacenado en la tabla de búsqueda y
también en el grafo).
2. Alta y baja de una ruta marítima (arco entre dos puertos).
3. Alta de barcos en una Tabla Hash.
4. Dados 2 nombres de puertos P1 y P2, mostrar todos los puertos cuyo nombre se encuentren
alfabéticamente en dicho rango (recorriendo la estructura de la manera más eficiente).
5. Dado un barco B y 2 puertos O y D, de origen y destino respectivamente, verificar si B está
en alguna dársena de O y hacer que B viaje hasta D (y se coloque en la cola de espera para
ingresar al puerto D).
6. Dados 2 puertos, O y D, y una cantidad de millas marítimas M, verificar si existe algún
camino para ir desde O hasta D y que no supere M millas en total.
7. Dados 2 puertos O y D, devolver el camino que pasa por menos puertos desde O hasta D. El
camino que debe devolver será una lista de puertos.8. Mostrar todos los puertos ordenados alfabéticamente.
9. Dado un puerto P, actualizar el ingreso de barcos a las dársenas, es decir, si hay alguna
dársena libre, hacer ingresar al barco que esté primero en orden de prioridad, hasta
completar todas las dársenas.
10. Dado un barco B, mostrar todos sus datos.
11. Dado un puerto P, mostrar los barcos en espera a ingresar según la prioridad definida por el
tipo de barco.
12. Dados 3 puertos O, D y N, devolver un camino que pase por O y D, pero no pase por N. El
camino que debe devolver es una lista de puertos.
13. Dados 2 puertos O y D, devolver la menor cantidad de millas marítimas a realizar para llegar
desde O hasta D.
14. Listar todos los puertos que tienen barcos en espera.
15. Ejecutar un “script de carga” de al menos 15 puertos y con al menos 25 rutas marítimas, y al
menos 5 barcos que desean ingresar a un determinado puerto. El día de la presentación del
trabajo, traer en papel un diagrama de los datos cargados. Se pueden consultar puertos y
distancias en el sitio http://www.searates.com/es/reference/portdistance/
Para fines prácticos de la corrección y verificación de las estructuras, es necesario contar además con
opciones del menú que permitan mostrar la información almacenada en cada estructura utilizada, de
manera que pueda verse quién está conectado con quién (si es un grafo ver sus adyacentes o si es un
árbol ver quienes son hijos de quién)
  
## Autores ✒️

- **Federico Aguilera** - [Fedeag-92](https://github.com/Fedeag-92)
