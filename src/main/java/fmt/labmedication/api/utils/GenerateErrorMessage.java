package fmt.labmedication.api.utils;

import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GenerateErrorMessage {

    public static String enumError(String prefix, Class<? extends Enum> type) {
        Set<? extends Enum> values = EnumSet.allOf(type);
        return prefix + values.stream().map(v -> v.toString()).collect(Collectors.joining(" | "));
    }

}
