package br.com.yukita.liggaProject.service;

import br.com.yukita.liggaProject.dto.BoredApiResponse;
import br.com.yukita.liggaProject.entity.Activity;
import br.com.yukita.liggaProject.repository.ApiRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class BoredService {
    private final ApiRepository apiRepository;

    public BoredService(ApiRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    public BoredApiResponse getResponseFromApi() {
        String url = "https://bored-api.appbrewery.com/random";

        RestTemplate restTemplate = new RestTemplate();
        BoredApiResponse response = restTemplate.getForObject(url, BoredApiResponse.class);
        if (response != null) {
            saveResponse(response);
        }
        return response;
    }

    public void saveResponse(BoredApiResponse response) {
        Activity activity = new Activity(
                response.activity(),
                response.type(),
                response.participants(),
                response.price(),
                response.accessibility(),
                response.duration(),
                response.kidFriendly(),
                response.link(),
                response.key()
        );

        if (activity != null) {
            apiRepository.save(activity);
        }
    }

    public List<Activity> listAll(Map<String, String> filtros) {
        List<Activity> response = apiRepository.findAll();

        if (filtros != null) {
            return response.stream()
                    .filter(f -> filtros.get("type") == null || f.getType().equalsIgnoreCase(filtros.get("type")))
                    .filter(f -> filtros.get("key") == null || f.getKeyCode().equalsIgnoreCase(filtros.get("key")))
                    .filter(f -> filtros.get("isKidFriendly") == null || f.isKidFriendly() == Boolean.parseBoolean(filtros.get("isKidFriendly")))
                    .filter(p -> filtros.get("price") == null || p.getPrice() == Double.parseDouble(filtros.get("price")))
                    .toList();
        }

        return response;
    }

}
