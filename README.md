# Código Hands-On Full Stack Development with Spring Boot 2.0 and React.

Repositorio con mi versión del backend del libro Hands-On Full Stack Development with Spring Boot 2.0 and React.

## Seguridad

### Obtener el JWT

```shellscript
curl -s --header "Content-Type: application/json" -X POST -d '{"username":"admin", "password":"admin"}' -D - http://localhost:8080/login
```

Lo guardamos en una variable de entorno para usarlo en las solicitudes:

```shellscript
TOKEN=$(curl -s --header "Content-Type: application/json" -X POST -d '{"username":"admin", "password":"admin"}' -D - http://localhost:8080/login | grep Authorization: | awk '{print $3}')
```

### Usar el JWT

Para usarlo en una llamada:

```shellscript
curl -H 'Accept: application/json' -H "Authorization: Bearer ${TOKEN}" http://localhost:8080/api/cars
```
