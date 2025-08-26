package br.com.yukita.liggaProject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BoredApiResponse(
        String activity,
        int availability,
        String type,
        int participants,
        double price,
        String accessibility,
        String duration,
        @JsonProperty("kidFriendly") boolean kidFriendly,
        String link,
        String key
)
{ }
