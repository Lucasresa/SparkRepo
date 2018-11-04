package server;

import spark.Spark;
import spark.debug.DebugScreen;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Server {
	public static void main(String[] args) {
		Spark.port(9000); //Escuchar en el puerto...
		//Creo un motor de templates
		HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
		
		
		/*
		Spark.get("/saludar/:persona", (request,response)->{ //Metodo para parametrizar un pedido del cliente
			
			//los parametros seran obligatorios, si no le mandas nada tira error 404
			String persona=request.params("persona"); //Le digo que el parametro sera persona
			
			return "<html><body><h1>HOLA "+ persona + "!!</h1></body></html>";
		}); //Metodo para devolver una respuesta al cliente cuando haga una req de "/" | Las respuestas son en texto
		*/
		//Query params - otra forma
		
		Spark.get("/saludar", (req,res)->{
			String persona = req.queryParams("persona");
			return "<html><body><h1>HOLA "+ persona + "!!</h1></body></html>";
		});
		
		//Agrego el engine para que use el handlebars
		Spark.get("/convertir", Controller::convertir, engine); // Controller:convertir para simplificar (deberia crear la clase controller)
		
		
		Spark.init(); //Arrancar a escuchar conexiones
		
		//Para ayudar a encontrar donde estan los errores
		//Solo habilitarlo para desarrollo
		DebugScreen.enableDebugScreen();
	}

}

//Motor de templates : handlebars -- para evitar el uso de codigo html en el controller
