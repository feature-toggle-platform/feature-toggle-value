package com.configly.value;


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
