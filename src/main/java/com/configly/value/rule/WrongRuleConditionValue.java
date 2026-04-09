package com.configly.value.rule;

import java.util.Collection;

public class WrongRuleConditionValue extends RuntimeException {
    public WrongRuleConditionValue(String value, String... allowedValues) {
        super("Wrong rule condition value:" + value + ". Allowed values: " + String.join(", ", allowedValues));
    }

    public WrongRuleConditionValue(String value, Collection<String> allowedValues) {
        super("Wrong rule condition value:" + value + ". Allowed values: " + allowedValues);
    }

    public WrongRuleConditionValue() {
        super("Rule condition value is missing.");
    }
}
