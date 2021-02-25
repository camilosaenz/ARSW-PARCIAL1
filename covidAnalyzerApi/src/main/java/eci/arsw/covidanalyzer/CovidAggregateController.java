package eci.arsw.covidanalyzer;

import eci.arsw.covidanalyzer.model.Result;
import eci.arsw.covidanalyzer.model.ResultType;
import eci.arsw.covidanalyzer.service.CovidAggregatePersistence;
import eci.arsw.covidanalyzer.service.ICovidAggregateService;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CovidAggregateController {
	
	@Autowired
	ICovidAggregateService covidAggregateService;
	
	CovidAggregatePersistence covidAggregatePersistence;
    

    //TODO: Implemente todos los metodos POST que hacen falta.
	
	// METODO GET : /result - Este metodo muestra todos los resultados.

    @RequestMapping(value = "/covid/result/true-positive", method = RequestMethod.POST)
    public ResponseEntity<?> addTruePositiveResult(@RequestBody Result result) {
        //TODO
    	try {
    		covidAggregateService.aggregateResult(result, ResultType.TRUE_POSITIVE);
    		return new ResponseEntity<>(HttpStatus.CREATED);
    	}catch(Exception ex) {
    		 Logger.getLogger(CovidAggregateController.class.getName()).log(Level.SEVERE, null, ex);
 	        return new ResponseEntity<>("Error al ingresar a la pagina:",HttpStatus.FORBIDDEN);      
    	}
       
    }
    
  //METODOS POST
    
    @RequestMapping(value = "/covid/result/true-negative", method = RequestMethod.POST)
    public ResponseEntity<?> addTrueNegativeResult(@RequestBody Result result) {
        //TODO
    	try {
    		covidAggregateService.aggregateResult(result, ResultType.TRUE_NEGATIVE);
    		return new ResponseEntity<>(HttpStatus.CREATED);
    	}catch(Exception ex) {
    		 Logger.getLogger(CovidAggregateController.class.getName()).log(Level.SEVERE, null, ex);
 	        return new ResponseEntity<>("Error al ingresar a la pagina:",HttpStatus.FORBIDDEN);      
    	}
       
    }
    
    @RequestMapping(value = "/covid/result/false-positive", method = RequestMethod.POST)
    public ResponseEntity<?> addFalsePositiveResult(@RequestBody Result result) {
        //TODO
    	try {
    		covidAggregateService.aggregateResult(result, ResultType.FALSE_POSITIVE);
    		return new ResponseEntity<>(HttpStatus.CREATED);
    	}catch(Exception ex) {
    		 Logger.getLogger(CovidAggregateController.class.getName()).log(Level.SEVERE, null, ex);
 	        return new ResponseEntity<>("Error al ingresar a la pagina:",HttpStatus.FORBIDDEN);      
    	}
       
    }
    
    @RequestMapping(value = "/covid/result/false-negative", method = RequestMethod.POST)
    public ResponseEntity<?> addFalseNegativeResult(@RequestBody Result result) {
        //TODO
    	try {
    		covidAggregateService.aggregateResult(result, ResultType.FALSE_NEGATIVE);
    		return new ResponseEntity<>(HttpStatus.CREATED);
    	}catch(Exception ex) {
    		 Logger.getLogger(CovidAggregateController.class.getName()).log(Level.SEVERE, null, ex);
 	        return new ResponseEntity<>("Error al ingresar a la pagina:",HttpStatus.FORBIDDEN);      
    	}
       
    }

    //TODO: Implemente todos los metodos GET que hacen falta.
    
    //METODOS GET:
    
    @RequestMapping(value = "/covid/result", method = RequestMethod.GET)
    public ResponseEntity<?> getResults() {
        //TODO
    	try {
    		
    		return new ResponseEntity<>(covidAggregateService.getResult(), HttpStatus.ACCEPTED);
    	}catch(Exception ex) {
    		Logger.getLogger(CovidAggregateController.class.getName()).log(Level.SEVERE, null, ex);
	        return new ResponseEntity<>("Error al ingresar a la pagina: ",HttpStatus.NOT_FOUND);
    	}
    }

    @RequestMapping(value = "/covid/result/true-positive", method = RequestMethod.GET)
    public ResponseEntity<?> getTruePositiveResult() {
        //TODO
    	try {
    		
    		return new ResponseEntity<>(covidAggregateService.getResult(ResultType.TRUE_POSITIVE), HttpStatus.ACCEPTED);
    	}catch(Exception ex) {
    		Logger.getLogger(CovidAggregateController.class.getName()).log(Level.SEVERE, null, ex);
	        return new ResponseEntity<>("Error al ingresar a la pagina: ",HttpStatus.NOT_FOUND);
    	}
    }
    
    @RequestMapping(value = "/covid/result/true-negative", method = RequestMethod.GET)
    public ResponseEntity<?> getTrueNegativeResult() {
        //TODO
    	try {
    		
    		return new ResponseEntity<>(covidAggregateService.getResult(ResultType.TRUE_NEGATIVE), HttpStatus.ACCEPTED);
    	}catch(Exception ex) {
    		Logger.getLogger(CovidAggregateController.class.getName()).log(Level.SEVERE, null, ex);
	        return new ResponseEntity<>("Error al ingresar a la pagina: ",HttpStatus.NOT_FOUND);
    	}
    }
    
    @RequestMapping(value = "/covid/result/false-positive", method = RequestMethod.GET)
    public ResponseEntity<?> getFalsePositiveResult() {
        //TODO
    	try {
    		
    		return new ResponseEntity<>(covidAggregateService.getResult(ResultType.FALSE_POSITIVE), HttpStatus.ACCEPTED);
    	}catch(Exception ex) {
    		Logger.getLogger(CovidAggregateController.class.getName()).log(Level.SEVERE, null, ex);
	        return new ResponseEntity<>("Error al ingresar a la pagina: ",HttpStatus.NOT_FOUND);
    	}
    }
    
    @RequestMapping(value = "/covid/result/false-negative", method = RequestMethod.GET)
    public ResponseEntity<?> getFalseNegativeResult() {
        //TODO
    	try {
    		
    		return new ResponseEntity<>(covidAggregateService.getResult(ResultType.FALSE_NEGATIVE), HttpStatus.ACCEPTED);
    	}catch(Exception ex) {
    		Logger.getLogger(CovidAggregateController.class.getName()).log(Level.SEVERE, null, ex);
	        return new ResponseEntity<>("Error al ingresar a la pagina: ",HttpStatus.NOT_FOUND);
    	}
    }


    //TODO: Implemente el método.

    @RequestMapping(value = "/covid/result/persona/{id}", method = RequestMethod.PUT)
    public ResponseEntity savePersonaWithMultipleTests() {
        //TODO
        covidAggregateService.getResult(ResultType.TRUE_POSITIVE);
        return null;
    }
    
}