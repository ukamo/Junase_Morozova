package fiori.util;

import org.apache.commons.lang3.RandomStringUtils;

import static eu.ibagroup.junase.web.util.Wait.functionPassed;

public class TextUtil {

    public static String generateAlphanumericString(int size) {
        return functionPassed(() -> RandomStringUtils.randomAlphanumeric(size));
    }
}
