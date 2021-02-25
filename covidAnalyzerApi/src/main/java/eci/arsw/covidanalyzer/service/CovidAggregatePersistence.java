package eci.arsw.covidanalyzer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import eci.arsw.covidanalyzer.model.Result;
import eci.arsw.covidanalyzer.model.ResultType;

@Service
public class CovidAggregatePersistence implements ICovidAggregateService{
	
	List<Result> listaResult = new ArrayList<Result>();
	
	public CovidAggregatePersistence() {
		Result result = new Result();
		Result result1 = new Result();
		Result result2 = new Result();
		Result result3 = new Result();
		
		result.setName("Nicolas");
		result.setLastName("Saenz");
		result.setId("01");
		result.setTipo(ResultType.TRUE_NEGATIVE);
		result.setCantidad(1);
		
		result1.setName("Leidy");
		result1.setLastName("Saenz");
		result1.setId("02");
		result1.setTipo(ResultType.TRUE_POSITIVE);
		result1.setCantidad(1);
		
		result2.setName("Stella");
		result2.setLastName("Rodriguez");
		result2.setId("03");
		result2.setTipo(ResultType.FALSE_POSITIVE);
		result2.setCantidad(1);
		
		result3.setName("Rubian");
		result3.setLastName("Reyes");
		result3.setId("04");
		result3.setTipo(ResultType.FALSE_NEGATIVE);
		result3.setCantidad(1);
		
		
		listaResult.add(result);
		listaResult.add(result1);
		listaResult.add(result2);
		listaResult.add(result3);
	}
	
	
	

	@Override
	public boolean aggregateResult(Result result, ResultType type) {
		boolean val = false;
		for(Result r : listaResult) {
			if(!r.getId().equals(result.getId())) {
				val = true;
			}
			
		}if(val == true) {
			
			listaResult.add(result);
		}
		
		
		
		return true;
	}

	@Override
	public List<Result> getResult(ResultType type) {
		
		List<Result> lista = new ArrayList<Result>();
		
		for(Result r : listaResult) {
			if(r.getTipo().equals(type)) {
				lista.add(r);
			}

		}
		
		return lista;
		
	}

	@Override
	public void upsertPersonWithMultipleTests(UUID id, ResultType type) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public List<Result> getResult() {
		
		return listaResult;
	}




	@Override
	public void setId(Result result, String id) {
		int contador = 0;
		for(Result r : listaResult) {
			if(id == r.getId()) {
				contador += 1;
				result.setCantidad(contador);
			}
		}
		
	}	
}
