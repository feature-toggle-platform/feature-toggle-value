package pl.feature.toggle.service.model.exception;

import java.util.Collection;

public class WrongFeatureToggleValue extends RuntimeException {
    public WrongFeatureToggleValue(String value, String... allowedValues) {
        super("Wrong feature toggle value:" + value + ". Allowed values: " + String.join(", ", allowedValues));
    }

    public WrongFeatureToggleValue(String value, Collection<String> allowedValues) {
        super("Wrong feature toggle value:" + value + ". Allowed values: " + allowedValues);
    }

    public WrongFeatureToggleValue() {
        super("Feature toggle value is missing.");
    }
}
