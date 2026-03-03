package pl.feature.toggle.service.value;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchException;

class BooleanFeatureToggleValueTest {

    @Test
    void should_throw_exception_when_value_is_null() {
        // given && when
        var exception = catchException(() -> BooleanFeatureToggleValue.create(null));

        // then
        assertThat(exception).isNotNull()
                .isInstanceOf(WrongFeatureToggleValue.class)
                .hasMessageContaining("Feature toggle value is missing");
    }

    @Test
    void should_throw_exception_when_value_is_empty() {
        // given && when
        var exception = catchException(() -> BooleanFeatureToggleValue.create(" "));

        // then
        assertThat(exception).isNotNull()
                .isInstanceOf(WrongFeatureToggleValue.class)
                .hasMessageContaining("Wrong feature toggle value: ");
    }

    @Test
    void should_throw_exception_when_value_is_invalid() {
        // given && when
        var exception = catchException(() -> BooleanFeatureToggleValue.create("invalid"));

        // then
        assertThat(exception).isNotNull()
                .isInstanceOf(WrongFeatureToggleValue.class)
                .hasMessageContaining("Wrong feature toggle value:invalid");
    }

    @Test
    void should_create_boolean_true_feature_toggle_value_from_string() {
        // given && when
        var featureToggleValue = BooleanFeatureToggleValue.create("true");

        // then
        assertThat(featureToggleValue).isNotNull();
        assertThat(featureToggleValue.value()).isTrue();
        assertThat(featureToggleValue.type()).isEqualTo(FeatureToggleValueType.BOOLEAN);
        assertThat(featureToggleValue.asText()).isEqualTo("TRUE");
    }

    @Test
    void should_create_boolean_false_feature_toggle_value_from_string() {
        // given && when
        var featureToggleValue = BooleanFeatureToggleValue.create("false");

        // then
        assertThat(featureToggleValue).isNotNull();
        assertThat(featureToggleValue.value()).isFalse();
        assertThat(featureToggleValue.type()).isEqualTo(FeatureToggleValueType.BOOLEAN);
        assertThat(featureToggleValue.asText()).isEqualTo("FALSE");
    }

    @Test
    void should_create_boolean_true_feature_toggle_value() {
        // given && when
        var featureToggleValue = BooleanFeatureToggleValue.create(true);

        // then
        assertThat(featureToggleValue).isNotNull();
        assertThat(featureToggleValue.value()).isTrue();
        assertThat(featureToggleValue.type()).isEqualTo(FeatureToggleValueType.BOOLEAN);
        assertThat(featureToggleValue.asText()).isEqualTo("TRUE");
        assertThat(featureToggleValue.typedValue()).isEqualTo(Boolean.TRUE);
    }

    @Test
    void should_create_boolean_false_feature_toggle_value() {
        // given && when
        var featureToggleValue = BooleanFeatureToggleValue.create(false);

        // then
        assertThat(featureToggleValue).isNotNull();
        assertThat(featureToggleValue.value()).isFalse();
        assertThat(featureToggleValue.type()).isEqualTo(FeatureToggleValueType.BOOLEAN);
        assertThat(featureToggleValue.asText()).isEqualTo("FALSE");
        assertThat(featureToggleValue.typedValue()).isEqualTo(Boolean.FALSE);
    }
}