/**
 *
 *     Copyright (C) norad.fr
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *             http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */
package fr.norad.typed.command.line.parser.argument.args;

import java.util.ArrayList;
import java.util.List;
import fr.norad.typed.command.line.parser.argument.CliArgumentDefinitionException;
import fr.norad.typed.command.line.parser.argument.CliArgumentParseException;
import fr.norad.typed.command.line.parser.param.CliParam;

/**
 * @deprecated Not fully Tested
 */
@Deprecated
@SuppressWarnings("deprecation")
public class CliThreeParamArgument<PARAM_ONE_TYPE, PARAM_TWO_TYPE, PARAM_THREE_TYPE> extends
        CliTwoParamArgument<PARAM_ONE_TYPE, PARAM_TWO_TYPE> {

    private static final int NUMBER_OF_PARAMS = 3;

    private List<PARAM_THREE_TYPE> paramThreeDefValues = new ArrayList<PARAM_THREE_TYPE>();
    private List<PARAM_THREE_TYPE> paramThreeValues = paramThreeDefValues;

    private final CliParam<PARAM_THREE_TYPE> paramThreeArgument;

    // ///////////////////////////////////////////////////////////////////////////////////////////////////

    public CliThreeParamArgument(char shortName, CliParam<PARAM_ONE_TYPE> paramOneArgument,
            CliParam<PARAM_TWO_TYPE> paramTwoArgument, CliParam<PARAM_THREE_TYPE> paramThreeArgument) {
        super(shortName, paramOneArgument, paramTwoArgument);
        this.paramThreeArgument = paramThreeArgument;
    }

    // ///////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void reset() {
        super.reset();

        // set default values
        if (paramThreeDefValues != null) {
            paramThreeValues = paramThreeDefValues;
        }
    }

    @Override
    public String toStringArgument() {
        return getParamOneArgument().getName() + " " + getParamTwoArgument().getName() + " "
                + getParamThreeArgument().getName();
    }

    @Override
    public String toStringValues(boolean defaultValues, boolean isDefaultArgument) {
        List<PARAM_ONE_TYPE> param1;
        List<PARAM_TWO_TYPE> param2;
        List<PARAM_THREE_TYPE> param3;
        if (defaultValues) {
            param1 = getParamOneDefValues();
            param2 = getParamTwoDefValues();
            param3 = getParamThreeDefValues();
        } else {
            param1 = getParamOneValues();
            param2 = getParamTwoValues();
            param3 = getParamThreeValues();
        }
        if (param1 != null && !param1.isEmpty()) {
            StringBuilder buff = new StringBuilder();
            for (int i = 0; i < param1.size(); i++) {
                if (i != 0) {
                    buff.append(' ');
                }
                if (!isDefaultArgument) {
                    buff.append(getShortName());
                    buff.append(' ');
                }
                buff.append(param1.get(i));
                buff.append(' ');
                buff.append(param2.get(i));
                buff.append(' ');
                buff.append(param3.get(i));
            }
            return buff.toString();
        }
        return null;
    }

    @Override
    public void checkDefinition() {
        super.checkDefinition();
        if ((getParamTwoDefValues() == null && getParamOneDefValues() != null)
                || (getParamTwoDefValues() != null && getParamOneDefValues() == null)
                || (getParamTwoDefValues() != null && getParamThreeDefValues() == null)
                || (getParamTwoDefValues() == null && getParamThreeDefValues() != null)
                && (getParamTwoDefValues().size() != getParamOneDefValues().size() || getParamThreeDefValues().size() != getParamOneDefValues()
                        .size())) {
            throw new CliArgumentDefinitionException("length of default params values must be equal");
        }
    }

    @Override
    public void parse(List<String> args) throws CliArgumentParseException {
        // get all arguments before set to be able to throw an exception
        // on param parse without modification of this object
        // FIXME catch arrayindexooutofband and throw cliargumentparse
        PARAM_ONE_TYPE param1 = paramOneArgument.parse(args.get(0));
        PARAM_TWO_TYPE param2 = paramTwoArgument.parse(args.get(1));
        PARAM_THREE_TYPE param3 = paramThreeArgument.parse(args.get(2));

        numCall++;
        addParamOneValue(param1);
        addParamTwoValue(param2);
        addParamThreeValue(param3);
    }

    /**
     * @param paramThreeDefValue
     *            the paramThreeDefValue to set
     */
    public void setParamThreeDefValue(PARAM_THREE_TYPE paramThreeDefValue) {
        this.paramThreeDefValues.clear();
        this.paramThreeDefValues.add(paramThreeDefValue);
    }

    /**
     * @return the paramOneValues
     */
    public PARAM_THREE_TYPE getParamThreeValue() {
        if (isMulticall()) {
            throw new CliArgumentDefinitionException("for multicall arguments use getParamThreeValues()");
        }
        if (!paramThreeDefValues.isEmpty()) {
            return paramThreeValues.get(0);
        }
        return null;
    }

    /**
     * @param paramThreeDefValues
     *            the paramTwoDefValues to set
     */
    public void setParamThreeDefValues(List<PARAM_THREE_TYPE> paramThreeDefValues) {
        this.paramThreeDefValues.clear();
        this.paramThreeDefValues.addAll(paramThreeDefValues);
    }

    protected void addParamThreeValue(PARAM_THREE_TYPE value) {
        if (paramThreeValues == paramThreeDefValues) {
            paramThreeValues = new ArrayList<PARAM_THREE_TYPE>();
        }
        paramThreeValues.add(value);
    }

    // ////////////////////////////////////////////////////////////////////////////////////////

    /**
     * @return the paramOneArgument
     */
    public CliParam<PARAM_THREE_TYPE> getParamThreeArgument() {
        return paramThreeArgument;
    }

    /**
     * @return the paramTwoDefValues
     */
    public List<PARAM_THREE_TYPE> getParamThreeDefValues() {
        return paramThreeDefValues;
    }

    /**
     * @return the paramTwoValues
     */
    public List<PARAM_THREE_TYPE> getParamThreeValues() {
        return paramThreeValues;
    }

    /**
     * @return the numberOfArguments
     */
    @Override
    public int getNumberOfParams() {
        return NUMBER_OF_PARAMS;
    }
}
