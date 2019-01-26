package in.jord.deltoid.tacnode.parsers;

import in.jord.tacnode.exceptions.InvalidTypeException;

public class RelativeCoordinateParser {
    private static final String RELATIVE_IDENTIFIER = "~";

    public static double parseCoordinate(String given, double origin) throws InvalidTypeException {
        boolean relative = given.startsWith(RELATIVE_IDENTIFIER);
        if (relative) {
            given = given.replaceFirst(RELATIVE_IDENTIFIER, "");
        }
        double parsed = given.isEmpty() ? 0 : Double.parseDouble(given);

        return relative ? parsed + origin : parsed;
    }
}
