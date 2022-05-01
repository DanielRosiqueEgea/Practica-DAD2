# Practica-DAD2
Practica de Desarrollo de Aplicaciones Distribuidas 2 en la UCAM de Murcia.

La practica consiste en la creacion de una app ERP con Java y Apache Tomcar para crear un servidor web operativo

# Modificacion 01/05/2022 Por Roxoner44:
## Cambios:
### Cambio 1: optimizado import del paquete de acciones

![image](https://user-images.githubusercontent.com/58725397/166156314-a59df03f-6eed-45ce-a42d-18ecfa6ffc0b.png)

### Cambio 2: Creacion de AccionIR para evitar la explosion de clases "IR"->se eliminan 9 acciones para dejar solo 1

![image](https://user-images.githubusercontent.com/58725397/166156426-55cd5aa6-060d-43d4-8619-8e207ffa8516.png)

### Cambio 3: A peticion de Alexevers -> organizacion en subcarpetas de las acciones

![image](https://user-images.githubusercontent.com/58725397/166157342-ba3738f8-1143-426e-95fb-eb2cc040c066.png)


### Cambio 4: Creacion de Nickname de forma dinamica para usarlo como clave de la hashtable Usuarios
Como el hashtable es de <String, Usuario> nos da igual usar el nickname o la Clave, pero es mejor usar un nickname que se genere automaticamente para evitar filtraciones de contraseña (alguien quiere registrarse y a ver que esa contraseña ya existe prueba con todos los nombres de usuario posible, por ejemplo)

El nickname se va a generar mediante el nombre y el apellido de la siguiente forma:

```java
String nick = name[0] + surname;
String nickname = nick;
int i=0;
while(usuarios.containsKey(nickname)){
nickname = nick + i;
}
```
De esta forma si por ejemplo hubiesen 6 personas que se llamasen Dani Rosique (o David Rosique) la primera tendría el nickname drosique, la siguiente drosique1 y así hasta drosique6

### Cambio 5: Cambio en Accion Login
Ahora solo se inicializa el objeto User si ya existe dentro de la hashtable o si es admin. Tambien tiene en cuenta el nickname en lugar del name.
```java
String nicknameAdmin = "admin";
```
A la hora de hacer login he añadido el metodo validtePass() dentro del Usuario, nos ahorra poco pero es utíl y queda un poco más estetico

Pasamos de esto:
```java
usuarios.get(nickname).getPass().equals(pass)
```
A esto:
```java
usuatios.get(nickname).validatePass(pass)
```

# Propuestas:
Cifrado de contraseña usando mk5
