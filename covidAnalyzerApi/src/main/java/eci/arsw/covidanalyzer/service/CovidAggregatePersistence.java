package eci.arsw.covidanalyzer.service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;

import eci.arsw.covidanalyzer.model.Result;
import eci.arsw.covidanalyzer.model.ResultType;

@Service
public class CovidAggregatePersistence implements ICovidAggregateService{
	
	private final List<Result> listaResult = new CopyOnWriteArrayList<>();
	
	public CovidAggregatePersistence() {
		Result result = new Result("juan", "01", ResultType.TRUE_POSITIVE);
		Result result1 = new Result("carlos", "02", ResultType.TRUE_NEGATIVE);
		Result result2 = new Result("jairo", "03", ResultType.FALSE_POSITIVE);
		Result result3 = new Result("jonathan", "04", ResultType.FALSE_NEGATIVE);
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
		
		List<Result> lista = new CopyOnWriteArrayList<>();
		
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


	/**
	@Override
	public void setResult(Result result, String name, String id, ResultType tipo) {
		int i = 0;
		for(Result r : listaResult) {
			if(id == r.getId() ) {
				
				i += 1;
				
				//r.setCantidad(i);
				result.setCantidad(i);
				
			}
			
		}
		
	}*/



	
	
	
}