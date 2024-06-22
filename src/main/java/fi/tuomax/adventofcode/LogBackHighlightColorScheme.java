package fi.tuomax.adventofcode;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.color.ANSIConstants;
import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase;

public class LogBackHighlightColorScheme 
extends ForegroundCompositeConverterBase<ILoggingEvent>
{

    @Override
    protected String getForegroundColorCode(ILoggingEvent event) 
    {
        switch (event.getLevel().toInt()) {
            case Level.ERROR_INT :  return ANSIConstants.RED_FG;
            case Level.DEBUG_INT :  return ANSIConstants.BOLD + ANSIConstants.BLACK_FG;
            case Level.INFO_INT  :  return ANSIConstants.BLUE_FG;
            case Level.WARN_INT  :  return ANSIConstants.RED_FG;
            default :               return ANSIConstants.WHITE_FG;
        }
    }
    
}
