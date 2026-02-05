package pl.feature.toggle.service.value.raw;

public record FeatureToggleRawValue(
        String value
) {

    public static FeatureToggleRawValue of(String value) {
        return new FeatureToggleRawValue(value);
    }
}
