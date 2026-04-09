package com.configly.value.toggle;

public interface FeatureToggleValue {

    String asText();

    Object typedValue();

    FeatureToggleValueType type();

    default String typeName(){
        return type().name();
    }

}
