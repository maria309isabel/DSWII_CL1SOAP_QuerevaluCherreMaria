package pe.edu.cibertec.DSWII_CL1SOAP_QUEREVALUMARIA.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class medicoEndPoint {



    private static final String NAMESPACE_URI = "http://www.DSWII_CL1SOAP_QuerevaluMaria.com/ws/objects";
    @Autowired
    private medicoRepository medicoRepository;
    @Autowired
    private medicoConvert medicoConvert;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getmedicosRequest")
    @ResponsePayload
    public GetmedicosResponse getmedicos(@RequestPayload
                                             GetmedicosRequest request){
        GetmedicosResponse response = new GetmedicosResponse();
        List<medicows> medicowsList = medicoConvert
                .convertmedicoTomedicoWs(medicoRepository.findAll());
        response.getmedicos().addAll(medicowsList);
        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getmedicoRequest")
    @ResponsePayload
    public GetmedicoResponse getmedicosXId(@RequestPayload
                                               GetmedicoRequest request){
        GetmedicoResponse response = new GetmedicoResponse();
        medicows medicows = medicoConvert
                .convertmedicoTomedicoWs(
                        medicoRepository.findById(request.getId()).get());
        response.setmedico(medicows);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postmedicoRequest")
    @ResponsePayload
    public PostmedicoResponse postmedico(@RequestPayload
                                             PostmedicoRequest request){
        PostmedicoResponse response = new PostmedicoResponse();
        medico newmedico =
                medicoConvert.convertmedicoWsTomedico(
                        request.getmedico());
        medicows newmedicows =
                medicoConvert.convertmedicoTomedicoWs(
                        medicoRepository.save(newmedico)
                );
        response.setmedico(newmedicows);
        return response;
    }

}

