package com.configly.value.toggle;

public record FeatureToggleValueSnapshot(
        String value
) {

    public static FeatureToggleValueSnapshot of(String value) {
        return new FeatureToggleValueSnapshot(value);
    }
}
