package pl.paprocka.apisurveysquizzes.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionMessage {
    private String message;
    private int httpCode;
}

