package guru.springframework.spring5webapp;

import guru.springframework.spring5webapp.domain.Result;
import jakarta.persistence.AttributeConverter;

public class ResultConverter implements AttributeConverter<Result, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Result result) {
        return switch (result) {
            case FAILED -> 0;
            case PASSED -> 1;
        };
    }

    @Override
    public Result convertToEntityAttribute(Integer integer) {
        return switch (integer) {
            case 0 -> Result.FAILED;
            case 1 -> Result.PASSED;
            default -> throw new IllegalStateException("Unexpected value: " + integer);
        };
    }
}
