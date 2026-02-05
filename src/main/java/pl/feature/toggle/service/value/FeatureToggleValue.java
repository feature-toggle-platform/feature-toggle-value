package pl.feature.toggle.service.value;

public interface FeatureToggleValue {

    String asText();

    FeatureToggleValueType type();

    default String typeName(){
        return type().name();
    }

}
