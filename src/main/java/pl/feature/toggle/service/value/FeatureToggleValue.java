package pl.feature.toggle.service.value;

public interface FeatureToggleValue {

    String asText();

    Object typedValue();

    FeatureToggleValueType type();

    default String typeName(){
        return type().name();
    }

}
