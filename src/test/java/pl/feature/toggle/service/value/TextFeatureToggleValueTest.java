package pl.feature.toggle.service.value;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TextFeatureToggleValueTest {

    @Test
    void should_create_text_feature_toggle_value_from_string() {
        // given
        var text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
                " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
                " Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat." +
                " Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur." +
                " Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

        // when
        var actual = TextFeatureToggleValue.create(text);

        // then
        assertThat(actual).isNotNull();
        assertThat(actual.type()).isEqualTo(FeatureToggleValueType.TEXT);
        assertThat(actual.asText()).isEqualTo(text);
        assertThat(actual.value()).isEqualTo(text);
    }

    @Test
    void should_throw_exception_when_value_is_null() {
        // given && when && then
        assertThrows(WrongFeatureToggleValue.class, () -> TextFeatureToggleValue.create(null));
    }

    @Test
    void should_throw_exception_when_value_is_empty() {
        // given && when && then
        assertThrows(WrongFeatureToggleValue.class, () -> TextFeatureToggleValue.create(""));
    }

}