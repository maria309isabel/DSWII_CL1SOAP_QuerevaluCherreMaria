package pe.edu.cibertec.soap.converter;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.soap.model.Medico;
import pe.edu.cibertec.ws.objects.Medicows;

import java.util.*;

@Component
public class MedicoConvert {


    private Date convertXMLGregorianCalendarToDate(XMLGregorianCalendar xmlGregorianCalendar) {
        if (xmlGregorianCalendar == null) {
            return null;
        }
        return xmlGregorianCalendar.toGregorianCalendar().getTime();
    }

    private XMLGregorianCalendar convertDateToXMLGregorianCalendar(Date date) {
        if (date == null) {
            return null;
        }

        try {
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(date);
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Medico convertMedicoWsToMedico(Medicows medicows) {
        Medico medico = new Medico();

        medico.setIdmedico(medicows.getIdMedico());
        medico.setNommedico(medicows.getNomMedico());
        medico.setApeme(medicows.getApeMedico());
        Date fechaNacimiento = convertXMLGregorianCalendarToDate(medicows.getFechNacMedico());
        medico.setFechnac(fechaNacimiento);

        return medico;
    }

    public Medicows convertMedicoToMedicoWs(Medico medico) {
        Medicows medicows = new Medicows();

        medicows.setIdMedico(medico.getIdmedico());
        medicows.setNomMedico(medico.getNommedico());
        medicows.setApeMedico(medico.getApeme());
        XMLGregorianCalendar fechaNacimiento = convertDateToXMLGregorianCalendar(medico.getFechnac());
        medicows.setFechNacMedico(fechaNacimiento);

        return medicows;
    }

    public List<Medico> convertMedicoWsToMedico(List<Medicows> pacientewsList) {
        List<Medico> pacienteList = new ArrayList<>();
        for (Medicows medicows : pacientewsList) {
            pacienteList.add(convertMedicoWsToMedico(medicows));
        }
        return pacienteList;
    }

    public List<Medicows> convertMedicoToMedicoWs(List<Medico> medicos) {
        List<Medicows> medicowsList = new ArrayList<>();
        for (Medico medico : medicos) {
            medicowsList.add(convertMedicoToMedicoWs(medico));
        }
        return medicowsList;
    }



}
