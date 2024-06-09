package pe.edu.cibertec.DSWII_CL1SOAP_QUEREVALUMARIA.converter;

import pe.edu.cibertec.DSWII_CL1SOAP_QUEREVALUMARIA.model.medico;
import pe.edu.cibertec.DSWII_CL1SOAP_QUEREVALUMARIA.ws.objects.medicows;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class medicoConvert {
    public medico convertmedicoWsTomedico(medicows medicows){
        medico medico = new medico();
        medico.setIdmedico(medicows.getIdmedico());
        medico.setNommedico(medicows.getNommedico());
        medico.setApemedico(medicows.getApemedico());
        medico.setDocmedico(medicows.getDocmedico());
        medico.setFechanacmedico(medicows.getFechanacmedico());
        medico.setEmailmedico(medicows.getEmailmedico());
        return medico;
    }
    public medicows convertmedicoTomedicoWs(medico medico){
        medicows medicows = new medicows();
        medicows.setIdmedico(medico.getIdmedico());
        medicows.setNommedico(medico.getNommedico());
        medicows.setApemedico(medico.getApemedico());
        medicows.setDocmedico(medico.getDocmedico());
        medicows.setFechanacmedico(medico.getFechanacmedico());
        medicows.setEmailmedico(medico.getEmailmedico());
        return medicows;
    }
    public List<medico> convertmedicoWsTomedico(
            List<medicows> medicowsList){
        List<medico> medicoList = new ArrayList<>();
        for (medicows medicows:
                medicowsList) {
            medicoList.add(convertmedicoWsTomedico(medicows));
        }
        return medicoList;
    }
    public List<medicows> convertmedicoTomedicoWs(
            List<medico> medicoList){
        List<medicows> medicowsList = new ArrayList<>();
        for (medico medico:
                medicoList) {
            medicowsList.add(convertmedicoTomedicoWs(medico));
        }
        return medicowsList;
    }
}

