package com.springboot.rest.webservices.rest_full_web_services.user;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;


//la anotacion componente hace que spring maneje este componente

//Este componente DAO lo utilizaremos para recuperar datos de Base de datos

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
//	creamos unavariable estatica que solo defina el inicio del conteo de los usuarios 
	private static int userCount = 0;
	
	
	static {
		users.add(new User(++userCount, "Ramiro", LocalDate.now().minusYears(90)));
		users.add(new User(++userCount, "Fer", LocalDate.now().minusYears(100)));
		users.add(new User(++userCount, "Vale", LocalDate.now().minusYears(80)));
		users.add(new User(++userCount, "Titis", LocalDate.now().minusYears(80)));
		users.add(new User(++userCount, "Jime", LocalDate.now().minusYears(90)));
	}
	
//	metodo que resuelve una lista de tipo user que regresa a su vez todos los usuarios 
	public List<User> findAll(){
		return users;
	}
	
//	metodo para Devolver soolo un usuario
	
	public User findOneUser( int id ) {
		
//		utilizamos la programacion funcional para obtener mediante una funcion lamda el id de los usuarios comparado con el id que recibimos por parametro
		
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		
//		con el stream nos devuelve una lista de users que despues filtraremos con el resultado del predicado nos dara el primer elemento
//		con el getFirst optenemos el primer valor que coicida con el predicado si no en cuantra lanzara una escepcion
//		sin embargo con el orElse estaremos devolviendo un error personalizado
		return users.stream().filter(predicate).findFirst().orElse(null);		
	}
	
	public User save(User user) {
//		con el metodo set, colocaremos los valore que vamos acumulando
		user.setId(++userCount);
		users.add(user);
		return user;
	}
	
	public void deleteById( int id ) {
		
//		utilizamos la programacion funcional para obtener mediante una funcion lamda el id de los usuarios comparado con el id que recibimos por parametro
		
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}
	

	
}
