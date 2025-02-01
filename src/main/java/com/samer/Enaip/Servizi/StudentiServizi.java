package com.samer.Enaip.Servizi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.samer.Enaip.Ripository.StudentiRepository;
import com.samer.Enaip.modelli.Studenti;


@Service
public class StudentiServizi {
	@Autowired
	StudentiRepository stRp;
	
	public long ListaStudenti() {
		return stRp.count();
	}
	public List<Studenti> stampaAll(){
		return stRp.findAll(Sort.by(Sort.Direction.DESC,"matricola"));
	}
	
	public Studenti getStudentiById(long matrciola) {
		return stRp.findById(matrciola).orElse(null);
	}
	
	public void saveUser(Studenti studente) {


        if (studente.getMatricola()!= null) {
            Optional<Studenti> existingUser = stRp.findById(studente.getMatricola());
            if (existingUser.isPresent()) {
                Studenti updatedUser = existingUser.get();
                updatedUser.setNome(studente.getNome());
                updatedUser.setCognome(studente.getCognome());
                updatedUser.setEmail(studente.getEmail());
                updatedUser.setCell(studente.getCell());
                stRp.save(updatedUser);
                
            }
        }
        stRp.save(studente);
    }
	public void deleteStudente(Long matricola) {
		stRp.deleteById(matricola);
	}
	
	

}
