package pl.feature.toggle.service.model.exception;

import pl.feature.toggle.service.model.featuretoggle.value.FeatureToggleValueType;

public class UnsupportedFeatureToggleType extends RuntimeException {
    public UnsupportedFeatureToggleType(FeatureToggleValueType type) {
        super("Unsupported feature toggle type: " + type);
    }

    public UnsupportedFeatureToggleType() {
        super("Feature toggle type is missing.");
    }

    public UnsupportedFeatureToggleType(String rawType) {
        super("Unsupported feature toggle type: " + rawType);
    }
}
