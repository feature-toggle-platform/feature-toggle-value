package com.configly.value.rule;

public interface RuleConditionValue {

    RuleConditionValueType type();

    Object typedValue();

    String asText();
}
