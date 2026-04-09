package com.configly.value.rule;

import java.math.BigDecimal;

import static java.util.Objects.isNull;

record NumberRuleConditionValue(
        BigDecimal value
) implements RuleConditionValue {

    static NumberRuleConditionValue create(String value) {
        if (isNull(value)) {
            throw new WrongRuleConditionValue();
        }

        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new WrongRuleConditionValue(value);
        }

        try {
            return new NumberRuleConditionValue(new BigDecimal(normalized));
        } catch (NumberFormatException ex) {
            throw new WrongRuleConditionValue(value);
        }
    }

    public static NumberRuleConditionValue create(Number value) {
        return NumberRuleConditionValue.create(value.toString());
    }

    @Override
    public String asText() {
        return value.toPlainString();
    }

    @Override
    public Object typedValue() {
        return value;
    }

    @Override
    public RuleConditionValueType type() {
        return RuleConditionValueType.NUMBER;
    }
}
