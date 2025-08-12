# Conversor de Monedas en Java (API ExchangeRate)

Este es un proyecto Java basado en consola que permite convertir entre distintas monedas utilizando la API ExchangeRate-API, con soporte para tasas en tiempo real y estructura modular en varias clases.

En este caso, el proyecto se enfoca en realizar conversión del Peso Chileno como base a otras monedas.

📁 Estructura del Proyecto

<strong>conversor/</strong>
<br><strong>├── Principal.java</strong>               // *Punto de entrada del programa.*
<br><strong>├── Conversor.java</strong>            // *Contiene el menú e interacción con el usuario.*
<br><strong>└── ConsultaConversion.java</strong>     // *Realiza las solicitudes HTTP a la API utilizando el endpoint /pair.*<br>
<br>*└── RespuestaConversion.java*     // *Clase no utilizada (Se desechó en el proceso, pero puede ser útil para realizar conversión con respuestas JSON completas para un gran número de monedas).*

## Requisitos para utilizar el conversor de monedas

- Java 11 o superior.
- Gson (para parsear JSON).
- Una clave válida de ExchangeRate-API (puede conseguirse gratis).

### 🔑 Cómo configurar tu clave API en el conversor.

Reemplace la línea en ConsultaConversion.java: private static final String API_KEY = "TU_API_KEY_AQUI";
por su clave real de ExchangeRate-API.

## Monedas soportadas

La aplicación permite conversiones bidireccionales entre el Peso chileno (CLP) y las siguientes monedas:

- Peso argentino (ARS).

- Boliviano boliviano (BOB).

- Real brasileño (BRL).

- Peso colombiano (COP).

- Dólar estadounidense (USD).

- Dólar canadiense (CAD).

# Ejecución

1. Compile todos los archivos Java dentro del paquete conversor.

2. Ejecute Principal.java.

3. El programa mostrará en la terminal un mensaje de bienvenida dando a conocer las monedas que maneja la aplicación:<br>
   <img width="501" height="310" alt="image" src="https://github.com/user-attachments/assets/59289238-7d3d-418f-9e4d-60aa70d9c8c7"/><br>

4. Seguido de un menú con las diferentes opciones de conversión dispnobles junto con una opción final de salir de la aplicación:<br>
   <img width="505" height="419" alt="image" src="https://github.com/user-attachments/assets/b5161120-0342-4643-ac40-3d432a3e1906"/><br>

5. Usted deberá ingresar el número de la opción que prefiera ejecutar y presionar ENTER, por ejemplo la opción 5. CLP a BRL:<br>
   <img width="501" height="44" alt="image" src="https://github.com/user-attachments/assets/c53bf533-6528-4ab0-919f-a63a1a68b64a"/><br>

6. Luego, debe ingresar la cantidad (monto) que desea convertir y presionar ENTER:<br>
   <img width="497" height="41" alt="image" src="https://github.com/user-attachments/assets/1419b1f0-00bf-480d-b8b5-95ee82732a70"/><br>

7. La aplicación mostrará la conversión en la terminal:<br>
   <img width="500" height="66" alt="image" src="https://github.com/user-attachments/assets/1663bfcd-4e63-408b-bd01-5531bef51d23" /><br>

8. Se desplegará nuevamente el mensaje de bienvenida con el menú de opciones de conversión. Este menú se muestra después de cada conversión hasta que el usuario seleccione la opción "Salir de la aplicación".

## Errores en la ejecucion.
1. Si el usuario ingresa un número que no corresponde a las opciones del menú aparece el siguiente mensaje:<br>
   <img width="496" height="176" alt="image" src="https://github.com/user-attachments/assets/2f6f7e74-ff39-446c-909e-ab01e8e4eae6" /><br>

2. Si el usuario ingresa un valor que no es número aparece el siguiente mensaje:<br>
   <img width="498" height="178" alt="image" src="https://github.com/user-attachments/assets/f33c64a9-7e5b-4f65-80d5-615c4ae91aa3" /><br>

3. Lo mismo ocurre si no se ingresa un número al ingresar la cantidad (monto) a convertir:<br>
   <img width="497" height="108" alt="image" src="https://github.com/user-attachments/assets/69d69fd4-e375-4b94-a355-3bc2748564a1" /><br>

4. Si el usuario ingresa una cantidad (monto) igual a 0 se muestra lo siguiente:<br>
   <img width="505" height="87" alt="image" src="https://github.com/user-attachments/assets/176399fa-4131-4fc5-926b-63adff0151e6" /><br>

5. Si ocurre algún error en la respuesta de la API, el usuario verá un mensaje de error como el siguiente:<br>
   <img width="369" height="22" alt="image" src="https://github.com/user-attachments/assets/275381d6-bb9e-45e7-af5c-f0180d1163fe" /><br>
   Dónde e.getMessage() corresponderá al detalle del error ocurrido.

## Librerías externas

Este programa utiliza:

- HttpClient, HttpRequest y HttpResponse (desde Java 11).
- Gson para el parseo de JSON. Si se usa Maven, puede incluirse con:
````
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.10.1</version>
</dependency>
````
## Notas

La clase RespuestaConversion fue diseñada inicialmente para mapear respuestas JSON completas, pero luego no fue necesaria pues se decidió utilizar el endpoint /pair de la API.

### Futuras mejoras

- Soporte para más monedas.
- Interfaz gráfica (Swing o JavaFX).
- Registro de historial de conversiones.

# Autor

Desarrollado por Jaime Lira García como ejercicio educativo de Oracle ONE con Alura Latam, para entender el consumo de APIs con Java.