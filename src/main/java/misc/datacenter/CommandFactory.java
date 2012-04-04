package misc.datacenter;

import java.util.ArrayList;
import java.util.List;

/**
 * User: absharma
 * Date: 3/30/12
 */
public final class CommandFactory {
    private List<CommandType> parse(String s) {
        List<CommandType> commandTypes = new ArrayList<CommandType>();

        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            switch (c) {
                case 'F':
                    commandTypes.add(CommandType.F);
                    break;
                case 'R':
                    commandTypes.add(CommandType.R);
                    break;
                case 'L':
                    commandTypes.add(CommandType.L);
                    break;
                case 'H':
                    i++;
                    char next = array[i];
                    if(next == 'R') {
                        commandTypes.add(CommandType.HR);
                    } else if(next == 'L'){
                        commandTypes.add(CommandType.HL);
                    } else {

                    }
                    break;
                default:

            }
        }
        return commandTypes;
    }

}
