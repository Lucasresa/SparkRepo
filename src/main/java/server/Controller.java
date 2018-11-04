package server;

import java.util.*;

import spark.*;

public class Controller {

	public static ModelAndView convertir(Request req, Response res) {
		double celsius = Double.parseDouble(req.queryParams("celsius"));
		
		double kelvin = new Conversor().convertir(celsius); //Delego esto a otra clase para poder reutilizar codigo 
		// y para mejorar el testing
		
		//return "<html><body>Conversion: "+kelvin +"</body></html>";
		//ModelAndView(modelo, Nombre de la vista)
		
		Map<String, Object> viewModel = new HashMap<>();
		viewModel.put("celsius", celsius);
		viewModel.put("kelvin", kelvin);
		
		return new ModelAndView(viewModel, "kelvin.hbs");
	}
	
	
}
